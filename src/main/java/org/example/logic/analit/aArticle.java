/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.logic.analit;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.example.logic.Model;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "A_ARTICLE")
public class aArticle implements Serializable {
    @Id
    @Column(name = "A_ARTICLE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_A_ARTICLE_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_A_ARTICLE_ID", sequenceName = "GEN_A_ARTICLE_ID")
    Integer a_article;
    
    @Column(name = "NAME")
    String name;
    
    @Column(name = "ARTICLE")
    String article;
    
    @ManyToOne
    @JoinColumn(name = "ID_MODEL")
    Model model;

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public aArticle(Integer a) {
        a_article = a;
    }

    public aArticle() {
    }

    public Integer getA_article() {
        return a_article;
    }

    public void setA_article(Integer a_article) {
        this.a_article = a_article;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getArticle() {
        return article;
    }

    
    
    
    
    
    
}
