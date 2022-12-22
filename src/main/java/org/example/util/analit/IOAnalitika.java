/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.util.analit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.example.logic.GetProductAnalizNovinka;
import org.example.logic.analit.Get_TimeOp_for_ModelPlan;
import org.example.logic.analit.aArticle;
import org.example.logic.analit.aColor;
import org.example.logic.analit.aGetGruppa2;
import org.example.logic.analit.aGruppa1;
import org.example.logic.analit.aGruppa2;
import org.example.logic.analit.aJournal;
import org.example.logic.analit.aRazmer;
import org.example.logic.analit.tAJ;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.example.util.HelpClass;
import org.example.util.HibernateUtil;

/**
 *
 * @author ivan
 */
public class IOAnalitika {
    /**
     * Загрузить данные из файла
     * @param fil
     * @return 
     */
    public static boolean loadData(String fil)
    {
        if(new File(fil).canExecute())        
        {
            //try (BufferedReader red = new BufferedReader(new InputStreamReader(new FileInputStream(fil), "cp1251"))) 
            try (BufferedReader red = new BufferedReader(new InputStreamReader(new FileInputStream(fil), "utf-8"))) 
            {   
                String h;                
                SimpleDateFormat sd = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
                // записываем в структуру
                String ss[];
                aGruppa1 ag1;
                aGruppa2 ag2;
                aColor ac;
                aRazmer ar;
                aArticle aa;
                aJournal aj;
                tAJ ta;
                List<tAJ> ls = new ArrayList<>();
                int k = 1;
                while((h = red.readLine()) != null)                
                {                     
                    if(h.contains("###"))
                        continue;
                    h = h.trim();
                    System.out.println(k+">" +h);
                    if(k==1)
                    {
                        h = h.substring(1);
                    }
                    k++;
                    if(k % 1000 == 0) 
                    {
                        setListTAJ(ls);
                        ls = new ArrayList<>();                        
                    }
                    
                    
                    if(h.length()>60)
                    {
                        ss = h.split("#");  
                        if(ss.length>8)
                        {
                            ta = new tAJ();
                            ta.setTaj(k);
                            ta.setAname(ss[4]);
                            ta.setArticle(ss[3]);
                            ta.setColor(ss[5]);
                            try {
                                ta.setDates(sd.parse(ss[9]));
                                } catch (ParseException ex) {
                                Logger.getLogger(IOAnalitika.class.getName()).log(Level.SEVERE, null, ex);
                                ta.setDates(new Date());
                            }
                            ta.setGruppa1(ss[1]);
                            ta.setGruppa2(ss[2]);
                            ta.setId(ss[0]);
                            ta.setId_article(0);
                            ta.setId_color(0);
                            ta.setId_gruppa1(0);
                            ta.setId_gruppa2(0);
                            ta.setId_razmer(0);
                            ta.setOperations(ss[10]);
                            ta.setScladuid(ss[11]);
                            ta.setSclad(ss[12]);
                            ta.setScladId(0);
                            ta.setOperationId(0);
                            ta.setAgentid(0);
                            ta.setAgent(ss[13]);
                            ta.setAgentuid(ss[14]);
                            try {
                                ta.setPrice(new BigDecimal(ss[8]));
                            } catch (NumberFormatException e) {
                                
                                 ta.setPrice(new BigDecimal(ss[8].substring(3)));
                                
                            }
                            
                            try
                            {
                                ta.setQty(new BigDecimal(ss[7]));
                            }catch(NumberFormatException  e)
                            {
                                ta.setQty(BigDecimal.ZERO);
                            }
                            ta.setRazmer(ss[6]);
                            ta.setTaj(0);
                            
                            ls.add(ta);
                            
                            
                        }
                    }
                } 
                setListTAJ(ls);
                
            } catch (FileNotFoundException ex) {
                System.out.println("ERROR load " + ex);
            } catch (IOException ex) {
                System.out.println("ERROR load " + ex);
            }
        } 
        
        return true;
    }
    
    /**
     * Записать группу строк для импорта
     * @param ag 
     */
    public static void setListTAJ(List<tAJ> ag)
    {
        
        Session sess = HibernateUtil.getSessionFactory().openSession();
        try 
        {
            sess.beginTransaction();
            for(tAJ t :ag)
            {
                t.setTaj(null);
                sess.save(t);
            }
            sess.beginTransaction().commit();
            sess.beginTransaction();
            sess.createSQLQuery("execute procedure execute_load_sale").executeUpdate();
            sess.beginTransaction().commit();
            
        }catch(HibernateException e)
        {
            System.out.println("ERROR SAVE" + e);            
        }        
    }
    
    
    /**
     * Записать строку для импорта
     * @param ag
     * @return 
     */
    public static tAJ setTAJ(tAJ ag)
    {
        if(ag.getTaj()==0)
            ag.setTaj(null);
        Session sess = HibernateUtil.getSessionFactory().openSession();
        try 
        {
            sess.beginTransaction();
            sess.saveOrUpdate(ag);
            sess.beginTransaction().commit();
            
        }catch(HibernateException e)
        {
            System.out.println("ERROR SAVE" + e);            
        }
        return ag;
    }
    
