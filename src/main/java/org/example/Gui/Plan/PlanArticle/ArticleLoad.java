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
public class ArticleLoad implements Comparable<ArticleLoad>{
    int id;
    int check;
    String tip;
    String article;
    String color;
    int sale;
    int balance;
    
    String sizes_1c;
    String sizes_t;
    int sizes_tid;
    
    int model_id;
    String model_article;
    
    int color_id;
    String color_name;
    
    int in_work;

    int status;
    
    int summa_sale;
    
    public ArticleLoad() {
    }

    public ArticleLoad(int id, int check, String tip, String article, String color, String sizes, int sale, int balance, int summa_sale) {
        this.id = id;
        this.check = check;
        this.tip = tip;
        this.article = article;
        this.color = color;
        this.sale = sale;
        this.balance = balance;
        this.model_article = "";
        this.model_id = 0;
        this.color_id = 0;
        this.color_name = "";
        this.in_work = 0;
        this.status = 0;
        this.sizes_1c = sizes;
        this.sizes_t = "";
        this.sizes_tid = 0;
                
        
        this.summa_sale = summa_sale;
    }

    @Override
    public String toString() {
        return "ArticleLoad{" + "id=" + id + ", check=" + check + ", tip=" + tip + ", article=" + article + ", color=" + color + ", sale=" + sale + ", balance=" + balance + ", sizes_1c=" + sizes_1c + ", sizes_t=" + sizes_t + ", sizes_tid=" + sizes_tid + ", model_id=" + model_id + ", model_article=" + model_article + ", color_id=" + color_id + ", color_name=" + color_name + ", in_work=" + in_work + ", status=" + status + ", summa_sale=" + summa_sale + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.sizes_tid;
        hash = 29 * hash + this.model_id;
        hash = 29 * hash + this.color_id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ArticleLoad other = (ArticleLoad) obj;
        if (this.sizes_tid != other.sizes_tid) {
            return false;
        }
        if (this.model_id != other.model_id) {
            return false;
        }
        if (this.color_id != other.color_id) {
            return false;
        }
        return true;
    }
    
    
    
    

    public ArticleLoad(String article, String color, int summa_sale) {
        this.article = article;
        this.color = color;
        this.summa_sale = summa_sale;
    }

    
    
    
    public int getSumma_sale() {
        return summa_sale;
    }

    public void setSumma_sale(int summa_sale) {
        this.summa_sale = summa_sale;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCheck() {
        return check;
    }

    public void setCheck(int check) {
        this.check = check;
    }

    public String getTip() {
        return tip;
    }

    public String getSizes_1c() {
        return sizes_1c;
    }

    public void setSizes_1c(String sizes_1c) {
        this.sizes_1c = sizes_1c;
    }

    public String getSizes_t() {
        return sizes_t;
    }

    public void setSizes_t(String sizes_t) {
        this.sizes_t = sizes_t;
    }

    public int getSizes_tid() {
        return sizes_tid;
    }

    public void setSizes_tid(int sizes_tid) {
        this.sizes_tid = sizes_tid;
    }

    
    

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public int compareTo(ArticleLoad o) {
        //return o.getArticle().compareTo( getArticle());
        return getArticle().compareTo(o.getArticle());
    }

    public int getModel_id() {
        return model_id;
    }

    public void setModel_id(int model_id) {
        this.model_id = model_id;
    }

    public String getModel_article() {
        return model_article;
    }

    public void setModel_article(String model_article) {
        this.model_article = model_article;
    }

    public int getColor_id() {
        return color_id;
    }

    public void setColor_id(int color_id) {
        this.color_id = color_id;
    }

    public String getColor_name() {
        return color_name;
    }

    public void setColor_name(String color_name) {
        this.color_name = color_name;
    }

    public int getIn_work() {
        return in_work;
    }

    public void setIn_work(int in_work) {
        this.in_work = in_work;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
    
}
