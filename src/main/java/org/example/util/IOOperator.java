/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import org.example.logic.Operator;
import org.example.logic.OperatorChexStop;
import org.example.logic.OperatorSetup;
import org.example.logic.RabotnikGruppa;
import org.example.logic.SetupName;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ivan
 */
public class IOOperator {
    public static Operator operator;
    private static List<OperatorSetup> listSetup;
    
    /**
     * Загрузить настройки для пользователя
     */
    public static void loadSetupForOperator()
    {
        listSetup = getListOperatorSetup(operator.getOperator());
    }
        
    /**
     * Получить настройку для пользователя
     * @param setupname - настройка
     * @return 
     */
    public static int getSetupOperator(int setupname)
    {
        for(OperatorSetup os: listSetup)
            if(os.getSetupname().getSetupname()==setupname)
            {
                //System.out.println("Нашли " + setupname + " = " + os.getVal() );
                return os.getVal();
            }
        //System.out.println("НЕ Нашли " + setupname + " = " + 0 );
        return 0;
        /*List<OperatorSetup> ls;
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(OperatorSetup.class).add(Restrictions.eq("operator", operator)).add(Restrictions.eq("setupname", new SetupName(setupname))).list();            
            if(ls.isEmpty())
                return 0;
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
            return 0;
        }        
        return ls.get(0).getVal();*/
    }
    
    /**
     * Сохранить пользователя
     * @param p - 
     * @return - 
     */
    public static Operator setOperator(Operator p)
    {
        if(p.getOperator()== 0)
            p.setOperator(null);
        
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
     * Получить список пользователей
     * @param p - id  -1 все     
     * @return 
     */
    public static List<Operator> getListOperator(int p)
    {
        List<Operator> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            if(p == -1)
                ls = sess.createCriteria(Operator.class).add(Restrictions.eq("del", 0)).addOrder(Order.asc("name")).list();            
            else
                ls = sess.createCriteria(Operator.class).add(Restrictions.eq("operator", p)).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Удалить 
     * @param p - ид 
     * @return - результат
     */
    public static boolean delOperator(int p)
    {
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            Transaction transaction = sess.beginTransaction();
            String s = "update operator set del = 1 where operator = " + p;
            sess.createSQLQuery(s).executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
            return false;
        }        
        return true;
        
    }

    /**
     * Получить список настроек
     * @return 
     */
    public static List<SetupName> getListSetupName()
    {
        List<SetupName> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(SetupName.class).addOrder(Order.asc("name")).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls; 
    }
    
    /**
     * Получить список настроек для пользователя
     * @param o
     * @return 
     */
    public static List<OperatorSetup> getListOperatorSetup(int o)
    {
        List<OperatorSetup> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(OperatorSetup.class).add(Restrictions.eq("operator", new Operator(o))).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;         
    }
    
    /**
     * Сохранить настройки для пользователя
     * @param ls
     * @return 
     */
    public static boolean setOperatorSetup(List<OperatorSetup> ls)
    {
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = sess.beginTransaction();
            int h;
            for(OperatorSetup o: ls)
            {
                h = getOS(o.getOperator().getOperator(), o.getSetupname().getSetupname()).getOperatorsetup();
                o.setOperatorsetup(h==0?null:h);
                sess.saveOrUpdate(o);
            }
            transaction.commit();
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }
        return true;
    }
    
    /**
     * Найти настройку для пользователя
     * @param o - оператор
     * @param s - настройка
     * @return 
     */
    public static OperatorSetup getOS(int o, int s)
    {
        List<OperatorSetup> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(OperatorSetup.class).add(Restrictions.eq("setupname", new SetupName(s))).add(Restrictions.eq("operator", new Operator(o))).list();            
            if(ls.isEmpty())
                ls.add(new OperatorSetup(0));
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
            ls.add(new OperatorSetup(0));
        }        
        return ls.get(0);         
    }
    
    /**
     * Получить новый пароль для оператора
     * @return 
     */
    public static int getNewPasswd()
    {
        Random r = new Random(new Date().getTime());
        r.nextInt(9999);
        int p;
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            for(;;)
            {
                p =  r.nextInt(9999);
                if(p>99)
                    if(sess.createCriteria(Operator.class).add(Restrictions.eq("passwd", p)).list().isEmpty())
                       return p;                  
            }
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return 0;
    }
    
    /**
     * Получить оператора по паролю
     * @param ps
     * @return 
     */
    public static Operator getOPForPaaswd(String ps)
    {
        int p;
        try
        {
            p = Integer.parseInt(ps);
        }
        catch(NumberFormatException e)
        {
            p = 0;
        }
        List<Operator> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(Operator.class).add(Restrictions.eq("passwd", p)).list();
            if(ls.isEmpty())
                ls.add(new Operator(0));
            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
            ls.add(new Operator(0));
        }        
        return ls.get(0);
    }
    
    
    /**
     * Получить все цеха которые недоступны для пользователя
     * @param oper
     * @return 
     */
    public static List<RabotnikGruppa> getListChexForStopOperator(int oper)
    {
        List<RabotnikGruppa> ls = new ArrayList<>();
        List<OperatorChexStop> ls1 = new ArrayList<>();
        
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls1 = sess.createCriteria(OperatorChexStop.class).add(Restrictions.eq("operator" , new Operator(oper))).list();
            if(!ls1.isEmpty())
            {
                for(OperatorChexStop r: ls1)
                {
                    ls.add(r.getChex());
                }
            }
                
            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);                        
        }        
        return ls;
    }
    
    /**
     * Получить все коды цехов которые недоступны для пользователя - 
     * @param oper
     * @return 
     */
    public static List<Integer> getListChexForStopOperator1(int oper)
    {
        List<Integer> ls = new ArrayList<>();
        List<OperatorChexStop> ls1 = new ArrayList<>();
        
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls1 = sess.createCriteria(OperatorChexStop.class).add(Restrictions.eq("operator" , new Operator(oper))).list();
            if(!ls1.isEmpty())
            {
                for(OperatorChexStop r: ls1)
                {
                    ls.add(r.getChex().getRabotnikgruppa());
                }
            }
                
            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);                        
        }        
        return ls;
    }
}
