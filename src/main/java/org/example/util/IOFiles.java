/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.example.logic.Files;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ivan
 */
public class IOFiles {
    /**
     * Загрузить файл для сохранения в файл
     * @param name_file - название файла и путь к нему
     * @return - массив
     */
    public static byte[] loadFile(String name_file)
    {
        byte[] bt = null;
        try(FileInputStream fin=new FileInputStream(name_file))
        {
            File file = new File(name_file);            
            bt = new byte[(int) file.length()];                      
            fin.read(bt);           
        }
        catch(IOException ex){
             
            System.out.println(ex.getMessage());
        } 
        return bt;
    }
    
    /**
     * Сохранить файл
     * @param b - файл в вите байтов
     * @param filename - название файла
     * @return 
     */
    public static String saveFile(byte[] b, String filename)
    {
        try {            
            FileOutputStream ou = new FileOutputStream(filename);
            ou.write(b);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(IOFiles.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(IOFiles.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filename;
    }
    
    /**
     * Сохранить файл во временный файл
     * @param b - массив
     * @return 
     */
    public static String saveFileTemp(byte[] b)
    {
        String namefile = null;
        try {
            namefile = File.createTempFile("outf", "cck").getAbsolutePath();
        } catch (IOException ex) {
            Logger.getLogger(IOFiles.class.getName()).log(Level.SEVERE, null, ex);
        }
        return saveFile(b, namefile);
    }
    
    
    
    
    
    /**
     * Сохранить файл
     * @param p - файл
     * @return - файл
     */
    public static Files setFiles(Files p)
    {
        if(p.getFiles()== 0)
            p.setFiles(null);
        
        Session sess = HibernateUtil.getSessionFactory().openSession();
        try 
        {
            sess.beginTransaction();
            sess.saveOrUpdate(p);
            sess.beginTransaction().commit();
            
        }catch(HibernateException e)
        {
            System.out.println("ERROR SAVE" + e);            
        }
        return p;
    }
    
     /**
     * Получить файл
     * @param p - id цвета
     * @return 
     */
    public static Files getFiles(int p)
    {
        List<Files> ls = new ArrayList<>();
        try  
        {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            ls = sess.createCriteria(Files.class).add(Restrictions.eq("files", p)).list();            
            if(ls.isEmpty())
                ls.add(new Files(0));
        }catch(HibernateException e)
        {
            System.out.println("GER ERROR " + e);            
            ls.add(new Files(0));
        }        
        return ls.get(0);        
    }
    
    /**
     * Удалить объект
     * @param p - ид объекта
     * @return - результат
     */
    public static boolean delFiles(int p)
    {
        try 
        {
            Session sess = HibernateUtil.getSessionFactory().openSession(); 
            sess.beginTransaction();
            String s = "delete from files where files = " + p;
            sess.createSQLQuery(s).executeUpdate();
            sess.beginTransaction().commit();
        } catch (HibernateException e) {
            System.out.println("ERROR DEL" + e);
            return false;
        }        
        return true;
        
    }
    
}
