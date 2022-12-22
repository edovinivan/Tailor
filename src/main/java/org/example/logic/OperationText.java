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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "OPERATIONTEXT")
public class OperationText implements Serializable {
    @Id
    @Column(name = "OPERATIONTEXT")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_OPERATIONTEXT_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_OPERATIONTEXT_ID", sequenceName = "GEN_OPERATIONTEXT_ID")
    Integer operationtext;
    
    @Column(name = "TEXT")
    String text;

    public OperationText() {
    }

    public Integer getOperationtext() {
        return operationtext;
    }

    public void setOperationtext(Integer operationtext) {
        this.operationtext = operationtext;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    
    
}
