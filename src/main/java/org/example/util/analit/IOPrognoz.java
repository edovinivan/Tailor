/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.util.analit;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.example.util.HibernateUtil;

/**
 *
 * @author ivan
 */
public class IOPrognoz {
    public static List<String> getDataForPrognoz(int model, Date d1, Date d2, Date d3)
    {
        List<String> ls = new ArrayList<>();
        try 
        {
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            sess.beginTransaction();
            String s = "select res from  GET_DATA_FOR_PROGNOZ("+model+", '"+sf.format(d1)+"', '"+sf.format(d2)+"', '"+sf.format(d3)+"')";            
            //System.out.println(s);
            ls = sess.createSQLQuery(s).list();
            sess.beginTransaction().commit();
            sess.close();            
        } catch (HibernateException e) {
            System.out.println("ERROR close document" + e);
        }        
        return ls;
        
    }
    
    
    /**
     * 
     * @param model
     * @param d1
     * @param d2
     * @param d3
     * @param yar
     * @return 
     */
    public static List<String> getDataForPrognoz1(int model, Date d1, Date d2, Date d3, int yar)
    {
        List<String> ls = new ArrayList<>();
        try 
        {
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            sess.beginTransaction();
            String s = "select res from  GET_DATA_FOR_PROGNOZ1("+model+", '"+sf.format(d1)+"', '"+sf.format(d2)+"', '"+sf.format(d3)+"', " + yar+ " )";            
            //System.out.println(s);
            ls = sess.createSQLQuery(s).list();
            sess.beginTransaction().commit();
            sess.close();            
        } catch (HibernateException e) {
            System.out.println("ERROR close document" + e);
        }        
        return ls;
        
    }
    
    
    public static int getQtySale(int model, int color, int razmer, Date d1, Date d2)
    {
        //List<String> ls = new ArrayList<>();
        Integer res = 0;
        try 
        {
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            sess.beginTransaction();
            String s = "select res from  GET_DATA_FOR_PROGNOZ1_FOR_STR("+model+", " + color + ", " + razmer + ", '" +sf.format(d1)+"', '"+sf.format(d2)+"')";            
            //System.out.println(s);
            res = (Integer)sess.createSQLQuery(s).uniqueResult();
            sess.beginTransaction().commit();
            sess.close();            
        } catch (HibernateException e) {
            System.out.println("ERROR close document" + e);
            res = 0;
        }        
        return res;
        
    }
    
    
    public static List<String> getQtySaleForChar(int model, int color, Date d1, Date d2)
    {
        //System.out.println("model - " + model);
        //System.out.println("color - " + color);
        List<String> ls = new ArrayList<>();
        try 
        {
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            sess.beginTransaction();
            String s = "select\n"
                    + " cast(coalesce(sum(-qty),0) as integer) || '<!>' || 'Продажи' || '<!>' || dat  \n"
                    + "from(\n"
                    + "select\n"
                    + "  j.qty,\n"
                    + "  extract(year from j.dates) || decode( (extract(MONTH from j.dates)<10),true, ('0' || extract(MONTH from j.dates)),extract(MONTH from j.dates)) as dat\n"
                    + "from a_journal j\n"
                    + "inner join a_operation o on o.a_operation = j.operations and o.ink = 1\n"
                    + "inner join a_sclad s on s.a_sclad = j.sclad and s.io = 1\n"
                    + "where j.article = "+model+" and j.color = "+color+" and j.dates between '"+sf.format(d1)+"' and '"+sf.format(d2)+"' and qty < 0)\n"
                    + "group by dat";
            //System.out.println(s);
            ls = sess.createSQLQuery(s).list();
            sess.beginTransaction().commit();
            sess.close();            
        } catch (HibernateException e) {
            System.out.println("ERROR close document" + e);
        }        
        //System.out.println("z1 =  " + ls.size());
        return ls;        
    }
    
