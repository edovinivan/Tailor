/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.util;

import java.util.ArrayList;
import java.util.List;
import org.example.logic.Rabotnik;
import org.example.logic.RabotnikGruppa;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Transaction;

/**
 *
 * @author ivan
 */
public class IORabotnik {
    /**
     * Сохранить объект
     * @param p - объект
     * @return - объект
     */
    public static Rabotnik setRabotnik(Rabotnik p)
    {
        if(p.getRabotnik()== 0)
            p.setRabotnik(null);
        
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
    public static List<Rabotnik> getListRabotnik(int p)
    {
        List<Rabotnik> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            if(p == -1)
                ls = sess.createCriteria(Rabotnik.class).add(Restrictions.eq("del", 0)).addOrder(Order.asc("rabotnikgruppa")).addOrder(Order.asc("name")).list();            
            else
                ls = sess.createCriteria(Rabotnik.class).add(Restrictions.eq("rabotnik", p)).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Получить список объектов
     * @param rg - группа работников
     * @return 
     */
    public static List<Rabotnik> getListRabotnikIzGruppa(int rg)
    {
        //System.out.println(">>>>>>>>> " + rg);
        List<Rabotnik> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            if(rg!=-1)
            {
                if(rg == 0)
                {
                    Criteria c = sess.createCriteria(Rabotnik.class).add(Restrictions.eq("del", 0));
                    c.createAlias("rabotnikgruppa", "rg").add(Restrictions.eq("rg.gruppa", 1));
                    ls = c.addOrder(Order.asc("rabotnikgruppa")).addOrder(Order.asc("name")).list();            
                }
                else
                    ls = sess.createCriteria(Rabotnik.class).add(Restrictions.eq("del", 0)).add(Restrictions.eq("rabotnikgruppa", new RabotnikGruppa(rg))).addOrder(Order.asc("rabotnikgruppa")).addOrder(Order.asc("name")).list();            
            }
            else
                ls = sess.createCriteria(Rabotnik.class).add(Restrictions.eq("del", 0)).addOrder(Order.asc("rabotnikgruppa")).addOrder(Order.asc("name")).list();            
            
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
    public static boolean delRabotnik(int p)
    {
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            Transaction transaction = sess.beginTransaction();
            String s = "update Rabotnik set del = 1 where Rabotnik = " + p;
            sess.createSQLQuery(s).executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
            return false;
        }        
        return true;
        
    }
    
    /**
     * Сохранить объект
     * @param p - объект
     * @return - объект
     */
    public static RabotnikGruppa setRabotnikGruppa(RabotnikGruppa p)
    {
        if(p.getRabotnikgruppa()== 0)
            p.setRabotnikgruppa(null);
        
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
    public static List<RabotnikGruppa> getListRabotnikGruppa(int p)
    {
        List<RabotnikGruppa> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            if(p == -1)
                ls = sess.createCriteria(RabotnikGruppa.class).add(Restrictions.eq("del", 0)).addOrder(Order.asc("name")).list();            
            else
                ls = sess.createCriteria(RabotnikGruppa.class).add(Restrictions.eq("rabotnikgruppa", p)).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Получить список объектов
     * @return 
     */
    public static List<RabotnikGruppa> getListRabotnikGruppaChex()
    {
        List<RabotnikGruppa> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(RabotnikGruppa.class).add(Restrictions.eq("del", 0)).add(Restrictions.eq("gruppa", 1)).addOrder(Order.asc("name")).list();            
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
    public static boolean delRabotnikGruppa(int p)
    {
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            Transaction transaction = sess.beginTransaction();
            String s = "update RabotnikGruppa set del = 1 where RabotnikGruppa = " + p;
            sess.createSQLQuery(s).executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
            return false;
        }        
        return true;
        
    }
}
