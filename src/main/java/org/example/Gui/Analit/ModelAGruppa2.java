/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Analit;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ivan
 */
public class ModelAGruppa2 extends AbstractTableModel{
    //List<aGetGruppa2> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();
    List<SalePeriod> list = new ArrayList<>();
    private int max_row = 0;

    public ModelAGruppa2() {
        /*listCol.add("art");        
        listCol.add("Артикул");  
        listCol.add("Название");
        listCol.add("Сумма");  
        listCol.add("Количество");          */
    }   
    
    @Override
    public int getRowCount() {
        return max_row;//list.size();
    }

    @Override
    public int getColumnCount() {
        return listCol.size();
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex>=3)
            return BigDecimal.class;
        return super.getColumnClass(columnIndex); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if((columnIndex+1)%2!=0)
        {
            if(list.get(columnIndex/2).getList().size()>rowIndex)
            {
                //System.out.println(list.get(columnIndex/2).getList().size());
                return list.get(columnIndex/2).getList().get(rowIndex).getArt();
            }
            else
                return 0;
        }
        else
        {
            
            if(list.get(columnIndex/2).getList().size()>rowIndex)
            {
                String ss = "<html>";
                if(list.get(columnIndex/2).getList().get(rowIndex).getPlans()>0)
                {          
                    //ss = "<html ><font style=background:green> ";
                    //ss = "<body bgcolor=green>";
                    ss = ss + list.get(columnIndex/2).getList().get(rowIndex).getArticle() + "<br>";
                    ss = ss + list.get(columnIndex/2).getList().get(rowIndex).getSprice().setScale(0, RoundingMode.HALF_UP) + " - ";
                    ss = ss + list.get(columnIndex/2).getList().get(rowIndex).getQty().setScale(0, RoundingMode.HALF_UP) + " <br> ";
                    ss = ss + list.get(columnIndex/2).getList().get(rowIndex).getNost();
                    ss = ss +  " -> " + list.get(columnIndex/2).getList().get(rowIndex).getPlans()+ "</html>";
                }
                else
                {
                    //ss = "<html>";
                    ss = ss + list.get(columnIndex/2).getList().get(rowIndex).getArticle() + "<br>";
                    ss = ss + list.get(columnIndex/2).getList().get(rowIndex).getSprice().setScale(0, RoundingMode.HALF_UP) + " - ";
                    ss = ss + list.get(columnIndex/2).getList().get(rowIndex).getQty().setScale(0, RoundingMode.HALF_UP) + " <br> ";                
                    ss = ss + list.get(columnIndex/2).getList().get(rowIndex).getNost();
                    ss = ss + "</html>";
                }
                return ss;
            }
            else
                return null;
        }
       
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    
    public void setData(List<SalePeriod> ls)
    {
        list = ls;
        SimpleDateFormat sf = new SimpleDateFormat("yyyy.MM.dd");
        for(SalePeriod s: list)
        {
            listCol.add("id"); 
            listCol.add("<html>"+sf.format(s.getD1()) + "<br>"+sf.format(s.getD2())+"</html>");
            if(s.getList().size()>max_row)
                max_row = s.getList().size();
            //System.out.println(sf.format(s.getD1()) + "\n"+sf.format(s.getD2()));
        }
        //list = IOAnalitika.getGruppa2(g1, g2, d1, d2);
        fireTableDataChanged();
    }
    
    
    /* private final DefaultTableCellRenderer jTableRendererColor4 = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            JLabel cell = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            
            if(!isSelected)
            {
                //cell.setForeground(model.lsColor.get(4));                
                cell.setOpaque(true);
                cell.setBackground(model.lsColor.get(4));                
                cell.setHorizontalAlignment(JLabel.CENTER);
                                
                if(Integer.parseInt((String)table.getValueAt(row, 6))==1)
                    cell.setFont(new java.awt.Font("Tahoma", 1, 14)); 
            }
            
            return cell;
        }

    };*/
    
}
