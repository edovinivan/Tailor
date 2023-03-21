/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.util.plannew;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ivan
 * @param <O> - объект
 * @param <K> - ключ
 */
public interface ioObject<O, K> {
    /**
     * Сохранить объект
     * @param obj
     * @return 
     */
    public O setObject(O obj);
    public O getObject(K key);
    public List<O> getListObject(Date d1, Date d2);    
    public boolean delObject(K key);
}
