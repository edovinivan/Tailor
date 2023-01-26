/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.util;

import java.util.ArrayList;
import java.util.List;
import org.example.logic.Setup;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Transaction;

/**
 *
 * @author ivan
 */
public class IOSetup {
    
    /**
     * Получить строковое значение настройки
     * @param s - номер настройки
     * @return 
     */
    public static String getSetuValStr(int s)
    {
        List<Setup> ls;// = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(Setup.class).add(Restrictions.eq("setup", s)).list();            
            return ls.get(0).getVal_str();
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return "";        
    }
    
    /**
     * Получить числовое значение настройки
     * @param s - номер настройки
     * @return 
     */
    public static int getSetuValInt(int s)
    {
        List<Setup> ls;// = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(Setup.class).add(Restrictions.eq("setup", s)).list();            
            return ls.get(0).getVal_int();
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return -1;        
    }
    
    /**
     * сохранить настройку
     * @param s
     * @return 
     */
    public static Setup setSetup(Setup s)
    {
        if(s.getSetup()== 0)
            s.setSetup(null);
        
        Session sess = HibernateUtil.getSessionFactory().openSession();
        try 
        {
            Transaction transaction = sess.beginTransaction();
            sess.saveOrUpdate(s);
            transaction.commit();
            
        }catch(HibernateException e)
        {
            System.out.println("ERROR SAVE" + e);            
        }
        return s;
    }
    
    /**
     * Получить настройку
     * @param s
     * @return 
     */
    public static Setup getSetup(int s)
    {
        List<Setup> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(Setup.class).add(Restrictions.eq("setup", s)).list();            
            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls.get(0);        
    }
    
    /**
     * Сохранить строковое значение в параметр
     * @param s
     * @param str
     * @return 
     */
    public static boolean setSetup(int s, String str)            
    {
        Setup p = getSetup(s);
        p.setVal_str(str);
        setSetup(p);
        return true;
    }
    
    /**
     * Сохранить числовое значение в параметр
     * @param s
     * @param i
     * @return 
     */
    public static boolean setSetup(int s, int i)            
    {
        Setup p = getSetup(s);
        p.setVal_int(i);
        setSetup(p);
        return true;
    }
    
    /**
     * Получить номер для задачи
     * @return 
     */
    public static int getNextNomZadacha()
    {
        Setup s = getSetup(1);
        int n = s.getVal_int();
        s.setVal_int(s.getVal_int()+1);
        setSetup(s);
        return n;
    }
    
    /**
     * Получить номер для настила
     * @return 
     */
    public static int getNextNomNastil()
    {
        Setup s = getSetup(2);
        int n = s.getVal_int();
        s.setVal_int(s.getVal_int()+1);
        setSetup(s);
        return n;
    }
    
    
    /**
     * Отключение от базы
     */
    public static void disconnet()
    {
        HibernateUtil.closeSession();
    }
}
