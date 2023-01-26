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
import org.example.logic.FurnituraScladOff;
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
public class IOFurnituraScladOff {
    /**
     * Получить списания
     * 
     * @param d
     * @return 
     */
    public static FurnituraScladOff getFurnituraScladOff(int d)
    {
        List<FurnituraScladOff> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(FurnituraScladOff.class).add(Restrictions.eq("furniturascladoff", d)).list();            
            if(ls.isEmpty())
                ls.add(new FurnituraScladOff(0));
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
            ls.add(new FurnituraScladOff(0));
        }        
        return ls.get(0);    
    }
    
    
    
    
    /**
     * Сохранить списание
     * @param p -      
     * @return - списание
     */
    public static FurnituraScladOff setFurnituraScladOff(FurnituraScladOff p)
    {
        if(p.getFurniturascladoff()== 0)
            p.setFurniturascladoff(null);
        
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
     * Получить список строк для документа
     * @param d1
     * @param d2
     * @return 
     */
    public static List<FurnituraScladOff> getListFurnituraScladOff(Date d1, Date d2)
    {
        List<FurnituraScladOff> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(FurnituraScladOff.class).add(Restrictions.between("dates", d1, d2)).addOrder(Order.desc("dates")).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;    
    }
    
    /**
     * провести списание фурнитуры на складе
     * @param s
     * @return 
     */
    public static boolean closeFurnituraScladOff(int s)
    {
        FurnituraScladOff f = getFurnituraScladOff(s);
        if(f.getScladproduct().getStatus()==2)
        {
            JOptionPane.showMessageDialog(null, "Недостаточно остатков на складе");
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
        setFurnituraScladOff(f);
        return true;
    }
    
    /**
     * Открыть списание фурнитуры на складе
     * @param s
     * @return 
     */
    public static boolean openFurnituraScladOff(int s)
    {
        FurnituraScladOff f = getFurnituraScladOff(s);        
        ScladProduct sp = f.getScladproduct();
        sp.setWidth(sp.getWidth().add(f.getQty()));
        if(sp.getStatus()==2)
            sp.setStatus(1);
        IOScladProduct.setScladProduct(sp);
        f.setStatus(0);
        setFurnituraScladOff(f);
        return true;
    }
    
    /**
     * удалить списание фурнитуры на складе
     * @param s
     * @return 
     */
    public static boolean delFurnituraScladOff(int s)
    {
        FurnituraScladOff f = getFurnituraScladOff(s);        
        if(f.getStatus()==1)
            return false;
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = sess.beginTransaction();
            sess.delete(f);
            transaction.commit();
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return true;
    }

}
