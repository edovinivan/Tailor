/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.example.logic.RabotnikGruppa;
import org.example.logic.ZadachaKomplektovka;
import org.example.logic.ZadachaKomplektovkaPretenzia;
import org.example.logic.ZadachaKomplektovkaPretenziaRazmer;
import org.example.logic.ZadachaKomplektovkaRazmeri;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ivan
 */
public class IOZadachaKomplektovkaPretenzia {
    /**
     * Сохранить претензию
     * @param p - объект
     * @return - объект
     */
    public static ZadachaKomplektovkaPretenzia setZadachaKomplektovkaPretenzia(ZadachaKomplektovkaPretenzia p)
    {
        if(p.getZkpretenzia()== 0)
            p.setZkpretenzia(null);
        
        
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
     * Сохранить строку претензии
     * @param p - объект
     * @return - объект
     */
    public static ZadachaKomplektovkaPretenziaRazmer setZadachaKomplektovkaPretenziaRazmer(ZadachaKomplektovkaPretenziaRazmer p)
    {
        if(p.getZkpretenziarazmer()== 0)
            p.setZkpretenziarazmer(null);
        
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
     * Получить претензию
     * @param z - номер
     * @return 
     */
    public static ZadachaKomplektovkaPretenzia getZadachaKomplektovkaPretenzia(int z)
    {
        List<ZadachaKomplektovkaPretenzia> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(ZadachaKomplektovkaPretenzia.class).add(Restrictions.eq("zkpretenzia", z)).list();            
            if(ls.isEmpty())
                ls.add(new ZadachaKomplektovkaPretenzia(0));
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
            ls.add(new ZadachaKomplektovkaPretenzia(0));
        }        
        return ls.get(0);        
    }
    
    /**
     * Получить претензию по номеру комплектовки
     * @param k - номер комплектовки
     * @return 
     */
    public static ZadachaKomplektovkaPretenzia getZadachaKomplektovkaPretenziaForKomplektovka(int k)
    {
        List<ZadachaKomplektovkaPretenzia> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(ZadachaKomplektovkaPretenzia.class).add(Restrictions.eq("zadachakomplektovka", new ZadachaKomplektovka(k))).list();            
            if(ls.isEmpty())
                ls.add(new ZadachaKomplektovkaPretenzia(0));
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
            ls.add(new ZadachaKomplektovkaPretenzia(0));
        }        
        return ls.get(0);        
    }
    
