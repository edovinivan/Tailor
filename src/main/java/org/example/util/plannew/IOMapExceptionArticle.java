/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.util.plannew;

import java.util.ArrayList;
import java.util.List;
import org.example.logic.plan.MapExceptionArticle;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.example.util.HibernateUtil;

/**
 *
 * @author ivan
 */
public class IOMapExceptionArticle {
    
    private static final Logger log = LogManager.getLogger(IOMapExceptionArticle.class);

    public MapExceptionArticle setObject(MapExceptionArticle obj) {
        if(obj.getMapexceptionarticle()== 0)
            obj.setMapexceptionarticle(null);
        
        Session sess = HibernateUtil.getSessionFactory().openSession();
        try 
        {
            sess.beginTransaction();
            sess.saveOrUpdate(obj);
            sess.beginTransaction().commit();
            
        }catch(HibernateException e)
        {
            log.error("Error " + e);
        }
        return obj;
    }

    
    public MapExceptionArticle getObject(Integer key) {
        List<MapExceptionArticle> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();            
            ls = sess.createCriteria(MapExceptionArticle.class)
                    .add(Restrictions.eq("mapexceptionarticle", key))                    
                    .list();                        
            if(ls.isEmpty())
                ls.add(new MapExceptionArticle(0));
        }catch(HibernateException e)
        {
            log.error("Error " + e);
            ls.add(new MapExceptionArticle(0));
        }        
        return ls.get(0);    
    }

    
    public List<MapExceptionArticle> getListObject() {
        List<MapExceptionArticle> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();            
            ls = sess.createCriteria(MapExceptionArticle.class)
                    .list();                        
        }catch(HibernateException e)
        {
            log.error("Error " + e);
        }        
        return ls;   
    }
    
    public boolean delObject(Integer key) {
        MapExceptionArticle mp = getObject(key);
        if(mp.getMapexceptionarticle() == 0){
            log.error("Error del" );
            return false;
        }            
        
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();            
            sess.beginTransaction();
            sess.delete(mp);
            sess.beginTransaction().commit();
        }catch(HibernateException e)
        {
            log.error("Error " + e);
            return false;
        }             
        return true;        
    }
    
    /**
     * Сохранить объект
     * @param mape
     * @return 
     */
    public MapExceptionArticle save(MapExceptionArticle mape){
        
        List<MapExceptionArticle> ls;
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();            
            ls = sess.createCriteria(MapExceptionArticle.class)
                    .add(Restrictions.eq("mapjoinstring1c", mape.getMapjoinstring1c()))                    
                    .list();                        
            if(ls.isEmpty()){
                setObject(mape);
            } else {
                delObject(ls.get(0).getMapexceptionarticle());
            }                
        }catch(HibernateException e)
        {
            log.error("Error " + e);
        }   
        return mape;
    }
    
}
