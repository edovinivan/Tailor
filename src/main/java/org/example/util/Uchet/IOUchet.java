/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.util.Uchet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.example.logic.Uchet.UDocument;
import org.example.logic.Uchet.UOperation;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.example.util.HibernateUtil;

/**
 *
 * @author ivan
 */
public class IOUchet {
    /**
     * Сохранить объект
     * @param p - объект
     * @return - объект
     */
    public static UOperation setUOperation(UOperation p)
    {
        if(p.getUoperation()== 0)
            p.setUoperation(null);
        
        Session sess = HibernateUtil.getSessionFactory().openSession();
        try 
        {
            sess.beginTransaction();
            sess.saveOrUpdate(p);
            sess.beginTransaction().commit();
            
        }catch(HibernateException e)
        {
            System.out.println("ERROR SAVE" + e);            
        }
        return p;
    }
    
    
    /**
     * Получить список объектов
     * @return 
     */
    public static List<UOperation> getListUOperation()
    {
        List<UOperation> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();            
            ls = sess.createCriteria(UOperation.class).add(Restrictions.eq("del", 0)).list();                        
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
    public static UOperation getUOperation(int p)
    {
        List<UOperation> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();            
            ls = sess.createCriteria(UOperation.class).add(Restrictions.eq("uoperation", p)).list();                        
            if(ls.isEmpty())
                ls.add(new UOperation(0));
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
            ls.add(new UOperation(0));
        }        
        return ls.get(0);        
    }
    
    /**
     * Удалить объект
     * @param p - ид объекта
     * @return - результат
     */
    public static boolean delUOperation(int p)
    { 
        UOperation p1 = getUOperation(p);
        p1.setDel(1);
                
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            
            sess.beginTransaction();
            sess.saveOrUpdate(p1);
            sess.beginTransaction().commit();            
            
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
    public static UDocument setUDocument(UDocument p)
    {
        if(p.getUdocument()== 0)
            p.setUdocument(null);
        
        Session sess = HibernateUtil.getSessionFactory().openSession();
        try 
        {
            sess.beginTransaction();
            sess.saveOrUpdate(p);
            sess.beginTransaction().commit();
            
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
     * @return 
     */
    public static List<UDocument> getListUDocument(Date d1, Date d2)
    {
        List<UDocument> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();            
            ls = sess.createCriteria(UDocument.class).add(Restrictions.between("dates", d1, d2)).list();                        
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
    public static UDocument getUDocument(int p)
    {
        List<UDocument> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();            
            ls = sess.createCriteria(UDocument.class).add(Restrictions.eq("udocument", p)).list();                        
            if(ls.isEmpty())
                ls.add(new UDocument(0));
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
            ls.add(new UDocument(0));
        }        
        return ls.get(0);        
    }
    
    /**
     * Удалить объект
     * @param p - ид объекта
     * @return - результат
     */
    public static boolean delUDocument(int p)
    { 
        UDocument p1 = getUDocument(p);       
                
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            
            sess.beginTransaction();
            sess.delete(p1);
            sess.beginTransaction().commit();            
            
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
            return false;
        }        
        return true;
        
    }
    
}
