/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import org.example.logic.LSZadacha;
import org.example.logic.Model;
import org.example.logic.ModelPrintDetali;
import org.example.logic.ModelProduct;
import org.example.logic.Razmeri;
import org.example.logic.ScladProduct;
import org.example.logic.Zadacha;
import org.example.logic.ZadachaKomplektovka;
import org.example.logic.ZadachaNastil;
import org.example.logic.ZadachaNastilProduct;
import org.example.logic.ZadachaPrintDetali;
import org.example.logic.ZadachaProduct;
import org.example.logic.ZadachaRazmeri;
import org.example.logic.ZadachaScladProduct;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ivan
 */
public class IOZadacha { 
    
    
    /**
     * Изменение привязку запланированной задачи
     * @param z
     * @param s
     * @return 
     */
    public static boolean updateMPlanHauptForZadacha(int z, int s)
    {
        
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            sess.beginTransaction();
            String sql = "update zadacha set p_modelplanhaupt = "+s+" where Zadacha = " + z;
            sess.createSQLQuery(sql).executeUpdate();
            sess.beginTransaction().commit();            
           
        } catch (HibernateException e) {
            System.out.println("ERROR UPADTE" + e);
            return false;
        }
        return true;
    }
    
    
    /**
     * Изменение статуса наличия материала
     * @param z
     * @param s
     * @return 
     */
    public static boolean updateNetMForZadacha(int z, int s)
    {
        // получим количество деталей на узготовление
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            sess.beginTransaction();
            String sql = "update zadacha set netm = "+s+" where Zadacha = " + z;
            sess.createSQLQuery(sql).executeUpdate();
            sess.beginTransaction().commit();            
           
        } catch (HibernateException e) {
            System.out.println("ERROR UPADTE" + e);
            return false;
        }
        return true;
    }
    
    /**
     * Проверка полотен.
     * Если используются полотна и в этой поставке были такие же полотна и они не проверены
     * То запрещаем выполнение
     * @param z - задача
     * @return - результат  
     *    true - можно использовать
     *   false - нельзя использовать
     * 
     */
    public  static boolean checkProductForListDocument(int z)
    {
        Session sess = HibernateUtil.getSessionFactory().openSession(); 
        String sql;
        int r;
        for(ZadachaScladProduct zp: IOZadacha.getListZadachaScladProductForZadacha(z))
        {
            sql = "select count(sp.scladproduct) from scladproduct sp inner join documentjournal dj on dj.documentjournal = sp.documentjournal where dj.document = "+zp.getScladproduct().getDocumentjournal().getDocument().getDocument()+" and sp.product = "+zp.getScladproduct().getProduct().getProduct()+" and sp.color = "+zp.getScladproduct().getColor().getColor()+" and sp.status = 0";
            r = ((BigInteger)sess.createSQLQuery(sql).uniqueResult()).intValue();
            if(r>0)
                return false;
        }
        return true;
    }
    
    /**
     * Проверим все или нет закрыты настилы и весь или нет изработан материал
     * @param z 
     * @return -1 - незакрытый настил
     *         -2 - невыбранный материал
     */
    public static int getCloseZadacha(int z)
    {        
        for(ZadachaNastil zn : IOZadachaNastil.getListZadachaNastil(z, -1))
            if(zn.getStatus()<3)
                return -1;
        for(ZadachaScladProduct zp: getListZadachaScladProductForZadacha(z))
            if(zp.getNastil()==0)
                return -2;
        return 0;
    }
    
    /**
     * расчитать количество нужного материала для изготовления заказа
     * @param zad - задача
     * @return 
     */
    public static boolean executeProductForZadacha(int zad)
    {
        // получим количество деталей на узготовление
        try 
        {
            BigInteger h;
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            sess.beginTransaction();
            String s = "select sum(qty) from zadacharazmeri where Zadacha = " + zad;
            h = (BigInteger)sess.createSQLQuery(s).uniqueResult();
            sess.beginTransaction().commit();
            
            //System.out.println("Всего деталей = " + h.intValue() );
            
            List<ZadachaProduct> ls = sess.createCriteria(ZadachaProduct.class).add(Restrictions.eq("zadacha", new Zadacha(zad))).list();            
            //System.out.println("Всего товаров = " + ls.size() );
            sess.beginTransaction();
            for(ZadachaProduct z: ls)
            {
                z.setQty(z.getQty1().multiply(new BigDecimal(h)));
                sess.saveOrUpdate(z);
            }
            sess.beginTransaction().commit();
           
        } catch (HibernateException e) {
            System.out.println("ERROR UPADTE" + e);
            return false;
        }
        return true;
    }
    
    /**
     * Проверить и автоматически закрыть задачу
     * @param z - номер задачи
     */
    public static void autoCloseZadacha(int z)
    {
        Zadacha zz = getListZadacha(z, 0).get(0);
                
        // если закрыты все настилы
        if(zz.getStatus()==3)
        {
            //если все маршруты вернулись
            if (IOZadachaKomplektovka.getListZadachaKomplektovkaIsNotGut(zz.getZadacha()).isEmpty()) 
            {
                // посмотрим все или нет закрыты принты и вышивки
                List<ZadachaPrintDetali> ls = IOZadachaPrintDetali.getListZadachaPrintDetaliForZadacha(zz.getZadacha());
                if (!ls.isEmpty()) {
                    for (ZadachaPrintDetali z1 : ls) {
                        if (z1.getStatus() != 1) {
                            //System.out.println("Принт не закрыт" + z.getZadachaprintdetali());
                            return;
                        }
                    }
                    // Изменим статус на закрытый
                    for (ZadachaPrintDetali z1 : ls) {
                        IOZadachaPrintDetali.updateStatusPD(z1.getZadachaprintdetali(), 2);
                    }

                }
                //закроем задачу
                IOZadacha.setNewStatusZadacha(zz.getZadacha(), 10);
            }
                    //else
            // System.out.println("Не все маршруты вернулмсь");

        }
    }
    
    /**
     * Изменить статус задания
     * двигаемся вперед
     * @param z - задача
     * @param status - новый статус
     * @return 
     */
    public static boolean setNewStatusZadacha(int z, int status)
    {
        try 
        {            
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            sess.beginTransaction();
            String s = "update Zadacha set status = "+status+", DATEEND = 'NOW' where Zadacha = " + z;
            sess.createSQLQuery(s).executeUpdate();
            sess.beginTransaction().commit();
            // если закрываем настилы то пометим все настилы как закрытые
            if(status==10)
            {
                sess.beginTransaction();
                s = "update ZADACHANASTIL set status = 4 where Zadacha = " + z;
                sess.createSQLQuery(s).executeUpdate();
                sess.beginTransaction().commit();
            }
            
            // если утверждаем что полотна набраны
            if(status==2)
            {
                sess.beginTransaction();
                s = "update Zadacha set datestart = 'NOW', datesclad = 'NOW' where Zadacha = " + z;
                sess.createSQLQuery(s).executeUpdate();
                sess.beginTransaction().commit();
                
                // установим максимальный коэффициент полотна
                
                s = "update zadacha set koef = ( select\n"
                        + "    coalesce(max(p.koef),0)\n"
                        + "  from zadachascladproduct zs\n"
                        + "  inner join scladproduct sp on sp.scladproduct = zs.scladproduct\n"
                        + "  inner join zadachaproduct zp on zp.zadachaproduct = zs.zadachaproduct\n"
                        + "  inner join modelproduct mp on mp.modelproduct = zp.modelproduct\n"
                        + "  inner join tipproduct tp on tp.tipproduct = mp.tipproduct\n"
                        + "  inner join product p on sp.product = p.product\n"
                        + "  where tp.tipproduct = 1 and zs.zadacha = " + z + ") where zadacha = " + z;
                
                sess.beginTransaction();                
                sess.createSQLQuery(s).executeUpdate();
                sess.beginTransaction().commit();

                Zadacha zd = IOZadacha.getListZadacha(z, 0).get(0);
                ZadachaPrintDetali zp;
                for(ModelPrintDetali p : IOModel.getListModelPrintDetali(zd.getModel().getModel(), -1, 1))
                {
                    zp = new ZadachaPrintDetali();
                    zp.setPrice(new BigDecimal(0));
                    zp.setPrintdetali(p.getPrintdetali());
                    zp.setQty(1);
                    zp.setQtyend(1);
                    zp.setStatus(0);
                    zp.setVid(1);
                    zp.setZadacha(zd);
                    zp.setZadachaprintdetali(0);
                    zp.setDates(zd.getDates());
                    IOZadachaPrintDetali.setZadachaPrintDetali(zp);
                }
                
                for(ModelPrintDetali p : IOModel.getListModelPrintDetali(zd.getModel().getModel(), -1, 2))
                {
                    zp = new ZadachaPrintDetali();
                    zp.setPrice(new BigDecimal(0));
                    zp.setPrintdetali(p.getPrintdetali());
                    zp.setQty(1);
                    zp.setQtyend(1);
                    zp.setStatus(0);
                    zp.setVid(2);
                    zp.setZadacha(zd);
                    zp.setDates(zd.getDates());
                    zp.setZadachaprintdetali(0);
                    IOZadachaPrintDetali.setZadachaPrintDetali(zp);
                }
            }
           
        } catch (HibernateException e) {
            System.out.println("ERROR UPADTE" + e);
            return false;
        }        
        
        return true;
    }
    
    /**
     * Изменить статус задания
     * Откатываем изменения
     * @param z - задача
     * @param status - новый статус
     * @return 
     */
    public static boolean setOldStatusZadacha(int z, int status)
    {
        try 
        {
            
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            sess.beginTransaction();
            String s = "update Zadacha set status = "+status+" where Zadacha = " + z;
            sess.createSQLQuery(s).executeUpdate();
            sess.beginTransaction().commit();
            // если открываем задание для редактирования настилов
            if(status==3)
            {
                sess.beginTransaction();
                s = "update ZADACHANASTIL set status = 3 where Zadacha = " + z;
                sess.createSQLQuery(s).executeUpdate();
                sess.beginTransaction().commit();
            }
            
            //если открываем для набора товара
            if(status == 1)
            {
                sess.beginTransaction();
                s = "delete from ZADACHAPRINTDETALI where Zadacha = " + z;
                sess.createSQLQuery(s).executeUpdate();
                sess.beginTransaction().commit();
            }
           
        } catch (HibernateException e) {
            System.out.println("ERROR UPADTE" + e);
            return false;
        }        
        
        return true;
    }
    
    /**
     * Сохранить количество для размера
     * @param zr - задачаразмер
     * @param qty - количество
     * @return 
     */
    public static boolean setQtyForZR(int zr, int qty)
    {
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            // удалим все размеры для данной задачи
            sess.beginTransaction();
            String s = "update ZadachaRazmeri set qty = "+qty+" where ZadachaRazmeri = " + zr;
            sess.createSQLQuery(s).executeUpdate();
            sess.beginTransaction().commit();          
            
           
        } catch (HibernateException e) {
            System.out.println("ERROR ADD ZR" + e);
            return false;
        }        
        
        return true;
    }
    /**
     * Добавить размеры для формирования задания по выбранной модели
     * @param zadacha - задача
     * @param model - модель для задачи
     * @return 
     */
    public static boolean setRazmeriForZadacha(int zadacha, int model)
    {
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            // удалим все размеры для данной задачи
            sess.beginTransaction();
            String s = "delete from ZadachaRazmeri where Zadacha = " + zadacha;
            sess.createSQLQuery(s).executeUpdate();
            sess.beginTransaction().commit();
            
            // удалим количество товара для выполнения задачи
            sess.beginTransaction();
            s = "delete from ZadachaProduct where Zadacha = " + zadacha;
            sess.createSQLQuery(s).executeUpdate();
            sess.beginTransaction().commit();
            
            // получим модель для задачи
            Model mod = IOModel.getListModel(model, -1, true).get(0);
            // получим все размеры для данной модели 
            List<Razmeri> lRazm = sess.createCriteria(Razmeri.class).add(Restrictions.ge("nom", mod.getFirstrazmeri().getNom())).add(Restrictions.eq("razmerigruppa", mod.getFirstrazmeri().getRazmerigruppa())).addOrder(Order.asc("nom")).list();            
            ZadachaRazmeri zr;
            sess.beginTransaction();
            for(Razmeri r: lRazm)
            {
                zr = new ZadachaRazmeri();
                zr.setQty(0);
                zr.setQtyend(0);
                zr.setRazmeri(r);
                zr.setZadacha(new Zadacha(zadacha));
                zr.setZadacharazmeri(null);
                sess.saveOrUpdate(zr);
            }
            sess.beginTransaction().commit();
            // добавим материалы для выполнения задачи
            List<ModelProduct> lMP = sess.createCriteria(ModelProduct.class).add(Restrictions.eq("model", mod)).list();            
            ZadachaProduct zp;
            sess.beginTransaction();
            for(ModelProduct r: lMP)
            {
                zp = new ZadachaProduct();                
                zp.setQty(new BigDecimal(0));
                // если это материал
                if(r.getProduct().getVid() == 1)                    
                    zp.setQty1(r.getQty_start()/*.multiply(new BigDecimal(r.getQty()))*/);
                else
                    zp.setQty1(r.getQty());
                
                zp.setModelproduct(r);
                zp.setZadacha(new Zadacha(zadacha));
                zp.setZadachaproduct(null);
                sess.saveOrUpdate(zp);
            }
            sess.beginTransaction().commit();
            
            
        } catch (HibernateException e) {
            System.out.println("ERROR ADD ZR" + e);
            return false;
        }        
        
        return true;
    }
    /**
     * Сохранить задачу
     * @param p - объект
     * @return - объект
     */
    public static Zadacha setZadacha(Zadacha p)
    {
        if(p.getZadacha()== 0)
            p.setZadacha(null);
        
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
     * Получить список задач
     * @param p - id объекта
     * @param vid - вид     
     * @return 
     */
    public static List<Zadacha> getListZadacha(int p, int vid)
    {
        List<Zadacha> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            if(p == -1)
                ls = sess.createCriteria(Zadacha.class).add(Restrictions.eq("del", 0)).add(Restrictions.ge("status", vid)).addOrder(Order.desc("dates")).list();            
            else
                ls = sess.createCriteria(Zadacha.class).add(Restrictions.eq("zadacha", p)).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Получить задачи склад продукт
     * @param d
     * @return 
     */
    public static ZadachaScladProduct getZadachaScladProduct(int d)
    {
        List<ZadachaScladProduct> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
                ls = sess.createCriteria(ZadachaScladProduct.class).add(Restrictions.eq("zadachascladproduct", d)).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls.get(0);        
    }
    
    /**
     * Получить список задач     
     * @param vid - вид     
     * @param d1     
     * @param d2     
     * @param hand  - Ручной стол        
     * @return 
     */
    public static List<Zadacha> getListZadacha(int vid, Date d1, Date d2, int hand)
    {
        List<Zadacha> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            if(hand !=- 1)
                ls = sess.createCriteria(Zadacha.class).add(Restrictions.eq("hand", hand)).add(Restrictions.eq("del", 0)).add(Restrictions.ge("status", vid)).add(Restrictions.between("dates", d1, d2)).addOrder(Order.desc("dateendmax")).list();            
            else
                ls = sess.createCriteria(Zadacha.class).add(Restrictions.eq("del", 0)).add(Restrictions.ge("status", vid)).add(Restrictions.between("dates", d1, d2)).addOrder(Order.desc("dateendmax")).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    
    /**
     * Получить список задач     
     * @param vid - вид     
     * @param d1     
     * @param d2     
     * @param hand  - Ручной стол        
     * @return 
     */
    public static List<LSZadacha> getListLSZadacha(int vid, Date d1, Date d2, int hand)
    {
        List<LSZadacha> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            if(hand !=- 1)
                ls = sess.createCriteria(LSZadacha.class).add(Restrictions.eq("hand", hand)).add(Restrictions.eq("del", 0)).add(Restrictions.ge("status", vid)).add(Restrictions.between("dates", d1, d2)).addOrder(Order.desc("dateendmax")).list();            
            else
                ls = sess.createCriteria(LSZadacha.class).add(Restrictions.eq("del", 0)).add(Restrictions.ge("status", vid)).add(Restrictions.between("dates", d1, d2)).addOrder(Order.desc("dateendmax")).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    
    
    /**
     * Получить список задач     
     * @param d1     
     * @param d2     
     * @param hand  - Ручной стол        
     * @param maxstat - максимальный статус задачи по умолчанию 3        
     * @return 
     */
    public static List<Zadacha> getListZadachaForCreateNastil(Date d1, Date d2, int hand, int maxstat)
    {
        List<Zadacha> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            if(hand !=-1)
                ls = sess.createCriteria(Zadacha.class).add(Restrictions.eq("hand", hand)).add(Restrictions.eq("del", 0)).add(Restrictions.between("status", 2, maxstat)).add(Restrictions.between("dates", d1, d2)).addOrder(Order.desc("dateendmax")).list();            
            else
                ls = sess.createCriteria(Zadacha.class).add(Restrictions.eq("del", 0)).add(Restrictions.between("status", 2, maxstat)).add(Restrictions.between("dates", d1, d2)).addOrder(Order.desc("dateendmax")).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    
    /**
     * Получить список задач для набора материала
     * @return 
     */
    public static List<Zadacha> getListZadachaForGetMaterial()
    {
        List<Zadacha> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(Zadacha.class).add(Restrictions.eq("del", 0)).add(Restrictions.between("status", 1, 3)).addOrder(Order.desc("dates")).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Получить список задач для комплектовки
     * @param hand - ручной стол
     * @return 
     */
    public static List<Zadacha> getListZadachaForKomplektovka(int hand)
    {
        List<Zadacha> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();  // 
            ls = sess.createCriteria(Zadacha.class).add(Restrictions.eq("hand", hand)).add(Restrictions.eq("del", 0)).add(Restrictions.between("status", 2, 3)).addOrder(Order.desc("dates")).list();            
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
    public static boolean delZadacha(int p)
    {
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();             
            // удалим товары задачи
            sess.beginTransaction();
            String s = "delete from zadachaproduct where Zadacha = " + p;
            sess.createSQLQuery(s).executeUpdate();
            sess.beginTransaction().commit();
            
            // удалим количество задачи
            sess.beginTransaction();
            s = "delete from zadacharazmeri where Zadacha = " + p;
            sess.createSQLQuery(s).executeUpdate();
            sess.beginTransaction().commit();
            
            // удалим  задачу
            sess.beginTransaction();
            s = "delete from zadacha where Zadacha = " + p;
            sess.createSQLQuery(s).executeUpdate();
            sess.beginTransaction().commit();
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
            return false;
        }        
        return true;
        
    }
    
    /**
     * Сохранить размер задачи
     * @param p - объект
     * @return - объект
     */
    public static ZadachaRazmeri setZadachaRazmeri(ZadachaRazmeri p)
    {
        if(p.getZadacharazmeri()== 0)
            p.setZadacharazmeri(null);
        
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
     * Получить список размеров задачи
     * @param zadacha
     * @param zr
     * @return 
     */
    public static List<ZadachaRazmeri> getListZadachaRazmeri(int zadacha, int zr)
    {
        List<ZadachaRazmeri> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            if(zr == 0)
                ls = sess.createCriteria(ZadachaRazmeri.class).add(Restrictions.eq("zadacha", new Zadacha(zadacha))).list();            
            else
                ls = sess.createCriteria(ZadachaRazmeri.class).add(Restrictions.eq("zadacharazmeri", zr)).list();            
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
    public static boolean delZadachaRazmeri(int p)
    {
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            sess.beginTransaction();
            String s = "delete from ZadachaRazmeri where ZadachaRazmeri = " + p;
            sess.createSQLQuery(s).executeUpdate();
            sess.beginTransaction().commit();
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
            return false;
        }        
        return true;
        
    }
    
     /**
     * Сохранить количество товара задачи
     * @param p - объект
     * @return - объект
     */
    public static ZadachaProduct setZadachaProduct(ZadachaProduct p)
    {
        if(p.getZadachaproduct()== 0)
            p.setZadachaproduct(null);
        
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
     * Получить список размеров задачи
     * @param zadacha
     * @param zr - строка товара задачи
     * @param vid - вид товара
     * @return 
     */
    public static List<ZadachaProduct> getListZadachaProduct(int zadacha, int zr, int vid)
    {
        List<ZadachaProduct> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            if(zr == 0)
                ls = sess.createCriteria(ZadachaProduct.class).add(Restrictions.eq("zadacha", new Zadacha(zadacha))).createAlias("modelproduct", "mp").add(Restrictions.eq("mp.vid", vid)).list();            
            else
                ls = sess.createCriteria(ZadachaProduct.class).add(Restrictions.eq("zadachaproduct", zr)).list();            
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
    public static boolean delZadachaProduct(int p)
    {
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            sess.beginTransaction();
            String s = "delete from ZadachaProduct where ZadachaProduct = " + p;
            sess.createSQLQuery(s).executeUpdate();
            sess.beginTransaction().commit();
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
            return false;
        }        
        return true;
        
    }
    
    
     /**
     * Сохранить рулон полотна для задачи
     * @param p - объект
     * @return - объект
     */
    public static ZadachaScladProduct setZadachaScladProduct(ZadachaScladProduct p)
    {
        if(p.getZadachascladproduct()== 0)
            p.setZadachascladproduct(null);
        
        Session sess = HibernateUtil.getSessionFactory().openSession();
        try 
        {
            sess.beginTransaction();
            sess.saveOrUpdate(p);
            sess.beginTransaction().commit();
            // пометим рулон как взятый со склада
            ScladProduct sp = p.getScladproduct();
            sp.setStatus(2);
            sess.beginTransaction();
            sess.saveOrUpdate(sp);
            sess.beginTransaction().commit();
            
        }catch(HibernateException e)
        {
            System.out.println("ERROR SAVE" + e);            
        }
        return p;
    }
    
    
    /**
     * Получить список товаров которые выделили для задачи
     * @param zp - материал для задачи
     * @return 
     */
    public static List<ZadachaScladProduct> getListZadachaScladProduct(int zp)
    {
        List<ZadachaScladProduct> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(ZadachaScladProduct.class).add(Restrictions.eq("zadachaproduct", new ZadachaProduct(zp))).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Получить список товаров которые выделили для задачи
     * @param zadacha - материал для задачи
     * @return 
     */
    public static List<ZadachaScladProduct> getListZadachaScladProductForZadacha(int zadacha)
    {
        List<ZadachaScladProduct> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(ZadachaScladProduct.class).add(Restrictions.eq("zadacha", new Zadacha(zadacha))).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Удалить товар выбранный для задачи со клада
     * @param zsp - ид объекта
     * @return - результат
     */
    public static boolean delZadachaScladProduct(int zsp)
    {
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            
            //пометим рулон полотка как не взятый со склада
            sess.beginTransaction();
            String s = "update ScladProduct set status = 1 where scladproduct = (select ScladProduct from ZadachaScladProduct where ZadachaScladProduct = " + zsp+")";
            sess.createSQLQuery(s).executeUpdate();
            sess.beginTransaction().commit();
            
            sess.beginTransaction();
            s = "delete from ZadachaScladProduct where ZadachaScladProduct = " + zsp;
            sess.createSQLQuery(s).executeUpdate();
            sess.beginTransaction().commit();
            
            /*
            //пометим рулон полотка как не взятый со склада
            sess.beginTransaction();
            s = "update ScladProduct set status = 1 where scladproduct = (select ScladProduct from ZadachaScladProduct where ZadachaScladProduct = " + zsp+")";
            sess.createSQLQuery(s).executeUpdate();
            sess.beginTransaction().commit();/**/
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
            return false;
        }        
        return true;
        
    }
    
    /**
     * Получить ZadachaScladProduct по строке складской позиции и виду товара
     * @param ZadachaProduct - строка товара для задачи
     * @param ScladProduct - строка со склада
     * @return 
     */
    public static ZadachaScladProduct getZSP(int ZadachaProduct, int ScladProduct)
    {
        List<ZadachaScladProduct> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(ZadachaScladProduct.class).add(Restrictions.eq("scladproduct", new ScladProduct(ScladProduct))).add(Restrictions.eq("zadachaproduct", new ZadachaProduct(ZadachaProduct))).list();            
            if(ls.isEmpty())
                ls.add(new ZadachaScladProduct(0));
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
            ls.add(new ZadachaScladProduct(0));
        }        
        return ls.get(0);        
    }
    
    /**
     * Печать задачи в HTML файл
     * @param z - номер задачи
     * @return - файл
     */
    public static String printZadachaForHtml(int z)
    {
        File f = null;
        try {
            f = File.createTempFile("tempfil", ".html");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Ошибка создания файла \n"+ex);
        }
        
        try (PrintWriter outs = new PrintWriter(new OutputStreamWriter(new FileOutputStream(f, false), "cp1251"), false)) 
        {
            Zadacha zd = IOZadacha.getListZadacha(z, -1).get(0);
            outs.println("<HTML><HEAD><TITLE> Задача №" + zd.getNomer()+" </TITLE></HEAD><BODY>");
            outs.println("<h2>Задача №" + zd.getNomer()+" от "+zd.getDates()+" </h2><br>");            
            outs.println("Конфекционная карта: " + zd.getModel().getArticle() + "  "+zd.getModel().getName()+ " от "+ zd.getModel().getDates() + " <br>");
            outs.println("Размеры:<br>");
            outs.println("<table width=100% border = 1><tr><td>Размер</td><td>Количество</td></tr>");
            for(ZadachaRazmeri zr: IOZadacha.getListZadachaRazmeri(z, 0))
            {
                if(zr.getQty()!=0)
                    outs.println("<tr><td>"+zr.getRazmeri().getName()+" </td><td>"+zr.getQty()+" </td><tr>");
            }
            outs.println("</table>");
            outs.println("Операции:<br>");
            
            
            
            outs.println("<h3>Набранное полотно:</h3>");
            outs.println("<table width=100% border = 1><tr><td>Артикул</td><td>Полотно</td><td>Цвет</td><td>Вес</td><td>Цена</td></tr>");
            BigDecimal summa_all = new BigDecimal(0);
            BigDecimal ves_all = new BigDecimal(0);
            for(ZadachaScladProduct zp: IOZadacha.getListZadachaScladProductForZadacha(z))
            {
                outs.println("<tr><td>"+zp.getScladproduct().getPasport()+" </td><td>"+zp.getScladproduct().getProduct().getName()+" </td><td>"+zp.getScladproduct().getColor().getName()+" </td><td>"+zp.getScladproduct().getVes().setScale(2, RoundingMode.HALF_UP)+" </td><td>"+zp.getScladproduct().getPrice().setScale(2, RoundingMode.HALF_UP)+" </td><tr>");
                summa_all = summa_all.add(zp.getScladproduct().getPrice().multiply(zp.getScladproduct().getVes()));
                ves_all = ves_all.add(zp.getScladproduct().getVes());
            }
            outs.println("<tr><td></td><td></td><td>Всего: </td><td>"+ves_all.setScale(2, RoundingMode.HALF_UP)+"</td><td>"+summa_all.setScale(2, RoundingMode.HALF_UP)+" </td><tr>");
            outs.println("</table>");
            
            outs.println("<h3>Настилы:</h3>");
            
            BigDecimal q1 = new BigDecimal(0);
            BigDecimal q2 = new BigDecimal(0);
            BigDecimal q3 = new BigDecimal(0);
            BigDecimal q4 = new BigDecimal(0);
            BigDecimal q5 = new BigDecimal(0);
            BigDecimal q6 = new BigDecimal(0);
            BigDecimal q7 = new BigDecimal(0);
            
            for(ZadachaNastil zn: IOZadachaNastil.getListZadachaNastil(z, -1))
            {
                outs.println("<h4>№" + zn.getNomer()+"</h4>");
                outs.println("<table width=100% border = 1><tr><td>Артикул</td><td>Полотно</td><td>Цвет</td><td>Вес</td><td>Цена</td></tr>");
                summa_all = new BigDecimal(0);
                ves_all = new BigDecimal(0);
                for(ZadachaNastilProduct s: IOZadachaNastil.getListZadachaNastilProduct(zn.getZadachanastil()))
                {
                    outs.println("<tr><td>"+s.getZadachascladproduct().getScladproduct().getPasport()+" </td><td>"+s.getZadachascladproduct().getScladproduct().getProduct().getName()+" </td><td>"+s.getZadachascladproduct().getScladproduct().getColor().getName()+" </td><td>"+s.getZadachascladproduct().getScladproduct().getVes().setScale(2, RoundingMode.HALF_UP)+" </td><td>"+s.getZadachascladproduct().getScladproduct().getPrice().setScale(2, RoundingMode.HALF_UP)+" </td><tr>");
                    summa_all = summa_all.add(s.getZadachascladproduct().getScladproduct().getPrice().multiply(s.getZadachascladproduct().getScladproduct().getVes()));
                    ves_all = ves_all.add(s.getZadachascladproduct().getScladproduct().getVes());
                }
                outs.println("<tr><td></td><td></td><td>Всего: </td><td>"+ves_all.setScale(2, RoundingMode.HALF_UP)+"</td><td>"+summa_all.setScale(2, RoundingMode.HALF_UP)+" </td><tr>");
                outs.println("</table>");
                outs.println("<br>Вес концевых остатков:" + zn.getQtyend().setScale(2, RoundingMode.HALF_UP));
                outs.println("<br>Вес отходов:" + zn.getQtydel().setScale(2, RoundingMode.HALF_UP));
                outs.println("<br>Вес лоскутов:" + zn.getQtylosk().setScale(2, RoundingMode.HALF_UP));
                outs.println("<br>Вес кроя:" + zn.getQtygut().setScale(2, RoundingMode.HALF_UP));
                outs.println("<br>Вес трубки:" + zn.getQtytruba().setScale(2, RoundingMode.HALF_UP));
                outs.println("<br>Вес дополнительно артикула:" + zn.getQtyaddarticle().setScale(2, RoundingMode.HALF_UP));
                outs.println("<br>Вес возврата:" + zn.getQtyreturn().setScale(2, RoundingMode.HALF_UP));
                
                q1 = q1.add(zn.getQtyend());
                q2 = q2.add(zn.getQtydel());
                q3 = q3.add(zn.getQtylosk());
                q4 = q4.add(zn.getQtygut());
                q5 = q5.add(zn.getQtytruba());
                q6 = q6.add(zn.getQtyaddarticle());
                q7 = q7.add(zn.getQtyreturn());
                
                
            }
            
            outs.println("<h5>Итого по всем настилам:</h5>");
            outs.println("<br>Вес концевых остатков:" + q1.setScale(2, RoundingMode.HALF_UP));
            outs.println("<br>Вес отходов:" + q2.setScale(2, RoundingMode.HALF_UP));
            outs.println("<br>Вес лоскутов:" + q3.setScale(2, RoundingMode.HALF_UP));
            outs.println("<br>Вес кроя:" + q4.setScale(2, RoundingMode.HALF_UP));
            outs.println("<br>Вес трубки:" + q5.setScale(2, RoundingMode.HALF_UP));
            outs.println("<br>Вес дополнительно артикула:" + q6.setScale(2, RoundingMode.HALF_UP));
            outs.println("<br>Вес возврата:" + q7.setScale(2, RoundingMode.HALF_UP));

            // пачки кроя
            outs.println("<h3>Маршруты:</h3>");
            outs.println("<table width=100% border = 1><tr><td>Цех</td><td>Комплектовщик</td><td>Дата</td></tr>");
            for(ZadachaKomplektovka k: IOZadachaKomplektovka.getListZadachaKomplektovka(z, -1))
            {
                outs.println("<tr><td>"+k.getChek().getName()+" </td>"
                        + "<td>"+k.getRabotnik().getName()+" </td>"
                        + "<td>"+k.getDates()+" </td>"
                        + "<tr>");
            }
            outs.println("</table>");        

            outs.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Ошибка записи в файл \n"+ex);
        }
        return f.getAbsolutePath();
    }
    
}
