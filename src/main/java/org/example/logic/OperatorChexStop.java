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
@Table(name = "OPERATORCHEXSTOP")
public class OperatorChexStop implements Serializable {    
    @Id
    @Column(name = "OPERATORCHEXSTOP")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_OPERATORCHEXSTOP_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_OPERATORCHEXSTOP_ID", sequenceName = "GEN_OPERATORCHEXSTOP_ID")
    Integer operatorchexstop;
    
    @ManyToOne
    @JoinColumn(name = "OPERATOR")
    Operator operator;
    
    @ManyToOne
    @JoinColumn(name = "CHEX")
    RabotnikGruppa chex;

    public OperatorChexStop(Integer o) {
        operatorchexstop = o;
    }

    public OperatorChexStop() {
    }

    public Integer getOperatorchexstop() {
        return operatorchexstop;
    }

    public void setOperatorchexstop(Integer operatorchexstop) {
        this.operatorchexstop = operatorchexstop;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public RabotnikGruppa getChex() {
        return chex;
    }

    public void setChex(RabotnikGruppa chex) {
        this.chex = chex;
    }
    
    
    
    
    
    
}
