/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.example.logic.Agent;
import org.example.logic.Document;
import org.example.logic.DocumentJournal;
import org.example.logic.DocumentReturn;
import org.example.logic.ScladProduct;
import org.example.logic.Zadacha;
import org.example.logic.ZadachaDopScladProduct;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ivan
 */
public class IOZadachaDopSP {
    /**
     * Добавить доп материал для задачи
     * @param zadacha - номер задачи
     * @param sp1 - номер строки на складе
     * @param newLight - новая длина
     * @param allProduct - взять весь рулон
     * @return 
     */
    public static boolean addDopScladProductForZadacha(int zadacha, int sp1, BigDecimal newLight, boolean allProduct)
    {
        ScladProduct sn = IOScladProduct.getScladProduct(sp1);
        // если нужно разделить рулон
        
        if(!allProduct)
        {
            DocumentJournal j2 = null;
            int jj1 = 0;
            // Сформируем документ списания рулона
            DocumentReturn dr = new DocumentReturn();
            dr.setAgent(new Agent(24));
            dr.setDates(new Date());
            dr.setDocumentreturn(0);
            dr.setScladproduct(sn);
            dr.setText("Списание рулона для добавления к задаче");
            IODocument.setDocumentReturn(dr);

            // Поставим на приход 2 товара которые 
            BigDecimal nVes = newLight.multiply(sn.getVes()).divide(sn.getLight(), 6, RoundingMode.HALF_UP);

            Document d = new Document();
            d.setAgent(new Agent(14));
            d.setDates(new Date());
            d.setDel(0);
            d.setDocument(0);
            d.setNomer("D" + new Date().getTime());
            d.setStatus(0);
            d.setVid(3);
            d = IODocument.setDocument(d);

            // сформируем новую строку
            DocumentJournal j1 = sn.getDocumentjournal();
            j1.setDocument(d);
            j1.setDocumentjournal(0);
            j1.setLight(newLight);
            j1.setVes(nVes);
            j1.setLighttemp(newLight);
            j1.setScladproduct(new ScladProduct(0));
            j1.setPasport("Д" + sn.getPasport());
            j1 = IODocument.setDocumentJournal(j1);

            jj1 = j1.getDocumentjournal();

            // сформируем старую строку
            j2 = sn.getDocumentjournal();
            j2.setDocument(d);
            j2.setDocumentjournal(0);
            j2.setLight(sn.getLight().subtract(newLight));
            j2.setVes(sn.getVes().subtract(nVes));
            j2.setLighttemp(sn.getLight().subtract(newLight));
            j2.setScladproduct(new ScladProduct(0));
            j2.setPasport("Д" + sn.getPasport());

            j2 = IODocument.setDocumentJournal(j2);

            // закроем документ
            IODocument.Document_close(d.getDocument());
            
            sn = IOScladProduct.getScladProductForDocumentJournal(j2.getDocumentjournal());
            sn.setStatus(4);
            IOScladProduct.setScladProduct(sn);
            
            sn = IOScladProduct.getScladProductForDocumentJournal(jj1);
        }
        
        ZadachaDopScladProduct zp = new ZadachaDopScladProduct();
        zp.setZadacha(new Zadacha(zadacha));
        zp.setScladproduct(sn);
        zp.setZadachadopscladproduct(0);
        zp = setZadachaDopScladProduct(zp);
        
        //отметим что рулон уже выбран
        sn.setStatus(2);
        IOScladProduct.setScladProduct(sn);
        
        return zp.getZadachadopscladproduct()>0;
    }
    /**
     * Сохранить доп материал для задачи
     * @param p - объект
     * @return - объект
     */
    public static ZadachaDopScladProduct setZadachaDopScladProduct(ZadachaDopScladProduct p)
    {
        if(p.getZadachadopscladproduct()== 0)
            p.setZadachadopscladproduct(null);
        
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
     * Получить список доп материалов для задачи
     * @param z - задача
     * @return 
     */
    public static List<ZadachaDopScladProduct> getListZadachaDopScladProduct(int z)
    {
        List<ZadachaDopScladProduct> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(ZadachaDopScladProduct.class).add(Restrictions.eq("zadacha", new Zadacha(z))).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Получить доп материал для задачи
     * @param dsp - задача
     * @return 
     */
    public static ZadachaDopScladProduct getZadachaDopScladProduct(int dsp)
    {
        List<ZadachaDopScladProduct> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(ZadachaDopScladProduct.class).add(Restrictions.eq("zadachadopscladproduct", dsp)).list();            
            if(ls.isEmpty())
                ls.add(new ZadachaDopScladProduct(0));
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
            ls.add(new ZadachaDopScladProduct(0));
        }        
        return ls.get(0);        
    }
    
    /**
     * Удалить доп материал для задачи
     * @param dsp
     * @return 
     */
    public static boolean delZadachaDopScladProduct(int dsp)
    {
        ZadachaDopScladProduct z = getZadachaDopScladProduct(dsp);
        try  
        {
            //отметим что товар вернулся на склад
            ScladProduct sp = z.getScladproduct();
            sp.setStatus(4);
            IOScladProduct.setScladProduct(sp);
            
            Session sess = HibernateUtil.getSessionFactory().openSession();
            sess.beginTransaction();
            sess.delete(z);
            sess.beginTransaction().commit();
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
            return false;
        } 
        return true;
    }
}
