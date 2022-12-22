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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "OPERATORSETUP")
public class OperatorSetup implements Serializable {
    @Id
    @Column(name = "OPERATORSETUP")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_OPERATORSETUP_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_OPERATORSETUP_ID", sequenceName = "GEN_OPERATORSETUP_ID")
    Integer operatorsetup;
    
    @ManyToOne
    @JoinColumn(name = "OPERATOR")
    Operator operator;
    
    @ManyToOne
    @JoinColumn(name = "SETUPNAME")
    SetupName setupname;
    
    @Column(name = "VAL")
    Integer val;

    public OperatorSetup(Integer os) {
        operatorsetup = os;
    }

    public OperatorSetup() {
    }

    public Integer getOperatorsetup() {
        return operatorsetup;
    }

    public void setOperatorsetup(Integer operatorsetup) {
        this.operatorsetup = operatorsetup;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public SetupName getSetupname() {
        return setupname;
    }

    public void setSetupname(SetupName setupname) {
        this.setupname = setupname;
    }

    public Integer getVal() {
        return val;
    }

    public void setVal(Integer val) {
        this.val = val;
    }
    
    
    
    
    
}
