/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Plan.PlanArticle.Model;

import org.example.Gui.Plan.PlanArticle.ArticleLoad;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.swing.table.AbstractTableModel;
import org.example.logic.Color;
import org.example.logic.Model;

/**
 *
 * @author ivan
 */
public class ModelExecuteLoadFile extends AbstractTableModel{

    public ModelExecuteLoadFile() {
        cols.add("id");
        cols.add("Ch");
        cols.add("Группа");
        cols.add("Артикул");
        cols.add("Цвет");
        cols.add("Размер");
        cols.add("TАртикул");
        cols.add("TЦвет");
        cols.add("ТРазмер");
        cols.add("Продажи");
        cols.add("Остатки");
        cols.add("В работе");
        cols.add("status");
        cols.add("model_id");
 
        
    }
    
    private List<ArticleLoad> listal = new ArrayList<>();
    private List<String> cols = new ArrayList<>();
    
    public List<ArticleLoad> getListArticleLoad(){
        return listal;
    }

    @Override
    public int getRowCount() {
        return listal.size();
    }

    @Override
    public int getColumnCount() {
        return cols.size();
    }

    @Override
    public String getColumnName(int column) {
        return cols.get(column);
    }   
    
    
  

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return listal.get(rowIndex).getId();
            case 1:
                return listal.get(rowIndex).getCheck()==1;
            case 2:
                return listal.get(rowIndex).getTip();
            case 3:
                return listal.get(rowIndex).getArticle();
            case 4:
                return listal.get(rowIndex).getColor();
            case 5:
                return listal.get(rowIndex).getSizes_1c();    
            case 6:
                return listal.get(rowIndex).getModel_article();
            case 7:
                return listal.get(rowIndex).getColor_name();
            case 8:
                return listal.get(rowIndex).getSizes_t();    
            case 9:
                return listal.get(rowIndex).getSale();
            case 10:
                return listal.get(rowIndex).getBalance();    
            case 11:
                return listal.get(rowIndex).getIn_work();
            case 12:
                return listal.get(rowIndex).getStatus();
            case 13:
                return listal.get(rowIndex).getModel_id();
            
