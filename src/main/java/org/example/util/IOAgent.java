/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.util;

import java.util.ArrayList;
import java.util.List;
import org.example.logic.Agent;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ivan
 */
public class IOAgent {
    /**
     * Сохранить агента
     * @param p - агент
     * @return - агент
     */
    public static Agent setAgent(Agent p)
    {
        if(p.getAgent()== 0)
            p.setAgent(null);
        
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
     * Получить список агентов
     * @param p - id агента
     * @param vid - вид 
     * @return 
     */
    public static List<Agent> getListAgent(int p, int vid)
    {
        List<Agent> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            if(p == -1)
                ls = sess.createCriteria(Agent.class).add(Restrictions.eq("del", 0)).add(Restrictions.eq("vid", vid)).addOrder(Order.asc("name")).list();            
            else
                ls = sess.createCriteria(Agent.class).add(Restrictions.eq("agent", p)).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Удалить агента
     * @param p - ид агента
     * @return - результат
     */
    public static boolean delAgent(int p)
    {
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            Transaction transaction = sess.beginTransaction();
            String s = "update agent set del = 1 where agent = " + p;
            sess.createSQLQuery(s).executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
            return false;
        }        
        return true;
        
    }
    
}
