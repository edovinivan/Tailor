/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import org.example.logic.DocumentF;
import org.example.logic.DocumentFJournal;
import org.example.logic.FurnituraChex;
import org.example.logic.FurnituraOff;
import org.example.logic.FurnituraOffAll;
import org.example.logic.GetHistoryFurnitura;
import org.example.logic.ScladProduct;
import org.example.logic.ScladProductF;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ivan
 */
public class IODocumentF {
     /**
     * Получить список документов    
     * @param d1 - дата с
     * @param d2 - дата по
     * @return 
     */
    public static List<DocumentF> getListDocumentF(Date d1, Date d2)
    {
        List<DocumentF> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            int chex = IOOperator.operator.getRabotnikgruppa().getRabotnikgruppa();
            if(chex == 0)
                ls = sess.createCriteria(DocumentF.class).add(Restrictions.between("dates", d1, d2)) .addOrder(Order.desc("dates")).list();            
            else
                ls = sess.createCriteria(DocumentF.class).add(Restrictions.eq("chex", IOOperator.operator.getRabotnikgruppa() )).add(Restrictions.between("dates", d1, d2)) .addOrder(Order.desc("dates")).list();            
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
    public static DocumentF getDocumentF(int d)
    {
        List<DocumentF> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(DocumentF.class).add(Restrictions.eq("documentf", d)).list();            
            if(ls.isEmpty())
                ls.add(new DocumentF(0));
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
            ls.add(new DocumentF(0));
        }        
        return ls.get(0);    
    }
    
    
    
    
    /**
     * Сохранить заголовок документа
     * @param p - документ
     * @return - документ
     */
    public static DocumentF setDocumentF(DocumentF p)
    {
        if(p.getDocumentf()== 0)
            p.setDocumentf(null);
        
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
     * Получить список строк для документа
     * @param d - номер документа
     * @return 
     */
    public static List<DocumentFJournal> getListDocumentFJournal(int d)
    {
        List<DocumentFJournal> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(DocumentFJournal.class).add(Restrictions.eq("documentf", new DocumentF(d))).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;    
    }
   
    
    /**
     * Получить документ
     * @param d
     * @return 
     */
    public static DocumentFJournal getDocumentFJournal(int d)
    {
        List<DocumentFJournal> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(DocumentFJournal.class).add(Restrictions.eq("documentfjournal", d)).list();            
            if(ls.isEmpty())
                ls.add(new DocumentFJournal(0));
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
            ls.add(new DocumentFJournal(0));
        }        
        return ls.get(0);    
    }
    
