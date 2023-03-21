/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.util.analit;

import java.util.ArrayList;
import java.util.List;
import org.example.logic.Razmeri;
import org.example.logic.analit.aArticle;
import org.example.logic.analit.aColor;
import org.example.logic.analit.aGruppa1;
import org.example.logic.analit.aGruppa2;
import org.example.logic.analit.aJournal;
import org.example.logic.analit.aRazmer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.example.util.HibernateUtil;
import org.example.util.IORazmeri;
import org.hibernate.Transaction;

/**
 *
 * @author ivan
 * Работа с таблицами аналитики
 */
public class IOAHelp {
    
    /**
     * Сохранить группу1
     * @param ag
     * @return 
     */
    public static aGruppa1 setGruppa1(aGruppa1 ag)
    {
        if(ag.getA_gruppa1()==0)
            ag.setA_gruppa1(null);
        Session sess = HibernateUtil.getSessionFactory().openSession();
        try 
        {
            Transaction transaction = sess.beginTransaction();
            sess.saveOrUpdate(ag);
            transaction.commit();
            
        }catch(HibernateException e)
        {
            System.out.println("ERROR SAVE" + e);            
        }
        return ag;
    }
    
    /**
     * Получить список объектов     
     * @return 
     */
    public static List<aGruppa1> getListGruppa1()
    {
        List<aGruppa1> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(aGruppa1.class).addOrder(Order.asc("name")).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Получить группу 1
     * @param g - номер группы
     * @return 
     */
    public static aGruppa1 getGruppa1(int g)
    {
        List<aGruppa1> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(aGruppa1.class).add(Restrictions.eq("a_gruppa1", g)).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        if(ls.isEmpty())
            ls.add(new aGruppa1(0));
        return ls.get(0);        
    }
    
    /**
     * Получить группу 1 по названию
     * @param name - название
     * @return 
     */
    public static aGruppa1 getGruppa1(String name)
    {
        if(name == null)
            return new aGruppa1(-1);
        if(name.isEmpty())
            return new aGruppa1(-1);
        
        List<aGruppa1> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(aGruppa1.class).add(Restrictions.eq("name", name)).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        if(ls.isEmpty())
            ls.add(new aGruppa1(0));
        return ls.get(0);        
    }
    
    /**
     * Сохранить группу2
     * @param ag
     * @return 
     */
    public static aGruppa2 setGruppa2(aGruppa2 ag)
    {
        if(ag.getA_gruppa2()==0)
            ag.setA_gruppa2(null);
        Session sess = HibernateUtil.getSessionFactory().openSession();
        try 
        {
            Transaction transaction = sess.beginTransaction();
            sess.saveOrUpdate(ag);
            transaction.commit();
            
        }catch(HibernateException e)
        {
            System.out.println("ERROR SAVE" + e);            
        }
        return ag;
    }
    
    /**
     * Получить список объектов     
     * @return 
     */
    public static List<aGruppa2> getListGruppa2()
    {
        List<aGruppa2> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(aGruppa2.class).addOrder(Order.asc("name")).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Получить группу 2
     * @param g - номер группы
     * @return 
     */
    public static aGruppa2 getGruppa2(int g)
    {
        List<aGruppa2> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(aGruppa2.class).add(Restrictions.eq("a_gruppa2", g)).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        if(ls.isEmpty())
            ls.add(new aGruppa2(0));
        return ls.get(0);        
    }
    
    /**
     * Получить группу 2 по названию
     * @param name - название
     * @return 
     */
    public static aGruppa2 getGruppa2(String name)
    {
        if(name == null)
            return new aGruppa2(-1);
        if(name.isEmpty())
            return new aGruppa2(-1);
        
        List<aGruppa2> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(aGruppa2.class).add(Restrictions.eq("name", name)).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        if(ls.isEmpty())
            ls.add(new aGruppa2(0));
        return ls.get(0);        
    }
    
    /**
     * Сохранить артикул
     * @param ag
     * @return 
     */
    public static aArticle setaArticle(aArticle ag)
    {
        if(ag.getA_article()==0)
            ag.setA_article(null);
        Session sess = HibernateUtil.getSessionFactory().openSession();
        try 
        {
            Transaction transaction = sess.beginTransaction();
            sess.saveOrUpdate(ag);
            transaction.commit();
            
        }catch(HibernateException e)
        {
            System.out.println("ERROR SAVE" + e);            
        }
        return ag;
    }
    
    /**
     * Получить список объектов     
     * @return 
     */
    public static List<aArticle> getListArticle()
    {
        List<aArticle> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(aArticle.class).addOrder(Order.asc("article")).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Получить артикул
     * @param g - номер 
     * @return 
     */
    public static aArticle getArticle(int g)
    {
        List<aArticle> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(aArticle.class).add(Restrictions.eq("a_article", g)).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        if(ls.isEmpty())
            ls.add(new aArticle(0));
        return ls.get(0);        
    }
    
    /**
     * Получить артикул по названию
     * @param name - название
     * @return 
     */
    public static aArticle getArticle(String name)
    {
        if(name == null)
            return new aArticle(-1);
        if(name.isEmpty())
            return new aArticle(-1);
        
        List<aArticle> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(aArticle.class).add(Restrictions.eq("article", name)).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        if(ls.isEmpty())
            ls.add(new aArticle(0));
        return ls.get(0);        
    }
    
     /**
     * Сохранить цвет
     * @param ag
     * @return 
     */
    public static aColor setaColor(aColor ag)
    {
        if(ag.getA_color()==0)
            ag.setA_color(null);
        Session sess = HibernateUtil.getSessionFactory().openSession();
        try 
        {
            Transaction transaction = sess.beginTransaction();
            sess.saveOrUpdate(ag);
            transaction.commit();
            
        }catch(HibernateException e)
        {
            System.out.println("ERROR SAVE" + e);            
        }
        return ag;
    }
    
    /**
     * Получить список объектов     
     * @return 
     */
    public static List<aColor> getListColor()
    {
        List<aColor> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(aColor.class).addOrder(Order.asc("name")).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Получить цвет
     * @param g - номер 
     * @return 
     */
    public static aColor getColor(int g)
    {
        List<aColor> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(aColor.class).add(Restrictions.eq("a_color", g)).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        if(ls.isEmpty())
            ls.add(new aColor(0));
        return ls.get(0);        
    }
    
    /**
     * Получить цвет по названию
     * @param name - название
     * @return 
     */
    public static aColor getColor(String name)
    {
        if(name == null)
            return new aColor(-1);
        if(name.isEmpty())
            return new aColor(-1);
        
        List<aColor> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(aColor.class).add(Restrictions.eq("name", name)).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        if(ls.isEmpty())
            ls.add(new aColor(0));
        return ls.get(0);        
    }
    
    
     /**
     * Сохранить размер
     * @param ag
     * @return 
     */
    public static aRazmer setaRazmer(aRazmer ag)
    {
        if(ag.getA_razmer()==0)
            ag.setA_razmer(null);
        Session sess = HibernateUtil.getSessionFactory().openSession();
        try 
        {
            Transaction transaction = sess.beginTransaction();
            sess.saveOrUpdate(ag);
            transaction.commit();
            
        }catch(HibernateException e)
        {
            System.out.println("ERROR SAVE" + e);            
        }
        return ag;
    }
    
    /**
     * Получить список объектов     
     * @return 
     */
    public static List<aRazmer> getListRazmer()
    {
        List<aRazmer> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(aRazmer.class).addOrder(Order.asc("name")).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Получить размер
     * @param g - номер 
     * @return 
     */
    public static aRazmer getRazmer(int g)
    {
        List<aRazmer> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(aRazmer.class).add(Restrictions.eq("a_razmer", g)).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        if(ls.isEmpty())
            ls.add(new aRazmer(0));
        return ls.get(0);        
    }
    
    /**
     * Получить размер по названию
     * @param name - название
     * @return 
     */
    public static aRazmer getRazmer(String name)
    {
        if(name == null)
            return new aRazmer(-1);
        if(name.isEmpty())
            return new aRazmer(-1);
        
        List<aRazmer> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(aRazmer.class).add(Restrictions.eq("name", name)).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        if(ls.isEmpty())
            ls.add(new aRazmer(0));
        return ls.get(0);        
    }
    /**
     * Сохранить строку
     * @param ag
     * @return 
     */
    public static aJournal setaJournal(aJournal ag)
    {
        if(ag.getA_journal()==0)
            ag.setA_journal(null);
        Session sess = HibernateUtil.getSessionFactory().openSession();
        try 
        {
            Transaction transaction = sess.beginTransaction();
            sess.saveOrUpdate(ag);
            transaction.commit();
            
        }catch(HibernateException e)
        {
            System.out.println("ERROR SAVE" + e);            
        }
        return ag;
    }
    
    /**
     * Получить список объектов     
     * @return 
     */
    public static List<aJournal> getListJournal()
    {
        List<aJournal> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(aJournal.class).addOrder(Order.asc("dates")).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Получить Строку
     * @param g - номер 
     * @return 
     */
    public static aJournal getJournal(int g)
    {
        List<aJournal> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(aJournal.class).add(Restrictions.eq("a_journal", g)).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        if(ls.isEmpty())
            ls.add(new aJournal(0));
        return ls.get(0);        
    }
    
    /**
     * Получить строку по id
     * @param id - id
     * @return 
     */
    public static aJournal getJournalForId(String id)
    {
        if(id == null)
            return new aJournal(-1);
        if(id.isEmpty())
            return new aJournal(-1);
        
        List<aJournal> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(aJournal.class).add(Restrictions.eq("id", id)).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        if(ls.isEmpty())
            ls.add(new aJournal(0));
        return ls.get(0);        
    }
    
    /**
     * Привязать цвет из тейлора к цвету 1С
     * @param aColor - цвет 1с
     * @param color - цвет в базе
     * @return 
     */
    public static aColor snapColor(int aColor, int color)
    {
        List<aColor> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            String sql = "update A_COLOR set ID_COLOR = " + color + "where A_COLOR = " + aColor;
            Transaction transaction = sess.beginTransaction();
            sess.createSQLQuery(sql).executeUpdate();
            transaction.commit();
            
            ls = sess.createCriteria(aColor.class).add(Restrictions.eq("a_color", aColor)).list();                        
            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }   
        return  ls.get(0);
    }
    
    /**
     * Привязать размер из 1с к размеру тэйлор
     * @param aRazmer - размер 1С
     * @param razmer - размер тэйлор
     */
    public static void snapRazmer(int aRazmer, int razmer)
    {
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            String sql = "update A_RAZMER set RAZMER = " + razmer + "where A_RAZMER = " + aRazmer;
            Transaction transaction = sess.beginTransaction();
            sess.createSQLQuery(sql).executeUpdate();
            transaction.commit();
            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }   
    }
    
    
    /**
     * Получить размеры 1С
     * @return 
     */
    public static List<aRazmer> getListARazmer()
    {
        List<aRazmer> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(aRazmer.class).addOrder(Order.asc("name")).list();                        
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }   
        return ls;
    }
    
    
    /**
     * Привязать модель из тейлора к артикулу 1С
     * @param aArticle - артикул в 1С
     * @param model - модель в тейлоре
     * @return 
     */
    public static aArticle snapArticle(int aArticle, int model)
    {
        
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            String sql = "update A_ARTICLE set ID_MODEL = " + model + "where A_ARTICLE = " + aArticle;
            Transaction transaction = sess.beginTransaction();
            sess.createSQLQuery(sql).executeUpdate();
            transaction.commit();
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }   
        return  getArticle(aArticle);
    }
    
    /**
     * Привязать размер из тейлора к размеру 1С
     * @param aRazmer - размер 1С
     * @param razmer - размер из программы
     * @return 
     */
    public static Razmeri snapRazmeri(int aRazmer, int razmer)
    {
        
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            String sql = "update RAZMERI set A_RAZMER = " + aRazmer + "where RAZMERI = " + razmer;
            Transaction transaction = sess.beginTransaction();
            sess.createSQLQuery(sql).executeUpdate();
            transaction.commit();
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }   
        return  IORazmeri.getListRazmeri(razmer).get(0);
    }
}
