/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.util;

import org.example.Gui.Plan.PlanArticle.ArticleRazmerGruppa;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.example.dto.MegaReportDto;
import org.example.logic.Color;
import org.example.logic.Files;
import org.example.logic.LModel1;
import org.example.logic.Model;
import org.example.logic.ModelChex;
import org.example.logic.ModelFiles;
import org.example.logic.ModelKleevaya;
import org.example.logic.ModelOperation;
import org.example.logic.ModelPrintDetali;
import org.example.logic.ModelProduct;
import org.example.logic.ModelSablon;
import org.example.logic.RabotnikGruppa;
import org.example.logic.Razmeri;
import org.example.logic.Zadacha;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;

/**
 *
 * @author ivan
 */
public class IOModel {
    /**
     * Установить цену для 1 изделия модели
     * @param m - номер модели
     * @param price - цена новая
     * @return 
     */
    public static boolean setPriceForModel(int m, BigDecimal price)
    {
        Model mod = getListModel(m, 0, true).get(0);
        mod.setPrice(price);
        setModel(mod);
        return true;
    }
    /**
     * Использыется или нет кк в комплектовке задач
     * @param m - модель
     * @return true - используется
     */
    public static boolean getModelForZadachaKomplektovka(int m)
    {
        String sql = "select count(m.model) from model m inner join zadacha z on z.model = m.model inner join zadachakomplektovka zk on zk.zadacha = z.zadacha where zk.status > 1 and  m.model = " + m;
        int l=1;
        try 
        {
            
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            Transaction transaction = sess.beginTransaction();
            l = (Integer)sess.createSQLQuery(sql).uniqueResult();
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
            return true;
        }        
        return l!=0;
    }

    /**
     * Копировать модель
     * @param ml - cтарая модель
     * @return - новая модель
     */
    public static int copyModel(int ml)
    {
        // скопируем модель
        Model m = getListModel(ml, 1, true).get(0);
        m.setHmodel(new Model(ml));
        m.setModel(0);
        m.setStatus(0);
        m.setDates(new Date());
        m.setArticle("Копия " + m.getArticle());
        if(m.getFirstrazmeri().getDel() == 1){
            m.setFirstrazmeri(new Razmeri(0));
            m.setEndrazmeri(new Razmeri(0));
        }
        m = setModel(m);
        // скопируем все материалы
        for(ModelProduct mp: getListModelProduct(ml, -1, 0))
        {
            mp.setModel(m);
            mp.setModelproduct(0);
            setModelProduct(mp);            
        }
        // скопируем детали с принтом и вышивкой
        for(ModelPrintDetali pd: getListModelPrintDetali(ml, -1, 1))
        {
            pd.setModel(m);
            pd.setModelprintdetali(0);
            setModelPrintDetali(pd);
        }
        
        for(ModelPrintDetali pd: getListModelPrintDetali(ml, -1, 2))
        {
            pd.setModel(m);
            pd.setModelprintdetali(0);
            setModelPrintDetali(pd);
        }
        // cкопируем клеевые детали
        for(ModelKleevaya mk: getListModelKleevaya(ml, -1))
        {
            mk.setModel(m);
            mk.setModelkleevaya(0);
            setModelKleevaya(mk);
        }
        
        // скопируем шаблоны
        for(ModelSablon ms:getListModelSablon(ml, -1))
        {
            ms.setModel(m);
            ms.setModelsablon(0);
            setModelSablon(ms);
        }
        // скопирыем операции
        for(ModelOperation mo: getListModelOperation(ml, -1))
        {
            mo.setModel(m.getModel());
            mo.setModeloperation(0);
            setModelOperation(mo);
        }
        // скопируем файлы
        Files f;
        for(ModelFiles mf :getListModelFiles(ml, 0))
        {
            f = mf.getFiles();
            f.setFiles(0);
            f = IOFiles.setFiles(f);
            mf.setFiles(f);
            mf.setModel(m);
            mf.setModelfiles(0);
            setModelFiles(mf);
        }        
        return m.getModel();
    }
    
