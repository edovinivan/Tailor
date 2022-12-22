/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.util.plannew;

import org.example.Gui.Plan.PlanArticle.MapProjectProduct;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.example.util.HibernateUtil;

/**
 *
 * @author ivan
 */
public class IOMapPlanProduct {
    
    private static final Logger log = LogManager.getLogger(IOMapPlanProduct.class);
    
    /**
     * Получить полотна которые нужны для выполнения данной задачи
     * @param plan
     * @return 
     */
    public List<MapProjectProduct> getListMapProjectProductForPlan(int plan) {
        
        List<MapProjectProduct> listdata= new ArrayList<>();
        
        String sql = "select product || '<!>' || color  || '<!>' ||  sum(qty)  || '<!>' ||  list(article) \n"
                + "from (\n"
                + "\n"
                + "select\n"
                + " pr.name as product,\n"
                + " c.name as color,\n"
                + " mp.qty_start * mj.qty as qty,\n"
                + " m.article\n"
                + "from mapprojectjournal mj\n"
                + "inner join model m on m.model = mj.model\n"
                + "inner join modelproduct mp on mp.model = m.model and mp.vid = 1 and mp.tipproduct = 1\n"
                + "inner join product pr on pr.product = mp.product\n"
                + "inner join color c on c.color = mj.color\n"
                + "where  mj.mapproject = " + plan + "\n"
                + "union\n"
                + "select\n"
                + " pr.name as product,\n"
                + " c.name as color,\n"
                + " mp.qty_start * mj.qty as qty,\n"
                + " m.article\n"
                + "from mapprojectjournal mj\n"
                + "inner join model m on m.model = mj.model\n"
                + "inner join modelproduct mp on mp.model = m.model and mp.vid = 1 and mp.tipproduct != 1\n"
                + "inner join product pr on pr.product = mp.product\n"
                + "inner join color c on c.color = mp.color\n"
                + "where  mj.mapproject = " + plan + ")\n"
                + "group by product, color\n";
                
        
        Session sess = HibernateUtil.getSessionFactory().openSession();
        try 
        {
            sess.beginTransaction();
            List<String> ls = sess.createSQLQuery(sql).list();
            sess.beginTransaction().commit();
            
            AtomicInteger id = new AtomicInteger(1);
            
            listdata =  ls.stream()
                    .map(t->{
                        String ss[] = t.split("<!>");                        
                        return new MapProjectProduct(id.getAndIncrement(), ss[0] , ss[1], new BigDecimal(ss[2]), ss[3]);
                    })
                    .collect(Collectors.toList()); 
            
        }catch(HibernateException e)
        {
            log.error("Error " + e);
        }      
        
        return listdata;
    }
}
