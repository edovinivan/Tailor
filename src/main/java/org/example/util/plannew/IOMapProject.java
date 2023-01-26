/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.util.plannew;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.example.logic.plan.MapProject;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.example.util.HibernateUtil;
import org.hibernate.Transaction;

/**
 *
 * @author ivan
 */
public class IOMapProject implements ioObject<MapProject, Integer>{
    
    private static final Logger log = LogManager.getLogger(IOMapProject.class);

    @Override
    public MapProject setObject(MapProject obj) {
        if(obj.getMapproject()== 0)
            obj.setMapproject(null);
        
        Session sess = HibernateUtil.getSessionFactory().openSession();
        try 
        {
            Transaction transaction = sess.beginTransaction();
            sess.saveOrUpdate(obj);
            transaction.commit();
            
        }catch(HibernateException e)
        {
            log.error("Error " + e);
        }
        return obj;
    }

    @Override
    public MapProject getObject(Integer key) {
        List<MapProject> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();            
            ls = sess.createCriteria(MapProject.class)
                    .add(Restrictions.eq("mapproject", key))                    
                    .list();                        
            if(ls.isEmpty())
                ls.add(new MapProject(0));
        }catch(HibernateException e)
        {
            log.error("Error " + e);
            ls.add(new MapProject(0));
        }        
        return ls.get(0);    
    }

    @Override
    public List<MapProject> getListObject(Date d1, Date d2) {
        List<MapProject> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();            
            ls = sess.createCriteria(MapProject.class)
                    .add(Restrictions.between("start_date", d1, d2))
                    .addOrder(Order.desc("start_date"))
                    .add(Restrictions.between("status", 0, 3))
                    .list();                        
        }catch(HibernateException e)
        {
            log.error("Error " + e);
        }        
        return ls;   
    }

    @Override
    public boolean delObject(Integer key) {
        MapProject mp = getObject(key);
        if(mp.getMapproject()==0){
            log.error("Error del" );
            return false;
        }            
        mp.setStatus(-1);
        setObject(mp);
        return true;        
    }
    
}
