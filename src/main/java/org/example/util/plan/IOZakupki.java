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
import org.example.logic.plan.PZakupki;
import org.example.logic.plan.PZakupkiJournal;
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
public class IOZakupki {
    
    /**
     * Сохранить объект
     * @param p - объект
     * @return - объект
     */
    public static PZakupki setPZakupki(PZakupki p)
    {
        if(p.getPzakupki()== 0)
            p.setPzakupki(null);
        
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
    public static List<PZakupki> getListPZakupki(Date d1, Date d2)
    {
        List<PZakupki> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();            
            ls = sess.createCriteria(PZakupki.class).add(Restrictions.between("date1", d1, d2)).addOrder(Order.desc("date1")).list();                        
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
    public static PZakupki getPZakupki(int p)
    {
        List<PZakupki> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();            
            ls = sess.createCriteria(PZakupki.class).add(Restrictions.eq("pzakupki", p)).list();                        
            if(ls.isEmpty())
                ls.add(new PZakupki(0));
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
            ls.add(new PZakupki(0));
        }        
        return ls.get(0);        
    }
    
    /**
     * Удалить объект
     * @param p - ид объекта
     * @return - результат
     */
    public static int delPZakupki(int p)
    { 
        PZakupki pz = getPZakupki(p);
        if(pz.getStatus()!=0)
            return -1;
        
        for(PZakupkiJournal j:getListPZakupkiJournal(p))
            delPZakupkiJournal(j.getPzakupkijournal());
        
        
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            
            Transaction transaction = sess.beginTransaction();
            sess.delete(pz);
            transaction.commit();
            
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
            return -3;
        }        
        return 0;
        
    }
    
    /**
     * Удалить задачу из закупки
     * @param zj - ид объекта
     * @return - результат
     */
    public static boolean delPZakupkiJournal(int zj)
    { 
        PZakupkiJournal p = getPZakupkiJournal(zj);        
        try 
        {
            PModelPlan pm = p.getPmodelplan();
            Session sess = HibernateUtil.getSessionFactory().openSession();             
            Transaction transaction = sess.beginTransaction();
            sess.delete(p);
            transaction.commit();
            pm.setStatus(1);
            IOModelPlan.setPModelPlan(pm);
            
            
            
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
            return false;
        }        
        return true;
        
    }
    
    /**
     * Создать закупки
     * @param d1 - дата закупок
     * @param d2 - дата с
     * @param d3 - дата по
     * @return 
     */
    public static int createZakupki(Date d1, Date d2, Date d3)
    {
        PZakupki pz = new PZakupki();
        pz.setDate1(new Date());
        pz.setDate2(d1);
        pz.setPzakupki(0);
        pz.setStatus(0);
        pz = setPZakupki(pz);
        PZakupkiJournal pj;
        for(PModelPlan p : IOModelPlan.getListPModelPlan(d2, d3))
        {
            pj = new PZakupkiJournal();
            pj.setPmodelplan(p);
            pj.setPzakupki(pz);
            pj.setPzakupkijournal(0);
            if(setPZakupkiJournal(pj).getPzakupkijournal()>0)
            {
                p.setStatus(2);
                IOModelPlan.setPModelPlan(p);
            }
        }        
        return pz.getPzakupki();
    }
    
     /**
     * Сохранить объект
     * @param p - объект
     * @return - объект
     */
    public static PZakupkiJournal setPZakupkiJournal(PZakupkiJournal p)
    {
        if(p.getPzakupkijournal()== 0)
            p.setPzakupkijournal(null);
        
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
     * @param pz - заголовок закупок
     * @return 
     */
    public static List<PZakupkiJournal> getListPZakupkiJournal(int pz)
    {
        List<PZakupkiJournal> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();            
            ls = sess.createCriteria(PZakupkiJournal.class).add(Restrictions.eq("pzakupki", new PZakupki(pz))).list();                        
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Получить список строк закупок для плана производства
     * @param mp - строка плана производства
     * @return 
     */
    public static List<PZakupkiJournal> getListPZakupkiJournalForPMpdelPlan(int mp)
    {
        List<PZakupkiJournal> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();            
            ls = sess.createCriteria(PZakupkiJournal.class).add(Restrictions.eq("pmodelplan", new PModelPlan(mp) )).list();                        
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
    public static PZakupkiJournal getPZakupkiJournal(int p)
    {
        List<PZakupkiJournal> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();            
            ls = sess.createCriteria(PZakupkiJournal.class).add(Restrictions.eq("pzakupkijournal", p)).list();                        
            if(ls.isEmpty())
                ls.add(new PZakupkiJournal(0));
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
            ls.add(new PZakupkiJournal(0));
        }        
        return ls.get(0);        
    }
    
}
