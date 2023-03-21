/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.util;

import java.util.ArrayList;
import java.util.List;
import org.example.logic.Color;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ivan
 */
public class IOColor {
    /**
     * Сохранить цвет
     * @param p - цвет
     * @return - цвет
     */
    public static Color setColor(Color p)
    {
        if(p.getColor()== 0)
            p.setColor(null);
        
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
     * @param p - id цвета -1 все
     * @param vid - вид
     * @return 
     */
    public static List<Color> getListColor(int p, int vid)
    {
        List<Color> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            if(p == -1)
            {
                ls = sess.createCriteria(Color.class).add(Restrictions.eq("vid", vid)).add(Restrictions.eq("del", 0)).addOrder(Order.asc("name")).list();            
            }
            else
                ls = sess.createCriteria(Color.class).add(Restrictions.eq("color", p)).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    
    /**
     * Получить список агентов
     * @param p - id цвета
     * @return 
     */
    public static Color getColor(int p)
    {
        List<Color> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(Color.class).add(Restrictions.eq("color", p)).list();            
            if(ls.isEmpty())
                ls.add(new Color(0));
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
            ls.add(new Color(0));
        }        
        return ls.get(0);        
    }
    
    
    
    /**
     * Получить список цветов для комплектовки
     * @param kom - вид
     * @return 
     */
    public static List<Color> getListColorForKomplektovka(int kom)
    {
        List<Color> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            String sql = "select list(DISTINCT c.color , '!')   from zadachaproduct zp inner join modelproduct mp on mp.modelproduct = zp.modelproduct inner join zadachascladproduct zsp on zsp.zadachaproduct = zp.zadachaproduct inner join scladproduct sp on sp.scladproduct = zsp.scladproduct inner join color c on sp.color = c.color inner join zadachakomplektovka zk on zk.zadacha = zp.zadacha where  mp.tipproduct = 1 and zk.zadachakomplektovka = " + kom;
            sql = (String) sess.createSQLQuery(sql).uniqueResult();
            //System.out.println(">>>>>>>>  " + sql);
            String s[];
            s = sql.split("!");
            //if(s.length>0)
            for(String c:s)
                ls.add(IOColor.getListColor(Integer.parseInt(c), 0).get(0));
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    
    /**
     * Удалить агента
     * @param p - ид цвет
     * @return - результат
     */
    public static boolean delColor(int p)
    {
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            Transaction transaction = sess.beginTransaction();
            String s = "update Color set del = 1 where Color = " + p;
            sess.createSQLQuery(s).executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
            return false;
        }        
        return true;
        
    }
}
