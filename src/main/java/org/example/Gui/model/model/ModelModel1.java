/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.model.model;


import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import org.example.logic.LModel1;
import org.example.util.HelpClass;
import org.example.util.IOModel;

/**
 *
 * @author ivan
 */
public class ModelModel1   extends AbstractTableModel{
    List<LModel1> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();

    
    public ModelModel1() {
        listCol.add("№");
        listCol.add("Статус");
        listCol.add("№");
        listCol.add("Артикул");        
        listCol.add("Название");       
        listCol.add("Дата");        
        listCol.add("Модель");        
        listCol.add("Ком");        
        listCol.add("Цех");        
        listCol.add("HArticle");        
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
                return list.get(rowIndex).getModel();
            case 1: 
                return list.get(rowIndex).getStatus();
            case 2: 
                return rowIndex+1;    
            case 3: 
                return list.get(rowIndex).getArticle();
            case 4: 
                return list.get(rowIndex).getName();
            case 5: 
                return HelpClass.getPrintDate(list.get(rowIndex).getDates());
            case 6: 
                return list.get(rowIndex).getTipmodel();        
            case 7: 
                return list.get(rowIndex).getCoucom();
            case 8: 
                return list.get(rowIndex).getChex();    
            case 9: 
                return list.get(rowIndex).getHarticle();        
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    public void setData(boolean all)
    {
        list = IOModel.getListLModel1(all);
        fireTableDataChanged();
    }
    
    public void setData(String str)
    {
        list = IOModel.getListLModel1(str);
        fireTableDataChanged();
    }
    
    public void setNullCouData()
    {
        for(LModel1 l: list)
            l.setCoucom(0);
        rea = true;
    }
    
    boolean rea = false;

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if(!rea)
            return false;
        return columnIndex==7;    
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if(columnIndex==7)
        {
            int l = 0;
            try
            {
                 l = Integer.parseInt(String.valueOf(aValue));
            }catch(NumberFormatException e){}
            
           list.get(rowIndex).setCoucom(l);        
        }
    }
    
    
    public List<LModel1> getData()            
    {
        return list;
    }
    
    
        // подсветка и картинки в таблицу                       
    final ImageIcon edit = new ImageIcon(getClass().getResource("/org/example/images/1.png"));
    final ImageIcon ok = new ImageIcon(getClass().getResource("/org/example/images/2.png"));
    final ImageIcon clos = new ImageIcon(getClass().getResource("/org/example/images/clos.png"));
    final ImageIcon block = new ImageIcon(getClass().getResource("/org/example/images/block.png"));
    final ImageIcon pen = new ImageIcon(getClass().getResource("/org/example/images/Pen.png"));
    final ImageIcon question = new ImageIcon(getClass().getResource("/org/example/images/question.png"));
    
    

    public final DefaultTableCellRenderer jTableRenderer = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            JLabel cell = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            
            if (column == 1) {
                switch (Integer.parseInt(cell.getText())) {
                    case 0:
                        cell.setIcon(edit);
                        cell.setText("");
                        break;
                    case 1:
                        cell.setIcon(ok);
                        cell.setText("");
                        break;
                    case 2:
                        cell.setIcon(clos);
                        cell.setText("");
                        break;    
                    case 3:
                        cell.setIcon(block);
                        cell.setText("");
                        break;        
                    
                }
            }
            return cell;
        }

    };
    
    public final DefaultTableCellRenderer jTableRenderer1 = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            JLabel cell = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            
            if (column == 7) {
                switch (Integer.parseInt(cell.getText())) {
                    case -1:
                        cell.setIcon(null);
                        cell.setText("");
                        break;
                    case 0:
                    case 1:    
                        cell.setIcon(question);
                        cell.setText("");
                        break;    
                    default:
                        cell.setIcon(pen);
                        cell.setText("");
                        break;                    
                }
            }
            return cell;
        }

    };
    
}
