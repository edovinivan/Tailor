/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.util.plan;

import org.example.Gui.Analit.TimeChexOperation;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import org.example.logic.OperationGruppa;
import org.example.logic.RabotnikGruppa;
import org.example.logic.plan.PCalendar;
import org.example.logic.plan.PModelPlan;
import org.example.logic.plan.PTimeChex;
import org.example.logic.plan.PTimeOpChex;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.example.util.HelpClass;
import org.example.util.HibernateUtil;
import org.example.util.IOOperation;
import org.example.util.IORabotnik;
import org.hibernate.Transaction;

/**
 *
 * @author ivan
 */
public class IOTimeOpChex {
    /**
     * Сохранить объект
     * @param p - объект
     * @return - объект
     */
    public static PTimeOpChex setPTimeOpChex(PTimeOpChex p)
    {
        if(p.getPtimeopchex()== 0)
            p.setPtimeopchex(null);
        
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
     * @param chex - цех  0 -все
     * @return 
     */
    public static List<PTimeOpChex> getListPTimeOpChex(int chex)
    {
        List<PTimeOpChex> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            if(chex == 0)
                ls = sess.createCriteria(PTimeOpChex.class).addOrder(Order.asc("chex")).addOrder(Order.asc("operationgruppa")).list();            
            else
                ls = sess.createCriteria(PTimeOpChex.class).add(Restrictions.eq("chex", new RabotnikGruppa(chex))).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Получить объект
     * @param p - цех
     * @return 
     */
    public static PTimeOpChex getPTimeOpChex(int p)
    {
        List<PTimeOpChex> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(PTimeOpChex.class).add(Restrictions.eq("ptimeopchex", p)).list();            
            if(ls.isEmpty())
                ls.add(new PTimeOpChex(0));
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls.get(0);        
    }
    
    /**
     * Удалить объект
     * @param p - ид объекта
     * @return - результат
     */
    public static boolean delPTimeOpChex(int p)
    {
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            Transaction transaction = sess.beginTransaction();
            String s = "delete from P_TIMEOPCHEX where P_TIMEOPCHEX = " + p;
            sess.createSQLQuery(s).executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
            return false;
        }        
        return true;
        
    }
    
     /**
     * Получить объект по цеху и операции
     * @param opergruppa
     * @param chex
     * @return 
     */
    public static PTimeOpChex getPTimeOpChex(int opergruppa, int chex)
    {
        List<PTimeOpChex> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(PTimeOpChex.class).add(Restrictions.eq("chex", new RabotnikGruppa(chex))).add(Restrictions.eq("operationgruppa", new OperationGruppa(opergruppa))).list();            
            if(ls.isEmpty())
                ls.add(new PTimeOpChex(0));
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls.get(0);        
    }
   
    /**
     * Добавить строку времени
     * @param p
     * @return 
     */
    public static PTimeOpChex addPTimeOpChex(PTimeOpChex p)
    {
        PTimeOpChex pp = getPTimeOpChex(p.getOperationgruppa().getOperationgruppa(), p.getChex().getRabotnikgruppa());
        p.setPtimeopchex(pp.getPtimeopchex());
        return setPTimeOpChex(p);
    }
    
    /**
     * Сохранить дату
     * @param p - объект
     * @return - объект
     */
    public static PCalendar setPCalendar(PCalendar p)
    {
        p.setPcalendar(getPCalendarForDateForChex(p.getDates(), p.getChex().getRabotnikgruppa()).getPcalendar());
        if(p.getPcalendar()== 0)
            p.setPcalendar(null);
        
        
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
    public static List<PCalendar> getListPCalendar()
    {
        List<PCalendar> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();            
            ls = sess.createCriteria(PCalendar.class).addOrder(Order.desc("dates")).list();            
            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }
    
    /**
     * Получить список объектов     
     * @param d
     * @return 
     */
    public static PCalendar getPCalendarForDateForChex(Date d, int chex)
    {
        List<PCalendar> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();            
            ls = sess.createCriteria(PCalendar.class).add(Restrictions.eq("dates", d)).add(Restrictions.eq("chex", new RabotnikGruppa(chex))).list();            
            if(ls.isEmpty())
                ls.add(new PCalendar(0));
            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
            ls.add(new PCalendar(0));
        }        
        return ls.get(0);        
    }
    
    /**
     * Получить список объектов     
     * @param d
     * @return 
     */
    public static PCalendar getPCalendar(int d)
    {
        List<PCalendar> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();            
            ls = sess.createCriteria(PCalendar.class).add(Restrictions.eq("pcalendar", d)).list();            
            if(ls.isEmpty())
                ls.add(new PCalendar(0));
            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
            ls.add(new PCalendar(0));
        }        
        return ls.get(0);        
    }
    
