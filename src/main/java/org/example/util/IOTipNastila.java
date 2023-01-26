/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.util;

import java.util.ArrayList;
import java.util.List;
import org.example.logic.TipNastila;
import org.example.logic.TipNastilania;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Transaction;

/**
 *
 * @author ivan
 */
public class IOTipNastila {
     /**
     * Сохранить объект
     * @param p - объект
     * @return - объект
     */
    public static TipNastila setTipNastila(TipNastila p)
    {
        if(p.getTipnastila()== 0)
            p.setTipnastila(null);
        
        Session sess = HibernateUtil.getSessionFactory().openSession();
        try 
        {
            Transaction transaction = sess.beginTransaction();
            sess.saveOrUpdate(p);
            transaction.commit();
            
        }catch(HibernateException e)
        {
            System.out.println("ERROR SAVE" + e);            
        }
        return p;
    }
    
    
    /**
     * Получить список объектов
     * @param p - id объекта
     * @return 
     */
    public static List<TipNastila> getListTipNastila(int p)
    {
        List<TipNastila> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            if(p == -1)
                ls = sess.createCriteria(TipNastila.class).add(Restrictions.eq("del", 0)).addOrder(Order.asc("name")).list();            
            else
                ls = sess.createCriteria(TipNastila.class).add(Restrictions.eq("tipnastila", p)).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Удалить объект
     * @param p - ид объекта
     * @return - результат
     */
    public static boolean delTipNastila(int p)
    {
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            Transaction transaction = sess.beginTransaction();
            String s = "update TipNastila set del = 1 where TipNastila = " + p;
            sess.createSQLQuery(s).executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
            return false;
        }        
        return true;
        
    }
    
    /**
     * Получить список объектов
     * @param p - id объекта
     * @return 
     */
    public static List<TipNastilania> getListTipNastilania(int p)
    {
        List<TipNastilania> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            if(p == -1)
                ls = sess.createCriteria(TipNastilania.class).add(Restrictions.eq("del", 0)).addOrder(Order.asc("name")).list();            
            else
                ls = sess.createCriteria(TipNastilania.class).add(Restrictions.eq("tipnastilania", p)).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
}