    /**
     * Получить список претензий для цеха или 0 - все     
     * @return 
     */
    public static List<ZadachaKomplektovkaPretenzia> getListZadachaKomplektovkaPretenziaForChex()
    {
        //int chex = IOOperator.operator.getRabotnikgruppa().getRabotnikgruppa();
        RabotnikGruppa rg = IOOperator.operator.getRabotnikgruppa();
        
        //System.out.println("wewewe> " + chex);
        
        List<ZadachaKomplektovkaPretenzia> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            if(rg.getRabotnikgruppa()==0)
                ls = sess.createCriteria(ZadachaKomplektovkaPretenzia.class).addOrder(Order.desc("date1")).list();            
            else    
                ls = sess.createCriteria(ZadachaKomplektovkaPretenzia.class).createAlias("zadachakomplektovka", "zk").add(Restrictions.eq("zk.chek", rg)).addOrder(Order.desc("date1")).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    
    /**
     * Получить список претензий для цеха или 0 - все     
     * @return 
     */
    public static List<ZadachaKomplektovkaPretenzia> getListZadachaKomplektovkaPretenziaForChex1()
    {
        int chex = IOOperator.operator.getRabotnikgruppa().getRabotnikgruppa();
        List<ZadachaKomplektovkaPretenzia> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            if(chex==0)
                ls = sess.createCriteria(ZadachaKomplektovkaPretenzia.class).add(Restrictions.gt("status", 4)).add(Restrictions.lt("status", 11)).addOrder(Order.desc("date1")).list();            
            else    
                ls = sess.createCriteria(ZadachaKomplektovkaPretenzia.class).add(Restrictions.gt("status", 4)).add(Restrictions.lt("status", 11)).createAlias("zadachakomplektovka", "zk").add(Restrictions.eq("zk.chek", chex)).addOrder(Order.desc("date1")).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    
    /**
     * Получить претензию для комплектовки
     * @param zk - номер комплектовки
     * @return 
     */
    public static ZadachaKomplektovkaPretenzia getPretenziaForZadachaKomplektovka(int zk)
    {
        List<ZadachaKomplektovkaPretenzia> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(ZadachaKomplektovkaPretenzia.class).add(Restrictions.eq("zadachakomplektovka", new ZadachaKomplektovka(zk))).list();            
            if(ls.isEmpty())
                ls.add(new ZadachaKomplektovkaPretenzia(0));
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
            ls.add(new ZadachaKomplektovkaPretenzia(0));
        }        
        return ls.get(0);        
    }
    
    /**
     * Удалить претензию
     * @param p - претензия
     * @return 
     */
    public static boolean delPretenzia(ZadachaKomplektovkaPretenzia p)
    {
        if(p.getZkpretenzia() == 0)
            return true;
        try 
        {
            
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            sess.beginTransaction();            
            sess.delete(p);
            sess.beginTransaction().commit();
            
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
            return false;
        }        
        return true;
    }
    
    /**
     * Получить строки претензии
     * @param z - номер
     * @return 
     */
    public static List<ZadachaKomplektovkaPretenziaRazmer> getListZKPretenziaRazmer(int z)
    {
        List<ZadachaKomplektovkaPretenziaRazmer> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(ZadachaKomplektovkaPretenziaRazmer.class).add(Restrictions.eq("zkpretenzia", new ZadachaKomplektovkaPretenzia(z))).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Создание новой претензии
     * @param zk - номер комплектовки
     * @return 
     */
    public static ZadachaKomplektovkaPretenzia createNewZKP(int zk)
    {        
        ZadachaKomplektovkaPretenzia zp = new ZadachaKomplektovkaPretenzia();
        //getZadachaKomplektovkaPretenziaForKomplektovka(zk);
        zp.setZkpretenzia(0);
        if(zp.getZkpretenzia()==0)
        {
            zp.setDate1(new Date());
            zp.setDate2(new Date());
            zp.setDate3(new Date());
            zp.setDateget(new Date());
            zp.setDatereturn(new Date());
            zp.setDatesclad(new Date());
            zp.setQty(0);
            zp.setScladqty(0);
            zp.setStatus(0);
            zp.setZadachakomplektovka(new ZadachaKomplektovka(zk));
            zp.setZkpretenzia(0);
            zp = setZadachaKomplektovkaPretenzia(zp);
            ZadachaKomplektovkaPretenziaRazmer r;
            for (ZadachaKomplektovkaRazmeri z : IOZadachaKomplektovka.getListZadachaKomplektovkaRazmeri(zk)) 
            {
                if(z.getQty()<=0)
                    continue;
                r = new ZadachaKomplektovkaPretenziaRazmer();
                r.setOtvet("");
                r.setQty(0);
                r.setVopros("");
                r.setZkpretenzia(zp);
                r.setZkpretenziarazmer(0);
                r.setZkrazmer(z);
                setZadachaKomplektovkaPretenziaRazmer(r);
            }
        }
        return getZadachaKomplektovkaPretenzia(zp.getZkpretenzia());
    }
    
    /**
     * Удалить лишние строки из претензии
     * @param zp - номер претензии
     * @return 
     */
    public static int delNullPretenziaRazmer(int zp)
    {
        try {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            sess.beginTransaction();
            for (ZadachaKomplektovkaPretenziaRazmer z : getListZKPretenziaRazmer(zp)) 
            {
                if(z.getQty()<=0)
                {
                    sess.delete(z);
                }                
            }
            sess.beginTransaction().commit();
        } catch (HibernateException e) {
            System.out.println("GER ERROR " + e);
        }
        return 0;
    }
    
    
    /**
     * Удалить претензию
     * @param zkp
     * @return - 1 - ошибка
     */
    public static int delZKPretenzia(int zkp)
    {
        ZadachaKomplektovkaPretenzia z = getZadachaKomplektovkaPretenzia(zkp);
        if(z.getStatus()>1)
            return -1;
        try {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            sess.beginTransaction();
            for (ZadachaKomplektovkaPretenziaRazmer zj : getListZKPretenziaRazmer(zkp)) 
            {
                 sess.delete(zj);
            }
            sess.beginTransaction().commit();
            sess.beginTransaction();
            sess.delete(z);
            sess.beginTransaction().commit();
        } catch (HibernateException e) {
            System.out.println("GER ERROR " + e);
            return -2;
        }
        return 0;
    }
            
    
}
