/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.util;

import org.example.Gui.Form.Helps.ComboItem;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.example.logic.Agent;
import org.example.logic.Color;
import org.example.logic.Document;
import org.example.logic.DocumentJournal;
import org.example.logic.DocumentReturn;
import org.example.logic.Product;
import org.example.logic.Sclad;
import org.example.logic.ScladProduct;
import org.example.logic.ViewSP;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ivan
 */
public class IOScladProduct {
    
    
    /**
     * Получить список объектов
     * @param status - статус
     * 0 - показать все
     * 1 - показать полько те что на складе
     * @param vid - вид
     * @param product - товар или 0 все
     * @param color - цвет
     * @param agent - поставщик
     * @param width - ширина
     * @param sclad
     * @param sname - поиск по имени
     * @return 
     */
    public static List<ViewSP> getListScladProduct1(int status, int vid, int product, int color, int agent, int width, int sclad, String sname)
    {
        List<ViewSP> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            Criteria cr;
            //if(status == 1) больше или равно
            {
                cr = sess.createCriteria(ViewSP.class).add(Restrictions.eq("vid", vid)).add(Restrictions.ge("status", status));
                // если это полотно                
                if(vid==1)
                    cr.add(Restrictions.eq("status", status));
                else // если это фурнитура
                {                    
                    cr.add(Restrictions.ge("status", status));
                    cr.add(Restrictions.gt("width", new BigDecimal(0)));
                }
                
                if(product!=0)
                    cr.add(Restrictions.eq("product", product));
                if(color!=0)
                    cr.add(Restrictions.eq("color", color));
                if(agent!=0)
                    cr.add(Restrictions.eq("agent", agent));
                if(width!=0)
                    cr.add(Restrictions.eq("width", new BigDecimal(width)));
                if(sclad!=0)
                    cr.add(Restrictions.eq("sclad", sclad));
                // если ищем по имени
                if(sname.length()>0)
                    cr.add(Restrictions.like("productname", "%" + sname.toUpperCase() + "%").ignoreCase());//.addOrder(Order.asc("productname"));
                //else
                cr.addOrder(Order.asc("productname"));
                
                ls = cr.list();            
                System.out.println(">>>>>>>>>>>>>>> " + ls.size());
            }
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    
    
    
    /**
     * Получить список объектов
     * @param status - статус
     * 0 - показать все
     * 1 - показать полько те что на складе
     * @param vid - вид
     * @param product - товар или 0 все
     * @param color - цвет
     * @param agent - поставщик
     * @param width - ширина
     * @param sclad
     * @param sname - поиск по имени
     * @return 
     */
    public static List<ScladProduct> getListScladProduct(int status, int vid, int product, int color, int agent, int width, int sclad, String sname)
    {
        List<ScladProduct> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            Criteria cr;
            //if(status == 1) больше или равно
            {
                cr = sess.createCriteria(ScladProduct.class).add(Restrictions.eq("vid", vid)).add(Restrictions.ge("status", status));
                // если это полотно                
                if(vid==1)
                    cr.add(Restrictions.eq("status", status));
                else // если это фурнитура
                {                    
                    cr.add(Restrictions.ge("status", status));
                    cr.add(Restrictions.gt("width", new BigDecimal(0)));
                }
                
                if(product!=0)
                    cr.add(Restrictions.eq("product", new Product(product)));
                if(color!=0)
                    cr.add(Restrictions.eq("color", new Color(color)));
                if(agent!=0)
                    cr.add(Restrictions.eq("agent", new Agent(agent)));
                if(width!=0)
                    cr.add(Restrictions.eq("width", new BigDecimal(width)));
                if(sclad!=0)
                    cr.add(Restrictions.eq("sclad", new Sclad(sclad)));
                // если ищем по имени
                if(sname.length()>0)
                    cr.createAlias("product", "pr").add(Restrictions.like("pr.name", "%" + sname.toUpperCase() + "%").ignoreCase()).addOrder(Order.asc("pr.name"));
                else
                    cr.createAlias("product", "pr1").addOrder(Order.asc("pr1.name"));
                    //dd(Restrictions.ne("ostatok", n_max)).add(Restrictions.le("pend", d)).add(Restrictions.like("productname", "%" + sea.toUpperCase() + "%").ignoreCase())
                
                ls = cr.list();            
                //ls = sess.createCriteria(ScladProduct.class).add(Restrictions.eq("vid", vid)).add(Restrictions.eq("status", 0)).addOrder(Order.asc("product")).list();            
            }
            //else
                //ls = sess.createCriteria(ScladProduct.class).addOrder(Order.asc("product")).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Загрузить данные для фильтра
     * @param tip - тип
     * 1 - товары
     * 2 - цвет
     * 3 - ширина
     * 4 - поставщик
     * @param vid
     * @param status
   
     * 
     * @return 
     */
    
    public static List<ComboItem> getDataForFilter(int tip, int vid, int status)
    {
        //Map<Integer, String> ls = new HashMap<>();
        
        List<ComboItem> ls = new ArrayList<>();
        List<String> l = new ArrayList<>();
        //select sp.product, p.name from scladproduct sp inner join product p on sp.product = p.product where sp.vid = 1 and sp.status = 0 group by sp.product, p.name
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            sess.beginTransaction();
            String s = "";
            if(vid == 1)
            {
                if(tip == 1)
                    s = "select sp.product||'!=!'|| p.name from scladproduct sp inner join product p on sp.product = p.product where sp.vid = "+vid+" and sp.status = "+status+"  group by sp.product, p.name order by p.name";
                if(tip == 2)
                    s = "select sp.color||'!=!'|| c.name from scladproduct sp inner join color c on sp.color = c.color where sp.vid = "+vid+" and sp.status = "+status+" group by sp.color, c.name  order by c.name";
                if(tip == 3)
                    s = "select cast(sp.width as integer)||'!=!'|| cast(sp.width as integer) from scladproduct sp where sp.vid = "+vid+" and sp.status = "+status+" group by sp.width order by sp.width";
                if(tip == 4)
                    s = "select sp.agent||'!=!'|| p.name from scladproduct sp inner join agent p on sp.agent = p.agent where sp.vid = "+vid+" and sp.status = "+status+" group by sp.agent, p.name order by p.name";
                if(tip == 5)
                    s = "select sp.sclad||'!=!'|| p.name from scladproduct sp inner join sclad p on sp.sclad = p.sclad where sp.vid = "+vid+" and sp.status = "+status+" group by sp.sclad, p.name order by p.name";
            }
            else
            {
                if(tip == 1)
                    s = "select sp.product||'!=!'|| p.name from scladproduct sp inner join product p on sp.product = p.product where sp.vid = "+vid+" and sp.width>0  group by sp.product, p.name order by p.name";
                if(tip == 2)
                    s = "select sp.color||'!=!'|| c.name from scladproduct sp inner join color c on sp.color = c.color where sp.vid = "+vid+" and  sp.width>0 group by sp.color, c.name  order by c.name";
                if(tip == 3)
                    s = "select cast(sp.width as integer)||'!=!'|| cast(sp.width as integer) from scladproduct sp where sp.vid = "+vid+" and  sp.width>0 group by sp.width order by sp.width";
                if(tip == 4)
                    s = "select sp.agent||'!=!'|| p.name from scladproduct sp inner join agent p on sp.agent = p.agent where sp.vid = "+vid+" and  sp.width>0 group by sp.agent, p.name order by p.name";
                if(tip == 5)
                    s = "select sp.sclad||'!=!'|| p.name from scladproduct sp inner join sclad p on sp.sclad = p.sclad where sp.vid = "+vid+" and  sp.width>0 group by sp.sclad, p.name order by p.name";
            }
            //ls =  (Map<Integer, String>)sess.createSQLQuery(s). uniqueResult();
            //System.out.println(s);
            l = sess.createSQLQuery(s).list();// uniqueResult();
            sess.beginTransaction().commit();
            sess.close();
            if(!l.isEmpty())
            {
                String sd[];
                for(String ss:l)
                {
                    sd = ss.split("!=!");
                    ls.add(new ComboItem(Integer.parseInt(sd[0]), sd[1]));
                }
            }
        } catch (HibernateException e) {
            System.out.println("ERROR close document" + e);
        }        
        return ls;
        
    }
    
    /**
     * Получить объект
     * @param sp
     * @return 
     */
    public static ScladProduct getScladProduct(int sp)
    {
        List<ScladProduct> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(ScladProduct.class).add(Restrictions.eq("scladproduct", sp)).list();
            if(ls.isEmpty())
                ls.add(new ScladProduct(0));
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
            ls.add(new ScladProduct(0));
        }        
        return ls.get(0);        
    }
    
