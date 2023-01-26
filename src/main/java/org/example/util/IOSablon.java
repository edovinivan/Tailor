/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.util;

import java.util.ArrayList;
import java.util.List;
import org.example.logic.Sablon;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Transaction;

/**
 *
 * @author ivan
 */
public class IOSablon {
     /**
     * Сохранить объект
     * @param p - объект
     * @return - объект
     */
    public static Sablon setSablon(Sablon p)
    {
        if(p.getSablon()== 0)
            p.setSablon(null);
        
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
    public static List<Sablon> getListSablon(int p)
    {
        List<Sablon> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            if(p == -1)
                ls = sess.createCriteria(Sablon.class).add(Restrictions.eq("del", 0)).addOrder(Order.asc("name")).list();            
            else
                ls = sess.createCriteria(Sablon.class).add(Restrictions.eq("sablon", p)).list();            
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
    public static boolean delSablon(int p)
    {
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            Transaction transaction = sess.beginTransaction();
            String s = "update Sablon set del = 1 where Sablon = " + p;
            sess.createSQLQuery(s).executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
            return false;
        }        
        return true;
        
    }
    
}
