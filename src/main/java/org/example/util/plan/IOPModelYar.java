/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.util.plan;

import java.util.ArrayList;
import java.util.List;
import org.example.logic.Color;
import org.example.logic.Model;
import org.example.logic.Razmeri;
import org.example.logic.plan.PModelYar;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.example.util.HibernateUtil;

/**
 *
 * @author ivan
 */
public class IOPModelYar {
    
    
    public static PModelYar savePModelYar(PModelYar p)
    {
        PModelYar py = getPModelYar(p.getYar(), p.getModel().getModel(), p.getRazmeri().getRazmeri(), p.getColor().getColor());
        if(py.getPmodelyar()!=0)
        {
            py.setQty(p.getQty());
            py = setPModelYar(py);
        }
        else
            py = setPModelYar(p);
        return py;
    }
    
    /**
     * Сохранить строку
     * @param p
     * @return 
     */
    public static PModelYar setPModelYar(PModelYar p)
    {
        if(p.getPmodelyar()== 0)
            p.setPmodelyar(null);
        
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
     * Получить строку
     * @param p
     * @return 
     */
    public static PModelYar getPModelYar(int p)
    {
        List<PModelYar> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();            
            ls = sess.createCriteria(PModelYar.class).add(Restrictions.eq("pmodelyar", p)).list();                        
            if(ls.isEmpty())
                ls.add(new PModelYar(0));
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
            ls.add(new PModelYar(0));
        }        
        return ls.get(0);        
    }
    
    /**
     * Получить строку по параметрам
     * @param y - год
     * @param m - модель
     * @param r - размер
     * @param c - цвет
     * @return 
     */
    public static PModelYar getPModelYar(int y, int m, int r, int c)
    {
        List<PModelYar> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();            
            ls = sess.createCriteria(PModelYar.class)
                    .add(Restrictions.eq("yar", y))
                    .add(Restrictions.eq("model", new Model(m)))
                    .add(Restrictions.eq("color", new Color(c)))
                    .add(Restrictions.eq("razmeri", new Razmeri(r)))
                    .list();                        
            if(ls.isEmpty())
                ls.add(new PModelYar(0));
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
            ls.add(new PModelYar(0));
        }        
        return ls.get(0);        
    }
    
}
