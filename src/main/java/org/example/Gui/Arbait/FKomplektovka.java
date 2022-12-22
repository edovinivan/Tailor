/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Arbait;

import org.example.Gui.Arbait.Model.ModelZadachaKomplektovkaFurnitura;
import org.example.Gui.Arbait.Model.ModelZadachaKomplektovkaRazmeri;
import org.example.Gui.Form.Helps.FGetColor;
import org.example.Gui.Form.Helps.FGetModel;
import org.example.Gui.Form.Helps.FGetRabotnik;
import org.example.Gui.Form.Helps.FGetZadacha;
import java.awt.Toolkit;
import java.util.Date;
import javax.swing.JOptionPane;
import org.example.logic.Color;
import org.example.logic.Model;
import org.example.logic.Rabotnik;
import org.example.logic.RabotnikGruppa;
import org.example.logic.Sclad;
import org.example.logic.Zadacha;
import org.example.logic.ZadachaKomplektovka;
import org.example.util.HelpClass;
import org.example.util.IOColor;
import org.example.util.IOModel;
import org.example.util.IOOperator;
import org.example.util.IORabotnik;
import org.example.util.IOZadacha;
import org.example.util.IOZadachaKomplektovka;

/**
 *
 * @author ivan
 */
public class FKomplektovka extends javax.swing.JDialog {

    /**
     * Creates new form FKomplektovka
     * @param parent
     * @param modal
     * @param z - номер задачи
     * @param zk - номер комплектовки     
     * @param rab  - работник   
     * @param vid_rb  - вир работ
     *  0 - комплектовка
     *  1 - добавление фурнитуры
     * @param ha - ручной стол
     */
    public FKomplektovka(java.awt.Frame parent, boolean modal, int z, int zk, int rab, int vid_rb, int ha) {
        super(parent, modal);
        initComponents();
        setVisibleDopOdel(false);
        hand = ha;
        jButton11.setVisible(false);
        
        jLabel14.setVisible(false);
        jTextField13.setVisible(false);
        jButton12.setVisible(false);
        
        if(z>0)
        {
            jButton4.setVisible(false);
            jButton12.setVisible(false);
        }
        //если новая комплектовка
        if(zk==0)
        {
            zkom = new ZadachaKomplektovka();
            zkom.setChek(new RabotnikGruppa(0));
            zkom.setRabotnik(new Rabotnik(rab));
            zkom.setZadacha(new Zadacha(z));
            zkom.setZadachakomplektovka(0);
            zkom.setColor(new Color(0));
            zkom.setModel(new Model(0));
            zkom.setSclad(new Sclad(0));
            
            if(rab!=0)
            {
                zkom.setRabotnik(IORabotnik.getListRabotnik(rab).get(0));
                jTextField1.setText(zkom.getRabotnik().getName());
                jButton3.setEnabled(false);
            }            
            
            // на будущее
            zkom.setBrak(0);
            zkom.setBraktext("");
            zkom.setDataend(new Date());
            zkom.setDataget(new Date());
            zkom.setDatareturn(new Date());
            zkom.setDatasclad(new Date());
            zkom.setDatasend(new Date());
            zkom.setQtysclad(0);
            zkom.setBrak1(0);
            zkom.setBrak1text("");
            zkom.setCsale(0);
            zkom.setNastil(new Rabotnik(0));
            zkom.setRezak(new Rabotnik(0));
            zkom.setZadacha2(new Zadacha(0));
            
            jDateChooser1.setDate(new Date());
            jButton5.setEnabled(false);
            
            /*if(z>0)
            {            
                jTextField3.setText(IOZadacha.getListZadacha(z, -1).get(0).getNomer() + "/" + (IOZadachaKomplektovka.getListZadachaKomplektovka(z, -1).size()+1));
                saveZK();
                IOZadachaKomplektovka.copyRazmeriForKomplektovka(zkom.getZadachakomplektovka(), z);            
                jTextField2.setText(zkom.getZadacha().getNomer());
            }*/
        }
        else
        {
            zkom = IOZadachaKomplektovka.getListZadachaKomplektovka(0, zk).get(0);
            jTextField1.setText(zkom.getRabotnik().getName());
            jTextField2.setText(zkom.getZadacha().getNomer());
            jTextField3.setText(zkom.getNomer());
            jDateChooser1.setDate(zkom.getDates());   
            jTextField8.setText(zkom.getColor().getName());
            jTextField9.setText(zkom.getModel().getArticle());
            jTextField10.setText(zkom.getZtext());
            jButton6.setEnabled(false);
            jTextField11.setText(zkom.getNastil().getName());
            jTextField12.setText(zkom.getRezak().getName());
            jTextField13.setText(zkom.getZadacha2().getNomer());
            
            // если это комплектовка подкроя
            if(zkom.getZadacha().getDel()==2)
            {
                setVisibleDopOdel(true);
                if(zkom.getStatus()>0)
                {
                    jButton9.setEnabled(false);
                    jButton10.setEnabled(false);
                    jButton12.setEnabled(false);
                }
                else
                {
                    if (IOOperator.getSetupOperator(7) < 2)
                    {
                        jButton9.setEnabled(false);
                        jButton10.setEnabled(false);
                        jButton12.setEnabled(false);
                    }
                }
            }
            
            // если закрыто
            if(zkom.getStatus()==1)
            {
                jButton1.setEnabled(false);
                jButton3.setEnabled(false);
                jButton4.setEnabled(false);
                
                model1.setStop();
                
                
                //jButton5.setEnabled(false);
                
                //если открываем для фурнитуры
                if(vid_rb==1)
                {
                    if (IOOperator.getSetupOperator(8) == 2) 
                    {
                        jButton5.setEnabled(true);
                        //jButton6.setEnabled(true);
                    }
                }
                else
                {
                    if(IOOperator.getSetupOperator(49)==2)
                        jButton11.setVisible(true);
                }
                
                
            }
            else
            {
                if(zkom.getStatus()==0)
                {         
                    jButton6.setEnabled(true);                    
                    if (IOOperator.getSetupOperator(7) < 2) 
                    {
                        jButton1.setEnabled(false);
                        jButton3.setEnabled(false);
                        jButton4.setEnabled(false);
                        jButton6.setEnabled(false);                    
                    }
                }
                if(zkom.getStatus()>1)
                {
                    jButton1.setEnabled(false);
                    jButton3.setEnabled(false);
                    jButton4.setEnabled(false);
                    //jButton6.setEnabled(false);
                }
                
                //если открываем не для фурнитуры
                if(vid_rb!=1)
                {
                    if(IOOperator.getSetupOperator(49)==2)
                        jButton11.setVisible(true);                    
                }                
            }
            //jButton6.setEnabled(false);
            jButton4.setEnabled(false);
            jButton8.setEnabled(false);
            if(zkom.getStatus()<1)
                jButton5.setEnabled(false);
        }
    }
    
