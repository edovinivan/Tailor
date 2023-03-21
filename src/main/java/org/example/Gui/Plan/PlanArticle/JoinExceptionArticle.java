/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Plan.PlanArticle;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.example.logic.plan.MapExceptionArticle;
import org.example.util.plannew.IOMapExceptionArticle;

/**
 *
 * @author ivan
 * Загрузка прязок исключений
 */
public class JoinExceptionArticle {

    public JoinExceptionArticle() {
        iomapExceptionArticle = new IOMapExceptionArticle();
    }
    
    // список строк исключений
    private Map<String, Integer> mapException;
    
    // загруженные строки
    private List<MapExceptionArticle> listMapException;
    
    private IOMapExceptionArticle iomapExceptionArticle;
    
    public void joinMapException(List<ArticleLoad> ls){
        listMapException = iomapExceptionArticle.getListObject();
        
        mapException =  listMapException.stream()
                .collect(Collectors.toMap(MapExceptionArticle::getMapjoinstring1c , MapExceptionArticle::getMapexceptionarticle, (t1,t2)->t1));
        
        ls.forEach(t->{
            String ss = t.getArticle() + "<!>" + t.getColor() + "<!>" + t.getSizes_1c();
            if(mapException.containsKey(ss)){
                int id = mapException.get(ss);
                listMapException
                        .stream()
                        .filter(r->{
                            return r.getMapexceptionarticle() == id;
                        })
                        .forEach(e->{ 
                            t.setColor_id( e.getColor().getColor());
                            t.setColor_name(e.getColor().getName());
                            t.setSizes_tid(e.getRazmeri().getRazmeri());
                            t.setSizes_t( e.getRazmeri().getName());
                            t.setModel_id(e.getModel().getModel());
                            t.setModel_article(e.getModel().getArticle());
                                    });
            }
        });
        
    }
    
    
}