    /**
     * Получить список объектов     
     * @param d
     */
    public static void delPCalendar(int d)
    {
        PCalendar p = getPCalendar(d);
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();            
            Transaction transaction = sess.beginTransaction();
            sess.delete(p);
            transaction.commit();
            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
    }
    
    
    /**
     * Сохранить операции в цех
     * @param p - объект
     * @return - объект
     */
    public static PTimeChex setPTimeChex(PTimeChex p)
    {
        if(p.getPtimechex()== 0)
            p.setPtimechex(null);
        
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
     * Сохранить операции в цех
     * @param p - объект
     * @return - объект
     */
    public static PTimeChex savePTimeChex(PTimeChex p)
    {
        PTimeChex cp = getPTimeChexForChexAndPModel(p.getChex().getRabotnikgruppa(), p.getPmodelplan().getPmodelplan());
        if(cp.getPtimechex()!=0)
        {
            int mk = p.getQty() + cp.getQty();
            if(mk > cp.getPmodelplan().getSumqty())
            {
                JOptionPane.showMessageDialog(null, "Ошибка. Перераспределение операций!");
                return p;
            }
            cp.setQty(mk);
            return setPTimeChex(cp);
        }        
        
        return setPTimeChex(p);
    }
    
    /**
     * Удалить распределение в цех
     * @param p
     * @return 
     */
    public static int delPTimeChex(int p)
    {
        PTimeChex pp = getPTimeChex(p);
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = sess.beginTransaction();
            sess.delete(pp);
            transaction.commit();
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }    
        
        return 0;
    }
    