    /**
     * Получить строку на складе по строке прихода
     * @param dj
     * @return 
     */
    public static ScladProduct getScladProductForDocumentJournal(int dj)
    {
        List<ScladProduct> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(ScladProduct.class).add(Restrictions.eq("documentjournal", new DocumentJournal(dj))).list();
            if(ls.isEmpty())
                ls.add(new ScladProduct(0));
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
            ls.add(new ScladProduct(0));
        }        
        return ls.get(0);        
    }
    
    /**
     * Сохранить товар на складе
     * @param sp
     * @return 
     */
    public static ScladProduct setScladProduct(ScladProduct sp)
    {
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            sess.beginTransaction();
            sess.saveOrUpdate(sp);
            sess.beginTransaction().commit();
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return sp;        
    }
    
    /**
     * Разделить товар на складе
     * @param sc - строка для деления
     * @param nQty - отделяемый вес
     * @return 
     */
    public static boolean reziceScladProduct(int sc, BigDecimal nQty)
    {
        
        ScladProduct aSc = getScladProduct(sc);
        if(aSc.getStatus()==2)
            return false;
        
        
         // Сформируем документ списания рулона
        DocumentReturn dr = new DocumentReturn();
        dr.setAgent(new Agent(24));
        dr.setDates(new Date());
        dr.setDocumentreturn(0);
        dr.setScladproduct(aSc);
        dr.setText("Списание рулона для деления");
        IODocument.setDocumentReturn(dr);

        // Поставим на приход 2 товара которые 
        
        // новая длина
        BigDecimal nL = aSc.getLight().multiply(nQty).divide(aSc.getVes(), 6,  RoundingMode.HALF_EVEN);
        //BigDecimal nVes = newLight.multiply(sn.getVes()).divide(sn.getLight(), 6 ,RoundingMode.HALF_UP);
        
        Document d = new Document();
        d.setAgent(new Agent(14));
        d.setDates(new Date());
        d.setDel(0);
        d.setDocument(0);
        d.setNomer("Д"+new Date().getTime());
        d.setStatus(0);
        d.setVid(3);
        d = IODocument.setDocument(d);
        
        // сформируем новую строку
        DocumentJournal j1 = aSc.getDocumentjournal();
        j1.setDocument(d);
        j1.setDocumentjournal(0);
        j1.setLight(nL);
        j1.setVes(nQty);
        j1.setPrice(aSc.getPrice());
        j1.setWidth(aSc.getWidth());  
        j1.setWidthtemp(aSc.getWidth());
        j1.setLighttemp(nL);
        j1.setScladproduct(new ScladProduct(0));
        j1.setPasport(aSc.getPasport()+"Н");
        j1.setStatus(1);
        j1.setSclad(aSc.getSclad() );
        j1 = IODocument.setDocumentJournal(j1);
        
        int jj1 = j1.getDocumentjournal();
        //System.out.println("J1 = " + j1.getDocumentjournal());
        
        // сформируем старую строку
        DocumentJournal j2 = aSc.getDocumentjournal();
        j2.setDocument(d);
        j2.setDocumentjournal(0);
        j2.setWidth(aSc.getWidth());
        j2.setWidthtemp(aSc.getWidth());
        j2.setPrice(aSc.getPrice());
        j2.setStatus(1);
        j2.setLight(aSc.getLight().subtract(nL));
        j2.setVes(aSc.getVes().subtract(nQty));
        j2.setLighttemp(aSc.getLight().subtract(nL));
        j2.setScladproduct(new ScladProduct(0));
        j2.setPasport(aSc.getPasport()+"С");
        j2.setSclad(aSc.getSclad() );
        j2 = IODocument.setDocumentJournal(j2);
        
        //System.out.println("J2 = " + j2.getDocumentjournal());
        
        // закроем документ
        IODocument.Document_close(d.getDocument());
        
        
        //---------------------------------
       /* DocumentJournal aDJ = getScladProduct(sc).getDocumentjournal();
        DocumentJournal nDJ = aDJ;
        //ScladProduct aSc = getScladProduct(sc);
        //ScladProduct nSc = aSc;
        
        // новая длина
        BigDecimal nL = aDJ.getLight().multiply(nQty).divide(aDJ.getVes(), 6,  RoundingMode.HALF_EVEN);
        aDJ.setVes(aDJ.getVes().subtract(nQty));
        aDJ.setLight(nL);
        
        nDJ.setVes(nQty);
        nDJ.setLight(nDJ.getLight().subtract(aDJ.getLight()));
        */
        return true;
        
        
    }
    
    /**
     * переместить рулон на склад производства
     * @param sp - строка на склад
     * @param vid_temp_sclad - вид склада
     *      3 - склад цеха
     *      4 - склад для бейки
     * @return 
     */
    public static boolean sendProductToScladChex(int sp, int vid_temp_sclad)
    {
        ScladProduct sp1 = getScladProduct(sp);
        if(sp1.getStatus()==1)
        {
            sp1.setStatus(vid_temp_sclad);
            setScladProduct(sp1);
            return true;
        }
        return false;
    }
    
     /**
     * переместить рулон на основной склад
     * @param sp - строка на склад
     * @return 
     */
    public static boolean sendProductToSclad(int sp)
    {
        ScladProduct sp1 = getScladProduct(sp);
        if(sp1.getStatus()>2)
        {
            sp1.setStatus(1);
            setScladProduct(sp1);
            return true;
        }
        return false;
    }
    
    /**
     * 
     */
}