     /**
     * Получить строку по строке остатка в документу
     * @param d - номер документа
     * @param sc - номер строки на складе
     * @return 
     */
    public static DocumentFJournal getDocumentFJournal(int d, int sc)
    {
        List<DocumentFJournal> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(DocumentFJournal.class).add(Restrictions.eq("documentf", new DocumentF(d))).add(Restrictions.eq("scladproduct", new ScladProduct(sc))).list();            
            if(ls.isEmpty())
                ls.add(new DocumentFJournal(0));
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
            ls.add(new DocumentFJournal(0));
        }        
        return ls.get(0);    
    }
    
    
    /**
     * Сохранить строку документа
     * @param p - документ
     * @return - документ
     */
    public static DocumentFJournal setDocumentFJournal(DocumentFJournal p)
    {
        if(p.getDocumentfjournal()== 0)
            p.setDocumentfjournal(null);
        
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
     * Удалить строку
     * @param j
     * @return 
     */
    public static boolean delDocumentFJournal(int j)
    {
        DocumentFJournal d = getDocumentFJournal(j);
        if(d.getDocumentfjournal()!=0)
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            try 
            {
                Transaction transaction = sess.beginTransaction();
                sess.delete(d);
                transaction.commit();

            } catch (HibernateException e) {
                System.out.println("ERROR SAVE" + e);
                return false;
            }
        }
        return true;
    }
    
    /**
     * Удалить документ
     * @param d - документ
     * @return 
     */
    public static int delDocumentF(int d)
    {
        DocumentF dd = getDocumentF(d);
        if(dd.getDocumentf()==0)
            return -1;
        if(dd.getStatus()!=0)
            return -2;

        for(DocumentFJournal j : getListDocumentFJournal(d))
        {
            if(!delDocumentFJournal(j.getDocumentfjournal()))
                return -4;
        }
        
        Session sess = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction transaction = sess.beginTransaction();
            sess.delete(dd);
            transaction.commit();

        } catch (HibernateException e) {
            System.out.println("ERROR SAVE" + e);
            return -3;
        }

        return 0;
    }
    
    /**
     * Переместить документ перемещения фурнитуры в цех
     * @param dd
     * @return 
     */
    public static int sendDocumentF(int dd)
    {
        DocumentF d = getDocumentF(dd);
        if(d.getDocumentf()==0)
            return -1;
        if(d.getStatus()!=0)
            return -2;
        //ScladProductF sf;
        List<DocumentFJournal> ls = getListDocumentFJournal(dd);
        if(ls.isEmpty())
            return -3;
        ScladProduct sp;
        // проверим что хватает количества
        for(DocumentFJournal df: ls)
        {
            if(df.getScladproduct().getWidth().subtract(df.getQty()).signum()<0)
            {
                JOptionPane.showMessageDialog(null, "Нехватает фурнитуры " + df.getScladproduct().getProduct().getName() + " для перемещения нужного количества.");        
                return -4;
            }
        }
        for(DocumentFJournal df: ls)
        {
            /*sf = new ScladProductF();
            sf.setDocumentfjournal(df);
            sf.setQty(df.getQty());
            sf.setOstatok(df.getQty());
            sf.setScladproductf(0);*/
            //вычтем количество на складе
            //if(setScladProductF(sf).getScladproductf()>0)
            
            //вычтем количество на складе
            sp = df.getScladproduct();
            sp.setWidth(sp.getWidth().subtract(df.getQty()));
            if(sp.getWidth().signum()==0)
                sp.setStatus(2);
            IOScladProduct.setScladProduct(sp);
            
            /*sf = new ScladProductF();
            sf.setDocumentfjournal(df);
            sf.setQty(df.getQty());
            sf.setOstatok(df.getQty());
            sf.setScladproductf(0);*/
            //вычтем количество на складе
            /*if(setScladProductF(sf).getScladproductf()>0)
            {
                sp = df.getScladproduct();
                sp.setWidth(sp.getWidth().subtract(sf.getQty()));
                if(sp.getWidth().signum()==0)
                    sp.setStatus(2);
                IOScladProduct.setScladProduct(sp);
            }*/
            
        }
        d.setStatus(1);
        setDocumentF(d);        
        return 0;
    }
    
     /**
     * подтвердить перемещение фурнитурыв цеху
     * @param dd
     * @return 
     */
    public static int closeDocumentF(int dd)
    {
        DocumentF d = getDocumentF(dd);
        if(d.getDocumentf()==0)
            return -1;
        if(d.getStatus()!=1)
            return -2;
        ScladProductF sf;
        List<DocumentFJournal> ls = getListDocumentFJournal(dd);
        if(ls.isEmpty())
            return -3;
        //ScladProduct sp;        
        for(DocumentFJournal df: ls)
        {
            sf = new ScladProductF();
            sf.setDocumentfjournal(df);
            sf.setQty(df.getQty());
            sf.setOstatok(df.getQty());
            sf.setScladproductf(0);     
            setScladProductF(sf);            
        }
        d.setStatus(2);
        setDocumentF(d);        
        return 0;
    }
    
    /**
     * Отменить прием документа перемещения фурнитуры в цеху
     * @param dd
     * @return 
     */
    public static int openDocumentF(int dd)
    {
        DocumentF d = getDocumentF(dd);
        if(d.getDocumentf()==0)
            return -1;
        if(d.getStatus()!=2)
            return -2;
        ScladProductF sf;
        List<DocumentFJournal> ls = getListDocumentFJournal(dd);
        if(ls.isEmpty())
            return -3;
        
        // провим на использование
        for(DocumentFJournal df: ls)
        {
            sf = getScladProductFForDFJ(df.getDocumentfjournal());
            if(getFurnituraOffForFC(sf.getScladproductf()).getFurnituraoff()!=0)
            {
                JOptionPane.showMessageDialog(null, "Фурнитура <" + sf.getDocumentfjournal().getScladproduct().getProduct().getName() + "> уже используется! Открытие невозможно!");
                return -4;
            }
        }
        ScladProduct sp;        
        for(DocumentFJournal df: ls)
        {
            sf = getScladProductFForDFJ(df.getDocumentfjournal());
            //sp = sf.getDocumentfjournal().getScladproduct();            
            //sp.setWidth(sp.getWidth().add(sf.getQty()));
            //if(sp.getStatus()==2)
            //    sp.setStatus(1);
            //IOScladProduct.setScladProduct(sp);
            delScladProductF(sf.getScladproductf());        
        }
        d.setStatus(1);
        setDocumentF(d);        
        return 0;
    }
    
    /**
     * Вернуть фурнитуру из цеха в склад
     * @param dd
     * @return 
     */
    public static int reSendDocumentF(int dd)
    {
        DocumentF d = getDocumentF(dd);
        if(d.getDocumentf()==0)
            return -1;
        if(d.getStatus()!=1)
            return -2;
        //ScladProductF sf;
        List<DocumentFJournal> ls = getListDocumentFJournal(dd);
        if(ls.isEmpty())
            return -3;
        
       
        ScladProduct sp;
        
        for(DocumentFJournal df: ls)
        {
            //sf = getScladProductFForDFJ(df.getDocumentfjournal());
            sp = df.getScladproduct();            
            sp.setWidth(sp.getWidth().add(df.getQty()));
            if(sp.getStatus()==2)
                sp.setStatus(1);
            IOScladProduct.setScladProduct(sp);            
        }
        d.setStatus(0);
        setDocumentF(d);        
        return 0;
    }
    
    
    /**
     * Записать строку на складе
     * @param sf
     * @return 
     */
    public static ScladProductF setScladProductF(ScladProductF sf)
    {
         if(sf.getScladproductf()== 0)
            sf.setScladproductf(null);
        
        Session sess = HibernateUtil.getSessionFactory().openSession();
        try 
        {
            Transaction transaction = sess.beginTransaction();
            sess.saveOrUpdate(sf);
            transaction.commit();
            
        }catch(HibernateException e)
        {
            System.out.println("ERROR SAVE" + e);            
        }
        return sf;
    }
    
    /**
     * получить строку на складе
     * @param sf
     * @return 
     */
    public static ScladProductF getScladProductF(int sf)
    {
        List<ScladProductF> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(ScladProductF.class).add(Restrictions.eq("scladproductf", sf)).list();            
            if(ls.isEmpty())
                ls.add(new ScladProductF(0));
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
            ls.add(new ScladProductF(0));
        }        
        return ls.get(0);   
    }
    
    /**
     * получить строку на складе по строке перемещения
     * @param dj - строка перемещения
     * @return 
     */
    public static ScladProductF getScladProductFForDFJ(int dj)
    {
        List<ScladProductF> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(ScladProductF.class).add(Restrictions.eq("documentfjournal", new DocumentFJournal(dj))).list();            
            if(ls.isEmpty())
                ls.add(new ScladProductF(0));
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
            ls.add(new ScladProductF(0));
        }        
        return ls.get(0);   
    }
    
    /**
     * Удалить строку со склада
     * @param f
     * @return 
     */
    public static boolean delScladProductF(int f)
    {
        ScladProductF ff = getScladProductF(f);
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = sess.beginTransaction();
            sess.delete(ff);
            transaction.commit();
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
            return false;
        }
        return true;
    }
    
    /**
     * Получить список фурнитуры для цеха
     * @param c
     * @return 
     */
    public static List<FurnituraChex> getListFurnituraChex(int c)
    {
        List<FurnituraChex> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            if(c == 0)
                ls = sess.createCriteria(FurnituraChex.class).add(Restrictions.gt("qty", BigDecimal.ZERO)).addOrder(Order.asc("product")).list();            
            else
                ls = sess.createCriteria(FurnituraChex.class).add(Restrictions.eq("cid", c)).add(Restrictions.gt("qty", BigDecimal.ZERO)).addOrder(Order.asc("product")).list();                        
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;   
    }
    
     /**
     * Записать строку списания фурнитуры в цехе
     * @param f
     * @return 
     */
    public static FurnituraOff setFurnituraOff(FurnituraOff f)
    {
         if(f.getFurnituraoff()== 0)
            f.setFurnituraoff(null);
        
        Session sess = HibernateUtil.getSessionFactory().openSession();
        try 
        {
            Transaction transaction = sess.beginTransaction();
            sess.saveOrUpdate(f);
            transaction.commit();
            ScladProductF sf = f.getScladproductf();
            sf.setOstatok(sf.getOstatok().subtract(f.getQty()));
            setScladProductF(sf);
            
        }catch(HibernateException e)
        {
            System.out.println("ERROR SAVE" + e);            
        }
        return f;
    }
    
    /**
     * получить строку списания
     * @param f
     * @return 
     */
    public static FurnituraOff getFurnituraOff(int f)
    {
        List<FurnituraOff> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(FurnituraOff.class).add(Restrictions.eq("furnituraoff", f)).list();            
            if(ls.isEmpty())
                ls.add(new FurnituraOff(0));
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
            ls.add(new FurnituraOff(0));
        }        
        return ls.get(0);   
    }

    /**
     * Получить список списаний для цеха
     * @param c
     * @param d1
     * @param d2
     * @return 
     */
    public static List<FurnituraOffAll> getListFurnituraOffAll(int c, Date d1, Date d2)
    {
        List<FurnituraOffAll> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            if(c == 0)
                ls = sess.createCriteria(FurnituraOffAll.class).add(Restrictions.between("dates", d1, d2)).addOrder(Order.asc("dates")).list();            
            else
                ls = sess.createCriteria(FurnituraOffAll.class).add(Restrictions.eq("cid", c)).add(Restrictions.between("dates", d1, d2)).addOrder(Order.asc("dates")).list();            
            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);                        
        }        
        return ls;   
    }
    
    /**
     * Записать строку списания фурнитуры в цехе
     * @param f
     * @return 
     */
    public static int delFurnituraOff(int f)
    {
        FurnituraOff ff = getFurnituraOff(f);
        // прибавим количество
        ScladProductF sf = ff.getScladproductf();
        sf.setOstatok(sf.getOstatok().add(ff.getQty()));
        setScladProductF(sf);
        
        Session sess = HibernateUtil.getSessionFactory().openSession();
        try 
        {
            Transaction transaction = sess.beginTransaction();
            sess.delete(ff);
            transaction.commit();            
            
        }catch(HibernateException e)
        {
            System.out.println("ERROR SAVE" + e);            
        }
        return f;
    }
    
    /**
     * получить строку списания по строке фурнитуры в цехе
     * @param f
     * @return 
     */
    public static FurnituraOff getFurnituraOffForFC(int f)
    {
        List<FurnituraOff> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(FurnituraOff.class).add(Restrictions.eq("scladproductf", new ScladProductF(f))).list();            
            if(ls.isEmpty())
                ls.add(new FurnituraOff(0));
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
            ls.add(new FurnituraOff(0));
        }        
        return ls.get(0);   
    }
    
    /**
     * Получить историю фурнитуры
     * @param furn - фурнитура
     * @param sps - номер строки, если 0 то все строки
     * @return 
     */
    public static List<GetHistoryFurnitura> getGetHistoryFurnitura (int furn, int sps)
    {
        List<GetHistoryFurnitura> ls = new ArrayList<>();
        
        Session sess;
        try 
        {
            sess = HibernateUtil.getSessionFactory().openSession();            
            Query query = sess.getNamedQuery("GETHISTORYFURNITURA")
                    .setParameter("furn", furn)
                    .setParameter("sps", sps);

            ls = (List<GetHistoryFurnitura>)query.list();
            
        }catch(HibernateException ex)
        {     
            System.out.println("ERROR GET12");                
        }
        return ls;
    }
   
}
