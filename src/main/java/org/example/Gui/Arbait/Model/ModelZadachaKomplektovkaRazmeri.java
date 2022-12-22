/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Arbait.Model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.table.AbstractTableModel;
import org.example.logic.ZadachaKomplektovkaRazmeri;
import org.example.util.IOZadachaKomplektovka;

/**
 *
 * @author ivan
 * Модель таблицы для показа размеров в окне комплектовки
 */
public class ModelZadachaKomplektovkaRazmeri extends AbstractTableModel{
    List<ZadachaKomplektovkaRazmeri> list = new ArrayList<>();
    //List<ZadachaKomplektovkaRazmeri> list1 = new ArrayList<>();
    List<String> listCol = new ArrayList<>();
    
    ModelZadachaKomplektovkaFurnitura  model2;
    JPanel panel;
    
    public void setModel2(ModelZadachaKomplektovkaFurnitura  k)
    {
        model2 = k;
    }
    
    boolean stop = false;
    public void setStop()
    {
        stop = true;
    }
    
    public void setPanel(JPanel k)
    {
        panel = k;
    }

    public ModelZadachaKomplektovkaRazmeri() {
        listCol.add("#");
        listCol.add("IO");
        listCol.add("Размер");        
        listCol.add("Количество");  
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
                return list.get(rowIndex).getZadachakomplektovkarazmeri();
            case 1: 
                return list.get(rowIndex).getCounts()>0;
            case 2: 
                return list.get(rowIndex)./*getZadacharazmeri().*/getRazmeri().getName();        
            case 3: 
                return list.get(rowIndex).getQty();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if(stop) return false;
        if(columnIndex == 1) return true;
        return columnIndex == 3;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex==1)
            return Boolean.class;
        return super.getColumnClass(columnIndex); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (columnIndex == 3) 
        {
            int k;
            try {
                k = Integer.parseInt((String) aValue);
            } catch (NumberFormatException e) {
                k = 0;
            }
            IOZadachaKomplektovka.setQtuForZKR(list.get(rowIndex).getZadachakomplektovkarazmeri(), k);
            list.get(rowIndex).setQty(k);
            model2.setData(getQty());
            panel.setBorder(javax.swing.BorderFactory.createTitledBorder("Размеры (" + getQty() + ")"));
            fireTableDataChanged();
        }
        if(columnIndex==1)
            list.get(rowIndex).setCounts(((boolean)aValue)?1:0);
    }
    
    /**
     * присвоить количество выделенным строкам
     * @param nv - новое количество
     */
    public void setSelectDataForRow(int nv)
    {
        for (ZadachaKomplektovkaRazmeri list11 : list) 
        {
            if(list11.getCounts()==1)
            {
                IOZadachaKomplektovka.setQtuForZKR(list11.getZadachakomplektovkarazmeri(), nv);
                list11.setQty(nv);
                list11.setCounts(0);                
            }            
        }
        model2.setData(getQty());
        panel.setBorder(javax.swing.BorderFactory.createTitledBorder("Размеры (" + getQty() + ")"));
        fireTableDataChanged();
    }
    
    public void setData(int zk)
    {
        list = IOZadachaKomplektovka.getListZadachaKomplektovkaRazmeri(zk);        
        
        for (ZadachaKomplektovkaRazmeri list11 : list) 
            list11.setCounts(0);
        
        fireTableDataChanged();
    }
    
    public int getQty()
    {
        int k =0;
        for(ZadachaKomplektovkaRazmeri z: list)
            k = k + z.getQty();        
        return k;
    }
    
    
    /*
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
    final ImageIcon ok1 = new ImageIcon(getClass().getResource("/org/example/images/2.png"));
    final ImageIcon ok2 = new ImageIcon(getClass().getResource("/org/example/images/clos.png"));
    
    public DefaultTableCellRenderer jTableRenderer1 = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            JLabel cell = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (column == 1) {
            int v = Integer.parseInt(cell.getText());                
                    switch (v) {
                        case 0:
                            cell.setIcon(ok0);
                            cell.setText("");                            
                            break;
                        case 1:
                            cell.setIcon(ok1);
                            cell.setText("");
                            break;
                        case 2:
                            cell.setIcon(ok2);
                            cell.setText("");
                            break;
                        case 3:
                            cell.setIcon(ok2);
                            cell.setText("");
                            break;    
                    }
                }
            return cell;
        }

    };/**/
    
    
}