            default:
                return null;
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex==1)
            return Boolean.class;
        if(columnIndex==9 || columnIndex==10 || columnIndex==11)
            return Integer.class;
        return super.getColumnClass(columnIndex); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if(columnIndex==1)
            return true;
        return super.isCellEditable(rowIndex, columnIndex); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if(columnIndex==1){
            listal.get(rowIndex).setCheck(((Boolean)aValue)?1:0);
        }
        super.setValueAt(aValue, rowIndex, columnIndex); //To change body of generated methods, choose Tools | Templates.
    } 
    
    public void setDate(List<ArticleLoad> ls){
        listal = ls;
        fireTableDataChanged();
    }
    
    
    public void setDataBalanc(List<ArticleLoad> ls){
        Map<String, Integer> mbalance = ls.stream()
                .collect(Collectors.toMap((t)->t.getArticle()+"-"+t.getColor()+"-"+t.getSizes_1c() , ArticleLoad::getBalance, ((t1,t2)->t1)));
        listal.forEach((t)->{
            if(mbalance.containsKey(t.getArticle()+"-"+t.getColor()+"-"+t.getSizes_1c())){
                t.setBalance(mbalance.get(t.getArticle()+"-"+t.getColor()+"-"+t.getSizes_1c()));
            }
        });
        fireTableDataChanged();
    }
    
    /**
     * Изменить цвет привязки
     * @param id - ид строки
     * @param color - номер цвета в БД
     * @param name - название цвета
     */
    public void updateColor(int id, int color, String name){        
        String article_seach = listal.stream()
                .filter((t)->{
                    return t.getId()==id;
                })
                .collect(Collectors.toList()).get(0).getColor();
        
        
        listal.stream()
                .filter((t)->{
                    return t.getColor().equals(article_seach);
                })
                .forEach(t->{
                    t.setColor_id(color);
                    t.setColor_name(name);
                    if(t.getModel_id()!=0 && t.getSizes_tid()!=0){
                        t.setCheck(1);
                        t.setStatus(1);
                    }
                });
        fireTableDataChanged();
    }
    
    
    public void updateColor(int id, Color color){        
        listal.stream()
                .filter((t)->{
                    return t.getId()==id;
                })
                .forEach(t->{
                    t.setColor_id(color.getColor());
                    t.setColor_name(color.getName());
                    if(t.getModel_id()!=0 && t.getSizes_tid()!=0){
                        t.setCheck(1);
                        t.setStatus(1);
                    }
                });
        fireTableDataChanged();
    }
    
    
    /**
     * Изменить артикул
     * @param id - номер
     * @param article - артикул
     * @param name - название
     */
    public void updateArticle(int id, int article, String name){
        String article_seach = listal.stream()
                .filter((t)->{
                    return t.getId()==id;
                })
                .collect(Collectors.toList()).get(0).getArticle();
                
                
        listal.stream()
                .filter((t)->{
                    return t.getArticle().equals(article_seach);
                })
                .forEach(t->{
                    t.setModel_id(article);
                    t.setModel_article(name);
                    if(t.getColor_id()!=0 && t.getSizes_tid()!=0 && t.getSizes_tid() != 0){
                        t.setCheck(1);
                        t.setStatus(1);
                    }
                });
        fireTableDataChanged();
    }
    
    /**
     * Изменить артикул
     * @param id - номер
     * @param model
     */
    public void updateArticle(int id, Model model){
        listal.stream()
                .filter((t)->{
                    return t.getId()==id;
                })
                .forEach(t->{
                    t.setModel_id(model.getModel());
                    t.setModel_article(model.getArticle());
                    if(t.getColor_id()!=0 && t.getSizes_tid()!=0 && t.getSizes_tid() != 0){
                        t.setCheck(1);
                        t.setStatus(1);
                }});
        fireTableDataChanged();
    }
    
    
    /**
     * Добавить в работе
     * @param ls
     */
    public void addInWork(Map<String, Integer> ls){
        listal.stream()
                .filter(t->{
                    if(t.getColor_id()==0) return false;
                    return t.getModel_id()!=0;})
                .forEach(t->{
                    if(ls.containsKey(t.getModel_id() + "-" +t.getColor_id() + "-" + t.getSizes_tid())){
                        t.setIn_work(ls.get(t.getModel_id() + "-" +t.getColor_id() + "-" + t.getSizes_tid()));
                    }
                });
        fireTableDataChanged();        
    }
    
    /**
     * Снять выделение со всех строк
     */
    public void deselectAll(){
        listal.forEach(t->t.setCheck(0));
        fireTableDataChanged();
    }
    
    
    /**
     * Обновить размер
     * @param id - ид строки
     * @param size_id - номер размера
     * @param size_name - название размера
     */
    public void updateRazmeri(int id, int size_id, String size_name){
        listal.stream()
                .filter((t)->{
                    return t.getId()==id;
                })
                .forEach(t->{
                    t.setSizes_tid(id);
                    t.setSizes_t(size_name);
                    if(t.getColor_id()!=0 && t.getModel_id()!=0){
                        t.setCheck(1);
                        t.setStatus(1);
                    }
                });
        fireTableDataChanged();
    }
    
    
    /**
     * Сортировать данные по ABC
     */
    public void sortABC(){
        listal.sort((o1, o2) -> {
            return o2.getSumma_sale()-o1.getSumma_sale();
        });                
        fireTableDataChanged();
    }
    
     /**
     * Сортировать данные по ABC
     */
    public void sortArticle(){
        Collections.sort(listal);                
        fireTableDataChanged();
    }
    
    
    /**
     * Получим выделенный элемент
     * @param id
     * @return 
     */
    public ArticleLoad getSelectArticleLoad(int id){
        return listal.stream()
                .filter(t->{
                    return t.getId() == id;
                })
                .findFirst().get();
    }
}
