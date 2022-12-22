/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author ivan
 */
public class IOHelpClass {
    /**
     * Получение паспорта для рулона
     * @return - паспорт
     */
    public static int getPasport()
    {
        int p;
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            sess.beginTransaction();
            String s = "select pasport from get_pasport";
            p =  (Integer)sess.createSQLQuery(s).uniqueResult();
            sess.beginTransaction().commit();
            
        } catch (HibernateException e) {
            System.out.println("ERROR GET" + e);
            return 0;
        }        
        return p;
    }
}