    /**
     * Копировать модель для внесения изменения в закрытую
     * @param ml - cтарая модель
     * @return - новая модель
     */
    public static int copyModel1(int ml)
    {
        
        // скопируем модель
        Model m = getListModel(ml, 1, true).get(0);
        m.setStatus(3);
        //сохраним модель
        m = setModel(m);
        
        m.setHmodel(new Model(ml));
        m.setModel(0);
        m.setStatus(0);
        m.setDates(new Date());
        m.setArticle("Копия " + m.getArticle());
        if(m.getFirstrazmeri().getDel() == 1){
            m.setFirstrazmeri(new Razmeri(0));
            m.setEndrazmeri(new Razmeri(0));
        }
        m = setModel(m);
        // скопируем все материалы
        for(ModelProduct mp: getListModelProduct(ml, -1, 0))
        {
            mp.setModel(m);
            mp.setModelproduct(0);
            setModelProduct(mp);            
        }
        // скопируем детали с принтом и вышивкой
        for(ModelPrintDetali pd: getListModelPrintDetali(ml, -1, 1))
        {
            pd.setModel(m);
            pd.setModelprintdetali(0);
            setModelPrintDetali(pd);
        }
        
        for(ModelPrintDetali pd: getListModelPrintDetali(ml, -1, 2))
        {
            pd.setModel(m);
            pd.setModelprintdetali(0);
            setModelPrintDetali(pd);
        }
        // cкопируем клеевые детали
        for(ModelKleevaya mk: getListModelKleevaya(ml, -1))
        {
            mk.setModel(m);
            mk.setModelkleevaya(0);
            setModelKleevaya(mk);
        }
        
        // скопируем шаблоны
        for(ModelSablon ms:getListModelSablon(ml, -1))
        {
            ms.setModel(m);
            ms.setModelsablon(0);
            setModelSablon(ms);
        }
        // скопирыем операции
        for(ModelOperation mo: getListModelOperation(ml, -1))
        {
            mo.setModel(m.getModel());
            mo.setModeloperation(0);
            setModelOperation(mo);
        }
        // скопируем файлы
        Files f;
        for(ModelFiles mf :getListModelFiles(ml, 0))
        {
            f = mf.getFiles();
            f.setFiles(0);
            f = IOFiles.setFiles(f);
            mf.setFiles(f);
            mf.setModel(m);
            mf.setModelfiles(0);
            setModelFiles(mf);
        }        
        return m.getModel();
    }
    /**
     * Узнать используется или нет модель в заданиях
     * @param m - модель
     * @return 
     */
    public static boolean getTrueModelInZadacha(int m)
    {
        List<Zadacha> ls;// = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(Zadacha.class).add(Restrictions.eq("model", new Model(m))).list();            
            return !ls.isEmpty();
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
            return true;
        }        
    }
    
    /**
     * Изменить статус модели
     * @param mod
     * @param st
     * @return 
     */
    public static boolean updateStatusModel(int mod, int st)
    {
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            Transaction transaction = sess.beginTransaction();
            String s = "update Model set status = "+st+" where Model = " + mod;
            sess.createSQLQuery(s).executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
            return false;
        }        
        return true;
    }
    
    /**
     * Изменить главный артикул модели
     * @param mod
     * @param st
     * @return 
     */
    public static boolean updateHArticleForModel(int mod, String st)
    {
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            Transaction transaction = sess.beginTransaction();
            String s = "update Model set harticle = '"+st+"' where Model = " + mod;
            sess.createSQLQuery(s).executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
            return false;
        }        
        return true;
    }
    
    
    
    /**
     * Сохранить объект
     * @param p - объект
     * @return - объект
     */
    public static Model setModel(Model p)
    {
        if(p.getModel()== 0)
            p.setModel(null);
        
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
     * Получить список объектов
     * @param p - id объекта
     * @param status - статус
     * @param all - все или только не старые
     * @return 
     */
    public static List<Model> getListModel(int p, int status, boolean all)
    {
        List<Model> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            if(p == -1)
            {
                if(status == -1)
                {
                    if(all)
                        ls = sess.createCriteria(Model.class).add(Restrictions.eq("del", 0)).addOrder(Order.asc("article")).list();            
                    else
                        ls = sess.createCriteria(Model.class).add(Restrictions.eq("del", 0)).add(Restrictions.ne("status", 3)).addOrder(Order.asc("article")).list();            
                }
                else
                {
                    //if(all)
                    ls = sess.createCriteria(Model.class).add(Restrictions.eq("del", 0)).add(Restrictions.ge("status", status)).add(Restrictions.le("status", 2)).addOrder(Order.asc("article")).list();            
                    //else
                    //    ls = sess.createCriteria(Model.class).add(Restrictions.eq("del", 0)).add(Restrictions.ge("status", status)).add(Restrictions.le("status", 2)).addOrder(Order.asc("article")).list();            
                        
                }
            }
            else
                ls = sess.createCriteria(Model.class).add(Restrictions.eq("model", p)).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    
    /**
     * Получить список артикулов которые не удалены и в работе
     * @return 
     */
    public static List<Model> getListModelNotDel()
    {
        List<Model> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(Model.class).add(Restrictions.eq("del", 0)).add(Restrictions.between("status", 1,2)).list();            
                
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Получить список артикулов с uheggjq gthdjuj hfpvthf
     * @return 
     */
    public static List<ArticleRazmerGruppa> getListModelRazmerGruppa()
    {
        List<String> ls = new ArrayList<>();
        try  
        {
            String sql = "select m.article || '<!>' || r.razmerigruppa from model m\n" +
                         "inner join razmeri r on r.razmeri = m.firstrazmeri\n" +
                         "where m.del = 0 and m.status between 1 and 2";
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createSQLQuery(sql).list();            
                
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }     
        List<ArticleRazmerGruppa> rez = ls.stream()
                .map(t->{
                    return new ArticleRazmerGruppa(t.split("<!>")[0].replace("/", "").replace("-", "").replace(" ", ""), Integer.parseInt(t.split("<!>")[1]));
                })
                .collect(Collectors.toList());
        return rez;        
    }
    
    
    
    /**
     * Получить объектов
     * @param p - id объекта
     * @return 
     */
    public static Model getModel(int p)
    {
        List<Model> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();            
            ls = sess.createCriteria(Model.class).add(Restrictions.eq("model", p)).list();            
            if(ls.isEmpty())
                ls.add(new Model(0));
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
            ls.add(new Model(0));
        }        
        return ls.get(0);        
    }
    
    
    
    /**
     * Получить список моделей
     * @param all - все или только не старые
     * @return 
     */
    public static List<LModel1> getListLModel1(boolean all)
    {
        List<LModel1> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            if(all)
                ls = sess.createCriteria(LModel1.class).addOrder(Order.asc("article")).list();            
            else
                ls = sess.createCriteria(LModel1.class).add(Restrictions.ne("status", 3)).addOrder(Order.asc("article")).list();            
                
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Получить список объектов
     * @param str - строка для поиска
     * @return 
     */
    public static List<LModel1> getListLModel1(String str)
    {
        List<LModel1> ls = new ArrayList<>();
        try  
        {  //add(Restrictions.like("pr.name", "%" + str.toUpperCase() + "%").ignoreCase())
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(LModel1.class).add(Restrictions.ge("status", 1)).add(Restrictions.like("article", "%" + str.toUpperCase() + "%").ignoreCase()).addOrder(Order.asc("article")).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Получить список объектов
     * @param p - id объекта
     * @param status - cnfnec
     * @param str - строка для поиска
     * @return 
     */
    public static List<Model> getListModel(int p, int status, String str, boolean all)
    {
        List<Model> ls = new ArrayList<>();
        try  
        {  //add(Restrictions.like("pr.name", "%" + str.toUpperCase() + "%").ignoreCase())
            Session sess = HibernateUtil.getSessionFactory().openSession();
            if(p == -1)
            {
                if(status == -1)                
                {
                    if(all)
                        ls = sess.createCriteria(Model.class).add(Restrictions.eq("del", 0)).add(Restrictions.like("article", "%" + str.toUpperCase() + "%").ignoreCase()).addOrder(Order.asc("name")).list();            
                    else
                        ls = sess.createCriteria(Model.class).add(Restrictions.ne("status", 3)).add(Restrictions.eq("del", 0)).add(Restrictions.like("article", "%" + str.toUpperCase() + "%").ignoreCase()).addOrder(Order.asc("name")).list();            
                }
                else
                    ls = sess.createCriteria(Model.class).add(Restrictions.eq("del", 0)).add(Restrictions.ge("status", status)).add(Restrictions.le("status", 2)).add(Restrictions.like("article", "%" + str.toUpperCase() + "%").ignoreCase()).addOrder(Order.asc("name")).list();            
            }
            else
                ls = sess.createCriteria(Model.class).add(Restrictions.eq("model", p)).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Удалить объект
     * @param p - ид объекта
     * @return - результат
     */
    public static boolean delModel(int p)
    {
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            Transaction transaction = sess.beginTransaction();
            String s = "update Model set del = 1 where Model = " + p;
            sess.createSQLQuery(s).executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
            return false;
        }        
        return true;
        
    }
    
    /**
     * Сохранить объект
     * @param p - объект
     * @return - объект
     */
    public static ModelProduct setModelProduct(ModelProduct p)
    {
        if(p.getModelproduct()== 0)
            p.setModelproduct(null);
        
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
     * Получить список объектов   
     * @return 
     */
    public static List<ModelProduct> getListModelProductAll()
    {
        List<ModelProduct> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            
            ls = sess.createCriteria(ModelProduct.class).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    
    /**
     * Получить список объектов
     * @param model
     * @param l
     * @param vid - вид
     * @return 
     */
    public static List<ModelProduct> getListModelProduct(int model, int l, int vid)
    {
        List<ModelProduct> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            if(l == -1)
            {
                if(vid == 0)
                    ls = sess.createCriteria(ModelProduct.class).add(Restrictions.eq("model", new Model(model))).addOrder(Order.asc("product")).list();            
                else
                    ls = sess.createCriteria(ModelProduct.class).add(Restrictions.eq("vid", vid)).add(Restrictions.eq("model", new Model(model))).addOrder(Order.asc("product")).list();            
            }
            else
                ls = sess.createCriteria(ModelProduct.class).add(Restrictions.eq("modelproduct", l)).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    
    /**
     * Получить цвет главного полотна модели
     * @param m
     * @return 
     */
    public static Color getHauptColorForProductModel(int m)
    {
        for(ModelProduct mp: getListModelProduct(m, -1, 1))
        {
            // Если это главное полотно то выцходим
            if(mp.getTipproduct().getTipproduct()==1)
                return mp.getColor();
        }
        return new Color(0);
    }
    
    /**
     * Удалить объект
     * @param p - ид объекта
     * @return - результат
     */
    public static boolean delModelProduct(int p)
    {
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            Transaction transaction = sess.beginTransaction();
            String s = "delete from modelproduct where modelproduct = " + p;
            sess.createSQLQuery(s).executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
            return false;
        }        
        return true;
        
    }
    
     /**
     * Сохранить объект
     * @param p - объект
     * @return - объект
     */
    public static ModelPrintDetali setModelPrintDetali(ModelPrintDetali p)
    {
        if(p.getModelprintdetali()== 0)
            p.setModelprintdetali(null);
        
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
     * Получить список объектов
     * @param model - id модели
     * @param l - строка -1 все 
     * @param vid - вид
     * @return 
     */
    public static List<ModelPrintDetali> getListModelPrintDetali(int model, int l, int vid)
    {
        List<ModelPrintDetali> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            if(l == -1)
                ls = sess.createCriteria(ModelPrintDetali.class).add(Restrictions.eq("vid", vid)).add(Restrictions.eq("model", new Model(model))).addOrder(Order.asc("modelprintdetali")).list();            
            else
                ls = sess.createCriteria(ModelPrintDetali.class).add(Restrictions.eq("modelprintdetali", l)).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Удалить объект
     * @param p - ид объекта
     * @return - результат
     */
    public static boolean delModelPrintDetali(int p)
    {
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            Transaction transaction = sess.beginTransaction();
            String s = "delete from ModelPrintDetali where ModelPrintDetali = " + p;
            sess.createSQLQuery(s).executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
            return false;
        }        
        return true;
        
    }
    
    
    /**
     * Сохранить объект
     * @param p - объект
     * @return - объект
     */
    public static ModelKleevaya setModelKleevaya(ModelKleevaya p)
    {
        if(p.getModelkleevaya()== 0)
            p.setModelkleevaya(null);
        
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
     * Получить список объектов
     * @param model
     * @param l
     * @return 
     */
    public static List<ModelKleevaya> getListModelKleevaya(int model, int l)
    {
        List<ModelKleevaya> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            if(l == -1)
                ls = sess.createCriteria(ModelKleevaya.class).add(Restrictions.eq("model", new Model(model))).addOrder(Order.asc("modelkleevaya")).list();            
            else
                ls = sess.createCriteria(ModelKleevaya.class).add(Restrictions.eq("modelkleevaya", l)).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Удалить объект
     * @param p - ид объекта
     * @return - результат
     */
    public static boolean delModelKleevaya(int p)
    {
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            Transaction transaction = sess.beginTransaction();
            String s = "delete from MODELKTEEVAYA where MODELKTEEVAYA = " + p;
            sess.createSQLQuery(s).executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
            return false;
        }        
        return true;
        
    }
    
     /**
     * Сохранить объект
     * @param p - объект
     * @return - объект
     */
    public static ModelSablon setModelSablon(ModelSablon p)
    {
        if(p.getModelsablon()== 0)
            p.setModelsablon(null);
        
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
     * Получить список объектов
     * @param model
     * @param l
     * @return 
     */
    public static List<ModelSablon> getListModelSablon(int model, int l)
    {
        List<ModelSablon> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            if(l == -1)
                ls = sess.createCriteria(ModelSablon.class).add(Restrictions.eq("model", new Model(model))).addOrder(Order.asc("modelsablon")).list();            
            else
                ls = sess.createCriteria(ModelSablon.class).add(Restrictions.eq("modelsablon", l)).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Удалить объект
     * @param p - ид объекта
     * @return - результат
     */
    public static boolean delModelSablon(int p)
    {
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            Transaction transaction = sess.beginTransaction();
            String s = "delete from ModelSablon where ModelSablon = " + p;
            sess.createSQLQuery(s).executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
            return false;
        }        
        return true;
        
    }
    
     /**
     * Сохранить объект
     * @param p - объект
     * @return - объект
     */
    public static ModelFiles setModelFiles(ModelFiles p)
    {
        if(p.getModelfiles()== 0)
            p.setModelfiles(null);
        
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
     * Получить главное фото объектов
     * @param model
     * @param id - ид фото
     * @return 
     */
    public static ModelFiles getHauptModelFiles(int model, int id)
    {
        List<ModelFiles> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            if(id == 0)
            {
                ls = sess.createCriteria(ModelFiles.class).add(Restrictions.eq("model", new Model(model))).add(Restrictions.eq("haupt", 1)).list();            
                if(ls.isEmpty())
                    ls = sess.createCriteria(ModelFiles.class).add(Restrictions.eq("model", new Model(model))).list();            
            }
            else
                ls = sess.createCriteria(ModelFiles.class).add(Restrictions.eq("modelfiles", id)).list();            
            if(ls.isEmpty())
                ls.add(new ModelFiles(0));
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
            ls.add(new ModelFiles(0));
        }        
        return ls.get(0);        
    }
    
    /**
     * Получить список объектов
     * @param model
     * @param mf
     * @return 
     */
    public static List<ModelFiles> getListModelFiles(int model, int mf)
    {
        List<ModelFiles> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            if(mf == 0)
                ls = sess.createCriteria(ModelFiles.class).add(Restrictions.eq("model", new Model(model))).list();            
            else
                ls = sess.createCriteria(ModelFiles.class).add(Restrictions.eq("modelfiles", mf)).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Удалить объект
     * @param p - ид объекта
     * @return - результат
     */
    public static boolean delModelFiles(int p)
    {
        try 
        {
            ModelFiles mf = getListModelFiles(0,p).get(0);
            
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            
            Transaction transaction = sess.beginTransaction();
            String s = "delete from ModelFiles where ModelFiles = " + p;
            sess.createSQLQuery(s).executeUpdate();
            transaction.commit();
            
            Transaction transaction2 = sess.beginTransaction();
            s = "delete from Files where Files = " + mf.getFiles().getFiles();
            sess.createSQLQuery(s).executeUpdate();
            transaction2.commit();
            
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
            return false;
        }        
        return true;
        
    }
    
    /**
     * Установить главную фотографию
     * @param model
     * @param fot
     * @return - результат
     */
    public static boolean statModelFilesSetHaupt(int model, int fot)
    {
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            
            Transaction transaction = sess.beginTransaction();
            String s = "update modelfiles set haupt = 0 where Model = " + model;
            sess.createSQLQuery(s).executeUpdate();
            transaction.commit();
            
            Transaction transaction1 = sess.beginTransaction();
            s = "update modelfiles set haupt = 1 where modelFiles = " + fot;
            sess.createSQLQuery(s).executeUpdate();
            transaction1.commit();
            
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
            return false;
        }        
        return true;
        
    }
    
    /**
     * Сохранить операцию для модели
     * @param p - объект
     * @return - объект
     */
    public static ModelOperation setModelOperation(ModelOperation p)
    {
        if(p.getModeloperation()== 0)
            p.setModeloperation(null);
        
        //if(1==1) return p;
        
        if(p.getNom()==0)
            p.setNom(getMaxOperationInModel(p.getModel()));
       
        
        
        
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
     * Получить маклимальный номер операции в модели
     */
    private static int getMaxOperationInModel(int m)
    {
        int l = 1;
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            //Transaction transaction = sess.beginTransaction();
            String s = "select coalesce(max(nom),0)+1 from modeloperation  where model = " + m;
            l = ((BigInteger)sess.createSQLQuery(s).uniqueResult()).intValue();
            //transaction.commit();
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
        }        
        return l;
    }
    
    /**
     * Получить сумму денег на все операции в модели
     * @param m
     * @return 
     */
    public static BigDecimal getSumOperationInModel(int m)
    {
        BigDecimal l;
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            //Transaction transaction = sess.beginTransaction();
            String s = "select coalesce(sum(mo.times*mo.qty*r.summa/3600),0) from modeloperation mo inner join razrad r on r.razrad = mo.razrad where mo.model =" + m;
            l = (BigDecimal)sess.createSQLQuery(s).uniqueResult();
            //transaction.commit();
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
            l = new BigDecimal(0);
        }        
        return l;
    }
    
    /**
     * Получить список объектов операции для модели
     * @param model - модедь
     * @param p - id объекта -1 все     
     * @return 
     */
    public static List<ModelOperation> getListModelOperation(int model, int p)
    {
        List<ModelOperation> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            if(p == -1)
                ls = sess.createCriteria(ModelOperation.class).add(Restrictions.eq("model", model)).addOrder(Order.asc("nom")).list();            
            else
                ls = sess.createCriteria(ModelOperation.class).add(Restrictions.eq("modeloperation", p)).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Удалить объект
     * @param p - ид объекта
     * @return - результат
     */
    public static boolean delModelOperation(int p)
    {
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            Transaction transaction = sess.beginTransaction();
            String s = "delete from ModelOperation where ModelOperation = " + p;
            sess.createSQLQuery(s).executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
            return false;
        }        
        return true;
        
    }
    
    
    /**
     * Сохранить модель в файл
     * @param m -номер моделт
     * @param file - файл
     */
    public static void saveModelInFile(int m, String file)
    {
        
        //System.out.println(file);
    }
    
    
    /**
     * Записать цех в котором шьем артикул 
     * @param m
     * @return 
     */
    public static ModelChex setModelChex(ModelChex m)
    {
        if(m.getModelchex() == 0)
            m.setModelchex(null);
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            Transaction transaction = sess.beginTransaction();
            sess.saveOrUpdate(m);
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println("ERROR STE11" + e);
            
        }        
        return m;
    }
    
    /**
     * Получить список цехов для модели
     * @param model
     * @return 
     */
    public static List<ModelChex> getListModelChexForModel(int model)
    {
        List<ModelChex> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(ModelChex.class).add(Restrictions.eq("model", new Model(model))).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    public static ModelChex getModelChexForModelAndChex(int model, int chex)
    {
        List<ModelChex> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(ModelChex.class).add(Restrictions.eq("model", new Model(model))).add(Restrictions.eq("chex", new RabotnikGruppa(chex))).list();            
            if(ls.isEmpty())
                ls.add(new ModelChex(0));
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
            ls.add(new ModelChex(0));
        }        
        return ls.get(0);        
    }
    
    /**
     * 
     * @param model
     * @param chex
     * @param vals 
     */
    public static void setModelChexForModelAndChex(int model, int chex, int vals)
    {
        ModelChex mc = getModelChexForModelAndChex(model, chex);
        if(mc.getModelchex()!=0)
        {
            mc.setVals(vals);
            setModelChex(mc);
            return;
        }
        mc.setChex(new RabotnikGruppa(chex));
        mc.setModel(new Model(model));
        mc.setVals(vals);
        setModelChex(mc);             
    }
    
    /**
     * Получить модель по артикулу
     * @param article - артикул
     * @return 
     */
    
    public static Model getModelForArticle(String article) {
        List<Model> ls = new ArrayList<>();
        try {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(Model.class).add(Restrictions.eq("article", article)).list();
            if (ls.isEmpty()) {
                ls = sess.createCriteria(Model.class).add(Restrictions.eq("article", article.replace("/", ""))).list();
                if (ls.isEmpty()) {
                    ls.add(new Model(0));
                }
            }

        } catch (HibernateException e) {
            System.out.println("GER ERROR " + e);
            ls.add(new Model(0));
        }
        return ls.get(0);
    }
    
    
    
    public static List<Integer> getAllModelForArticle(String article){
        Session sess = HibernateUtil.getSessionFactory().openSession(); 
        String sql = "select model from model where article = '" + article + "'";        
        List<Integer> ls = sess.createSQLQuery(sql)
                //.setResultTransformer(Transformers.aliasToBean(Integer.class))
                . list();        
        return ls;
    }
    
    
}
