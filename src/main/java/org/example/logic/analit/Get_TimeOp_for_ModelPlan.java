/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.logic.analit;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

/**
 *
 * @author ivan
 */
@NamedNativeQueries({
	@NamedNativeQuery(
	name = "GET_TOMEOP_FOR_MODELPLAN",
	query = "select ID, OPNAME, MAXT, QTYOP, QTYMPLAN from GET_TOMEOP_FOR_MODELPLAN(:MP, :D1, :D2)",        
	resultClass = Get_TimeOp_for_ModelPlan.class
	)
})
@Entity
public class Get_TimeOp_for_ModelPlan implements Serializable {
    @Id
    @Column(name = "ID")
    Integer id;
    
    @Column(name = "OPNAME")
    String opname;
    
    @Column(name = "MAXT")
    BigDecimal maxt;
    
    @Column(name = "QTYOP")
    BigDecimal qtyop;
    
    @Column(name = "QTYMPLAN")
    BigDecimal qtymplan;

    public Get_TimeOp_for_ModelPlan() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpname() {
        return opname;
    }

    public void setOpname(String opname) {
        this.opname = opname;
    }

    public BigDecimal getMaxt() {
        return maxt;
    }

    public void setMaxt(BigDecimal maxt) {
        this.maxt = maxt;
    }

    public BigDecimal getQtyop() {
        return qtyop;
    }

    public void setQtyop(BigDecimal qtyop) {
        this.qtyop = qtyop;
    }

    public BigDecimal getQtymplan() {
        return qtymplan;
    }

    public void setQtymplan(BigDecimal qtymplan) {
        this.qtymplan = qtymplan;
    }
    
    
    
    
    
}
