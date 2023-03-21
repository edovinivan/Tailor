/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.util.Uchet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.example.logic.Operator;
import org.example.logic.Uchet.UOperDoc;
import org.example.logic.Uchet.UOperJou;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.example.util.HibernateUtil;
import org.hibernate.Transaction;

/**
 *
 * @author ivan
 */
public class IOUOperDoc {
    /**
     * Сохранить заголовок документа
     * @param p - объект
     * @return - объект
     */
    public static UOperDoc setUOperDoc(UOperDoc p)
    {
        if(p.getUoperdoc()== 0)
            p.setUoperdoc(null);
        
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
     * @param d1
     * @param d2 
     * @param oper 
     * @return 
     */
    public static List<UOperDoc> getListUOperDoc(Date d1, Date d2, int oper)
    {
        List<UOperDoc> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();            
            if(oper == 0)
                ls = sess.createCriteria(UOperDoc.class).add(Restrictions.between("dates", d1, d2)).list();                        
            else
                ls = sess.createCriteria(UOperDoc.class).add(Restrictions.between("dates", d1, d2)).add(Restrictions.eq("operator", new Operator(oper))).list();                        
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Получить объектов
     * @param p
     * @return 
     */
    public static UOperDoc getUOperDoc(int p)
    {
        List<UOperDoc> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();            
            ls = sess.createCriteria(UOperDoc.class).add(Restrictions.eq("uoperdoc", p)).list();                        
            if(ls.isEmpty())
                ls.add(new UOperDoc(0));
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
            ls.add(new UOperDoc(0));
        }        
        return ls.get(0);        
    }
    
    /**
     * Удалить объект
     * @param p - ид объекта
     * @return - результат
     */
    public static boolean delUOperDoc(int p)
    { 
        UOperDoc p1 = getUOperDoc(p);      
        if(p1.getStatus()!=0)
            return false;
                
        
        for(UOperJou j: getListUOperJou(p))
            delUOperJou(j.getUoperjou());
        
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();             
            Transaction transaction = sess.beginTransaction();
            sess.delete(p1);
            transaction.commit();            
            
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
            return false;
        }        
        return true;
        
    }
    
    
    
    /**
     * Сохранить заголовок документа
     * @param p - объект
     * @return - объект
     */
    public static UOperJou setUOperJou(UOperJou p)
    {
        if(p.getUoperjou()== 0)
            p.setUoperjou(null);
        
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
     * @param d
     * @return 
     */
    public static List<UOperJou> getListUOperJou(int d)
    {
        List<UOperJou> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();            
            ls = sess.createCriteria(UOperJou.class).add(Restrictions.eq("uoperdoc", new UOperDoc(d))).list();                        
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Получить объектов
     * @param p
     * @return 
     */
    public static UOperJou getUOperJou(int p)
    {
        List<UOperJou> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();            
            ls = sess.createCriteria(UOperJou.class).add(Restrictions.eq("uoperjou", p)).list();                        
            if(ls.isEmpty())
                ls.add(new UOperJou(0));
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
            ls.add(new UOperJou(0));
        }        
        return ls.get(0);        
    }
    
    /**
     * Удалить объект
     * @param p - ид объекта
     * @return - результат
     */
    public static boolean delUOperJou(int p)
    { 
        UOperJou p1 = getUOperJou(p);      
                
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();             
            Transaction transaction = sess.beginTransaction();
            sess.delete(p1);
            transaction.commit();            
            
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
            return false;
        }        
        return true;
        
    }
    
    
}
