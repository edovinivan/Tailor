/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.util;

import java.awt.Component;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author ivan
 */
public class HelpClass {
    
    /**
     * проверка текста на соответствие числу BigDecimal
     * @param s - текст который нужно проверить
     * @return - соответствует или нет
     */
    public static boolean checkTextForBigDecimal(String s)
    {       
        try
        {
            new BigDecimal(s.replace(",", "."));
            //System.out.println("OK");
            return true;
        }
        catch(NumberFormatException e)
        {
            //System.out.println("ERROR");
            return false;
        }
    }
    
    
    
    /**
     * проверка текста на соответствие числу Integer
     * @param s - текст который нужно проверить
     * @return - соответствует или нет
     */
    public static boolean checkTextForInt(String s)
    {       
        try
        {
            Integer.parseInt(s);
            return true;
        }
        catch(NumberFormatException e)
        {
            return false;
        }
    }
    
    /**
     * Возвращает число  BigDecimal из текста если ошибка то 0
     * @param s - текст который нужно проверить
     * @return 
     */
    public static BigDecimal GetBigDecimalIzText(String s)
    {
        try
        {
            return new BigDecimal(s.replace(",", "."));
        }
        catch(NumberFormatException e)
        {
            //System.out.println("ERROR");
            return new BigDecimal(0);
        }
    }
    
    public static BigDecimal GetBigDecimalIzText2(String s)
    {
        try
        {
            return new BigDecimal(s.replace(",", "."));
        }
        catch(NumberFormatException e)
        {
            //System.out.println("ERROR");
            return MIN_QTY_EDIT;
        }
    }
    
    public static boolean checkNotEdit(BigDecimal bg){
        return MIN_QTY_EDIT.compareTo(bg) != 0;
    }
    
    public static BigDecimal MIN_QTY_EDIT = new BigDecimal("0.00001"); 
    
    public static boolean checkNotEdit2(String s){
        try
        {
            new BigDecimal(s.replace(",", "."));
            return true;
        }
        catch(NumberFormatException e)
        {
            return false;
        }
    }
    
    /**
     * Возвращает число  BigDecimal из текста если ошибка то 0
     * @param s - текст который нужно проверить
     * @return 
     */
    public static int GetIntIzText(String s)
    {
        try
        {
            return Integer.parseInt(s);
        }
        catch(NumberFormatException e)
        {
            //System.out.println("ERROR");
            return 0;
        }
    }
    
    /**
     * проверка текста на соответствие названию
     * @param s - текст который нужно проверить
     * @return 
     */
    public static boolean checkTextForName(String s)
    {
        if(s == null)                    
            return false;
        
        if(s.isEmpty())
            return false;
        if(s.length()< 1)
            return false;
        return true;
    }
    
    
    /**
     * Формирование даты для вывода
     * dd-MM-YYYY
     * @param d - дата
     * @return 
     */
    public static String getPrintDate(Date d)
    {
        SimpleDateFormat sd = new SimpleDateFormat("dd-MM-YYYY");
        return sd.format(d);
    }
    
    /**
     * Формирование даты для вывода YYYY-MM-dd
     * @param d - дата 
     * @return YYYY-MM-dd
     */
    public static String getPrintDate1(Date d)
    {
        SimpleDateFormat sd = new SimpleDateFormat("YYYY-MM-dd");
        return sd.format(d);
    }
    
    /**
     * Формирование даты для вывода YYYYMMdd
     * @param d - дата 
     * @return YYYYMMdd
     */
    public static String getPrintDate4(Date d)
    {
        SimpleDateFormat sd = new SimpleDateFormat("YYYYMMdd");
        return sd.format(d);
    }
    
    /**
     * Формирование даты для вывода
     * YYMMddHHmmss
     * @param d - дата
     * @return 
     */
    public static String getPrintDate2(Date d)
    {
        SimpleDateFormat sd = new SimpleDateFormat("YYMMddHHmmss");
        return sd.format(d);
    }
    
    /**
     * Формирование даты для вывода
     * YYYY-MM-dd HH:mm
     * @param d - дата
     * @return 
     */
    public static String getPrintDate3(Date d)
    {
        SimpleDateFormat sd = new SimpleDateFormat("YYYY-MM-dd HH:mm");
        return sd.format(d);
    }
    
    /**
     * Формирование даты для вывода
     * YYYYMMddHHmmss
     * @param d - дата
     * @return 
     */
    public static String getPrintDate5(Date d)
    {
        SimpleDateFormat sd = new SimpleDateFormat("YYYYMMddHHmmss");
        return sd.format(d);
    }
    
    
    public static DefaultTableCellRenderer jTableRendererColumnRight = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            JLabel cell = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            cell.setHorizontalAlignment(JLabel.RIGHT);
            return cell;
        }

    };
    
    
    
}
