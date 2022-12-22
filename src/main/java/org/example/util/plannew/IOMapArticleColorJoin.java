/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.util.plannew;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.example.logic.plan.MapArticleColorJoin;
import org.example.logic.plan.VidJoinArticleColor;
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
public class IOMapArticleColorJoin implements ioObject<MapArticleColorJoin, Integer>{
    
    private static final Logger log = LogManager.getLogger(IOMapArticleColorJoin.class);

    @Override
    public MapArticleColorJoin setObject(MapArticleColorJoin obj) {
        
        if(obj.getMaparticlecolorjoin() == 0)
            obj.setMaparticlecolorjoin(null);
        try{            
            Session sess = HibernateUtil.getSessionFactory().openSession();
            sess.beginTransaction();
            sess.saveOrUpdate(obj);
            sess.beginTransaction().commit();
        }catch(HibernateException ex){
            log.error(ex);
        }
        return obj;
    }

    @Override
    public MapArticleColorJoin getObject(Integer key) {
        List<MapArticleColorJoin> ls = new ArrayList<>();
        try{
            Session  sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(MapArticleColorJoin.class).add(Restrictions.eq("maparticlecolorjoin", key)).list();
            if(ls.isEmpty())
                ls.add(new MapArticleColorJoin(0));
        }catch(HibernateException he){
            log.error(he);
            ls.add(new MapArticleColorJoin(0));
        }
        return ls.get(0);
    }

    @Override
    public List<MapArticleColorJoin> getListObject(Date d1, Date d2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delObject(Integer key) {
        MapArticleColorJoin ma = getObject(key);
        if(ma.getMaparticlecolorjoin()==0) return false;
        try{
            Session sess = HibernateUtil.getSessionFactory().openSession();
            sess.beginTransaction();
            sess.delete(ma);
            sess.beginTransaction().commit();           
        }catch(HibernateException he){
            log.error(he);
        }
        return true;
    }
    
    /**
     * Получить список всех связей
     * @return 
     */
    public List<MapArticleColorJoin> getAllListMapJoin(){
        List<MapArticleColorJoin> ls = new ArrayList<>();
        try{
            Session  sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(MapArticleColorJoin.class).list();
        }catch(HibernateException he){
            log.error(he);
        }
        return ls;
    }
    
    /**
     * Получить объект для связки
     * @param article1C - артикул 1С
     * @param vd - вич что сохраняем
     * @return 
     */
    public MapArticleColorJoin getMapArticleColorJoinForArticle1C(String article1C, VidJoinArticleColor vd){
        List<MapArticleColorJoin> ls = new ArrayList<>();
        try{
            Session  sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(MapArticleColorJoin.class).add(Restrictions.eq("v_ic", article1C)).add(Restrictions.eq("vid", vd)).list();
            if(ls.isEmpty())
                ls.add(new MapArticleColorJoin(0));
        }catch(HibernateException he){
            log.error(he);
            ls.add(new MapArticleColorJoin(0));
        }
        return ls.get(0);
    }
   
    /**
     * Сохранить значение
     * @param m
     * @param vd - вид что сохраняем
     * @return 
     */
    public MapArticleColorJoin saveMapArticleColorJoin(MapArticleColorJoin m){
        m.setMaparticlecolorjoin(getMapArticleColorJoinForArticle1C(m.getV_ic(), m.getVid()).getMaparticlecolorjoin());
        return setObject(m);
    }
    
}
