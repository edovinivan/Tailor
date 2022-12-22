/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Arbait.Model;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import org.example.logic.Zadacha;
import org.example.util.HelpClass;
import org.example.util.IOZadacha;

/**
 *
 * @author ivan
 */
public class ModelZadacha extends AbstractTableModel{
    List<Zadacha> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();

    int vid;
    
    public ModelZadacha(int v) {
        vid = v;
        listCol.add("№");        
        listCol.add("Статус");  
        listCol.add("Номер задачи");
        listCol.add("Артикул");  
        listCol.add("Название");  
        listCol.add("Дата");          
        listCol.add("Размеров");
        listCol.add("Изделий");
        listCol.add("Выполнить");  
        listCol.add("S");
        listCol.add("H");
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
                return list.get(rowIndex).getZadacha();            
            case 1: 
                return list.get(rowIndex).getStatus();
            case 2: 
                return list.get(rowIndex).getNomer();        
            case 3: 
                return list.get(rowIndex).getModel().getArticle();
            case 4: 
                return list.get(rowIndex).getModel().getName();                    
            case 5: 
                return HelpClass.getPrintDate(list.get(rowIndex).getDates());            
            case 6: 
                return list.get(rowIndex).getCounts();
            case 7: 
                return list.get(rowIndex).getCountsall();
            case 8: 
                return HelpClass.getPrintDate(list.get(rowIndex).getDateendmax());    
            case 9: 
                return list.get(rowIndex).getNetm();
            case 10: 
                return list.get(rowIndex).getHand();    
                
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    public void setData()
    {
        list = IOZadacha.getListZadacha(-1, vid);
        fireTableDataChanged();
    }
    
    public void setData(Date d1, Date d2, int hand)
    {
        list = IOZadacha.getListZadacha(vid, d1, d2, hand);
        fireTableDataChanged();
    }
    
    public void setDataForCreateNastils(Date d1, Date d2, int hand, boolean is_vizible_close)
    {
        list = IOZadacha.getListZadachaForCreateNastil(d1, d2, hand, is_vizible_close?10:3);
        fireTableDataChanged();
    }
    
    public void setDataForGetMaterial()
    {
        list = IOZadacha.getListZadachaForGetMaterial();
        fireTableDataChanged();
    }
    
    public void setDataForKomplektovka(int hand)
    {
        list = IOZadacha.getListZadachaForKomplektovka(hand);
        fireTableDataChanged();
    }
    
    // подсветка и картинки в таблицу                       
    final ImageIcon edit = new ImageIcon(getClass().getResource("/images/1.png"));
    final ImageIcon ok1 = new ImageIcon(getClass().getResource("/images/2.png"));
    final ImageIcon ok2 = new ImageIcon(getClass().getResource("/images/up.png"));
    final ImageIcon ok3 = new ImageIcon(getClass().getResource("/images/cascade.png"));
    final ImageIcon ok10 = new ImageIcon(getClass().getResource("/images/clos.png"));
    public DefaultTableCellRenderer jTableRenderer = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            JLabel cell = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            //if (vid == 1) {
            int v = Integer.parseInt(cell.getText()) - vid;
                if (column == 1) {
                    switch (v) {
                        case 0:
                            cell.setIcon(edit);
                            cell.setText("");
                            if(vid == 0) cell.setToolTipText("Редактирование");
                            break;
                        case 1:
                            cell.setIcon(ok1);
                            cell.setText("");
                            if(vid == 0) cell.setToolTipText("Набор товара");
                            break;
                        case 2:
                            cell.setIcon(ok2);
                            cell.setText("");
                            if(vid == 0) cell.setToolTipText("Формирование настила");
                            break;
                        case 3:
                            cell.setIcon(ok3);
                            cell.setText("");
                            break;
                        case 10:
                            cell.setIcon(ok10);
                            cell.setText("");
                            break;    
                    }
                }
            return cell;
        }

    };
    
    private ImageIcon ok11 = new ImageIcon(getClass().getResource("/images/Hand.png"));    
    public DefaultTableCellRenderer jTableRendererHand = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            JLabel cell = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            
            int v = Integer.parseInt(cell.getText());
            cell.setIcon(null);
            if(v==1)            
                cell.setIcon(ok11);
            cell.setText("");            
            return cell;
        }

    };
    
}
