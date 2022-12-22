/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Analit;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.example.logic.GetProductAnalizNovinka;
import org.example.util.analit.IOAnalitika;

/**
 *
 * @author ivan
 */
public class ModelAnalitikaNovinka extends AbstractTableModel{
    
    List<String> listCol = new ArrayList<>();
    List<GetProductAnalizNovinka> list = new ArrayList<>();
    //String listArticle;
    /*int maxRow;
    
    public int getMaxRow()
    {
        //System.out.println("maxRow = " + maxRow);
        return maxRow;
    }*/
    

    public ModelAnalitikaNovinka() { 
        //maxRow = 0;
        listCol.add("MODEL");           //0 
        listCol.add("Артикул");         //1 
        listCol.add("Тип полотна");     //2 
        listCol.add("Цена");            //3
        listCol.add("Сумма");           //4 
        listCol.add("Кол-во");          //5 
        listCol.add("Принт");           //6 
        listCol.add("Вышивка");         //7 
        listCol.add("Фурнитура");       //8 
        listCol.add("Доп. Характер.");  //9         
        listCol.add("S");  //10         
        listCol.add("H");  //11         
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
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex == 4)
            return Integer.class;
        return super.getColumnClass(columnIndex); //To change body of generated methods, choose Tools | Templates.
    }
   
    
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
                
        switch(columnIndex)
        {
            case 0: 
                return list.get(rowIndex).getModel();
            case 1: 
                return list.get(rowIndex).getArticle();
            case 2: 
                return list.get(rowIndex).getTipprod();
            case 3: 
                if(list.get(rowIndex).getMinprice().compareTo(list.get(rowIndex).getMaxprice())==0)
                    return list.get(rowIndex).getMinprice().setScale(0, RoundingMode.HALF_UP);                
                return list.get(rowIndex).getMinprice().setScale(0, RoundingMode.HALF_UP) + "/" + list.get(rowIndex).getMaxprice().setScale(0, RoundingMode.HALF_UP);
            case 4: 
                return list.get(rowIndex).getSumma().setScale(0, RoundingMode.HALF_UP).intValue();
            case 5: 
                return list.get(rowIndex).getQty().setScale(0, RoundingMode.HALF_UP).intValue();
            case 6: 
                return "<html>" +  list.get(rowIndex).getLprint().replace("<!>", "<br>") + "</html>";
            case 7: 
                return "<html>" +  list.get(rowIndex).getLvishivka().replace("<!>", "<br>") + "</html>";
            case 8: 
                return "<html>" +  list.get(rowIndex).getLfurnit().replace("<!>", "<br>") + "</html>";
            case 9: 
                return "<html>" +  list.get(rowIndex).getLdoppar().replace("<!>", "<br>") + "</html>";
            case 10: 
                return list.get(rowIndex).getIsselect();
            case 11: 
                return list.get(rowIndex).getHint();    
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {        
        return listCol.get(column);
    }
    
    
    public void setData(int g1, int g2, Date d1, Date d2)
    {
        list.clear();            
        list = IOAnalitika.getProductAnalizNovinka(g1, g2, d1, d2);
        //list.get(1).setIsselect(1);        
        parameterSelect pp;
        boolean flag;
        int kline, klinet;
        for(GetProductAnalizNovinka g: list)
        {
            kline = 1;
            flag = false;
            
            klinet = g.getLprint().split("<!>").length;
            kline = kline < klinet?klinet:kline;
            
            klinet = g.getLfurnit().split("<!>").length;
            kline = kline < klinet?klinet:kline;
            
            klinet = g.getLdoppar().split("<!>").length;
            kline = kline < klinet?klinet:kline;
            
            klinet = g.getLvishivka().split("<!>").length;
            kline = kline < klinet?klinet:kline;
            
            g.setHint(kline);

            //System.out.println(">>" + width_h);            
            
            for(String s: g.getLprint().split("<!>"))
            {                
                if(s.trim().isEmpty())
                    continue;
                
                //klinet = g.getLprint().split("<!>").length;
                //kline = kline < klinet?klinet:kline;
                
                for(parameterSelect p: listPrint)
                    if(s.endsWith(p.getName()))
                    {
                        flag = true;
                        break;
                    }
                if(!flag)
                {
                    pp = new parameterSelect();
                    pp.setName(s);
                    pp.setParameter(listPrint.size()+1);
                    pp.setSelect(0);
                    listPrint.add(pp);
                }
            }
            
            flag = false;
            for(String s: g.getLfurnit().split("<!>"))
            {
                //System.out.println(">>" + s);
                if(s.trim().isEmpty())
                    continue;
                //klinet = s.length() / width_h;
                //kline = kline < klinet?klinet:kline;
                for(parameterSelect p: listFurnitura)
                    if(s.endsWith(p.getName()))
                    {
                        flag = true;
                        break;
                    }
                if(!flag)
                {
                    pp = new parameterSelect();
                    pp.setName(s);
                    pp.setParameter(listFurnitura.size()+1);
                    pp.setSelect(0);
                    listFurnitura.add(pp);
                }
            }
            
            flag = false;
            for(String s: g.getLdoppar().split("<!>"))
            {
                //System.out.println(">>" + s);
                if(s.trim().isEmpty())
                    continue;
                for(parameterSelect p: listDopPar)
                    if(s.endsWith(p.getName()))
                    {
                        flag = true;
                        break;
                    }
                if(!flag)
                {
                    pp = new parameterSelect();
                    pp.setName(s);
                    pp.setParameter(listDopPar.size()+1);
                    pp.setSelect(0);
                    listDopPar.add(pp);
                }
            }
            
            flag = false;
            for(String s: g.getLvishivka().split("<!>"))
            {
                //System.out.println(">>" + s);
                if(s.trim().isEmpty())
                    continue;
                for(parameterSelect p: listVishivka)
                    if(s.endsWith(p.getName()))
                    {
                        flag = true;
                        break;
                    }
                if(!flag)
                {
                    pp = new parameterSelect();
                    pp.setName(s);
                    pp.setParameter(listVishivka.size()+1);
                    pp.setSelect(0);
                    listVishivka.add(pp);
                }
            }
            
            flag = false;            
            for(parameterSelect p: listProduct)
            {
                if(g.getTipprod().endsWith(p.getName()))
                {
                    flag = true;
                    break;
                }
            }
            if (!flag) 
            {
                pp = new parameterSelect();
                pp.setName(g.getTipprod());
                pp.setParameter(listProduct.size() + 1);
                pp.setSelect(0);
                listProduct.add(pp);
            }
            
            
            
           
          
        }        
        fireTableDataChanged();
    }
    
    public List<parameterSelect> listPrint = new ArrayList<>();
    public List<parameterSelect> listVishivka = new ArrayList<>();
    public List<parameterSelect> listDopPar = new ArrayList<>();
    public List<parameterSelect> listFurnitura = new ArrayList<>();
    public List<parameterSelect> listProduct = new ArrayList<>();
    
   
    public void reselectData()
    {
        for(GetProductAnalizNovinka g: list)
        {
            g.setIsselect(0);
            for(String s: g.getLfurnit().split("<!>"))
            {
                for(parameterSelect p: listFurnitura)
                {
                    if(p.getSelect()==1)
                    {
                        if(p.getName().equals(s))
                            g.setIsselect(1);
                    }
                }
            }
            
            for(String s: g.getLdoppar().split("<!>"))
            {
                for(parameterSelect p: listDopPar)
                {
                    if(p.getSelect()==1)
                    {
                        if(p.getName().equals(s))
                            g.setIsselect(1);
                    }
                }
            }
            
            for(String s: g.getLprint().split("<!>"))
            {
                for(parameterSelect p: listPrint)
                {
                    if(p.getSelect()==1)
                    {
                        if(p.getName().equals(s))
                            g.setIsselect(1);
                    }
                }
            }
            
            for(String s: g.getLvishivka().split("<!>"))
            {
                for(parameterSelect p: listVishivka)
                {
                    if(p.getSelect()==1)
                    {
                        if(p.getName().equals(s))
                            g.setIsselect(1);
                    }
                }
            }
            
            for (parameterSelect p : listProduct) 
            {
                if (p.getSelect() == 1) 
                {
                    if (p.getName().equals(g.getTipprod())) 
                    {
                        g.setIsselect(1);
                    }
                }
            }
        }
        fireTableDataChanged();
    }
    
}
