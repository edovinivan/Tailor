/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.example.logic.MModelComment;
import org.example.util.HelpClass;
import org.example.util.IOMProperty;

/**
 *
 * @author ivan
 */
public class ModelMModelComment  extends AbstractTableModel{
    List<MModelComment> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();

    
    public ModelMModelComment() {
        listCol.add("#");
        listCol.add("№");
        listCol.add("Дата");        
        listCol.add("Артикул");
        listCol.add("Комментарий");        
        listCol.add("Ответ");                
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
                return list.get(rowIndex).getMmodelcomment();
            case 1: 
                return rowIndex + 1;
            case 2: 
                return HelpClass.getPrintDate3(list.get(rowIndex).getDates());
            case 3: 
                return list.get(rowIndex).getModel().getArticle();        
            case 4: 
                return list.get(rowIndex).getTexts();
            case 5: 
                return list.get(rowIndex).getAnsver();    
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    public void setData(int m)
    {
        if(m==0)
            list = IOMProperty.getListMModelCommentForAll();
        else
            list = IOMProperty.getListMModelCommentForModel(m);
        fireTableDataChanged();
    }
    
}
