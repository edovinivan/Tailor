/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.example.logic.ScladLoskut;
import org.example.logic.ScladLoskutSale;
import org.example.logic.ScladLoskutSaleOp;
import org.example.logic.ZadachaNastil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ivan
 */
public class IOScladLoskut {
    /**
     * Сохранить объект
     * @param p - объект
     * @return - объект
     */
    public static ScladLoskut setScladLoskut(ScladLoskut p)
    {
        if(p.getScladloskut()== 0)
            p.setScladloskut(null);
        
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
     * @param mn - минимальный статус
     * @param mx - максимальный статус
     * @param view_all - показывать все или только те что на остатке
     * @return 
     */
    public static List<ScladLoskut> getListScladLoskut(int mn, int mx, boolean view_all)
    {
        List<ScladLoskut> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            if(!view_all)
                ls = sess.createCriteria(ScladLoskut.class).add(Restrictions.between("status", mn, mx)).add(Restrictions.gt("ostatok", new BigDecimal("0"))).addOrder(Order.asc("dates")).list();            
            else
                ls = sess.createCriteria(ScladLoskut.class).add(Restrictions.between("status", mn, mx)).addOrder(Order.asc("dates")).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    
    public static ScladLoskut getScladLoskut(int sl)
    {
        List<ScladLoskut> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(ScladLoskut.class).add(Restrictions.eq("scladloskut", sl)).list();            
            if(ls.isEmpty())
                ls.add(new ScladLoskut(0));
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls.get(0);        
    }
    
    /**
     * Получить лоскут на складе по номеру настила
     * @param zn
     * @return 
     */
    public static ScladLoskut getScladLoskutForZN(int zn)
    {
        List<ScladLoskut> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(ScladLoskut.class).add(Restrictions.eq("zadachanastil", new ZadachaNastil(zn))).list();            
            if(ls.isEmpty())
                ls.add(new ScladLoskut(0));
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
            ls.add(new ScladLoskut(0));
        }        
        return ls.get(0);        
    }
    
    
    /**
     * Сохранить объект
     * @param p - объект
     * @return - объект
     */
    public static ScladLoskutSale setScladLoskutSale(ScladLoskutSale p)
    {
        if(p.getScladloskutsale()== 0)
            p.setScladloskutsale(null);
        
        Session sess = HibernateUtil.getSessionFactory().openSession();
        try 
        {
            sess.beginTransaction();
            sess.saveOrUpdate(p);
            sess.beginTransaction().commit();
            
            ScladLoskut sl = p.getScladloskut();
            sl.setOstatok(sl.getOstatok().subtract(p.getQty()));
            setScladLoskut(sl);
            
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
    public static List<ScladLoskutSale> getListScladLoskutSale(Date d1, Date d2)
    {
        List<ScladLoskutSale> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(ScladLoskutSale.class).add(Restrictions.between("dates", d1, d2)).addOrder(Order.asc("dates")).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    
    public static ScladLoskutSale getScladLoskutSale(int sl)
    {
        List<ScladLoskutSale> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(ScladLoskutSale.class).add(Restrictions.eq("scladloskutsale", sl)).list();            
            if(ls.isEmpty())
                ls.add(new ScladLoskutSale(0));
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls.get(0);        
    }
    
    /**
     * Получить операции по строке лоскута
     * @param sl
     * @return 
     */
    public static List<ScladLoskutSale> getScladLoskutSaleForSL(int sl)
    {
        List<ScladLoskutSale> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(ScladLoskutSale.class).add(Restrictions.eq("scladloskut", new ScladLoskut(sl))).list();            
            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    
    /**
     * Сохранить объект
     * @param p - объект
     */
    public static void delScladLoskutSale(int p)
    {
        ScladLoskutSale ss = getScladLoskutSale(p);
        //изменим количество на складе
        ScladLoskut sl = ss.getScladloskut();
        sl.setOstatok(sl.getOstatok().add(ss.getQty()));
        setScladLoskut(sl);
        
        Session sess = HibernateUtil.getSessionFactory().openSession();
        try 
        {
            sess.beginTransaction();
            sess.delete(ss);
            sess.beginTransaction().commit();
        }catch(HibernateException e)
        {
            System.out.println("ERROR SAVE" + e);            
        }
    }
    
    
     /**
     * Сохранить объект
     * @param p - объект
     * @return 
     */
    public static int delScladLoskut(int p)
    {
        ScladLoskut sl = getScladLoskut(p);        
        
        Session sess = HibernateUtil.getSessionFactory().openSession();
        try 
        {
            sess.beginTransaction();
            sess.delete(sl);
            sess.beginTransaction().commit();
            
            IOOperationHistory.saveOperationHistory("Удалили приход ", sl.getZadachanastil().getZadachanastil(), 1);
            
        }catch(HibernateException e)
        {
            System.out.println("ERROR SAVE" + e);            
        }
        return 0;
    }
    
    
    /**
     * Получить список операций списания
     * @return 
     */
    public static List<ScladLoskutSaleOp> getScladLoskutSaleOp()
    {
        List<ScladLoskutSaleOp> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(ScladLoskutSaleOp.class).add(Restrictions.eq("del", 0)).addOrder(Order.asc("name")).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
}
