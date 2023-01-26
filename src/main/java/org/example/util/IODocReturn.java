/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.util;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import org.example.logic.DocReturn;
import org.example.logic.DocReturnJournal;
import org.example.logic.ScladProduct;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ivan
 */
public class IODocReturn {
    /**
     * Получить максимальный номер для документа возврата
     * @return 
     */
    public static int getMaxNomerForDocReturn()
    {
        Session sess = HibernateUtil.getSessionFactory().openSession();
        Integer m = 0;
        try 
        {            
            String s = "select max(doc_return) from doc_return";
            m =  (Integer)sess.createSQLQuery(s).uniqueResult();
            
        }catch(HibernateException e)
        {
            System.out.println("ERROR SAVE" + e);            
        }
        return m+1;
    }
    /**
     * Сохранить документ
     * @param p - 
     * @return - 
     */
    public static DocReturn setDocReturn(DocReturn p)
    {
        if(p.getDocreturn()== 0)
            p.setDocreturn(null);
        
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
     * Получить список 
     * @param d1
     * @param d2
     * @return 
     */
    public static List<DocReturn> getListDocReturn(Date d1, Date d2)
    {
        List<DocReturn> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(DocReturn.class).add(Restrictions.between("dates", d1, d2)).addOrder(Order.desc("dates")).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    
    /**
     * Получить документ
     * @param d = id
     * @return 
     */
    public static DocReturn getDocReturn(int d)
    {
        List<DocReturn> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(DocReturn.class).add(Restrictions.eq("docreturn",d)).list();            
            if(ls.isEmpty())
                ls.add(new DocReturn(0));
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
            ls.add(new DocReturn(0));
        }        
        return ls.get(0);               
    }
    
    
    /**
     * Удалить документ 
     * @param d
     * @return - результат
     */
    public static boolean delDocReturn(int d)
    {
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            Transaction transaction = sess.beginTransaction();
            String s = "delete from doc_return_journal where doc_return = " + d;
            sess.createSQLQuery(s).executeUpdate();
            transaction.commit();
            
            Transaction transaction1 = sess.beginTransaction();
            s = "delete from doc_return where doc_return = " + d;
            sess.createSQLQuery(s).executeUpdate();
            transaction1.commit();
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
            return false;
        }        
        return true;
        
    }
    
    /**
     * Сохранить документ
     * @param p - 
     * @return - 
     */
    public static DocReturnJournal setDocReturnJournal(DocReturnJournal p)
    {
        if(p.getDocreturnjournal()== 0)
            p.setDocreturnjournal(null);
        
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
     * Получить список 
     * @param d
     * @return 
     */
    public static List<DocReturnJournal> getListDocReturnJournalForDocument(int d)
    {
        List<DocReturnJournal> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(DocReturnJournal.class).add(Restrictions.eq("docreturn", new DocReturn(d))).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    
    /**
     * Получить строку
     * @param d = id
     * @return 
     */
    public static DocReturnJournal getDorReturnJournal(int d)
    {
        List<DocReturnJournal> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(DocReturnJournal.class).add(Restrictions.eq("docreturnjournal",d)).list();            
            if(ls.isEmpty())
                ls.add(new DocReturnJournal(0));
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
            ls.add(new DocReturnJournal(0));
        }        
        return ls.get(0);               
    }
    
    
    /**
     * Удалить строку
     * @param d
     * @return - результат
     */
    public static boolean delDocReturnJournal(int d)
    {
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            Transaction transaction = sess.beginTransaction();
            String s = "delete from doc_return_journal where doc_return_journal = " + d;
            sess.createSQLQuery(s).executeUpdate();
            transaction.commit();
            
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
            return false;
        }        
        return true;
        
    }
    
    
    /**
     * Проверить было ли добавлено полотно для списания     
     * @param sp
     * @return 
     */
    public static boolean testScladProductForDocReturn(int sp)
    {
        BigInteger r  = BigInteger.ZERO;
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();             
            String s = "select count(doc_return_journal) from doc_return_journal where scladproduct = " + sp;
            r = (BigInteger)sess.createSQLQuery(s).uniqueResult();
            
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
            return false;
        }        
        return r.intValue() !=0;
    }
    
    /**
     * Провести документ возврата
     * @param d - номер документа
     * @return 
     */
    public static boolean closeDocReturn(int d)
    {
        DocReturn dr = getDocReturn(d);
        if(dr.getStatus()!=0)
        {
            JOptionPane.showConfirmDialog(null, "Документ уже отработан.");
            return false;
        }
        //посмотрим что все полотна свободны
        for(DocReturnJournal dj: getListDocReturnJournalForDocument(d))
        {
            if(dj.getScladproduct().getStatus()!=1)
            {
                JOptionPane.showMessageDialog(null, "Полотно <"+dj.getScladproduct().getProduct().getName() + "> Паспорт<"+dj.getScladproduct().getPasport()+"> уже использовано!");
                return false;
            }
        }
        ScladProduct  sp;
        // отметим рулоны как взятые со склада
        for(DocReturnJournal dj: getListDocReturnJournalForDocument(d))
        {
            sp = dj.getScladproduct();
            sp.setStatus(2);
            IOScladProduct.setScladProduct(sp);
        }
        dr.setStatus(1);
        setDocReturn(dr);
        return true;
    }
    
    /**
     * Открыть документ возврата
     * @param d - номер документа
     * @return 
     */
    public static boolean openDocReturn(int d)
    {
        DocReturn dr = getDocReturn(d);
        if(dr.getStatus()!=1)
        {
            JOptionPane.showConfirmDialog(null, "Документ уже открыт");
            return false;
        }
        
        ScladProduct  sp;
        // отметим рулоны как взятые со склада
        for(DocReturnJournal dj: getListDocReturnJournalForDocument(d))
        {
            sp = dj.getScladproduct();
            sp.setStatus(1);
            IOScladProduct.setScladProduct(sp);
        }
        dr.setStatus(0);
        setDocReturn(dr);
        return true;
    }
}
