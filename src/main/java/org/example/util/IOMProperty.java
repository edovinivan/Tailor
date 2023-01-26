/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.util;

import java.util.ArrayList;
import java.util.List;
import org.example.logic.MModelComment;
import org.example.logic.MModelProperty;
import org.example.logic.MProperty;
import org.example.logic.Model;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ivan
 */
public class IOMProperty {
    /**
     * Сохранить настройку
     * @param p - объект
     * @return - объект
     */
    public static MProperty setMProperty(MProperty p)
    {
        if(p.getMproperty()== 0)
            p.setMproperty(null);
        
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
     * @return 
     */
    public static List<MProperty> getListMProperty()
    {
        List<MProperty> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(MProperty.class).add(Restrictions.eq("del", 0)).addOrder(Order.asc("name")).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Получить объект
     * @param p
     * @return 
     */
    public static MProperty getMProperty(int p)
    {
        List<MProperty> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(MProperty.class).add(Restrictions.eq("mproperty", p)).list();            
            if(ls.isEmpty())
                ls.add(new MProperty(0));
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
            ls.add(new MProperty(0));
        }        
        return ls.get(0);        
    }
    
    /**
     * Удалить объект
     * @param p - ид объекта
     * @return - результат
     */
    public static boolean delMProperty(int p)
    {
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            Transaction transaction = sess.beginTransaction();
            String s = "update M_Property set del = 1 where M_Property = " + p;
            sess.createSQLQuery(s).executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
            return false;
        }        
        return true;
        
    }
    
    /**
     * Сохранить настройку
     * @param p - объект
     * @return - объект
     */
    public static MModelProperty setMModelProperty(MModelProperty p)
    {
        if(p.getMmodelproperty()== 0)
            p.setMmodelproperty(null);
        
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
     * @return 
     */
    public static List<MModelProperty> getListMModelProperty()
    {
        List<MModelProperty> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(MModelProperty.class).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Получить объект
     * @param p
     * @return 
     */
    public static MModelProperty getMModelProperty(int p)
    {
        List<MModelProperty> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(MModelProperty.class).add(Restrictions.eq("mmodelproperty", p)).list();            
            if(ls.isEmpty())
                ls.add(new MModelProperty(0));
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
            ls.add(new MModelProperty(0));
        }        
        return ls.get(0);        
    }
    
    /**
     * Удалить объект
     * @param p - ид объекта
     * @return - результат
     */
    public static boolean delMModelProperty(int p)
    {
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            Transaction transaction = sess.beginTransaction();
            String s = "delete from M_MODELPROPERTY where M_MODELPROPERTY = " + p;
            sess.createSQLQuery(s).executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
            return false;
        }        
        return true;
        
    }
    
    
    /**
     * Сохранить комментарий
     * @param p - объект
     * @return - объект
     */
    public static MModelComment setMModelComment(MModelComment p)
    {
        if(p.getMmodelcomment()== 0)
            p.setMmodelcomment(null);
        
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
     * Получить список объектов для модели
     * @param m - модель
     * @return 
     */
    public static List<MModelComment> getListMModelCommentForModel(int m)
    {
        List<MModelComment> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(MModelComment.class).add(Restrictions.eq("model", new Model(m))).addOrder(Order.desc("dates")).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Получить список комментариев
     * @param m - модель
     * @return 
     */
    public static List<MModelComment> getListMModelCommentForAll()
    {
        List<MModelComment> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(MModelComment.class).addOrder(Order.desc("dates")).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Получить объект
     * @param p
     * @return 
     */
    public static MModelComment getMModelComment(int p)
    {
        List<MModelComment> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(MModelComment.class).add(Restrictions.eq("mmodelcomment", p)).list();            
            if(ls.isEmpty())
                ls.add(new MModelComment(0));
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
            ls.add(new MModelComment(0));
        }        
        return ls.get(0);        
    }
    
    /**
     * Удалить объект
     * @param p - ид объекта
     * @return - результат
     */
    public static boolean delMModelComment(int p)
    {
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            Transaction transaction = sess.beginTransaction();
            String s = "delete from M_MODELCOMMENT where status < 2 and M_MODELCOMMENT = " + p;
            sess.createSQLQuery(s).executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
            return false;
        }        
        return true;
        
    }
    
}
