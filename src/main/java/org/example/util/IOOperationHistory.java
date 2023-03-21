/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.example.logic.OperationHistory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ivan
 */
public class IOOperationHistory {
    /**
     * Сохранить событие
     * @param p - объект
     * @return - объект
     */
    public static OperationHistory setOperationHistory(OperationHistory p)
    {
        if(p.getOperationhistory()== 0)
            p.setOperationhistory(null);
        
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
     * Сохранить событие
     * @param name - Название операции
     * @param doc - номер документа
     * @param vid - вид документа
     *       1 - Документ склада лоскутов
     * @return - объект
     */
    public static OperationHistory saveOperationHistory(String name, int doc, int vid)
    {
        OperationHistory oh = new OperationHistory();
        oh.setDates(new Date());
        oh.setDocument(doc);
        oh.setOper(IOOperator.operator);
        oh.setOperationhistory(0);
        oh.setOperations(name);
        oh.setVid(vid);        
        return setOperationHistory(oh);        
    }
    
    
    /**
     * Получить список объектов
     * @param doc - номер документа
     * @param vid - вид документа
     * @return 
     */
    public static List<OperationHistory> getListOperationHistory(int doc, int vid)
    {
        List<OperationHistory> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(OperationHistory.class).add(Restrictions.eq("vid", vid)).add(Restrictions.eq("document", doc)).addOrder(Order.asc("dates")).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
}
