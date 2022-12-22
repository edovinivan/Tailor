/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Form;

import org.example.Gui.Form.Helps.FGetKleevaya;
import org.example.Gui.Form.Helps.FGetPrintDetali;
import org.example.Gui.Form.Helps.FGetProductForModel;
import org.example.Gui.Form.Helps.FGetRazmeri;
import org.example.Gui.Form.Helps.FGetSablon;
import org.example.Gui.Form.Helps.FGetTipModeli;
import org.example.Gui.model.ModelRabotnikGruppa;
import org.example.Gui.model.ModelRabotnikGruppa1;
import org.example.Gui.model.model.ModelFilesModel;
import org.example.Gui.model.model.ModelKleevayaModel;
import org.example.Gui.model.model.ModelPrintDetaliModel;
import org.example.Gui.model.model.ModelProductModel;
import org.example.Gui.model.model.ModelSablonModel;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.example.logic.Files;
import org.example.logic.Kleevaya;
import org.example.logic.Model;
import org.example.logic.ModelFiles;
import org.example.logic.ModelKleevaya;
import org.example.logic.ModelPrintDetali;
import org.example.logic.ModelSablon;
import org.example.logic.PrintDetali;
import org.example.logic.Raskladchik;
import org.example.logic.Razmeri;
import org.example.logic.Sablon;
import org.example.logic.TipModel;
import org.example.util.HelpClass;
import org.example.util.IOFiles;
import org.example.util.IOModel;
import org.example.util.IOOperator;
import org.example.util.IORaskladchik;
import org.example.util.IORazmeri;
import org.example.util.IOTipModel;

/**
 *
 * @author ivan
 */
public class FModel extends javax.swing.JDialog {

    /**
     * Creates new form FModel
     * @param parent
     * @param modal
     * @param m - модель
     * @param width - Ширина
     * @param hai - высота
     */
    public FModel(java.awt.Frame parent, boolean modal, int m,  int width, int hai) {
        super(parent, modal);
        initComponents();
        setSize(width, hai);
        loadNullValue();
        model.setModel(m);
        model.setHmodel(new Model(0));
        model.setTipmodel(new TipModel(0));
        model.setFirstrazmeri(new Razmeri(0));
        model.setEndrazmeri(new Razmeri(0));
        model.setRaskladchik(new Raskladchik(0));
        model.setRaskladchik1(new Raskladchik(0));
        model.setTextsite("");
        model.setStatus(0);
        
        model.setPm1(BigDecimal.ZERO);
        model.setPm1_1(BigDecimal.ZERO);
        model.setPm1_2(BigDecimal.ZERO);
        model.setPm1_3(BigDecimal.ZERO);
        model.setPm1_4(BigDecimal.ZERO);
        model.setPm1_5(BigDecimal.ZERO);
        model.setPm1_6(BigDecimal.ZERO);
        model.setPm1_7(BigDecimal.ZERO);
        model.setPm1_8(BigDecimal.ZERO);
        model.setPm1_9(BigDecimal.ZERO);
        model.setPm2(BigDecimal.ONE);
        model.setPm2_1(BigDecimal.ZERO);
        model.setPm2_2(BigDecimal.ZERO);
        model.setPm2_3(BigDecimal.ZERO);
        model.setPm2_4(BigDecimal.ZERO);
        model.setPm2_5(BigDecimal.ZERO);
        model.setPm2_6(BigDecimal.ZERO);
        model.setPm2_7(BigDecimal.ZERO);
        model.setPm2_8(BigDecimal.ZERO);
        model.setPm2_9(BigDecimal.ZERO);
        
        model.setPm3(0);
        model.setPm3_1(0);
        model.setPm3_2(0);
        model.setPm3_3(0);
        model.setPm3_4(0);
        model.setPm3_5(0);
        model.setPm3_6(0);
        model.setPm3_7(0);
        model.setPm3_8(0);
        model.setPm3_9(0);
        
        model.setPm4(0);
        
        
        if(m>0)
            loadModel();
        if(m==0)
        {
            jLabel13.setVisible(false);
            jTextField9.setVisible(false);
            jButton32.setVisible(false);
        }
        if(IOOperator.getSetupOperator(47)<2)
        {
            jLabel13.setVisible(false);
            jTextField9.setVisible(false);
            jButton32.setVisible(false);
        }
    }

