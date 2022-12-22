/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.example.logic.ScladProduct;
import org.example.logic.ZadachaFurnitura;
import org.example.logic.ZadachaKomplektovka;
import org.example.logic.ZadachaProduct;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ivan
 */
public class IOZadachaFurnitura {
    
    /**
     * Получить количество набранных элементов для фурнитуры для комплектовки
     * @param komplektovka - номер комплектовки
     * @param zp - номер фурнитуры для комплектовки
     * @return 
     */
    public static int getQtyFurnituraForKomplektovka(int komplektovka, int zp)
    {
        List<ZadachaFurnitura> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(ZadachaFurnitura.class).add(Restrictions.eq("zadachakomplektovka", new ZadachaKomplektovka(komplektovka))).add(Restrictions.eq("zadachaproduct", new ZadachaProduct(zp))).list();            
            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls.size();        
    }
    
    /**
     * Получить фурнитуру для задачи если она уже была добавлена для даноого товара
     * @param zp
     * @param sp - 
     * @param zk 
     * @return 
     */
    public static ZadachaFurnitura getZFForZadachaProduct(int zp, int sp, int zk)
    {
        List<ZadachaFurnitura> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(ZadachaFurnitura.class).add(Restrictions.eq("zadachakomplektovka", new ZadachaKomplektovka(zk))).add(Restrictions.eq("scladproduct", new ScladProduct(sp))).add(Restrictions.eq("zadachaproduct", new ZadachaProduct(zp))).list();            
            if(ls.isEmpty())
                ls.add(new ZadachaFurnitura(0));
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
            ls.add(new ZadachaFurnitura(0));
        }        
        return ls.get(0);
    }
    
    /**
     * Сохранить задачу
     * @param p - объект
     * @return - объект
     */
    public static ZadachaFurnitura setZadachaFurnitura(ZadachaFurnitura p)
    {
        BigDecimal d = p.getQty();
        if(p.getZadachafurnitura()== 0)
            p.setZadachafurnitura(null);
        else // если не новая строка
        {
            ZadachaFurnitura zf = IOZadachaFurnitura.getListZadachaFurnitura(0, p.getZadachafurnitura()).get(0);
            // если количество изменилось
            if(zf.getQty().compareTo(p.getQty())!=0)            
                d = p.getQty().subtract(zf.getQty());
            
        }
        
        Session sess = HibernateUtil.getSessionFactory().openSession();
        try 
        {
            sess.beginTransaction();
            sess.saveOrUpdate(p);
            sess.beginTransaction().commit();
            
            ScladProduct s = p.getScladproduct();
            s.setWidth(s.getWidth().subtract(d));
            s.setStatus(2);
            
            sess.beginTransaction();
            sess.saveOrUpdate(s);
            sess.beginTransaction().commit();
            
        }catch(HibernateException e)
        {
            System.out.println("ERROR SAVE" + e);            
        }
        return p;
    }
    
    
    /**
     * Получить список фурнитур для задачи
     * @param zadacha
     * @param zf -1 все
     * @return 
     */
    public static List<ZadachaFurnitura> getListZadachaFurnitura(int zadacha, int zf)
    {
        List<ZadachaFurnitura> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            if(zf == -1)
                ls = sess.createCriteria(ZadachaFurnitura.class).add(Restrictions.eq("zadacha", zadacha)).list();            
            else
                ls = sess.createCriteria(ZadachaFurnitura.class).add(Restrictions.eq("zadachafurnitura", zf)).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Получить список фурнитур для задачи для конкретной комплектовки
     * @param zf - задача фурнитура  zadachaproduct
     * @param komplektovka - комплектовка zadachakomplektovka
     * @return 
     */
    public static List<ZadachaFurnitura> getListZadachaFurnituraForKomplektovka(int zf, int komplektovka)
    {
        List<ZadachaFurnitura> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(ZadachaFurnitura.class).add(Restrictions.eq("zadachaproduct", new ZadachaProduct(zf))).add(Restrictions.eq("zadachakomplektovka", new ZadachaKomplektovka(komplektovka))).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Получить список фурнитур для конкретной комплектовки
     * @param komplektovka - комплектовка zadachakomplektovka
     * @return 
     */
    public static List<ZadachaFurnitura> getListZadachaFurnituraForKomplektovka(int komplektovka)
    {
        List<ZadachaFurnitura> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(ZadachaFurnitura.class).add(Restrictions.eq("zadachakomplektovka", new ZadachaKomplektovka(komplektovka))).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Получить список фурнитур для товара в задаче
     * @param zadachaproduct     
     * @return 
     */
    public static List<ZadachaFurnitura> getListZadachaFurnituraForZadachaProduct(int zadachaproduct)
    {
        List<ZadachaFurnitura> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(ZadachaFurnitura.class).add(Restrictions.eq("zadachaproduct", new ZadachaProduct(zadachaproduct))).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Получить список фурнитур для товара в комплектовке
     * @param kompl     
     * @param zadachaproduct     
     * @return 
     */
    /*public static List<ZadachaFurnitura> getListZadachaFurnituraForKomplektovka(int kompl, int zadachaproduct)
    {
        List<ZadachaFurnitura> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(ZadachaFurnitura.class).add(Restrictions.eq("zadachakomplektovka", new ZadachaKomplektovka(kompl))).add(Restrictions.eq("zadachaproduct", new ZadachaProduct(zadachaproduct))).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }*/
    
    
    /**
     * Удалить объект
     * @param p - ид объекта
     * @return - результат
     */
    public static boolean delZadachaFurnitura(int p)
    {
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            // изменим количество на складе
            ZadachaFurnitura zf = IOZadachaFurnitura.getListZadachaFurnitura(0, p).get(0);
            ScladProduct sp = zf.getScladproduct();
            sp.setWidth(sp.getWidth().add(zf.getQty()));
            sess.beginTransaction();
            sess.saveOrUpdate(sp);
            sess.beginTransaction().commit();
            // удалим товары задачи
            sess.beginTransaction();
            String s = "delete from zadachafurnitura where Zadachafurnitura = " + p;
            sess.createSQLQuery(s).executeUpdate();
            sess.beginTransaction().commit();            
            
            //если строка склада нигде не используется то пометин её как новая
            if(sess.createCriteria(ZadachaFurnitura.class).add(Restrictions.eq("scladproduct", sp)).list().isEmpty())
            {
                sp.setStatus(1);
                sess.beginTransaction();
                sess.saveOrUpdate(sp);
                sess.beginTransaction().commit();
            }
                
            
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
            return false;
        }        
        return true;
        
    }
}
