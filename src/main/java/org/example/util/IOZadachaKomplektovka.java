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
import org.example.logic.MarshrutAll;
import org.example.logic.Model;
import org.example.logic.Rabotnik;
import org.example.logic.RabotnikGruppa;
import org.example.logic.Razmeri;
import org.example.logic.Sclad;
import org.example.logic.ViewMarshrut;
import org.example.logic.Zadacha;
import org.example.logic.ZadachaFurnitura;
import org.example.logic.ZadachaKomplektovka;
import org.example.logic.ZadachaKomplektovkaRazmeri;
import org.example.logic.ZadachaRazmeri;
import org.example.logic.plan.PModelPlanHaupt;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ivan
 */
public class IOZadachaKomplektovka {
    
    /**
     *  Копирование комплектовки
     * @param ak - комплектовка которую нужно копировать
     * @return 
     */
    public static ZadachaKomplektovka copyZadachaKomplektovka(int ak)
    {
        ZadachaKomplektovka zk = IOZadachaKomplektovka.getListZadachaKomplektovka(0, ak).get(0);
        // сохраним комплектовку заново
        zk.setZadachakomplektovka(0);
        zk.setStatus(0);
        zk.setBrak(0);
        zk.setBrak1(0);
        zk.setBrak1text("");
        zk.setBraktext("");
        zk.setQtysclad(0);
        zk.setZtext("");        
        zk.setSclad(new Sclad(0));
        zk.setNomer(zk.getZadacha().getNomer() + "/" + (IOZadachaKomplektovka.getListZadachaKomplektovka(zk.getZadacha().getZadacha(), -1).size()+1));
        zk = setZadachaKomplektovka(zk);
        
        // скопируем размеры
        for(ZadachaKomplektovkaRazmeri zr: getListZadachaKomplektovkaRazmeri(ak))
        {
            zr.setQty(0);
            zr.setZadachakomplektovkarazmeri(0);
            zr.setZadachakomplektovka(zk.getZadachakomplektovka());
            setZadachaKomplektovkaRazmeri(zr);
        }
        return zk;
    }
    
    /**
     *  Копирование комплектовки с размерами
     * @param ak - комплектовка которую нужно копировать
     * @return 
     */
    public static ZadachaKomplektovka copyZadachaKomplektovkaAndRazmer(int ak)
    {
        ZadachaKomplektovka zk = IOZadachaKomplektovka.getListZadachaKomplektovka(0, ak).get(0);
        // сохраним комплектовку заново
        zk.setZadachakomplektovka(0);
        zk.setStatus(0);
        zk.setBrak(0);
        zk.setBrak1(0);
        zk.setBrak1text("");
        zk.setBraktext("");
        zk.setQtysclad(0);
        zk.setZtext("");        
        zk.setNomer(zk.getZadacha().getNomer() + "/" + (IOZadachaKomplektovka.getListZadachaKomplektovka(zk.getZadacha().getZadacha(), -1).size()+1));
        zk = setZadachaKomplektovka(zk);
        
        // скопируем размеры
        for(ZadachaKomplektovkaRazmeri zr: getListZadachaKomplektovkaRazmeri(ak))
        {            
            zr.setZadachakomplektovkarazmeri(0);
            zr.setZadachakomplektovka(zk.getZadachakomplektovka());
            setZadachaKomplektovkaRazmeri(zr);
        }
        return zk;
    }
    
