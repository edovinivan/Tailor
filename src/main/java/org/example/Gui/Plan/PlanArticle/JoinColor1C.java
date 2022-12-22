/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Plan.PlanArticle;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.example.logic.Color;
import org.example.logic.plan.MapArticleColorJoin;
import org.example.logic.plan.VidJoinArticleColor;
import org.example.util.IOColor;
import org.example.util.plannew.IOMapArticleColorJoin;

/**
 * Привязка цветов импортированным данным
 * @author ivan
 */
public class JoinColor1C {
    
    // список цветов название код
    private Map<String, Integer> lcolor;
    
    // список цветов код - название
    private Map<Integer, String> lcolor1;

    public JoinColor1C() {
    }
    
    /**
     * Начальная связка цветов
     * @param ls 
     */
    public void joinColor(List<ArticleLoad> ls){
         List<Color> lcolor_base = IOColor.getListColor(-1, 1);
            /**
             * Создадим список цветов для поиска
             */
            lcolor = lcolor_base
                    .stream()
                    .collect(Collectors.toMap(Color::getName, 
                                              Color::getColor,
                                              (c1, c2)->c1));
            
            /**
             * Создадим список цветов для поиска названия
             */
            lcolor1 = lcolor_base
                            .stream()
                            .collect(Collectors.toMap(Color::getColor,
                                    Color::getName,
                                    (c1, c2) -> c1));
            
            
            /**
             * Создадим список артикулов которые были ранее связаны
             */
            IOMapArticleColorJoin iom = new IOMapArticleColorJoin();            
            
            Map<String, Integer> joinColor = iom.getAllListMapJoin().stream()
                    .filter( (t) -> { 
                        return t.getVid()== VidJoinArticleColor.COLOR; })
                    .collect(Collectors.toMap(MapArticleColorJoin::getV_ic, MapArticleColorJoin::getV_tailor, (t1,t2)->t1));
            
            
           ls.forEach((t)->{                   
                        // найдем связанные
                        if(joinColor.get(t.getColor())!=null){
                            if (lcolor1.get(joinColor.get(t.getColor())) != null) {
                                t.setColor_id(joinColor.get(t.getColor()));
                                t.setColor_name(lcolor1.get(joinColor.get(t.getColor())));                                
                                t.setCheck(1);                                
                            }
                        }
                        if (t.getCheck() != 1) {
                            if (lcolor.get(t.getColor()) != null) {
                                 t.setColor_id(lcolor.get(t.getColor()));
                                 t.setColor_name(t.getColor());                        
                                 t.setCheck(1);                                
                            }
                        }                
                    });  
            
    }
            
}
