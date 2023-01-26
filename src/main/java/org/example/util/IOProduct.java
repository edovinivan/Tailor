/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.util;

import java.util.ArrayList;
import java.util.List;
import org.example.logic.Measure;
import org.example.logic.Product;
import org.example.logic.ProductGruppa;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Transaction;

/**
 *
 * @author ivan
 */
public class IOProduct {
    /**
     * Сохранить товар
     * @param p - товар
     * @return - товар
     */
    public static Product setProduct(Product p)
    {
        if(p.getProduct()== 0)
            p.setProduct(null);
        
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
     * Получить список товаров
     * @param p - id товара -1 все
     * @param vid - вид 0 - все
     * @return 
     */
    public static List<Product> getListProduct(int p, int vid)
    {
        List<Product> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            if(p == -1)
            {
                if(vid == 0)
                    ls = sess.createCriteria(Product.class).add(Restrictions.eq("del", 0)).addOrder(Order.asc("name")).list();            
                else
                    ls = sess.createCriteria(Product.class).add(Restrictions.eq("vid", vid)).add(Restrictions.eq("del", 0)).addOrder(Order.asc("name")).list();            
            }
            else
                ls = sess.createCriteria(Product.class).add(Restrictions.eq("product", p)).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Удалить товар
     * @param p - ид товара
     * @return - результат
     */
    public static boolean delProduct(int p)
    {
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            Transaction transaction = sess.beginTransaction();
            String s = "update product set del = 1 where product = " + p;
            sess.createSQLQuery(s).executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
            return false;
        }        
        return true;
        
    }
    
     /**
     * Получить список единиц измерения товара     
     * @param m - ед изм
     * @return 
     */
    public static List<Measure> getListMeasure(int m)
    {
        List<Measure> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            if(m==-1)
                ls = sess.createCriteria(Measure.class).add(Restrictions.eq("del", 0)).addOrder(Order.asc("name")).list();            
            else
                ls = sess.createCriteria(Measure.class).add(Restrictions.eq("measure", m)).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Сохранить ед изм
     * @param p - ед изм
     * @return - ед изм
     */
    public static Measure setMeasure(Measure p)
    {
        if(p.getMeasure()== 0)
            p.setMeasure(null);
        
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
     * Удалить товар
     * @param p - ид ед изм
     * @return - результат
     */
    public static boolean delMeasure(int p)
    {
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            Transaction transaction = sess.beginTransaction();
            String s = "update Measure set del = 1 where Measure = " + p;
            sess.createSQLQuery(s).executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
            return false;
        }        
        return true;
        
    }
    
    /**
     * Сохранить группу товаров
     * @param p - товар
     * @return - товар
     */
    public static ProductGruppa setProductGruppa(ProductGruppa p)
    {
        if(p.getProductgruppa()== 0)
            p.setProductgruppa(null);
        
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
     * Получить список групп товаров
     * @param p - id группы  -1 все
     * @param vid - вид 0 - все
     * @return 
     */
    public static List<ProductGruppa> getListProductGruppa(int p, int vid)
    {
        List<ProductGruppa> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            if(p == -1)
            {
                if(vid == 0)
                    ls = sess.createCriteria(ProductGruppa.class).add(Restrictions.eq("del", 0)).addOrder(Order.asc("name")).list();            
                else
                    ls = sess.createCriteria(ProductGruppa.class).add(Restrictions.eq("vid", vid)).add(Restrictions.eq("del", 0)).addOrder(Order.asc("name")).list();            
            }
            else
                ls = sess.createCriteria(ProductGruppa.class).add(Restrictions.eq("productgruppa", p)).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Удалить группу товар
     * @param p - ид группы
     * @return - результат
     */
    public static boolean delProductGruppa(int p)
    {
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            Transaction transaction = sess.beginTransaction();
            String s = "update ProductGruppa set del = 1 where ProductGruppa = " + p;
            sess.createSQLQuery(s).executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
            return false;
        }        
        return true;
        
    }
    
    
}
