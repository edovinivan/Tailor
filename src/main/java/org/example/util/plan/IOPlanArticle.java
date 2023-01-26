/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.util.plan;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.example.logic.plan.PModelPlan;
import org.example.logic.plan.PlanArticle;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.example.util.HibernateUtil;
import org.hibernate.Transaction;

/**
 *
 * @author ivan
 */
public class IOPlanArticle {
    
     /**
     * Сохранить объект
     * @param p - объект
     * @return - объект
     */
    public static PlanArticle setPlanArticle(PlanArticle p)
    {
        if(p.getPlanarticle()== 0)
            p.setPlanarticle(null);
        
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
     * @return 
     */
    public static List<PlanArticle> getListPlanArticle(Date d1, Date d2)
    {
        List<PlanArticle> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();            
            ls = sess.createCriteria(PlanArticle.class).add(Restrictions.between("dates", d1, d2)).addOrder(Order.desc("dates")).list();                        
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
    public static PlanArticle getPlanArticle(int p)
    {
        List<PlanArticle> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();            
            ls = sess.createCriteria(PlanArticle.class).add(Restrictions.eq("planarticle", p)).list();                        
            if(ls.isEmpty())
                ls.add(new PlanArticle(0));
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
            ls.add(new PlanArticle(0));
        }        
        return ls.get(0);        
    }
    
    
     /**
     * Удалить строку
     * @param m - 
     * @return 
     */
    public static int delPlanArticle(int m)
    {
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
                        
            
            Transaction transaction = sess.beginTransaction();
            String s = "delete from PLANARTICLE where PLANARTICLE = " + m;
            sess.createSQLQuery(s).executeUpdate();
            transaction.commit();
            
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
            return -1;
        }
        return 0;
    }
    
}
