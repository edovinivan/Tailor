/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.util;

import org.example.logic.Report;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ivan
 */
public class IOReport {
    /**
     * Сохранить объект
     * @param p - объект
     * @return - объект
     */
    public static Report setReport(Report p)
    {
        if(p.getReport()== 0)
            p.setReport(null);
        
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
     * @param p - типы отчетов
     * 0 - отчеты
     * @return 
     */
    public static List<Report> getListReport(int p)
    {
        List<Report> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(Report.class).add(Restrictions.eq("tip", p)).addOrder(Order.asc("name")).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Получить объект
     * @param p - id объекта
     * @return 
     */
    public static Report getReport(int p)
    {
        List<Report> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(Report.class).add(Restrictions.eq("report", p)).list();            
            if(ls.isEmpty())
                ls.add(new Report(0));
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
            ls.add(new Report(0));
        }        
        return ls.get(0);        
    }
    
    /**
     * Удалить объект
     * @param p - ид объекта
     * @return - результат
     */
    public static boolean delReport(int p)
    {
        try 
        {
            Report r = getReport(p);
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            
            sess.beginTransaction();
            String s = "delete from Report where Report = " + p;
            sess.createSQLQuery(s).executeUpdate();
            sess.beginTransaction().commit();
            
            sess.beginTransaction();
            s = "delete from files where files = " + r.getFiles().getFiles();
            sess.createSQLQuery(s).executeUpdate();
            sess.beginTransaction().commit();
            
            
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
            return false;
        }        
        return true;
        
    }
    
    
    
    /**
     * Очистить таблицу для хранения временных данных
     */
    public static void clearTModelCalc()
    {
        try 
        {
            
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            
            sess.beginTransaction();
            String s = "delete from T_MODELCALC";
            sess.createSQLQuery(s).executeUpdate();
            sess.beginTransaction().commit();        
            
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
        }        
        
    }
    
    
    /**
     * Добавить строку
     * @param m
     * @param c
     */
    public static void addTModelCalc(int m, int c)
    {
        try 
        {
            String sql = "insert into T_MODELCALC (MODEL, COU) values ("+m+", "+c+")";
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            
            sess.beginTransaction();            
            sess.createSQLQuery(sql).executeUpdate();
            sess.beginTransaction().commit();        
            
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
        }        
        
    }
    
}
