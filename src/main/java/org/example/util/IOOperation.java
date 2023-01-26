/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.util;

import java.util.ArrayList;
import java.util.List;
import org.example.logic.Operation;
import org.example.logic.OperationGruppa;
import org.example.logic.OperationText;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ivan
 */
public class IOOperation {
    /**
     * Сохранить операцию
     * @param p - операция
     * @return - операция
     */
    public static Operation setOperation(Operation p)
    {
        if(p.getOperation()== 0)
            p.setOperation(null);
        
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
     * Получить список операций
     * @param p - id операции
     * @return 
     */
    public static List<Operation> getListOperation(int p)
    {
        List<Operation> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            if(p == -1)
                ls = sess.createCriteria(Operation.class).add(Restrictions.eq("del", 0)).addOrder(Order.asc("operationgruppa")).addOrder(Order.asc("name")).list();            
            else
                ls = sess.createCriteria(Operation.class).add(Restrictions.eq("operation", p)).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Удалить операцию
     * @param p - ид операции
     * @return - результат
     */
    public static boolean delOperation(int p)
    {
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            Transaction transaction = sess.beginTransaction();
            String s = "update Operation set del = 1 where Operation = " + p;
            sess.createSQLQuery(s).executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
            return false;
        }        
        return true;
        
    }
    
    
    /**
     * Сохранить группу  операции
     * @param p - операция
     * @return - операция
     */
    public static OperationGruppa setOperationGruppa(OperationGruppa p)
    {
        if(p.getOperationgruppa()== 0)
            p.setOperationgruppa(null);
        
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
     * Получить список операций
     * @param p - id операции  -1 все
     * @return 
     */
    public static List<OperationGruppa> getListOperationGruppa(int p)
    {
        List<OperationGruppa> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            if(p == -1)
                ls = sess.createCriteria(OperationGruppa.class).add(Restrictions.eq("del", 0)).addOrder(Order.asc("name")).list();            
            else
                ls = sess.createCriteria(OperationGruppa.class).add(Restrictions.eq("operationgruppa", p)).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Удалить операцию
     * @param p - ид операции
     * @return - результат
     */
    public static boolean delOperationGruppa(int p)
    {
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            Transaction transaction = sess.beginTransaction();
            String s = "update OperationGruppa set del = 1 where OperationGruppa = " + p;
            sess.createSQLQuery(s).executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
            return false;
        }        
        return true;
        
    }
    
    
    /**
     * Удалить описание операции
     * @param op
     * @return 
     */
    public static boolean delOperationText(int op)
    {
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            Transaction transaction = sess.beginTransaction();
            String s = "delete from OPERATIONTEXT where OPERATIONTEXT = " + op;
            sess.createSQLQuery(s).executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
            return false;
        }        
        return true;
    }
    
    /**
     * Получить список описаний операций     * 
     * @param p
     * @return 
     */
    public static List<OperationText> getListOperationText(int p)
    {
        List<OperationText> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            if(p == -1)
                ls = sess.createCriteria(OperationText.class).addOrder(Order.asc("text")).list();            
            else
                ls = sess.createCriteria(OperationText.class).add(Restrictions.eq("operationtext", p)).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Сохранить строку описания операции
     * @param str - строка
     */
    public static void setOperationText(String str)
    {
        List<OperationText> ls;// = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(OperationText.class).add(Restrictions.eq("text",str)).list();            
            if(ls.isEmpty())
            {
                OperationText ot = new OperationText();
                ot.setOperationtext(null);
                ot.setText(str);
                Transaction transaction = sess.beginTransaction();
                sess.saveOrUpdate(ot);
                transaction.commit();
            }
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
    }
    
}
