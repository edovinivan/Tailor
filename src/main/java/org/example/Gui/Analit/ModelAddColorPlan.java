/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Analit;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.example.logic.Color;
import org.example.logic.Model;
import org.example.logic.ModelProduct;
import org.example.logic.RabotnikGruppa;
import org.example.logic.Razmeri;
import org.example.logic.plan.PModelPlan;
import org.example.logic.plan.PModelPlanProduct;
import org.example.logic.plan.PModelPlanRazmeri;
import org.example.util.HelpClass;
import org.example.util.IOModel;
import org.example.util.IORazmeri;
import org.example.util.plan.IOModelPlan;

/**
 *
 * @author ivan
 */
public class ModelAddColorPlan extends AbstractTableModel{
    
    List<String> listCol = new ArrayList<>();
    List<Razmeri> list = new ArrayList<>();
    
    boolean isR = false;

    public ModelAddColorPlan(boolean f) {
        listCol.add("ID");        
        listCol.add("Размер");          
        listCol.add("Кол-во");        
        isR = f;
    }   
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return listCol.size();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if(isR)
            return columnIndex==2;
        else 
            return false;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if(columnIndex == 2)
        {
            list.get(rowIndex).setDel(HelpClass.GetIntIzText((String) aValue));
            return;
        }
        super.setValueAt(aValue, rowIndex, columnIndex); //To change body of generated methods, choose Tools | Templates.
    }
       

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        switch(columnIndex)
        {
            case 0: 
                return list.get(rowIndex).getRazmeri();
            case 1: 
                return list.get(rowIndex).getName();     
            case 2: 
                return list.get(rowIndex).getDel();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    
    public void setData(int g)
    {
        list = IORazmeri.getListRazmeriForGruppa1(g);
        for(Razmeri r:list)
            r.setDel(0);
        fireTableDataChanged();
    }
    
    public void setDataForPModel(int mp)
    {
        list.clear();
        List<PModelPlanRazmeri> ls = IOModelPlan.getListPModelPlanRazmeriForPlan(mp);
        Razmeri rr;
        for(PModelPlanRazmeri r: ls)
        {            
            rr = r.getRazmeri();
            rr.setRazmeri(r.getPmodelplanrazmeri());
            rr.setName(rr.getName() + "(" + r.getTx() + ")");
            rr.setDel(r.getQty());
            list.add(rr);
        }
        fireTableDataChanged();
    }
    
    public int getAllQtyRazmeri()
    {
        int rq = 0;
        for(Razmeri r:list)
        {
            if(r.getDel()>0)
            {
                rq = rq + r.getDel();
            }
        }
        return rq;
    }
    
    /**
     * Сохранить операции в план
     * @param model - модель
     * @param d - дата производства
     * @param color - цвет
     * @param d1 - дата закупок
     * @param comm1 - комментарий
     * @param d5 - дата начала продаж
     * @return 
     */
    public int saveMPlan(int model, Date d, int color, Date d1, String comm1, Date d5)
    {
        PModelPlan pp;
        PModelPlanRazmeri pr;
        pp = new PModelPlan();
        pp.setChex(new RabotnikGruppa(0));
        pp.setColor(new Color(color));
        pp.setDates(d);
        pp.setDates1(d1);
        pp.setDates2(new Date());
        pp.setModel(new Model(model));
        pp.setStatus(1);
        pp.setPmodelplan(0);
        pp.setComment1(comm1);
        pp.setDates5(d5);
        pp = IOModelPlan.setPModelPlan(pp);                
        
        for(Razmeri r:list)
        {
            if(r.getDel()>0)
            {
                pr = new PModelPlanRazmeri();
                pr.setPmodelplan(pp);
                pr.setPmodelplanrazmeri(0);
                pr.setQty(r.getDel());
                pr.setRazmeri(new Razmeri(r.getRazmeri()));
                IOModelPlan.setPModelPlanRazmeri(pr);
            }
        }
        PModelPlanProduct p1;
        // сохраним товары которые нужны для заявки
        for(ModelProduct m: IOModel.getListModelProduct(model, -1, 1))
        {
            p1 = new PModelPlanProduct();
            p1.setModelproduct(m);
            p1.setPmodelplan(pp);
            p1.setPmodelplanproduct(0);
            p1.setQty(BigDecimal.ZERO);
            if(m.getTipproduct().getTipproduct()==1)
                p1.setColor(new Color(color));
            else
                p1.setColor(m.getColor());
            p1.setProduct(m.getProduct());
            IOModelPlan.setPModelPlanProduct(p1);
        }
        return pp.getPmodelplan();
    }
    
}
