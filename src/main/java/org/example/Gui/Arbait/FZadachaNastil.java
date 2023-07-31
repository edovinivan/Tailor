/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Arbait;

import org.example.Gui.Arbait.Model.ModelZadachaNastilDop;
import org.example.Gui.Arbait.Model.ModelZadachaNastilPrintDetali;
import org.example.Gui.Arbait.Model.ModelZadachaScladProduct;
import org.example.Gui.Form.Helps.FGetRabotnik;
import org.example.Gui.Form.Helps.FGetTipNastila;
import org.example.Gui.Form.Helps.FGetTipNastilania;
import org.example.Gui.model.ModelDocumentJournal;
import java.awt.Component;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import static javax.swing.SwingConstants.LEFT;
import static javax.swing.SwingConstants.RIGHT;
import javax.swing.table.DefaultTableCellRenderer;
import org.example.logic.Agent;
import org.example.logic.Document;
import org.example.logic.Product;
import org.example.logic.Rabotnik;
import org.example.logic.TipNastila;
import org.example.logic.TipNastilania;
import org.example.logic.Zadacha;
import org.example.logic.ZadachaNastil;
import org.example.logic.ZadachaNastilDop;
import org.example.util.HelpClass;
import org.example.util.IODocument;
import org.example.util.IORabotnik;
import org.example.util.IOSetup;
import org.example.util.IOTipNastila;
import org.example.util.IOZadacha;
import org.example.util.IOZadachaNastil;

/**
 *
 * @author ivan
 */
public class FZadachaNastil extends javax.swing.JDialog {

    /**
     * Creates new form FZadachaNastil
     * @param parent
     * @param modal
     * @param z - номер задачи
     * @param zn - номер задачи настила
     */
    public FZadachaNastil(java.awt.Frame parent, boolean modal, int z, int zn) {
        super(parent, modal);
        initComponents();
        jPanel1.setVisible(false);
        jLabel7.setVisible(false);
        jTextField5.setVisible(false);
        //zadachaNastil = IOZadachaNastil.getListZadachaNastil(0, zn).get(0);
        zadachaNastil.setZadacha(new Zadacha(z));
        zadachaNastil.setZadachanastil(zn);
        zadachaNastil.setTipnastila(new TipNastila(0));
        zadachaNastil.setTipnastilania(new TipNastilania(0));
        zadachaNastil.setRezak(new Rabotnik(0));
        zadachaNastil.setNastil(new Rabotnik(0));
        zadachaNastil.setStatus(0);
        zadachaNastil.setDreturn(new Document(0));
        zadachaNastil.setTippolotna(new Product(0));
        
        
        
        jButton8.setEnabled(false);
        jButton9.setEnabled(false);
        jButton10.setEnabled(false);
        
        jDateChooser1.setDate(new Date());
        
        if(zn>0)
            loadZN();
        else
        {
            
            /* 
            zn.setQtyaddarticle(HelpClass.GetBigDecimalIzText2(jTextField10.getText()));
        zn.setQtydel(HelpClass.GetBigDecimalIzText2(jTextField5.getText()));
        zn.setQtydel1(HelpClass.GetBigDecimalIzText2(jTextField27.getText()));
        zn.setQtyend(HelpClass.GetBigDecimalIzText2(jTextField4.getText()));
        zn.setQtygut(HelpClass.GetBigDecimalIzText2(jTextField7.getText()));        
        zn.setQtylosk(HelpClass.GetBigDecimalIzText2(jTextField6.getText()));
        zn.setQtylosk1(HelpClass.GetBigDecimalIzText2(jTextField28.getText()));
        zn.setQtytruba(HelpClass.GetBigDecimalIzText2(jTextField8.getText()));
        zn.setQtyreturn(HelpClass.GetBigDecimalIzText2(jTextField14.getText()));
        zn.setQtynull(HelpClass.GetBigDecimalIzText(jTextField19.getText()));
        zn.setDlina(HelpClass.GetBigDecimalIzText(jTextField20.getText()));
        zn.setQtybeika(HelpClass.GetBigDecimalIzText2(jTextField25.getText()));*/
            
            
            jTextField1.setText(IOZadacha.getListZadacha(z, 0).get(0).getNomer() + "-" + (IOZadachaNastil.getListZadachaNastil(z, -1).size() + 1) + "-" + IOSetup.getNextNomNastil());
            zadachaNastil.setQtyaddarticle(HelpClass.MIN_QTY_EDIT);
            zadachaNastil.setQtydel(HelpClass.MIN_QTY_EDIT);
            zadachaNastil.setQtydel1(HelpClass.MIN_QTY_EDIT);
            zadachaNastil.setQtyend(HelpClass.MIN_QTY_EDIT);
            zadachaNastil.setQtygut(HelpClass.MIN_QTY_EDIT);
            zadachaNastil.setQtyl(0);
            zadachaNastil.setQtylosk(HelpClass.MIN_QTY_EDIT);
            zadachaNastil.setQtylosk1(HelpClass.MIN_QTY_EDIT);
            zadachaNastil.setQtytruba(HelpClass.MIN_QTY_EDIT);
            zadachaNastil.setQtyreturn(HelpClass.MIN_QTY_EDIT);
            zadachaNastil.setQtyl_string("0");
            zadachaNastil.setDlina(HelpClass.MIN_QTY_EDIT);
            zadachaNastil.setQtynull(HelpClass.MIN_QTY_EDIT);
            zadachaNastil.setDlinakonc(BigDecimal.ZERO);
            zadachaNastil.setQtybeika(HelpClass.MIN_QTY_EDIT);
            zadachaNastil.setPachka(0);      
            zadachaNastil.setPasportreturn("");
            zadachaNastil.setDateclose(new Date());
            //zadachaNastil.setDlina(new BigDecimal(0));
            saveNastil();
        }
        
        modelDJ = new ModelDocumentJournal(1);
    }
    
