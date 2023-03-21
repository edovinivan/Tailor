/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Plan.PlanArticle;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.example.logic.LModel1;
import org.example.logic.Model;
import org.example.logic.Razmeri;
import org.example.logic.plan.MapArticleColorJoin;
import org.example.logic.plan.VidJoinArticleColor;
import org.example.util.IOModel;
import org.example.util.IORazmeri;
import org.example.util.plannew.IOMapArticleColorJoin;

/**
 *
 * @author ivan
 * Связь для размер артикулов импортированных из 1с
 */
public class JoinRazmeriSize1C {

    public JoinRazmeriSize1C() {
        
        
    }
    
    // размеры с названиями
    private Map<Integer, String> mapRazmeri;
    
    // артикул-размер с кодом размера
    private Map<String, Integer> mapArticleRazmer;
    
    /**
     * Связать размеры
     * @param ls 
     */
    public void joinRazmeri(List<ArticleLoad> ls){
        
        //список артикулов
        List<ArticleRazmerGruppa> lsModel = IOModel.getListModelRazmerGruppa();
        
        // список размеров
        List<Razmeri> lsRazmeri = IORazmeri.getListAllRazmeri();
        
        mapRazmeri =
                lsRazmeri.stream()
                .collect(Collectors.toMap(Razmeri::getRazmeri, Razmeri::getName, (t1, t2)->t1));
        
        mapArticleRazmer = new HashMap<>();
        
        Map<String, Integer> tMap;
        
        //составим список артикул-модель
        for(ArticleRazmerGruppa model: lsModel){
            tMap = lsRazmeri.stream()                    
                    .filter(t->t.getRazmerigruppa().getRazmerigruppa() == model.getRazmergruppa())                    
                    .collect(Collectors.toMap(t->{ return String.valueOf(model.getArticle() + "-" + t.getName());}, Razmeri::getRazmeri,(t3, t4)->t3));
            mapArticleRazmer.putAll(tMap);
        }    
        
        // список ранее связанных артикулов
        IOMapArticleColorJoin iom = new IOMapArticleColorJoin();
        Map<String, Integer> joinSize = iom.getAllListMapJoin().stream()
                  .filter( (t) -> { 
                      return t.getVid()== VidJoinArticleColor.SIZE; })
                  .collect(Collectors.toMap(MapArticleColorJoin::getV_ic, MapArticleColorJoin::getV_tailor, (t1,t2)->t1));
        
        //сопоставим размеры
        ls.stream()
                .filter(t->{                    
                    if(t.getSizes_1c()==null || t.getSizes_1c().isEmpty()) return false;
                    return t.getModel_id() != 0;
                })
                .forEach(t->{
                    String sb = t.getModel_article() + "-" + t.getSizes_1c();
                    String sbb = t.getModel_id() + "-" + t.getSizes_1c();
                    // сопоставим ранее связанные размеры
                    // если сопоставление есть в базе
                    if (joinSize.containsKey(sbb)) {
                        t.setSizes_tid(joinSize.get(sbb));
                        t.setSizes_t(mapRazmeri.get(t.getSizes_tid()));
                    } else {
                    //проверим есть ли соотношение артикул размер в базе
                        if (mapArticleRazmer.containsKey(sb)) {
                            t.setSizes_tid(mapArticleRazmer.get(sb));
                            t.setSizes_t(mapRazmeri.get(t.getSizes_tid()));
                        }
                    }
                });
        
    }
    
    
}
