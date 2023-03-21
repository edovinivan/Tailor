/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Analit;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.example.util.plan.IOModelPlan;

/**
 *
 * @author ivan
 */
public class ModelPlanTimeTable  extends AbstractTableModel{
    
    private class mplan 
    {
        String chex;
        String gname;
        Integer op;
        Integer opm;

        public mplan() {
        }

        public String getChex() {
            return chex;
        }

        public void setChex(String chex) {
            this.chex = chex;
        }

        public String getGname() {
            return gname;
        }

        public void setGname(String gname) {
            this.gname = gname;
        }

        public Integer getOp() {
            return op;
        }

        public void setOp(Integer op) {
            this.op = op;
        }

        public Integer getOpm() {
            return opm;
        }

        public void setOpm(Integer opm) {
            this.opm = opm;
        }
        
    }
    
    List<String> listCol = new ArrayList<>();
    List<mplan> list = new ArrayList<>();
    

    public ModelPlanTimeTable() {        
        listCol.add("Цех");           
        listCol.add("Гр.Операций");            
        listCol.add("План");            
        listCol.add("Максимум");            
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
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        switch(columnIndex)
        {
            case 0: 
                return list.get(rowIndex).getChex();
            case 1: 
                return list.get(rowIndex).getGname();
            case 2: 
                return list.get(rowIndex).getOp();
            case 3: 
                return list.get(rowIndex).getOpm();
            
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        
        return listCol.get(column);
    }
    
    
    public void setData(Date d1, Date d2)
    { 
        mplan m;
        String ss[];
        for(String s: IOModelPlan.getTimeForModelPlan(d1, d2))
        { 
            ss = s.split("<!>");            
            m = new mplan();
            m.setChex(ss[0]);
            m.setGname(ss[1]);
            m.setOp(new BigDecimal(ss[2]).intValue());
            m.setOpm(new BigDecimal(ss[3]).intValue());
            list.add(m);
        }
        fireTableDataChanged();
    }
    
}
