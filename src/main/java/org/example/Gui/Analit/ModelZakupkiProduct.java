/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Analit;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.example.logic.plan.PModelPlanProduct;
import org.example.logic.plan.PZakupkiJournal;
import org.example.util.plan.IOModelPlan;
import org.example.util.plan.IOZakupki;

/**
 *
 * @author ivan
 */
public class ModelZakupkiProduct extends AbstractTableModel{
    
    List<String> listCol = new ArrayList<>();
    List<ProductForZakupki> list = new ArrayList<>();    

    public ModelZakupkiProduct() {
        listCol.add("ID");                        
        listCol.add("ВидПолотна");          
        listCol.add("Цвет");          
        listCol.add("Кол-во");          
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
                return list.get(rowIndex).getId();
            case 1: 
                return list.get(rowIndex).getProduct().getName();            
            case 2: 
                return list.get(rowIndex).getColor().getName();
            case 3: 
                return list.get(rowIndex).getQty().setScale(2);
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    /**
     * Номер закупки
     * @param z 
     */
    public void setData(int z)
    {
        list = new ArrayList<>();
        int f;
        ProductForZakupki k;
        for(PZakupkiJournal j: IOZakupki.getListPZakupkiJournal(z))
        {
            for(PModelPlanProduct j1: IOModelPlan.getListPModelPlanProduct(j.getPmodelplan().getPmodelplan()))
            {
                f = 0;
                for(ProductForZakupki p: list)
                {                
                    if(p.getProduct().getProduct().intValue() == j1.getProduct().getProduct().intValue())
                    {
                        if(p.getColor().getColor().intValue() == j1.getColor().getColor().intValue())
                        { 
                            p.setQty(p.getQty().add(j1.getQty()));
                            f = 1;                            
                        }
                    }
                }
                if(f == 0)
                {
                    k = new ProductForZakupki();
                    k.setColor(j1.getColor());
                    k.setId(list.size());
                    k.setProduct(j1.getProduct());
                    k.setQty(j1.getQty());
                    list.add(k);
                }
            }
            
        }        
        fireTableDataChanged();
    }
    
    public ProductForZakupki getDates(int id)
    {
        for(ProductForZakupki k:list)
            if(id == k.getId())
                return k;
        return null;
    }
    
}