    /**
     * Получить загруженность цехов
     * @param d1
     * @param d2
     * @return 
     */
    public static List<TimeChexOperation> getChexOp(Date d1, Date d2)
    {
        long milliseconds = d2.getTime() - d1.getTime();
        int days = (int) (milliseconds / (24 * 60 * 60 * 1000));
        List<TimeChexOperation> ls = new ArrayList<>();
        TimeChexOperation t;
        
        List<PTimeOpChex> lspo = IOTimeOpChex.getListPTimeOpChex(0);
                
        for(int i=1;i<4;i++)
        {
            for(OperationGruppa o: IOOperation.getListOperationGruppa(-1))
            {
                t = new TimeChexOperation();
                t.setChex(i==3?7:i);
                t.setChexName(IORabotnik.getListRabotnikGruppa(t.getChex()).get(0).getName());
                t.setOper(o.getOperationgruppa());
                t.setOperName(IOOperation.getListOperationGruppa(t.getOper()).get(0).getName());
                t.setQty_chex(0);
                t.setQty_pm(0);
                t.setQty_max(0);
                
                
                //максимальные возможности
                for(PTimeOpChex h: lspo)
                {
                    if(h.getChex().getRabotnikgruppa() == t.getChex())
                        if(h.getOperationgruppa().getOperationgruppa() == t.getOper())
                        {
                            t.setQty_max(h.getTimes()*days);
                        }
                }
                
                ls.add(t);
            }
        }
                
                
        String sql = "select rg.rabotnikgruppa || '<!>' || og.operationgruppa || '<!>' || cast(sum(pt.qty * mo.times) as integer)  \n"
                + "from p_timechex pt\n"
                + "inner join p_modelplan pm on pm.p_modelplan = pt.p_modelplan\n"
                + "inner join model m on m.model = pm.model\n"
                + "inner join modeloperation mo on mo.model = m.model\n"
                + "inner join operation o on o.operation = mo.operation\n"
                + "inner join operationgruppa og on og.operationgruppa = o.operationgruppa\n"
                + "inner join rabotnikgruppa rg on rg.rabotnikgruppa = pt.chex\n"
                + "where pm.dates between '" + HelpClass.getPrintDate1(d1) + "' and '" + HelpClass.getPrintDate1(d2) + "'\n"
                + "group by   rg.rabotnikgruppa, og.operationgruppa";
        
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            List<String> ls1 = sess.createSQLQuery(sql).list();
            String ss[];
            int c,p,q;
            for(String s: ls1)
            {
                ss = s.split("<!>");
                c = Integer.parseInt(ss[0]);
                p = Integer.parseInt(ss[1]);
                q = Integer.parseInt(ss[2]);
                for(TimeChexOperation r: ls)
                {
                    if(r.getChex() == c)
                    {
                        if(r.getOper() == p)
                        {
                            r.setQty_chex(q);
                        }
                    }
                }
            }
            
            
            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }    
        return ls;
    }
            
    
    
    /**
     * Получить список объектов
     * @param chex - цех  0 -все
     * @return 
     */
   /* public static List<PTimeOpChex> getListPTimeOpChex(int chex)
    {
        List<PTimeOpChex> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            if(chex == 0)
                ls = sess.createCriteria(PTimeOpChex.class).addOrder(Order.asc("chex")).addOrder(Order.asc("operationgruppa")).list();            
            else
                ls = sess.createCriteria(PTimeOpChex.class).add(Restrictions.eq("chex", new RabotnikGruppa(chex))).list();            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls;        
    }*/
    
    /**
     * Получить объект
     * @param p - цех
     * @return 
     */
    public static PTimeChex getPTimeChex(int p)
    {
        List<PTimeChex> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(PTimeChex.class).add(Restrictions.eq("ptimechex", p)).list();            
            if(ls.isEmpty())
                ls.add(new PTimeChex(0));
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls.get(0);        
    }
    
    /**
     * Получить объект по цеху и задаче
     * @param ch
     * @param pm
     * @return 
     */
    public static PTimeChex getPTimeChexForChexAndPModel(int ch, int pm)
    {
        List<PTimeChex> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(PTimeChex.class).add(Restrictions.eq("pmodelplan", new PModelPlan(pm))).add(Restrictions.eq("chex", new RabotnikGruppa(ch))).list();            
            if(ls.isEmpty())
                ls.add(new PTimeChex(0));
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls.get(0);        
    }
    
    
    /**
     * Получить объект по  задаче     
     * @param pm
     * @return 
     */
    public static PTimeChex getPTimeChexForPModel(int pm)
    {
        List<PTimeChex> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(PTimeChex.class).add(Restrictions.eq("pmodelplan", new PModelPlan(pm))).list();            
            if(ls.isEmpty())
                ls.add(new PTimeChex(0));
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }        
        return ls.get(0);        
    }
    
    
    /**
     * Получить количество операций в цехе в настоящее время
     * @param opg - группа операций
     * @param cx - цех
     * @return 
     */
    public static int getOpInCexCurrent(int opg, int cx)
    {
        BigDecimal op = BigDecimal.ZERO;
        BigDecimal op1;
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            //сколько всего операций отправили
            String sql = "select\n"
                    + "     sum(zr.qty * mo.times)\n"
                    + "   from zadachakomplektovka zk\n"
                    + "   inner join zadachakomplektovkarazmeri zr on zr.zadachakomplektovka = zk.zadachakomplektovka\n"
                    + "   inner join model m on m.model = zk.model\n"
                    + "   inner join modeloperation mo on mo.model = m.model\n"
                    + "   inner join operation o on o.operation = mo.operation\n"
                    + "   where zk.status between 3 and 5 and o.operationgruppa = "+ opg +" and zk.chex = " + cx;
            
            op = (BigDecimal)sess.createSQLQuery(sql).uniqueResult();            
            
            sql = "select\n"
                    + "     sum(ro.qty * ( select mo.times from modeloperation mo where mo.model = zk.model and mo.operation = o.operation))\n"
                    + "   from zadachakomplektovka zk\n"
                    + "   inner join rabotnikoperation ro on ro.zadachakomplektovka = zk.zadachakomplektovka\n"
                    + "   inner join operation o on o.operation = ro.operation\n"
                    + "   where zk.status between 3 and 5 and o.operationgruppa = "+opg+"  and zk.chex = " + cx;
            
            op1 = (BigDecimal)sess.createSQLQuery(sql).uniqueResult();            
            
            op = op.subtract(op1);
            
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
        }   
        
        return op.intValue();
    }
    
    
    
}
