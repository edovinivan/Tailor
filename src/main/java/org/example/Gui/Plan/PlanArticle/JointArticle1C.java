/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Plan.PlanArticle;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.example.logic.LModel1;
import org.example.logic.plan.MapArticleColorJoin;
import org.example.logic.plan.VidJoinArticleColor;
import org.example.util.IOModel;
import org.example.util.plannew.IOMapArticleColorJoin;

/**
 * Связывание артикулов 1с и базы
 * @author ivan
 */
public class JointArticle1C {

    
    private Map<String, Integer> lmodel;
    
    public JointArticle1C() {
    }
    
    /**
     * Стартовое связывание артикулов
     * @param ls - список в котором нужно провести связь
     */
    public void joinStartArticle(List<ArticleLoad> ls){
        
         List<LModel1> lmodel1_base = IOModel.getListLModel1(false);
            /**
             * Создадим список артикулов для поиска
             */
            lmodel = lmodel1_base
                            .stream()
                            .filter((t) -> {
                                if(t.getArticleForNoSlash()==null) return false;                                
                                return !t.getArticleForNoSlash().isEmpty();
                            })                            
                            .collect(Collectors.toMap(LModel1::getArticleForNoSlash, 
                                                      LModel1::getModel,
                                                      (lm1, lm2)->lm1));
            /**
             * Создадим список артикулов для связанных ранее
             */
            Map<Integer, String> lmodel_1 
                    = lmodel1_base
                            .stream()
                            .filter((t) -> {
                                if(t.getArticleForNoSlash()==null) return false;                                
                                return !t.getArticleForNoSlash().isEmpty();
                            })                            
                            .collect(Collectors.toMap(LModel1::getModel, 
                                                      LModel1::getArticle,                                                       
                                                      (lm1, lm2)->lm1));
            
            // список ранее связанных артикулов
            IOMapArticleColorJoin iom = new IOMapArticleColorJoin();
            Map<String, Integer> joinArticle = iom.getAllListMapJoin().stream()
                    .filter( (t) -> { 
                        return t.getVid()== VidJoinArticleColor.ARTICLE; })
                    .collect(Collectors.toMap(MapArticleColorJoin::getV_ic, MapArticleColorJoin::getV_tailor, (t1,t2)->t1));
            
            ls.forEach((t)->{                 
                                               
                        //Проверим ранее связанные артикула
                        if(joinArticle.get(t.getArticle())!=null){
                            // если есть то найдем артикул
                            if(lmodel_1.get(joinArticle.get(t.getArticle()))!=null){
                                t.setModel_id(joinArticle.get(t.getArticle()));
                                t.setModel_article(lmodel_1.get(joinArticle.get(t.getArticle())));                            
                                t.setStatus(1);
                            }                            
                        }
                        //если нет в связанных ранее то поищем по названию
                        if (t.getStatus() != 1) {
                             if (lmodel.get(t.getArticle()) != null) {
                                  t.setModel_id(lmodel.get(t.getArticle()));
                                  t.setModel_article(t.getArticle());
                                  t.setStatus(1);
                             }
                        }
            }); 
    }
    
    
    /**
     * Проверить и связать только что связанные артикула
     */
    
    
}
