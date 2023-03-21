/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.FOT;

import org.example.Gui.Form.Helps.FGetGruppaProduct;
import org.example.Gui.Form.Helps.FGetModel;
import org.example.Gui.Form.Helps.FGetRabotnik;
import org.example.Gui.Form.Helps.FGetRabotnikGruppa;
import org.example.Gui.Form.Helps.FGetSclad;
import org.example.Gui.Form.Helps.FGetTipModeli;
import org.example.Gui.Form.Report.PrintReport;
import java.awt.Toolkit;
import java.util.Date;
import org.example.logic.RabotnikGruppa;
import org.example.util.IOModel;
import org.example.util.IOOperator;
import org.example.util.IOProduct;
import org.example.util.IORabotnik;
import org.example.util.IOSclad;
import org.example.util.IOTipModel;

/**
 *
 * @author ivan
 */
public class FParamReportPrintRabotnik extends javax.swing.JDialog {

    /**
     * Creates new form FParamReportPrintRabotnik
     * @param parent
     * @param modal
     * @param v - вид работников
     * 1 = швей
     * 2 - комплектовщики
     * 3 - наслильшики
     * 4 - резаки
     
     * 
     */
    public FParamReportPrintRabotnik(java.awt.Frame parent, boolean modal, int v) {
        super(parent, modal);
        initComponents();
        jDateChooser1.setDate(new Date());
        jDateChooser2.setDate(new Date());
        jLabel5.setVisible(false);
        jTextField3.setVisible(false);
        jButton5.setVisible(false);
        vid = v;
        jLabel6.setVisible(false);
        jTextField4.setVisible(false);
        jButton6.setVisible(false);
        
        jLabel7.setVisible(false);
        jTextField5.setVisible(false);
        jButton7.setVisible(false);
        
        jLabel8.setVisible(false);
        jTextField6.setVisible(false);
        jButton8.setVisible(false);
        
        if(vid!=1)
        {
            jLabel1.setVisible(false);
            jTextField1.setVisible(false);
            jButton1.setVisible(false);
        }
        switch(vid)
        {
            case 46:
            case 2:
                rg = 6;
                break;
            case 3:    
            case 47:        
                rg = 4;
                break;
            case 48:     
            case 4:    
                rg = 5;
                break;    
            case 12:    
                rg = 6;
                break;        
           case 20:
           case 49:    
                rg = 6;
                break;             
                
        }
        if(vid == 5)
        {
            jLabel1.setVisible(false);
            jLabel2.setVisible(false);
            jTextField1.setVisible(false);
            jTextField2.setVisible(false);
            jButton1.setVisible(false);
            jButton2.setVisible(false);
        }
        
        if(vid == 6)
        {
            jLabel1.setVisible(false);
            jLabel2.setVisible(false);
            jTextField1.setVisible(false);
            jTextField2.setVisible(false);
            jButton1.setVisible(false);
            jButton2.setVisible(false);
        }
        if(vid == 7)
        {
            jLabel1.setVisible(false);
            jLabel2.setVisible(false);
            jTextField1.setVisible(false);
            jTextField2.setVisible(false);
            jButton1.setVisible(false);
            jButton2.setVisible(false);
        }
        if(vid == 8)
        {
            jLabel1.setVisible(false);
            jLabel2.setVisible(false);
            jTextField1.setVisible(false);
            jTextField2.setVisible(false);
            jButton1.setVisible(false);
            jButton2.setVisible(false);
        }
        
        if(vid == 9)
        {
            jLabel1.setVisible(false);
            jLabel2.setVisible(false);
            jTextField1.setVisible(false);
            jTextField2.setVisible(false);
            jButton1.setVisible(false);
            jButton2.setVisible(false);
        }
        if(vid == 10)
        {
            jLabel2.setVisible(false);
            jTextField2.setVisible(false);
            jButton2.setVisible(false);
            jLabel1.setVisible(true);
            jTextField1.setVisible(true);
            jButton1.setVisible(true);
        }
        if(vid == 11)
        {
            jLabel1.setVisible(false);
            jLabel2.setVisible(false);
            jTextField1.setVisible(false);
            jTextField2.setVisible(false);
            jButton1.setVisible(false);
            jButton2.setVisible(false);
        }
        
        if(vid == 12)
        {
            jLabel2.setVisible(true);
            jTextField2.setVisible(true);
            jButton2.setVisible(true);
            jLabel1.setVisible(false);
            jTextField1.setVisible(false);
            jButton1.setVisible(false);
        }
        
        
        if(vid == 13)
        {
            jLabel2.setVisible(false);
            jTextField2.setVisible(false);
            jButton2.setVisible(false);
            jLabel1.setVisible(false);
            jTextField1.setVisible(false);
            jButton1.setVisible(false);
            jLabel5.setVisible(true);
            jTextField3.setVisible(true);
            jButton5.setVisible(true);
        }
        
        if(vid == 14)
        {
            jLabel2.setVisible(false);
            jTextField2.setVisible(false);
            jButton2.setVisible(false);
            jLabel1.setVisible(false);
            jTextField1.setVisible(false);
            jButton1.setVisible(false);
            jLabel5.setVisible(false);
            jTextField3.setVisible(false);
            jButton5.setVisible(false);
        }
        
        if(vid == 15)
        {
            jLabel2.setVisible(false);
            jTextField2.setVisible(false);
            jButton2.setVisible(false);
            jLabel1.setVisible(false);
            jTextField1.setVisible(false);
            jButton1.setVisible(false);
            jLabel5.setVisible(false);
            jTextField3.setVisible(false);
            jButton5.setVisible(false);
        }
        
        if(vid == 16)
        {
            jLabel2.setVisible(false);
            jTextField2.setVisible(false);
            jButton2.setVisible(false);
            jLabel1.setVisible(false);
            jTextField1.setVisible(false);
            jButton1.setVisible(false);
            jLabel5.setVisible(false);
            jTextField3.setVisible(false);
            jButton5.setVisible(false);
            
            jLabel6.setVisible(true);
            jTextField4.setVisible(true);
            jButton6.setVisible(true);
        }
        
        if(vid == 18)
        {
            jLabel2.setVisible(false);
            jTextField2.setVisible(false);
            jButton2.setVisible(false);
            jLabel1.setVisible(true);
            jTextField1.setVisible(true);
            jButton1.setVisible(true);
            jLabel5.setVisible(false);
            jTextField3.setVisible(false);
            jButton5.setVisible(false);
            
            jLabel6.setVisible(false);
            jTextField4.setVisible(false);
            jButton6.setVisible(false);
            
            jLabel4.setVisible(false);
            jLabel3.setVisible(false);
            jDateChooser1.setVisible(false);
            jDateChooser2.setVisible(false);
        }
        
        if(vid == 19)
        {
            jLabel1.setVisible(false);
            jTextField1.setVisible(false);
            jButton1.setVisible(false);
            
            jLabel2.setVisible(false);
            jTextField2.setVisible(false);
            jButton2.setVisible(false);
                        
            jLabel5.setVisible(false);
            jTextField3.setVisible(false);
            jButton5.setVisible(false);
            
            jLabel6.setVisible(false);
            jTextField4.setVisible(false);
            jButton6.setVisible(false);
            
        }
        
        if(vid == 20 || vid == 49)
        {
            jLabel2.setVisible(true);
            jTextField2.setVisible(true);
            jButton2.setVisible(true);
            jLabel1.setVisible(false);
            jTextField1.setVisible(false);
            jButton1.setVisible(false);
        }
        
        if(vid == 21)
        {
            jLabel2.setVisible(false);
            jTextField2.setVisible(false);
            jButton2.setVisible(false);
            jLabel1.setVisible(false);
            jTextField1.setVisible(false);
            jButton1.setVisible(false);
        }
        
        if(vid == 22)
        {
            jLabel2.setVisible(false);
            jTextField2.setVisible(false);
            jButton2.setVisible(false);
            jLabel1.setVisible(false);
            jTextField1.setVisible(false);
            jButton1.setVisible(false);
            jLabel5.setVisible(false);
            jTextField3.setVisible(false);
            jButton5.setVisible(false);
            
            jLabel6.setVisible(false);
            jTextField4.setVisible(false);
            jButton6.setVisible(false);
        }
        
        if(vid == 23)
        {
            jLabel2.setVisible(false);
            jTextField2.setVisible(false);
            jButton2.setVisible(false);
            
            jLabel1.setVisible(true);
            jTextField1.setVisible(true);
            jButton1.setVisible(true);
            
            jLabel5.setVisible(false);
            jTextField3.setVisible(false);
            jButton5.setVisible(false);
            
            jLabel6.setVisible(false);
            jTextField4.setVisible(false);
            jButton6.setVisible(false);
        }
        
        if(vid == 24)
        {
            jLabel2.setVisible(false);
            jTextField2.setVisible(false);
            jButton2.setVisible(false);
            jLabel1.setVisible(false);
            jTextField1.setVisible(false);
            jButton1.setVisible(false);
            jLabel5.setVisible(false);
            jTextField3.setVisible(false);
            jButton5.setVisible(false);
            
            jLabel6.setVisible(false);
            jTextField4.setVisible(false);
            jButton6.setVisible(false);
        }
        
        if(vid == 25)
        {
            jLabel2.setVisible(false);
            jTextField2.setVisible(false);
            jButton2.setVisible(false);
            jLabel1.setVisible(true);
            jTextField1.setVisible(true);
            jButton1.setVisible(true);
            jLabel5.setVisible(false);
            jTextField3.setVisible(false);
            jButton5.setVisible(false);
            
            jLabel6.setVisible(false);
            jTextField4.setVisible(false);
            jButton6.setVisible(false);
            
            jLabel4.setVisible(false);
            jLabel3.setVisible(false);
            jDateChooser1.setVisible(false);
            jDateChooser2.setVisible(false);
        }
        if(vid == 26)
        {
            jLabel2.setVisible(false);
            jTextField2.setVisible(false);
            jButton2.setVisible(false);
            jLabel1.setVisible(true);
            jTextField1.setVisible(true);
            jButton1.setVisible(true);
            jLabel5.setVisible(false);
            jTextField3.setVisible(false);
            jButton5.setVisible(false);
            
            jLabel6.setVisible(false);
            jTextField4.setVisible(false);
            jButton6.setVisible(false);
            
            jLabel4.setVisible(false);
            jLabel3.setVisible(false);
            jDateChooser1.setVisible(false);
            jDateChooser2.setVisible(false);
        }
        
        if(vid == 27)
        {
            jLabel2.setVisible(false);
            jTextField2.setVisible(false);
            jButton2.setVisible(false);
            jLabel1.setVisible(true);
            jTextField1.setVisible(true);
            jButton1.setVisible(true);
            jLabel5.setVisible(false);
            jTextField3.setVisible(false);
            jButton5.setVisible(false);
            
            jLabel6.setVisible(false);
            jTextField4.setVisible(false);
            jButton6.setVisible(false);
            
            jLabel4.setVisible(false);
            jLabel3.setVisible(false);
            jDateChooser1.setVisible(false);
            jDateChooser2.setVisible(false);
        }
        
        if(vid == 28)
        {
            jLabel2.setVisible(false);
            jTextField2.setVisible(false);
            jButton2.setVisible(false);
            
            jLabel1.setVisible(false);
            jTextField1.setVisible(false);
            jButton1.setVisible(false);
            
            jLabel5.setVisible(false);
            jTextField3.setVisible(false);
            jButton5.setVisible(false);
            
            jLabel6.setVisible(false);
            jTextField4.setVisible(false);
            jButton6.setVisible(false);
            
            jLabel4.setVisible(false);
            jLabel3.setVisible(false);
            jDateChooser1.setVisible(false);
            jDateChooser2.setVisible(false);
            
            jLabel7.setVisible(true);
            jTextField5.setVisible(true);
            jButton7.setVisible(true);

            jLabel8.setVisible(true);
            jTextField6.setVisible(true);
            jButton8.setVisible(true);

        }
        
        if(vid == 29)
        {
            jLabel2.setVisible(false);
            jTextField2.setVisible(false);
            jButton2.setVisible(false);
            
            jLabel1.setVisible(false);
            jTextField1.setVisible(false);
            jButton1.setVisible(false);
            
            jLabel5.setVisible(false);
            jTextField3.setVisible(false);
            jButton5.setVisible(false);
            
            jLabel6.setVisible(false);
            jTextField4.setVisible(false);
            jButton6.setVisible(false);
            
            jLabel4.setVisible(true);
            jLabel3.setVisible(true);
            jDateChooser1.setVisible(true);
            jDateChooser2.setVisible(true);
            
            jLabel7.setVisible(false);
            jTextField5.setVisible(false);
            jButton7.setVisible(false);

            jLabel8.setVisible(false);
            jTextField6.setVisible(false);
            jButton8.setVisible(false);

        }
        
        if(vid == 30)
        {
            jLabel2.setVisible(false);
            jTextField2.setVisible(false);
            jButton2.setVisible(false);
            
            jLabel1.setVisible(false);
            jTextField1.setVisible(false);
            jButton1.setVisible(false);
            
            jLabel5.setVisible(false);
            jTextField3.setVisible(false);
            jButton5.setVisible(false);
            
            jLabel6.setVisible(false);
            jTextField4.setVisible(false);
            jButton6.setVisible(false);
            
            jLabel4.setVisible(true);
            jLabel3.setVisible(true);
            jDateChooser1.setVisible(true);
            jDateChooser2.setVisible(true);
            
            jLabel7.setVisible(false);
            jTextField5.setVisible(false);
            jButton7.setVisible(false);

            jLabel8.setVisible(false);
            jTextField6.setVisible(false);
            jButton8.setVisible(false);

        }
        
        if(vid == 31)
        {
            jLabel2.setVisible(false);
            jTextField2.setVisible(false);
            jButton2.setVisible(false);
            
            jLabel1.setVisible(false);
            jTextField1.setVisible(false);
            jButton1.setVisible(false);
            
            jLabel5.setVisible(false);
            jTextField3.setVisible(false);
            jButton5.setVisible(false);
            
            jLabel6.setVisible(false);
            jTextField4.setVisible(false);
            jButton6.setVisible(false);
            
            jLabel4.setVisible(true);
            jLabel3.setVisible(true);
            jDateChooser1.setVisible(true);
            jDateChooser2.setVisible(true);
            
            jLabel7.setVisible(false);
            jTextField5.setVisible(false);
            jButton7.setVisible(false);

            jLabel8.setVisible(false);
            jTextField6.setVisible(false);
            jButton8.setVisible(false);

        }
        
        if(vid == 32)
        {
            jLabel2.setVisible(false);
            jTextField2.setVisible(false);
            jButton2.setVisible(false);
            
            jLabel1.setVisible(false);
            jTextField1.setVisible(false);
            jButton1.setVisible(false);
            
            jLabel5.setVisible(false);
            jTextField3.setVisible(false);
            jButton5.setVisible(false);
            
            jLabel6.setVisible(false);
            jTextField4.setVisible(false);
            jButton6.setVisible(false);
            
            jLabel4.setVisible(true);
            jLabel3.setVisible(true);
            jDateChooser1.setVisible(true);
            jDateChooser2.setVisible(true);
            
            jLabel7.setVisible(false);
            jTextField5.setVisible(false);
            jButton7.setVisible(false);

            jLabel8.setVisible(false);
            jTextField6.setVisible(false);
            jButton8.setVisible(false);

        }
        
        
        if(vid == 33)
        {
            jLabel2.setVisible(true);
            jTextField2.setVisible(!false);
            jButton2.setVisible(!false);
            
            jLabel1.setVisible(!false);
            jTextField1.setVisible(!false);
            jButton1.setVisible(!false);
            
            jLabel5.setVisible(false);
            jTextField3.setVisible(false);
            jButton5.setVisible(false);
            
            jLabel6.setVisible(false);
            jTextField4.setVisible(false);
            jButton6.setVisible(false);
            
            jLabel4.setVisible(true);
            jLabel3.setVisible(true);
            jDateChooser1.setVisible(true);
            jDateChooser2.setVisible(true);
            
            jLabel7.setVisible(false);
            jTextField5.setVisible(false);
            jButton7.setVisible(false);

            jLabel8.setVisible(false);
            jTextField6.setVisible(false);
            jButton8.setVisible(false);

        }
        
        
        if(vid == 34)
        {
            jLabel2.setVisible(true);
            jTextField2.setVisible(!false);
            jButton2.setVisible(!false);
            
            jLabel1.setVisible(!false);
            jTextField1.setVisible(!false);
            jButton1.setVisible(!false);
            
            jLabel5.setVisible(false);
            jTextField3.setVisible(false);
            jButton5.setVisible(false);
            
            jLabel6.setVisible(false);
            jTextField4.setVisible(false);
            jButton6.setVisible(false);
            
            jLabel4.setVisible(true);
            jLabel3.setVisible(true);
            jDateChooser1.setVisible(true);
            jDateChooser2.setVisible(true);
            
            jLabel7.setVisible(false);
            jTextField5.setVisible(false);
            jButton7.setVisible(false);

            jLabel8.setVisible(false);
            jTextField6.setVisible(false);
            jButton8.setVisible(false);

        }
        
        if(vid == 35)
        {
            jLabel1.setVisible(false);
            jLabel2.setVisible(false);
            jTextField1.setVisible(false);
            jTextField2.setVisible(false);
            jButton1.setVisible(false);
            jButton2.setVisible(false);
        }
        
        if(vid == 36)
        {
            jLabel1.setVisible(false);
            jLabel2.setVisible(false);
            jTextField1.setVisible(false);
            jTextField2.setVisible(false);
            jButton1.setVisible(false);
            jButton2.setVisible(false);
            
            jLabel4.setVisible(false);
            jLabel3.setVisible(true);
            jDateChooser1.setVisible(true);
            jDateChooser2.setVisible(false);
        }
        
        if(vid == 37)
        {
            jLabel1.setVisible(false);
            jLabel2.setVisible(false);
            jTextField1.setVisible(false);
            jTextField2.setVisible(false);
            jButton1.setVisible(false);
            jButton2.setVisible(false);
            
            jLabel4.setVisible(true);
            jLabel3.setVisible(true);
            jDateChooser1.setVisible(true);
            jDateChooser2.setVisible(true);
        }
        
        
        if(vid == 38)
        {
            jLabel1.setVisible(false);
            jLabel2.setVisible(false);
            jTextField1.setVisible(false);
            jTextField2.setVisible(false);
            jButton1.setVisible(false);
            jButton2.setVisible(false);
            
            jLabel4.setVisible(true);
            jLabel3.setVisible(true);
            jDateChooser1.setVisible(true);
            jDateChooser2.setVisible(true);
        }
        
        
        if(vid == 39)
        {
            jLabel2.setVisible(false);
            jTextField2.setVisible(false);
            jButton2.setVisible(false);
            
            jLabel1.setVisible(false);
            jTextField1.setVisible(false);
            jButton1.setVisible(false);
            
            jLabel5.setVisible(false);
            jTextField3.setVisible(false);
            jButton5.setVisible(false);
            
            jLabel6.setVisible(false);
            jTextField4.setVisible(false);
            jButton6.setVisible(false);
            
            jLabel4.setVisible(true);
            jLabel3.setVisible(true);
            jDateChooser1.setVisible(true);
            jDateChooser2.setVisible(true);
            
            jLabel7.setVisible(false);
            jTextField5.setVisible(false);
            jButton7.setVisible(false);

            jLabel8.setVisible(false);
            jTextField6.setVisible(false);
            jButton8.setVisible(false);

        }
        
        if(vid == 41)
        {
            jLabel2.setVisible(false);
            jTextField2.setVisible(false);
            jButton2.setVisible(false);
            
            jLabel1.setVisible(false);
            jTextField1.setVisible(false);
            jButton1.setVisible(false);
            
            jLabel5.setVisible(false);
            jTextField3.setVisible(false);
            jButton5.setVisible(false);
            
            jLabel6.setVisible(false);
            jTextField4.setVisible(false);
            jButton6.setVisible(false);
            
            jLabel4.setVisible(true);
            jLabel3.setVisible(true);
            jDateChooser1.setVisible(true);
            jDateChooser2.setVisible(true);
            
            jLabel7.setVisible(false);
            jTextField5.setVisible(false);
            jButton7.setVisible(false);

            jLabel8.setVisible(false);
            jTextField6.setVisible(false);
            jButton8.setVisible(false);

        }
        
        if(vid == 42)
        {
            jLabel2.setVisible(false);
            jTextField2.setVisible(false);
            jButton2.setVisible(false);
            
            jLabel1.setVisible(false);
            jTextField1.setVisible(false);
            jButton1.setVisible(false);
            
            jLabel5.setVisible(false);
            jTextField3.setVisible(false);
            jButton5.setVisible(false);
            
            jLabel6.setVisible(false);
            jTextField4.setVisible(false);
            jButton6.setVisible(false);
            
            jLabel4.setVisible(true);
            jLabel3.setVisible(true);
            jDateChooser1.setVisible(true);
            jDateChooser2.setVisible(true);
            
            jLabel7.setVisible(false);
            jTextField5.setVisible(false);
            jButton7.setVisible(false);

            jLabel8.setVisible(false);
            jTextField6.setVisible(false);
            jButton8.setVisible(false);

        }
        
        if(vid == 43)
        {
            jLabel2.setVisible(false);
            jTextField2.setVisible(false);
            jButton2.setVisible(false);
            
            jLabel1.setVisible(false);
            jTextField1.setVisible(false);
            jButton1.setVisible(false);
            
            jLabel5.setVisible(false);
            jTextField3.setVisible(false);
            jButton5.setVisible(false);
            
            jLabel6.setVisible(false);
            jTextField4.setVisible(false);
            jButton6.setVisible(false);
            
            jLabel4.setVisible(true);
            jLabel3.setVisible(true);
            jDateChooser1.setVisible(true);
            jDateChooser2.setVisible(true);
            
            jLabel7.setVisible(false);
            jTextField5.setVisible(false);
            jButton7.setVisible(false);

            jLabel8.setVisible(false);
            jTextField6.setVisible(false);
            jButton8.setVisible(false);

        }
        
        if(vid == 44 || vid == 45)
        {
            jLabel2.setVisible(false);
            jTextField2.setVisible(false);
            jButton2.setVisible(false);
            
            jLabel1.setVisible(false);
            jTextField1.setVisible(false);
            jButton1.setVisible(false);
            
            jLabel5.setVisible(false);
            jTextField3.setVisible(false);
            jButton5.setVisible(false);
            
            jLabel6.setVisible(false);
            jTextField4.setVisible(false);
            jButton6.setVisible(false);
            
            jLabel4.setVisible(true);
            jLabel3.setVisible(true);
            jDateChooser1.setVisible(true);
            jDateChooser2.setVisible(true);
            
            jLabel7.setVisible(false);
            jTextField5.setVisible(false);
            jButton7.setVisible(false);

            jLabel8.setVisible(false);
            jTextField6.setVisible(false);
            jButton8.setVisible(false);

        }
        
        
        
        
        
        
        
        int rg1 = IOOperator.operator.getRabotnikgruppa().getRabotnikgruppa();
        if(rg1!=0)
        {
            RabotnikGruppa r = IORabotnik.getListRabotnikGruppa(rg1).get(0);
            jTextField1.setText(r.getName());
            rg  = r.getRabotnikgruppa();
            jButton1.setEnabled(false);
        }
    }
    int vid;