    ModelZadachaNastilDop modelDop = new ModelZadachaNastilDop(1);
    
    ModelZadachaNastilPrintDetali modelPD = new ModelZadachaNastilPrintDetali();
    
    ZadachaNastil zadachaNastil = new ZadachaNastil();
    ModelZadachaScladProduct model = new ModelZadachaScladProduct();
    ModelDocumentJournal modelDJ;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jSpinner3 = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jToolBar2 = new javax.swing.JToolBar();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Настил для задачи");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Номер");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Тип настила");

        jTextField2.setEditable(false);
        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextField3.setEditable(false);
        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Тип настилания");

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton4.setText("...");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton5.setText("...");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Доп. артикул");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Резак");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Настил");

        jTextField9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextField11.setEditable(false);
        jTextField11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextField12.setEditable(false);
        jTextField12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton6.setText("...");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton7.setText("...");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Общий вес настила");

        jTextField13.setEditable(false);
        jTextField13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField13.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField13.setText("0");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Прибавка к длине раскладчика");

        jSpinner3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Дата настила");

        jDateChooser1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTable3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable3.setRowHeight(24);
        jTable3.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable3.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jTable3ComponentResized(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Дополнительные секции");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Длина настила");

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField4.setText("0");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Длина концевых");

        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField5.setText("0");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Расход бейки");

        jTextField6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox1.setText("Пачка");

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/add.png"))); // NOI18N
        jButton11.setText("Добавить");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/remove.png"))); // NOI18N
        jButton12.setText("Удалить");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Пояснение к доп. арт");

        jTextField7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Пояснение к настилу");

        jTextField8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Детали с вышивкой и принтом");

        jTable4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable4.setRowHeight(24);
        jTable4.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable4.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jTable4ComponentResized(evt);
            }
        });
        jScrollPane4.setViewportView(jTable4);

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Ширина");

        jTextField10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField10.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField10.setText("0");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Кол-во изделий в 1 слое");

        jTextField14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField14.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField14.setText("0");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Кол-во изделий в 1 слое доп арт");

        jTextField15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField15.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField15.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                                        .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)))
                                .addGap(10, 10, 10)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addComponent(jTextField7)
                                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton12))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                                .addComponent(jLabel15)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextField6, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                                .addComponent(jTextField8))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextField14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                .addComponent(jTextField10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)))))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4)
                    .addComponent(jButton11)
                    .addComponent(jButton12))
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel3)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel12)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6)
                    .addComponent(jLabel15))
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel13)
                            .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton7))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel4)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel14)
                            .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel6)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel7)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel16)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel18)
                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel8)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(5, 5, 5)
                .addComponent(jCheckBox1)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Основное", jPanel2);

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

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/refresh.png"))); // NOI18N
        jButton3.setText("Полотна");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1037, Short.MAX_VALUE)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Полотна", jPanel3);

        jToolBar2.setFloatable(false);
        jToolBar2.setRollover(true);

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/add.png"))); // NOI18N
        jButton8.setText("Добавить");
        jButton8.setEnabled(false);
        jButton8.setFocusable(false);
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton8);

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/edit.png"))); // NOI18N
        jButton9.setText("Изменить");
        jButton9.setEnabled(false);
        jButton9.setFocusable(false);
        jButton9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton9);

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/remove.png"))); // NOI18N
        jButton10.setText("Удалить");
        jButton10.setEnabled(false);
        jButton10.setFocusable(false);
        jButton10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton10.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton10);

        jTable2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable2.setRowHeight(26);
        jTable2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable2.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jTable2ComponentResized(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1037, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Возвраты", jPanel1);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Сохранить");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("Закрыть");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jToggleButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jToggleButton1.setText("Возвраты");
        jToggleButton1.setEnabled(false);
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jToggleButton1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jToggleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Сохранить
     * @param evt 
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        saveNastil();
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        setLocationRelativeTo(null);        
        
        jTable1.setModel(model);
        model.setDataForNastil(zadachaNastil.getZadachanastil());
        jTable1.setShowGrid(true);                    
        jTable1.getTableHeader().setReorderingAllowed(false);           
        jTable1ComponentResized(null); 
        jTextField13.setText(model.getAllQty().setScale(2, RoundingMode.HALF_EVEN).toString());
        jTable1.getColumnModel().getColumn(4).setCellRenderer(model.jTableRenderer);
        jTable1.getColumnModel().getColumn(5).setCellRenderer(model.jTableRenderer);
        jTable1.getColumnModel().getColumn(7).setCellRenderer(model.jTableRenderer);
        
        
        jTable2.setModel(modelDJ);
        modelDJ.setData(zadachaNastil.getDreturn().getDocument());
        jTable2.setShowGrid(true);                    
        jTable2.getTableHeader().setReorderingAllowed(false);           
        jTable2ComponentResized(null); 
        jTable2.getColumnModel().getColumn(7).setCellRenderer(jTableRenderer);
        jTable2.getColumnModel().getColumn(6).setCellRenderer(jTableRenderer);
        jTable2.getColumnModel().getColumn(5).setCellRenderer(jTableRenderer);
        jTable2.getColumnModel().getColumn(4).setCellRenderer(jTableRenderer);/**/
        
        modelDop.setData(zadachaNastil.getZadachanastil());
        jTable3.setModel(modelDop);
        jTable3.setShowGrid(true);                    
        jTable3.getTableHeader().setReorderingAllowed(false);   
        jTable3ComponentResized(null);
        
        modelPD.setData(zadachaNastil.getZadachanastil(), true);
        jTable4.setModel(modelPD);
        jTable4.setShowGrid(true);                    
        jTable4.getTableHeader().setReorderingAllowed(false);   
        jTable4ComponentResized(null);
    }//GEN-LAST:event_formWindowOpened

    private final DefaultTableCellRenderer jTableRenderer = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            JLabel cell = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            cell.setHorizontalAlignment(LEFT);
            if (column >3 && column <= 7)                
            {                
                cell.setHorizontalAlignment(RIGHT);
            }
            return cell;
        }

    };
    
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    /***
     * выбор типа настила
     * @param evt 
     */
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if(zadachaNastil.getZadachanastil() == 0)
            saveNastil();
        FGetTipNastila fg = new FGetTipNastila(null, true, zadachaNastil.getTipnastila().getTipnastila());
        fg.setVisible(true);
        if(fg.getResult())
        {
            zadachaNastil.setTipnastila(IOTipNastila.getListTipNastila(fg.getResultValue()).get(0));
            jTextField2.setText(zadachaNastil.getTipnastila().getName());
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    /***
     * Выбор типа настилания
     * @param evt 
     */
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        if(zadachaNastil.getZadachanastil() == 0)
            saveNastil();
        FGetTipNastilania fg = new FGetTipNastilania(null, true, zadachaNastil.getTipnastilania().getTipnastilania());
        fg.setVisible(true);
        if(fg.getResult())
        {
            zadachaNastil.setTipnastilania(IOTipNastila.getListTipNastilania(fg.getResultValue()).get(0));
            jTextField3.setText(zadachaNastil.getTipnastilania().getName());
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    /***
     * набрать полотна
     * @param evt 
     */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if(zadachaNastil.getZadachanastil() == 0)
            saveNastil();
        FGetProductForNastil fg = new FGetProductForNastil(null, true, zadachaNastil.getZadachanastil());
        fg.setSize(getWidth(), getHeight());
        fg.setVisible(true);
        model.setDataForNastil(zadachaNastil.getZadachanastil());
        jTextField13.setText(model.getAllQty().setScale(2, RoundingMode.HALF_EVEN).toString());
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTable1ComponentResized
        // TODO add your handling code here:
        if(jTable1.getColumnCount()<=0)
            return;
        int h = (jTable1.getWidth()-320)/3;
        
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(0);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(0).setMinWidth(0);
        
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(0);
        jTable1.getColumnModel().getColumn(6).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(6).setMinWidth(0);
        
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(h*2);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(h);
        
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(80);
               
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(80);
        jTable1.getColumnModel().getColumn(7).setPreferredWidth(80);
    }//GEN-LAST:event_jTable1ComponentResized

    /**
     * выбор резака
     * @param evt 
     */
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        if(zadachaNastil.getZadachanastil() == 0)
            saveNastil();
        FGetRabotnik fg = new FGetRabotnik(null, true, zadachaNastil.getRezak().getRabotnik(), 5);
        fg.setVisible(true);
        if(fg.getResult())
        {
            zadachaNastil.setRezak(IORabotnik.getListRabotnik(fg.getResultValue()).get(0));
            jTextField11.setText(zadachaNastil.getRezak().getName());
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    /**
     * выбор настильщика
     * @param evt 
     */
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        if(zadachaNastil.getZadachanastil() == 0)
            saveNastil();
        FGetRabotnik fg = new FGetRabotnik(null, true, zadachaNastil.getNastil().getRabotnik(), 4);
        fg.setVisible(true);
        if(fg.getResult())
        {
            zadachaNastil.setNastil(IORabotnik.getListRabotnik(fg.getResultValue()).get(0));
            jTextField12.setText(zadachaNastil.getNastil().getName());
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    /**
     * добавить полотно для возврата на склад
     * @param evt 
     */
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        //если документа возврата еще нет то создадим его
        if(zadachaNastil.getDreturn().getDocument() == 0)
        {
            Document d = new Document();
            d.setAgent(new Agent(12));
            d.setDates(zadachaNastil.getZadacha().getDates());
            d.setDel(0);
            d.setDocument(0);
            d.setNomer(zadachaNastil.getNomer());
            d.setStatus(0);
            d.setVid(3);
            d = IODocument.setDocument(d);
            zadachaNastil.setDreturn(d);
            zadachaNastil =  IOZadachaNastil.setZadachaNastil(zadachaNastil);
            //zadachaNastil.setZadacha(IOZadacha.setZadacha(zd));
        }
        FGetProductForReturn fg = new FGetProductForReturn(null, true, zadachaNastil.getZadachanastil(), 0, zadachaNastil.getDreturn().getDocument());
        fg.setVisible(true);
        modelDJ.setData(zadachaNastil.getDreturn().getDocument());
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jTable2ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTable2ComponentResized
        // TODO add your handling code here:
        /*if(jTable2.getColumnCount()<=0)
            return;
        int h = (jTable2.getWidth()-400)/3;
        
        jTable2.getColumnModel().getColumn(0).setPreferredWidth(0);
        jTable2.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable2.getColumnModel().getColumn(0).setMinWidth(0);
        
        jTable2.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTable2.getColumnModel().getColumn(2).setPreferredWidth(h);
        jTable2.getColumnModel().getColumn(3).setPreferredWidth(h);
        jTable2.getColumnModel().getColumn(4).setPreferredWidth(80);        
        jTable2.getColumnModel().getColumn(5).setPreferredWidth(80);
        
        jTable2.getColumnModel().getColumn(6).setPreferredWidth(80);        
        jTable2.getColumnModel().getColumn(7).setPreferredWidth(80);
            
        jTable2.getColumnModel().getColumn(8).setPreferredWidth(h);*/
        if(jTable2.getColumnCount()<=0)
            return;
        int h = (jTable2.getWidth()-400)/3;
        
        jTable2.getColumnModel().getColumn(0).setPreferredWidth(0);
        jTable2.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable2.getColumnModel().getColumn(0).setMinWidth(0);
        
        jTable2.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTable2.getColumnModel().getColumn(2).setPreferredWidth(h);
        jTable2.getColumnModel().getColumn(3).setPreferredWidth(h);
        jTable2.getColumnModel().getColumn(4).setPreferredWidth(80);        
        
        jTable2.getColumnModel().getColumn(5).setPreferredWidth(0);
        jTable2.getColumnModel().getColumn(5).setMaxWidth(0);
        jTable2.getColumnModel().getColumn(5).setMinWidth(0);
        
        jTable2.getColumnModel().getColumn(6).setPreferredWidth(80);        
        
        jTable2.getColumnModel().getColumn(7).setPreferredWidth(0);
        jTable2.getColumnModel().getColumn(7).setMaxWidth(0);
        jTable2.getColumnModel().getColumn(7).setMinWidth(0);
        
        jTable2.getColumnModel().getColumn(8).setPreferredWidth(80);        
        jTable2.getColumnModel().getColumn(9).setPreferredWidth(80);        
        jTable2.getColumnModel().getColumn(10).setPreferredWidth(h);        
            
        jTable2.getColumnModel().getColumn(11).setPreferredWidth(0);
        jTable2.getColumnModel().getColumn(11).setMaxWidth(0);
        jTable2.getColumnModel().getColumn(11).setMinWidth(0);
    }//GEN-LAST:event_jTable2ComponentResized

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        int h = jTable2.getSelectedRow();
        if(h==-1) return;
        FGetProductForReturn fg = new FGetProductForReturn(null, true, zadachaNastil.getZadachanastil(), (int)jTable2.getValueAt(h, 0), zadachaNastil.getDreturn().getDocument());
        fg.setVisible(true);
        modelDJ.setData(zadachaNastil.getDreturn().getDocument());
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        int h = jTable2.getSelectedRow();
        if(h==-1)
            return;
        h = (int) jTable2.getValueAt(h, 0);
        if (JOptionPane.showConfirmDialog(null, "Вы действительно хотите удалить <" + jTable2.getValueAt(jTable2.getSelectedRow(), 2) + ">?", "Вопрос.", JOptionPane.YES_NO_OPTION) == 0) 
        {
            if(IODocument.delDocumentJournal(h))
                modelDJ.setData(zadachaNastil.getDreturn().getDocument());
            else
                JOptionPane.showMessageDialog(null, "Ошибка удаления");
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
        // если хотим делать возвраты
        if(jToggleButton1.isSelected())            
        {            
            // сохраним настил
            saveNastil();
            //нажали формирование возвратов
            // проверим веса
            if(!IOZadachaNastil.executeNastilForQty(zadachaNastil.getZadachanastil()))
            {
                JOptionPane.showMessageDialog(null, "Общий вес настила не соответствует сумме итоговых весов!");
                jToggleButton1.setSelected(false);
                return;
            }
            // изменим интерфейс
            jButton1.setEnabled(false);
            jButton3.setEnabled(false);
            jButton4.setEnabled(false);
            jButton5.setEnabled(false);
            jButton6.setEnabled(false);
            jButton7.setEnabled(false);
            
            jButton8.setEnabled(true);
            jButton9.setEnabled(true);
            jButton10.setEnabled(true);
        }
        else
        {
            // проверим есть или нет возвраты
            // если документ возврата даже не создан
            if(zadachaNastil.getDreturn().getDocument() == 0)
                return;
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jTable3ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTable3ComponentResized
        // TODO add your handling code here:
        if(jTable3.getColumnCount()<=0)
            return;
        int h = (jTable3.getWidth())/5;
        
        jTable3.getColumnModel().getColumn(0).setPreferredWidth(0);
        jTable3.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable3.getColumnModel().getColumn(0).setMinWidth(0);
        
        jTable3.getColumnModel().getColumn(1).setPreferredWidth(h);  
        jTable3.getColumnModel().getColumn(2).setPreferredWidth(h);  
        jTable3.getColumnModel().getColumn(3).setPreferredWidth(h); 
        jTable3.getColumnModel().getColumn(4).setPreferredWidth(h); 
        jTable3.getColumnModel().getColumn(5).setPreferredWidth(h); 
    }//GEN-LAST:event_jTable3ComponentResized

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        FAddZadachaNastilDop f = new FAddZadachaNastilDop(null, true);
        f.setVisible(true);
        if(f.getResult())
        {
            ZadachaNastilDop z = new ZadachaNastilDop();
            z.setLight(f.getDlina());
            z.setName(f.getNames());
            z.setKolsloidop(f.getKolIzdDop());
            z.setQty(0);
            z.setKolsloi(f.getKolIzd());
            z.setZadachanastil(zadachaNastil.getZadachanastil());
            z.setZadachanastildop(0);
            
            IOZadachaNastil.setZadachaNastilDop(z);
            modelDop.setData(zadachaNastil.getZadachanastil());
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
         int h = jTable3.getSelectedRow();
        if(h==-1)
            return;        
        if (JOptionPane.showConfirmDialog(null, "Вы действительно хотите удалить размер<" + jTable3.getValueAt(jTable3.getSelectedRow(), 1) + ">?", "Вопрос.", JOptionPane.YES_NO_OPTION) == 0) 
        {
            if(!IOZadachaNastil.delZadachaNastilDop((int)jTable3.getValueAt(h, 0)))
            {
                JOptionPane.showMessageDialog(null, "Ошибка удаления!");
                return;
            }
            modelDop.setData(zadachaNastil.getZadachanastil());
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jTable4ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTable4ComponentResized
        // TODO add your handling code here:
        if(jTable4.getColumnCount()<=0)
            return;
        int h = (jTable4.getWidth()-110)/1;
        
        jTable4.getColumnModel().getColumn(0).setPreferredWidth(0);
        jTable4.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable4.getColumnModel().getColumn(0).setMinWidth(0);
        
        jTable4.getColumnModel().getColumn(1).setPreferredWidth(40);          
        jTable4.getColumnModel().getColumn(2).setPreferredWidth(h);  
        jTable4.getColumnModel().getColumn(3).setPreferredWidth(70); 
    }//GEN-LAST:event_jTable4ComponentResized

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
            java.util.logging.Logger.getLogger(FZadachaNastil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FZadachaNastil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FZadachaNastil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FZadachaNastil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                FZadachaNastil dialog = new FZadachaNastil(new javax.swing.JFrame(), true, 0, 0);
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
    private javax.swing.JCheckBox jCheckBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSpinner jSpinner3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    // End of variables declaration//GEN-END:variables

    /**
     * сохранить настил
     */
    private void saveNastil()
    {
        zadachaNastil.setNomer(jTextField1.getText());        
        zadachaNastil.setAddarticle(jTextField9.getText());
        zadachaNastil.setPlusdlina((int)jSpinner3.getValue());
        zadachaNastil.setDates(jDateChooser1.getDate());
        zadachaNastil.setDlina(HelpClass.GetBigDecimalIzText(jTextField4.getText()));
        zadachaNastil.setDlinakonc(HelpClass.GetBigDecimalIzText(jTextField5.getText()));
        zadachaNastil.setBeika(jTextField6.getText());
        zadachaNastil.setPachka(jCheckBox1.isSelected()?1:0);
        zadachaNastil.setAddarticletext(jTextField7.getText());
        zadachaNastil.setTexts(jTextField8.getText());
        zadachaNastil.setWidth(HelpClass.GetIntIzText(jTextField10.getText()));
        zadachaNastil.setKolsloi(HelpClass.GetIntIzText(jTextField14.getText()));
        zadachaNastil.setKolsloidop(HelpClass.GetIntIzText(jTextField15.getText()));
        
        
        
        
        
        /*zadachaNastil.setQtyaddarticle(HelpClass.GetBigDecimalIzText(jTextField10.getText()));
        zadachaNastil.setQtydel(HelpClass.GetBigDecimalIzText(jTextField5.getText()));
        zadachaNastil.setQtyend(HelpClass.GetBigDecimalIzText(jTextField4.getText()));
        zadachaNastil.setQtygut(HelpClass.GetBigDecimalIzText(jTextField7.getText()));
        zadachaNastil.setQtyl((int)jSpinner1.getValue());        
        zadachaNastil.setQtylosk(HelpClass.GetBigDecimalIzText(jTextField6.getText()));
        zadachaNastil.setQtytruba(HelpClass.GetBigDecimalIzText(jTextField8.getText()));
        zadachaNastil.setQtyreturn(HelpClass.GetBigDecimalIzText(jTextField14.getText()));*/
        
        zadachaNastil = IOZadachaNastil.setZadachaNastil(zadachaNastil);
    }

    private void loadZN() {
        zadachaNastil = IOZadachaNastil.getListZadachaNastil(0, zadachaNastil.getZadachanastil()).get(0);
        jTextField1.setText(zadachaNastil.getNomer());
        jTextField2.setText(zadachaNastil.getTipnastila().getName());
        jTextField3.setText(zadachaNastil.getTipnastilania().getName());
        jSpinner3.setValue(zadachaNastil.getPlusdlina());
        jDateChooser1.setDate(zadachaNastil.getDates());
        jTextField10.setText(zadachaNastil.getWidth().toString());
        jTextField14.setText(zadachaNastil.getKolsloi().toString());
        jTextField15.setText(zadachaNastil.getKolsloidop().toString());
        //jSpinner1.setValue(zadachaNastil.getQtyl());
        jTextField4.setText(zadachaNastil.getDlina().setScale(0, RoundingMode.HALF_EVEN).toString());
        //jTextField5.setText(zadachaNastil.getQtydel().setScale(2, RoundingMode.HALF_EVEN).toString());
        //jTextField6.setText(zadachaNastil.getQtylosk().setScale(2, RoundingMode.HALF_EVEN).toString());
        //jTextField7.setText(zadachaNastil.getQtygut().setScale(2, RoundingMode.HALF_EVEN).toString());
        //jTextField8.setText(zadachaNastil.getQtytruba().setScale(2, RoundingMode.HALF_EVEN).toString());
        jTextField9.setText(zadachaNastil.getAddarticle());
        //jTextField10.setText(zadachaNastil.getQtyaddarticle().setScale(2, RoundingMode.HALF_EVEN).toString());
        //jTextField14.setText(zadachaNastil.getQtyreturn().setScale(2, RoundingMode.HALF_EVEN).toString());
        jTextField11.setText(zadachaNastil.getRezak().getName());
        jTextField12.setText(zadachaNastil.getNastil().getName());
        jTextField5.setText(zadachaNastil.getDlinakonc().setScale(0, RoundingMode.HALF_EVEN).toString());
        jTextField6.setText(zadachaNastil.getBeika());
        jCheckBox1.setSelected(zadachaNastil.getPachka()==1);
        jTextField7.setText(zadachaNastil.getAddarticletext());
        jTextField8.setText(zadachaNastil.getTexts());
        // если задача закрыта на редактирование настилов
        if(zadachaNastil.getZadacha().getStatus() > 2)
        {
            jButton1.setEnabled(false);
            jButton3.setEnabled(false);
            jButton4.setEnabled(false);
            jButton5.setEnabled(false);
            jButton6.setEnabled(false);
            jButton7.setEnabled(false);
            
            jButton11.setEnabled(false);            
            jButton12.setEnabled(false);
            
            modelDop.setEditStop();
            
        }
        
        if(zadachaNastil.getStatus()>0)
        {
            jButton1.setEnabled(false);
            jButton3.setEnabled(false);
            jButton4.setEnabled(false);
            jButton5.setEnabled(false);
            jButton6.setEnabled(false);
            jButton7.setEnabled(false);
            
            jButton11.setEnabled(false);            
            jButton12.setEnabled(false);
            
            modelDop.setEditStop();
            
        }
    }
}
