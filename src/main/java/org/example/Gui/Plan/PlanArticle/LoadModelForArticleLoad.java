/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Plan.PlanArticle;

import org.example.logic.Model;
import org.example.util.IOModel;

/**
 * Поиск соотношений артикулов загрузки и базы
 * @author ivan
 */
public class LoadModelForArticleLoad {

    public LoadModelForArticleLoad() {
    }
    
    /**
     * Поиск в базе
     * @param al
     * @return 
     */
    public ArticleLoad findModel(ArticleLoad al){
        Model model = IOModel.getModelForArticle(al.getArticle());
        if(model.getModel()!=0){
            al.setModel_id(model.getModel());
            al.setModel_article(model.getArticle());
        }        
        return al;
    }
    
}
