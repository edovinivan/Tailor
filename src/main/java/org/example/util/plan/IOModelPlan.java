/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.util.plan;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.example.logic.Color;
import org.example.logic.Model;
import org.example.logic.Product;
import org.example.logic.Razmeri;
import org.example.logic.plan.PModelPlan;
import org.example.logic.plan.PModelPlanProduct;
import org.example.logic.plan.PModelPlanRazmeri;  
import org.example.logic.plan.PTimeChex;
import org.example.logic.plan.PZakupkiJournal;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.example.util.HelpClass;
import org.example.util.HibernateUtil;

/**
 *
 * @author ivan
 */
public class IOModelPlan {
    
    /**
     * Сохранить объект
     * @param p - объект
     * @return - объект
     */
    public static PModelPlan setPModelPlan(PModelPlan p)
    {
        if(p.getPmodelplan()== 0)
            p.setPmodelplan(null);
        
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
     * Получить список объектов
     * @param d1
     * @param d2
     * @return 
     */
    public static List<PModelPlan> getListPModelPlan(Date d1, Date d2)
    {
        List<PModelPlan> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();            
            ls = sess.createCriteria(PModelPlan.class).add(Restrictions.between("dates", d1, d2)).addOrder(Order.desc("dates")).list();                        
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Получить список объектов
     * @param d1
     * @param d2
     * @return 
     */
    public static List<PModelPlan> getListPModelPlanForNoChex(Date d1, Date d2)
    {
        List<PModelPlan> ls1 = new ArrayList<>();
        List<PModelPlan> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();            
            ls1 = sess.createCriteria(PModelPlan.class).add(Restrictions.between("dates", d1, d2)).addOrder(Order.desc("dates")).list();                        
            for(PModelPlan p: ls1)
                if(p.getNoChex()>0)
                    ls.add(p);
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        //System.out.println("ZZZZZ = " + ls.size());            
        return ls;        
    }
    
    
    /**
     * Изменить количество в строке плана задачи
     * @param pmr - строка количество - размер
     * @param qty - новое количество
     * @return 
     */
    public static PModelPlanRazmeri updateQtyPModelPlanRazmeri(int pmr, int qty)
    {
        
        List<PModelPlanRazmeri> ls = new ArrayList<>();
        PModelPlanRazmeri r = null;
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();            
            ls = sess.createCriteria(PModelPlanRazmeri.class).add(Restrictions.eq("pmodelplanrazmeri", pmr)).list();                        
            if(!ls.isEmpty())
            {
                r = ls.get(0);
                r.setQty(qty);
                setPModelPlanRazmeri(r);
            }
            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return r;        
    }
    
    /**
     * Получить объектов
     * @param p
     * @return 
     */
    public static PModelPlan getPModelPlan(int p)
    {
        List<PModelPlan> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();            
            ls = sess.createCriteria(PModelPlan.class).add(Restrictions.eq("pmodelplan", p)).list();                        
            if(ls.isEmpty())
                ls.add(new PModelPlan(0));
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
            ls.add(new PModelPlan(0));
        }        
        return ls.get(0);        
    }
    
    /**
     * Удалить объект
     * @param p - ид объекта
     * @return - результат
     */
    public static int delPModelPlan(int p)
    {
        if(IOZakupki.getListPZakupkiJournalForPMpdelPlan(p).size()>0)
            return -2;
        
        PModelPlan p1 = getPModelPlan(p);
        if(p1.getStatus()>1)
            return -1;
        
        PTimeChex p2 = IOTimeOpChex.getPTimeChexForPModel(p);
        if(p2.getPtimechex()!=0)
            return -3;
        
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            
            //удалим строку в заголовке задач
            sess.beginTransaction();
            String s = "delete from P_MODELPLANHAUPTJOURNAL where P_MODELPLAN = " + p;
            sess.createSQLQuery(s).executeUpdate();
            sess.beginTransaction().commit();
            
            
            sess.beginTransaction();
            s = "delete from P_MODELPLANRAZMERI where P_MODELPLAN = " + p;
            sess.createSQLQuery(s).executeUpdate();
            sess.beginTransaction().commit();
            
            sess.beginTransaction();
            s = "delete from P_MODELPLANPRODUCT where P_MODELPLAN = " + p;
            sess.createSQLQuery(s).executeUpdate();
            sess.beginTransaction().commit();
            
            sess.beginTransaction();
            s = "delete from P_MODELPLAN where P_MODELPLAN = " + p;
            sess.createSQLQuery(s).executeUpdate();
            sess.beginTransaction().commit();
            
            //проверим. Если удалили все планы из глобальной задачи, то удалим заголовок глобальной задачи
            
            
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
            return -3;
        }        
        return 0;
        
    }
    
    
    /**
     * Удалить все товары для задачи на производство
     * @param m - 
     * @return 
     */
    public static int delModelPlanProductForMP(int m)
    {
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
                        
            
            sess.beginTransaction();
            String s = "delete from P_MODELPLANPRODUCT where P_MODELPLAN = " + m;
            sess.createSQLQuery(s).executeUpdate();
            sess.beginTransaction().commit();
            
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
            return -1;
        }
        return 0;
    }
    
    
    /**
     * Удалить все размеры для задачи на производство
     * @param m - 
     * @return 
     */
    public static int delModelPlanRarmeriForMP(int m)
    {
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
                        
            
            sess.beginTransaction();
            String s = "delete from P_MODELPLANRAZMERI where P_MODELPLAN = " + m;
            sess.createSQLQuery(s).executeUpdate();
            sess.beginTransaction().commit();
            
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
            return -1;
        }
        return 0;
    }
    
    /**
     * Получить операции для модели
     * @param m
     * @param q
     * @return 
     */
    public static List<String> getTimeForModel(int m, int q)
    {
        List<String> ls = new ArrayList<>();
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            sess.beginTransaction();
            String s = " select  og.name || '<!>' || sum(mo.times * "+q+")   from modeloperation mo\n" +
                       " inner join operation o on o.operation = mo.operation\n" +
                       " inner join operationgruppa og on o.operationgruppa = og.operationgruppa\n" +
                       " where mo.model = "+m+" group by og.name";            
            ls = sess.createSQLQuery(s).list();
            sess.beginTransaction().commit();
            sess.close();            
        } catch (HibernateException e) {
            System.out.println("ERROR close document" + e);
        }        
        return ls;
        
    }
    
    /**
     * Получить загуренность по цехам
     * @param d1
     * @param d2
     * @return 
     */
    public static List<String> getTimeForModelPlan(Date d1, Date d2)
    {
        List<String> ls = new ArrayList<>();
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            sess.beginTransaction();
            String s = "select rg1.name || '<!>' || og1.name || '<!>' || coalesce(pl.tim,0)  || '<!>' || pt.times\n"
                    + "from p_timeopchex pt\n"
                    + "left join (\n"
                    + " select\n"
                    + "   rg.rabotnikgruppa as chex,\n"
                    + "   rg.name as chexname,\n"
                    + "   og.operationgruppa as og,\n"
                    + "   og.name as ogname,\n"
                    + "   sum(mo.times * mp.qty) as tim\n"
                    + " from p_modelplan mp\n"
                    + " inner join rabotnikgruppa rg on mp.chex = rg.rabotnikgruppa\n"
                    + " inner join modeloperation mo on mo.model = mp.model\n"
                    + " inner join operation o on o.operation = mo.operation\n"
                    + " inner join operationgruppa og on o.operationgruppa = og.operationgruppa\n"
                    + " where mp.dates between '"+HelpClass.getPrintDate1(d1) +"' and '"+HelpClass.getPrintDate1(d2) +"'\n"
                    + " group by rg.name, rg.rabotnikgruppa, og.operationgruppa, og.name) pl on pl.chex = pt.chex and pl.og = pt.operationgruppa\n"
                    + " inner join operationgruppa og1 on og1.operationgruppa = pt.operationgruppa\n"
                    + " inner join rabotnikgruppa rg1 on pt.chex = rg1.rabotnikgruppa\n"
                    + " order by  rg1.name, og1.name";            
            ls = sess.createSQLQuery(s).list();
            sess.beginTransaction().commit();
            sess.close();            
        } catch (HibernateException e) {
            System.out.println("ERROR close document" + e);
        }        
        return ls;
        
    }
    
    /**
     * Получить объектов
     * @param model - модель
     * @param color - цвет
     * @param razmer - размер
     * @param d - дата
     * @return 
     */
    public static PModelPlan getPModelPlanForDublicat(int model, int color, int razmer, Date d)
    {
        List<PModelPlan> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();            
            ls = sess.createCriteria(PModelPlan.class)
                    .add(Restrictions.eq("model", new Model(model)))
                    .add(Restrictions.eq("color", new Color(color)))
                    .add(Restrictions.eq("razmeri", new Razmeri(razmer)))
                    .add(Restrictions.eq("dates", d))
                    .list();                        
            if(ls.isEmpty())
                ls.add(new PModelPlan(0));
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
            ls.add(new PModelPlan(0));
        }        
        return ls.get(0);        
    }
    
    /**
     * Получить список запланированных изделий для молдели
     * @param model
     * @param d1
     * @param d2
     * @return 
     */
    public static List<PModelPlan> getListPModelForModel(int model, Date d1, Date d2)
    {
        List<PModelPlan> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();            
            ls = sess.createCriteria(PModelPlan.class).add(Restrictions.eq("model", new Model(model))).add(Restrictions.between("dates", d1, d2)).addOrder(Order.desc("dates")).list();                        
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    
    /**
     * Получить список запланированных изделий которые распределили
     * @param d1
     * @param d2
     * @return 
     */
    public static List<PTimeChex> getListPModelPlanForTime(Date d1, Date d2)
    {
        List<PTimeChex> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();            
            ls = sess.createCriteria(PTimeChex.class).createAlias("pmodelplan", "pp").add(Restrictions.between("pp.dates", d1, d2)).addOrder(Order.desc("pp.dates")).list();                        
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    
    /**
     * Сохранить объект
     * @param p - объект
     * @return - объект
     */
    public static PModelPlanRazmeri setPModelPlanRazmeri(PModelPlanRazmeri p)
    {
        if(p.getPmodelplanrazmeri()== 0)
            p.setPmodelplanrazmeri(null);
        
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
     * Сохранить объект
     * @param p - объект
     * @return - объект
     */
    public static PModelPlanRazmeri savePModelPlanRazmeri(PModelPlanRazmeri p)
    {
        PModelPlanRazmeri p1 = getPModelPlanRazmeri(p.getPmodelplan().getPmodelplan(), p.getRazmeri().getRazmeri());
        if(p1.getPmodelplanrazmeri()!=0)
        {
            p1.setQty(p1.getQty() + p.getQty());
            p1.setTx(p1.getTx() + " " + p.getTx());
            p = p1;
        }
        
        return setPModelPlanRazmeri(p);
    }
    
    
    public static PModelPlanRazmeri getPModelPlanRazmeri(int modelplan, int razmer)
    {
        List<PModelPlanRazmeri> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();            
            ls = sess.createCriteria(PModelPlanRazmeri.class).add(Restrictions.eq("pmodelplan", new PModelPlan(modelplan))).add(Restrictions.eq("razmeri", new Razmeri(razmer))).list();                        
            if(ls.isEmpty())
                ls.add(new PModelPlanRazmeri(0));
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
            ls.add(new PModelPlanRazmeri(0));
        }        
        return ls.get(0);        
    }
    
    
    
    /**
     * получить размеры для запланорованной задачи
     * @param mp - номер задачи
     * @return 
     */
    public static List<PModelPlanRazmeri> getListPModelPlanRazmeriForPlan(int mp)
    {
        List<PModelPlanRazmeri> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();            
            ls = sess.createCriteria(PModelPlanRazmeri.class).add(Restrictions.eq("pmodelplan", new PModelPlan(mp))).list();                        
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Сохранить объект
     * @param p - объект
     * @return - объект
     */
    public static PModelPlanProduct setPModelPlanProduct(PModelPlanProduct p)
    {
        if(p.getPmodelplanproduct()== 0)
            p.setPmodelplanproduct(null);
        
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
     * Получить список объектов
     * @param pm
     * @return 
     */
    public static List<PModelPlanProduct> getListPModelPlanProduct(int pm)
    {
        List<PModelPlanProduct> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();            
            ls = sess.createCriteria(PModelPlanProduct.class).add(Restrictions.eq("pmodelplan", new PModelPlan(pm))).list();                        
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Получить список объектов
     * @param pm
     * @return 
     */
    public static PModelPlanProduct getPModelPlanProduct(int pm)
    {
        List<PModelPlanProduct> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();            
            ls = sess.createCriteria(PModelPlanProduct.class).add(Restrictions.eq("pmodelplanproduct", pm)).list();                        
            if(ls.isEmpty())
                ls.add(new PModelPlanProduct(0));
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
            ls.add(new PModelPlanProduct(0));
        }        
        return ls.get(0);        
    }
    
    /**
     * Получить список объектов
     * @param pm
     * @param qty - 
     * @return 
     */
    public static PModelPlanProduct setQtyForPModelPlanProduct(int pm, BigDecimal qty)
    {
        List<PModelPlanProduct> ls;// = new ArrayList<>();
        PModelPlanProduct p = null;
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();            
            ls = sess.createCriteria(PModelPlanProduct.class).add(Restrictions.eq("pmodelplanproduct", pm)).list();                        
            if(!ls.isEmpty())
            {
                p = ls.get(0);
                p.setQty(qty);
                setPModelPlanProduct(p);
            }
            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return p;        
    }
    
    /**
     * Получить список зчдач где используется полотно нужного цвета в задаче на покупку
     * @param zakupki
     * @param product
     * @param color
     * @return 
     */
    public static List<PModelPlanProduct>  getPModelPlanProductForZakupkiForColorAndProduct(int zakupki, int product, int color)
    {
        List<PModelPlanProduct> ls = new ArrayList<>();
        //PModelPlanProduct p = null;
        List<PModelPlan> l1 = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();            
            for(PZakupkiJournal t : IOZakupki.getListPZakupkiJournal(zakupki))            
                l1.add(t.getPmodelplan());           
            
            ls = sess.createCriteria(PModelPlanProduct.class).add(Restrictions.in("pmodelplan", l1)).add(Restrictions.eq("product", new Product(product))).add(Restrictions.eq("color", new Color(color))).list();                        
                        
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
}
