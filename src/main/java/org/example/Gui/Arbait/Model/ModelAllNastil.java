/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Arbait.Model;

import java.awt.Component;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import org.example.logic.ZadachaNastil;
import org.example.util.IOZadachaNastil;

/**
 *
 * @author ivan
 */
public class ModelAllNastil extends AbstractTableModel{
    List<ZadachaNastil> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();
    
    public ModelAllNastil() {
        
        listCol.add("#");           //0
        listCol.add("Статус");      //1
        listCol.add("Задача");      //2
        listCol.add("Настил");  
        listCol.add("Артикул");  
        listCol.add("Длина");       //5
        listCol.add("Тип полотна");  
        listCol.add("ВидП");  
        listCol.add("Тип Настила");  //8
        listCol.add("Вес возврата");  
        listCol.add("Неучт.");    //10
        listCol.add("Паспорта");    //11
        listCol.add("ДатаЗ");    //12
        listCol.add("РС");    //13
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
                return list.get(rowIndex).getZadachanastil();
            case 1: 
                return list.get(rowIndex).getStatus();
            case 2: 
                return list.get(rowIndex).getZadacha().getNomer();        
            case 3: 
                return list.get(rowIndex).getNomer();
            case 4: 
                return list.get(rowIndex).getZadacha().getModel().getArticle();
            case 5: 
                return list.get(rowIndex).getDlina().setScale(0, RoundingMode.HALF_UP);
            case 6: 
                return list.get(rowIndex).getTippolotna().getName();
            case 7: 
                return list.get(rowIndex).getPachka()==1?"Пачка":"Рулон";    
            case 8: 
                return list.get(rowIndex).getTipnastila().getName();
            case 9: 
                return list.get(rowIndex).getQtyreturn().setScale(2, RoundingMode.HALF_UP);
            case 10: 
                return list.get(rowIndex).getQtynull().setScale(2, RoundingMode.HALF_UP);    
            case 11: 
                return list.get(rowIndex).getPasportreturn();
            case 12: 
                if(list.get(rowIndex).getStatus()>1)
                    return list.get(rowIndex).getDateclose();
                    //return HelpClass.getPrintDate(list.get(rowIndex).getDateclose());
                else
                    return "";
            case 13: 
                return list.get(rowIndex).getZadacha().getHand();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    public void setData(int minS, int maxS, int hand)
    {
        list = IOZadachaNastil.getListAllNastil(minS, maxS, hand);
        fireTableDataChanged();
    }
    
    public void setData(int minS, int maxS, int hand, Date d1, Date d2)
    {
        list = IOZadachaNastil.getListAllNastil(minS, maxS,hand, d1, d2);
        fireTableDataChanged();
    }
    
    // подсветка и картинки в таблицу                       
    final ImageIcon edit = new ImageIcon(getClass().getResource("/org/example/images/1.png"));
    final ImageIcon ok1 = new ImageIcon(getClass().getResource("/org/example/images/2.png"));
    final ImageIcon ok2 = new ImageIcon(getClass().getResource("/org/example/images/bac.png"));
    final ImageIcon ok3 = new ImageIcon(getClass().getResource("/org/example/images/clos.png"));
    
    public DefaultTableCellRenderer jTableRenderer = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            JLabel cell = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (column == 1) {
                int v = Integer.parseInt(cell.getText());
                switch (v) {
                    case 1:
                        cell.setIcon(edit);
                        cell.setText("");
                        break;
                    case 2:
                        cell.setIcon(ok2);
                        cell.setText("");
                        break;
                    case 3:
                        cell.setIcon(ok1);
                        cell.setText("");
                        break;
                    case 4:
                        cell.setIcon(ok3);
                        cell.setText("");
                        break;    
                }
            }
            return cell;
        }

    };
    
}
