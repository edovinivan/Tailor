/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import org.example.logic.FurnituraReturnSclad;
import org.example.logic.RabotnikGruppa;
import org.example.logic.ScladProduct;
import org.example.logic.ScladProductF;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ivan
 */
public class IOFurnituraReturnSclad {
    /**
     * Получить возврат 
     * @param d
     * @return 
     */
    public static FurnituraReturnSclad getFurnituraReturnSclad(int d)
    {
        List<FurnituraReturnSclad> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(FurnituraReturnSclad.class).add(Restrictions.eq("furniturareturnsclad", d)).list();            
            if(ls.isEmpty())
                ls.add(new FurnituraReturnSclad(0));
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
            ls.add(new FurnituraReturnSclad(0));
        }        
        return ls.get(0);    
    }
    
    
    
    
    /**
     * Сохранить списание
     * @param p -      
     * @return - списание
     */
    public static FurnituraReturnSclad setFurnituraReturnSclad(FurnituraReturnSclad p)
    {
        if(p.getFurniturareturnsclad()== 0)
            p.setFurniturareturnsclad(null);
        
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
     * Получить список строк для цеха
     * @param chex
     * @param d1
     * @param d2
     * @return 
     */
    public static List<FurnituraReturnSclad> getListFurnituraReturnSclad(int chex, Date d1, Date d2)
    {
        List<FurnituraReturnSclad> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            if(chex == 0)
                ls = sess.createCriteria(FurnituraReturnSclad.class).add(Restrictions.between("dates", d1, d2)).addOrder(Order.desc("dates")).list();            
            else
                ls = sess.createCriteria(FurnituraReturnSclad.class).add(Restrictions.eq("chex", new RabotnikGruppa(chex))).add(Restrictions.between("dates", d1, d2)).addOrder(Order.desc("dates")).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;    
    }
    
    /**
     * провести списание фурнитуры на складе в цехе
     * @param s
     * @return 
     */
    public static boolean closeFurnituraReturnScladInChex(int s)
    {
        FurnituraReturnSclad f = getFurnituraReturnSclad(s);
        if(f.getStatus()>0)
        {
            JOptionPane.showMessageDialog(null, "Возврат уже проведен");
            return false;
        }
            
        if(f.getScladproductf().getOstatok().compareTo(f.getQty())<0)
        {
            JOptionPane.showMessageDialog(null, "Недостаточно остатков на складе");
            return false;
        }
        // вычтем количество из склада цеха                
        ScladProductF sp = f.getScladproductf();
        sp.setOstatok(sp.getOstatok().subtract(f.getQty()));
        
        IODocumentF.setScladProductF(sp);
        f.setStatus(1);
        setFurnituraReturnSclad(f);
        return true;
    }
    
    /**
     * Открыть возврат фурнитуры в цехе
     * @param s
     * @return 
     */
    public static boolean openFurnituraReturnScladInChex(int s)
    {
        FurnituraReturnSclad f = getFurnituraReturnSclad(s);        
        if(f.getStatus()!=1)
        {
            JOptionPane.showMessageDialog(null, "Возврат нельзя открыть");
            return false;
        }
        ScladProductF sp = f.getScladproductf();
        sp.setOstatok(sp.getOstatok().add(f.getQty()));
        IODocumentF.setScladProductF(sp);
        f.setStatus(0);
        setFurnituraReturnSclad(f);
        return true;
    }
    
    /**
     * удалить возврат фурнитуры на склад
     * @param s
     * @return 
     */
    public static boolean delFurnituraReturnSclad(int s)
    {
        FurnituraReturnSclad f = getFurnituraReturnSclad(s);        
        if(f.getStatus()!=0)
            return false;
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            sess.beginTransaction();
            sess.delete(f);
            sess.beginTransaction().commit();
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return true;
    }
    
    /**
     * провести списание фурнитуры на складе в СКЛАДЕ
     * @param s
     * @return 
     */
    public static boolean closeFurnituraReturnScladInSclad(int s)
    {
        FurnituraReturnSclad f = getFurnituraReturnSclad(s);
        if(f.getStatus()!=1)
        {
            JOptionPane.showMessageDialog(null, "Возврат уже проведен");
            return false;
        }            
        
        // добавим количество к складским остаткам
        ScladProduct sp = f.getScladproduct();
        sp.setWidth(sp.getWidth().add(f.getQty()));
        if(sp.getStatus()==2)
            sp.setStatus(1);
        
        IOScladProduct.setScladProduct(sp);
        f.setStatus(2);
        setFurnituraReturnSclad(f);
        return true;
    }
    
    /**
     * Открыть возврат фурнитуры на складе
     * @param s
     * @return 
     */
    public static boolean openFurnituraReturnScladInSclad(int s)
    {
        FurnituraReturnSclad f = getFurnituraReturnSclad(s);        
        if(f.getStatus()!=2)
        {
            JOptionPane.showMessageDialog(null, "Возврат нельзя открыть");
            return false;
        }
        
        if(f.getScladproduct().getWidth().compareTo(f.getQty())<0)
        {
            JOptionPane.showMessageDialog(null, "Недостаточно остатков на складе");
            return false;
        }
        
        ScladProduct sp = f.getScladproduct();
        sp.setWidth(sp.getWidth().subtract(f.getQty()));
        if(sp.getWidth().signum()==0)
            sp.setStatus(2);
        IOScladProduct.setScladProduct(sp);
        f.setStatus(1);
        setFurnituraReturnSclad(f);
        return true;
    }
    
}
