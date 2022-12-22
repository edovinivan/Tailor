/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Arbait.Model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.example.logic.ZadachaProduct;
import org.example.util.IOZadacha;
import org.example.util.IOZadachaFurnitura;

/**
 *
 * @author ivan
 * модель для вывода фурнитуры для комплектовки
 */
public class ModelZadachaKomplektovkaFurnitura extends AbstractTableModel{
    List<ZadachaProduct> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();

    public ModelZadachaKomplektovkaFurnitura() {
        listCol.add("#");
        listCol.add("Фурнитура");        
        listCol.add("Цвет");        
        listCol.add("Количество");          
        listCol.add("НБ");
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
        if(columnIndex==4)
            return Boolean.class;
        return super.getColumnClass(columnIndex); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex)
        {
            case 0: 
                return list.get(rowIndex).getZadachaproduct();
            case 1: 
                return list.get(rowIndex).getModelproduct().getProduct().getName();
            case 2: 
                return list.get(rowIndex).getModelproduct().getColor().getName();
            case 3: 
                return list.get(rowIndex).getQty().setScale(0,RoundingMode.HALF_EVEN);
            case 4: 
                return list.get(rowIndex).getAll_qty().signum()>0;    
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    public void setData(int qty)
    {
        for(int i=0;i<list.size();i++)
            list.get(i).setQty(list.get(i).getQty1().multiply(new BigDecimal(qty)));
        fireTableDataChanged();
    }
    
    public void getNullData(int z)
    {
        //System.out.println("ZZZZ = " + z);
        list = IOZadacha.getListZadachaProduct(z, 0, 2);
        fireTableDataChanged();
    }
    
    
    public void setQtyData(int k)
    {
        for(int i=0;i<list.size();i++)
            list.get(i).setAll_qty(new BigDecimal(IOZadachaFurnitura.getQtyFurnituraForKomplektovka(k, list.get(i).getZadachaproduct())));
        fireTableDataChanged();
    }
}
/*class furnituraQty
{
    ZadachaProduct zp;
    BigDecimal qty;
}*/