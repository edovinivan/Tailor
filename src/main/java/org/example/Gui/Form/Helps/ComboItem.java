/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Form.Helps;

/**
 *
 * @author ivan
 */
public class ComboItem {
    Integer id;
    String name;

    @Override
    public String toString() {
        return getName();
    }  
   

    public ComboItem() {
    }

    public ComboItem(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
   
   
}