    int hand;
    ZadachaKomplektovka zkom;
    ModelZadachaKomplektovkaRazmeri model1 = new ModelZadachaKomplektovkaRazmeri();
    ModelZadachaKomplektovkaFurnitura model2 = new ModelZadachaKomplektovkaFurnitura();

    private void setVisibleDopOdel(boolean f)
    {
        jLabel12.setVisible(f);
        jLabel13.setVisible(f);
        jTextField11.setVisible(f);
        jTextField12.setVisible(f);
        jButton10.setVisible(f);
        jButton9.setVisible(f);
        
        jLabel14.setVisible(f);
        jTextField13.setVisible(f);
        jButton12.setVisible(f);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButton5 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jButton12 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Комплектовка");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Сохранить");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("Отмена");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Комплектовщик");

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setText("...");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Задача");

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton4.setText("...");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTextField2.setEditable(false);
        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Размеры"));
        jPanel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jScrollPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setRowHeight(26);
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jTable1ComponentResized(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton7.setText("Все");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Номер");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Фурнитура"));
        jPanel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTable4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable4.setRowHeight(26);
        jTable4.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable4.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jTable4ComponentResized(evt);
            }
        });
        jScrollPane4.setViewportView(jTable4);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Клеевая");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Шаблон");

        jTextField4.setEditable(false);
        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextField5.setEditable(false);
        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Детали с принтом");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Детали с вышивкой");

        jTextField6.setEditable(false);
        jTextField6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextField7.setEditable(false);
        jTextField7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Дата");

        jDateChooser1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton5.setText("Выбрать");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Цвет");

        jTextField8.setEditable(false);
        jTextField8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField8.setText("НЕТ");

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton6.setText("...");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Артикул");

        jTextField9.setEditable(false);
        jTextField9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButton8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton8.setText("...");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Комментарий");

        jTextField10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Настильщик");

        jTextField11.setEditable(false);
        jTextField11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButton9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton9.setText("...");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Резчик");

        jTextField12.setEditable(false);
        jTextField12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButton10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton10.setText("...");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton11.setText("Изменить");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Задача 2");

        jTextField13.setEditable(false);
        jTextField13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButton12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton12.setText("...");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel8))
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel14))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                                    .addComponent(jTextField9)
                                    .addComponent(jTextField13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton11))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(418, 418, 418)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addGap(30, 30, 30)
                .addComponent(jTextField10))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addGap(1, 1, 1)
                .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jButton1)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButton2)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel14)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton12))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel10)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8)
                    .addComponent(jButton11))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel12)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9)
                    .addComponent(jLabel13)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel5)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel6)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel7)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel9)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addGap(5, 5, 5)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        int w,h;
        w = Toolkit.getDefaultToolkit ().getScreenSize().width-20;
        h = Toolkit.getDefaultToolkit ().getScreenSize().height-50;
        setSize(w,h);      
        setLocationRelativeTo(null);
        model1.setData(zkom.getZadachakomplektovka());
        
        model1.setModel2(model2);
        model1.setPanel(jPanel1);
        
        jTable1.setModel(model1);
        jTable1.setShowGrid(true);                    
        jTable1.getTableHeader().setReorderingAllowed(false);   
        
        model2.getNullData(zkom.getZadacha().getZadacha());
        model2.setData(model1.getQty());
        model2.setQtyData(zkom.getZadachakomplektovka());
        
        
        jTable4.setModel(model2);
        jTable4.setShowGrid(true);                    
        jTable4.getTableHeader().setReorderingAllowed(false);   
        
        if(zkom.getModel().getModel()>0)
        {
            jTextField4.setText(IOZadachaKomplektovka.getParamModel(zkom.getModel().getModel(), 1));
            jTextField5.setText(IOZadachaKomplektovka.getParamModel(zkom.getModel().getModel(), 4));
            jTextField6.setText(IOZadachaKomplektovka.getParamModel(zkom.getModel().getModel(), 2));
            jTextField7.setText(IOZadachaKomplektovka.getParamModel(zkom.getModel().getModel(), 3));
        }
        //jTable1.getColumnModel().getColumn(1).setCellRenderer(model.jTableRenderer);
        jTable1ComponentResized(null);
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Размеры ("+ model1.getQty()+")"));
    }//GEN-LAST:event_formWindowOpened

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        //if(zkom.getZadachakomplektovka()== 0)
        //    saveZK();
        FGetRabotnik fg = new FGetRabotnik(null, true, zkom.getRabotnik().getRabotnik(), 6);
        fg.setVisible(true);
        if(fg.getResult())
        {
            zkom.setRabotnik(IORabotnik.getListRabotnik(fg.getResultValue()).get(0));
            jTextField1.setText(zkom.getRabotnik().getName());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        /*if(zkom.getChek().getRabotnikgruppa() == 0)
        {
            JOptionPane.showMessageDialog(null, "Выберите цех назначения.");
            return;
        }*/
        
        if(zkom.getRabotnik().getRabotnik() == 0)
        {
            JOptionPane.showMessageDialog(null, "Выберите комплектовщика.");
            return;
        }
        
        if(zkom.getColor().getColor() == 0)
        {
            JOptionPane.showMessageDialog(null, "Выберите цвет.");
            return;
        }
        
        //System.out.println(">>>>>> " + jTextField3.getText());
        if(!HelpClass.checkTextForName(jTextField3.getText()))
        {
            JOptionPane.showMessageDialog(null, "Введите номер");
            return;
        }   
        // если это комплектовка подкроя
        if(zkom.getZadacha().getDel()==2)
        {
            if(zkom.getRezak().getRabotnik()==0)
            {
                JOptionPane.showMessageDialog(null, "Выберите резчика");
                return;
            }
            if(zkom.getNastil().getRabotnik()==0)
            {
                JOptionPane.showMessageDialog(null, "Выберите настильщика");
                return;
            }
            
        }
        saveZK();
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTable1ComponentResized
        // TODO add your handling code here:
        if(jTable1.getColumnCount()<=0)
            return;
        int h = (jTable1.getWidth()-30)/2;
        
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(0);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(0).setMinWidth(0);
        
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(30);  
        
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(h);  
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(h);  
        
    }//GEN-LAST:event_jTable1ComponentResized

    private void jTable4ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTable4ComponentResized
        // TODO add your handling code here:
        if(jTable4.getColumnCount()<=0)
            return;
        int h = (jTable4.getWidth()-100)/2;
        
        jTable4.getColumnModel().getColumn(0).setPreferredWidth(0);
        jTable4.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable4.getColumnModel().getColumn(0).setMinWidth(0);
        
        jTable4.getColumnModel().getColumn(1).setPreferredWidth(h);  
        jTable4.getColumnModel().getColumn(2).setPreferredWidth(h);  
        jTable4.getColumnModel().getColumn(3).setPreferredWidth(80);  
        jTable4.getColumnModel().getColumn(4).setPreferredWidth(30);  
    }//GEN-LAST:event_jTable4ComponentResized

    /**
     * выбор задачи
     * @param evt 
     */
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        FGetZadacha f = new FGetZadacha(null, true, zkom.getZadacha().getZadacha(), hand);
        f.setVisible(true);
        if(f.getResult())
        {
            zkom.setZadacha(IOZadacha.getListZadacha(f.getResultValue(), -1).get(0));
            zkom.setModel(zkom.getZadacha().getModel());
            jTextField2.setText(zkom.getZadacha().getNomer());
            jTextField3.setText(zkom.getZadacha().getNomer() + "/" + (IOZadachaKomplektovka.getListZadachaKomplektovka(zkom.getZadacha().getZadacha(), -1).size()+1));
            saveZK();
            IOZadachaKomplektovka.copyRazmeriForKomplektovka(zkom.getZadachakomplektovka(), zkom.getZadacha().getZadacha(), zkom.getModel().getModel());            
            model1.setData(zkom.getZadachakomplektovka());
        
            model2.getNullData(zkom.getZadacha().getZadacha());
            model2.setData(model1.getQty());
            
            /*jTextField4.setText(IOZadachaKomplektovka.getParamModel(zkom.getZadacha().getZadacha(), 1));
            jTextField5.setText(IOZadachaKomplektovka.getParamModel(zkom.getZadacha().getZadacha(), 4));
            jTextField6.setText(IOZadachaKomplektovka.getParamModel(zkom.getZadacha().getZadacha(), 2));
            jTextField7.setText(IOZadachaKomplektovka.getParamModel(zkom.getZadacha().getZadacha(), 3));*/
            
            jTextField4.setText(IOZadachaKomplektovka.getParamModel(zkom.getModel().getModel(), 1));
            jTextField5.setText(IOZadachaKomplektovka.getParamModel(zkom.getModel().getModel(), 4));
            jTextField6.setText(IOZadachaKomplektovka.getParamModel(zkom.getModel().getModel(), 2));
            jTextField7.setText(IOZadachaKomplektovka.getParamModel(zkom.getModel().getModel(), 3));
            
            jTextField9.setText(zkom.getModel().getArticle());
            
            jButton4.setEnabled(false);
            jButton8.setEnabled(false);
            jButton2.setEnabled(false);
        }
       
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        int h = jTable4.getSelectedRow();
        if(h==-1) return;
        LKomplektovkaFurnitura lk = new LKomplektovkaFurnitura(null, true, zkom.getZadachakomplektovka(), (int)jTable4.getValueAt(h, 0));
        lk.setTitle("Подбор фурнитуры со склада для ("+jTable4.getValueAt(h, 1)+")");
        lk.setVisible(true);
        model2.setQtyData(zkom.getZadachakomplektovka());
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * Выбор цвета
     * @param evt 
     */
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        if(zkom.getZadachakomplektovka()==0)
            return;
        // если это комплектовка подкроя то выберем цвет из справочника
        /*if(zkom.getZadacha().getDel()==2)
        {
            return;
        }*/
        FGetColor f = new FGetColor(null, true, zkom.getColor().getColor(), 1);
        //if(zkom.getZadacha().getDel()!=2)
        //    f.colorForKomplektovka(zkom.getZadachakomplektovka());
        f.setVisible(true);
        
        if(f.getResult())
        {
            zkom.setColor(IOColor.getListColor(f.getResultValue(), 0).get(0));
            jTextField8.setText(zkom.getColor().getName());
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        String h = JOptionPane.showInputDialog(null, "Кол-во", "1");
        if(HelpClass.checkTextForInt(h))
        {
            model1.setSelectDataForRow(Integer.parseInt(h));
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    // выбор модели для комплектовки
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        FGetModel fg= new FGetModel(null, true, zkom.getModel().getModel(), false);
        fg.setSize(getWidth(), getHeight());
        fg.setVisible(true);
        if(fg.getResult())
        {
            zkom.setZadacha(IOZadachaKomplektovka.createZadachaForModel(fg.getResultValue(), hand));
            zkom.setModel(IOModel.getListModel(fg.getResultValue(), -1, true).get(0));
            
            zkom.setColor(IOModel.getHauptColorForProductModel(zkom.getModel().getModel()));
            
            jTextField2.setText(zkom.getZadacha().getNomer());
            jTextField3.setText("КП/"+zkom.getModel().getArticle()+ "/" + zkom.getZadacha().getNomer());
            saveZK();
            
            IOZadachaKomplektovka.copyRazmeriForKomplektovka(zkom.getZadachakomplektovka(), zkom.getZadacha().getZadacha(), zkom.getModel().getModel());            
            model1.setData(zkom.getZadachakomplektovka());
        
            model2.getNullData(zkom.getZadacha().getZadacha());
            model2.setData(model1.getQty());
                        
            
            jTextField4.setText(IOZadachaKomplektovka.getParamModel(zkom.getModel().getModel(), 1));
            jTextField5.setText(IOZadachaKomplektovka.getParamModel(zkom.getModel().getModel(), 4));
            jTextField6.setText(IOZadachaKomplektovka.getParamModel(zkom.getModel().getModel(), 2));
            jTextField7.setText(IOZadachaKomplektovka.getParamModel(zkom.getModel().getModel(), 3));
            
            jTextField9.setText(zkom.getModel().getArticle());
            
            jButton4.setEnabled(false);
            jButton8.setEnabled(false);
            
            
            jTextField8.setText(zkom.getColor().getName());
            //jButton6.setEnabled(false);
            jButton2.setEnabled(false);
            setVisibleDopOdel(true);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        FGetRabotnik fg = new FGetRabotnik(null, true, zkom.getNastil().getRabotnik(), 4);
        fg.setVisible(true);
        if(fg.getResult())
        {
            zkom.setNastil(IORabotnik.getListRabotnik(fg.getResultValue()).get(0));
            jTextField11.setText(zkom.getNastil().getName());
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        FGetRabotnik fg = new FGetRabotnik(null, true, zkom.getRezak().getRabotnik(), 5);
        fg.setVisible(true);
        if(fg.getResult())
        {
            zkom.setRezak(IORabotnik.getListRabotnik(fg.getResultValue()).get(0));
            jTextField12.setText(zkom.getRezak().getName());
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        FGetModel fg= new FGetModel(null, true, zkom.getModel().getModel());
        fg.setSize(getWidth(), getHeight());
        fg.setVisible(true);
        if(fg.getResult())
        {
            Model mmm = IOModel.getListModel(fg.getResultValue(), 0, true).get(0);
            if (JOptionPane.showConfirmDialog(null, "Вы действительно хотите изменить конфекционную карту с  <" + zkom.getModel().getArticle() + "> на <"+mmm.getArticle()+">?", "Вопрос.", JOptionPane.YES_NO_OPTION) == 0) 
            {
                zkom.setModel(mmm);
                IOZadachaKomplektovka.setZadachaKomplektovka(zkom);
                jTextField9.setText(zkom.getModel().getArticle());
            }
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        FGetZadacha f = new FGetZadacha(null, true, zkom.getZadacha2().getZadacha(), hand);
        f.setVisible(true);
        if(f.getResult())
        {
            Zadacha z2 = IOZadacha.getListZadacha(f.getResultValue(), -1).get(0);
            jTextField13.setText(z2.getNomer());         
            zkom.setZadacha2(z2);
        }
    }//GEN-LAST:event_jButton12ActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FKomplektovka.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                FKomplektovka dialog = new FKomplektovka(new javax.swing.JFrame(), true, 0 ,0, 0, 0, 0);
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
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables

    private void saveZK()
    {
        zkom.setDates(jDateChooser1.getDate());
        zkom.setNomer(jTextField3.getText());
        zkom.setZtext(jTextField10.getText());
        zkom.setStatus(0);
        //zkom.setCsale(0);
        zkom = IOZadachaKomplektovka.setZadachaKomplektovka(zkom);
    }
    
    
}
