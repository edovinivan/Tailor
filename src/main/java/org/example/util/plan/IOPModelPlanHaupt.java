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
import org.example.logic.plan.PModelPlanHaupt;
import org.example.logic.plan.PModelPlanHauptJournal;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.example.util.HibernateUtil;
import static org.example.util.plan.IOModelPlan.getPModelPlan;

/**
 *
 * @author ivan
 */
public class IOPModelPlanHaupt {
    
     /**
     * Сохранить объект
     * @param p - объект
     * @return - объект
     */
    public static PModelPlanHaupt setPModelPlanHaupt(PModelPlanHaupt p)
    {
        if(p.getPmodelplanhaupt()== 0)
            p.setPmodelplanhaupt(null);
        
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
    public static List<PModelPlanHaupt> getListPModelPlanHaupt(Date d1, Date d2)
    {
        List<PModelPlanHaupt> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();            
            ls = sess.createCriteria(PModelPlanHaupt.class).add(Restrictions.between("dates", d1, d2)).addOrder(Order.desc("dates")).list();                        
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Получить список объектов по дате когда делаем
     * @param d1
     * @param d2
     * @return 
     */
    public static List<PModelPlanHaupt> getListPModelPlanHaupt1(Date d1, Date d2)
    {
        List<PModelPlanHaupt> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();            
            ls = sess.createCriteria(PModelPlanHaupt.class).add(Restrictions.between("dates4", d1, d2)).addOrder(Order.desc("dates4")).list();                        
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
    public static PModelPlanHaupt getPModelPlanHaupt(int p)
    {
        List<PModelPlanHaupt> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();            
            ls = sess.createCriteria(PModelPlanHaupt.class).add(Restrictions.eq("pmodelplanhaupt", p)).list();                        
            if(ls.isEmpty())
                ls.add(new PModelPlanHaupt(0));
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
            ls.add(new PModelPlanHaupt(0));
        }        
        return ls.get(0);        
    }
    
    /**
     * Сохранить объект
     * @param p - объект
     * @return - объект
     */
    public static PModelPlanHauptJournal setPModelPlanHauptJournal(PModelPlanHauptJournal p)
    {
        if(p.getPmodelplanhauptjournal()== 0)
            p.setPmodelplanhauptjournal(null);
        
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
     * Сохранить объект
     * @param p - объект
     * @return - объект
     */
    public static PModelPlanHauptJournal savePModelPlanHauptJournal(PModelPlanHauptJournal p)
    {
        PModelPlanHauptJournal j = getListPModelPlanHauptJournals(p.getPmodelplanhaupt().getPmodelplanhaupt(), p.getPmodelplan().getPmodelplan());
        if(j.getPmodelplanhauptjournal()!=0)
            return j;
        
        return setPModelPlanHauptJournal(p);
    }
    
    /**
     * Получить строку главной задачи по номеру задачи главной и номеру
     * @param ph
     * @param pl
     * @return 
     */
    public static PModelPlanHauptJournal getListPModelPlanHauptJournals(int ph, int pl)
    {
        List<PModelPlanHauptJournal> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();            
            ls = sess.createCriteria(PModelPlanHauptJournal.class).add(Restrictions.eq("pmodelplanhaupt", new PModelPlanHaupt(ph))).add(Restrictions.eq("pmodelplan", new PModelPlan(pl))).list();                        
            if(ls.isEmpty())
                ls.add(new PModelPlanHauptJournal(0));
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
            ls.add(new PModelPlanHauptJournal(0));
        }        
        return ls.get(0);        
    }
    
    
    /**
     * Получить список объектов
     * @param ph
     * @return 
     */
    public static List<PModelPlanHauptJournal> getListPModelPlanHauptJournals(int ph)
    {
        List<PModelPlanHauptJournal> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();            
            //ls = sess.createCriteria(PModelPlanHauptJournal.class).add(Restrictions.eq("pmodelplanhaupt", new PModelPlanHaupt(ph))).addOrder(order).list();                        
            
            ls = sess.createCriteria(PModelPlanHauptJournal.class).createAlias("pmodelplan", "pm").add(Restrictions.eq("pmodelplanhaupt", new PModelPlanHaupt(ph))).addOrder(Order.asc("pm.dates")).list();
            
            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Удалить заголовок плана
     * @param p - ид объекта
     * @return - результат
     */
    public static int delPModelPlanHaupt(int p)
    {
        for(PModelPlanHauptJournal j: getListPModelPlanHauptJournals(p))
        {
            if(j.getPmodelplan().getStatus()>1)
                return -1;
        }
        
        //удалим строки плана
        for(PModelPlanHauptJournal j: getListPModelPlanHauptJournals(p))
        {
            if(IOModelPlan.delPModelPlan(j.getPmodelplan().getPmodelplan())!=0)
                return -2;
        }        
        
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            
            sess.beginTransaction();
            String s = "delete from P_MODELPLANHAUPT where P_MODELPLANHAUPT = " + p;
            sess.createSQLQuery(s).executeUpdate();
            sess.beginTransaction().commit();            
            
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
            return -3;
        }        
        return 0;
        
    }
    
}
