/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.model;

import java.awt.Component;
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
import org.example.logic.ZadachaScladProduct;
import org.example.util.IOScladProduct;
import org.example.util.IOZadacha;

/**
 *
 * @author ivan
 */
public class ModelScladProduct   extends AbstractTableModel{
    List<ScladProduct> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();

    int vid;
    
    public ModelScladProduct(int v) {
        vid = v;
        listCol.add("№");        
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
        listCol.add("T2"); 
        listCol.add("Комментарий");
        //listCol.add("AGENT"); 
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
                return list.get(rowIndex).getDocumentjournal();
            case 1: 
                return list.get(rowIndex).getPasport();        
            case 2: 
                return list.get(rowIndex).getProduct().getName();    
            case 3: 
                return list.get(rowIndex).getColor().getName();
            case 4: 
                return list.get(rowIndex).getPrice().setScale(2, RoundingMode.HALF_UP);
            case 5: 
                return list.get(rowIndex).getStatus()==0?list.get(rowIndex).getWidthtemp():list.get(rowIndex).getWidth().setScale(0, RoundingMode.HALF_EVEN);
            case 6: 
                return list.get(rowIndex).getStatus()==0?list.get(rowIndex).getLighttemp().setScale(2, RoundingMode.HALF_UP):list.get(rowIndex).getLight().setScale(2, RoundingMode.HALF_UP);
            case 7: 
                return list.get(rowIndex).getVes().setScale(2, RoundingMode.HALF_UP);
            case 8: 
                return list.get(rowIndex).getSclad().getName();
            case 9: 
                return list.get(rowIndex).getDocumentjournal().getDocument().getDates();
            case 10: 
                return list.get(rowIndex).getDocumentjournal().getDocument().getAgent().getName();    
            case 11:
                return list.get(rowIndex).getProduct().getProduct();
            case 12:
                return list.get(rowIndex).getScladproduct();
            case 13:
                return list.get(rowIndex).getTextcomment();    
            
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
     * @param sname
     */
    public void setData(int status, int product, int color, int agent, int width, int sclad, String sname)
    {
        list = IOScladProduct.getListScladProduct(status, vid, product, color, agent, width, sclad, sname);
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
    
    /**
     * Показать данные для товаров которые определили для задачи 
     * @param zp 
     */
    public void setDataForZadachaScladProduct(int zp)
    {
        list.clear();
        for(ZadachaScladProduct s: IOZadacha.getListZadachaScladProduct(zp))
            list.add(s.getScladproduct());
        fireTableDataChanged();
    }
    
    
    /**
     * Удалить строку
     * @param sp
     */
    public void delRow(int sp)
    {
        for(ScladProduct s: list)
        {
            if(s.getScladproduct() == sp)
            {                
                list.remove(s);
                fireTableDataChanged();
                return;
            }
        }
    }
    
    /**
     * Обновить строку
     * @param sp
     */
    public void updateRow(ScladProduct sp)
    {
        for(int i = 0;i<list.size();i++)
        {
            if (Objects.equals(list.get(i).getScladproduct(), sp.getScladproduct())) {
                list.get(i).setTextcomment(sp.getTextcomment());
            }
        }
        fireTableDataChanged();
    }
    
}
