/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Analit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.example.logic.Color;
import org.example.logic.Razmeri;
import org.example.util.HelpClass;

/**
 *
 * @author ivan
 */
public class ModelPrognoz extends AbstractTableModel{
     
    List<String> listCol = new ArrayList<>();
    List<List<String>> list = new ArrayList<>();    
    
   

    public ModelPrognoz() {        
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
        return list.get(rowIndex).get(columnIndex);
    }

    @Override
    public String getColumnName(int column) {
        if(column>1)
        {
            return "<html>" + listCol.get(column) + "</html>";
            //return "<html>" + listCol.get(column).replace("<>", <br>) split("<>")[0] + "<br>" + listCol.get(column).split("<>")[1] + "</html>";
        }
        return listCol.get(column);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex==getColumnCount()-2;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if(HelpClass.checkTextForInt((String)aValue))
        {
            int k = HelpClass.GetIntIzText((String)aValue);
            list.get(rowIndex).set(columnIndex, String.valueOf(k));
        }
        //super.setValueAt(aValue, rowIndex, columnIndex); //To change body of generated methods, choose Tools | Templates.
    }
      
    public void setData(List<String> ls)
    {
        list.clear();
        listCol.clear();
        String str[];
        String str1[];
        int i=0;
        List<String> lk;
        String ss;
        int col;
        int it;
        for(String s:ls)
        {
            //System.out.println(s);
            str = s.split("!");
            if(i==0)
            {
                listCol.addAll(Arrays.asList(str));                
            }
            else //строки с цветами
            {
                ss = s;
                //если это строка итога
                if(Integer.parseInt(str[6])==1)
                {                    
                    //for(int j=9;j<getColumnCount();j++)
                    //    ss = ss + "!0";
                    //найдем цвет
                    col = Integer.parseInt(str[2]);
                    //просмотрим все строки и посчитаем
                    for(int j=9;j<getColumnCount();j++)
                    {
                        it = 0;
                        for (String s1 : ls) 
                        {                            
                            str1 = s1.split("!");
                            if(str1[0].equals("Артикул"))
                                continue;
                            
                            //если это не строка итога
                            if(Integer.parseInt(str1[6])==0) 
                            {
                                //если это цвет тот же
                                if(Integer.parseInt(str1[2])==col)
                                {
                                    it = it + Integer.parseInt(str1[j]);
                                }
                            }
                        }
                        ss = ss + "!" + it;
                    }
                    //ss = ss + "!0!0!0" ;                    
                }
                if(Integer.parseInt(str[6])==3)
                {
                    it = Integer.parseInt(str[9]);
                    ss = "";
                    for(int k=0; k < 9;k++)
                        ss = ss + str[k] + "!";
                    
                    for(int j=9;j<getColumnCount()-1;j++)
                    {                        
                        ss = ss + "0!";
                    }
                    ss = ss + it;
                }
                
                str = ss.split("!");
                lk = new ArrayList<>();
                lk.addAll(Arrays.asList(str));
                list.add(lk);                
            }
            i++;
        } 
        if(ls.size()>1)
        {            
            ss = "Итого!0!0!0!0!0!2!0!0";
            for (int j = 9; j < getColumnCount(); j++) 
            {
                it = 0;
                for (String s1 : ls) 
                {
                    str1 = s1.split("!");
                    if (str1[0].equals("Артикул")) 
                        continue;
                    
                    //если это не строка итога
                    if (Integer.parseInt(str1[6]) == 0)                     
                        it = it + Integer.parseInt(str1[j]);
                    
                }
                ss = ss + "!" + it;
            }
            str = ss.split("!");
            lk = new ArrayList<>();
            lk.addAll(Arrays.asList(str));
            list.add(lk);                
        }
        fireTableDataChanged();
    }
    
    public void addLine(Color c, Razmeri r)
    {
        String ss = "Новая строка";
        if(list.size()>0)
        {
            ss = list.get(0).get(0);            
            ss = ss + "!" + list.get(0).get(1);            
        }
        ss = ss + "!0!0!" + c.getColor() + "!" + r.getRazmeri()+ "!0!" + c.getName( )+"!" + r.getName();
                
        for(int i=9;i<getColumnCount();i++)
            ss = ss + "!0";
        
        //System.out.println("0>" + list.get(0).size());
        //System.out.println("1>" + ss.split("!").length);
        
        list.add(Arrays.asList(ss.split("!")));
        fireTableDataChanged();
    }
}
