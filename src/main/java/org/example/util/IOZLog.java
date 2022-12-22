/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.util;

import java.util.Date;
import org.example.logic.ZLog;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ivan
 */
public class IOZLog {
    
    /**
     Добавитьв лог операцию
     * @param z - Номер задачи
     * @param id  - ид объекта
     * @param tid - тип объекта
     *    1 - Задача
          2 - Настил
          3 - Комплектовка
     * @param s - комментарий
     * @return 
     */
    public static ZLog setZLog(int z, int id, int tid, String s)
    {
        ZLog zl = new ZLog();
        zl.setComment(s);
        zl.setDates(new Date());
        zl.setId(id);
        zl.setTipid(tid);
        zl.setZadacha(z);
        zl.setZlog(null);
        zl.setOper(IOOperator.operator.getOperator());
        
        String computername = "";
        try {
            computername=InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException ex) {
            Logger.getLogger(IOZLog.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        zl.setPc(computername);
        
        Session sess = HibernateUtil.getSessionFactory().openSession();
        try 
        {
            sess.beginTransaction();
            sess.saveOrUpdate(zl);
            sess.beginTransaction().commit();
            
        }catch(HibernateException e)
        {
            System.out.println("ERROR SAVE" + e);            
        }
        return zl;
    }
    
}
