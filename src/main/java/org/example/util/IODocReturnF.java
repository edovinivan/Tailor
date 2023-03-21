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
import org.example.logic.DocReturnF;
import org.example.logic.DocReturnFJournal;
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
public class IODocReturnF {
    /**
     * Получить максимальный номер для документа возврата
     * @return 
     */
    public static int getMaxNomerForDocReturnF()
    {
        Session sess = HibernateUtil.getSessionFactory().openSession();
        Integer m = 0;
        try 
        {            
            String s = "select max(doc_returnf) from doc_returnf";
            m =  (Integer)sess.createSQLQuery(s).uniqueResult();
            if(m == null)
                m = 0;
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
    public static DocReturnF setDocReturnF(DocReturnF p)
    {
        if(p.getDocreturnf()== 0)
            p.setDocreturnf(null);
        
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
    public static List<DocReturnF> getListDocReturnF(Date d1, Date d2)
    {
        List<DocReturnF> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(DocReturnF.class).add(Restrictions.between("dates", d1, d2)).addOrder(Order.desc("dates")).list();            
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
    public static DocReturnF getDocReturnF(int d)
    {
        List<DocReturnF> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(DocReturnF.class).add(Restrictions.eq("docreturnf",d)).list();            
            if(ls.isEmpty())
                ls.add(new DocReturnF(0));
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
            ls.add(new DocReturnF(0));
        }        
        return ls.get(0);               
    }
    
    
    /**
     * Удалить документ 
     * @param d
     * @return - результат
     */
    public static boolean delDocReturnF(int d)
    {
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            Transaction transaction = sess.beginTransaction();
            String s = "delete from doc_returnf_journal where doc_returnf = " + d;
            sess.createSQLQuery(s).executeUpdate();
            transaction.commit();
            
            Transaction transaction1 = sess.beginTransaction();
            s = "delete from doc_returnf where doc_returnf = " + d;
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
    public static DocReturnFJournal setDocReturnFJournal(DocReturnFJournal p)
    {
        if(p.getDocreturnfjournal()== 0)
            p.setDocreturnfjournal(null);
        
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
    public static List<DocReturnFJournal> getListDocReturnFJournalForDocument(int d)
    {
        List<DocReturnFJournal> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(DocReturnFJournal.class).add(Restrictions.eq("docreturnf", new DocReturnF(d))).list();            
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
    public static DocReturnFJournal getDorReturnFJournal(int d)
    {
        List<DocReturnFJournal> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(DocReturnFJournal.class).add(Restrictions.eq("docreturnfjournal",d)).list();            
            if(ls.isEmpty())
                ls.add(new DocReturnFJournal(0));
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
            ls.add(new DocReturnFJournal(0));
        }        
        return ls.get(0);               
    }
    
    
    /**
     * Удалить строку
     * @param d
     * @return - результат
     */
    public static boolean delDocReturnFJournal(int d)
    {
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            Transaction transaction = sess.beginTransaction();
            String s = "delete from doc_returnf_journal where doc_returnf_journal = " + d;
            sess.createSQLQuery(s).executeUpdate();
            transaction.commit();
            
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
            return false;
        }        
        return true;
        
    }
    
    
    /**
     * Проверить была ли добавлена фурнитура для списания     
     * @param sp - номер строки на складе
     * @param d - номер документа
     * @return 
     */
    public static boolean testScladProductForDocReturnF(int sp, int d)
    {
        BigInteger r  = BigInteger.ZERO;
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();             
            String s = "select count(doc_returnf_journal) from doc_returnf_journal where  scladproduct = " + sp + " and doc_returnf = " + d;
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
    public static boolean closeDocReturnF(int d)
    {
        DocReturnF dr = getDocReturnF(d);
        if(dr.getStatus()!=0)
        {
            JOptionPane.showConfirmDialog(null, "Документ уже отработан.");
            return false;
        }
        List<DocReturnFJournal> ls = getListDocReturnFJournalForDocument(d);
        if(ls.isEmpty())
        {
            JOptionPane.showConfirmDialog(null, "У документа нет строк!");
            return false;
        }
        // посмотрим что фурнитуры хватает для возврата
        for(DocReturnFJournal j: ls)
        {
            if(j.getQty().compareTo(j.getScladproduct().getWidth())>0)
            {
                JOptionPane.showConfirmDialog(null, "Фурнитуры <" + j.getScladproduct().getProduct().getName() + "> нехватает на остатке для возврата!");
                return false;
            }
        }        
        ScladProduct  sp;
        // вычтем количество из остатков
        for(DocReturnFJournal j: ls)
        {
            sp = j.getScladproduct();
            sp.setWidth(sp.getWidth().subtract(j.getQty()));
            if(sp.getWidth().signum() ==0)
                sp.setStatus(2);
            IOScladProduct.setScladProduct(sp);
        }
        dr.setStatus(1);
        setDocReturnF(dr);
        return true;
    }
    
    /**
     * Открыть документ возврата
     * @param d - номер документа
     * @return 
     */
    public static boolean openDocReturnF(int d)
    {
        DocReturnF dr = getDocReturnF(d);
        if(dr.getStatus()!=1)
        {
            JOptionPane.showConfirmDialog(null, "Документ уже открыт.");
            return false;
        }
        List<DocReturnFJournal> ls = getListDocReturnFJournalForDocument(d);
        if(ls.isEmpty())
        {
            JOptionPane.showConfirmDialog(null, "У документа нет строк!");
            return false;
        }            
        ScladProduct  sp;
        // прибавим количество к остатков
        for(DocReturnFJournal j: ls)
        {
            sp = j.getScladproduct();
            sp.setWidth(sp.getWidth().add(j.getQty()));
            if(sp.getStatus() == 2)
                sp.setStatus(1);
            IOScladProduct.setScladProduct(sp);
        }
        dr.setStatus(0);
        setDocReturnF(dr);
        return true;
    }/**/
    
}