    int rg = 0;
    int rab = 0;
    int model = 0;
    int tipmodel = 0;
    int sclad = 0;
    int fgruppa = 0;
    Date d1, d2;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Парметры отчета ");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Швейный цех");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Сотрудник");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Дата с");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Дата по");

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField1.setText("Все");

        jTextField2.setEditable(false);
        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField2.setText("Все");

        jDateChooser1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jDateChooser2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("...");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setText("Печать");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton4.setText("Отмена");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Артикул");

        jTextField3.setEditable(false);
        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField3.setText("Все");

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton5.setText("...");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Тип модели");

        jTextField4.setEditable(false);
        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton6.setText("...");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Место хранения");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Группа фурнитуры");

        jTextField5.setEditable(false);
        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField5.setText("Все");

        jTextField6.setEditable(false);
        jTextField6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField6.setText("Все");

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton7.setText("...");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton8.setText("...");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel7)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                            .addComponent(jTextField5)
                            .addComponent(jTextField6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(154, 154, 154)
                                .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(154, 154, 154)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)))
                        .addGap(70, 70, 70)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel6)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel4)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        FGetRabotnikGruppa fg = new FGetRabotnikGruppa(null, true, 1);
        fg.setVisible(true);
        if(fg.getResult())
        {
            RabotnikGruppa r = IORabotnik.getListRabotnikGruppa(fg.getResultValue()).get(0);
            jTextField1.setText(r.getName());
            rg  = r.getRabotnikgruppa();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        FGetRabotnik fg = new FGetRabotnik(null, true, rab, rg);
        fg.setVisible(true);
        if(fg.getResult())
        {
            //ro.setRabotnik(IORabotnik.getListRabotnik(fg.getResultValue()).get(0));
            jTextField2.setText(IORabotnik.getListRabotnik(fg.getResultValue()).get(0).getName());
            rab = fg.getResultValue();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int id = 12;
        switch(vid)
        {
            case 2:
                id = 15;
                break;
            case 3:    
                id = 16;
                break;
            case 4:    
                id = 17;
                break;    
            case 5:    
                id = 20;
                break;        
            case 6:    
                id = 31;
                break;            
            case 7:    
                id = 33;
                break;            
            case 8:    
                id = 32;
                break;                
            case 9:    
                id = 34;
                break;                    
            case 10:    
                id = 35;
                break;                        
            case 11:    
                id = 36;
                break;                            
            case 12:    
                id = 37;
                break;                                
            case 13:    
                id = 38;
                break;                                    
            case 14:    
                id = 39;
                break;                                        
            case 15:    
                id = 40;
                break;                                            
            case 16:    
                id = 41;
                break;                                                
            case 17:    
                id = 43;
                break;                                                    
            case 18:    
                id = 44;
                break;                                                        
            case 19:    
                id = 47;
                break;                                                            
            case 20:    
                id = 48;
                break;                                                                
            case 21:    
                id = 50;
                break;                                                                    
            case 22:    
                id = 53;
                break;                                                                    
            case 23:    
                id = 54;
                break;     
            case 24:    
                id = 55;
                break;         
            case 25:    
                id = 56;
                break;      
            case 26:    
                id = 57;
                break;    
            case 27:    
                id = 58;
                break;        
            case 28:    
                id = 59;
                break;            
            case 29:    
                id = 60;
                break;     
            case 30:    
                id = 61;
                break;         
            case 31:    
                id = 62;
                break;             
            case 32:    
                id = 63;
                break;                 
            case 33:    
                id = 65;
                break;                     
            case 34:    
                id = 66;
                break;                         
            case 35:    
                id = 67;
                break;                             
            case 36:    
                id = 68;
                break;                                 
            case 37:    
                id = 69;
                break;                                     
            case 38:    
                id = 70;
                break;                                         
            case 39:    
                id = 71;
                break;                                             
            case 40:    
                id = 75;
                break;                                                 
            case 41:    
                id = 76;
                break;                                                     
            case 42:    
                id = 77;
                break;                                                         
            case 43:    
                id = 78;
                break;                                                             
           case 44:    
                id = 81;
                break;      
           case 45:    
                id = 82;
                break;           
           case 46:    
                id = 83;
                break;      
           case 47:    
                id = 84;
                break;           
           case 48:    
                id = 85;
                break;                
           case 49:    
                id = 86;
                break;                     
                
        }
        PrintReport pr = new PrintReport(null, true, id, 0);
        pr.setMap1(rg, rab, jDateChooser1.getDate(), jDateChooser2.getDate(), model, tipmodel, sclad, fgruppa);
        pr.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        setLocationRelativeTo(null);
        if(vid == 17)
        {
            jButton3ActionPerformed(null);
        }
        
        if(vid == 40)
        {
            jButton3ActionPerformed(null);
        }
    }//GEN-LAST:event_formWindowOpened

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        FGetModel fg= new FGetModel(null, true, model);
        int w,h;
        w = Toolkit.getDefaultToolkit ().getScreenSize().width-20;
        h = Toolkit.getDefaultToolkit ().getScreenSize().height-50;        
        fg.setSize(w, h);
        fg.setVisible(true);
        if(fg.getResult())
        {
            model = fg.getResultValue();
            jTextField3.setText(IOModel.getListModel(fg.getResultValue(), -1, true).get(0).getArticle());
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        FGetTipModeli fg = new FGetTipModeli(null, true, tipmodel);
        fg.setVisible(true);
        if(fg.getResult())
        {
            tipmodel = fg.getResultValue();//.setTipmodel(IOTipModel.getListTipModel(fg.getResultValue()).get(0));
            jTextField4.setText(IOTipModel.getListTipModel(fg.getResultValue()).get(0).getName());
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        FGetSclad fg = new FGetSclad(null, true, 0);
        fg.setVisible(true);
        if(fg.getResult())
        {
            sclad = fg.getResultValue();            
            jTextField5.setText(IOSclad.getListSclad(fg.getResultValue()).get(0).getName());
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        FGetGruppaProduct fg = new FGetGruppaProduct(null, true, 2);
        fg.setVisible(true);
        if(fg.getResult())
        {
            fgruppa = fg.getResultValue();            
            jTextField6.setText(IOProduct.getListProductGruppa(fg.getResultValue(), 0).get(0).getName());
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FParamReportPrintRabotnik.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FParamReportPrintRabotnik.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FParamReportPrintRabotnik.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FParamReportPrintRabotnik.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                FParamReportPrintRabotnik dialog = new FParamReportPrintRabotnik(new javax.swing.JFrame(), true, 0);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
