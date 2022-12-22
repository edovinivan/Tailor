/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.example.logic.Agent;
import org.example.logic.Document;
import org.example.logic.DocumentJournal;
import org.example.logic.DocumentReturn;
import org.example.logic.Model;
import org.example.logic.ModelPrintDetali;
import org.example.logic.ScladLoskut;
import org.example.logic.ScladProduct;
import org.example.logic.TipNastila;
import org.example.logic.Zadacha;
import org.example.logic.ZadachaNastil;
import org.example.logic.ZadachaNastilDop;
import org.example.logic.ZadachaNastilPrintDetali;
import org.example.logic.ZadachaNastilProduct;
import org.example.logic.ZadachaProduct;
import org.example.logic.ZadachaScladProduct;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ivan
 */
public class IOZadachaNastil {
    
    /**
     * Обновить количество для деталей с принтом и вышивкой для настила
     * @param znpd
     * @param qty
     * @return 
     */
    public static boolean updateQtyForPrintDetaliNadachaNastil(int znpd, int qty)
    {
        try  
        {
            
            Session sess = HibernateUtil.getSessionFactory().openSession();  
            String sql = "update ZADACHANASTILPRINTDETALI set qty = "+ qty + " where ZADACHANASTILPRINTDETALI = " + znpd;
            
            sess.beginTransaction();
            sess.createSQLQuery(sql).executeUpdate();
            sess.beginTransaction().commit();
            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
            return false;
        }  
        return true;
    }
    /**
     * Получить все детали с принтом и вышивкой для настила
     * @param zn - настил
     * @param all - если труе то все иначе только те что больше нуля
     * @return 
     */
    public static List<ZadachaNastilPrintDetali> getListZadachaNastilPrintDetaliForZN(int zn, boolean all)
    {
        List<ZadachaNastilPrintDetali> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();  
            if(all)                
                ls = sess.createCriteria(ZadachaNastilPrintDetali.class).add(Restrictions.eq("zadachanastil", new ZadachaNastil(zn))).list();
            else
                ls = sess.createCriteria(ZadachaNastilPrintDetali.class).add(Restrictions.eq("zadachanastil", new ZadachaNastil(zn))).add(Restrictions.gt("qty", 0)).list();
            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return  ls;
    }
    /**
     * Сохранить деталь с принтом и вышивкой для настила
     * @param z
     * @return 
     */
    public static ZadachaNastilPrintDetali setZadachaNastilPrintDetali(ZadachaNastilPrintDetali z)
    {
         if(z.getZadachanastilprintdetali()==0)
            z.setZadachanastilprintdetali(null);
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();  
            sess.beginTransaction();
            sess.saveOrUpdate(z);
            sess.beginTransaction().commit();
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        } 
        return z;
    }
    
    /**
     * Разделить рулон
     * @param zsp - строка которуюру делим
     * @param newLight = новая длина
     * @return 
     */
    public static boolean reziceProduct(int zsp, BigDecimal newLight)
    {
        ZadachaScladProduct z = IOZadacha.getZadachaScladProduct(zsp);
        ScladProduct sn = z.getScladproduct();
        // Сформируем документ списания рулона
        DocumentReturn dr = new DocumentReturn();
        dr.setAgent(new Agent(24));
        dr.setDates(new Date());
        dr.setDocumentreturn(0);
        dr.setScladproduct(z.getScladproduct());
        dr.setText("Списание рулона для деления в настиле");
        IODocument.setDocumentReturn(dr);

        // Поставим на приход 2 товара которые 
        BigDecimal nVes = newLight.multiply(sn.getVes()).divide(sn.getLight(), 6 ,RoundingMode.HALF_UP);
        
        Document d = new Document();
        d.setAgent(new Agent(14));
        d.setDates(new Date());
        d.setDel(0);
        d.setDocument(0);
        d.setNomer("D"+new Date().getTime());
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
        j1.setPrice(sn.getPrice());
        j1.setWidth(sn.getWidth());
        j1.setWidthtemp(sn.getWidth());
        j1.setStatus(1);
        j1.setScladproduct(new ScladProduct(0));
        j1.setPasport("Деленный:"+sn.getPasport());
        j1 = IODocument.setDocumentJournal(j1);
        
        int jj1 = j1.getDocumentjournal();
        //System.out.println("J1 = " + j1.getDocumentjournal());
        
        // сформируем старую строку
        DocumentJournal j2 = sn.getDocumentjournal();
        j2.setDocument(d);
        j2.setDocumentjournal(0);
        j2.setPrice(sn.getPrice());
        j2.setWidth(sn.getWidth());
        j2.setWidthtemp(sn.getWidth());
        j2.setStatus(1);
        j2.setLight(sn.getLight().subtract(newLight));
        j2.setVes(sn.getVes().subtract(nVes));
        j2.setLighttemp(sn.getLight().subtract(newLight));
        j2.setScladproduct(new ScladProduct(0));
        j2.setPasport("Деленный:"+sn.getPasport());
        j2 = IODocument.setDocumentJournal(j2);
        
        //System.out.println("J2 = " + j2.getDocumentjournal());
        
        // закроем документ
        IODocument.Document_close(d.getDocument());

        // удалим старый рулон из задачи
        try  
        {
            //если рулон уже в наслите удалим его
            Session sess = HibernateUtil.getSessionFactory().openSession();  
            String sql = "delete from ZADACHANASTILPRODUCT where ZADACHASCLADPRODUCT =" + zsp;
            
            //System.out.println("\n\n\n\n\n\n" + sql + "\n\n\n\n\n\n");
            
            sess.beginTransaction();
            sess.createSQLQuery(sql).executeUpdate();
            sess.beginTransaction().commit();
            
            // удалим рулон из задачи
            sql = "delete from ZADACHASCLADPRODUCT where SCLADPRODUCT =" + sn.getScladproduct();
            sess.beginTransaction();
            sess.createSQLQuery(sql).executeUpdate();
            sess.beginTransaction().commit();
            
            // добавим новые рулоны к задаче
            ZadachaScladProduct z1 = z;
            z1.setScladproduct(IOScladProduct.getScladProductForDocumentJournal(jj1));
            //z.setScladproduct(IOScladProduct.getScladProductForDocumentJournal(93));
            z1.setZadachascladproduct(0);
            z1.setNastil(0);
            
            //System.out.println("J1 = " + jj1);
            
            IOZadacha.setZadachaScladProduct(z1);
            
            ZadachaScladProduct z2 = z;
            z2.setScladproduct(IOScladProduct.getScladProductForDocumentJournal(j2.getDocumentjournal()));
            z2.setZadachascladproduct(0);
            z2.setNastil(0);
            
            //System.out.println("J2 = " + j2.getDocumentjournal());
            
            IOZadacha.setZadachaScladProduct(z2);
            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
            return false;
        }  
        
        return true;
    }
    
    /**
     * Разделить рулон из временного склада
     * @param nastil - настил
     * @param sp - строка склада которую делим
     * @param newLight = новая длина
     * @param allProduct - если труе то добаляем весь рулон и не делим его
     * @return 
     */
    public static boolean reziceProductForScladChex(int nastil, int sp, BigDecimal newLight, boolean allProduct)
    {        
        // получим настил для которго добавляем товар
        ZadachaNastil znn = IOZadachaNastil.getListZadachaNastil(0, nastil).get(0);
        ZadachaProduct zp = null;
        // получим главный материал для задачи
        for(ZadachaProduct zz: IOZadacha.getListZadachaProduct(znn.getZadacha().getZadacha(), 0, 1))
        {
            if(zz.getModelproduct().getTipproduct().getTipproduct() == 1)
            {
                zp = zz;
                break;
            }
            zp = zz;
        }
        
        if(zp == null)
            return false;        
        
        ScladProduct sn;
        int jj1 = 0;
        sn = IOScladProduct.getScladProduct(sp);
        DocumentJournal j2 = null;
        // если добавляем весь рулон
        if(!allProduct)
        {            
            // Сформируем документ списания рулона
            DocumentReturn dr = new DocumentReturn();
            dr.setAgent(new Agent(24));
            dr.setDates(new Date());
            dr.setDocumentreturn(0);
            dr.setScladproduct(sn);
            dr.setText("Списание рулона для добавления в настил");
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
            j1.setPrice(sn.getPrice());
            j1.setWidth(sn.getWidth());
            j1.setWidthtemp(sn.getWidth());
            j1.setLighttemp(newLight);
            j1.setStatus(1);
            j1.setScladproduct(new ScladProduct(0));
            j1.setPasport("Д" + sn.getPasport());
            j1 = IODocument.setDocumentJournal(j1);

            jj1 = j1.getDocumentjournal();

            // сформируем старую строку
            j2 = sn.getDocumentjournal();
            j2.setDocument(d);
            j2.setStatus(1);
            j2.setDocumentjournal(0);
            j2.setPrice(sn.getPrice());
            j2.setWidth(sn.getWidth());
            j2.setWidthtemp(sn.getWidth());
            j2.setLight(sn.getLight().subtract(newLight));
            j2.setVes(sn.getVes().subtract(nVes));
            j2.setLighttemp(sn.getLight().subtract(newLight));
            j2.setScladproduct(new ScladProduct(0));
            j2.setPasport("Д" + sn.getPasport());

            j2 = IODocument.setDocumentJournal(j2);

            // закроем документ
            IODocument.Document_close(d.getDocument());

        }
        // удалим старый рулон из задачи
        /*try  
        {*/
            // добавим новый рулоны к задаче
            ZadachaScladProduct z1 = new ZadachaScladProduct();
            if(!allProduct)
                z1.setScladproduct(IOScladProduct.getScladProductForDocumentJournal(jj1));
            else
                z1.setScladproduct(sn);
            z1.setNastil(1);
            z1.setZadachascladproduct(0);
            z1.setZadacha(znn.getZadacha());
            z1.setZadachaproduct(zp);            
            z1 = IOZadacha.setZadachaScladProduct(z1);
            
            //добавим рулон к настилу
            ZadachaNastilProduct znp = new ZadachaNastilProduct();
            znp.setZadachanastil(znn);
            znp.setZadachanastilproduct(0);
            znp.setZadachascladproduct(z1);
            
            znp = IOZadachaNastil.setZadachaNastilProduct(znp);
            
            if(!allProduct)
            {
                // отметим новый рулон как хранящейся на временном складе
                sn = IOScladProduct.getScladProductForDocumentJournal(j2.getDocumentjournal());
                sn.setStatus(3);
                IOScladProduct.setScladProduct(sn);
            }
            //IOZadacha.setZadachaScladProduct(z2);
            
       /* }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
            return false;
        }*/  
        
        return true;
    }
    
    /**
     * Получить настил по документу возврата полотна
     * @param dr - Документ возврата на склад
     * @return - настил
     */
    public static int getZDForDocumentReturn(int dr)
    {
        List<ZadachaNastil> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();  
            ls = sess.createCriteria(ZadachaNastil.class).add(Restrictions.eq("dreturn", new Document(dr))).list();
            if(!ls.isEmpty())
            {
                return ls.get(0).getZadachanastil();
            }
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
            return 0;
        }        
        return 0;
    }
    
    
    
    /**
     * Сохранить новые параметры доп секции
     * @param z - номер доп секции
     * @param l - новая длина
     * @param q - новое колво
     * @param k - количество изделий в слое
     * @param kdop - количество изделий доп артикул
     * @return 
     */
    public static boolean setZBD(int z, int l, int q, int k, int kdop)
    {
        List<ZadachaNastilDop> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();  
            ls = sess.createCriteria(ZadachaNastilDop.class).add(Restrictions.eq("zadachanastildop", z)).list();
            if(!ls.isEmpty())
            {
                ZadachaNastilDop d = ls.get(0);
                d.setLight(l);
                d.setQty(q);
                d.setKolsloi(k);
                d.setKolsloidop(kdop);
                setZadachaNastilDop(d);
            }
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return true;
    }
    
    /**
     * Сохранить строку доп секция к настилу
     * @param z
     * @return 
     */
    public static ZadachaNastilDop setZadachaNastilDop(ZadachaNastilDop z)
    {
        if(z.getZadachanastildop()==0)
            z.setZadachanastildop(null);
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();  
            sess.beginTransaction();
            sess.saveOrUpdate(z);
            sess.beginTransaction().commit();
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        } 
        return z;
    }
    
    /**
     * удалить строку доп секция к настилу
     * @param d
     * @return 
     */
    public static boolean delZadachaNastilDop(int d)
    {
        try  
        {
            String sql = "delete from ZADACHANASTILDOP where ZADACHANASTILDOP = " + d;
            Session sess = HibernateUtil.getSessionFactory().openSession();  
            sess.beginTransaction();
            sess.createSQLQuery(sql).executeUpdate();
            sess.beginTransaction().commit();
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
            return false;
        } 
        return true;
    }
    
    /**
     * Получить доп секций для настила 
     * @param nastil - настил
     * @return 
     */
    public static List<ZadachaNastilDop> getListNastilDopForNastil(int nastil)
    {
        List<ZadachaNastilDop> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();  
            ls = sess.createCriteria(ZadachaNastilDop.class).add(Restrictions.eq("zadachanastil", nastil)).addOrder(Order.asc("name")).list();
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Получить список настилов для обшего списка
     * @param minStatus - минимальный статус
     * @param maxStatus - максимальный статус
     * @param hand - ручной стол
     * @return 
     */
    public static List<ZadachaNastil> getListAllNastil(int minStatus, int maxStatus, int hand)
    {
        List<ZadachaNastil> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();  
            if(hand == -1)
                ls = sess.createCriteria(ZadachaNastil.class).add(Restrictions.ge("status", minStatus)).add(Restrictions.le("status", maxStatus)).addOrder(Order.asc("zadacha")).list();
            else
                ls = sess.createCriteria(ZadachaNastil.class).createAlias("zadacha", "z").add(Restrictions.eq("z.hand", hand)).add(Restrictions.ge("status", minStatus)).add(Restrictions.le("status", maxStatus)).addOrder(Order.asc("zadacha")).list();
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Получить список настилов для обшего списка c периудом закрытия
     * @param minStatus - минимальный статус
     * @param maxStatus - максимальный статус
     * @param hand - ручной стол
     * @param d1
     * @param d2
     * @return 
     */
    public static List<ZadachaNastil> getListAllNastil(int minStatus, int maxStatus, int hand, Date d1, Date d2)
    {
        List<ZadachaNastil> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();  
            ls = sess.createCriteria(ZadachaNastil.class).createAlias("zadacha", "z").add(Restrictions.eq("z.hand", hand)).add(Restrictions.ge("status", minStatus)).add(Restrictions.le("status", maxStatus)).add(Restrictions.or(Restrictions.between("dateclose", d1, d2), Restrictions.eq("status", 1))).addOrder(Order.asc("status")).addOrder(Order.desc("dateclose")).list();
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Утведтить настил задачи     * 
     * @param nastil
     * @param nstatus - новый статус
     * @return 
     */
    public static int setStatusOkForNastil(int nastil, int nstatus)
    {  
        ZadachaNastil zn = getListZadachaNastil(0, nastil).get(0);
        if(zn.getStatus()>2)
            return -1;
        if(zn.getStatus()!=2)
            zn.setDateclose(new Date());
        zn.setStatus(nstatus);
        
        setZadachaNastil(zn);
        // если нужно окончательно закрыть настил
        
        ZadachaNastilProduct zz = getListZadachaNastilProduct(nastil).get(0);
        
        String sql = "update ZADACHANASTIL set TIPPOLOTNA = " + zz.getZadachascladproduct().getScladproduct().getProduct().getProduct() + " where ZADACHANASTIL = " + zz.getZadachanastil().getZadachanastil();
        Session sess = HibernateUtil.getSessionFactory().openSession();
        sess.beginTransaction();
        sess.createSQLQuery(sql).executeUpdate();
        sess.beginTransaction().commit();
        
        //создадим приход на склад Обрезков
        if(zn.getQtyend().signum()>0)
            createLoskutForNastil(nastil);
        
        if(nstatus==3)
        {
            // закроем задачу если все хорошо
            // проверим все или нет настилы закрыты и все полотна израсходованы        
            int r =IOZadacha.getCloseZadacha(zn.getZadacha().getZadacha());
            if(r==0)
                IOZadacha.setNewStatusZadacha(zn.getZadacha().getZadacha(), 3);
            
            // пометим 
            if(zn.getDreturn().getDocument()!=0)
            {
                //IODocument.setDocumentStatus(zn.getDreturn().getDocument(), 2);
                //return 0;//IODocument.Document_close(zn.getDreturn().getDocument())-1;
                return IODocument.Document_close(zn.getDreturn().getDocument())-1;
            }
        }
        
        
        
        return 0;
    }
    
    
    /**
     * Проверить был ли сформирован приход лоскутов на склад если нет то сформируем этот приход
     * @param zn1
     * @return 
     */
    public static int createLoskutForNastil(int zn1)
    {
        ZadachaNastil zn = getListZadachaNastil(0, zn1).get(0);
        if(zn.getQtyend().signum()==0)
            return 0;
        
        ScladLoskut sl = IOScladLoskut.getScladLoskutForZN(zn1);
        if(sl.getScladloskut()==0)
        {
            sl.setDates(new Date());
            sl.setOstatok(zn.getQtyend());
            sl.setProduct(zn.getTippolotna());
            sl.setQty(zn.getQtyend());
            sl.setStatus(0);
            sl.setZadachanastil(zn);
            IOScladLoskut.setScladLoskut(sl);
            
            IOOperationHistory.saveOperationHistory("Создали приход полотна", zn1, 1);
        }        
        return 0;
    }
    
    
    /**
     * Открыть настил задачи     * 
     * @param nastil
     * @param nstatus - новый статус
     * @return 
     */
    public static int setStatusEditForNastil(int nastil, int nstatus)
    {
        
        ZadachaNastil zn = getListZadachaNastil(0, nastil).get(0);
        //System.out.println("\n\n\n\nСтатус = " + zn.getStatus());
        if(zn.getStatus()>3)
            return -1;
        if(zn.getZadacha().getStatus()>3)
            return -2;
        
        //проверим нет ли лоскутов на складе
        if(zn.getQtyend().signum()>0)
        {
            ScladLoskut sl = IOScladLoskut.getScladLoskutForZN(nastil);
            //если лоскут на складе есть
            if(sl.getScladloskut() != 0)
            {
                //если уже приняли то выходим
                if(sl.getStatus()!=0)
                    return -4;               
                IOScladLoskut.delScladLoskut(sl.getScladloskut());
            }
            
        }
        //4645613654
        // удалим возвращаемые полотна
        if(nstatus == 0)
        {
            if(zn.getDreturn().getDocument()!=0)
            {
                Session sess = HibernateUtil.getSessionFactory().openSession();
                String sql = "delete from documentjournal where document = " + zn.getDreturn().getDocument();
                sess.beginTransaction();
                sess.createSQLQuery(sql).executeUpdate();
                sess.beginTransaction().commit();
                
                //удалим ссылку в настиле на докумен
                sql = "update zadachanastil set dreturn = 0 where zadachanastil = " + zn.getZadachanastil();
                sess.beginTransaction();
                sess.createSQLQuery(sql).executeUpdate();
                sess.beginTransaction().commit();
                
                sql = "delete from document where document = " + zn.getDreturn().getDocument();
                sess.beginTransaction();
                sess.createSQLQuery(sql).executeUpdate();
                sess.beginTransaction().commit();
                
                zn.setDreturn(new Document(0));
            }
        }
        
        // проверить использование возвращаемых полотен
        if(nstatus == 1)
        {
            if(zn.getDreturn().getDocument()>0)
            {
                String sql;
                BigInteger k;
                Session sess = HibernateUtil.getSessionFactory().openSession();
                for(DocumentJournal dj: IODocument.getListDocumentJournal(zn.getDreturn().getDocument()))
                {
                    sql = "select count(ZADACHASCLADPRODUCT) from ZADACHASCLADPRODUCT where scladproduct = (select scladproduct from scladproduct where documentjournal = " + dj.getDocumentjournal()+")";
                    k = (BigInteger)sess.createSQLQuery(sql).uniqueResult();
                    if(k.intValue()>0)
                        return -3;
                }
                // откроем накладную возарата
                IODocument.Document_open(zn.getDreturn().getDocument());
                // удалим возвращаемые полотна
                sql = "delete from documentjournal where document = " + zn.getDreturn().getDocument();
                sess.beginTransaction();
                sess.createSQLQuery(sql).executeUpdate();
                sess.beginTransaction().commit();
                
                //удалим ссылку в настиле на докумен
                sql = "update zadachanastil set dreturn = 0 where zadachanastil = " + zn.getZadachanastil();
                sess.beginTransaction();
                sess.createSQLQuery(sql).executeUpdate();
                sess.beginTransaction().commit();
                
                sql = "delete from document where document = " + zn.getDreturn().getDocument();
                sess.beginTransaction();
                sess.createSQLQuery(sql).executeUpdate();
                sess.beginTransaction().commit();
                
                zn.setDreturn(new Document(0));
                
            }
        }
        zn.setStatus(nstatus);
        setZadachaNastil(zn);
        // если нужно вернуть товары со клада 
        /*if(nstatus==1)
        {            
            if(zn.getDreturn().getDocument()!=0)
                return IODocument.Document_open(zn.getDreturn().getDocument());
        }*/
        return 0;
    }
    /**
     * Проверить настил на расписанные веса и вес всего настила
     * @param zn
     * @return 
     */
    public static boolean executeNastilForQty(int zn)
    {
        //получим общий вес настила
        BigDecimal all_qty = new BigDecimal(0);
        for(ZadachaNastilProduct p : getListZadachaNastilProduct(zn))
            all_qty  = all_qty.add(p.getZadachascladproduct().getScladproduct().getVes());
        // получим вес расписанных по возвратам
        BigDecimal zn_qty = new BigDecimal(0);
        ZadachaNastil z = getListZadachaNastil(0, zn).get(0);
        zn_qty = zn_qty.add(z.getQtyaddarticle());
        zn_qty = zn_qty.add(z.getQtydel());
        zn_qty = zn_qty.add(z.getQtyend());
        zn_qty = zn_qty.add(z.getQtygut());
        zn_qty = zn_qty.add(z.getQtylosk());
        zn_qty = zn_qty.add(z.getQtyreturn());
        zn_qty = zn_qty.add(z.getQtytruba());
        zn_qty = zn_qty.add(z.getQtynull());
        zn_qty = zn_qty.add(z.getQtybeika());
        //System.out.println("Сумма весов использованных =" + zn_qty .setScale(4, RoundingMode.HALF_UP).toString());
        //System.out.println("Сумма весов взятых =" + all_qty .setScale(4, RoundingMode.HALF_UP).toString());
        return all_qty.compareTo(zn_qty)==0;
    }
    
    /**
     * Проверить настил возвращаемого материала на возврат в настиле
     * @param zn
     * @return 
     */
    public static boolean executeNastilForQtyReturn(int zn)
    {
        ZadachaNastil z = getListZadachaNastil(0, zn).get(0);
        if(z.getQtyreturn().signum()==0)
            return true;
                
        BigDecimal qs = new BigDecimal(0);
        for(DocumentJournal dj: IODocument.getListDocumentJournal(z.getDreturn().getDocument()))
            qs = qs.add(dj.getVes());
        //System.out.println("вес возврата по полотнам =" + qs.setScale(4, RoundingMode.HALF_UP).toString());
        //System.out.println("вес возврата по настилу =" + z.getQtyreturn().setScale(4, RoundingMode.HALF_UP).toString());
        return qs.compareTo(z.getQtyreturn())==0;
    }
    
    
    /**
     * Сохранить настил для задачи
     * @param p - объект
     * @return - объект
     */
    public static ZadachaNastil setZadachaNastil(ZadachaNastil p)
    {
        int znow = 0;
        if(p.getZadachanastil()== 0)
            p.setZadachanastil(null);
        else
            znow = p.getZadachanastil();
        
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
        
        // если настил новый то добавим все детали с принтом ы вышивкой
        if(znow==0)
        {
            ZadachaNastil pp = getListZadachaNastil(0, p.getZadachanastil()).get(0);
            ZadachaNastilPrintDetali zp;
            for(ModelPrintDetali m: IOModel.getListModelPrintDetali(pp.getZadacha().getModel().getModel(), -1, 1))
            {
                zp = new ZadachaNastilPrintDetali();
                zp.setModelprintdetali(m);
                zp.setQty(0);
                zp.setZadachanastil(pp);
                zp.setZadachanastilprintdetali(0);
                setZadachaNastilPrintDetali(zp);
            }
            
            for(ModelPrintDetali m: IOModel.getListModelPrintDetali(pp.getZadacha().getModel().getModel(), -1, 2))
            {
                zp = new ZadachaNastilPrintDetali();
                zp.setModelprintdetali(m);
                zp.setQty(0);
                zp.setZadachanastil(pp);
                zp.setZadachanastilprintdetali(0);
                setZadachaNastilPrintDetali(zp);
            }
            
            for(ModelPrintDetali m: IOModel.getListModelPrintDetali(pp.getZadacha().getModel().getModel(), -1, 3))
            {
                zp = new ZadachaNastilPrintDetali();
                zp.setModelprintdetali(m);
                zp.setQty(0);
                zp.setZadachanastil(pp);
                zp.setZadachanastilprintdetali(0);
                setZadachaNastilPrintDetali(zp);
            }
            
            /*ZadachaNastilDop zp;
            for(ZadachaRazmeri r: IOZadacha.getListZadachaRazmeri(p.getZadacha().getZadacha(), 0))
            {
                zp = new ZadachaNastilDop();
                zp.setLight(0);
                zp.setQty(0);
                zp.setZadachanastil(p.getZadachanastil());
                zp.setZadachanastildop(0);
                zp.setZadacharazmeri(r);
                setZadachaNastilDop(zp);
            }*/
        }
        
        return p;
        
    }
    
    /**
     * Получить список настилов задачи
     * @param zadacha- ид задачи
     * @param zn - номер задача-настил -1 все этой задачи
     * @return 
     */
    public static List<ZadachaNastil> getListZadachaNastil(int zadacha, int zn)
    {
        List<ZadachaNastil> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            if(zn == -1)
                ls = sess.createCriteria(ZadachaNastil.class).add(Restrictions.eq("zadacha", new Zadacha(zadacha))).list();            
            else
                ls = sess.createCriteria(ZadachaNastil.class).add(Restrictions.eq("zadachanastil", zn)).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Получить список товаров для настила
     * @param zn - номер задача-настил 
     * @return 
     */
    public static List<ZadachaNastilProduct> getListZadachaNastilProduct(int zn)
    {
        List<ZadachaNastilProduct> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(ZadachaNastilProduct.class).add(Restrictions.eq("zadachanastil", new ZadachaNastil(zn))).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Получить список товаров которые отобрали для этой задачи
     * @param z - номер задачи
     * @return 
     */
    public static List<ZadachaScladProduct> getListZadachaScladProduct(int z)
    {
        List<ZadachaScladProduct> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(ZadachaScladProduct.class).add(Restrictions.eq("nastil", 0)).add(Restrictions.eq("zadacha", new Zadacha(z))).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Добавить товар к настилу
     * @param p
     * @return 
     */
    public static ZadachaNastilProduct setZadachaNastilProduct(ZadachaNastilProduct p)
    {
        if(p.getZadachanastilproduct()== 0)
            p.setZadachanastilproduct(null);
        
        Session sess = HibernateUtil.getSessionFactory().openSession();
        try 
        {
            sess.beginTransaction();
            sess.saveOrUpdate(p);
            sess.beginTransaction().commit();
            // отметим товар из задачи как выбранный
            ZadachaScladProduct s = p.getZadachascladproduct();
            s.setNastil(1);
            sess.beginTransaction();
            sess.saveOrUpdate(s);
            sess.beginTransaction().commit();
            
            //отметим товар как тип полотна в настиле
            /*String sql = "update ZADACHANASTIL set TIPPOLOTNA = " + p.getZadachascladproduct().getScladproduct().getProduct().getProduct() + " where ZADACHANASTIL = " + p.getZadachanastil().getZadachanastil();
            sess.beginTransaction();
            sess.createSQLQuery(sql).executeUpdate();
            sess.beginTransaction().commit();*/
            
            //System.out.println("\n\n\n\n\n\n\n"+ sql + "\n\n\n\n\n");
            
            
        }catch(HibernateException e)
        {
            System.out.println("ERROR SAVE" + e);            
        }
        return p;
    }
    
    /**
     * Удалить товар из настила
     * @param zn - задачи настил
     * @param zsp - товар задачи настила
     * @return 
     */
    public static boolean delZadachaNastilProduct(int zn, int zsp)
    {        
        List<ZadachaNastilProduct> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(ZadachaNastilProduct.class).add(Restrictions.eq("zadachascladproduct", new ZadachaScladProduct(zsp))).add(Restrictions.eq("zadachanastil", new ZadachaNastil(zn))).list();            
            if(ls.isEmpty())
                return false;
            ZadachaScladProduct s = ls.get(0).getZadachascladproduct();
            s.setNastil(0);
            
            // удалим строку принадлежности товара к настилу
            sess.beginTransaction();
            sess.delete(ls.get(0));
            sess.beginTransaction().commit();
                        
            // сохраним изменение что товар свободен для выбора в настил
            sess.beginTransaction();
            sess.saveOrUpdate(s);
            sess.beginTransaction().commit();
            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return true;   
    }
    
    /**
     * Удалить настил из задачи
     * @param zn - задачи настил
     * @return 
     */
    public static boolean delZadachaNastil(int zn)
    {        
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            // пометим товары из настила как не использованные
            sess.beginTransaction();
            String s = "update ZADACHASCLADPRODUCT set nastil = 0 where ZADACHASCLADPRODUCT in (select ZADACHASCLADPRODUCT from ZADACHANASTILPRODUCT where ZADACHANASTIL = " + zn + ")";
            sess.createSQLQuery(s).executeUpdate();
            sess.beginTransaction().commit();
            //удалим все товары из настила
            sess.beginTransaction();
            s = "delete from ZADACHANASTILPRODUCT where ZADACHANASTIL = " + zn;
            sess.createSQLQuery(s).executeUpdate();
            sess.beginTransaction().commit();
            
            //удалим доп секции настила
            sess.beginTransaction();
            s = "delete from ZADACHANASTILDOP where ZADACHANASTIL = " + zn;
            sess.createSQLQuery(s).executeUpdate();
            sess.beginTransaction().commit();
            
            //удалим детали с принтом и вышивкой
            sess.beginTransaction();
            s = "delete from ZADACHANASTILPRINTDETALI where ZADACHANASTIL = " + zn;
            sess.createSQLQuery(s).executeUpdate();
            sess.beginTransaction().commit();
            
            //удалим настил
            sess.beginTransaction();
            s = "delete from ZADACHANASTIL where ZADACHANASTIL = " + zn;
            sess.createSQLQuery(s).executeUpdate();
            sess.beginTransaction().commit();
            
            
           
        } catch (HibernateException e) {
            System.out.println("ERROR UPADTE" + e);
            return false;
        }        
        
        return true;
    }
    
    
    /**
     * Получить общий вес настила по отпущенным полотнам
     * @param zn - номер настила
     * @return 
     */
    public static BigDecimal getAllVesForZadachaNastil(int zn)
    {
        String sql;
        BigDecimal vall;
        Session sess = HibernateUtil.getSessionFactory().openSession();
        sql = "select coalesce(sum(sp1.ves),0) from zadachanastilproduct znp1 inner join zadachascladproduct zsp1 on zsp1.zadachascladproduct = znp1.zadachascladproduct inner join scladproduct sp1 on zsp1.scladproduct = sp1.scladproduct where znp1.zadachanastil = " + zn;
        vall = (BigDecimal)sess.createSQLQuery(sql).uniqueResult();
        return vall; 
    }
    
    /**
     * Получить список настилов для артикула за дату
     * @param art - артикул
     * @param d1
     * @param d2
     * @return 
     */
    public static List<ZadachaNastil> getListNastilForArticle(int art, Date d1, Date d2)
    {
        List<ZadachaNastil> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();  
            ls = sess.createCriteria(ZadachaNastil.class)
                    .createAlias("zadacha", "z")
                    .add(Restrictions.eq("z.model", new Model(art)))
                    .add(Restrictions.between("dateclose", d1, d2))
                    .add(Restrictions.eq("tipnastila", new TipNastila(1)))
                    .add(Restrictions.between("status", 2, 10))
                    .addOrder(Order.asc("dateclose")).list();
            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
}
