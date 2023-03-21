/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Plan.PlanArticle;

/**
 *
 * @author ivan
 */
public class ArticleRazmerGruppa {
    
    private String article;
    private int razmergruppa;

    public ArticleRazmerGruppa(String article, int razmergruppa) {
        this.article = article;
        this.razmergruppa = razmergruppa;
    }

    public ArticleRazmerGruppa() {
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public int getRazmergruppa() {
        return razmergruppa;
    }

    public void setRazmergruppa(int razmergruppa) {
        this.razmergruppa = razmergruppa;
    }
    
    
    
}
