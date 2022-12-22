/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Analit;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.example.logic.Color;

import org.example.logic.Razmeri;
import org.example.logic.plan.PModelPlanHauptJournal;
import org.example.logic.plan.PModelPlanRazmeri;
import org.example.util.HelpClass;
import org.example.util.analit.IOPrognoz;
import org.example.util.plan.IOModelPlan;
import org.example.util.plan.IOPModelPlanHaupt;

/**
 *
 * @author ivan
 */
public class ModelPrognoz1 extends AbstractTableModel{
     
    List<String> listCol = new ArrayList<>();
    List<List<String>> list = new ArrayList<>();    
    
    public int kol_prognoz = 0;
    public List<datePrognoz> listDatePrognoz = new ArrayList<>();
    public int max_kol = 0;
    public List<java.awt.Color> lsColor = new ArrayList<>();
    int h;

    public ModelPrognoz1() {      
        lsColor.add(java.awt.Color.RED);
        lsColor.add(java.awt.Color.CYAN);
        lsColor.add(new java.awt.Color(51,131,255));
        lsColor.add(java.awt.Color.GREEN);
        lsColor.add(java.awt.Color.MAGENTA);
        lsColor.add(java.awt.Color.ORANGE);        
        lsColor.add(java.awt.Color.PINK);
        lsColor.add(java.awt.Color.YELLOW);
        lsColor.add(new java.awt.Color(60,255,51));
        lsColor.add(new java.awt.Color(51,172,255));
        /*for(int i=0;i<40;i++)
            listCol.add("№"+i);
        
        
        for(int i=0;i<100;i++)
           list.add(null);*/
    }   
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        //System.out.println("org.example.Gui.Analit.ModelPrognoz1.getColumnCount() = " + listCol.size());
        return listCol.size();
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return list.get(rowIndex).get(columnIndex);
        
