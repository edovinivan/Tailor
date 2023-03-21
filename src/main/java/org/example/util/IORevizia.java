/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import org.example.logic.Revizia;
import org.example.logic.ReviziaJournal;
import org.example.logic.ScladProduct;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Transaction;

/**
 *
 * @author ivan
 */
public class IORevizia {
    /**
     * Сохранить документ
     * @param p - 
     * @return - 
     */
    public static Revizia setRevizia(Revizia p)
    {
        if(p.getRevizia()== 0)
            p.setRevizia(null);
        
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
    public static List<Revizia> getListRevizia(Date d1, Date d2)
    {
        List<Revizia> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(Revizia.class).add(Restrictions.between("dates", d1, d2)).addOrder(Order.desc("dates")).list();            
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
    public static Revizia getRevizia(int d)
    {
        List<Revizia> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(Revizia.class).add(Restrictions.eq("revizia",d)).list();            
            if(ls.isEmpty())
                ls.add(new Revizia(0));
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
            ls.add(new Revizia(0));
        }        
        return ls.get(0);               
    }
    
    
    /**
     * Удалить документ 
     * @param d
     * @return - результат
     */
    public static boolean delRevizia(int d)
    {
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            Transaction transaction = sess.beginTransaction();
            String s = "delete from reviziajournal where revizia = " + d;
            sess.createSQLQuery(s).executeUpdate();
            transaction.commit();
            
            Transaction transaction1 = sess.beginTransaction();
            s = "delete from revizia where revizia = " + d;
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
    public static ReviziaJournal setReviziaJournal(ReviziaJournal p)
    {
        if(p.getReviziajournal()== 0)
            p.setReviziajournal(null);
        
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
    public static List<ReviziaJournal> getListReviziaJournalForRevizia(int d)
    {
        List<ReviziaJournal> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(ReviziaJournal.class).add(Restrictions.eq("revizia", new Revizia(d))).list();            
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
    public static ReviziaJournal getReviziaJournal(int d)
    {
        List<ReviziaJournal> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(ReviziaJournal.class).add(Restrictions.eq("reviziajournal",d)).list();            
            if(ls.isEmpty())
                ls.add(new ReviziaJournal(0));
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
            ls.add(new ReviziaJournal(0));
        }        
        return ls.get(0);               
    }
    
    
    /**
     * Удалить строку
     * @param d
     * @return - результат
     */
    public static boolean delReviziaJournal(int d)
    {
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            Transaction transaction = sess.beginTransaction();
            String s = "delete from reviziajournal where reviziajournal = " + d;
            sess.createSQLQuery(s).executeUpdate();
            transaction.commit();
            
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
            return false;
        }        
        return true;
        
    }
    
    /**
     * Добавить остатки на складе в ревизию в зависимости от фильтра
     * @param r - номер ревизии
     * @param sclad - место хранения
     * @param product - полотно
     * @return 
     */
    public static boolean addScladProductForRevizia(int r, int sclad, int product)
    {
        ReviziaJournal rj;
        for(ScladProduct sp : IOScladProduct.getListScladProduct(1, 1, product, 0, 0, 0, sclad, ""))
        {
            rj = new ReviziaJournal();
            rj.setRevizia(new Revizia(r));
            rj.setReviziajournal(0);
            rj.setScladproduct(sp);
            rj.setVes(BigDecimal.ZERO);
            rj.setVesdb(sp.getVes());
            setReviziaJournal(rj);
        }
        return true;
    }
    
    
    /**
     * Очистить ревизию
     * @param r
     * @return 
     */
    public static boolean clearRevizia(int r)
    {
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            Transaction transaction = sess.beginTransaction();
            String s = "delete from reviziajournal where revizia = " + r;
            sess.createSQLQuery(s).executeUpdate();
            transaction.commit();
            
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
            return false;
        }        
        return true;
    }
    
    /**
     * Изменить количество найденорго полотна в строке
     * @param rj
     * @param qty
     * @return 
     */
    public static boolean updateQtyForReviziaJournal(int rj, BigDecimal qty)
    {
        ReviziaJournal r = getReviziaJournal(rj);
        r.setVes(qty);
        setReviziaJournal(r);
        return true;
    }
    
    /**
     * Очистить ревизию
     * @param r
     * @return 
     */
    public static boolean nullRevizia(int r)
    {
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            Transaction transaction = sess.beginTransaction();
            String s = "update reviziajournal set ves = vesdb where revizia = " + r;
            sess.createSQLQuery(s).executeUpdate();
            transaction.commit();
            
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
            return false;
        }        
        return true;
    }
    
    /**
     * Отработать ревизию
     * @param r
     * @return 
     */
    public static boolean closeRevizia(int r)
    {
        Revizia rev = getRevizia(r);
        if(rev.getStatus()!=0)
        {
            JOptionPane.showMessageDialog(null, "Инвентаризация уже закрыта");
            return false;
        }
        // проверим что их не взяли в работу
        for(ReviziaJournal rj: getListReviziaJournalForRevizia(r))
        {
            if(rj.getScladproduct().getStatus()!=1)
            {
                JOptionPane.showMessageDialog(null, "Полотно <" + rj.getScladproduct().getPasport()+ " - " + rj.getScladproduct().getProduct().getName() + "> уже использованно.");
                return false;
            }
        }
        for(ReviziaJournal rj: getListReviziaJournalForRevizia(r))
        {            
            if(rj.getVes().compareTo(rj.getVesdb())!=0)
            {
                rj.getScladproduct().setVes(rj.getScladproduct().getVes().add(rj.getVes().subtract(rj.getVesdb())));
                if(rj.getVes().signum()==0)
                    rj.getScladproduct().setStatus(2);
                IOScladProduct.setScladProduct(rj.getScladproduct());                
            }
        }
        rev.setStatus(1);
        setRevizia(rev);
        return true;
    }
    
    /**
     * Открыть ревизию
     * @param r
     * @return 
     */
    public static boolean openRevizia(int r)
    {
        Revizia rev = getRevizia(r);
        if(rev.getStatus()!=1)
        {
            JOptionPane.showMessageDialog(null, "Инвентаризация уже открыта");
            return false;
        }
        // проверим что их не взяли в работу
        for(ReviziaJournal rj: getListReviziaJournalForRevizia(r))
        {
            if(rj.getScladproduct().getStatus()!=1)
            {
                JOptionPane.showMessageDialog(null, "Полотно <" + rj.getScladproduct().getPasport()+ " - " + rj.getScladproduct().getProduct().getName() + "> уже использован.");
                return false;
            }
        }
        for(ReviziaJournal rj: getListReviziaJournalForRevizia(r))
        {            
            if(rj.getVes().compareTo(rj.getVesdb())!=0)
            {
                rj.getScladproduct().setVes(rj.getScladproduct().getVes().subtract(rj.getVes().subtract(rj.getVesdb())));
                IOScladProduct.setScladProduct(rj.getScladproduct());                
            }
        }
        rev.setStatus(0);
        setRevizia(rev);
        return true;
    }
}
