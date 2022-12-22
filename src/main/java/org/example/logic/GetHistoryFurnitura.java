/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.logic;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Temporal;

/**
 *
 * @author ivan
 */
@NamedNativeQueries({
	@NamedNativeQuery(
	name = "GETHISTORYFURNITURA",
	query = "select ID, ID1, GID, NAME, COLOR, PRICE, AGENT, DATES, OPERATIONS, QTY, PRODUCT from GET_HISTORY_FURNITURA_PRODUCT(:furn, :sps) order by gid, id1",        
	resultClass = GetHistoryFurnitura.class
	)
})
@Entity

//@Table(name = "PRODUCT")
public class GetHistoryFurnitura implements Serializable {
    @Id
    @Column(name = "ID")
    Integer id;
    
    @Column(name = "ID1")
    Integer id1;
    
    @Column(name = "GID")
    Integer gid;
    
    @Column(name = "NAME")
    String name;
    
    @Column(name = "COLOR")
    String color;
    
    @Column(name = "PRICE")
    BigDecimal price;
    
    @Column(name = "AGENT")
    String agent;
    
    @Column(name = "DATES")    
    @Temporal(javax.persistence.TemporalType.DATE)
    Date dates;
    
    @Column(name = "OPERATIONS")
    String operations;
    
    @Column(name = "QTY")    
    BigDecimal qty;
    
    @Column(name = "PRODUCT")
    Integer product;

    public Integer getProduct() {
        return product;
    }

    public void setProduct(Integer product) {
        this.product = product;
    }
    
    

    public GetHistoryFurnitura() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId1() {
        return id1;
    }

    public void setId1(Integer id1) {
        this.id1 = id1;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public Date getDates() {
        return dates;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }

    public String getOperations() {
        return operations;
    }

    public void setOperations(String operations) {
        this.operations = operations;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }
    
    
    
}
