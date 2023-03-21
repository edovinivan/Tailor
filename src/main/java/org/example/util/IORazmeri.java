/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.util;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.example.logic.Model;
import org.example.logic.Razmeri;
import org.example.logic.RazmeriGruppa;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Transaction;

/**
 *
 * @author ivan
 */
public class IORazmeri {
    /**
     * Сохранить объект
     * @param p - объект
     * @return - объект
     */
    public static Razmeri setRazmeri(Razmeri p)
    {
        
        Session sess = HibernateUtil.getSessionFactory().openSession();
        try 
        {
            if(p.getNom()==0)
            {
                Transaction transaction = sess.beginTransaction();
                String s = "select coalesce(max(nom),0)+1 from razmeri where del = 0 and razmerigruppa = " + p.getRazmerigruppa().getRazmerigruppa();
                int mn = ((BigInteger)sess.createSQLQuery(s).uniqueResult()).intValue();
                transaction.commit();
                p.setNom(mn);
            }
            
            if(p.getRazmeri()== 0)
            {
                Transaction transaction = sess.beginTransaction();
                String s = "update Razmeri set nom = nom + 1 where Razmerigruppa = " + p.getRazmerigruppa().getRazmerigruppa() + " and nom >=" + p.getNom() + " and del = 0";
                sess.createSQLQuery(s).executeUpdate();
                transaction.commit();
                p.setRazmeri(null);
            }
            
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
     * @param p - id объекта
     * @return 
     */
    public static List<Razmeri> getListRazmeri(int p)
    {
        List<Razmeri> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            if(p == -1)
                ls = sess.createCriteria(Razmeri.class).add(Restrictions.eq("del", 0)).addOrder(Order.asc("razmerigruppa")).addOrder(Order.asc("nom")).list();            
            else
                ls = sess.createCriteria(Razmeri.class).add(Restrictions.eq("razmeri", p)).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    
    /**
     * Получить список всех размеров
     
     * @return 
     */
    public static List<Razmeri> getListAllRazmeri()
    {
        List<Razmeri> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(Razmeri.class).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Получить список размеров для группы
     * @param p - id группы
     * @return 
     */
    public static List<Razmeri> getListRazmeriForGruppa(int p)
    {
        List<Razmeri> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(Razmeri.class).add(Restrictions.eq("del", 0)).add(Restrictions.eq("razmerigruppa", new RazmeriGruppa(p))).addOrder(Order.asc("nom")).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Получить список размеров для группы
     * @param p - id группы
     * @return 
     */
    public static List<Razmeri> getListRazmeriForGruppa1(int p)
    {
        List<Razmeri> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(Razmeri.class).add(Restrictions.eq("razmerigruppa", new RazmeriGruppa(p))).addOrder(Order.asc("nom")).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Удалить объект
     * @param p - ид объекта
     * @return - результат
     */
    public static boolean delRazmeri(int p)
    {
        Razmeri r = getListRazmeri(p).get(0);
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            
            Transaction transaction = sess.beginTransaction();
            String s = "update Razmeri set nom = nom - 1 where nom > " + r.getNom() + " and del = 0" ;
            sess.createSQLQuery(s).executeUpdate();
            transaction.commit();
            
            
            Transaction transaction1 = sess.beginTransaction();
            s = "update Razmeri set del = 1 where Razmeri = " + p;
            sess.createSQLQuery(s).executeUpdate();
            transaction1.commit();
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
            return false;
        }        
        return true;
        
    }
    
    /**
     * Сохранить объект
     * @param p - объект
     * @return - объект
     */
    public static RazmeriGruppa setRazmeriGruppa(RazmeriGruppa p)
    {
        if(p.getRazmerigruppa()== 0)
            p.setRazmerigruppa(null);
        
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
     * @param p - id объекта
     * @return 
     */
    public static List<RazmeriGruppa> getListRazmeriGruppa(int p)
    {
        List<RazmeriGruppa> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            if(p == -1)
                ls = sess.createCriteria(RazmeriGruppa.class).add(Restrictions.eq("del", 0)).addOrder(Order.asc("name")).list();            
            else
                ls = sess.createCriteria(RazmeriGruppa.class).add(Restrictions.eq("razmerigruppa", p)).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Удалить объект
     * @param p - ид объекта
     * @return - результат
     */
    public static boolean delRazmeriGruppa(int p)
    {
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            Transaction transaction = sess.beginTransaction();
            String s = "update RazmeriGruppa set del = 1 where RazmeriGruppa = " + p;
            sess.createSQLQuery(s).executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
            return false;
        }        
        return true;
        
    }
    
    /**
     * Переместить строку вниз
     * @param p
     * @return 
     */
    public static boolean sendRazmeriDown(int p)
    {
        /*Razmeri r = getListRazmeri(p).get(0);
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            List<Razmeri> ls = new ArrayList<>();
            ls = sess.createCriteria(Razmeri.class).add(Restrictions.eq("del", 0)).add(Restrictions.eq("razmerigruppa", r.getRazmerigruppa())).add(Restrictions.eq("nom", r.getNom()+1)).list();            
            // если нет 
            if(ls.isEmpty())
                return false;
            Transaction transaction = sess.beginTransaction();
            String s = "update RazmeriGruppa set del = 1 where RazmeriGruppa = " + p;
            sess.createSQLQuery(s).executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
            return false;
        } */
        return true;
    }
    
    
    /**
     *   Получить список размеров для группы в которую входит первый размер из артикула
     * @param mod
     * @return 
     */
    public static List<Razmeri> getListRazmeriForArticle(int mod){
        Model model = IOModel.getModel(mod);
        List<Razmeri> ls = getListRazmeriForGruppa1(model.getFirstrazmeri().getRazmerigruppa().getRazmerigruppa());
        return ls;
    }
    
}
