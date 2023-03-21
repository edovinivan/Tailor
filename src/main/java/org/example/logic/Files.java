/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.logic;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "FILES")
public class Files implements Serializable {
    @Id
    @Column(name = "FILES")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_FILES_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_FILES_ID", sequenceName = "GEN_FILES_ID")
    Integer files;
    
    @Column(name = "NAME")
    String name;
    
    @Lob
    @Column(name = "OBJ")    
    byte[] obj;

    public Files(Integer f) {
        files = f;
    }

    public Files() {
    }

    public Integer getFiles() {
        return files;
    }

    public void setFiles(Integer files) {
        this.files = files;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getObj() {
        return obj;
    }

    public void setObj(byte[] obj) {
        this.obj = obj;
    }
    
    
    
    
}
