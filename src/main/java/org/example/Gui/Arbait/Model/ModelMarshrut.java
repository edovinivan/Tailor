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
import static javax.swing.SwingConstants.LEFT;
import static javax.swing.SwingConstants.RIGHT;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import org.example.logic.ZadachaKomplektovka;
import org.example.util.IOZadachaKomplektovka;

/**
 *
 * @author ivan
 */
public class ModelMarshrut  extends AbstractTableModel{
    List<ZadachaKomplektovka> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();

    public ModelMarshrut() {
        listCol.add("#");          //0
        listCol.add("Статус");     //1   
        listCol.add("Номер");      //2
        listCol.add("ДатаО");  
        listCol.add("Швейный цех");          
        listCol.add("Кол-во");          
        listCol.add("Принял");        //6  
        listCol.add("Сдать до");          
        listCol.add("Сдал");          //8
        listCol.add("Сдал кол-во");          
        listCol.add("Брак");          //10
        listCol.add("Прод");          //11
        listCol.add("НК");          //12
        
        listCol.add("Просрочка");          
        listCol.add("Склад");          //14
        listCol.add("ДатаС");          
        listCol.add("Артикул");        //16  
        listCol.add("Пр");        //17  
    }   

        
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return listCol.size();
    }

    long d;
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex)
        {
            case 0: 
                return list.get(rowIndex).getZadachakomplektovka();
            case 1: 
                return list.get(rowIndex).getStatus();
            case 2: 
                return list.get(rowIndex).getNomer();
            case 3: 
                //return HelpClass.getPrintDate(list.get(rowIndex).getDatasend());
                return list.get(rowIndex).getDatasend();
            case 4: 
                return list.get(rowIndex).getChek().getName();
            case 5: 
                return list.get(rowIndex).getCounts();
            case 6: 
                //return HelpClass.getPrintDate(list.get(rowIndex).getDataget());
                if(list.get(rowIndex).getStatus()>=4)
                    return list.get(rowIndex).getDataget();
                else
                    return "";
            case 7: 
                //return HelpClass.getPrintDate(list.get(rowIndex).getDataend());
                return list.get(rowIndex).getDataend();
            case 8: 
                //return HelpClass.getPrintDate(list.get(rowIndex).getDatareturn());
                if(list.get(rowIndex).getStatus()>=5)
                    return list.get(rowIndex).getDatareturn();
                else
                    return "";
            case 9: 
                return list.get(rowIndex).getCounts() - list.get(rowIndex).getBrak();
            case 10: 
                return list.get(rowIndex).getBrak();    
            case 11: 
                return list.get(rowIndex).getCsale();            
            case 12: 
                return list.get(rowIndex).getBrak1();        
            case 13: 
                d = (list.get(rowIndex).getDatareturn().getTime()-list.get(rowIndex).getDataend().getTime())/(1000*60*60*24);
                if(d<=0)
                    return "";                
                return d;
            case 14: 
                return list.get(rowIndex).getQtysclad();
            case 15: 
                //return HelpClass.getPrintDate(list.get(rowIndex).getDatasclad());
                if(list.get(rowIndex).getStatus()==6)
                    return list.get(rowIndex).getDatasclad();
                else
                    return "";
            case 16: 
                return list.get(rowIndex).getZadacha().getModel().getArticle();
            case 17: 
                return list.get(rowIndex).getCount_pretenzia();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
   /* public void setData(int s)
    {
        list = IOZadachaKomplektovka.getAllMarshrut(s);
        fireTableDataChanged();
    }*/
    
    /**
     * Получение маршрутов в зависимости от статусов
     * @param d1 - начальная дата
     * @param d2 - конечная дата
     * @param s
     * @param view_sclad - показывать принятые на склад
     */
    public void setData(Date d1, Date d2, Integer[] s, boolean view_sclad)
    {
        Integer ss[] = new Integer[4];
        ss[0] = (s[0]==1?3:-1);
        ss[1] = (s[1]==1?4:-1);
        ss[2] = (s[2]==1?5:-1);
        ss[3] = (s[3]==1?6:-1);
        
        if(!view_sclad)
            ss[3] = -1;
        list = IOZadachaKomplektovka.getAllMarshrut(d1,  d2,  ss);
        fireTableDataChanged();
    }
    
    public void setDataForGo()
    {
        list = IOZadachaKomplektovka.getAllMarshrutForGo();
        fireTableDataChanged();
    }
    
    public void setDataForCheh(int ch)
    {
        list = IOZadachaKomplektovka.getMarshrutForCheh(ch);
        fireTableDataChanged();
    }
    
    public void setDataForScladKroi()
    {
        list = IOZadachaKomplektovka.getMarshrutForScladKroi();
        fireTableDataChanged();
    }
    
    
    
    
    // подсветка и картинки в таблицу                       
    public DefaultTableCellRenderer jTableRenderer = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            JLabel cell = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            cell.setHorizontalAlignment(LEFT);
            if (column == 3 || column == 4 || column == 5) {
                cell.setHorizontalAlignment(RIGHT);
            }            
            return cell;
        }

    };
    
    // подсветка и картинки в таблицу                       
    final ImageIcon ok0 = new ImageIcon(getClass().getResource("/org/example/images/1.png"));
    final ImageIcon ok1 = new ImageIcon(getClass().getResource("/org/example/images/forw.png"));
    final ImageIcon ok2 = new ImageIcon(getClass().getResource("/org/example/images/Filled.png"));
    final ImageIcon ok3 = new ImageIcon(getClass().getResource("/org/example/images/2.png"));
    final ImageIcon ok4 = new ImageIcon(getClass().getResource("/org/example/images/clos.png"));
    
    final ImageIcon warn = new ImageIcon(getClass().getResource("/org/example/images/warning.png"));
    
    
    public DefaultTableCellRenderer jTableRenderer1 = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            JLabel cell = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (column == 1) {
            int v = Integer.parseInt(cell.getText())-2;                
                    switch (v) {
                        case 0:
                            cell.setIcon(ok0);
                            cell.setText("");                            
                            cell.setToolTipText("Маршрут сформирован");
                            break;
                        case 1:
                            cell.setIcon(ok1);
                            cell.setText("");
                            cell.setToolTipText("Маршрут отправлен");
                            break;
                        case 2:
                            cell.setIcon(ok2);
                            cell.setText("");
                            cell.setToolTipText("Маршрут получен в цех");
                            break;
                        case 3:
                            cell.setIcon(ok3);
                            cell.setText("");
                            cell.setToolTipText("Маршрут выполнен");
                            break;    
                        case 4:
                            cell.setIcon(ok4);
                            cell.setText("");
                            cell.setToolTipText("Маршрут получен на складе");
                            break;                            
                    }
                }
            return cell;
        }

    };
    
    public DefaultTableCellRenderer jTableRenderer2 = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            JLabel cell = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (column == 17) 
            {
            int v = Integer.parseInt(cell.getText());                
                    switch (v) 
                    {
                        case 0:
                            cell.setIcon(null);
                            cell.setText("");                            
                            break;
                        default:
                            cell.setIcon(warn);
                            cell.setText("");                            
                            break;                                                  
                    }
                }
            return cell;
        }

    };
    
}
