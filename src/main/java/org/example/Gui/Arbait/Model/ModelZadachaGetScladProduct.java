/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Arbait.Model;

import java.awt.Component;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.swing.JLabel;
import javax.swing.JTable;
import static javax.swing.SwingConstants.LEFT;
import static javax.swing.SwingConstants.RIGHT;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import org.example.logic.ScladProduct;
import org.example.logic.ZadachaProduct;
import org.example.logic.ZadachaScladProduct;
import org.example.util.IOScladProduct;
import org.example.util.IOZadacha;

/**
 *
 * @author ivan
 * модель для выбора полотен для задачи
 */
public class ModelZadachaGetScladProduct  extends AbstractTableModel{
    List<ScladProduct> list = new ArrayList<>();
    List<ScladProduct> listP = new ArrayList<>();
    //List<ZadachaScladProduct> listZP = new ArrayList<>();
    List<String> listCol = new ArrayList<>();

    int vid;
    ZadachaProduct zp;
    JLabel jl;
    
    public void setLabel(JLabel l)
    {
        jl = l;
    }
    
    public void setStartData(ZadachaProduct z1)
    {
        zp = z1;
    }
    
    public ModelZadachaGetScladProduct(int v) {
        vid = v;
        listCol.add("№");        
        listCol.add("#");        
        listCol.add("Паспорт");
        listCol.add("Название");
        listCol.add("Цвет");
        listCol.add("Цена");
        listCol.add(vid==1?"Ширина":"Кол-во");
        listCol.add("Длина");
        listCol.add("Вес");
        listCol.add("МестоХранения");
        listCol.add("Дата поступления");
        listCol.add("Поставщик");
        listCol.add("T1");        
    }   
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex == 1) return Boolean.class;
        return super.getColumnClass(columnIndex); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 1;
    }

    @Override
    public int getColumnCount() {
        return listCol.size();
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if(columnIndex==1)
        {
            // добавляем товар
            if((boolean) aValue)
            {
                for(ScladProduct sp: listP)
                {
                    if(Objects.equals(sp.getScladproduct(), list.get(rowIndex).getScladproduct()))
                        return;
                }
                //if(listP.indexOf(list.get(rowIndex))!=-1)
                //    return;
                ZadachaScladProduct zz = new ZadachaScladProduct();
                zz.setZadacha(zp.getZadacha());
                zz.setZadachaproduct(zp);
                zz.setZadachascladproduct(0);
                zz.setScladproduct(list.get(rowIndex));
                zz.setNastil(0);
                IOZadacha.setZadachaScladProduct(zz);
                getDataZP();                
                //listZP.add(zz);  
                //System.out.println(list.get(rowIndex).getPasport());
            }
            else // удаляем товар из выбранных
            {
                ZadachaScladProduct zz = IOZadacha.getZSP(zp.getZadachaproduct(), list.get(rowIndex).getScladproduct());
                if(zz.getZadachascladproduct() == 0) return;
                IOZadacha.delZadachaScladProduct(zz.getZadachascladproduct());
                getDataZP();
                fireTableDataChanged();
            }
            //jl.setText("Итого: ");
            printAllQty();
            //IOZadacha.setZadachaScladProduct(null)
        }
    }
    
    
    private void printAllQty()
    {
        BigDecimal d = BigDecimal.ZERO;
        for(ScladProduct e: listP)
            d = d.add(e.getVes());
        jl.setText("Итого: "+d.setScale(2, RoundingMode.HALF_UP).toString());    
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex)
        {
            case 0: 
                return list.get(rowIndex).getDocumentjournal();
            case 1: 
            {
                for(ScladProduct sp: listP)
                {
                    if(Objects.equals(sp.getScladproduct(), list.get(rowIndex).getScladproduct()))
                        return true;
                }
                return false;
                //System.out.println(listP.indexOf(list.get(rowIndex)));
                //return listP.indexOf(list.get(rowIndex))>=0;    
            }
            case 2: 
                return list.get(rowIndex).getPasport();        
            case 3: 
                return list.get(rowIndex).getProduct().getName();    
            case 4: 
                return list.get(rowIndex).getColor().getName();
            case 5: 
                return list.get(rowIndex).getPrice().setScale(2, RoundingMode.HALF_UP);
            case 6: 
            {
                if(vid==1)
                    return list.get(rowIndex).getWidth().setScale(0, RoundingMode.HALF_EVEN);
                else
                    return list.get(rowIndex).getWidth().setScale(2, RoundingMode.HALF_EVEN);
            }
            case 7: 
                return list.get(rowIndex).getLight().setScale(2, RoundingMode.HALF_UP);
            case 8: 
                return list.get(rowIndex).getVes().setScale(2, RoundingMode.HALF_UP);
            case 9: 
                return list.get(rowIndex).getSclad().getName();
            case 10: 
                return list.get(rowIndex).getDocumentjournal().getDocument().getDates();
            case 11: 
                return list.get(rowIndex).getDocumentjournal().getDocument().getAgent().getName();    
            case 12:
                return list.get(rowIndex).getProduct().getProduct();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    /***
     * Обновить данные
     * @param status 
     * 0 - все
     * 1 - те что на складе
     * @param product - товар
     * @param color
     * @param agent
     * @param width
     * @param sclad
     * @param str - текст поиска
     */
    public void setData(int status, int product, int color, int agent, int width, int sclad, String str)
    {
        list = IOScladProduct.getListScladProduct(status, vid, product, color, agent, width, sclad, str);
        getDataZP();
        for(ScladProduct s: listP)
            list.add(s);
        fireTableDataChanged();
        printAllQty();
    }
    
    public void getDataZP()
    {
        //listZP = IOZadacha.getListZadachaScladProduct(zp.getZadachaproduct());
        listP.clear();
        for(ZadachaScladProduct s: IOZadacha.getListZadachaScladProduct(zp.getZadachaproduct()))
        {
            //list.add(s.getScladproduct());
            listP.add(s.getScladproduct());
        }
    }
    
    /**
     * показать выбранные товары
     */
    
    public void openSelectProduct()
    {
        list.clear();
        list = listP;
        fireTableDataChanged();
    }
    
    public DefaultTableCellRenderer jTableRenderer = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            JLabel cell = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            cell.setHorizontalAlignment(LEFT);
            if (column >3 && column < 8)                
            {                
                cell.setHorizontalAlignment(RIGHT);
            }
            return cell;
        }

    };
    
}
