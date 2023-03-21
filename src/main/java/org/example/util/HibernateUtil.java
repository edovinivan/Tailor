/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author ivan
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory = null;
    
    //static File fil = new File("hibernate.cfg.xml1");
    static Configuration c = new Configuration().configure();
    static {
        
        try {
                //creates the session factory from hibernate.cfg.xml
                c.addProperties(getConnectionProperties());                                
                sessionFactory = c.buildSessionFactory();
                
                
                
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, "ERROR= " + e);
        }
        
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static  void closeSession()
    {
        sessionFactory.close();
    }
    
    
    private static  Properties getConnectionProperties() {
        Properties connectionProps = new Properties();
        connectionProps.put("hibernate.connection.url", getConnectionUrl());
        return connectionProps;
    }

    private static String getConnectionUrl() {
        String h = "111";
        File ff = new File("connect.ini");
        if(ff.exists())
        {
            try (BufferedReader red = new BufferedReader(new InputStreamReader(new FileInputStream(ff)))) 
            {
                h = red.readLine();
                                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(HibernateUtil.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(HibernateUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
           //h = "jdbc:firebirdsql:localhost:tailor";
            h = "jdbc:firebirdsql:10.1.1.1:tailor";
        return h;
    }

}
