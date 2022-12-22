/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.example.logic.Zadacha;
import org.example.logic.ZadachaPrintDetali;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ivan
 */
public class IOZadachaPrintDetali {
    
    
    
    
     /**
     * Получить список не отработанных объектов для задачи
     * 
     * @param zadacha
     * @return 
     */
    public static List<ZadachaPrintDetali> getListZadachaPrintDetaliForZadacha(int zadacha)
    {
        List<ZadachaPrintDetali> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(ZadachaPrintDetali.class).add(Restrictions.eq("zadacha", new Zadacha(zadacha))).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    
    /**
     * Сохранить 
     * @param p - объект
     * @return - объект
     */
    public static ZadachaPrintDetali setZadachaPrintDetali(ZadachaPrintDetali p)
    {
        if(p.getZadachaprintdetali()== 0)
            p.setZadachaprintdetali(null);
        
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
     * @param p - id объекта
     * @param vid - вид
     * @param status - максимальный статус
     * 
     * @return 
     */
    public static List<ZadachaPrintDetali> getListZadachaPrintDetali(int p, int vid, int status)
    {
        List<ZadachaPrintDetali> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            if(p == -1)
            {
                ls = sess.createCriteria(ZadachaPrintDetali.class).add(Restrictions.eq("vid", vid)).add(Restrictions.le("status", status)).addOrder(Order.desc("zadacha")).list();            
            }
            else
                ls = sess.createCriteria(ZadachaPrintDetali.class).add(Restrictions.eq("zadachaprintdetali", p)).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Изменить количество и цену за одну деталь
     * @param zpd - id строки
     * @param qty - количество
     * @param price - цена
     * @return 
     */
    public static int updateZadachaPrintDetali(int zpd, int qty, BigDecimal price)
    {
        ZadachaPrintDetali z = getListZadachaPrintDetali(zpd, 0, 0).get(0);
        z.setQtyend(qty);
        z.setPrice(price);
        setZadachaPrintDetali(z);
        return 1;
    }
    
    /**
     * Изменить статус 
     * @param pd - id
     * @param st - статус
     * @return 
     */
    public static int updateStatusPD(int pd, int st)
    {
        ZadachaPrintDetali z = getListZadachaPrintDetali(pd, 0, 0).get(0);
        z.setStatus(st);
        Session sess = HibernateUtil.getSessionFactory().openSession();
        try 
        {
            sess.beginTransaction();
            sess.saveOrUpdate(z);
            sess.beginTransaction().commit();
            
        }catch(HibernateException e)
        {
            System.out.println("ERROR SAVE" + e);            
            return -1;
        }
        return 1;
    }
}