    public static List<String> getQtySaleForChar1(int model, Date d1, Date d2)
    {
        //System.out.println("model - " + model);
        //System.out.println("color - " + color);
        List<String> ls = new ArrayList<>();
        try 
        {
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            sess.beginTransaction();
           
            String s = "select\n"
                    + " cast(coalesce(sum(-qty),0) as integer) || '<!>' || 'Продажи' || '<!>' || dat  \n"
                    + "from(\n"
                    + "select\n"
                    + "  j.qty,\n"
                    + "  extract(year from j.dates) || decode( (extract(MONTH from j.dates)<10),true, ('0' || extract(MONTH from j.dates)),extract(MONTH from j.dates)) as dat\n"
                    + "from a_journal j\n"
                    + "inner join a_operation o on o.a_operation = j.operations and o.ink = 1\n"
                    + "inner join a_sclad s on s.a_sclad = j.sclad and s.io = 1\n"
                    + "where j.article = "+model+" and j.dates between '"+sf.format(d1)+"' and '"+sf.format(d2)+"' and qty < 0)\n"
                    + "group by dat";
            //System.out.println(s);
            ls = sess.createSQLQuery(s).list();
            sess.beginTransaction().commit();
            sess.close();            
        } catch (HibernateException e) {
            System.out.println("ERROR close document" + e);
        }        
        //System.out.println("z1 =  " + ls.size());
        return ls;        
    }
    
    public static List<String> getQtySaleForChar2(int model, Date d1, Date d2)
    {
        //System.out.println("model - " + model);
        //System.out.println("color - " + color);
        List<String> ls = new ArrayList<>();
        List<String> ls1 = new ArrayList<>();
        try 
        {
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            sess.beginTransaction();
           
            
            String s = "select\n"
                    + "  cast(coalesce(sum(-qty),0) as integer) || '<!>' || colors || '<!>' || dat\n"
                    + "  from(\n"
                    + "  select\n"
                    + "    j.qty,\n"
                    + "    extract(year from j.dates) || decode( (extract(MONTH from j.dates)<10),true, ('0' || extract(MONTH from j.dates)),extract(MONTH from j.dates)) as dat,\n"
                    + "    a.name as colors\n"
                    + "  from a_journal j\n"
                    + "  inner join a_operation o on o.a_operation = j.operations and o.ink = 1\n"
                    + "  inner join a_sclad s on s.a_sclad = j.sclad and s.io = 1\n"
                    + "  inner join a_color a on a.a_color = j.color\n"
                    + "  where j.article = " + model + " and j.dates between '" + sf.format(d1) + "' and '" + sf.format(d2) + "' and qty < 0\n"
                    + "  )\n"
                    + "  group by dat, colors";                              
                        
            ls = sess.createSQLQuery(s).list();                                                
            sess.beginTransaction().commit();
            
            sess.beginTransaction();
           
            
            s = "select\n"
                    + "  cast(coalesce(sum(-qty),0) as integer) || '<!>' || 'Всего' || '<!>' || dat\n"
                    + "  from(\n"
                    + "  select\n"
                    + "    j.qty,\n"
                    + "    extract(year from j.dates) || decode( (extract(MONTH from j.dates)<10),true, ('0' || extract(MONTH from j.dates)),extract(MONTH from j.dates)) as dat\n"
                    + "  from a_journal j\n"
                    + "  inner join a_operation o on o.a_operation = j.operations and o.ink = 1\n"
                    + "  inner join a_sclad s on s.a_sclad = j.sclad and s.io = 1\n"
                    + "  where j.article = "+model+" and j.dates between '" + sf.format(d1) + "' and '" + sf.format(d2) + "' and qty < 0) group by dat";                            
                        
            ls1 = sess.createSQLQuery(s).list();                                                
            sess.beginTransaction().commit();
            
            ls.addAll(ls1);
            
            
            
            
            sess.close();            
        } catch (HibernateException e) {
            System.out.println("ERROR close document" + e);
        }        
        //System.out.println("z1 =  " + ls.size());
        return ls;        
    }
    
    
    
    
    
    
    
}