    /**
     * Создать задачу и комплектовку на основании модели 
     * @param m - модель
     * @param hand
     * @return - объект
     */
    public static Zadacha createZadachaForModel(int m, int hand)
    {
        Model model = IOModel.getListModel(m, 0, true).get(0);
        Zadacha zadacha = new Zadacha();
        zadacha.setDateend(new Date());
        zadacha.setDateendmax(new Date());
        zadacha.setDates(new Date());
        zadacha.setDatestart(new Date());
        zadacha.setDatesclad(new Date());
        zadacha.setDel(2);
        zadacha.setKoef(BigDecimal.ONE);
        zadacha.setModel(model);
        zadacha.setNetm(0);
        zadacha.setNomer("КП-" +IOSetup.getNextNomZadacha());
        zadacha.setStatus(10);
        zadacha.setText("Автоматическая задача для комплектовки подкроя.");
        zadacha.setZadacha(0);
        zadacha.setHand(hand);
        zadacha.setPmodelplanhaupt(new PModelPlanHaupt(0));
        zadacha = IOZadacha.setZadacha(zadacha);
        
        IOZadacha.setRazmeriForZadacha(zadacha.getZadacha(), model.getModel());
        
        return zadacha;
        
    }
    
    /**
     * Сохранить объект
     * @param p - объект
     * @return - объект
     */
    public static ZadachaKomplektovka setZadachaKomplektovka(ZadachaKomplektovka p)
    {
        if(p.getZadachakomplektovka()== 0)
            p.setZadachakomplektovka(null);
        
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
     * @param zadacha - задача
     * @param zk - ид комплектовки  -1 все
     * @return 
     */
    public static List<ZadachaKomplektovka> getListZadachaKomplektovka(int zadacha, int zk)
    {
        List<ZadachaKomplektovka> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            if(zk == -1)
                ls = sess.createCriteria(ZadachaKomplektovka.class).add(Restrictions.eq("zadacha", new Zadacha(zadacha))).addOrder(Order.asc("nomer")).list();            
            else
                ls = sess.createCriteria(ZadachaKomplektovka.class).add(Restrictions.eq("zadachakomplektovka", zk)).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Получить список объектов     
     * @param zk - ид комплектовки  
     * @return 
     */
    public static ZadachaKomplektovka getZadachaKomplektovka(int zk){
        List<ZadachaKomplektovka> ls = new ArrayList<>();
        try{
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(ZadachaKomplektovka.class).add(Restrictions.eq("zadachakomplektovka", zk)).list();            
            
        }catch(HibernateException e){
            System.out.println("GER ERROR " + e);            
        }   
        if(ls.isEmpty())
            ls.add(new ZadachaKomplektovka(0));
        return ls.get(0);        
    }
    
    
    
    
    /**
     * Получить список комплектовок для задачи которые не выполнены
     * @param zadacha - задача
     * @return 
     */
    public static List<ZadachaKomplektovka> getListZadachaKomplektovkaIsNotGut(int zadacha)
    {
        List<ZadachaKomplektovka> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            ls = sess.createCriteria(ZadachaKomplektovka.class).add(Restrictions.eq("zadacha", new Zadacha(zadacha))).add(Restrictions.lt("status", 5)).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    
    /**
     * Получить список объектов для оператора
     * @param op
     * @param zk - ид комплектовки  -1 все
     * @param hand - ручной стол или -1 все
     * @param d1 - дата с
     * @param d2 - дата по
     * @param vall - показывать все или только не отправленные
     * @return 
     */
    public static List<ZadachaKomplektovka> getListZadachaKomplektovkaForOperator(int op, int zk, int hand, Date d1, Date d2, boolean vall)
    {
        List<ZadachaKomplektovka> ls = new ArrayList<>();
        try  
        {
            int max_status = 1;
            if(vall)
                max_status = 10;
            Session sess = HibernateUtil.getSessionFactory().openSession();
            if(hand ==-1)
            {
                if(zk == -1)
                {
                    if(op!=0)
                        ls = sess.createCriteria(ZadachaKomplektovka.class).add(Restrictions.eq("rabotnik", new Rabotnik(op))).add(Restrictions.between("status", 0, max_status)).add(Restrictions.between("dates", d1, d2)).addOrder(Order.desc("dates")).addOrder(Order.asc("nomer")).list();            
                    else
                        ls = sess.createCriteria(ZadachaKomplektovka.class).add(Restrictions.between("dates", d1, d2)).add(Restrictions.between("status", 0, max_status)).addOrder(Order.desc("dates")).addOrder(Order.asc("nomer")).list();            
                }
                else
                    ls = sess.createCriteria(ZadachaKomplektovka.class).add(Restrictions.eq("zadachakomplektovka", zk)).list();            
            }
            else
            {
                if(zk == -1)
                {
                    if(op!=0)
                        ls = sess.createCriteria(ZadachaKomplektovka.class).add(Restrictions.between("status", 0, max_status)).createAlias("zadacha", "z").add(Restrictions.eq("z.hand", hand)).add(Restrictions.between("dates", d1, d2)).add(Restrictions.eq("rabotnik", new Rabotnik(op))).addOrder(Order.desc("dates")).addOrder(Order.asc("nomer")).list();            
                    else
                        ls = sess.createCriteria(ZadachaKomplektovka.class).add(Restrictions.between("status", 0, max_status)).createAlias("zadacha", "z").add(Restrictions.eq("z.hand", hand)).add(Restrictions.between("dates", d1, d2)).addOrder(Order.desc("dates")).addOrder(Order.asc("nomer")).list();            
                }
                else
                    ls = sess.createCriteria(ZadachaKomplektovka.class).add(Restrictions.eq("zadachakomplektovka", zk)).list();            
            }
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Получить список объектов для комплектовки фурнитурой
     * @return 
     */
    public static List<ZadachaKomplektovka> getListZadachaKomplektovkaForFurnitura()
    {
        List<ZadachaKomplektovka> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(ZadachaKomplektovka.class).add(Restrictions.eq("status", 1)).addOrder(Order.asc("nomer")).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Получить список маршрутов
     * @param s - статус или -1 все
     * @return 
     */
    public static List<ZadachaKomplektovka> getAllMarshrut(int s)
    {
        List<ZadachaKomplektovka> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            if(s == -1)
                ls = sess.createCriteria(ZadachaKomplektovka.class).addOrder(Order.asc("nomer")).list();            
            else
                ls = sess.createCriteria(ZadachaKomplektovka.class).add(Restrictions.ge("status", s)).addOrder(Order.asc("nomer")).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    
    
    /**
     * Получить список маршрутов которые считаются в работе
     * @return 
     */     
    public static List<String> getAllMarshrutForWork()
    {
        String sql = "select\n"
                + "  name||'<->'||sum(qty)\n"
                + "from (\n"
                + "      select\n"
                + "         zk.model|| '-' ||zk.color || '-' || zkr.razmeri as name,\n"
                + "         (coalesce((select sum(z.qty) from zadachakomplektovkarazmeri z where z.zadachakomplektovka = zk.zadachakomplektovka  and z.razmeri = zkr.razmeri),0))  as qty\n"
                + "      from zadachakomplektovka zk\n"
                + "      inner join zadachakomplektovkarazmeri zkr on zkr.zadachakomplektovka = zk.zadachakomplektovka and zkr.qty > 0 \n"
                + "      where zk.status between 3 and 4)\n"
                + " group by name";
        List<String> ls = new ArrayList<>();
        try  
        {         
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createSQLQuery(sql).list();
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Получить список маршрутов которые считаются в работе - по названиям
     * @return 
     */     
    public static List<String> getAllMarshrutForWorkName()
    {
        String sql = "select\n"
                + "  name||'<->'||sum(qty)\n"
                + "from (\n"
                + "      select\n"
                + "         m.article|| '-' ||c.name || '-' || r.name as name,\n"
                + "         (coalesce((select sum(z.qty) from zadachakomplektovkarazmeri z where z.zadachakomplektovka = zk.zadachakomplektovka  and z.razmeri = zkr.razmeri),0))  as qty\n"
                + "      from zadachakomplektovka zk\n"
                + "      inner join zadachakomplektovkarazmeri zkr on zkr.zadachakomplektovka = zk.zadachakomplektovka and zkr.qty > 0 \n"
                + "      inner join model m on m.model = zk.model "
                + "      inner join color c on zk.color = c.color  "
                + "      inner join razmeri r on r.razmeri = zkr.razmeri  "        
                + "      where zk.status between 3 and 4)\n"
                + " group by name";
        List<String> ls = new ArrayList<>();
        try  
        {         
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createSQLQuery(sql).list();
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    
    /**
     * Рассчитать параметр в работе для строк запланированной задачи
     * @param mapProject - номер задачи
     * @return 
     */     
    public static boolean updateFildInWorkForMapProject(int mapProject)
    {
        String sql = "execute procedure UPDATEMAPPROJECTINWORK(" + mapProject + ")";
        
        try  
        {         
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
     * Получить список маршрутов для артикула
     * @param article
     * @return 
     */
    public static List<ZadachaKomplektovka> getAllMarshrutForArticle(int article)
    {
        List<ZadachaKomplektovka> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(ZadachaKomplektovka.class).add(Restrictions.eq("model", new Model(article))).add(Restrictions.lt("status", 6)).addOrder(Order.asc("nomer")).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Получить список маршрутов для артикула
     * @param article
     * @return 
     */
    public static List<ZadachaKomplektovka> getAllMarshrutForArticle1(int article)
    {
        Model md = IOModel.getListModel(article, 0, true).get(0);
        md.setArticle(md.getArticle().split(" ")[0].split("-")[0]);
        
        List<ZadachaKomplektovka> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(ZadachaKomplektovka.class).createAlias("model", "mm").add(Restrictions.like("mm.article", md.getArticle())).add(Restrictions.lt("status", 6)).addOrder(Order.asc("nomer")).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    
     /**
      * Получение маршрутов в зависимости от статусов
     * @param d1 - начальная дата
     * @param d2 - конечная дата
     * @param s     
     
     * @return 
     */
    public static List<ZadachaKomplektovka> getAllMarshrut(Date d1, Date d2, Integer[] s)
    {
        int chex = IOOperator.operator.getRabotnikgruppa().getRabotnikgruppa();
        List<ZadachaKomplektovka> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            Criteria c = sess.createCriteria(ZadachaKomplektovka.class).add(Restrictions.between("datasend", d1, d2));
            
            c = c.add(Restrictions.in("status", s));
            if(chex!=0)
            {
                c = c.add(Restrictions.eq("chek", new RabotnikGruppa(chex)));
            }
            
            ls = c.addOrder(Order.asc("nomer")).list();            
            
            //    ls = sess.createCriteria(ZadachaKomplektovka.class).add(Restrictions.ge("status", s)).addOrder(Order.asc("nomer")).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    
    /**
     * Получить список маршрутов Для отправки
     * @return 
     */
    public static List<ZadachaKomplektovka> getAllMarshrutForGo()
    {
        List<ZadachaKomplektovka> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(ZadachaKomplektovka.class).add(Restrictions.eq("status", 2)).addOrder(Order.asc("nomer")).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    
    /**
     * Получить список маршрутов для цеха
     * @param s - цех
     * @return 
     */
    public static List<ZadachaKomplektovka> getMarshrutForCheh(int s)
    {
        List<ZadachaKomplektovka> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(ZadachaKomplektovka.class).add(Restrictions.eq("chek", new RabotnikGruppa(s))).add(Restrictions.ge("status", 4)).addOrder(Order.asc("nomer")).list();            
            //ls = sess.createCriteria(ZadachaKomplektovka.class).add(Restrictions.eq("chek", new RabotnikGruppa(s))).add(Restrictions.eq("status", 4)).addOrder(Order.asc("nomer")).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Получить упрощенный список маршрутов для цеха
     * @param s - цех
     * @return 
     */
    public static List<MarshrutAll> getMarshrutAllForCheh(int s)
    {
        List<MarshrutAll> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(MarshrutAll.class).add(Restrictions.eq("chex", s)).addOrder(Order.asc("nomer")).list();
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Получить список в складе кроя
     * @return 
     */
    public static List<ZadachaKomplektovka> getMarshrutForScladKroi()
    {
        List<ZadachaKomplektovka> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();            
            ls = sess.createCriteria(ZadachaKomplektovka.class).add(Restrictions.between("status", 11, 13)).addOrder(Order.asc("nomer")).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    
    /**
     * Утвердить комплектовку задачи
     * @param zk
     * @param nSt - Новый статус
     * @return - результат
     */
    public static boolean setStatusKomplektovkaGut(int zk, int nSt)
    {
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            sess.beginTransaction();
            String s = "update ZADACHAKOMPLEKTOVKA set status = "+nSt+" where ZadachaKomplektovka = " + zk;
            sess.createSQLQuery(s).executeUpdate();
            sess.beginTransaction().commit();
            
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
            return false;
        }        
        return true;
        
    }
    
    /**
     * Закрыть операции работников по маршруту
     * @param m     
     * @return - результат
     */
    public static boolean setCloseRabontikOperationForMarshrut(int m)
    {
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();             
            String s = "update rabotnikoperation set status = 1 where zadachakomplektovka = " + m;
            sess.beginTransaction();
            sess.createSQLQuery(s).executeUpdate();
            sess.beginTransaction().commit();
            
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
            return false;
        }        
        return true;
        
    }
    
    /**
     * Открыть операции работников по маршруту
     * @param m     
     * @return - результат
     */
    public static boolean setOpenRabontikOperationForMarshrut(int m)
    {
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();             
            String s = "update rabotnikoperation set status = 0 where zadachakomplektovka = " + m;
            sess.beginTransaction();
            sess.createSQLQuery(s).executeUpdate();
            sess.beginTransaction().commit();
            
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
            return false;
        }        
        return true;
        
    }
    
    /**
     * Изменить статус комплектовки задачи
     * @param zk - маршрут
     * @param status - новый статус
     * @return - результат
     */
    public static boolean setStatusKomplektovka(int zk, int status)
    {
        try 
        {
            // если хотим принять маршрут на склад
            /*if(status == 6)
            {
                ZadachaKomplektovka zz = getListZadachaKomplektovka(0, zk).get(0);
                if(zz.getZadacha().getDel()==2)
                {
                    zz.getZadacha().setStatus(10);
                    
                }
            }*/
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            sess.beginTransaction();
            String s = "update ZADACHAKOMPLEKTOVKA set status = "+status+" where ZadachaKomplektovka = " + zk;
            sess.createSQLQuery(s).executeUpdate();
            sess.beginTransaction().commit();
            
            // если хотим принять маршрут на склад
            // попробуем закрыть задание
            if(status ==6)
            {
                //System.out.println("Закрываем комплектовку");
                ZadachaKomplektovka zzk = getListZadachaKomplektovka(0, zk).get(0);
                IOZadacha.autoCloseZadacha(zzk.getZadacha().getZadacha());
                /*Zadacha zz = zzk.getZadacha();
                
                //System.out.println("Стутус задачи = " + zz.getStatus());
                // если закрыты все настилы
                if(zz.getStatus()==3)
                {
                    
                    //если все маршруты вернулись
                    if(IOZadachaKomplektovka.getListZadachaKomplektovkaIsNotGut(zz.getZadacha()).isEmpty())                                                        
                    {
                        //System.out.println("Все маршруты вернулись");
                        // посмотрим все или нет закрыты принты и вышивки
                        List<ZadachaPrintDetali> ls = IOZadachaPrintDetali.getListZadachaPrintDetaliForZadacha(zz.getZadacha());
                        if(!ls.isEmpty())
                        {
                            for(ZadachaPrintDetali z: ls)
                            {
                                if(z.getStatus()!=1)
                                {
                                    //System.out.println("Принт не закрыт" + z.getZadachaprintdetali());
                                    return true;
                                }
                            }
                        // Изменим статус на закрытый
                        for(ZadachaPrintDetali z: ls)               
                            IOZadachaPrintDetali.updateStatusPD(z.getZadachaprintdetali(), 2);
               
                        }
                        //закроем задачу
                        IOZadacha.setNewStatusZadacha(zz.getZadacha(), 10);
                    }
                    //else
                       // System.out.println("Не все маршруты вернулмсь");
                
                }*/
            }
            
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
            return false;
        }        
        return true;
        
    }
    
    /**
     * открыть комплектовку задачи для редактирования
     * @param zk
     * @return - результат
     */
    public static boolean setStatusKomplektovkaEdit(int zk)
    {
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            sess.beginTransaction();
            String s = "update ZADACHAKOMPLEKTOVKA set status = 0 where ZadachaKomplektovka = " + zk;
            sess.createSQLQuery(s).executeUpdate();
            sess.beginTransaction().commit();
            
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
            return false;
        }        
        return true;
        
    }
    
    /**
     * Удалить объект
     * @param p - ид объекта
     * @return - результат
     */
    public static boolean delZadachaKomplektovka(int p)
    {
        try 
        {
            ZadachaKomplektovka zk = getListZadachaKomplektovka(0, p).get(0);
            
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            
            for(ZadachaFurnitura zf: IOZadachaFurnitura.getListZadachaFurnituraForKomplektovka(p))
            {
                IOZadachaFurnitura.delZadachaFurnitura(zf.getZadachafurnitura());
            }
            
            sess.beginTransaction();
            String s = "delete from ZADACHAKOMPLEKTOVKARAZMERI where ZadachaKomplektovka = " + p;
            sess.createSQLQuery(s).executeUpdate();
            sess.beginTransaction().commit();
            
            sess.beginTransaction();
            s = "delete from ZadachaKomplektovka where ZadachaKomplektovka = " + p;
            sess.createSQLQuery(s).executeUpdate();
            sess.beginTransaction().commit();
            
            // если это временная задача 
            if(zk.getZadacha().getDel()==2)            
                IOZadacha.delZadacha(zk.getZadacha().getZadacha());
            
            
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
    public static ZadachaKomplektovkaRazmeri setZadachaKomplektovkaRazmeri(ZadachaKomplektovkaRazmeri p)
    {
        if(p.getZadachakomplektovkarazmeri()== 0)
            p.setZadachakomplektovkarazmeri(null);
        
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
     * Получить список всех размер комплектовки
     * @param zk - ид комплектовки  
     * @return 
     */
    public static List<ZadachaKomplektovkaRazmeri> getListZadachaKomplektovkaRazmeri(int zk)
    {
        List<ZadachaKomplektovkaRazmeri> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(ZadachaKomplektovkaRazmeri.class).add(Restrictions.eq("zadachakomplektovka", zk)).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Изменить количество для размера в комплектовке
     * @param zkr - размер комплектовки
     * @param nQty - новое количество
     * @return 
     */
    public static boolean setQtuForZKR(int zkr, int nQty)
    {
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            sess.beginTransaction();
            String s = "update ZADACHAKOMPLEKTOVKARAZMERI set qty = " + nQty + "  where ZADACHAKOMPLEKTOVKARAZMERI = " + zkr;
            sess.createSQLQuery(s).executeUpdate();
            sess.beginTransaction().commit();
        } catch (HibernateException e) {
            System.out.println("ERROR UPDATE" + e);
            return false;
        }   
        return true;
    }
    
    /**
     * Скопировать все размеры в таблицу комплектовки
     * @param zk - ид комплектовки
     * @param z - ид задачи
     * @param m - ид модели
     * @return 
     */
    public static boolean copyRazmeriForKomplektovka(int zk, int z, int m)
    {
        ZadachaKomplektovkaRazmeri zkr;
        // если получаем размеры по задаче
        if(z>0)
        {
            for (ZadachaRazmeri zr : IOZadacha.getListZadachaRazmeri(z, 0)) 
            {
                zkr = new ZadachaKomplektovkaRazmeri();
                zkr.setQty(0);
                zkr.setZadachakomplektovka(zk);
                zkr.setZadachakomplektovkarazmeri(0);
                zkr.setZadacharazmeri(zr);
                zkr.setRazmeri(zr.getRazmeri());
                setZadachaKomplektovkaRazmeri(zkr);
            }
        }
        else // если получаем размеры по модели
        {
            try {
                Session sess = HibernateUtil.getSessionFactory().openSession();
                // получим модель для задачи
                Model mod = IOModel.getListModel(m, -1, true).get(0);
                // получим все размеры для данной модели 
                List<Razmeri> lRazm = sess.createCriteria(Razmeri.class).add(Restrictions.ge("nom", mod.getFirstrazmeri().getNom())).add(Restrictions.eq("razmerigruppa", mod.getFirstrazmeri().getRazmerigruppa())).addOrder(Order.asc("nom")).list();
                sess.beginTransaction();
                for (Razmeri r : lRazm) 
                {
                    zkr = new ZadachaKomplektovkaRazmeri();
                    zkr.setQty(0);
                    zkr.setZadachakomplektovka(zk);
                    zkr.setZadachakomplektovkarazmeri(0);
                    zkr.setZadacharazmeri(new ZadachaRazmeri(0));
                    zkr.setRazmeri(r);
                    setZadachaKomplektovkaRazmeri(zkr);
                }
            }
            catch (HibernateException e) 
            {
                System.out.println("ERROR ADD ZR" + e);
                return false;
            }
        }
        return true;
    }
    
    /**
     * Получить все параметры модели в строку
     * @param z - модель
     * @param tip - тип
     *        1 - клеевая
     *        2 - деталь с принтом
     *        3 - деталь с вышивкой
     *        4 - шаблон
     * @return 
     */
    public static String getParamModel(int z, int tip)
    {
        int m = z;//IOZadacha.getListZadacha(z, -1).get(0).getModel().getModel();
        
        String sql="";
         try 
        {
            
            if(tip==1)
                sql = "select list(k.name || '('||mk.qty||')','; ') from modelkteevaya mk inner join kleevaya k on k.kleevaya = mk.kleevaya where mk.model = " + m;
            if(tip==2)
                sql = "select list(k.name,'; ') from modelprintdetali mk inner join printdetali k on k.printdetali = mk.printdetali where mk.vid=1 and mk.model = " + m;
            if(tip==3)
                sql = "select list(k.name,'; ') from modelprintdetali mk inner join printdetali k on k.printdetali = mk.printdetali where mk.vid=2 and mk.model = " + m;
            if(tip == 4)
                sql = "select list(k.name || '(' || mk.qty || ')','; ') from modelsablon mk inner join sablon k on k.sablon = mk.sablon where mk.model = " + m;
            
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            sess.beginTransaction();            
            sql = (String)sess.createSQLQuery(sql).uniqueResult();
            sess.beginTransaction().commit();
        } catch (HibernateException e) {
            System.out.println("ERROR UPDATE" + e);
            return "";
        }   
        return sql;
    }
    
    
    /***
     * Маршруты
     */
    /**
      * Получение маршрутов в зависимости от статусов
     * @param d1 - начальная дата
     * @param d2 - конечная дата
     * @param s     
     
     * @return 
     */
    public static List<ViewMarshrut> getAllMarshrut1(Date d1, Date d2, Integer[] s)
    {
        int chex = IOOperator.operator.getRabotnikgruppa().getRabotnikgruppa();
        List<ViewMarshrut> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            Criteria c = sess.createCriteria(ViewMarshrut.class).add(Restrictions.between("datasend", d1, d2));
            
            c = c.add(Restrictions.in("status", s));
            if(chex!=0)
            {
                c = c.add(Restrictions.eq("chex", chex));
            }
            
            ls = c.addOrder(Order.asc("nomer")).list();            
            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
}
