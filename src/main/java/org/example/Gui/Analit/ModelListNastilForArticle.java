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
import org.example.logic.ZadachaNastil;
import org.example.util.IOZadachaNastil;

/**
 *
 * @author ivan
 */
public class ModelListNastilForArticle extends AbstractTableModel{
    
    List<String> listCol = new ArrayList<>();
    List<ZadachaNastil> list = new ArrayList<>();
    

    public ModelListNastilForArticle() {        
        listCol.add("#");           //0 
        listCol.add("№");          //1
        listCol.add("Настил");
        listCol.add("Дата");        //3
        listCol.add("Вес настила"); //4 
        listCol.add("Отходы");
        listCol.add("%Отходы");     //6
        listCol.add("Доп арт.");
        listCol.add("Длина");       //8
        listCol.add("Ширина");   
        listCol.add("Руч.Ст.");   
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
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex==10)
            return Boolean.class;
        return super.getColumnClass(columnIndex); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        switch(columnIndex)
        {
            case 0: 
                return list.get(rowIndex).getZadachanastil();
            case 1: 
                return rowIndex + 1;
            case 2: 
                return list.get(rowIndex).getNomer();
            case 3: 
                return list.get(rowIndex).getDateclose();
            case 4: 
                return list.get(rowIndex).getQtynull().setScale(2, RoundingMode.HALF_UP);
            case 5: 
                //return list.get(rowIndex).getQtydel().add(list.get(rowIndex).getQtytruba()).add(list.get(rowIndex).getQtyend()).add(list.get(rowIndex).getQtylosk()).setScale(2, RoundingMode.HALF_UP);
                return list.get(rowIndex).getQtydel().setScale(2, RoundingMode.HALF_UP);
            case 6: 
                return list.get(rowIndex).getQtydel().divide(list.get(rowIndex).getQtynull().divide(new BigDecimal("100"),6, RoundingMode.HALF_UP), 6, RoundingMode.HALF_UP).setScale(2, RoundingMode.HALF_UP);
            case 7: 
                return list.get(rowIndex).getQtyaddarticle().setScale(2, RoundingMode.HALF_UP);
            case 8: 
                return list.get(rowIndex).getDlina().setScale(0, RoundingMode.HALF_UP);
            case 9: 
                return list.get(rowIndex).getWidth();    
            case 10: 
                return list.get(rowIndex).getZadacha().getHand()==1;       
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        
        return listCol.get(column);
    }
    
    
    public void setData(int art, Date d1, Date d2)
    { 
        List<ZadachaNastil> ls = IOZadachaNastil.getListNastilForArticle(art, d1, d2);
        list = ls;
        for(ZadachaNastil z: list)
        {
            z.setQtynull(z.getQtyaddarticle().add(z.getQtybeika()).add(z.getQtydel()).add(z.getQtyend()).add(z.getQtygut()).add(z.getQtylosk()).add(z.getQtynull()).add(z.getQtyreturn()).add(z.getQtytruba()));
            z.setQtydel(z.getQtydel().add(z.getQtylosk()).add(z.getQtyend()).add(z.getQtytruba()));
        }
        fireTableDataChanged();
    }
    
}
