/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.logic.plan;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name = "MAPARTICLECOLORJOIN")
public class MapArticleColorJoin implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GET_ID")
    @SequenceGenerator(sequenceName = "GEN_MAPARTICLECOLORJOIN_ID", name = "GET_ID", allocationSize = 1)
    @Column(name = "MAPARTICLECOLORJOIN", nullable = false)
            
    Integer maparticlecolorjoin;
    
    @Column(name = "V_1C")
    String v_ic;
    
    @Column(name = "V_TAILOR", nullable = false)
    Integer v_tailor;
    
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "VID")
    VidJoinArticleColor vid;

    public MapArticleColorJoin() {
    }

    public MapArticleColorJoin(Integer maparticlecolorjoin) {
        this.maparticlecolorjoin = maparticlecolorjoin;
    }

    public MapArticleColorJoin(Integer maparticlecolorjoin, String v_ic, Integer v_tailor, VidJoinArticleColor vid) {
        this.maparticlecolorjoin = maparticlecolorjoin;
        this.v_ic = v_ic;
        this.v_tailor = v_tailor;
        this.vid = vid;
    }

    public Integer getMaparticlecolorjoin() {
        return maparticlecolorjoin;
    }

    public void setMaparticlecolorjoin(Integer maparticlecolorjoin) {
        this.maparticlecolorjoin = maparticlecolorjoin;
    }

    public String getV_ic() {
        return v_ic;
    }

    public void setV_ic(String v_ic) {
        this.v_ic = v_ic;
    }

    public Integer getV_tailor() {
        return v_tailor;
    }

    public void setV_tailor(Integer v_tailor) {
        this.v_tailor = v_tailor;
    }

    public VidJoinArticleColor getVid() {
        return vid;
    }

    public void setVid(VidJoinArticleColor vid) {
        this.vid = vid;
    }
    
    
    
}
