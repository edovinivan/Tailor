/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.util;

import java.util.ArrayList;
import java.util.List;
import org.example.logic.OperationTextGruppa;
import org.example.logic.OperationTextGruppaJournal;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author edovin.ivan
 */
public class IOOperationTextGruppa {
    /**
     * Сохранить 
     * @param p - объект
     * @return - объект
     */
    public static OperationTextGruppa setOperationTextGruppa(OperationTextGruppa p)
    {
        if(p.getOperationtextgruppa()== 0)
            p.setOperationtextgruppa(null);
        
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
     * Сохранить строку
     * @param p - объект
     * @return - объект
     */
    public static OperationTextGruppaJournal setOperationTextGruppaJournal(OperationTextGruppaJournal p)
    {
        if(p.getOperationtextgruppajournal()== 0)
            p.setOperationtextgruppajournal(null);
        
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
     * Получить объект
     * @param p
     * @return 
     */
    public static OperationTextGruppa getOperationTextGruppa(int p)
    {
        List<OperationTextGruppa> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess
                    .createCriteria(OperationTextGruppa.class)
                    .add(Restrictions.eq("operationtextgruppa", p))
                    .list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls.get(0);        
    }
    
    /**
     * Получить объект
     * @param p
     * @return 
     */
    public static OperationTextGruppaJournal getOperationTextGruppaJournal(int p)
    {
        List<OperationTextGruppaJournal> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess
                    .createCriteria(OperationTextGruppaJournal.class)
                    .add(Restrictions.eq("operationtextgruppajournal", p))
                    .list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls.get(0);        
    }
    
     /**
     * Получить список объектов
     * @return 
     */
    public static List<OperationTextGruppa> getListOperationTextGruppa()
    {
        List<OperationTextGruppa> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess
                    .createCriteria(OperationTextGruppa.class)
                    .add(Restrictions.eq("del", 0))
                    .addOrder(Order.asc("name"))
                    .list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    
     /**
     * Получить список объектов
     * @param op
     * @return 
     */
    public static List<OperationTextGruppaJournal> getListOperationTextGruppaJournal(int op)
    {
        List<OperationTextGruppaJournal> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess
                    .createCriteria(OperationTextGruppaJournal.class)
                    .add(Restrictions.eq("operationTextGruppa", new OperationTextGruppa(op)))
                    .addOrder(Order.asc("nom"))
                    .list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
     /**
     * Удалить операцию
     * @param p
     * @return 
     */
    public static boolean delOperationTextGruppaJournal(int p)
    {
        OperationTextGruppaJournal oj = getOperationTextGruppaJournal(p);        
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            Transaction transaction = sess.beginTransaction();
            sess.delete(oj);
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
            return false;
        }        
        return true;
        
    }
    
     /**
     * Удалить операцию
     * @param p
     * @return 
     */
    public static boolean delOperationTextGruppa(int p)
    {
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            Transaction transaction = sess.beginTransaction();
            String s = "update OPERATIONTEXTGRUPPA set del = 1 where OPERATIONTEXTGRUPPA = " + p;
            sess.createSQLQuery(s).executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
            return false;
        }        
        return true;
        
    }
}
