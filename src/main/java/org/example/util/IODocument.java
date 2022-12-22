/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import org.example.logic.Agent;
import org.example.logic.Color;
import org.example.logic.Document;
import org.example.logic.DocumentJournal;
import org.example.logic.DocumentReturn;
import org.example.logic.FurnituraScladAll;
import org.example.logic.Product;
import org.example.logic.Sclad;
import org.example.logic.ScladProduct;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ivan
 */
public class IODocument {
    
    /**
     * Установить документу статус
     * @param doc - Документ
     * @param st - Новый статус
     * @return 
     */
    public static boolean setDocumentStatus(int doc, int st)
    {        
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            sess.beginTransaction();
            String s = "update document set status = " + st + " where document = " + doc;
            sess.createSQLQuery(s).executeUpdate();
            sess.beginTransaction().commit();
            
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
            return false;
        }
        return true;            
    }
    
    
    /**
     * Получить список  возвращаемых товаров
     * @param d - дата с
     * @param vid - вид
     * @return 
     */
    public static List<DocumentReturn> getListDocumentReturn(Date d, int vid)
    {
        List<DocumentReturn> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            if(vid == 2)
                ls = sess.createCriteria(DocumentReturn.class).createAlias("scladproduct", "sp").add(Restrictions.ge("dates", d)).add(Restrictions.eq("sp.vid", vid)).addOrder(Order.desc("dates")).list();            
            if(vid == 1)
                ls = sess.createCriteria(DocumentReturn.class).createAlias("scladproduct", "sp").add(Restrictions.ne("agent", new Agent(14))).add(Restrictions.ge("dates", d)).add(Restrictions.eq("sp.vid", vid)).addOrder(Order.desc("dates")).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;    
    }
    
    /**
     * Получить  возвращаемых товаров
     * @param dr - dr
     * @return 
     */
    public static DocumentReturn getDocumentReturn(int dr)
    {
        List<DocumentReturn> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(DocumentReturn.class).add(Restrictions.eq("documentreturn", dr)).list();            
            if(ls.isEmpty())
                ls.add(new DocumentReturn(0));
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
            ls.add(new DocumentReturn(0));
        }        
        return ls.get(0);    
    }
    
    /**
     * Сохранить возвращаемый товар
     * @param dr - DR
     * @return 
     */
    public static DocumentReturn setDocumentReturn(DocumentReturn dr)
    {
        if(dr.getDocumentreturn()==0)
            dr.setDocumentreturn(null);
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            sess.beginTransaction();
            sess.saveOrUpdate(dr);
            sess.beginTransaction().commit();
            // пометим на складе что товар удален
            if(dr.getScladproduct().getVid()==1)
            {
                ScladProduct sp = IOScladProduct.getScladProduct(dr.getScladproduct().getScladproduct());
                sp.setStatus(2);
                sess.beginTransaction();
                sess.saveOrUpdate(sp);
                sess.beginTransaction().commit();
            }
            else // если фурнитура
            {
                ScladProduct sp = IOScladProduct.getScladProduct(dr.getScladproduct().getScladproduct());
                sp.setWidth(sp.getWidth().subtract(dr.getQty()));
                sess.beginTransaction();
                sess.saveOrUpdate(sp);
                sess.beginTransaction().commit();
            }
            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return dr;    
    }
    
    
    /**
     * del возвращаемый товар
     * @param d - DR
     * @return 
     */
    public static boolean delDocumentReturn(int d)
    {
        DocumentReturn dr = getDocumentReturn(d);
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            // пометим на складе что товар возвращен
            ScladProduct sp = IOScladProduct.getScladProduct(dr.getScladproduct().getScladproduct());
            if(sp.getVid()==1)
                sp.setStatus(1);
            else
                sp.setWidth(sp.getWidth().add(dr.getQty()));
            sess.beginTransaction();
            sess.saveOrUpdate(sp);
            sess.beginTransaction().commit();
            
            sess.beginTransaction();
            sess.delete(dr);
            sess.beginTransaction().commit();
            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
            return false;    
        }        
        return true;    
    }
    
    
    
    /**
     * Получить список товаров
     * @param vid     - вид 
     * @param d1 - дата с
     * @param d2 - дата по
     * @return 
     */
    public static List<Document> getListDocument(int vid, Date d1, Date d2)
    {
        List<Document> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            //if(vid == 2)
                ls = sess.createCriteria(Document.class).add(Restrictions.eq("vid", vid)).add(Restrictions.eq("del", 0)).add(Restrictions.between("dates", d1, d2)) .addOrder(Order.desc("dates")).list();            
            //else
            //    ls = sess.createCriteria(Document.class).add(Restrictions.eq("document", doc)).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;    
    }
    
    /**
     * Получить список товаров
     * @return 
     */
    public static List<Document> getListDocumentForReturnSclad()
    {
        List<Document> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(Document.class).add(Restrictions.eq("status", 2)).addOrder(Order.desc("dates")).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;    
    }
    
    /**
     * Получить документ
     * 
     * @param d
     * @return 
     */
    public static Document getDocument(int d)
    {
        List<Document> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(Document.class).add(Restrictions.eq("document", d)).list();            
            if(ls.isEmpty())
                ls.add(new Document(0));
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
            ls.add(new Document(0));
        }        
        return ls.get(0);    
    }
    
    
    /**
     * Сохранить заголовок документа
     * @param p - документ
     * @return - документ
     */
    public static Document setDocument(Document p)
    {
        if(p.getDocument()== 0)
            p.setDocument(null);
        
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
     * Получить строку документа
     * @param j
     * @return 
     */
    public static DocumentJournal getDocumentJournal(int j)
    {
        List<DocumentJournal> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(DocumentJournal.class).add(Restrictions.eq("documentjournal", j)).list();            
            if(ls.isEmpty())
                ls.add(new DocumentJournal(0));
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
            ls.add(new DocumentJournal(0));
        }        
        return ls.get(0);    
    }
    
    /**
     * Сохранить строку документа
     * @param p - документ
     * @return - документ
     */
    public static DocumentJournal setDocumentJournal(DocumentJournal p)
    {
        if(p.getDocumentjournal()== 0)
            p.setDocumentjournal(null);
        
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
     * Получить товары документа
     * @param d - документ
     * @return 
     */
    public static List<DocumentJournal> getListDocumentJournal(int d)
    {
        List<DocumentJournal> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(DocumentJournal.class).add(Restrictions.eq("document", new Document(d))).add(Restrictions.eq("del", 0)).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;    
    }
    
    /**
     * Отработка документа поставки
     * @param doc - номер документа
     * @return - результат
     * 0 - документ не закрыт
     * 1 - все закрыли
     */
    public static int Document_close(int doc)
    {
        int p;
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            sess.beginTransaction();
            String s = "select result from DOCUMENT_CLOSE("+doc+")";
            p =  new BigInteger(sess.createSQLQuery(s).uniqueResult().toString()).intValue();
            sess.beginTransaction().commit();
            
        } catch (HibernateException e) {
            System.out.println("ERROR close document" + e);
            return -1;
        }        
        return p;
    }
    
    /**
     * удалить документ
     * @param doc - Документ
     * @return 
     */
    public static boolean delDocument(int doc)
    {
        Document d = getDocument(doc);
        if(d.getStatus()!=0)        
            return false;
        
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            sess.beginTransaction();
            String s = "update documentjournal set del = 1 where document = " + doc;
            sess.createSQLQuery(s).executeUpdate();
            sess.beginTransaction().commit();
            
            sess.beginTransaction();
            s = "update document set del = 1 where document = " + doc;
            sess.createSQLQuery(s).executeUpdate();
            sess.beginTransaction().commit();
            
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
            return false;
        }
        return true;            
    }
    
    /**
     * Улалить строку документа
     * @param dj -строка 
     * @return 
     */
    public static boolean delDocumentJournal(int dj)
    {
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            sess.beginTransaction();
            String s = "delete from documentjournal where documentjournal = " + dj;
            sess.createSQLQuery(s).executeUpdate();
            sess.beginTransaction().commit();
            
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
            return false;
        }        
        return true;
    }
    
    /**
     * Открыть документ
     * @param doc - номер документв
     * @return 
     */
    public static int Document_open(int doc)
    {
        int p;
        Document dd = getDocument(doc);
        
        try 
        {
            //System.out.println("1");
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            String sql = "select count(dr.scladproduct) from documentreturn dr inner join scladproduct sp on sp.scladproduct = dr.scladproduct inner join documentjournal dj on dj.documentjournal = sp.documentjournal where dj.document = " + doc;
            
            
            //    return -1;
            int dr = new BigInteger(sess.createSQLQuery(sql).uniqueResult().toString()).intValue();
            if(dr>0)
                return -2;
            
            // если документ фурнитуры
            if(dd.getVid()==2)
            {
                sql = "select count(dj.documentjournal) from documentjournal dj inner join scladproduct sp on sp.documentjournal = dj.documentjournal inner join documentfjournal df on df.scladproduct = sp.scladproduct where dj.document = " + doc;
                dr = new BigInteger(sess.createSQLQuery(sql).uniqueResult().toString()).intValue();
                if(dr>0)
                    return -3;                                
            }//select count(dj.documentjournal) from documentjournal dj inner join scladproduct sp on sp.documentjournal = dj.documentjournal inner join documentfjournal df on df.scladproduct = sp.scladproduct where dj.document = 2151

            
            //System.out.println("2");
            // проверим строки на использование в работе
            sql = "select count(dj.documentjournal) from documentjournal dj inner join scladproduct sp on dj.documentjournal = sp.documentjournal where sp.status = 2 and dj.document = " + doc;
            dr = new BigInteger(sess.createSQLQuery(sql).uniqueResult().toString()).intValue();
            if(dr>0)
                return -3;
            //System.out.println("3");
            sess.beginTransaction();
            String s = "select result from DOCUMENT_OPEN("+doc+")";
            p =  new BigInteger(sess.createSQLQuery(s).uniqueResult().toString()).intValue();
            sess.beginTransaction().commit();
            //System.out.println("4");
        } catch (HibernateException e) {
            System.out.println("ERROR open document" + e);
            return -1;
        }        
        return p;
    }
    
    
    
    public static void test()
    {
        Document d;
        DocumentJournal dj;
        for(int i=0;i<200;i++)
        {
            Random r = new Random(new Date().getTime());
            
            d = new Document();
            d.setAgent(new Agent(4+r.nextInt(6)));
            d.setDates(new Date());
            d.setDel(0);
            d.setDocument(0);
            d.setNomer("N"+r.nextInt(999));
            d.setStatus(0);
            d.setVid(1);
            d = IODocument.setDocument(d);
            for(int j=0;j<50;j++)
            {
                dj = new DocumentJournal();
                dj.setColor(new Color(1+r.nextInt(88)));
                dj.setDel(0);
                dj.setDocument(d);
                dj.setDocumentjournal(0);
                dj.setLight(new BigDecimal(r.nextInt(50)));
                dj.setLighttemp(dj.getLight());
                dj.setPasport("p" + r.nextInt(10000));
                dj.setPrice(new BigDecimal(r.nextInt(25)));
                dj.setProduct(new Product(72+r.nextInt(65)));
                dj.setSclad(new Sclad(1+r.nextInt(3)));
                dj.setScladproduct(new ScladProduct(0));
                dj.setStatus(1);
                dj.setVes(new BigDecimal(10+r.nextInt(30)));
                dj.setWidth(new BigDecimal(100+ r.nextInt(50)));
                dj.setWidthtemp(dj.getWidth());
                IODocument.setDocumentJournal(dj);
            }
            IODocument.Document_close(d.getDocument());
            System.out.println(">>>> " + i);
        }
    }
    
    /**
     * Изменить цену товара в закрытой накладной
     * @param j - номер строки
     * @param np - новая цена
     * @return 
     */
    public static boolean updatePriceJournal(int j, BigDecimal np)
    {
        DocumentJournal dj = getDocumentJournal(j);
        dj.setPrice(np);
        setDocumentJournal(dj);
        ScladProduct sp = IOScladProduct.getScladProductForDocumentJournal(j);
        sp.setPrice(np);
        IOScladProduct.setScladProduct(sp);
        return true;
    }
    
    /**
     * Получить фурнитуру на складе
     * @return 
     */
    public static List<FurnituraScladAll> getListFurnituraScladAll()
    {
        List<FurnituraScladAll> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(FurnituraScladAll.class).addOrder(Order.asc("product")).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;    
    }
}