    Model model = new Model();
    ModelProductModel modelProduct = new ModelProductModel(1);
    ModelProductModel modelFurnitura = new ModelProductModel(2);
    ModelPrintDetaliModel modelPrintDetali = new ModelPrintDetaliModel(2);
    ModelPrintDetaliModel modelPrintDetali1 = new ModelPrintDetaliModel(1);
    ModelPrintDetaliModel modelPrintDetali3 = new ModelPrintDetaliModel(3);
    ModelSablonModel modelSablon = new ModelSablonModel();
    ModelKleevayaModel modelKleevaya = new ModelKleevayaModel();
    ModelFilesModel modelFiles = new ModelFilesModel();
    ModelRabotnikGruppa1 modelChex = new ModelRabotnikGruppa1();
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jToolBar2 = new javax.swing.JToolBar();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jToolBar3 = new javax.swing.JToolBar();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jToolBar4 = new javax.swing.JToolBar();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jToolBar5 = new javax.swing.JToolBar();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jToolBar6 = new javax.swing.JToolBar();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jToolBar7 = new javax.swing.JToolBar();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jButton36 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable8 = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        jToolBar8 = new javax.swing.JToolBar();
        jButton33 = new javax.swing.JButton();
        jButton35 = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable9 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jComboBox4 = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton25 = new javax.swing.JButton();
        jTextField5 = new javax.swing.JTextField();
        jButton26 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jButton28 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jButton32 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Конфекционная карта");
        setPreferredSize(new java.awt.Dimension(800, 600));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Фотография"));
        jPanel1.setMaximumSize(new java.awt.Dimension(283, 250));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
        );

        jButton7.setText("Загрузить фотографию");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Сохранить");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Отмена");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jTabbedPane1.setToolTipText("");

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setRowHeight(26);
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jTable1ComponentResized(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        jButton1.setText("Добавить");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        jButton2.setText("Изменить");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/remove.png"))); // NOI18N
        jButton3.setText("Удалить");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Материалы", jPanel8);

        jToolBar2.setFloatable(false);
        jToolBar2.setRollover(true);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        jButton4.setText("Добавить");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton4);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        jButton5.setText("Изменить");
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton5);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/remove.png"))); // NOI18N
        jButton6.setText("Удалить");
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton6);

        jTable2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable2.setRowHeight(26);
        jTable2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jTable2.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jTable2ComponentResized(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Детали с вышивкой", jPanel5);

        jToolBar3.setFloatable(false);
        jToolBar3.setRollover(true);

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        jButton10.setText("Добавить");
        jButton10.setFocusable(false);
        jButton10.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton10.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jToolBar3.add(jButton10);

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        jButton11.setText("Изменить");
        jButton11.setFocusable(false);
        jButton11.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton11.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jToolBar3.add(jButton11);

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/remove.png"))); // NOI18N
        jButton12.setText("Удалить");
        jButton12.setFocusable(false);
        jButton12.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton12.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jToolBar3.add(jButton12);

        jTable3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable3.setRowHeight(26);
        jTable3.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jTable3.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jTable3ComponentResized(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jToolBar3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Детали с принтом", jPanel6);

        jToolBar4.setFloatable(false);
        jToolBar4.setRollover(true);

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        jButton13.setText("Добавить");
        jButton13.setFocusable(false);
        jButton13.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton13.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jToolBar4.add(jButton13);

        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        jButton14.setText("Изменить");
        jButton14.setFocusable(false);
        jButton14.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton14.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jToolBar4.add(jButton14);

        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/remove.png"))); // NOI18N
        jButton15.setText("Удалить");
        jButton15.setFocusable(false);
        jButton15.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton15.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jToolBar4.add(jButton15);

        jTable4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable4.setRowHeight(26);
        jTable4.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable4MouseClicked(evt);
            }
        });
        jTable4.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jTable4ComponentResized(evt);
            }
        });
        jScrollPane4.setViewportView(jTable4);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jToolBar4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(207, 207, 207))
        );

        jTabbedPane1.addTab("Фурнитура", jPanel7);

        jToolBar5.setFloatable(false);
        jToolBar5.setRollover(true);

        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        jButton16.setText("Добавить");
        jButton16.setFocusable(false);
        jButton16.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton16.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jToolBar5.add(jButton16);

        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        jButton17.setText("Изменить");
        jButton17.setFocusable(false);
        jButton17.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton17.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        jToolBar5.add(jButton17);

        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/remove.png"))); // NOI18N
        jButton18.setText("Удалить");
        jButton18.setFocusable(false);
        jButton18.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton18.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        jToolBar5.add(jButton18);

        jButton30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/up.png"))); // NOI18N
        jButton30.setText("+1");
        jButton30.setFocusable(false);
        jButton30.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton30.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });
        jToolBar5.add(jButton30);

        jButton31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/down.png"))); // NOI18N
        jButton31.setText("-1");
        jButton31.setFocusable(false);
        jButton31.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton31.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });
        jToolBar5.add(jButton31);

        jTable5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable5.setRowHeight(26);
        jTable5.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable5MouseClicked(evt);
            }
        });
        jTable5.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jTable5ComponentResized(evt);
            }
        });
        jScrollPane5.setViewportView(jTable5);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jToolBar5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jTabbedPane1.addTab("Шаблоны", jPanel3);

        jToolBar6.setFloatable(false);
        jToolBar6.setRollover(true);

        jButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        jButton19.setText("Добавить");
        jButton19.setFocusable(false);
        jButton19.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton19.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        jToolBar6.add(jButton19);

        jButton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        jButton20.setText("Изменить");
        jButton20.setFocusable(false);
        jButton20.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton20.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });
        jToolBar6.add(jButton20);

        jButton21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/remove.png"))); // NOI18N
        jButton21.setText("Удалить");
        jButton21.setFocusable(false);
        jButton21.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton21.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        jToolBar6.add(jButton21);

        jButton27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/up.png"))); // NOI18N
        jButton27.setText("+1");
        jButton27.setFocusable(false);
        jButton27.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton27.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });
        jToolBar6.add(jButton27);

        jButton29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/down.png"))); // NOI18N
        jButton29.setText("-1");
        jButton29.setFocusable(false);
        jButton29.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton29.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });
        jToolBar6.add(jButton29);

        jTable6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable6.setRowHeight(26);
        jTable6.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable6MouseClicked(evt);
            }
        });
        jTable6.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jTable6ComponentResized(evt);
            }
        });
        jScrollPane6.setViewportView(jTable6);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jToolBar6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jTabbedPane1.addTab("Клеевая", jPanel4);

        jToolBar7.setFloatable(false);
        jToolBar7.setRollover(true);

        jButton22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        jButton22.setText("Добавить");
        jButton22.setFocusable(false);
        jButton22.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton22.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });
        jToolBar7.add(jButton22);

        jButton23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/remove.png"))); // NOI18N
        jButton23.setText("Удалить");
        jButton23.setFocusable(false);
        jButton23.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton23.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });
        jToolBar7.add(jButton23);

        jButton24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/2.png"))); // NOI18N
        jButton24.setText("Главная");
        jButton24.setFocusable(false);
        jButton24.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton24.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });
        jToolBar7.add(jButton24);

        jButton34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/down.png"))); // NOI18N
        jButton34.setText("В файл");
        jButton34.setFocusable(false);
        jButton34.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton34.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });
        jToolBar7.add(jButton34);

        jButton36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh.png"))); // NOI18N
        jButton36.setText("Заменить");
        jButton36.setFocusable(false);
        jButton36.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton36.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton36ActionPerformed(evt);
            }
        });
        jToolBar7.add(jButton36);

        jTable7.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTable7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable7.setRowHeight(26);
        jTable7.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable7MouseClicked(evt);
            }
        });
        jTable7.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jTable7ComponentResized(evt);
            }
        });
        jScrollPane7.setViewportView(jTable7);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jToolBar7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Фотографии", jPanel2);

        jTable8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable8.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable8.setRowHeight(26);
        jTable8.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable8.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jTable8ComponentResized(evt);
            }
        });
        jScrollPane8.setViewportView(jTable8);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Цеха", jPanel9);

        jToolBar8.setFloatable(false);
        jToolBar8.setRollover(true);

        jButton33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        jButton33.setText("Добавить");
        jButton33.setFocusable(false);
        jButton33.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton33.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });
        jToolBar8.add(jButton33);

        jButton35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/remove.png"))); // NOI18N
        jButton35.setText("Удалить");
        jButton35.setFocusable(false);
        jButton35.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton35.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35ActionPerformed(evt);
            }
        });
        jToolBar8.add(jButton35);

        jTable9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable9.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable9.setRowHeight(26);
        jTable9.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable9.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jTable9ComponentResized(evt);
            }
        });
        jScrollPane9.setViewportView(jTable9);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jToolBar8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                .addGap(8, 8, 8))
        );

        jTabbedPane1.addTab("ТермоПечать", jPanel10);

        jLabel1.setText("Артикул");

        jLabel2.setText("Дата");

        jLabel3.setText("Тип модели");

        jLabel4.setText("1 размер");

        jLabel5.setText("Раскладчик 1");

        jLabel6.setText("Раскладчик 2");

        jComboBox3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jComboBox4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel7.setText("Норма расхода бейки");

        jLabel8.setText("Название");

        jTextField4.setEditable(false);

        jButton25.setText("...");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        jTextField5.setEditable(false);

        jButton26.setText("...");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        jLabel10.setText("Пояснение");

        jTextField7.setEditable(false);

        jLabel11.setText("Последний размер");

        jButton28.setText("...");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });

        jLabel12.setText("Ответственный");

        jLabel13.setText("Цена 1 изделия");

        jTextField9.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField9.setText("0");

        jButton32.setText("Сохранить");
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });

        jLabel14.setText("Главный артикул");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jTextField4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jButton7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(jButton8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextField6)
                                        .addGap(13, 13, 13))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jTextField7, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboBox3, javax.swing.GroupLayout.Alignment.LEADING, 0, 183, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton26)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jTabbedPane1)))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField10)
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton26))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton25)
                    .addComponent(jLabel11)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton28))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel8)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel12)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton32)
                    .addComponent(jLabel14)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Тип полотна");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        setLocationRelativeTo(null);
        // товары 
        modelProduct.setData(model.getModel());
        jTable1.setModel(modelProduct);
        jTable1.setShowGrid(true);                    
        jTable1.getTableHeader().setReorderingAllowed(false);   
        jTable1ComponentResized(null);
        jTabbedPane1.setTitleAt(0, "Материалы<"+modelProduct.getRowCount()+">");
        
        // детали с вышивкой
        modelPrintDetali.setData(model.getModel());
        jTable2.setModel(modelPrintDetali);
        jTable2.setShowGrid(true);                    
        jTable2.getTableHeader().setReorderingAllowed(false);   
        jTable2ComponentResized(null);
        jTabbedPane1.setTitleAt(1, "Детали с вышивкой<"+modelPrintDetali.getRowCount()+">");
        
        // детали с принтом
        modelPrintDetali1.setData(model.getModel());
        jTable3.setModel(modelPrintDetali1);
        jTable3.setShowGrid(true);                    
        jTable3.getTableHeader().setReorderingAllowed(false);   
        jTable3ComponentResized(null);
        jTabbedPane1.setTitleAt(2, "Детали с принтом<"+modelPrintDetali1.getRowCount()+">");
        
        // фурнитура
        modelFurnitura.setData(model.getModel());
        jTable4.setModel(modelFurnitura);
        jTable4.setShowGrid(true);                    
        jTable4.getTableHeader().setReorderingAllowed(false);   
        jTable4ComponentResized(null);
        jTabbedPane1.setTitleAt(3, "Фурнитура("+modelFurnitura.getRowCount()+")");
        
        // шаблоны
        modelSablon.setData(model.getModel());
        jTable5.setModel(modelSablon);
        jTable5.setShowGrid(true);                    
        jTable5.getTableHeader().setReorderingAllowed(false);   
        jTable5ComponentResized(null);
        jTabbedPane1.setTitleAt(4, "Шаблоны("+modelSablon.getRowCount()+")");
        
        // клеевая
        modelKleevaya.setData(model.getModel());
        jTable6.setModel(modelKleevaya);
        jTable6.setShowGrid(true);                    
        jTable6.getTableHeader().setReorderingAllowed(false);   
        jTable6ComponentResized(null);
        jTabbedPane1.setTitleAt(5, "Клеевая("+modelKleevaya.getRowCount()+")");
        
        // файлы
        modelFiles.setData(model.getModel());
        jTable7.setModel(modelFiles);
        jTable7.setShowGrid(true);                    
        jTable7.getTableHeader().setReorderingAllowed(false);   
        jTable7ComponentResized(null);
        jTabbedPane1.setTitleAt(6, "Фотографии("+modelFiles.getRowCount()+")");
        
        //цеха
        modelChex.setDataChex(model.getModel());
        jTable8.setModel(modelChex);
        jTable8.setShowGrid(true);                    
        jTable8.getTableHeader().setReorderingAllowed(false);   
        jTable8ComponentResized(null);
        
        
        //Термопечать
        modelPrintDetali3.setData(model.getModel());
        jTable9.setModel(modelPrintDetali3);
        jTable9.setShowGrid(true);                    
        jTable9.getTableHeader().setReorderingAllowed(false);   
        jTable9ComponentResized(null);       
        
        jTabbedPane1.setTitleAt(8, "ТермоПечать("+modelPrintDetali3.getRowCount()+")");
    }//GEN-LAST:event_formWindowOpened

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jButton9ActionPerformed

    /**
     * Загрузить фото
     * @param evt 
     */
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        JFileChooser jf = new JFileChooser();        
        if(jf.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
        {
            if(model.getModel()==0)
                saveModel();
            
            File file = new File(jf.getSelectedFile().getAbsolutePath());
            Files fi = new Files();
            fi.setObj(IOFiles.loadFile(file.getAbsolutePath()));         
            fi.setName(file.getName());
            fi.setFiles(0);
            fi = IOFiles.setFiles(fi);
            
            ModelFiles md = new ModelFiles();
            md.setFiles(fi);
            md.setHaupt(modelFiles.getRowCount()==0?1:0);
            md.setModel(model);
            md.setModelfiles(0);
            
            md = IOModel.setModelFiles(md);
            modelFiles.setData(model.getModel());            
            //model.setFiles(IOFiles.setFiles(fi));
            printFoto(md.getModelfiles());
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        int m = model.getModel();
        saveModel();
        if(m>0)
            setVisible(false);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jTable1ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTable1ComponentResized
        // TODO add your handling code here:
        if(jTable1.getColumnCount()<=0)
            return;
        int h = (jTable1.getWidth()-110)/4;
        
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(0);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(0).setMinWidth(0);
        
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(h);        
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(h);        
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(h);        
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(h);        
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(50);        
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(60);        
        
    }//GEN-LAST:event_jTable1ComponentResized

    /**
     * Добавить материал
     * @param evt 
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(model.getModel()==0)
            saveModel();
        FGetProductForModel fg = new FGetProductForModel(null, true, model.getModel(), 0, 1);
        fg.setVisible(true);
        modelProduct.setData(model.getModel());
        jTabbedPane1.setTitleAt(0, "Материалы<"+modelProduct.getRowCount()+">");
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * Изменить материал
     * @param evt 
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(!jButton1.isEnabled()) return;
        int h = jTable1.getSelectedRow();
        if(h==-1) return;
        if(model.getModel()==0)
            saveModel();
        FGetProductForModel fg = new FGetProductForModel(null, true, model.getModel(), (int)jTable1.getValueAt(h, 0), 1);
        fg.setVisible(true);
        modelProduct.setData(model.getModel());
        jTabbedPane1.setTitleAt(0, "Материалы<"+modelProduct.getRowCount()+">");
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * Удалить материал
     * @param evt 
     */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int h = jTable1.getSelectedRow();
        if(h==-1)
            return;
        h = (int) jTable1.getValueAt(h, 0);
        if (JOptionPane.showConfirmDialog(null, "Вы действительно хотите удалить <" + jTable1.getValueAt(jTable1.getSelectedRow(), 2) + ">?", "Вопрос.", JOptionPane.YES_NO_OPTION) == 0) 
        {
            if(IOModel.delModelProduct(h))
            {
                modelProduct.setData(model.getModel());
                jTabbedPane1.setTitleAt(0, "Материалы<"+modelProduct.getRowCount()+">");
            }
            else
                JOptionPane.showMessageDialog(null, "Ошибка удаления");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * добавить деталь с вышивкой
     */
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if(model.getModel()==0)
            saveModel();
        FGetPrintDetali fg = new FGetPrintDetali(null, true, 2, 0);
        fg.setVisible(true);
        if(fg.getResult())
        {
            ModelPrintDetali md = new ModelPrintDetali();
            md.setModel(model);
            md.setModelprintdetali(0);
            md.setPrintdetali(new PrintDetali(fg.getResultValue()));
            md.setVid(2);
            IOModel.setModelPrintDetali(md);
            modelPrintDetali.setData(model.getModel());
            jTabbedPane1.setTitleAt(1, "Детали с вышивкой<"+modelPrintDetali.getRowCount()+">");            
        }
        
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable2ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTable2ComponentResized
        // TODO add your handling code here:
        if(jTable2.getColumnCount()<=0)
            return;
        int h = (jTable2.getWidth());
        
        jTable2.getColumnModel().getColumn(0).setPreferredWidth(0);
        jTable2.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable2.getColumnModel().getColumn(0).setMinWidth(0);
        
        jTable2.getColumnModel().getColumn(2).setPreferredWidth(0);
        jTable2.getColumnModel().getColumn(2).setMaxWidth(0);
        jTable2.getColumnModel().getColumn(2).setMinWidth(0);
        
        jTable2.getColumnModel().getColumn(1).setPreferredWidth(h);        
    }//GEN-LAST:event_jTable2ComponentResized

    /**
     * Изменить деталь с вышиакой
     * @param evt 
     */
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        if(!jButton1.isEnabled()) return;
        int h = jTable2.getSelectedRow();
        if(h==-1) return;
        if(model.getModel()==0)
            saveModel();
        FGetPrintDetali fg = new FGetPrintDetali(null, true, 2, (int)jTable2.getValueAt(h, 2));
        fg.setVisible(true);
        if(fg.getResult())
        {
            ModelPrintDetali md = new ModelPrintDetali();
            md.setModel(model);
            md.setModelprintdetali((int)jTable2.getValueAt(h, 0));
            md.setPrintdetali(new PrintDetali(fg.getResultValue()));
            md.setVid(2);
            IOModel.setModelPrintDetali(md);
            modelPrintDetali.setData(model.getModel());
            jTabbedPane1.setTitleAt(1, "Детали с вышивкой<"+modelPrintDetali.getRowCount()+">");            
        }
        
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * Удалить деталь с вышивкой
     * @param evt 
     */
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        int h = jTable2.getSelectedRow();
        if(h==-1)
            return;
        h = (int) jTable2.getValueAt(h, 0);
        if (JOptionPane.showConfirmDialog(null, "Вы действительно хотите удалить <" + jTable2.getValueAt(jTable2.getSelectedRow(), 1) + ">?", "Вопрос.", JOptionPane.YES_NO_OPTION) == 0) 
        {
            if(IOModel.delModelPrintDetali(h))
            {
                modelPrintDetali.setData(model.getModel());
                jTabbedPane1.setTitleAt(1, "Детали с вышивкой<"+modelPrintDetali.getRowCount()+">");
            }
            else
                JOptionPane.showMessageDialog(null, "Ошибка удаления");
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTable3ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTable3ComponentResized
        // TODO add your handling code here:
        if(jTable3.getColumnCount()<=0)
            return;
        int h = (jTable3.getWidth());
        
        jTable3.getColumnModel().getColumn(0).setPreferredWidth(0);
        jTable3.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable3.getColumnModel().getColumn(0).setMinWidth(0);
        
        jTable3.getColumnModel().getColumn(2).setPreferredWidth(0);
        jTable3.getColumnModel().getColumn(2).setMaxWidth(0);
        jTable3.getColumnModel().getColumn(2).setMinWidth(0);
        
        jTable3.getColumnModel().getColumn(1).setPreferredWidth(h);    
    }//GEN-LAST:event_jTable3ComponentResized

    /**
     * Добавить деталь с принтом
     * @param evt 
     */
    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        if(model.getModel()==0)
            saveModel();
        FGetPrintDetali fg = new FGetPrintDetali(null, true, 1, 0);
        fg.setVisible(true);
        if(fg.getResult())
        {
            ModelPrintDetali md = new ModelPrintDetali();
            md.setModel(model);
            md.setModelprintdetali(0);
            md.setPrintdetali(new PrintDetali(fg.getResultValue()));
            md.setVid(1);
            IOModel.setModelPrintDetali(md);
            modelPrintDetali1.setData(model.getModel());
            jTabbedPane1.setTitleAt(2, "Детали с принтом<"+modelPrintDetali1.getRowCount()+">");
        }        
    }//GEN-LAST:event_jButton10ActionPerformed

    /**
     * изменить деталь с принтом
     * @param evt 
     */
    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        if(!jButton1.isEnabled()) return;
        int h = jTable3.getSelectedRow();
        if(h==-1) return;
        if(model.getModel()==0)
            saveModel();
        FGetPrintDetali fg = new FGetPrintDetali(null, true, 1, (int)jTable3.getValueAt(h, 2));
        fg.setVisible(true);
        if(fg.getResult())
        {
            ModelPrintDetali md = new ModelPrintDetali();
            md.setModel(model);
            md.setModelprintdetali((int)jTable3.getValueAt(h, 0));
            md.setPrintdetali(new PrintDetali(fg.getResultValue()));
            md.setVid(1);
            IOModel.setModelPrintDetali(md);
            modelPrintDetali1.setData(model.getModel());
            jTabbedPane1.setTitleAt(2, "Детали с принтом<"+modelPrintDetali1.getRowCount()+">");
        }        
    }//GEN-LAST:event_jButton11ActionPerformed

    /**
     * удалить деталь с принтом
     * @param evt 
     */
    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        int h = jTable3.getSelectedRow();
        if(h==-1)
            return;
        h = (int) jTable3.getValueAt(h, 0);
        if (JOptionPane.showConfirmDialog(null, "Вы действительно хотите удалить <" + jTable3.getValueAt(jTable3.getSelectedRow(), 1) + ">?", "Вопрос.", JOptionPane.YES_NO_OPTION) == 0) 
        {
            if(IOModel.delModelPrintDetali(h))
            {
                modelPrintDetali1.setData(model.getModel());
                jTabbedPane1.setTitleAt(2, "Детали с принтом<"+modelPrintDetali1.getRowCount()+">");
            }
            else
                JOptionPane.showMessageDialog(null, "Ошибка удаления");
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jTable4ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTable4ComponentResized
        // TODO add your handling code here:
        if(jTable4.getColumnCount()<=0)
            return;
        int h = (jTable4.getWidth()-50)/2;
        
        jTable4.getColumnModel().getColumn(0).setPreferredWidth(0);
        jTable4.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable4.getColumnModel().getColumn(0).setMinWidth(0);
        
        jTable4.getColumnModel().getColumn(1).setPreferredWidth(0);
        jTable4.getColumnModel().getColumn(1).setMaxWidth(0);
        jTable4.getColumnModel().getColumn(1).setMinWidth(0);
        
        jTable4.getColumnModel().getColumn(2).setPreferredWidth(h);        
        jTable4.getColumnModel().getColumn(3).setPreferredWidth(h);        
        jTable4.getColumnModel().getColumn(4).setPreferredWidth(0);
        jTable4.getColumnModel().getColumn(4).setMaxWidth(0);
        jTable4.getColumnModel().getColumn(4).setMinWidth(0);
        jTable4.getColumnModel().getColumn(5).setPreferredWidth(50); 
        
        jTable4.getColumnModel().getColumn(6).setPreferredWidth(0);
        jTable4.getColumnModel().getColumn(6).setMaxWidth(0);
        jTable4.getColumnModel().getColumn(6).setMinWidth(0);
    }//GEN-LAST:event_jTable4ComponentResized

    /**
     * добавить фурнитуру
     * @param evt 
     */
    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        if(model.getModel()==0)
            saveModel();
        FGetProductForModel fg = new FGetProductForModel(null, true, model.getModel(), 0, 2);
        fg.setVisible(true);
        modelFurnitura.setData(model.getModel());
        jTabbedPane1.setTitleAt(3, "Фурнитура<"+modelFurnitura.getRowCount()+">");
    }//GEN-LAST:event_jButton13ActionPerformed

    /**
     * изменить фурнитуру
     * @param evt 
     */
    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        if(!jButton1.isEnabled()) return;
        int h = jTable4.getSelectedRow();
        if(h==-1) return;
        if(model.getModel()==0)
            saveModel();
        FGetProductForModel fg = new FGetProductForModel(null, true, model.getModel(), (int)jTable4.getValueAt(h, 0), 2);
        fg.setVisible(true);
        modelFurnitura.setData(model.getModel());
        jTabbedPane1.setTitleAt(3, "<html>Фурнитура<b>("+modelFurnitura.getRowCount()+")</b></html>");
    }//GEN-LAST:event_jButton14ActionPerformed

    /**
     * Удалить фурнитуру
     * @param evt 
     */
    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        int h = jTable4.getSelectedRow();
        if(h==-1)
            return;
        h = (int) jTable4.getValueAt(h, 0);
        if (JOptionPane.showConfirmDialog(null, "Вы действительно хотите удалить <" + jTable4.getValueAt(jTable4.getSelectedRow(), 2) + ">?", "Вопрос.", JOptionPane.YES_NO_OPTION) == 0) 
        {
            if(IOModel.delModelProduct(h))
            {
                modelFurnitura.setData(model.getModel());
                jTabbedPane1.setTitleAt(3, "<html>Фурнитура<b>("+modelFurnitura.getRowCount()+")</b></html>");
            }
            else
                JOptionPane.showMessageDialog(null, "Ошибка удаления");
        }
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jTable5ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTable5ComponentResized
        // TODO add your handling code here:
        if(jTable5.getColumnCount()<=0)
            return;
        int h = (jTable5.getWidth()-60);
        
        jTable5.getColumnModel().getColumn(0).setPreferredWidth(0);
        jTable5.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable5.getColumnModel().getColumn(0).setMinWidth(0);        
        jTable5.getColumnModel().getColumn(1).setPreferredWidth(h);        
        jTable5.getColumnModel().getColumn(2).setPreferredWidth(60);        
    }//GEN-LAST:event_jTable5ComponentResized

    private void jTable6ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTable6ComponentResized
        // TODO add your handling code here:
        if(jTable6.getColumnCount()<=0)
            return;
        int h = (jTable6.getWidth()-60);
        
        jTable6.getColumnModel().getColumn(0).setPreferredWidth(0);
        jTable6.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable6.getColumnModel().getColumn(0).setMinWidth(0);        
        jTable6.getColumnModel().getColumn(1).setPreferredWidth(h);                
        jTable6.getColumnModel().getColumn(2).setPreferredWidth(60);        
    }//GEN-LAST:event_jTable6ComponentResized

    /**
     * Добавить шаблон
     * @param evt 
     */
    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
        if(model.getModel()==0)
            saveModel();
        FGetSablon fg = new FGetSablon(null, true, 0);
        fg.setVisible(true);
        if(fg.getResult())
        {
            ModelSablon md = new ModelSablon();
            md.setModel(model);
            md.setModelsablon(0);
            md.setQty(1);
            md.setSablon(new Sablon(fg.getResultValue()));
            IOModel.setModelSablon(md);
            modelSablon.setData(model.getModel());
            jTabbedPane1.setTitleAt(4, "Шаблоны("+modelSablon.getRowCount()+")");
            //jTable6.setRowSelectionInterval(h, h);
        }
    }//GEN-LAST:event_jButton16ActionPerformed

    /**
     * Изменить шаблон
     * @param evt 
     */
    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
        if(!jButton1.isEnabled()) return;
        int h = jTable5.getSelectedRow();
        if(h==-1) return;
        
        if(model.getModel()==0)
            saveModel();
        FGetSablon fg = new FGetSablon(null, true, IOModel.getListModelSablon(0, (int)jTable5.getValueAt(h, 0)).get(0).getSablon().getSablon());
        fg.setVisible(true);
        if(fg.getResult())
        {
            ModelSablon md = IOModel.getListModelSablon(0, (int)jTable5.getValueAt(h, 0)).get(0);//new ModelSablon();
            md.setModel(model);
            md.setModelsablon((int)jTable5.getValueAt(h, 0));
            md.setSablon(new Sablon(fg.getResultValue()));
            IOModel.setModelSablon(md);
            modelSablon.setData(model.getModel());
            jTabbedPane1.setTitleAt(4, "Шаблоны("+modelSablon.getRowCount()+")");
            jTable5.setRowSelectionInterval(h, h);
        }
        /*FGetSablon fg = new FGetSablon(null, true, model.getModel(), (int)jTable5.getValueAt(h, 0));
        fg.setVisible(true);
        modelSablon.setData(model.getModel());
        jTabbedPane1.setTitleAt(4, "Шаблоны("+modelSablon.getRowCount()+")");*/
    }//GEN-LAST:event_jButton17ActionPerformed

    /**
     * Удалить шаблон
     * @param evt 
     */
    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
        int h = jTable5.getSelectedRow();
        if(h==-1)
            return;
        h = (int) jTable5.getValueAt(h, 0);
        if (JOptionPane.showConfirmDialog(null, "Вы действительно хотите удалить <" + jTable5.getValueAt(jTable5.getSelectedRow(), 1) + ">?", "Вопрос.", JOptionPane.YES_NO_OPTION) == 0) 
        {
            if(IOModel.delModelSablon(h))
            {
                modelSablon.setData(model.getModel());
                jTabbedPane1.setTitleAt(4, "Шаблоны("+modelSablon.getRowCount()+")");
            }
            else
                JOptionPane.showMessageDialog(null, "Ошибка удаления");
        }
    }//GEN-LAST:event_jButton18ActionPerformed

    /**
     * Открыть материал
     * @param evt 
     */
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount() == 2)
            jButton2ActionPerformed(null);
    }//GEN-LAST:event_jTable1MouseClicked

    /**
     * открыть вышивку
     * @param evt 
     */
    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount() == 2)
            jButton5ActionPerformed(null);
    }//GEN-LAST:event_jTable2MouseClicked

    /**
     * изменить детали с принтов
     * @param evt 
     */
    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount() == 2)
            jButton11ActionPerformed(null);
    }//GEN-LAST:event_jTable3MouseClicked

    
    private void jTable7ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTable7ComponentResized
        // TODO add your handling code here:
        if(jTable7.getColumnCount()<=0)
            return;
        int h = (jTable7.getWidth()-30);
        
        jTable7.getColumnModel().getColumn(0).setPreferredWidth(0);
        jTable7.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable7.getColumnModel().getColumn(0).setMinWidth(0);        
        jTable7.getColumnModel().getColumn(1).setPreferredWidth(30);        
        jTable7.getColumnModel().getColumn(2).setPreferredWidth(h);        
    }//GEN-LAST:event_jTable7ComponentResized

    /**
     * Добавить фотографию
     * @param evt 
     */
    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        // TODO add your handling code here:
        jButton7ActionPerformed(null);
        /*JFileChooser jf = new JFileChooser();        
        if(jf.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
        {
            File file = new File(jf.getSelectedFile().getAbsolutePath());
            Files fi = model.getFiles();
            fi.setObj(IOFiles.loadFile(file.getAbsolutePath()));         
            fi.setName(file.getName());
            model.setFiles(IOFiles.setFiles(fi));
            printFoto();
        }*/
    }//GEN-LAST:event_jButton22ActionPerformed

    /**
     * Просмотреть выбранное фото
     * @param evt 
     */
    private void jTable7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable7MouseClicked
        // TODO add your handling code here:
        int h = jTable7.getSelectedRow();
        if(h==-1) return;
        printFoto((int)jTable7.getValueAt(h, 0));
    }//GEN-LAST:event_jTable7MouseClicked

    /**
     * Удалить фотографию
     * @param evt 
     */
    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        // TODO add your handling code here:
        
        int h = jTable7.getSelectedRow();
        if(h==-1)
            return;
        h = (int) jTable7.getValueAt(h, 0);
        if (JOptionPane.showConfirmDialog(null, "Вы действительно хотите удалить <" + jTable7.getValueAt(jTable7.getSelectedRow(), 2) + ">?", "Вопрос.", JOptionPane.YES_NO_OPTION) == 0) 
        {
            if(IOModel.delModelFiles(h))
            {
                modelFiles.setData(model.getModel());
                printFoto(0);
                jTabbedPane1.setTitleAt(6, "Фотографии("+modelFiles.getRowCount()+")");
            }
            else
                JOptionPane.showMessageDialog(null, "Ошибка удаления");
        }
    }//GEN-LAST:event_jButton23ActionPerformed

    /**
     * Установить главную фотографию
     * @param evt 
     */
    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        // TODO add your handling code here:
        int h = jTable7.getSelectedRow();
        if(h==-1)
            return;
        h = (int) jTable7.getValueAt(h, 0);
        IOModel.statModelFilesSetHaupt(model.getModel(), h);
        modelFiles.setData(model.getModel());
                
        
    }//GEN-LAST:event_jButton24ActionPerformed

    /**
     * выбор типа модели
     * @param evt 
     */
    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        // TODO add your handling code here:
        FGetTipModeli fg = new FGetTipModeli(null, true, model.getTipmodel().getTipmodel());
        fg.setVisible(true);
        if(fg.getResult())
        {
            model.setTipmodel(IOTipModel.getListTipModel(fg.getResultValue()).get(0));
            jTextField4.setText(model.getTipmodel().getName());
        }
    }//GEN-LAST:event_jButton25ActionPerformed

    /**
     * Выбор первого размера
     * @param evt 
     */
    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        // TODO add your handling code here:
        FGetRazmeri fg = new FGetRazmeri(null, true, model.getFirstrazmeri().getRazmeri());
        fg.setVisible(true);
        if(fg.getResult())
        {
            model.setFirstrazmeri(IORazmeri.getListRazmeri(fg.getResultValue()).get(0));
            jTextField5.setText(model.getFirstrazmeri().getName());
        }
    }//GEN-LAST:event_jButton26ActionPerformed

    /**
     * добавить клеевую
     * @param evt 
     */
    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // TODO add your handling code here:
        if(model.getModel()==0)
            saveModel();
        FGetKleevaya fg = new FGetKleevaya(null, true, 0);
        fg.setVisible(true);
        if(fg.getResult())
        {
            ModelKleevaya md = new ModelKleevaya();
            md.setModel(model);
            md.setModelkleevaya(0);
            md.setQty(1);
            md.setKleevaya(new Kleevaya(fg.getResultValue()));
            IOModel.setModelKleevaya(md);
            modelKleevaya.setData(model.getModel());
            jTabbedPane1.setTitleAt(5, "Клеевая("+modelKleevaya.getRowCount()+")");
        }
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        // TODO add your handling code here:
        if(!jButton1.isEnabled()) return;
        if(jTable6.getSelectedRow() == -1) return;
        int h = jTable6.getSelectedRow();
        if(model.getModel()==0)
            saveModel();
        FGetKleevaya fg = new FGetKleevaya(null, true, IOModel.getListModelKleevaya(0, (int)jTable6.getValueAt(jTable6.getSelectedRow(), 0)).get(0).getKleevaya().getKleevaya());
        fg.setVisible(true);
        if(fg.getResult())
        {
            ModelKleevaya md = IOModel.getListModelKleevaya(0, (int)jTable6.getValueAt(jTable6.getSelectedRow(), 0)).get(0);//new ModelKleevaya();
            md.setModel(model);
            md.setModelkleevaya((int)jTable6.getValueAt(jTable6.getSelectedRow(), 0));
            md.setKleevaya(new Kleevaya(fg.getResultValue()));
            IOModel.setModelKleevaya(md);
            modelKleevaya.setData(model.getModel());
            jTabbedPane1.setTitleAt(5, "Клеевая("+modelKleevaya.getRowCount()+")");
            jTable6.setRowSelectionInterval(h, h);
        }
    }//GEN-LAST:event_jButton20ActionPerformed

    /**
     * Удалить клеевая
     * @param evt 
     */
    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        // TODO add your handling code here:
        int h = jTable6.getSelectedRow();
        if(h==-1)
            return;
        h = (int) jTable6.getValueAt(h, 0);
        if (JOptionPane.showConfirmDialog(null, "Вы действительно хотите удалить <" + jTable6.getValueAt(jTable6.getSelectedRow(), 1) + ">?", "Вопрос.", JOptionPane.YES_NO_OPTION) == 0) 
        {
            if(IOModel.delModelKleevaya(h))
            {
                modelKleevaya.setData(model.getModel());
                jTabbedPane1.setTitleAt(5, "Клеевая("+modelKleevaya.getRowCount()+")");
            }
            else
                JOptionPane.showMessageDialog(null, "Ошибка удаления");
        }
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jTable6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable6MouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount() == 2)
            jButton20ActionPerformed(null);
    }//GEN-LAST:event_jTable6MouseClicked

    private void jTable5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable5MouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount() == 2)
            jButton17ActionPerformed(null);
    }//GEN-LAST:event_jTable5MouseClicked

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount() == 2)
            jButton14ActionPerformed(null);
    }//GEN-LAST:event_jTable4MouseClicked

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        // TODO add your handling code here:
        FGetRazmeri fg = new FGetRazmeri(null, true, model.getEndrazmeri().getRazmeri());
        fg.setVisible(true);
        if(fg.getResult())
        {
            model.setEndrazmeri(IORazmeri.getListRazmeri(fg.getResultValue()).get(0));
            jTextField7.setText(model.getEndrazmeri().getName());
        }
    }//GEN-LAST:event_jButton28ActionPerformed

    // +1 клеевая
    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        // TODO add your handling code here:
        int h = jTable6.getSelectedRow();
        if(h==-1) return;
        ModelKleevaya mk = IOModel.getListModelKleevaya(0, (int)jTable6.getValueAt(h, 0)).get(0);
        mk.setQty(mk.getQty()+1);
        IOModel.setModelKleevaya(mk);
        modelKleevaya.setData(model.getModel());
        jTable6.setRowSelectionInterval(h, h);
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        // TODO add your handling code here:
        int h = jTable6.getSelectedRow();
        if(h==-1) return;
        ModelKleevaya mk = IOModel.getListModelKleevaya(0, (int)jTable6.getValueAt(h, 0)).get(0);
        mk.setQty(mk.getQty()-1);
        if(mk.getQty()==0)
            mk.setQty(1);
        IOModel.setModelKleevaya(mk);
        modelKleevaya.setData(model.getModel());
        jTable6.setRowSelectionInterval(h, h);
    }//GEN-LAST:event_jButton29ActionPerformed

    //+1 Шаблон
    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        // TODO add your handling code here:
        int h = jTable5.getSelectedRow();
        if(h==-1) return;
        ModelSablon mk = IOModel.getListModelSablon(0, (int)jTable5.getValueAt(h, 0)).get(0);
        mk.setQty(mk.getQty()+1);
        IOModel.setModelSablon(mk);
        modelSablon.setData(model.getModel());
        jTable5.setRowSelectionInterval(h, h);
    }//GEN-LAST:event_jButton30ActionPerformed

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
        // TODO add your handling code here:
        int h = jTable5.getSelectedRow();
        if(h==-1) return;
        ModelSablon mk = IOModel.getListModelSablon(0, (int)jTable5.getValueAt(h, 0)).get(0);
        mk.setQty(mk.getQty()-1);
        if(mk.getQty()==0)
            mk.setQty(1);
        IOModel.setModelSablon(mk);
        modelSablon.setData(model.getModel());
        jTable5.setRowSelectionInterval(h, h);
    }//GEN-LAST:event_jButton31ActionPerformed

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
        // TODO add your handling code here:
        IOModel.setPriceForModel(model.getModel(), HelpClass.GetBigDecimalIzText(jTextField9.getText()));
    }//GEN-LAST:event_jButton32ActionPerformed

    private void jTable8ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTable8ComponentResized
        // TODO add your handling code here:
         if(jTable8.getColumnCount()<=0)
            return;
        int h = (jTable8.getWidth()-30);
        
        jTable8.getColumnModel().getColumn(0).setPreferredWidth(0);
        jTable8.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable8.getColumnModel().getColumn(0).setMinWidth(0);        
        jTable8.getColumnModel().getColumn(1).setPreferredWidth(h);        
        jTable8.getColumnModel().getColumn(2).setPreferredWidth(30);  
    }//GEN-LAST:event_jTable8ComponentResized

    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed
        // TODO add your handling code here:
        if(model.getModel()==0)
            saveModel();
        FGetPrintDetali fg = new FGetPrintDetali(null, true, 3, 0);
        fg.setVisible(true);
        if(fg.getResult())
        {
            ModelPrintDetali md = new ModelPrintDetali();
            md.setModel(model);
            md.setModelprintdetali(0);
            md.setPrintdetali(new PrintDetali(fg.getResultValue()));
            md.setVid(3);            
            IOModel.setModelPrintDetali(md);
            modelPrintDetali3.setData(model.getModel());
            jTabbedPane1.setTitleAt(8, "ТермоПечать("+modelPrintDetali3.getRowCount()+")");
        }
    }//GEN-LAST:event_jButton33ActionPerformed

    private void jTable9ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTable9ComponentResized
        // TODO add your handling code here:
        if(jTable9.getColumnCount()<=0)
            return;
        //int h = (jTable5.getWidth()-60);
        
        jTable9.getColumnModel().getColumn(0).setPreferredWidth(0);
        jTable9.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable9.getColumnModel().getColumn(0).setMinWidth(0);        
        jTable9.getColumnModel().getColumn(1).setPreferredWidth(jTable9.getWidth());        
        jTable9.getColumnModel().getColumn(2).setPreferredWidth(0);
        jTable9.getColumnModel().getColumn(2).setMaxWidth(0);
        jTable9.getColumnModel().getColumn(2).setMinWidth(0);        
    }//GEN-LAST:event_jTable9ComponentResized

    //удалить деталь термопечати
    private void jButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton35ActionPerformed
        // TODO add your handling code here:
        int h = jTable9.getSelectedRow();
        if(h==-1)
            return;
        h = (int) jTable9.getValueAt(h, 0);
        if (JOptionPane.showConfirmDialog(null, "Вы действительно хотите удалить <" + jTable9.getValueAt(jTable9.getSelectedRow(), 1) + ">?", "Вопрос.", JOptionPane.YES_NO_OPTION) == 0) 
        {
            if(IOModel.delModelPrintDetali(h))
            {
                modelPrintDetali3.setData(model.getModel());
                jTabbedPane1.setTitleAt(8, "ТермоПечать("+modelPrintDetali3.getRowCount()+")");
            }
            else
                JOptionPane.showMessageDialog(null, "Ошибка удаления");
        }
    }//GEN-LAST:event_jButton35ActionPerformed

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
        // TODO add your handling code here:
        int h = jTable7.getSelectedRow();
        if(h==-1)
            return;
        h = (int) jTable7.getValueAt(h, 0);
               
        
        JFileChooser jf = new JFileChooser();        
        //jf.setFileName("name" );
        
        if(jf.showSaveDialog(this) == JFileChooser.APPROVE_OPTION)
        {
            ModelFiles mff = IOModel.getListModelFiles(0, h).get(0);
            String ss[] = mff.getFiles().getName().split("\\.");
            //IOFiles.saveFile(mff.getFiles().getObj(), jf.getSelectedFile().getAbsolutePath());            
            //IOFiles.saveFile(mff.getFiles().getObj(), jf.getCurrentDirectory().getAbsolutePath()+ "\\" + mff.getFiles().getName());            
            IOFiles.saveFile(mff.getFiles().getObj(), jf.getSelectedFile().getAbsolutePath()+ "." + ss[ss.length-1]);            
        }
    }//GEN-LAST:event_jButton34ActionPerformed

    private void jButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton36ActionPerformed
        // TODO add your handling code here:
        int h = jTable7.getSelectedRow();
        if(h==-1)
            return;
        //h = (int) jTable7.getValueAt(h, 0);
        if (JOptionPane.showConfirmDialog(null, "Вы действительно хотите заменить <" + jTable7.getValueAt(h, 2) + ">?", "Вопрос.", JOptionPane.YES_NO_OPTION) == 0) 
        {
            JFileChooser jf = new JFileChooser();
            if (jf.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) 
            {
                ModelFiles md = IOModel.getListModelFiles(0, (int)jTable7.getValueAt(h, 0)).get(0);
                
                Files fi = md.getFiles();
                fi.setObj(IOFiles.loadFile(jf.getSelectedFile().getAbsolutePath()));
                md.setFiles(IOFiles.setFiles(fi));               
                
                printFoto(md.getModelfiles());
            }           
        }
    }//GEN-LAST:event_jButton36ActionPerformed

    /**
     * Поместить фото в панель
     */    
    private void printFoto(int id)
    {
        
        try {
            //if(model.getFiles().getFiles() == 0) return;
            ModelFiles f = IOModel.getHauptModelFiles(model.getModel(), id);
            if(f.getModelfiles()==0)
            {
                jLabel9.setIcon(null);
                return;
            }            
            InputStream inputStream = new ByteArrayInputStream(f.getFiles().getObj());
            BufferedImage image = ImageIO.read(inputStream);
            ImageIcon ii = new ImageIcon(image);
            jLabel9.setIcon(new ImageIcon(ii.getImage().getScaledInstance(271, 227, 0)));
        } catch (IOException ex) {
            Logger.getLogger(FModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Сохранить модель
     */
    private void saveModel()
    {
        model.setArticle(jTextField1.getText());
        model.setBeika(jTextField2.getText());
        model.setDates(jDateChooser1.getDate());
        model.setDel(0);
        model.setText(jTextField6.getText());
        //model.setFirstrazmeri((Razmeri) jComboBox2.getSelectedItem());
        model.setName(jTextField3.getText());
        model.setPrice(HelpClass.GetBigDecimalIzText(jTextField9.getText()));
        model.setRaskladchik((Raskladchik) jComboBox3.getSelectedItem());
        model.setRaskladchik1((Raskladchik) jComboBox4.getSelectedItem());    
        model.setStatus(0);
        model.setOtvetst(jTextField8.getText());
        model.setHarticle(jTextField10.getText());
        model = IOModel.setModel(model);
    }
    
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
            java.util.logging.Logger.getLogger(FModel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FModel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FModel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FModel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                FModel dialog = new FModel(new javax.swing.JFrame(), true, 0, 0, 0);
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
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
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
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTable7;
    private javax.swing.JTable jTable8;
    private javax.swing.JTable jTable9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JToolBar jToolBar4;
    private javax.swing.JToolBar jToolBar5;
    private javax.swing.JToolBar jToolBar6;
    private javax.swing.JToolBar jToolBar7;
    private javax.swing.JToolBar jToolBar8;
    // End of variables declaration//GEN-END:variables

    /**
     * Загрузка первоначальных данных
     */
    private void loadNullValue() {
        
        jDateChooser1.setDate(new Date());
        // раскладчик
        for(Raskladchik a: IORaskladchik.getListRaskladchik(-1))            
        {
            jComboBox3.addItem(a);   
            jComboBox4.addItem(a);   
            if(a.getRaskladchik() == 0)
            {
                jComboBox3.setSelectedItem(a);
                jComboBox4.setSelectedItem(a);
            }
        }
        
    }

    /**
     * Загрузка модкли
     */
    private void loadModel() {
        model = IOModel.getListModel(model.getModel(), -1, true).get(0);
        // если нет прав редактировать то закроем для редактирования
        if(IOOperator.getSetupOperator(1)<2)
            model.setStatus(1);
        printFoto(0);
        jTextField1.setText(model.getArticle());
        jTextField2.setText(model.getBeika());
        jTextField3.setText(model.getName());
        jDateChooser1.setDate(model.getDates());
        jTextField4.setText(model.getTipmodel().getName());
        jTextField5.setText(model.getFirstrazmeri().getName());
        jTextField7.setText(model.getEndrazmeri().getName());
        jTextField8.setText(model.getOtvetst());
        jTextField9.setText(model.getPrice().setScale(2, RoundingMode.HALF_UP).toString());
        jComboBox3.getModel().setSelectedItem(model.getRaskladchik());
        jComboBox4.getModel().setSelectedItem(model.getRaskladchik1());
        jTextField6.setText(model.getText());
        jTextField10.setText(model.getHarticle());
        
        //если модель закрыта для редактирования
        if(model.getStatus() >= 1)
        {
            jButton8.setEnabled(false);
            jButton7.setEnabled(false);
            jButton26.setEnabled(false);
            jToolBar1.setEnabled(false);
            
            jButton1.setEnabled(false);
            jButton2.setEnabled(false);
            jButton3.setEnabled(false);
            jButton4.setEnabled(false);
            jButton5.setEnabled(false);
            jButton6.setEnabled(false);
            jButton10.setEnabled(false);
            jButton11.setEnabled(false);
            jButton12.setEnabled(false);
            jButton13.setEnabled(false);
            jButton14.setEnabled(false);
            jButton15.setEnabled(false);
            jButton16.setEnabled(false);
            jButton17.setEnabled(false);
            jButton18.setEnabled(false);
            jButton19.setEnabled(false);
            jButton20.setEnabled(false);
            jButton21.setEnabled(false);
            jButton22.setEnabled(false);
            jButton23.setEnabled(false);
            jButton24.setEnabled(false);
            jButton25.setEnabled(false);
            jButton26.setEnabled(false);            
            jButton28.setEnabled(false);            
            jButton27.setEnabled(false);            
            jButton29.setEnabled(false);            
            jButton30.setEnabled(false);            
            jButton31.setEnabled(false);  
            jButton33.setEnabled(false);  
            jButton35.setEnabled(false);  
            modelChex.stop_edit();
        }
    }
}
