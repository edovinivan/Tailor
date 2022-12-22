/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.logic.plan;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.example.logic.Color;
import org.example.logic.Model;
import org.example.logic.Razmeri;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "MAPPROJECTJOURNAL")
public class MapProjectJournal implements Serializable{
    @Id
    @Column(name = "MAPPROJECTJOURNAL")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_MAPPROJECTJOURNAL_ID")
    @SequenceGenerator(allocationSize = 1, sequenceName = "GEN_MAPPROJECTJOURNAL_ID", name = "GEN_MAPPROJECTJOURNAL_ID")
    Integer mapprojectjournal;
    
    @ManyToOne
    @JoinColumn(name = "MAPPROJECT")
    MapProject mapProject;
    
    @ManyToOne
    @JoinColumn(name = "MODEL")
    Model model;
    
    @ManyToOne
    @JoinColumn(name = "COLOR")
    Color color;
    
    @Column(name = "QTY")
    Integer qty;
    
    @Column(name = "DATES")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date dates;
    
    @Column(name = "STATUS")
    Integer status;
    
    @ManyToOne
    @JoinColumn(name = "RAZMERI")
    Razmeri razmeri;
    
    @Column(name = "SALE")
    Integer sale;
    
    @Column(name = "INWORK")
    Integer inwork;
    
    @Column(name = "BALANCE")
    Integer balance;
    
    @Column(name = "SALEMONEY")
    Integer salemoney;

    public Integer getSalemoney() {
        return salemoney;
    }

    public void setSalemoney(Integer salemoney) {
        this.salemoney = salemoney;
    }

    @Override
    public String toString() {
        return "MapProjectJournal{" + "mapprojectjournal=" + mapprojectjournal + ", mapProject=" + mapProject + ", model=" + model + ", color=" + color + ", qty=" + qty + ", dates=" + dates + ", status=" + status + ", razmeri=" + razmeri + ", sale=" + sale + ", inwork=" + inwork + ", balance=" + balance + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.mapProject);
        hash = 59 * hash + Objects.hashCode(this.model);
        hash = 59 * hash + Objects.hashCode(this.color);
        hash = 59 * hash + Objects.hashCode(this.razmeri);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MapProjectJournal other = (MapProjectJournal) obj;
        
        if (this.mapProject.getMapproject() != other.mapProject.getMapproject()) {
            return false;        
        }
        
        if (this.model.getModel() != other.model.getModel()) {
            return false;
        }
        if (this.color.getColor() != other.color.getColor()) {
            return false;
        }
        if ( this.razmeri.getRazmeri() != other.razmeri.getRazmeri()) {
            return false;
        }
        return true;
    }

    

    public Razmeri getRazmeri() {
        return razmeri;
    }

    public void setRazmeri(Razmeri razmeri) {
        this.razmeri = razmeri;
    }

    public Integer getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }

    public Integer getInwork() {
        return inwork;
    }

    public void setInwork(Integer inwork) {
        this.inwork = inwork;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }
    
    
    
    
    

    public MapProjectJournal(Integer mapprojectjournal) {
        this.mapprojectjournal = mapprojectjournal;
    }

    public MapProjectJournal() {
    }

    public MapProjectJournal(Integer mapprojectjournal, Integer mapProject, Integer model, Integer color, Integer qty, Date dates, Integer status, Integer balance, Integer sale, Integer inwork, Integer razmeri, Integer saleMoney) {
        this.mapprojectjournal = mapprojectjournal;
        this.mapProject = new MapProject(mapProject);
        this.model = new Model(model);
        this.color = new Color(color);
        this.qty = qty;
        this.dates = dates;
        this.status = status;
        this.balance = balance;
        this.inwork = inwork;
        this.sale = sale;
        this.razmeri = new Razmeri(razmeri);
        this.salemoney = saleMoney;        
    }
    
    

    public Integer getMapprojectjournal() {
        return mapprojectjournal;
    }

    public void setMapprojectjournal(Integer mapprojectjournal) {
        this.mapprojectjournal = mapprojectjournal;
    }

    public MapProject getMapProject() {
        return mapProject;
    }

    public void setMapProject(MapProject mapProject) {
        this.mapProject = mapProject;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Date getDates() {
        return dates;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }

   

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    
    
    
    
}
