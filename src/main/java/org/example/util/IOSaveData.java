/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ivan
 */
public class IOSaveData {
    /**
     * Сохранить выполненные операции за период в файл
     * @param file - файл куда сохраняем
     * @param d1
     * @param d2
     * @param group - группировать по типам операций
     * @return 
     */
    public static boolean saveRabotnikOperation(String file, Date d1, Date d2, boolean group)
    {
        String sql;
        if(group)
        {
                sql = "select  c.name || ';' || og.name  || ';' || cast(coalesce(sum(ro.timeo*ro.qty),0) as bigint) from RABOTNIKOPERATION ro\n" +
                    "inner join operation o on ro.operation = o.operation\n" +
                    "inner join operationgruppa og on og.operationgruppa = o.operationgruppa\n" +
                    "inner join zadachakomplektovka zk on zk.zadachakomplektovka = ro.zadachakomplektovka\n" +
                    "inner join rabotnikgruppa c on c.rabotnikgruppa = zk.chex\n" +
                    "where ro.dates between '2017-10-01' and '2017-11-17'\n" +
                    "group by c.name, og.name\n" +
                    "order by c.name, og.name";
        }
        else
        {
            sql = "select  c.name || ';' || og.name  || ';' || o.name || ';' || cast(coalesce(sum(ro.timeo*ro.qty),0) as bigint) from RABOTNIKOPERATION ro\n" +
                    "inner join operation o on ro.operation = o.operation\n" +
                    "inner join operationgruppa og on og.operationgruppa = o.operationgruppa\n" +
                    "inner join zadachakomplektovka zk on zk.zadachakomplektovka = ro.zadachakomplektovka\n" +
                    "inner join rabotnikgruppa c on c.rabotnikgruppa = zk.chex\n" +
                    "where ro.dates between '2017-10-01' and '2017-11-17'\n" +
                    "group by c.name, o.name, og.name\n" +
                    "order by c.name, og.name, o.name";
        }
        List<String> ls = null;
        
        try 
        {
            
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            Transaction transaction = sess.beginTransaction();     
            ls = (List<String>)sess.createSQLQuery(sql).list();
            transaction.commit();
            sess.close();            
        } catch (HibernateException e) {
            System.out.println("ERROR get data" + e);
        }
        
        if(ls.isEmpty())
            return false;
        try (PrintWriter outs = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file+".csv", false), "cp1251"), false)) {
            
            for(String s: ls)
            {
                outs.println(s);
            }
            
            outs.close();
            
        } catch (UnsupportedEncodingException | FileNotFoundException ex) {
                    System.out.println("ERROR " + ex);
                }
        
        return true;
    }
    
    /**
     * Сохранить операции доделей
     * @param file - файл куда сохраняем
     * @return 
     */
    public static boolean saveOperationModel(String file)
    {
        String sql;
        sql = "select\n"
                + " m.article || ';' || m.dates || ';' || m.name || ';' || REPLACE(m.text,';',':') || ';' || tm.name || ';' || tm.koef || ';' || REPLACE(mo.text,';',':') || ';' || mo.nom || ';' || mo.times || ';' || o.name || ';' || og.name || ';' || r.num || ';' || r.summa as pricerazrad\n"
                + "from model m\n"
                + "inner join modeloperation mo on mo.model = m.model\n"
                + "inner join operation o on o.operation = mo.operation\n"
                + "inner join operationgruppa og on og.operationgruppa = o.operationgruppa\n"
                + "inner join razrad r on mo.razrad = r.razrad\n"
                + "inner join tipmodel tm on tm.tipmodel = m.tipmodel\n"
                + "where m.del = 0 and m.status !=3 \n"
                + "order by m.model, mo.nom";
        
        List<String> ls = null;
        
        try 
        {
            
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            Transaction transaction = sess.beginTransaction();     
            ls = (List<String>)sess.createSQLQuery(sql).list();
            transaction.commit();
            sess.close();            
        } catch (HibernateException e) {
            System.out.println("ERROR get data" + e);
        }
        
        if(ls.isEmpty())
            return false;
        try (PrintWriter outs = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file+".csv", false), "cp1251"), false)) {
            outs.println("Артикул;Дата;Название модели;Пояснение;Тип модели;Коэффициент модели;Пояснение;Номер;Время;Название;Группа;Разряд;ЦенаРазряда");
            for(String s: ls)
            {
                outs.println(s);
            }
            
            outs.close();
            
        } catch (UnsupportedEncodingException | FileNotFoundException ex) {
                    System.out.println("ERROR " + ex);
                }
        
        return true;
    }
    
    
    /**
     * Сохранить маршруты в работе и отправленные
     * @param file - файл куда сохраняем
     * @return 
     */
    public static boolean saveMsrhrut(String file, String d1, String d2)
    {
        String sql;
        sql = "select\n" +
"  case zk.status when 3 then 'Отправлен' else 'Принят' end || ';' ||\n" +
"  zk.nomer || ';' ||\n" +
"  zk.datasend || ';' ||\n" +
"  rg.name || ';' ||\n" +
"  z.qty || ';' ||\n" +
"  rz.name || ';' ||\n" +
"  m.article || ';' ||\n" +
"  c.name\n" +
"from zadachakomplektovka zk\n" +
"inner join rabotnikgruppa rg on rg.rabotnikgruppa = zk.chex\n" +
"inner join model m on m.model = zk.model\n" +
"inner join color c on zk.color = c.color\n" +
"inner join zadachakomplektovkarazmeri z on z.zadachakomplektovka = zk.zadachakomplektovka\n" +
"inner join razmeri rz on rz.razmeri = z.razmeri\n" +
"where zk.datasend between '"+d1+"' and '"+d2+"'\n" +
"and zk.status in (3, 4)  and z.qty>0";
        
        List<String> ls = null;
        
        try 
        {
            
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            Transaction transaction = sess.beginTransaction();     
            ls = (List<String>)sess.createSQLQuery(sql).list();
            transaction.commit();
            sess.close();            
        } catch (HibernateException e) {
            System.out.println("ERROR get data" + e);
        }
        
        if(ls.isEmpty())
            return false;
        try (PrintWriter outs = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file+".csv", false), "cp1251"), false)) {
            outs.println("Статус;Маршрут;Дата отправки;Цех;Кол-во;Размер;Артикул;Цвет");
            for(String s: ls)
            {
                outs.println(s);
            }
            
            outs.close();
            
        } catch (UnsupportedEncodingException | FileNotFoundException ex) {
                    System.out.println("ERROR " + ex);
                }
        
        return true;
    }
    
    /**
     * Сохранить все маршруты в цехе
     * @param file
     * @return 
     */
    public static boolean saveMarhrutAll(String file)
    {
        String sql;
        sql = "select\n" +
"(case status when 3 then 'отправлена в швейный цех' when 4 then 'принята в швейном цехе' else 'нет' end) || ';' ||\n" +
"chexname || ';' ||\n" +
"article || ';' ||\n" +
"sum(qty)\n" +
"\n" +
"from VIEWMARSHRUT\n" +
"where status in (3,4)\n" +
"group by status, chexname, article";
        
        List<String> ls = null;
        
        try 
        {
            
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            Transaction transaction = sess.beginTransaction();     
            ls = (List<String>)sess.createSQLQuery(sql).list();
            transaction.commit();
            sess.close();            
        } catch (HibernateException e) {
            System.out.println("ERROR get data" + e);
        }
        
        if(ls.isEmpty())
            return false;
        try (PrintWriter outs = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file+".csv", false), "cp1251"), false)) {
            outs.println("Статус;Цех;Артикул;Кол-во");
            for(String s: ls)
            {
                outs.println(s);
            }
            
            outs.close();
            
        } catch (UnsupportedEncodingException | FileNotFoundException ex) {
                    System.out.println("ERROR " + ex);
                }
        
        return true;
    }
    
    
     /**
     * Сохранить все маршруты в цехе
     * @param file
     * @return 
     */
    public static boolean saveZadachaResult(String file, String date1, String date2)
    {
        String sql;
        sql = "select ZADACHA || ';' || ARTICLE || ';' || COMMENTS || ';' || ZADACHADATE || ';' || SUMZAKCHEH || ';' || SUMWORKSHOP || ';' || SUMPRINT || ';' || QTY4 || ';' || QTY3 || ';' || ALLSUM1|| ';' || ALLSUM2 from unloading_expenses('"+date1+"', '"+date2+"')";
        
        List<String> ls = null;
        
        try 
        {
            
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            Transaction transaction = sess.beginTransaction();     
            ls = (List<String>)sess.createSQLQuery(sql).list();
            transaction.commit();
            sess.close();            
        } catch (HibernateException e) {
            System.out.println("ERROR get data" + e);
        }
        
        if(ls.isEmpty())
            return false;
        try (PrintWriter outs = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file+".csv", false), "cp1251"), false)) {
            outs.println("Задача;Артикул;Комментарий к артикулу;Дата задачи;Себестоимость закройный цех - полотна; Субестоимость швейный цех; Сумма принт/вышивка;Количество изделий полученных на склад;Количество изделий факт; Себестоимость по полученным на склад; Субестоимость по откомплектованным  ");
            for(String s: ls)
            {
                outs.println(s.replace(".", ","));
            }
            
            outs.close();
            
        } catch (UnsupportedEncodingException | FileNotFoundException ex) {
                    System.out.println("ERROR " + ex);
                }
        
        return true;
    }
    
}
