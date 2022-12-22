/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.util.plannew;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.example.logic.plan.LMapProjectJournal;
import org.example.logic.plan.LMapProjectJournalGroupt;
import org.example.logic.plan.LMapProjectJournalGrouptColor;
import org.example.logic.plan.MapProject;
import org.example.logic.plan.MapProjectJournal;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.example.util.HibernateUtil;

/**
 *
 * @author ivan
 */
public class IOMapProjectJournal implements ioObject<MapProjectJournal, Integer>{

    private static final Logger log = LogManager.getLogger(IOMapProjectJournal.class);

    @Override
    public MapProjectJournal setObject(MapProjectJournal obj) {
        if(obj.getMapprojectjournal()== 0)
            obj.setMapprojectjournal(null);
        
        Session sess = HibernateUtil.getSessionFactory().openSession();
        try{
            sess.beginTransaction();
            sess.saveOrUpdate(obj);
            sess.beginTransaction().commit();            
        }catch(HibernateException e){            
            log.error("Error " + e);
        }
        return obj;
    }  

    @Override
    public MapProjectJournal getObject(Integer key) {
        List<MapProjectJournal> ls = new ArrayList<>();
        try{
            Session sess = HibernateUtil.getSessionFactory().openSession();            
            ls = sess.createCriteria(MapProjectJournal.class)
                    .add(Restrictions.eq("mapprojectjournal", key))                    
                    .list();                        
            if(ls.isEmpty())
                ls.add(new MapProjectJournal(0));
        }catch(HibernateException e){
            log.error("Error " + e);
            ls.add(new MapProjectJournal(0));
        }        
        return ls.get(0);    
    }

    /**
     * Получить список артикулов для задачи
     * @param mp
     * @return 
     */
    public List<MapProjectJournal> getListObjectForMapProject(int mp) {
        List<MapProjectJournal> ls = new ArrayList<>();
        try{
            Session sess = HibernateUtil.getSessionFactory().openSession();            
            ls = sess.createCriteria(MapProjectJournal.class)
                    .add(Restrictions.eq("mapProject", new MapProject(mp))).list();                        
        }catch(HibernateException e)
        {
            log.error("Error " + e);
        }        
        return ls;   
    }

    @Override
    public boolean delObject(Integer key) {
        MapProjectJournal mp = getObject(key);
        if(mp.getMapprojectjournal()==0)
            return false;
        try{
            Session sess = HibernateUtil.getSessionFactory().openSession();
            sess.beginTransaction();
            sess.delete(mp);
            sess.beginTransaction().commit();
        } catch(HibernateException e){
            log.error("Error del object " + e);
        }
        return true;    
    }

    @Override
    public List<MapProjectJournal> getListObject(Date d1, Date d2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Получить список сгрупированных по артикулу задач
     * @param pj - номер задачи
     * @return 
     */
    public List<LMapProjectJournalGroupt> getListLMapProjectJournalGroupt(int pj){
        List<LMapProjectJournalGroupt> ls = new ArrayList<>();
        try{
            Session sess = HibernateUtil.getSessionFactory().openSession();            
            ls = sess.createCriteria(LMapProjectJournalGroupt.class)
                    .add(Restrictions.eq("mapproject", pj)).list();                        
        }catch(HibernateException e){
            log.error("Error " + e);
        }        
        return ls;   
        
    }
    
    
    /**
     * Получить список сгрупированных по артикулу и цвету задач
     * @param pj - номер задачи
     * @return 
     */
    public List<LMapProjectJournalGrouptColor> getListLMapProjectJournalGrouptColor(int pj){
        List<LMapProjectJournalGrouptColor> ls = new ArrayList<>();
        try{
            Session sess = HibernateUtil.getSessionFactory().openSession();            
            ls = sess.createCriteria(LMapProjectJournalGrouptColor.class)
                    .add(Restrictions.eq("mapproject", pj)).list();                        
        }catch(HibernateException e){
            log.error("Error " + e);
        }        
        
        //ls.forEach(System.out::println);
        
        return ls;   
        
    }
    
    /**
     * Получить список строк для запланированной задачи из представления
     * @param mapproject - ид задачи
     * @return 
     */
    public List<LMapProjectJournal> getListLMapProjectJournal(int mapproject){
        List<LMapProjectJournal> journals = null;
        try{
            Session sess = HibernateUtil.getSessionFactory().openSession();
            journals = sess.createCriteria(LMapProjectJournal.class)
                    .add(Restrictions.eq("mapproject", mapproject))
                    .list();
        }catch(HibernateException e){
            log.error(e);
        }
        return journals;
    }
    
    
    
    /**
     * Сохранить загруженные и обработанные строки
     * @param Doc - документ которому принадлежит строки
     * @param ls - список строк для сохранения
     * @return 
     */
    public boolean saveListMapProjectJournal(int Doc, List<MapProjectJournal> ls){
        
        Map<String, Integer> mapDoc =  getListLMapProjectJournal(Doc)
                .stream()
                .collect(Collectors.toMap(t->{ return  t.getModelid()+ "-" + t.getColorid() + "-" + t.getRazmeriid(); }, LMapProjectJournal::getId));            
        
        ls.stream()
                .forEach(t->{    
            String skey = t.getModel().getModel()+ "-" + t.getColor().getColor() + "-" + t.getRazmeri().getRazmeri();
            
            //System.out.println("-->"+ skey);
            
            if(mapDoc.containsKey(skey))
                t.setMapprojectjournal(mapDoc.get(skey));
            else
                t.setMapprojectjournal(null);            
        });
        
        
        try{
            Session sess = HibernateUtil.getSessionFactory().openSession();
            
            sess.beginTransaction();
            int i = 0;
            int j = 0;
            for(MapProjectJournal m: ls){                
                sess.saveOrUpdate(m);
                i++;
                if(i>100){
                    sess.beginTransaction().commit();
                    sess.beginTransaction();
                    i = 0;
                    //System.out.println("------>" + j);
                    j++;
                }
            }
            sess.beginTransaction().commit();
            
        }catch(HibernateException e){
            log.error(e);
        }   
        
        return true;
    }
    
    /**
     * Получить строку по артикулу и цвету
     */
    private LMapProjectJournal getMapProjectJournalForArticleAndColor(int mapproject, int article, int color, int razmeri){
        List<LMapProjectJournal> journals = new ArrayList<>();
        try{
            Session sess = HibernateUtil.getSessionFactory().openSession();
            journals = sess.createCriteria(LMapProjectJournal.class)
                    .add(Restrictions.eq("mapproject", mapproject))
                    .add(Restrictions.eq("modelid", article))
                    .add(Restrictions.eq("colorid", color))
                    .add(Restrictions.eq("razmeriid", razmeri))
                    .list();
            if(journals.isEmpty())
                journals.add(new LMapProjectJournal(0));
        }catch(HibernateException e){
            log.error(e);
            journals.add(new LMapProjectJournal(0));
        }
        return journals.get(0);
    }
    
    
    /**
     * Обновить количество запланированного
     * @param mappj
     * @param qty
     * @return 
     */
    public boolean updateQtyForMapProjectJournal(int mappj, int qty){
        String sql = "update MAPPROJECTJOURNAL set QTY = " + qty + "where MAPPROJECTJOURNAL = " + mappj;
        try{
            Session sess = HibernateUtil.getSessionFactory().openSession();
            sess.beginTransaction();
            sess.createSQLQuery(sql).executeUpdate();
            sess.beginTransaction().commit();
        }catch(HibernateException e){
            return false;
        }
        return true;
    }
    
}