    /**
     * Получить артикулы по группе 2
     * @param g1 - группа 1
     * @param g2 - группа 2
     * @param d1 - дата с
     * @param d2 - дата по
     * @return 
     */
    public static List<aGetGruppa2> getGruppa2(int g1, int g2 , Date d1, Date d2)
    {
        List<aGetGruppa2> ls = new ArrayList<>();
        
        Session sess = null;
        try 
        {
            sess = HibernateUtil.getSessionFactory().openSession();            
            Query query = sess.getNamedQuery("A_GET_GRUPPA2")
                    .setParameter("G1", g1)
                    .setParameter("G2", g2)
                    .setParameter("D1", d1)
                    .setParameter("D2", d2)
                    .setParameter("D3", d1)
                    .setParameter("D4", d2);

            ls = (List<aGetGruppa2>)query.list();            
        }catch(HibernateException ex)
         {     
             System.out.println("ERROR GET" + ex);             
              
         }finally
          { 
              if(sess!=null&& sess.isOpen())
                  sess.close();
          }
        return ls;
    }
    
    /**
     * Получить артикулы по группе 2
     * @param g1 - группа 1
     * @param g2 - группа 2
     * @param d1 - дата с
     * @param d2 - дата по
     * @param d3 - дата производства с
     * @param d4 - дата производства по
     * @param ik - 1 исключить у и %
     * @return 
     */
    public static List<aGetGruppa2> getGruppa2_v2(int g1, int g2, Date d1, Date d2, Date d3, Date d4, int ik)
    {
        List<aGetGruppa2> ls = new ArrayList<>();
        
        Session sess = null;
        try 
        {
            sess = HibernateUtil.getSessionFactory().openSession();            
            Query query = sess.getNamedQuery("A_GET_GRUPPA2")
                    .setParameter("G1", g1)
                    .setParameter("G2", g2)
                    .setParameter("D1", d1)
                    .setParameter("D2", d2)
                    .setParameter("D3", d3)
                    .setParameter("D4", d4)
                    .setParameter("IK", ik);

            ls = (List<aGetGruppa2>)query.list();            
        }catch(HibernateException ex)
         {     
             System.out.println("ERROR GET" + ex);             
              
         }finally
          { 
              if(sess!=null&& sess.isOpen())
                  sess.close();
          }
        return ls;
    }
    
    /**
     * Получить продажи за период для артикула
     * @param article - артикул
     * @param d1
     * @param d2
     * @return 
     */
    public static List<String> getDataForChartForArticleSale(int article, Date d1, Date d2)
    {
        List<String> ls = new ArrayList<>();
        try 
        {
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            sess.beginTransaction();
            String s = "select j.dates || '#' || -sum(j.qty) from a_journal j where j.article =  "+article+" and j.qty < 0 and j.dates between '"+sf.format(d1)+"' and '"+sf.format(d2)+"'  group by j.dates";
            
            ls = sess.createSQLQuery(s).list();
            sess.beginTransaction().commit();
            sess.close();            
        } catch (HibernateException e) {
            System.out.println("ERROR close document" + e);
        }        
        return ls;
        
    }
    
