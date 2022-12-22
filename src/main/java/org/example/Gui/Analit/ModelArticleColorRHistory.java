/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Analit;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.example.logic.analit.aAgent;
import org.example.logic.analit.aArticle;
import org.example.logic.analit.aColor;
import org.example.logic.analit.aJournal;
import org.example.logic.analit.aOperation;
import org.example.logic.analit.aSclad;
import org.example.util.HelpClass;
import org.example.util.analit.IOAnalitika;

/**
 *
 * @author ivan
 */
public class ModelArticleColorRHistory  extends AbstractTableModel{
    
    List<String> listCol = new ArrayList<>();
    List<aJournal> list = new ArrayList<>();
    

    public ModelArticleColorRHistory() {        
        listCol.add("ID");        
        listCol.add("Дата");
        listCol.add("Кол-во");
        listCol.add("Цена");        
        listCol.add("Операция");
        listCol.add("Склад");
        listCol.add("Остаток");
        listCol.add("Агент");
        
        
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
                return list.get(rowIndex).getA_journal();            
            case 1: 
                return HelpClass.getPrintDate1(list.get(rowIndex).getDates());            
            case 2: 
                return list.get(rowIndex).getQty().setScale(0, RoundingMode.HALF_UP);
            case 3: 
                return list.get(rowIndex).getPrice().setScale(2, RoundingMode.HALF_UP);            
            case 4: 
                return list.get(rowIndex).getOperations().getName();
            case 5: 
                return list.get(rowIndex).getSclad().getName();                
            case 6: 
                return list.get(rowIndex).getQty_ost().setScale(0, RoundingMode.HALF_UP);
            case 7: 
                return list.get(rowIndex).getAgent().getName();// + "!" + list.get(rowIndex).getA_journal();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {        
        return listCol.get(column);
    }
    
    
    public void setData(int article, int color, int razmer, Date d1, Date d2)
    {
        //System.out.println("d1 = " +d1);
        //System.out.println("d2 = " +d2);
        list = IOAnalitika.getAJournalForColorAndRazmer(article, color, razmer, d1, d2);               
        
        aJournal j = new aJournal();
        j.setA_journal(0);
        j.setAarticle(new aArticle(article));
        j.setAcolor(new aColor(color));
        j.setDates(d1);
        j.setQty(IOAnalitika.getQtyForModelColorRazmer(article, color, razmer, d1));
        j.setQty_ost(j.getQty());
        j.setPrice(BigDecimal.ZERO);
        aOperation o = new aOperation();
        o.setA_operation(0);
        o.setInk(0);
        o.setName("Начальный остаток");
        j.setOperations(o);
        
        aSclad a = new aSclad();
        a.setA_sclad(0);
        a.setName("");
        a.setUid("");   
        
        aAgent aa = new aAgent(0);
        aa.setA_agent(0);
        aa.setName("");
        
        j.setAgent(aa);
        
        j.setSclad(a);
        
        
        BigDecimal q = j.getQty();
        for(aJournal l: list)
        {
            q = q.add(l.getQty());
            l.setQty_ost(q);
        }        
        
        list.add(0,j);        
        
        fireTableDataChanged();
    }
    
    public void setData1(int article, int color, int razmer, Date d1, Date d2)
    {
        //System.out.println("d1 = " +d1);
        //System.out.println("d2 = " +d2);
        list = IOAnalitika.getAJournalForColorAndRazmer1(article, color, razmer, d1, d2);               
        
        aJournal j = new aJournal();
        j.setA_journal(0);
        j.setAarticle(new aArticle(article));
        j.setAcolor(new aColor(color));
        j.setDates(d2);
        j.setQty(IOAnalitika.getQtyForModelColorRazmer(article, color, razmer, d1));
        j.setQty_ost(j.getQty());
        j.setPrice(BigDecimal.ZERO);
        aOperation o = new aOperation();
        o.setA_operation(0);
        o.setInk(0);
        o.setName("Начальный остаток");
        j.setOperations(o);
        
        aSclad a = new aSclad();
        a.setA_sclad(0);
        a.setName("");
        a.setUid("");        
        j.setSclad(a);
        
        aAgent aa = new aAgent(0);
        aa.setA_agent(0);
        aa.setName("");
        
        j.setAgent(aa);
        
        
        BigDecimal q = j.getQty();
        for(aJournal l: list)
        {
            q = q.add(l.getQty());
            l.setQty_ost(q);
        }        
        
        list.add(0,j);        
        
        fireTableDataChanged();
    }
    
}