        //return "suidfisugfy5843";
    }

    @Override
    public String getColumnName(int column) {
        if(column>1)
        {
            return "<html>" + listCol.get(column) + "</html>";
        
        }
        return listCol.get(column);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) 
    {
        
        if(kol_prognoz==0)
            return columnIndex==getColumnCount()-1;
        else
        {
            //если столбез больше или равен где вносим план на год
            if(columnIndex==(getColumnCount()-1))
            {
                return true;                
            }               
            else
            {           
                if(columnIndex>=max_kol-1)
                    if(columnIndex<=getColumnCount()-3)
                    {
                        if((columnIndex-max_kol-1)%2==0)
                        {
                            h = columnIndex;
                            h = -(max_kol-2-h);
                            h = h - h%2;
                            h = h/2;
                            return listDatePrognoz.get(h).isRead;
                        }                        
                        //return (columnIndex-max_kol-1)%2==0;
                    }
            }    
            return false;                
                 
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if(HelpClass.checkTextForInt((String)aValue))
        {
            int k = HelpClass.GetIntIzText((String)aValue);
            list.get(rowIndex).set(columnIndex, String.valueOf(k));
        }        
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
                /*int r = 0;
                for(String s2: listCol)
                {
                    System.out.println(r + " - " + s2);
                    r++;
                }*/
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
                    
                    for(int j=9;j<getColumnCount();j++)
                    {                        
                        if(j==getColumnCount()-4)
                            ss = ss + it + "!";
                        else
                            ss = ss + "0!";
                    }
                    
                    //ss = ss + it;
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
        fireTableStructureChanged();
        max_kol = list.get(0).size();
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
        
        //list.add(Arrays.asList(ss.split("!")));
        
        list.add(new ArrayList<>(Arrays.asList(ss.split("!"))));
        //new ArrayList<>(Arrays.asList(split))
        
        fireTableDataChanged();
    }
    
    /**
     * 
     * @param mod
     * @param d1 - дата закупок
     * @param d2 - дата производства
     * @param d3 - дата начала продаж
     * @param d6 - дата окончания продаж
     * @param d4 - дата начала анализа
     * @param d5 - дата окончания анализа
     */
    public void addNewPrognoz(int mod, Date d1, Date d2, Date d3, Date d6, Date d4, Date d5)
    {
        datePrognoz dp = new datePrognoz();
        dp.setId(kol_prognoz+1);
        dp.setD1(d1);
        dp.setD2(d2);
        dp.setD3(d3);
        dp.setD6(d6);
        dp.setD4(d4);
        dp.setD5(d5);
        dp.setIsRead(true);
        int pModel;
        int pColor;
        int pRazmeri;
        
        listDatePrognoz.add(dp);
        
        //System.out.println(list.get(0).size());
        String sd = listCol.get(listCol.size()-2);
        String sd1 = listCol.get(listCol.size()-1);
        //listCol.set(listCol.size()-2, "<font color=#"+ lsColor.get(kol_prognoz).getRGB() +"> Расчет <br> "+HelpClass.getPrintDate(d1)+"</font>");        
        listCol.set(listCol.size()-2, "План <br> "+HelpClass.getPrintDate(d3) + "<br> "+HelpClass.getPrintDate(d6));        
        listCol.set(listCol.size()-1, "Факт <br> "+HelpClass.getPrintDate(d3) + "<br> "+HelpClass.getPrintDate(d6));        
        listCol.add(sd);
        listCol.add(sd1);
        //String 
        int i=0;
        int qt;
        for(List<String> l: list)
        {
            sd = l.get(l.size()-2);
            sd1 = l.get(l.size()-1);
            
            pModel = Integer.parseInt(l.get(1));
            pColor = Integer.parseInt(l.get(2));
            pRazmeri  = Integer.parseInt(l.get(3));
            //если это первая строка
            /*if(kol_prognoz==0)
            {
                
            }*/
            //если это строка итого
            if(HelpClass.GetIntIzText(l.get(6))!=0)
            {
                l.set(l.size()-2, "0");
                l.set(l.size()-1, "0");
                l.add(sd);
                l.add(sd1);                
            }                
            else
            {
                qt = IOPrognoz.getQtySale(pModel, pColor, pRazmeri, d4, d5);
                if(kol_prognoz==0)
                {
                    qt = qt - Integer.parseInt(l.get(max_kol-5))- Integer.parseInt(l.get(max_kol-4)) - Integer.parseInt(l.get(max_kol-3));
                    /*System.out.println(">> " + l.get(8));
                    System.out.println("-4> " + l.get(max_kol-4));
                    System.out.println("-3> " + l.get(max_kol-3));*/
                }
                l.set(l.size()-1, "0");
                l.set(l.size()-2, "" + qt);
                //l.set(l.size()-2, "0");
                
                //System.out.println("!>" + l.size());
                
                
                l.add(sd);
                l.add(sd1);                
            }   
            list.set(i, l);
            i++;
        }
        kol_prognoz++;
        //System.out.println(list.get(0).size());
        
        
        fireTableDataChanged();
        
        fireTableStructureChanged();
        
    }
    
    
    /**
     * 
     * @param mod
     * @param d1 - дата закупок
     * @param d2 - дата производства
     * @param d3 - дата начала продаж
     * @param d6 - дата окончания продаж
     * @param d4 - дата начала анализа
     * @param d5 - дата окончания анализа
     * @param pm
     * @param color
     * @param isRead
     */
    public void addNewPrognoz1(int mod, Date d1, Date d2, Date d3, Date d6, Date d4, Date d5, int pm, int color, boolean isRead)
    {
        //System.out.println("COLOR1" + color);
        List<List<String>> ld = new ArrayList<>();        
        
        for(List<String> l: list)
        {
            if(Integer.parseInt(l.get(4))!=color)
            {
                ld.add(l);
            }
        }
        
        for(List<String> l: ld)
            list.remove(l);
        
        
        if(list.isEmpty())
        {
            fireTableDataChanged();        
            fireTableStructureChanged();
            return;
        }
            
        datePrognoz dp = new datePrognoz();
        dp.setId(kol_prognoz+1);
        dp.setD1(d1);
        dp.setD2(d2);
        dp.setD3(d3);
        dp.setD6(d6);
        dp.setD4(d4);
        dp.setD5(d5);
        dp.setPmodel(pm);
        dp.setIsRead(isRead);
        int pModel;
        int pColor;
        int pRazmeri;
        
        listDatePrognoz.add(dp);
        
        //System.out.println(list.get(0).size());
        String sd = listCol.get(listCol.size()-2);
        String sd1 = listCol.get(listCol.size()-1);
        //listCol.set(listCol.size()-2, "<font color=#"+ lsColor.get(kol_prognoz).getRGB() +"> Расчет <br> "+HelpClass.getPrintDate(d1)+"</font>");        
        listCol.set(listCol.size()-2, "План <br> "+HelpClass.getPrintDate(d3) + "<br> "+HelpClass.getPrintDate(d6));        
        listCol.set(listCol.size()-1, "Факт <br> "+HelpClass.getPrintDate(d3) + "<br> "+HelpClass.getPrintDate(d6));        
        listCol.add(sd);
        listCol.add(sd1);
        //String 
        int i=0;
        int qt;
        for(List<String> l: list)
        {
            sd = l.get(l.size()-2);
            sd1 = l.get(l.size()-1);
            
            pModel = Integer.parseInt(l.get(1));
            pColor = Integer.parseInt(l.get(2));
            pRazmeri  = Integer.parseInt(l.get(3));
            //если это первая строка
            /*if(kol_prognoz==0)
            {
                
            }*/
            //если это строка итого
            if(HelpClass.GetIntIzText(l.get(6))!=0)
            {
                l.set(l.size()-2, "0");
                l.set(l.size()-1, "0");
                l.add(sd);
                l.add(sd1);                
            }                
            else
            {
                qt = IOPrognoz.getQtySale(pModel, pColor, pRazmeri, d4, d5);
                if(kol_prognoz==0)
                    qt = qt - Integer.parseInt(l.get(max_kol-5))- Integer.parseInt(l.get(max_kol-4)) - Integer.parseInt(l.get(max_kol-3));
                    //qt = qt - Integer.parseInt(l.get(max_kol-4)) - Integer.parseInt(l.get(max_kol-3));
                l.set(l.size()-1, "0");
                l.set(l.size()-2, "" + qt);
                //l.set(l.size()-2, "0");
                
                //System.out.println("!>" + l.size());
                
                
                l.add(sd);
                l.add(sd1);                
            }   
            list.set(i, l);
            i++;
        }
        kol_prognoz++;
        //System.out.println(list.get(0).size());
        
        
        for(PModelPlanRazmeri pr: IOModelPlan.getListPModelPlanRazmeriForPlan(pm))
        {
            if(pr.getQty()>0)
            {           
                i = 0;
                for(List<String> l: list)
                {
                    //если размер совпадает
                    if(Integer.parseInt(l.get(5))==pr.getRazmeri().getRazmeri())
                    {
                        l.set(l.size()-3, pr.getQty().toString());
                        if (i > 0) 
                        {
                            //если цвет совпадает
                            //if (Integer.parseInt(list.get(i).get(4)) == Integer.parseInt(list.get(i - 1).get(4))) {
                                //если размеры совпадают
                                if (Integer.parseInt(list.get(i).get(5)) == Integer.parseInt(list.get(i - 1).get(5))) 
                                    l.set(l.size() - 3, "0");
                                
                            //}
                        }
                    }
                    i++;
                }
            }
        }
        
        
        
        
        fireTableDataChanged();
        
        fireTableStructureChanged();
        
    }
    
    /**
     * загрузить прогнозы
     * @param pmh
     */
    public void loadPrognoz(int pmh)
    {
        //System.out.println("COLOR1" + color);
        //List<List<String>> ld = new ArrayList<>();        
        
        datePrognoz dp;
        int pModel;
        int pColor;
        int pRazmeri;
        String sd;
        String sd1;
        int i;
        int qt;
        for(PModelPlanHauptJournal j: IOPModelPlanHaupt.getListPModelPlanHauptJournals(pmh))
        {
            i=0;
            dp = new datePrognoz();
            dp.setId(kol_prognoz+1);
            dp.setD1(j.getPmodelplan().getDates1());
            dp.setD2(j.getPmodelplan().getDates());
            dp.setD3(j.getPmodelplan().getDates5());
            dp.setD4(j.getPmodelplan().getDates7());
            dp.setD5(j.getPmodelplan().getDates8());
            dp.setD6(j.getPmodelplan().getDates6());
            
            dp.setPmodel(j.getPmodelplan().getPmodelplan());
            dp.setIsRead(!(j.getPmodelplan().getStatus()>1));

            listDatePrognoz.add(dp);
            
            sd = listCol.get(listCol.size()-2);
            sd1 = listCol.get(listCol.size()-1);
            listCol.set(listCol.size()-2, "План <br> "+HelpClass.getPrintDate(dp.getD3()) + "<br> "+HelpClass.getPrintDate(dp.getD6()));        
            listCol.set(listCol.size()-1, "Факт <br> "+HelpClass.getPrintDate(dp.getD3()) + "<br> "+HelpClass.getPrintDate(dp.getD6()));        
            
            listCol.add(sd);
            listCol.add(sd1);
            
            
            for(List<String> l: list)
            {
                sd = l.get(l.size()-2);
                sd1 = l.get(l.size()-1);
            
                pModel = Integer.parseInt(l.get(1));
                pColor = Integer.parseInt(l.get(2));
                pRazmeri  = Integer.parseInt(l.get(3));
           
                //если это строка итого
                if(HelpClass.GetIntIzText(l.get(6))!=0)
                {
                    l.set(l.size() - 2, "0");
                    l.set(l.size() - 1, "0");
                    l.add(sd);
                    l.add(sd1);
                } else 
                {
                    qt = IOPrognoz.getQtySale(pModel, pColor, pRazmeri, dp.getD4(), dp.getD5());
                    if (kol_prognoz == 0) 
                        qt = qt - Integer.parseInt(l.get(max_kol-5))- Integer.parseInt(l.get(max_kol-4)) - Integer.parseInt(l.get(max_kol-3));
                        //qt = qt - Integer.parseInt(l.get(max_kol - 4)) - Integer.parseInt(l.get(max_kol - 3));
                    
                    l.set(l.size() - 1, "0");
                    l.set(l.size() - 2, "" + qt);
                    
                    l.add(sd);
                    l.add(sd1);                    
                }
                //если это не первая строка
                /*if(i>0)
                {
                    //если цвет совпадает
                    if(Integer.parseInt(list.get(i).get(4))==Integer.parseInt(list.get(i-1).get(4)))
                    {
                        //если размеры совпадают
                        if(Integer.parseInt(list.get(i).get(5))==Integer.parseInt(list.get(i-1).get(5)))
                        {
                            l.set(l.size()-3, "9999");
                        }                        
                    }
                }*/
                list.set(i, l);
                i++;
            }
            kol_prognoz++;
        
        
        
            
            for (PModelPlanRazmeri pr : IOModelPlan.getListPModelPlanRazmeriForPlan(j.getPmodelplan().getPmodelplan())) 
            {
                if (pr.getQty() > 0) 
                {
                    i = 0;
                    for (List<String> l : list) 
                    {
                        // если совпадает цвет
                        if (Integer.parseInt(l.get(4)) == pr.getPmodelplan().getColor().getColor())
                        {
                            //если размер совпадает
                            if (Integer.parseInt(l.get(5)) == pr.getRazmeri().getRazmeri()) 
                            {
                                l.set(l.size() - 3, pr.getQty().toString());                        
                                if(i>0)
                                {
                                    //если цвет совпадает
                                    if (Integer.parseInt(list.get(i).get(4)) == Integer.parseInt(list.get(i - 1).get(4))) 
                                    {
                                        //если размеры совпадают
                                        if (Integer.parseInt(list.get(i).get(5)) == Integer.parseInt(list.get(i - 1).get(5))) 
                                        {
                                            l.set(l.size() - 3, "0");
                                        }
                                    }
                                }
                                    
                                
                            }
                        }
                        i++;
                    }
                }
            }
            
            
        }
        
        fireTableDataChanged();
        
        fireTableStructureChanged();
        /**/
    }
    
    public void repriceCol(int col, Date d1, Date d2)
    {
        int pModel;
        int pColor;
        int pRazmeri;
        int qt;
        int i=0;
        for (List<String> l : list) 
        {
            pModel = Integer.parseInt(l.get(1));
            pColor = Integer.parseInt(l.get(2));
            pRazmeri = Integer.parseInt(l.get(3));

            //если это строка итого
            if (HelpClass.GetIntIzText(l.get(6)) == 0) 
            {
                qt = IOPrognoz.getQtySale(pModel, pColor, pRazmeri, d1, d2);                
                if(col==0)
                    qt = qt - Integer.parseInt(l.get(max_kol-5))- Integer.parseInt(l.get(max_kol-4)) - Integer.parseInt(l.get(max_kol-3));
                l.set((max_kol-2)+col*2 , "" + qt);                            
            }
            list.set(i, l);
            i++;
        }
        fireTableDataChanged();
    }
}