    /**
     * Получить строки настилов по артикулам за период
     * @param d1 - дата с
     * @param d2 - дата по
     * @return 
     */
    public static List<String> getListArticleForPeriod(Date d1, Date d2)
    {
        List<String> ls = new ArrayList<>();
        try 
        {
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            sess.beginTransaction();
            String s = "select MONTS from GET_ARTICLE_FOR_PERIOD('"+sf.format(d1)+"', '"+sf.format(d2)+"')";
            
            ls = sess.createSQLQuery(s).list();
            sess.beginTransaction().commit();
            sess.close();            
        } catch (HibernateException e) {
            System.out.println("ERROR get data" + e);
        }        
        return ls;
    }
    
    
    /**
     * Получить количество времени для выпосления модели
     * @param model - номер додели
     * @param qty - количество
     * @return 
     */
    public static List<String> getTimeForModel(int model, int qty)
    {
        List<String> ls = new ArrayList<>();
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            sess.beginTransaction();
            String s = "select\n" +
"  gc.CHEX || '<!>' || gc.CHEXNAME || '<!>' || gc.GRUPPA || '<!>' || gc.GRUPPANAME  || '<!>' || gc.QOST || '<!>' ||   pt.times  || '<!>' ||   coalesce(mt.ot, 0)\n" +
"from GET_TIME_OF_CEX gc\n" +
"inner join p_timeopchex pt on pt.chex = gc.chex and pt.operationgruppa = gc.gruppa\n" +
"left join\n" +
"(\n" +
"    select\n" +
"       o.operationgruppa as og,\n" +
"       sum(mo.times * "+qty+") as ot\n" +
"    from modeloperation mo\n" +
"    inner join operation o on o.operation = mo.operation\n" +
"    where mo.model = "+model+"\n" +
"    group by o.operationgruppa\n" +
" )  mt on mt.og = gc.gruppa";
            
            ls = sess.createSQLQuery(s).list();
            sess.beginTransaction().commit();
            sess.close();            
        } catch (HibernateException e) {
            System.out.println("ERROR get data3" + e);
        }        
        return ls;
        
    }
    
    /**
     * Получить продажи для аналитики новинок
     * @param g1 - Группа 1
     * @param g2 - группа 2
     * @param d1 - дата с
     * @param d2 - дата по
     * @return 
     */
    public static List<GetProductAnalizNovinka> getProductAnalizNovinka(int g1, int g2 , Date d1, Date d2)
    {
        List<GetProductAnalizNovinka> ls = new ArrayList<>();
        
        Session sess = null;
        try 
        {
            sess = HibernateUtil.getSessionFactory().openSession();            
            Query query = sess.getNamedQuery("GETPRODUCTANALIZNOVINKA")
                    .setParameter("G1", g1)
                    .setParameter("G2", g2)
                    .setParameter("D1", d1)
                    .setParameter("D2", d2);

            ls = (List<GetProductAnalizNovinka>)query.list();            
        }catch(HibernateException ex)
         {     
             System.out.println("ERROR GET GETPRODUCTANALIZNOVINKA" + ex);             
              
         }finally
          { 
              if(sess!=null&& sess.isOpen())
                  sess.close();
          }
        return ls;
    }
    
    /**
     * Получить колво запланированных операций
     * @param mp - запланированная задача
     * @param d1
     * @param d2
     * @return 
     */
    public static List<Get_TimeOp_for_ModelPlan> getGet_TimeOp_for_ModelPlan (int mp, Date d1, Date d2)
    {
        List<Get_TimeOp_for_ModelPlan> ls = new ArrayList<>();
        
        Session sess;
        try 
        {
            sess = HibernateUtil.getSessionFactory().openSession();            
            Query query = sess.getNamedQuery("GET_TOMEOP_FOR_MODELPLAN")
                    .setParameter("MP", mp)
                    .setParameter("D1", d1)
                    .setParameter("D2", d2);

            ls = (List<Get_TimeOp_for_ModelPlan>)query.list();
            
            //System.out.println("ZISE = " + ls.size());
        }catch(HibernateException ex)
        {     
            System.out.println("ERROR GET12");                
        }
        return ls;
    }
    
    /**
     * Получить продажи артикула по цверу и размеру
     * @param art - артикул
     * @param color - цвет
     * @param razmer - размер
     * @param d1 - дата с
     * @param d2 - дата по
     * @return 
     */
    public static List<aJournal> getAJournalForColorAndRazmer(int art, int color , int razmer, Date d1, Date d2)
    {
        /*List<aJournal> ls = new ArrayList<>();
        
        Session sess = null;
        try 
        {
            sess = HibernateUtil.getSessionFactory().openSession();                        
            
            ls = sess.createCriteria(aJournal.class)
                    .createAlias("operations", "ops")
                    
                    .add(Restrictions.eq("aarticle", new aArticle(art)))
                    .add(Restrictions.eq("acolor", new aColor(color)))
                    .add(Restrictions.eq("arazmer", new aRazmer(razmer)))
                    .add(Restrictions.between("dates", d1, d2))
                    .add(Restrictions.eq("ops.ink", 1))
                    
                    .addOrder(Order.asc("dates"))
                    .addOrder(Order.desc("qty"))
                    .list();  
        }catch(HibernateException ex)
         {     
             System.out.println("ERROR GET" + ex);             
              
         }finally
          { 
              if(sess!=null&& sess.isOpen())
                  sess.close();
          }
        return ls;*/
        
        
        
         List<aJournal> ls = new ArrayList<>();
        
        
        Session sess = null;
        try 
        {
            sess = HibernateUtil.getSessionFactory().openSession();                        
            ls = sess.createCriteria(aJournal.class)
                    .createAlias("sclad", "sc")
                    //.createAlias("operations", "ops")
                    .add(Restrictions.eq("aarticle", new aArticle(art)))
                    .add(Restrictions.eq("acolor", new aColor(color)))
                    .add(Restrictions.eq("arazmer", new aRazmer(razmer)))
                    .add(Restrictions.between("dates", d1, d2))                    
                    .add(Restrictions.eq("sc.io", 1))
                    //.add(Restrictions.eq("ops.ink", 1))
                    .addOrder(Order.asc("dates"))
                    .addOrder(Order.desc("qty"))
                    .list();  
            
            
        }catch(HibernateException ex)
         {     
             System.out.println("ERROR GET" + ex);             
              
         }finally
          { 
              if(sess!=null&& sess.isOpen())
                  sess.close();
          }
        return ls;
        
        
    }
    
    /**
     * Получить продажи артикула по цверу и размеру
     * @param art - артикул
     * @param color - цвет
     * @param razmer - размер
     * @param d1 - дата с
     * @param d2 - дата по
     * @return 
     */
    public static List<aJournal> getAJournalForColorAndRazmer1(int art, int color , int razmer, Date d1, Date d2)
    {
        List<aJournal> ls = new ArrayList<>();
        
        //System.out.println("art = " + art);
        //System.out.println("color = " + color);
        //System.out.println("razmer = " + razmer);
        
        
        Session sess = null;
        try 
        {
            sess = HibernateUtil.getSessionFactory().openSession();                        
            //System.out.println("\n\n\n\n\n\n\n\nfdjghdsfjklghklsdfjghljksdfhgjklsdfhjklghsdflk");
            ls = sess.createCriteria(aJournal.class)
                    //.createAlias("operations", "ops")
                    .createAlias("sclad", "sc")
                    .add(Restrictions.eq("aarticle", new aArticle(art)))
                    .add(Restrictions.eq("acolor", new aColor(color)))
                    .add(Restrictions.eq("arazmer", new aRazmer(razmer)))
                    .add(Restrictions.between("dates", d1, d2))                    
                    .add(Restrictions.eq("sc.io", 1))
                    //.add(Restrictions.eq("ops.ink", 1))
                    .addOrder(Order.asc("dates"))
                    .addOrder(Order.desc("qty"))
                    .list();  
            //System.out.println("\n\n\n\n\n\n\n\nfdjghdsfjklghklsdfjghljksdfhgjklsdfhjklghsdflk");
            
            //for(aJournal a: ls)
            //    System.out.println(a.getDates());
            
        }catch(HibernateException ex)
         {     
             System.out.println("ERROR GET" + ex);             
              
         }finally
          { 
              if(sess!=null&& sess.isOpen())
                  sess.close();
          }
        return ls;
    }
    
    /**
     * Получить остаток на дату
     * @param model - артикул
     * @param color - цвет
     * @param razmer - размер
     * @param d - дата
     * @return 
     */
    public static BigDecimal getQtyForModelColorRazmer(int model, int color, int razmer, Date d)
    {
        String sql = "select cast(coalesce(sum(j.qty),0) as integer) from a_journal j inner join a_sclad s on s.a_sclad = j.sclad inner join a_operation o on o.a_operation = j.operations where s.io = 1 and article = "+model+" and color = "+color+" and razmer = "+razmer+" and dates < '"+HelpClass.getPrintDate1(d)+"'";
        Session sess = null;
        BigDecimal res = BigDecimal.ZERO;
        try 
        {
            sess = HibernateUtil.getSessionFactory().openSession();                        
           
            res = new BigDecimal((Integer)sess.createSQLQuery(sql).uniqueResult());            
            
            
        }catch(HibernateException ex)
         {     
             System.out.println("ERROR GET" + ex);             
              
         }finally
          { 
              if(sess!=null&& sess.isOpen())
                  sess.close();
          }
        return res;
    }
    
    /**
     * Получить остаток на дату
     * @param model - артикул
     * @param color - цвет
     * @param razmer - размер
     * @param d - дата
     * @return 
     */
    public static BigDecimal getQtyForModelColorRazmer1(int model, int color, int razmer, Date d)
    {
        String sql = "select cast(coalesce(sum(j.qty),0) as integer) from a_journal j inner join a_operation o on o.a_operation = j.operations where article = "+model+" and color = "+color+" and razmer = "+razmer+" and dates < '"+HelpClass.getPrintDate1(d)+"'";
        Session sess = null;
        BigDecimal res = BigDecimal.ZERO;
        try 
        {
            sess = HibernateUtil.getSessionFactory().openSession();                        
           
            res = new BigDecimal((Integer)sess.createSQLQuery(sql).uniqueResult());            
            
            
        }catch(HibernateException ex)
         {     
             System.out.println("ERROR GET" + ex);             
              
         }finally
          { 
              if(sess!=null&& sess.isOpen())
                  sess.close();
          }
        return res;
    }
    
}
