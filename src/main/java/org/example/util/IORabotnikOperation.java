/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.util;

import java.math.BigInteger;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.example.logic.LRabotnikOperation;
import org.example.logic.RabotnikGruppa;
import org.example.logic.RabotnikOperation;
import org.example.logic.ZadachaKomplektovka;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Transaction;

/**
 *
 * @author ivan
 */
public class IORabotnikOperation {
    
    /**
     * Получить список операций для маршрута
     * @param m - маршрут
     * @param o - операция
     * @return 
     */
    public static int getCountOperationForMarshrut(int m, int o, int ro)
    {
        BigInteger h;
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            Transaction transaction = sess.beginTransaction();
            String s;
            if(o ==0 )
                s = "select coalesce(sum(zkr.qty),0) from zadachakomplektovkarazmeri zkr where zkr.zadachakomplektovka = " + m;
            else
                s = "select coalesce(sum(rro.qty),0) from rabotnikoperation rro where rro.zadachakomplektovka = "+m+" and rro.operation = "+o + " and rro.rabotnikoperation != " + ro;
            h = (BigInteger)sess.createSQLQuery(s).uniqueResult();
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
            return 0;
        }        
        return h.intValue();
    }
    
    /**
     * Получить список операций работника по комплектовке
     * @param kompl
     * @return 
     */
    public static List<RabotnikOperation> getListRabotnikOperationForKomplektovka(int kompl)
    {
        List<RabotnikOperation> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(RabotnikOperation.class).add(Restrictions.eq("zadachakomplektovka", new ZadachaKomplektovka(kompl))).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Сохранить операцию
     * @param p - 
     * @return - 
     */
    public static RabotnikOperation setRabotnikOperation(RabotnikOperation p)
    {
        if(p.getRabotnikoperation()== 0)
            p.setRabotnikoperation(null);
        
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
     * Получить список 
     * @param p - id товара -1 все
     * @param d1
     * @param d2
     * @return 
     */
    public static List<RabotnikOperation> getListRabotnikOperation(int p, Date d1, Date d2)
    {
        List<RabotnikOperation> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            if(p == -1)   
            {
                Criteria c = sess.createCriteria(RabotnikOperation.class).add(Restrictions.between("dates", d1, d2));
                int chex = IOOperator.operator.getRabotnikgruppa().getRabotnikgruppa();
                if(chex !=0)
                {
                    c.createAlias("zadachakomplektovka", "zk").add(Restrictions.eq("zk.chek", new RabotnikGruppa(chex)));
                }
                ls = c.addOrder(Order.desc("dates")).list();            
            }
            else
                ls = sess.createCriteria(RabotnikOperation.class).add(Restrictions.eq("rabotnikoperation", p)).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    
    /**
     * Получить список 
     * @param d1
     * @param d2
     * @return 
     */
    public static List<LRabotnikOperation> getLRabotnikOperation(Date d1, Date d2)
    {
        List<LRabotnikOperation> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            int chex = IOOperator.operator.getRabotnikgruppa().getRabotnikgruppa();
            Criteria c = sess.createCriteria(LRabotnikOperation.class).add(Restrictions.between("dates", d1, d2));
            if(chex !=0)
            {
                c.add(Restrictions.eq("chex", chex));
            }
            ls = c.addOrder(Order.desc("dates")).list();            
            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    
    
    /**
     * Получить список 
     * @param d1
     * @param d2
     * @return 
     */
    public static List<LRabotnikOperation> getLRabotnikOperation1(Date d1, Date d2)
    {
        List<LRabotnikOperation> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            int chex = IOOperator.operator.getRabotnikgruppa().getRabotnikgruppa();
            int stop = IOOperator.operator.getNochex();
            
            Criteria c = sess.createCriteria(LRabotnikOperation.class).add(Restrictions.between("dates", d1, d2));
            if(chex !=0)
            {
                c.add(Restrictions.eq("chex", chex));
            }
            //если есть склады которые не нужно показывать
            if(stop!=0)
            {
                c.add(Restrictions.not(Restrictions.in("chex", IOOperator.getListChexForStopOperator1(IOOperator.operator.getOperator()))));
            }
            ls = c.addOrder(Order.desc("dates")).list();            
            
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
    public static boolean delRabotnikOperation(int p)
    {
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            Transaction transaction = sess.beginTransaction();
            String s = "delete from RabotnikOperation where RabotnikOperation = " + p;
            sess.createSQLQuery(s).executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
            return false;
        }        
        return true;
        
    }
    
    
    /**
     * Получить список перевыполненных операций
     * @param d1
     * @param d2
     * @return - результат
     */
    public static List<String> getLGrossRabotnikOperation(Date d1, Date d2)
    {
        List<String> ls = new ArrayList<>();
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();             
            
            int chex = IOOperator.operator.getRabotnikgruppa().getRabotnikgruppa();
            
            String s = "select\n"
                    + " nom || '<!>' || name || '<!>' || sumo || '<!>' || sumsf || '<!>' || article || '<!>' || nomer || '<!>' || zadacha || '<!>' || chex\n"
                    + "from\n"
                    + "(\n"
                    + "select\n"
                    + "  mo.nom,\n"
                    + "  o.name,\n"
                    + "  (select sum(zkr.qty) from zadachakomplektovkarazmeri zkr where zkr.zadachakomplektovka = zk.zadachakomplektovka) as sumo,\n"
                    + "  (select coalesce(sum(rro.qty),0) from rabotnikoperation rro where rro.zadachakomplektovka = zk.zadachakomplektovka and rro.operation = o.operation) as sumsf,\n"
                    + "  m.article,\n"
                    + "  zk.nomer,\n"
                    + "  z.nomer as zadacha,\n"
                    + "  rg.name as chex\n"
                    + "from zadachakomplektovka zk\n"
                    + "inner join zadacha z on z.zadacha = zk.zadacha\n"
                    + "inner join model m on m.model = z.model\n"
                    + "inner join modeloperation mo on mo.model = m.model\n"
                    + "inner join operation o on o.operation = mo.operation\n"
                    + "inner join rabotnikgruppa rg on zk.chex = rg.rabotnikgruppa\n";
            if(chex == 0)                
                s = s + "where zk.dates between '"+HelpClass.getPrintDate1(d1)+"' and '"+HelpClass.getPrintDate1(d2)+"') where sumo < sumsf";
            else
                s = s + "where zk.chex = " + chex + " and zk.dates between '"+HelpClass.getPrintDate1(d1)+"' and '"+HelpClass.getPrintDate1(d2)+"') where sumo < sumsf";
            
            ls = sess.createSQLQuery(s).list();
            
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
        }        
        return ls;        
    }
    
    
    
    
    
    
    
   
    
}
