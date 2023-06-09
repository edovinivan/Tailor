/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui;

import java.io.File;
import org.example.Gui.Analit.FAnalitika1;
import org.example.Gui.Analit.FArticleNastils;
import org.example.Gui.Analit.FGetPrognoz;
import org.example.Gui.Analit.FGetPrognoz1;
import org.example.Gui.Analit.LAArticle;
import org.example.Gui.Analit.LAColor;
import org.example.Gui.Analit.LARazmeri;
import org.example.Gui.Analit.LAnalitikaNovinka;
import org.example.Gui.Analit.LModelPlan;
import org.example.Gui.Analit.LModelPlanHaupt;
import org.example.Gui.Analit.LPZakupki;
import org.example.Gui.Plan.PlanArticle.LPlanArticle;
import org.example.Gui.Analit.LTimeOperation;
import org.example.Gui.Arbait.LAllKomplektovka;
import org.example.Gui.Arbait.LAllNastil;
import org.example.Gui.Arbait.LAllNastilForReturn;
import org.example.Gui.Arbait.LDopMarshrut;
import org.example.Gui.Arbait.LMarshrut;
import org.example.Gui.Arbait.LMarshrut1;
import org.example.Gui.Arbait.LMarshrutGo;
import org.example.Gui.Arbait.LPretenzia;
import org.example.Gui.Arbait.LRabotnikOperation;
import org.example.Gui.Arbait.LScladKroi;
import org.example.Gui.Arbait.LScladLoskut;
import org.example.Gui.Arbait.LScladLoskutSale;
import org.example.Gui.Arbait.LZadacha;
import org.example.Gui.Arbait.LZadachaEndArbait;
import org.example.Gui.Arbait.LZadachaFurnitura;
import org.example.Gui.Arbait.LZadachaKomplektovka;
import org.example.Gui.Arbait.LZadachaMaterial;
import org.example.Gui.Arbait.LZadachaNastils;
import org.example.Gui.Arbait.LZadachaPrintDetali;
import org.example.Gui.FOT.FParamReportPrintRabotnik;
import org.example.Gui.FOT.LFot;
import org.example.Gui.Form.FCalcTimeModel;
import org.example.Gui.Form.FConnectOperator;
import org.example.Gui.Form.FSaveExcel;
import org.example.Gui.Form.FUpdate;
import org.example.Gui.Form.Helps.FAddName;
import org.example.Gui.Form.Report.LReport;
import org.example.Gui.List.LAgent;
import org.example.Gui.List.LColor;
import org.example.Gui.List.LDocReturn;
import org.example.Gui.List.LDocReturnF;
import org.example.Gui.List.LDocument;
import org.example.Gui.List.LDocumentF;
import org.example.Gui.List.LDocumentReturn;
import org.example.Gui.List.LDocumentReturnSclad;
import org.example.Gui.List.LFurnituraChex;
import org.example.Gui.List.LFurnituraOffAll;
import org.example.Gui.List.LFurnituraReturnSclad;
import org.example.Gui.List.LFurnituraScladAll;
import org.example.Gui.List.LFurnituraScladOff;
import org.example.Gui.List.LKleevaya;
import org.example.Gui.List.LMModelComment;
import org.example.Gui.List.LMModelProperty;
import org.example.Gui.List.LMProperty;
import org.example.Gui.List.LMeasure;
import org.example.Gui.List.LModel;
import org.example.Gui.List.LOperation;
import org.example.Gui.List.LOperationGruppa;
import org.example.Gui.List.LOperator;
import org.example.Gui.List.LPrintDetal;
import org.example.Gui.List.LProduct;
import org.example.Gui.List.LProductGruppa;
import org.example.Gui.List.LRabotnik;
import org.example.Gui.List.LRabotnikGruppa;
import org.example.Gui.List.LRaskladchik;
import org.example.Gui.List.LRazmeri;
import org.example.Gui.List.LRazmeriGruppa;
import org.example.Gui.List.LRazrad;
import org.example.Gui.List.LRevizia;
import org.example.Gui.List.LSablon;
import org.example.Gui.List.LSclad;
import org.example.Gui.List.LScladProduct;
import org.example.Gui.List.LScladProduct1;
import org.example.Gui.List.LScladProductChex;
import org.example.Gui.List.LTipModel;
import org.example.Gui.List.LTipNastila;
import org.example.Gui.List.LTipProduct;
import org.example.Gui.Plan.LCalendar;
import org.example.Gui.Plan.LTimeOpChex;
import org.example.Gui.Plan.PlanArticle.LMapProject;
import org.example.Gui.Uchet.LUDocument;
import org.example.Gui.Uchet.LUOperDoc;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import static java.lang.System.exit;
import java.math.BigDecimal;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import org.example.Gui.List.LOperationTextGruppa;
import org.example.logic.Files;
import org.example.util.HelpClass;
import org.example.util.IOFiles;
import org.example.util.IOOperator;
import org.example.util.IOSetup;

/**
 *
 * @author ivan
 */
public class THaupt extends javax.swing.JFrame {

    /**
     * Creates new form THaupt
     */
    public THaupt() {
        FConnectOperator f = new FConnectOperator(null, true);
        f.setVisible(true);        
        initComponents();       
    }

    LProduct lProduct = new LProduct(this, 1);
    LProduct lFurnitura = new LProduct(this, 2);
    LDocument lDocument = new LDocument(this, 1);
    LDocument lDocumentF = new LDocument(this, 2);
    LDocumentReturn lDocumentReturn = new LDocumentReturn(this, 1);
    LFurnituraScladOff lDocumentReturnF = new LFurnituraScladOff(this);
    LAgent lAgent = new LAgent(this, 1);
    LAgent lAgentF = new LAgent(this, 2);
    LOperation lOperation = new LOperation(this);
    LOperationGruppa lOperationGruppa = new LOperationGruppa(this);
    LColor lColor = new LColor(this, 1);
    LColor lColorNitki = new LColor(this, 2);
    LColor lColorFurnitura = new LColor(this, 3);
    LKleevaya lKleevaya = new LKleevaya(this);
    LPrintDetal lPrintDetali = new LPrintDetal(this, 1);
    LPrintDetal lVichivkaDetali = new LPrintDetal(this, 2);
    LPrintDetal lTermoPrintDetali = new LPrintDetal(this, 3);
    LRaskladchik lRaskladchik = new LRaskladchik(this);
    LTipModel lTipModel = new LTipModel(this);
    LTipNastila lTipNastila = new LTipNastila(this);
    LRazmeriGruppa lRazmeriGruppa = new LRazmeriGruppa(this);
    LRazmeri lRazmeri = new LRazmeri(this, false);
    LRazmeri lRazmeri1C = new LRazmeri(this, true);
    LRabotnikGruppa lRabotnikGruppa = new LRabotnikGruppa(this);
    LRabotnik lRabotnik = new LRabotnik(this);
    LSablon lSablon = new LSablon(this);
    LSclad lSclad = new LSclad(this);
    LScladProduct lScladProduct = new LScladProduct(this, 1,1);
    LScladProduct1 lScladProduct1 = new LScladProduct1(this, 1,1);
    LScladProduct lScladProductNo = new LScladProduct(this, 1,0);
    //LScladProduct lScladProductF = new LScladProduct(this, 2,1);
    LFurnituraScladAll lScladProductF = new LFurnituraScladAll(this);
    LModel lModel = new LModel(this);
    LMeasure lMeasure = new LMeasure(this);
    LTipProduct lTipProduct = new LTipProduct(this);
    LZadacha lZadacha = new LZadacha(this, 1);
    LZadachaMaterial lZadachaMaterial = new LZadachaMaterial(this);
    LZadachaEndArbait lZadachaAllNastil = new LZadachaEndArbait(this);
    LRazrad lRazrad = new LRazrad(this);
    LAllNastil lAllNastil = new LAllNastil(this);
    LZadachaFurnitura lZadachaFurnitura = new LZadachaFurnitura(this);
    LZadachaKomplektovka lZadachaKomplektovka = new LZadachaKomplektovka(this);
    LMarshrut lMarshrut = new LMarshrut(this, 3);
    LMarshrut1 lMarshrut1 = new LMarshrut1(this, 3);
    LRabotnikOperation lRabotnikOperation = new LRabotnikOperation(this);
    LAllKomplektovka lAllKomplektovka = new LAllKomplektovka(this, 0);
    LAllKomplektovka lAllKomplektovkaHand = new LAllKomplektovka(this, 1);
    LOperator lOperator = new  LOperator(this);
    LMarshrutGo lMarshrutGo = new LMarshrutGo(this);
    LAllNastilForReturn lAllNastilForReturn = new LAllNastilForReturn(this);
    LZadachaPrintDetali lZadachaPrintDetali = new LZadachaPrintDetali(this, 1);
    LZadachaPrintDetali lZadachaPrintDetaliV = new LZadachaPrintDetali(this, 2);
    LDocumentReturnSclad lDocumentReturnSclad = new LDocumentReturnSclad(this);
    LFot lFot = new LFot(this);
    LZadachaNastils  lZadachaNastils = new LZadachaNastils(this, 0);
    LZadachaNastils  lZadachaNastilsHand = new LZadachaNastils(this, 1);
    LProductGruppa lProductGruppa1 = new LProductGruppa(this, 1);
    LProductGruppa lProductGruppa2 = new LProductGruppa(this, 2);
    //FAnalitika fan = new FAnalitika(this);
    FAnalitika1 fan1 = new FAnalitika1(this);
    LPretenzia lPretenzia = new LPretenzia(this);
    LDocReturn lDocReturn = new LDocReturn(this);
    LRevizia lRevizia = new LRevizia(this);
    LScladProductChex lScladProductChex = new LScladProductChex(this, 3);
    LScladProductChex lScladProductBeika = new LScladProductChex(this, 4);
    
    LTimeOpChex lTimeOpChex = new LTimeOpChex(this);
    FArticleNastils fArticleNastils = new FArticleNastils(this);
    LModelPlan lModelPlan = new LModelPlan(this);
    LAColor laColor = new LAColor(this);
    LAArticle laArticle = new LAArticle(this);
    LPZakupki lPZakupki = new LPZakupki(this);
    LScladKroi lScladKroi = new LScladKroi(this);
    LUDocument lUDocument = new LUDocument(this);
    LDocumentF lDocF = new LDocumentF(this);
    LFurnituraChex lFurnituraChex = new LFurnituraChex(this);
    LFurnituraOffAll lFurnituraOffAll = new LFurnituraOffAll(this);    
    LDocReturnF lDocReturnF = new LDocReturnF(this);
    LFurnituraReturnSclad lFurnituraReturnSclad = new LFurnituraReturnSclad(this);
    LMProperty lMProperty = new LMProperty(this);
    LMModelProperty lMModelProperty = new LMModelProperty(this);
    LAnalitikaNovinka lAnalitikaNovinka = new LAnalitikaNovinka(this);
    LARazmeri lARazmeri = new LARazmeri(this);
    LDopMarshrut lDopMarshrut = new LDopMarshrut(this);
    LScladLoskut lScladLoskut = new LScladLoskut(this, 2);
    LScladLoskut lScladLoskut1 = new LScladLoskut(this, 1);
    LScladLoskutSale lScladLoskutSale = new LScladLoskutSale(this);
    
    LUOperDoc lUOperDoc = new LUOperDoc(this);
    LModelPlanHaupt lModelPlanHaupt = new LModelPlanHaupt(this);
    FCalcTimeModel fCalcTimeModel = new FCalcTimeModel(this);
    
    LOperationTextGruppa lOperationTextGruppa = new LOperationTextGruppa(this);
    
    LMapProject lMapProject = new LMapProject(this);

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jToolBar1 = new javax.swing.JToolBar();
        jButton2 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem24 = new javax.swing.JMenuItem();
        jMenuItem59 = new javax.swing.JMenuItem();
        jMenuItem60 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem30 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem110 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem43 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem26 = new javax.swing.JMenuItem();
        jMenuItem29 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem25 = new javax.swing.JMenuItem();
        jMenuItem126 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenuItem20 = new javax.swing.JMenuItem();
        jMenuItem21 = new javax.swing.JMenuItem();
        jMenuItem27 = new javax.swing.JMenuItem();
        jMenuItem28 = new javax.swing.JMenuItem();
        jMenuItem37 = new javax.swing.JMenuItem();
        jMenuItem144 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem122 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem22 = new javax.swing.JMenuItem();
        jMenuItem116 = new javax.swing.JMenuItem();
        jMenuItem34 = new javax.swing.JMenuItem();
        jMenuItem36 = new javax.swing.JMenuItem();
        jMenuItem48 = new javax.swing.JMenuItem();
        jMenuItem64 = new javax.swing.JMenuItem();
        jMenuItem65 = new javax.swing.JMenuItem();
        jMenuItem66 = new javax.swing.JMenuItem();
        jMenuItem68 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItem119 = new javax.swing.JMenuItem();
        jMenuItem120 = new javax.swing.JMenuItem();
        jMenuItem121 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem31 = new javax.swing.JMenuItem();
        jMenuItem32 = new javax.swing.JMenuItem();
        jMenuItem98 = new javax.swing.JMenuItem();
        jMenuItem58 = new javax.swing.JMenuItem();
        jMenuItem95 = new javax.swing.JMenuItem();
        jMenuItem107 = new javax.swing.JMenuItem();
        jMenuItem96 = new javax.swing.JMenuItem();
        jMenuItem97 = new javax.swing.JMenuItem();
        jMenuItem100 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem99 = new javax.swing.JMenuItem();
        jMenuItem101 = new javax.swing.JMenuItem();
        jMenuItem102 = new javax.swing.JMenuItem();
        jMenuItem106 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem33 = new javax.swing.JMenuItem();
        jMenuItem51 = new javax.swing.JMenuItem();
        jMenuItem35 = new javax.swing.JMenuItem();
        jMenuItem38 = new javax.swing.JMenuItem();
        jMenuItem45 = new javax.swing.JMenuItem();
        jMenuItem46 = new javax.swing.JMenuItem();
        jMenuItem47 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem39 = new javax.swing.JMenuItem();
        jMenuItem93 = new javax.swing.JMenuItem();
        jMenuItem44 = new javax.swing.JMenuItem();
        jMenuItem40 = new javax.swing.JMenuItem();
        jMenuItem115 = new javax.swing.JMenuItem();
        jMenuItem114 = new javax.swing.JMenuItem();
        jMenuItem62 = new javax.swing.JMenuItem();
        jMenuItem74 = new javax.swing.JMenuItem();
        jMenuItem75 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem41 = new javax.swing.JMenuItem();
        jMenuItem53 = new javax.swing.JMenuItem();
        jMenuItem123 = new javax.swing.JMenuItem();
        jMenuItem124 = new javax.swing.JMenuItem();
        jMenuItem127 = new javax.swing.JMenuItem();
        jMenu10 = new javax.swing.JMenu();
        jMenuItem49 = new javax.swing.JMenuItem();
        jMenuItem50 = new javax.swing.JMenuItem();
        jMenuItem54 = new javax.swing.JMenuItem();
        jMenuItem55 = new javax.swing.JMenuItem();
        jMenuItem56 = new javax.swing.JMenuItem();
        jMenu13 = new javax.swing.JMenu();
        jMenuItem140 = new javax.swing.JMenuItem();
        jMenuItem141 = new javax.swing.JMenuItem();
        jMenuItem142 = new javax.swing.JMenuItem();
        jMenuItem143 = new javax.swing.JMenuItem();
        jMenuItem76 = new javax.swing.JMenuItem();
        jMenuItem91 = new javax.swing.JMenuItem();
        jMenuItem57 = new javax.swing.JMenuItem();
        jMenuItem67 = new javax.swing.JMenuItem();
        jMenuItem71 = new javax.swing.JMenuItem();
        jMenuItem128 = new javax.swing.JMenuItem();
        jMenuItem72 = new javax.swing.JMenuItem();
        jMenuItem77 = new javax.swing.JMenuItem();
        jMenuItem80 = new javax.swing.JMenuItem();
        jMenuItem81 = new javax.swing.JMenuItem();
        jMenuItem86 = new javax.swing.JMenuItem();
        jMenuItem103 = new javax.swing.JMenuItem();
        jMenuItem104 = new javax.swing.JMenuItem();
        jMenuItem105 = new javax.swing.JMenuItem();
        jMenuItem89 = new javax.swing.JMenuItem();
        jMenuItem117 = new javax.swing.JMenuItem();
        jMenuItem118 = new javax.swing.JMenuItem();
        jMenuItem129 = new javax.swing.JMenuItem();
        jMenuItem132 = new javax.swing.JMenuItem();
        jMenuItem139 = new javax.swing.JMenuItem();
        jMenuItem145 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem23 = new javax.swing.JMenuItem();
        jMenuItem69 = new javax.swing.JMenuItem();
        jMenuItem70 = new javax.swing.JMenuItem();
        jMenuItem73 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem42 = new javax.swing.JMenuItem();
        jMenuItem52 = new javax.swing.JMenuItem();
        jMenuItem63 = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        jMenu11 = new javax.swing.JMenu();
        jMenuItem130 = new javax.swing.JMenuItem();
        jMenuItem131 = new javax.swing.JMenuItem();
        jMenuItem85 = new javax.swing.JMenuItem();
        jMenuItem134 = new javax.swing.JMenuItem();
        jMenuItem79 = new javax.swing.JMenuItem();
        jMenuItem108 = new javax.swing.JMenuItem();
        jMenuItem109 = new javax.swing.JMenuItem();
        jMenuItem111 = new javax.swing.JMenuItem();
        jMenuItem61 = new javax.swing.JMenuItem();
        jMenuItem78 = new javax.swing.JMenuItem();
        jMenuItem82 = new javax.swing.JMenuItem();
        jMenuItem83 = new javax.swing.JMenuItem();
        jMenuItem84 = new javax.swing.JMenuItem();
        jMenuItem125 = new javax.swing.JMenuItem();
        jMenuItem87 = new javax.swing.JMenuItem();
        jMenuItem88 = new javax.swing.JMenuItem();
        jMenuItem90 = new javax.swing.JMenuItem();
        jMenuItem92 = new javax.swing.JMenuItem();
        jMenuItem94 = new javax.swing.JMenuItem();
        jMenuItem113 = new javax.swing.JMenuItem();
        jMenuItem112 = new javax.swing.JMenuItem();
        jMenuItem133 = new javax.swing.JMenuItem();
        jMenuItem135 = new javax.swing.JMenuItem();
        jMenuItem136 = new javax.swing.JMenuItem();
        jMenuItem137 = new javax.swing.JMenuItem();
        jMenu12 = new javax.swing.JMenu();
        jMenuItem138 = new javax.swing.JMenuItem();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tailor 1.0");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Пользователь");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("v 1.3");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addComponent(jLabel2))
        );

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);

        jToolBar1.setRollover(true);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/add.png"))); // NOI18N
        jButton2.setText("Поставки");
        jButton2.setToolTipText("Поставки полотна");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/preferences.png"))); // NOI18N
        jButton8.setText("Остатки");
        jButton8.setFocusable(false);
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton8);
        jToolBar1.add(jSeparator4);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/vcard.png"))); // NOI18N
        jButton4.setText("Конф. карты");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton4);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/down.png"))); // NOI18N
        jButton3.setText("Настилы");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/compose.png"))); // NOI18N
        jButton5.setText("Комплектовка");
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton5);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/lorrygreen.png"))); // NOI18N
        jButton6.setText("Маршруты");
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton6);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/icons8-Forward_16.png"))); // NOI18N
        jButton7.setText("Учет оп.");
        jButton7.setFocusable(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton7);

        jMenuBar1.setBorder(null);
        jMenuBar1.setPreferredSize(new java.awt.Dimension(336, 30));

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/house.png"))); // NOI18N
        jMenu1.setText("Файл");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/cancel.png"))); // NOI18N
        jMenuItem1.setText("Выход");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setBorder(null);
        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/application.png"))); // NOI18N
        jMenu2.setText("Справочники");

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/cascade.png"))); // NOI18N
        jMenuItem2.setText("Тип полотна");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/sun.png"))); // NOI18N
        jMenuItem24.setText("Фурнитура");
        jMenuItem24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem24ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem24);

        jMenuItem59.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/sun.png"))); // NOI18N
        jMenuItem59.setText("Группы полотен");
        jMenuItem59.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem59ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem59);

        jMenuItem60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/sun.png"))); // NOI18N
        jMenuItem60.setText("Группы фурнитуры");
        jMenuItem60.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem60ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem60);

        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/lorrygreen.png"))); // NOI18N
        jMenuItem6.setText("Поставщики полотна");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuItem30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/sun.png"))); // NOI18N
        jMenuItem30.setText("Поставщики фурнитуры");
        jMenuItem30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem30ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem30);

        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/sun.png"))); // NOI18N
        jMenuItem9.setText("Конфекционные карты");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem9);

        jMenuItem110.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/catapult.png"))); // NOI18N
        jMenuItem110.setText("Комментарий к артикулам");
        jMenuItem110.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem110ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem110);

        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/work.png"))); // NOI18N
        jMenuItem7.setText("Операции");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuItem43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/sun.png"))); // NOI18N
        jMenuItem43.setText("Группы операций");
        jMenuItem43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem43ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem43);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/sun.png"))); // NOI18N
        jMenuItem5.setText("Цвет полотна");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/sun.png"))); // NOI18N
        jMenuItem26.setText("Цвет ниток");
        jMenuItem26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem26ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem26);

        jMenuItem29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/sun.png"))); // NOI18N
        jMenuItem29.setText("Цвет фурнитуры");
        jMenuItem29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem29ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem29);

        jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/sun.png"))); // NOI18N
        jMenuItem10.setText("Клеевая");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem10);

        jMenuItem12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/sun.png"))); // NOI18N
        jMenuItem12.setText("Детали с принтом");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem12);

        jMenuItem25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/sun.png"))); // NOI18N
        jMenuItem25.setText("Детали с вышивкой");
        jMenuItem25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem25ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem25);

        jMenuItem126.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/sun.png"))); // NOI18N
        jMenuItem126.setText("Детали с термо печатью");
        jMenuItem126.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem126ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem126);

        jMenuItem13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/sun.png"))); // NOI18N
        jMenuItem13.setText("Раскладчик");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem13);

        jMenuItem14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/sun.png"))); // NOI18N
        jMenuItem14.setText("Типы моделей");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem14);

        jMenuItem15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/sun.png"))); // NOI18N
        jMenuItem15.setText("Тип настила");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem15);

        jMenuItem16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/sun.png"))); // NOI18N
        jMenuItem16.setText("Группы размеров");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem16);

        jMenuItem17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/sun.png"))); // NOI18N
        jMenuItem17.setText("Размеры");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem17);

        jMenuItem18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/sun.png"))); // NOI18N
        jMenuItem18.setText("Группы сотрудников");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem18);

        jMenuItem19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/sun.png"))); // NOI18N
        jMenuItem19.setText("Сотрудники");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem19);

        jMenuItem20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/sun.png"))); // NOI18N
        jMenuItem20.setText("Шаблоны");
        jMenuItem20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem20ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem20);

        jMenuItem21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/sun.png"))); // NOI18N
        jMenuItem21.setText("Место хранения");
        jMenuItem21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem21ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem21);

        jMenuItem27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/sun.png"))); // NOI18N
        jMenuItem27.setText("Единицы измерения");
        jMenuItem27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem27ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem27);

        jMenuItem28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/sun.png"))); // NOI18N
        jMenuItem28.setText("Виды полотен");
        jMenuItem28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem28ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem28);

        jMenuItem37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/sun.png"))); // NOI18N
        jMenuItem37.setText("Разряды");
        jMenuItem37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem37ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem37);

        jMenuItem144.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/sun.png"))); // NOI18N
        jMenuItem144.setText("Описание операций");
        jMenuItem144.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem144ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem144);

        jMenuBar1.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/document.png"))); // NOI18N
        jMenu3.setText(" Склад полотна");

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/add.png"))); // NOI18N
        jMenuItem3.setText("Поставки");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuItem122.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/icons8-Forward_16.png"))); // NOI18N
        jMenuItem122.setText("Список накладных поставки");
        jMenuItem122.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem122ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem122);
        jMenu3.add(jSeparator2);

        jMenuItem22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/preferences.png"))); // NOI18N
        jMenuItem22.setText("Остатки старые");
        jMenuItem22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem22ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem22);

        jMenuItem116.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/preferences.png"))); // NOI18N
        jMenuItem116.setText("Остатки");
        jMenuItem116.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem116ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem116);

        jMenuItem34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/warning.png"))); // NOI18N
        jMenuItem34.setText("Не проверенные");
        jMenuItem34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem34ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem34);

        jMenuItem36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/bac.png"))); // NOI18N
        jMenuItem36.setText("Списания");
        jMenuItem36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem36ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem36);

        jMenuItem48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/redo.png"))); // NOI18N
        jMenuItem48.setText("Возвраты с производства");
        jMenuItem48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem48ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem48);

        jMenuItem64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/down.png"))); // NOI18N
        jMenuItem64.setText("Возврат поставщику");
        jMenuItem64.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem64ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem64);

        jMenuItem65.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/filter.png"))); // NOI18N
        jMenuItem65.setText("Инвентаризация");
        jMenuItem65.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem65ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem65);

        jMenuItem66.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/basket.png"))); // NOI18N
        jMenuItem66.setText("Склад производства");
        jMenuItem66.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem66ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem66);

        jMenuItem68.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/configure.png"))); // NOI18N
        jMenuItem68.setText("Склад бейки");
        jMenuItem68.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem68ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem68);
        jMenu3.add(jSeparator3);

        jMenuItem119.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/Filled.png"))); // NOI18N
        jMenuItem119.setText("Склад концевых остатков");
        jMenuItem119.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem119ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem119);

        jMenuItem120.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/application.png"))); // NOI18N
        jMenuItem120.setText("Принятие концевых остатков");
        jMenuItem120.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem120ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem120);

        jMenuItem121.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/1.png"))); // NOI18N
        jMenuItem121.setText("Списание концевых остатков");
        jMenuItem121.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem121ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem121);

        jMenuBar1.add(jMenu3);

        jMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/database.png"))); // NOI18N
        jMenu7.setText("Склад фурнитуры");

        jMenuItem31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/add.png"))); // NOI18N
        jMenuItem31.setText("Поставки");
        jMenuItem31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem31ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem31);

        jMenuItem32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/preferences.png"))); // NOI18N
        jMenuItem32.setText("Остатки");
        jMenuItem32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem32ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem32);

        jMenuItem98.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/down.png"))); // NOI18N
        jMenuItem98.setText("Возврат поставщику");
        jMenuItem98.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem98ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem98);

        jMenuItem58.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/bac.png"))); // NOI18N
        jMenuItem58.setText("Списание фурнитуры");
        jMenuItem58.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem58ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem58);

        jMenuItem95.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/Pen.png"))); // NOI18N
        jMenuItem95.setText("Перемещение фурнитуры");
        jMenuItem95.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem95ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem95);

        jMenuItem107.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/filter.png"))); // NOI18N
        jMenuItem107.setText("Инвентаризация");
        jMenuItem107.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem107ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem107);

        jMenuItem96.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/Filled.png"))); // NOI18N
        jMenuItem96.setText("Фурнитура в цехе");
        jMenuItem96.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem96ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem96);

        jMenuItem97.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/Hand.png"))); // NOI18N
        jMenuItem97.setText("Списание в цехе");
        jMenuItem97.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem97ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem97);

        jMenuItem100.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/up.png"))); // NOI18N
        jMenuItem100.setText("Возвраты на склад");
        jMenuItem100.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem100ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem100);
        jMenu7.add(jSeparator1);

        jMenuItem99.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/icons8-Forward_16.png"))); // NOI18N
        jMenuItem99.setText("Движение фурнитуры");
        jMenuItem99.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem99ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem99);

        jMenuItem101.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/icons8-Forward_16.png"))); // NOI18N
        jMenuItem101.setText("Движение фурнитуры в цеху");
        jMenuItem101.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem101ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem101);

        jMenuItem102.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/icons8-Forward_16.png"))); // NOI18N
        jMenuItem102.setText("Движение фурнитуры - суммы");
        jMenuItem102.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem102ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem102);

        jMenuItem106.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/icons8-Forward_16.png"))); // NOI18N
        jMenuItem106.setText("Остатки фурнитуры по местам хранения");
        jMenuItem106.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem106ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem106);

        jMenuBar1.add(jMenu7);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/configure.png"))); // NOI18N
        jMenu5.setText("Задачи");

        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/preferences.png"))); // NOI18N
        jMenuItem8.setText("Формирование задач");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem8);

        jMenuItem33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/go.png"))); // NOI18N
        jMenuItem33.setText("Отпуск полотна");
        jMenuItem33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem33ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem33);

        jMenuItem51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/cascade.png"))); // NOI18N
        jMenuItem51.setText("Формирование настилов");
        jMenuItem51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem51ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem51);

        jMenuItem35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/stock.png"))); // NOI18N
        jMenuItem35.setText("Закрытие задач");
        jMenuItem35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem35ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem35);

        jMenuItem38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/down.png"))); // NOI18N
        jMenuItem38.setText("Обработка настилов");
        jMenuItem38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem38ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem38);

        jMenuItem45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/bac.png"))); // NOI18N
        jMenuItem45.setText("Возврат на склад");
        jMenuItem45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem45ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem45);

        jMenuItem46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/printer.png"))); // NOI18N
        jMenuItem46.setText("Детали с принтом");
        jMenuItem46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem46ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem46);

        jMenuItem47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/icons8-Needle_16.png"))); // NOI18N
        jMenuItem47.setText("Детали с вышивкой");
        jMenuItem47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem47ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem47);

        jMenuItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/compose.png"))); // NOI18N
        jMenuItem11.setText("Комплектовка");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem11);

        jMenuItem39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/need.png"))); // NOI18N
        jMenuItem39.setText("Набор фурнитуры");
        jMenuItem39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem39ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem39);

        jMenuItem93.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/timer.png"))); // NOI18N
        jMenuItem93.setText("Склад кроя");
        jMenuItem93.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem93ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem93);

        jMenuItem44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/forward.png"))); // NOI18N
        jMenuItem44.setText("Отправка маршрутов");
        jMenuItem44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem44ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem44);

        jMenuItem40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/lorrygreen.png"))); // NOI18N
        jMenuItem40.setText("Маршруты старые");
        jMenuItem40.setToolTipText("");
        jMenuItem40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem40ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem40);

        jMenuItem115.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/lorrygreen.png"))); // NOI18N
        jMenuItem115.setText("Маршруты");
        jMenuItem115.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem115ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem115);

        jMenuItem114.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/basket.png"))); // NOI18N
        jMenuItem114.setText("Доп. Маршруты");
        jMenuItem114.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem114ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem114);

        jMenuItem62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/question.png"))); // NOI18N
        jMenuItem62.setText("Претензии");
        jMenuItem62.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem62ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem62);

        jMenuItem74.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/Pen.png"))); // NOI18N
        jMenuItem74.setText("Ручной стол. Настилы");
        jMenuItem74.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem74ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem74);

        jMenuItem75.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/Pen.png"))); // NOI18N
        jMenuItem75.setText("Ручной стол. Комплектовка");
        jMenuItem75.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem75ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem75);

        jMenuBar1.add(jMenu5);

        jMenu8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/percent.png"))); // NOI18N
        jMenu8.setText("Учет");

        jMenuItem41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/icons8-Forward_16.png"))); // NOI18N
        jMenuItem41.setText("Учет операций");
        jMenuItem41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem41ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem41);

        jMenuItem53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/icons8-Forward_16.png"))); // NOI18N
        jMenuItem53.setText("ЗП швейный цех");
        jMenuItem53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem53ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem53);

        jMenuItem123.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/icons8-Forward_16.png"))); // NOI18N
        jMenuItem123.setText("ЗП по дням");
        jMenuItem123.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem123ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem123);

        jMenuItem124.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/icons8-Forward_16.png"))); // NOI18N
        jMenuItem124.setText("ЗП общий");
        jMenuItem124.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem124ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem124);

        jMenuItem127.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/catapult.png"))); // NOI18N
        jMenuItem127.setText("Рабочее время");
        jMenuItem127.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem127ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem127);

        jMenuBar1.add(jMenu8);

        jMenu10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/stock.png"))); // NOI18N
        jMenu10.setText("Затраты");

        jMenuItem49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/edit.png"))); // NOI18N
        jMenuItem49.setText("Затраты");
        jMenuItem49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem49ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem49);

        jMenuItem50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/money.png"))); // NOI18N
        jMenuItem50.setText("Курс У.Е.");
        jMenuItem50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem50ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem50);

        jMenuItem54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/icons8-Forward_16.png"))); // NOI18N
        jMenuItem54.setText("ЗП Комплектовщики");
        jMenuItem54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem54ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem54);

        jMenuItem55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/icons8-Forward_16.png"))); // NOI18N
        jMenuItem55.setText("ЗП Настильщики");
        jMenuItem55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem55ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem55);

        jMenuItem56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/icons8-Forward_16.png"))); // NOI18N
        jMenuItem56.setText("ЗП Резчики");
        jMenuItem56.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem56ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem56);

        jMenu13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/forward.png"))); // NOI18N
        jMenu13.setText("Сокращенные отчеты");

        jMenuItem140.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/icons8-Forward_16.png"))); // NOI18N
        jMenuItem140.setText("ЗП Комплектовщики");
        jMenuItem140.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem140ActionPerformed(evt);
            }
        });
        jMenu13.add(jMenuItem140);

        jMenuItem141.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/icons8-Forward_16.png"))); // NOI18N
        jMenuItem141.setText("ЗП Настильщики");
        jMenuItem141.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem141ActionPerformed(evt);
            }
        });
        jMenu13.add(jMenuItem141);

        jMenuItem142.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/icons8-Forward_16.png"))); // NOI18N
        jMenuItem142.setText("ЗП Резчики");
        jMenuItem142.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem142ActionPerformed(evt);
            }
        });
        jMenu13.add(jMenuItem142);

        jMenuItem143.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/icons8-Forward_16.png"))); // NOI18N
        jMenuItem143.setText("Кол-во изделий по комплектовщикам");
        jMenuItem143.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem143ActionPerformed(evt);
            }
        });
        jMenu13.add(jMenuItem143);

        jMenu10.add(jMenu13);

        jMenuItem76.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/icons8-Forward_16.png"))); // NOI18N
        jMenuItem76.setText("Сумма настилов");
        jMenuItem76.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem76ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem76);

        jMenuItem91.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/icons8-Forward_16.png"))); // NOI18N
        jMenuItem91.setText("Кол-во изделий по комплектовщикам");
        jMenuItem91.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem91ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem91);

        jMenuItem57.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/icons8-Forward_16.png"))); // NOI18N
        jMenuItem57.setText("Перевыполненные операции");
        jMenuItem57.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem57ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem57);

        jMenuItem67.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/icons8-Forward_16.png"))); // NOI18N
        jMenuItem67.setText("Использованные полотна");
        jMenuItem67.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem67ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem67);

        jMenuItem71.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/icons8-Forward_16.png"))); // NOI18N
        jMenuItem71.setText("Выработка");
        jMenuItem71.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem71ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem71);

        jMenuItem128.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/icons8-Forward_16.png"))); // NOI18N
        jMenuItem128.setText("Выработка 3");
        jMenuItem128.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem128ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem128);

        jMenuItem72.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/icons8-Forward_16.png"))); // NOI18N
        jMenuItem72.setText("Маршруты по цехам");
        jMenuItem72.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem72ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem72);

        jMenuItem77.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/icons8-Forward_16.png"))); // NOI18N
        jMenuItem77.setText("Настилы артикула");
        jMenuItem77.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem77ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem77);

        jMenuItem80.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/icons8-Forward_16.png"))); // NOI18N
        jMenuItem80.setText("Отпущенные и не отработанные полотна");
        jMenuItem80.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem80ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem80);

        jMenuItem81.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/icons8-Forward_16.png"))); // NOI18N
        jMenuItem81.setText("Отходы по типу модели");
        jMenuItem81.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem81ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem81);

        jMenuItem86.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/icons8-Forward_16.png"))); // NOI18N
        jMenuItem86.setText("Маршруты в цехе");
        jMenuItem86.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem86ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem86);

        jMenuItem103.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/icons8-Forward_16.png"))); // NOI18N
        jMenuItem103.setText("Маршруты в цехе по артикулам");
        jMenuItem103.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem103ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem103);

        jMenuItem104.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/icons8-Forward_16.png"))); // NOI18N
        jMenuItem104.setText("Маршруты в цехе по артикулам 2");
        jMenuItem104.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem104ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem104);

        jMenuItem105.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/icons8-Forward_16.png"))); // NOI18N
        jMenuItem105.setText("Маршруты в цехе по артикулам 3");
        jMenuItem105.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem105ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem105);

        jMenuItem89.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/icons8-Forward_16.png"))); // NOI18N
        jMenuItem89.setText("Комплектовки с недостачей");
        jMenuItem89.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem89ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem89);

        jMenuItem117.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/icons8-Forward_16.png"))); // NOI18N
        jMenuItem117.setText("Кол-во изделий в задаче");
        jMenuItem117.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem117ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem117);

        jMenuItem118.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/icons8-Forward_16.png"))); // NOI18N
        jMenuItem118.setText("Вес настилов");
        jMenuItem118.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem118ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem118);

        jMenuItem129.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/icons8-Forward_16.png"))); // NOI18N
        jMenuItem129.setText("Не откомплектованные задачи");
        jMenuItem129.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem129ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem129);

        jMenuItem132.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/icons8-Forward_16.png"))); // NOI18N
        jMenuItem132.setText("Вес настилов с начальным остатком");
        jMenuItem132.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem132ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem132);

        jMenuItem139.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/icons8-Forward_16.png"))); // NOI18N
        jMenuItem139.setText("Отпуск полотен в закройный цех");
        jMenuItem139.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem139ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem139);

        jMenuItem145.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/icons8-Forward_16.png"))); // NOI18N
        jMenuItem145.setText("Группы операций выполненные сотрудниками");
        jMenuItem145.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem145ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem145);

        jMenuBar1.add(jMenu10);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/print.png"))); // NOI18N
        jMenu6.setText("Отчеты");

        jMenuItem23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/print.png"))); // NOI18N
        jMenuItem23.setText("Отчеты");
        jMenuItem23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem23ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem23);

        jMenuItem69.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/icons8-Forward_16.png"))); // NOI18N
        jMenuItem69.setText("История полотен");
        jMenuItem69.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem69ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem69);

        jMenuItem70.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/icons8-Forward_16.png"))); // NOI18N
        jMenuItem70.setText("История полотен по цветам");
        jMenuItem70.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem70ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem70);

        jMenuItem73.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/icons8-Forward_16.png"))); // NOI18N
        jMenuItem73.setText("История полотен(Сводная)");
        jMenuItem73.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem73ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem73);

        jMenuBar1.add(jMenu6);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/pinion.png"))); // NOI18N
        jMenu4.setText("Сервис");

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/configure.png"))); // NOI18N
        jMenuItem4.setText("Настройки");
        jMenu4.add(jMenuItem4);

        jMenuItem42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/vcard.png"))); // NOI18N
        jMenuItem42.setText("Пользователи");
        jMenuItem42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem42ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem42);

        jMenuItem52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/print.png"))); // NOI18N
        jMenuItem52.setText("Печатные формы");
        jMenuItem52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem52ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem52);

        jMenuItem63.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/refresh.png"))); // NOI18N
        jMenuItem63.setText("Обновление");
        jMenuItem63.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem63ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem63);

        jMenuBar1.add(jMenu4);

        jMenu9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/basket.png"))); // NOI18N
        jMenu9.setText("Аналитика");

        jMenu11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/print.png"))); // NOI18N
        jMenu11.setText("Отчеты");

        jMenuItem130.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/icons8-Forward_16.png"))); // NOI18N
        jMenuItem130.setText("Планируемая загруженность");
        jMenuItem130.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem130ActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem130);

        jMenuItem131.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/icons8-Forward_16.png"))); // NOI18N
        jMenuItem131.setText("Фактическая загруженность");
        jMenuItem131.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem131ActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem131);

        jMenuItem85.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/icons8-Forward_16.png"))); // NOI18N
        jMenuItem85.setText("Загруженность цехов");
        jMenuItem85.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem85ActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem85);

        jMenuItem134.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/icons8-Forward_16.png"))); // NOI18N
        jMenuItem134.setText("Загруженность цехов 2");
        jMenuItem134.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem134ActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem134);

        jMenuItem79.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/icons8-Forward_16.png"))); // NOI18N
        jMenuItem79.setText("Выработка цехов");
        jMenuItem79.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem79ActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem79);

        jMenu9.add(jMenu11);

        jMenuItem108.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/catapult.png"))); // NOI18N
        jMenuItem108.setText("Названия характеристик");
        jMenuItem108.setToolTipText("");
        jMenuItem108.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem108ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem108);

        jMenuItem109.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/catapult.png"))); // NOI18N
        jMenuItem109.setText("Доп. характеристики КК");
        jMenuItem109.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem109ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem109);

        jMenuItem111.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/catapult.png"))); // NOI18N
        jMenuItem111.setText("Анализ по новинкам");
        jMenuItem111.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem111ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem111);

        jMenuItem61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/catapult.png"))); // NOI18N
        jMenuItem61.setText("Продажи");
        jMenuItem61.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem61ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem61);

        jMenuItem78.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/catapult.png"))); // NOI18N
        jMenuItem78.setText("Мощности цехов в день");
        jMenuItem78.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem78ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem78);

        jMenuItem82.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/catapult.png"))); // NOI18N
        jMenuItem82.setText("Настилы по артикулам");
        jMenuItem82.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem82ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem82);

        jMenuItem83.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/catapult.png"))); // NOI18N
        jMenuItem83.setText("Сохранение в Excel");
        jMenuItem83.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem83ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem83);

        jMenuItem84.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/catapult.png"))); // NOI18N
        jMenuItem84.setText("План задач");
        jMenuItem84.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem84ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem84);

        jMenuItem125.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/cascade.png"))); // NOI18N
        jMenuItem125.setText("План задач общий");
        jMenuItem125.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem125ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem125);

        jMenuItem87.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/catapult.png"))); // NOI18N
        jMenuItem87.setText("Цвета1С");
        jMenuItem87.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem87ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem87);

        jMenuItem88.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/catapult.png"))); // NOI18N
        jMenuItem88.setText("Артикула1С");
        jMenuItem88.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem88ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem88);

        jMenuItem90.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/catapult.png"))); // NOI18N
        jMenuItem90.setText("Размеры1С");
        jMenuItem90.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem90ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem90);

        jMenuItem92.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/forward.png"))); // NOI18N
        jMenuItem92.setText("Задачи на закупку");
        jMenuItem92.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem92ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem92);

        jMenuItem94.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/money.png"))); // NOI18N
        jMenuItem94.setText("Учет расходов");
        jMenuItem94.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem94ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem94);

        jMenuItem113.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/catapult.png"))); // NOI18N
        jMenuItem113.setText("Календарь");
        jMenuItem113.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem113ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem113);

        jMenuItem112.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/need.png"))); // NOI18N
        jMenuItem112.setText("Распределение запланированных задач");
        jMenuItem112.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem112ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem112);

        jMenuItem133.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/pinion.png"))); // NOI18N
        jMenuItem133.setText("Расчет задач");
        jMenuItem133.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem133ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem133);

        jMenuItem135.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/icons8-Forward_16.png"))); // NOI18N
        jMenuItem135.setText("Процент отходов (Подробно)");
        jMenuItem135.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem135ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem135);

        jMenuItem136.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/icons8-Forward_16.png"))); // NOI18N
        jMenuItem136.setText("Процент отходов (Кратко)");
        jMenuItem136.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem136ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem136);

        jMenuItem137.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/Filled.png"))); // NOI18N
        jMenuItem137.setText("Запланированные задачи");
        jMenuItem137.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem137ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem137);

        jMenuBar1.add(jMenu9);

        jMenu12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/work.png"))); // NOI18N
        jMenu12.setText("Планирование");

        jMenuItem138.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/database.png"))); // NOI18N
        jMenuItem138.setText("Сезоны работы");
        jMenuItem138.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem138ActionPerformed(evt);
            }
        });
        jMenu12.add(jMenuItem138);

        jMenuBar1.add(jMenu12);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 991, Short.MAX_VALUE)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        IOSetup.disconnet();
        //System.out.println(";ldfjk;sdjkg;ldsfjkg;lsdfjk;glksdl;f");
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * Закрыть вкладку
     */
    public void closeTabPage()
    {
        int l = jTabbedPane1.getSelectedIndex();
        jTabbedPane1.removeTabAt(l);
    }
    
    /**
     * Открытие окна
     * @param evt 
     */
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        RandomAccessFile raf;
        try {
            raf = new RandomAccessFile("lock.txt", "rw");
            FileChannel channel = raf.getChannel();

            FileLock lock = channel.tryLock();
            //FileLock lock = channel.lock();
            if (lock == null) { 
                System.out.println("Программа уже запущенна!");   
                exit(0);   
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(THaupt.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {   
            Logger.getLogger(THaupt.class.getName()).log(Level.SEVERE, null, ex);
        }
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        UIManager.put("OptionPane.yesButtonText", "Да");
        UIManager.put("OptionPane.noButtonText", "Нет");
        UIManager.put("OptionPane.cancelButtonText", "Отмена");
        UIManager.put("OptionPane.okButtonText", "Готово");
        
        
        //проверим версия программы в базе и в ехе файле
        int ver = 108;    
        jLabel2.setText("v 1." + ver);
        
        if(IOSetup.getSetuValInt(5)!= ver)
        {
            try {
                Files f_exe = IOFiles.getFiles(1408);
                Files f_jar = IOFiles.getFiles(1409);
                IOFiles.saveFile(f_exe.getObj(), f_exe.getName()+"_");
                IOFiles.saveFile(f_jar.getObj(), f_jar.getName()+"_");
                if(!new File("UpdaterTailor.jar").exists()){
                    Files fupdate = IOFiles.getFiles(8397);
                    IOFiles.saveFile(fupdate.getObj(), "UpdaterTailor.jar");
                }
                JOptionPane.showMessageDialog(null, "Программа обновилась и будет закрыта. Запустите её вновь!");
                Runtime.getRuntime().exec("java -jar UpdaterTailor.jar");
                System.exit(0);
                //System.out.println("Обновили.");
            } catch (IOException ex) {
                Logger.getLogger(THaupt.class.getName()).log(Level.SEVERE, null, ex);
            }
        }            
        
        jLabel1.setText(IOOperator.operator.getName());
        
        setTitle(getTitle() + " - " + IOOperator.operator.getName());
        
        getOperator();
        
        jMenuItem48.setVisible(false);
    }//GEN-LAST:event_formWindowOpened

    /**
     * Открыть справочник товаров
     * @param evt 
     */
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:                
        jTabbedPane1.addTab("Материалы", lProduct);
        jTabbedPane1.setSelectedComponent(lProduct);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    /**
     * Документы поставки
     * @param evt 
     */
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Документы поставки", lDocument);
        jTabbedPane1.setSelectedComponent(lDocument);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    /**
     * Поставщики
     * @param evt 
     */
    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Поставщики", lAgent);
        jTabbedPane1.setSelectedComponent(lAgent);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    /**
     * Операции
     * @param evt 
     */
    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Операции", lOperation);
        jTabbedPane1.setSelectedComponent(lOperation);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    /**
     * поставки
     * @param evt 
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jMenuItem3ActionPerformed(null);
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * цвета
     * @param evt 
     */
    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Цвет полотна", lColor);
        jTabbedPane1.setSelectedComponent(lColor);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    /**
     * клеевая
     * @param evt 
     */
    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Клеевая", lKleevaya);
        jTabbedPane1.setSelectedComponent(lKleevaya);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    /**
     * принт детали
     * @param evt 
     */
    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Детали с принтом", lPrintDetali);
        jTabbedPane1.setSelectedComponent(lPrintDetali);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Раскладчик", lRaskladchik);
        jTabbedPane1.setSelectedComponent(lRaskladchik);
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Типы моделей", lTipModel);
        jTabbedPane1.setSelectedComponent(lTipModel);
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Типы настила", lTipNastila);
        jTabbedPane1.setSelectedComponent(lTipNastila);
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Группы размеров", lRazmeriGruppa);
        jTabbedPane1.setSelectedComponent(lRazmeriGruppa);
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Размеры", lRazmeri);
        jTabbedPane1.setSelectedComponent(lRazmeri);
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
        // TODO add your handling code here:
        
        jTabbedPane1.addTab("Группы сотрудников", lRabotnikGruppa);
        jTabbedPane1.setSelectedComponent(lRabotnikGruppa);
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Сотрудники", lRabotnik);
        jTabbedPane1.setSelectedComponent(lRabotnik);
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void jMenuItem20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem20ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Шаблоны", lSablon);
        jTabbedPane1.setSelectedComponent(lSablon);
    }//GEN-LAST:event_jMenuItem20ActionPerformed

    private void jMenuItem21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem21ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Место хранения", lSclad);
        jTabbedPane1.setSelectedComponent(lSclad);
    }//GEN-LAST:event_jMenuItem21ActionPerformed

    private void jMenuItem22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem22ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Остатки", lScladProduct);
        jTabbedPane1.setSelectedComponent(lScladProduct);
    }//GEN-LAST:event_jMenuItem22ActionPerformed

    /**
     * Отчеты
     * @param evt 
     */
    private void jMenuItem23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem23ActionPerformed
        // TODO add your handling code here:
        LReport lr = new LReport(null, true, 0, 0);
        lr.setVisible(true);
    }//GEN-LAST:event_jMenuItem23ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Конфекционные карты", lModel);
        jTabbedPane1.setSelectedComponent(lModel);        
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem24ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Фурнитура", lFurnitura);
        jTabbedPane1.setSelectedComponent(lFurnitura);        
    }//GEN-LAST:event_jMenuItem24ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        jMenuItem9ActionPerformed(null);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jMenuItem25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem25ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Детали с вышивкой", lVichivkaDetali);
        jTabbedPane1.setSelectedComponent(lVichivkaDetali);                
    }//GEN-LAST:event_jMenuItem25ActionPerformed

    private void jMenuItem26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem26ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Цвет ниток", lColorNitki);
        jTabbedPane1.setSelectedComponent(lColorNitki);
    }//GEN-LAST:event_jMenuItem26ActionPerformed

    private void jMenuItem27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem27ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Единицы измерения", lMeasure);
        jTabbedPane1.setSelectedComponent(lMeasure);
    }//GEN-LAST:event_jMenuItem27ActionPerformed

    private void jMenuItem28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem28ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Виды полотен", lTipProduct);
        jTabbedPane1.setSelectedComponent(lTipProduct);
    }//GEN-LAST:event_jMenuItem28ActionPerformed

    private void jMenuItem29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem29ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Цвет фурнитуры", lColorFurnitura);
        jTabbedPane1.setSelectedComponent(lColorFurnitura);
    }//GEN-LAST:event_jMenuItem29ActionPerformed

    private void jMenuItem30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem30ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Поставщики фурнитуры", lAgentF);
        jTabbedPane1.setSelectedComponent(lAgentF);
    }//GEN-LAST:event_jMenuItem30ActionPerformed

    private void jMenuItem31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem31ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Поставки фурнитуры", lDocumentF);
        jTabbedPane1.setSelectedComponent(lDocumentF);
    }//GEN-LAST:event_jMenuItem31ActionPerformed

    private void jMenuItem32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem32ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Остатки фурнитуры", lScladProductF);
        jTabbedPane1.setSelectedComponent(lScladProductF);
    }//GEN-LAST:event_jMenuItem32ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Задачи", lZadacha);
        jTabbedPane1.setSelectedComponent(lZadacha);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    /**
     * отпуск полотна
     * @param evt 
     */
    private void jMenuItem33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem33ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Отпуск материала", lZadachaMaterial);
        jTabbedPane1.setSelectedComponent(lZadachaMaterial);
    }//GEN-LAST:event_jMenuItem33ActionPerformed

    private void jMenuItem35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem35ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Обработка задач", lZadachaAllNastil);
        jTabbedPane1.setSelectedComponent(lZadachaAllNastil);
    }//GEN-LAST:event_jMenuItem35ActionPerformed

    private void jMenuItem34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem34ActionPerformed
        // TODO add your handling code here:lScladProductNo
        jTabbedPane1.addTab("Не проверенные", lScladProductNo);
        jTabbedPane1.setSelectedComponent(lScladProductNo);
    }//GEN-LAST:event_jMenuItem34ActionPerformed

    private void jMenuItem36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem36ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Списания полотна", lDocumentReturn);
        jTabbedPane1.setSelectedComponent(lDocumentReturn);
    }//GEN-LAST:event_jMenuItem36ActionPerformed

    private void jMenuItem37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem37ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Разряды", lRazrad);
        jTabbedPane1.setSelectedComponent(lRazrad);
    }//GEN-LAST:event_jMenuItem37ActionPerformed

    private void jMenuItem38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem38ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Настилы", lAllNastil);
        jTabbedPane1.setSelectedComponent(lAllNastil);
    }//GEN-LAST:event_jMenuItem38ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Комплектовка", lAllKomplektovka);
        jTabbedPane1.setSelectedComponent(lAllKomplektovka);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem40ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Маршруты", lMarshrut);
        jTabbedPane1.setSelectedComponent(lMarshrut);
    }//GEN-LAST:event_jMenuItem40ActionPerformed

    private void jMenuItem41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem41ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Учет операций", lRabotnikOperation);
        jTabbedPane1.setSelectedComponent(lRabotnikOperation);
    }//GEN-LAST:event_jMenuItem41ActionPerformed

    private void jMenuItem43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem43ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Группы операций", lOperationGruppa);
        jTabbedPane1.setSelectedComponent(lOperationGruppa);
    }//GEN-LAST:event_jMenuItem43ActionPerformed

    private void jMenuItem39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem39ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Комплектовка фурнитурой", lZadachaFurnitura);
        jTabbedPane1.setSelectedComponent(lZadachaFurnitura);
    }//GEN-LAST:event_jMenuItem39ActionPerformed

    private void jMenuItem44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem44ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Отправка маршрутов", lMarshrutGo);
        jTabbedPane1.setSelectedComponent(lMarshrutGo);
    }//GEN-LAST:event_jMenuItem44ActionPerformed

    private void jMenuItem45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem45ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Возврат на склад", lAllNastilForReturn);
        jTabbedPane1.setSelectedComponent(lAllNastilForReturn);
    }//GEN-LAST:event_jMenuItem45ActionPerformed

    private void jMenuItem46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem46ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Детали с принтом", lZadachaPrintDetali);
        jTabbedPane1.setSelectedComponent(lZadachaPrintDetali);
    }//GEN-LAST:event_jMenuItem46ActionPerformed

    private void jMenuItem47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem47ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Детали с вышивкой", lZadachaPrintDetaliV);
        jTabbedPane1.setSelectedComponent(lZadachaPrintDetaliV);
    }//GEN-LAST:event_jMenuItem47ActionPerformed

    private void jMenuItem48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem48ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Возвраты с производства", lDocumentReturnSclad);
        jTabbedPane1.setSelectedComponent(lDocumentReturnSclad);
    }//GEN-LAST:event_jMenuItem48ActionPerformed

    private void jMenuItem42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem42ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Пользователи", lOperator);
        jTabbedPane1.setSelectedComponent(lOperator);
    }//GEN-LAST:event_jMenuItem42ActionPerformed

    private void jMenuItem49ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem49ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Затраты", lFot);
        jTabbedPane1.setSelectedComponent(lFot);
    }//GEN-LAST:event_jMenuItem49ActionPerformed

    private void jMenuItem50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem50ActionPerformed
        // TODO add your handling code here:
        /*util.IODocument.test();
        if(1==1)
            return;*/
        FAddName fa = new FAddName(null, true, IOSetup.getSetuValStr(3));
        fa.setNameAndText("Курс У.Е.", "Введите значение");
        fa.setVisible(true);
        if(fa.getResult())
        {
            BigDecimal d = HelpClass.GetBigDecimalIzText(fa.getText());
            if(d.signum()==0)
            {
                JOptionPane.showMessageDialog(null, "Ошибка ввода!");
                return;
            }
            IOSetup.setSetup(3, fa.getText().replace(",", "."));
        }
    }//GEN-LAST:event_jMenuItem50ActionPerformed

    private void jMenuItem51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem51ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Настилы", lZadachaNastils);
        jTabbedPane1.setSelectedComponent(lZadachaNastils);
    }//GEN-LAST:event_jMenuItem51ActionPerformed

    private void jMenuItem52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem52ActionPerformed
        // TODO add your handling code here:
        LReport lr = new LReport(null, true, 6, 0);
        lr.setVisible(true);
    }//GEN-LAST:event_jMenuItem52ActionPerformed

    private void jMenuItem53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem53ActionPerformed
        // TODO add your handling code here:
        FParamReportPrintRabotnik f = new FParamReportPrintRabotnik(null, true, 1);
        f.setVisible(true);
    }//GEN-LAST:event_jMenuItem53ActionPerformed

    private void jMenuItem54ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem54ActionPerformed
        // TODO add your handling code here:
        FParamReportPrintRabotnik f = new FParamReportPrintRabotnik(null, true, 2);
        f.setVisible(true);
    }//GEN-LAST:event_jMenuItem54ActionPerformed

    private void jMenuItem55ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem55ActionPerformed
        // TODO add your handling code here:
        FParamReportPrintRabotnik f = new FParamReportPrintRabotnik(null, true, 3);
        f.setVisible(true);
    }//GEN-LAST:event_jMenuItem55ActionPerformed

    private void jMenuItem56ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem56ActionPerformed
        // TODO add your handling code here:
        FParamReportPrintRabotnik f = new FParamReportPrintRabotnik(null, true, 4);
        f.setVisible(true);
    }//GEN-LAST:event_jMenuItem56ActionPerformed

    private void jMenuItem57ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem57ActionPerformed
        // TODO add your handling code here:
        FParamReportPrintRabotnik f = new FParamReportPrintRabotnik(null, true, 5);
        f.setVisible(true);
    }//GEN-LAST:event_jMenuItem57ActionPerformed

    private void jMenuItem58ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem58ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Списания фурнитуры", lDocumentReturnF);
        jTabbedPane1.setSelectedComponent(lDocumentReturnF);
    }//GEN-LAST:event_jMenuItem58ActionPerformed

    private void jMenuItem59ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem59ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Группы полотен", lProductGruppa1);
        jTabbedPane1.setSelectedComponent(lProductGruppa1);
    }//GEN-LAST:event_jMenuItem59ActionPerformed

    private void jMenuItem60ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem60ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Группы фурнитуры", lProductGruppa2);
        jTabbedPane1.setSelectedComponent(lProductGruppa2);
    }//GEN-LAST:event_jMenuItem60ActionPerformed

    private void jMenuItem61ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem61ActionPerformed
        // TODO add your handling code here:
        //jTabbedPane1.addTab("Продажи", fan);
        //jTabbedPane1.setSelectedComponent(fan);
        jTabbedPane1.addTab("Продажи", fan1);
        jTabbedPane1.setSelectedComponent(fan1);
    }//GEN-LAST:event_jMenuItem61ActionPerformed

    private void jMenuItem62ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem62ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Претензии", lPretenzia);
        jTabbedPane1.setSelectedComponent(lPretenzia);
    }//GEN-LAST:event_jMenuItem62ActionPerformed

    private void jMenuItem63ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem63ActionPerformed
        // TODO add your handling code here:
        FUpdate f = new FUpdate(null, true);
        f.setVisible(true);
    }//GEN-LAST:event_jMenuItem63ActionPerformed

    private void jMenuItem64ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem64ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Возвраты поставщику", lDocReturn);
        jTabbedPane1.setSelectedComponent(lDocReturn);
    }//GEN-LAST:event_jMenuItem64ActionPerformed

    private void jMenuItem65ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem65ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Инвентаризация", lRevizia);
        jTabbedPane1.setSelectedComponent(lRevizia);
    }//GEN-LAST:event_jMenuItem65ActionPerformed

    private void jMenuItem66ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem66ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Склад производства", lScladProductChex);
        jTabbedPane1.setSelectedComponent(lScladProductChex);
    }//GEN-LAST:event_jMenuItem66ActionPerformed

    private void jMenuItem67ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem67ActionPerformed
        // TODO add your handling code here:
        FParamReportPrintRabotnik f = new FParamReportPrintRabotnik(null, true, 6);
        f.setVisible(true);
    }//GEN-LAST:event_jMenuItem67ActionPerformed

    private void jMenuItem68ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem68ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Склад бейки", lScladProductBeika);
        jTabbedPane1.setSelectedComponent(lScladProductBeika);
    }//GEN-LAST:event_jMenuItem68ActionPerformed

    private void jMenuItem69ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem69ActionPerformed
        // TODO add your handling code here:
        FParamReportPrintRabotnik f = new FParamReportPrintRabotnik(null, true, 7);
        f.setVisible(true);
    }//GEN-LAST:event_jMenuItem69ActionPerformed

    private void jMenuItem70ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem70ActionPerformed
        // TODO add your handling code here:
        FParamReportPrintRabotnik f = new FParamReportPrintRabotnik(null, true, 8);
        f.setVisible(true);
    }//GEN-LAST:event_jMenuItem70ActionPerformed

    private void jMenuItem71ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem71ActionPerformed
        // TODO add your handling code here:
        FParamReportPrintRabotnik f = new FParamReportPrintRabotnik(null, true, 9);
        f.setVisible(true);
    }//GEN-LAST:event_jMenuItem71ActionPerformed

    private void jMenuItem72ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem72ActionPerformed
        // TODO add your handling code here:
        FParamReportPrintRabotnik f = new FParamReportPrintRabotnik(null, true, 10);
        f.setVisible(true);
    }//GEN-LAST:event_jMenuItem72ActionPerformed

    private void jMenuItem73ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem73ActionPerformed
        // TODO add your handling code here:
        FParamReportPrintRabotnik f = new FParamReportPrintRabotnik(null, true, 11);
        f.setVisible(true);
    }//GEN-LAST:event_jMenuItem73ActionPerformed

    private void jMenuItem74ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem74ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Ручной стол.Настилы", lZadachaNastilsHand);
        jTabbedPane1.setSelectedComponent(lZadachaNastilsHand);
    }//GEN-LAST:event_jMenuItem74ActionPerformed

    private void jMenuItem75ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem75ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Ручной стол.Комплектовка", lAllKomplektovkaHand);
        jTabbedPane1.setSelectedComponent(lAllKomplektovkaHand);
    }//GEN-LAST:event_jMenuItem75ActionPerformed

    private void jMenuItem76ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem76ActionPerformed
        // TODO add your handling code here:
        FParamReportPrintRabotnik f = new FParamReportPrintRabotnik(null, true, 12);
        f.setVisible(true);
    }//GEN-LAST:event_jMenuItem76ActionPerformed

    private void jMenuItem77ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem77ActionPerformed
        // TODO add your handling code here:
        FParamReportPrintRabotnik f = new FParamReportPrintRabotnik(null, true, 13);
        f.setVisible(true);
    }//GEN-LAST:event_jMenuItem77ActionPerformed

    private void jMenuItem79ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem79ActionPerformed
        // TODO add your handling code here:
        FParamReportPrintRabotnik f = new FParamReportPrintRabotnik(null, true, 14);
        f.setVisible(true);
    }//GEN-LAST:event_jMenuItem79ActionPerformed

    private void jMenuItem78ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem78ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Мощности цехов", lTimeOpChex);
        jTabbedPane1.setSelectedComponent(lTimeOpChex);
    }//GEN-LAST:event_jMenuItem78ActionPerformed

    private void jMenuItem80ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem80ActionPerformed
        // TODO add your handling code here:
        FParamReportPrintRabotnik f = new FParamReportPrintRabotnik(null, true, 15);
        f.setVisible(true);
    }//GEN-LAST:event_jMenuItem80ActionPerformed

    private void jMenuItem81ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem81ActionPerformed
        // TODO add your handling code here:
        FParamReportPrintRabotnik f = new FParamReportPrintRabotnik(null, true, 16);
        f.setVisible(true);
    }//GEN-LAST:event_jMenuItem81ActionPerformed

    private void jMenuItem82ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem82ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Настилы по артикулам", fArticleNastils);
        jTabbedPane1.setSelectedComponent(fArticleNastils);
    }//GEN-LAST:event_jMenuItem82ActionPerformed

    private void jMenuItem83ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem83ActionPerformed
        // TODO add your handling code here:
        FSaveExcel ff = new FSaveExcel(null, true);
        ff.setVisible(true);        
    }//GEN-LAST:event_jMenuItem83ActionPerformed

    private void jMenuItem85ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem85ActionPerformed
        // TODO add your handling code here:
        FParamReportPrintRabotnik f = new FParamReportPrintRabotnik(null, true, 17);
        f.setVisible(true);
    }//GEN-LAST:event_jMenuItem85ActionPerformed

    private void jMenuItem84ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem84ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("План задач", lModelPlan);
        jTabbedPane1.setSelectedComponent(lModelPlan);
    }//GEN-LAST:event_jMenuItem84ActionPerformed

    private void jMenuItem86ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem86ActionPerformed
        // TODO add your handling code here:
        FParamReportPrintRabotnik f = new FParamReportPrintRabotnik(null, true, 18);
        f.setVisible(true);
    }//GEN-LAST:event_jMenuItem86ActionPerformed

    private void jMenuItem87ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem87ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Цвета1С", laColor);
        jTabbedPane1.setSelectedComponent(laColor);
    }//GEN-LAST:event_jMenuItem87ActionPerformed

    private void jMenuItem88ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem88ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Артикула1С", laArticle);
        jTabbedPane1.setSelectedComponent(laArticle);
    }//GEN-LAST:event_jMenuItem88ActionPerformed

    /**
     * Запустить прогноз 
     * @param article - артикул
     * @param d1 - дата с
     * @param d2 - дата по
     * @param d3 - дата закупок
     * @param d4 - дата производства
     * @param d5
     */
    public void sendPrognoz(int article, Date d1, Date d2,Date d3, Date d4, Date d5)
    {
        FGetPrognoz fGetPrognoz = new FGetPrognoz(this);
        fGetPrognoz.sendPadamert(article, d1, d2, d3, d4, d5);
        jTabbedPane1.addTab("Прогнозирование", fGetPrognoz);
        jTabbedPane1.setSelectedComponent(fGetPrognoz);
    }
    
    /**
     * Запустить прогноз 
     * @param article - артикул
     * @param d1 - дата с
     * @param d2 - дата по
     * @param d3 - дата закупок
     * @param d4 - дата производства
     * @param d5
     * @param d6
     * @param yar - год производства
     */
    public void sendPrognoz1(int article, Date d1, Date d2,Date d3, Date d4, Date d5, Date d6, int yar)
    {
        FGetPrognoz1 fGetPrognoz = new FGetPrognoz1(this);
        fGetPrognoz.sendPadamert(article, d1, d2, d3, d4, d5, d6, yar);
        jTabbedPane1.addTab("Прогнозирование1", fGetPrognoz);
        jTabbedPane1.setSelectedComponent(fGetPrognoz);
    }
    
    /**
     * Запустить прогноз 
     * @param article - артикул
     * @param d1 - дата с
     * @param d2 - дата по
     * @param d3 - дата закупок
     * @param d4 - дата производства
     * @param d5
     * @param d6
     * @param yar - год производства
     * @param pm
     */
    public void sendPrognoz2(int article, Date d1, Date d2,Date d3, Date d4, Date d5, Date d6, int yar, int pm)
    {
        FGetPrognoz1 fGetPrognoz = new FGetPrognoz1(this);
        fGetPrognoz.sendPadamert(article, d1, d2, d3, d4, d5, d6, yar);
        fGetPrognoz.loadModelPlan(pm);
        
        jTabbedPane1.addTab("Прогнозирование1", fGetPrognoz);
        jTabbedPane1.setSelectedComponent(fGetPrognoz);
    }
    
    /**
     * Просмотреть прогноз 
     * @param article - артикул
     * @param d1 - дата с
     * @param d2 - дата по
     * @param d3 - дата закупок
     * @param d4 - дата производства
     * @param d5
     * @param d6
     * @param yar - год производства
     * @param pm - заголовок 
     */
    public void sendPrognoz3(int article, Date d1, Date d2,Date d3, Date d4, Date d5, Date d6, int yar, int pm)
    {
        FGetPrognoz1 fGetPrognoz = new FGetPrognoz1(this);
        fGetPrognoz.sendPadamert(article, d1, d2, d3, d4, d5, d6, yar);
        fGetPrognoz.loadModelPlanHaupt(pm);
        
        jTabbedPane1.addTab("Прогнозирование1", fGetPrognoz);
        jTabbedPane1.setSelectedComponent(fGetPrognoz);
    }
    
    private void jMenuItem90ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem90ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Размеры1С", lARazmeri);
        jTabbedPane1.setSelectedComponent(lARazmeri);
    }//GEN-LAST:event_jMenuItem90ActionPerformed

    private void jMenuItem89ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem89ActionPerformed
        // TODO add your handling code here:
        FParamReportPrintRabotnik f = new FParamReportPrintRabotnik(null, true, 19);
        f.setVisible(true);
    }//GEN-LAST:event_jMenuItem89ActionPerformed

    private void jMenuItem91ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem91ActionPerformed
        // TODO add your handling code here:
        FParamReportPrintRabotnik f = new FParamReportPrintRabotnik(null, true, 20);
        f.setVisible(true);
    }//GEN-LAST:event_jMenuItem91ActionPerformed

    private void jMenuItem92ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem92ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Задачи на закупки", lPZakupki);
        jTabbedPane1.setSelectedComponent(lPZakupki);
    }//GEN-LAST:event_jMenuItem92ActionPerformed

    private void jMenuItem93ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem93ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Склад кроя", lScladKroi);
        jTabbedPane1.setSelectedComponent(lScladKroi);
    }//GEN-LAST:event_jMenuItem93ActionPerformed

    private void jMenuItem94ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem94ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Учет расходов", lUDocument);
        jTabbedPane1.setSelectedComponent(lUDocument);
    }//GEN-LAST:event_jMenuItem94ActionPerformed

    private void jMenuItem95ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem95ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Перемещение фурнитуры", lDocF);
        jTabbedPane1.setSelectedComponent(lDocF);
    }//GEN-LAST:event_jMenuItem95ActionPerformed

    private void jMenuItem96ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem96ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Фурнитура в цехе", lFurnituraChex);
        jTabbedPane1.setSelectedComponent(lFurnituraChex);
        
    }//GEN-LAST:event_jMenuItem96ActionPerformed

    private void jMenuItem97ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem97ActionPerformed
        // TODO add your handling code here:lFurnituraOffAll
        jTabbedPane1.addTab("Списание фурнитуры в цехе", lFurnituraOffAll);
        jTabbedPane1.setSelectedComponent(lFurnituraOffAll);
    }//GEN-LAST:event_jMenuItem97ActionPerformed

    private void jMenuItem98ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem98ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Возврат поставщику", lDocReturnF);
        jTabbedPane1.setSelectedComponent(lDocReturnF);
    }//GEN-LAST:event_jMenuItem98ActionPerformed

    private void jMenuItem99ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem99ActionPerformed
        // TODO add your handling code here:
        FParamReportPrintRabotnik f = new FParamReportPrintRabotnik(null, true, 22);
        f.setVisible(true);
    }//GEN-LAST:event_jMenuItem99ActionPerformed

    private void jMenuItem100ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem100ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Возвраты на склад", lFurnituraReturnSclad);
        jTabbedPane1.setSelectedComponent(lFurnituraReturnSclad);        
    }//GEN-LAST:event_jMenuItem100ActionPerformed

    private void jMenuItem101ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem101ActionPerformed
        // TODO add your handling code here:
        FParamReportPrintRabotnik f = new FParamReportPrintRabotnik(null, true, 23);
        f.setVisible(true);
    }//GEN-LAST:event_jMenuItem101ActionPerformed

    private void jMenuItem102ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem102ActionPerformed
        // TODO add your handling code here:
        FParamReportPrintRabotnik f = new FParamReportPrintRabotnik(null, true, 24);
        f.setVisible(true);
    }//GEN-LAST:event_jMenuItem102ActionPerformed

    private void jMenuItem103ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem103ActionPerformed
        // TODO add your handling code here:
        FParamReportPrintRabotnik f = new FParamReportPrintRabotnik(null, true, 25);
        f.setVisible(true);
    }//GEN-LAST:event_jMenuItem103ActionPerformed

    private void jMenuItem104ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem104ActionPerformed
        // TODO add your handling code here:
        FParamReportPrintRabotnik f = new FParamReportPrintRabotnik(null, true, 26);
        f.setVisible(true);
    }//GEN-LAST:event_jMenuItem104ActionPerformed

    private void jMenuItem105ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem105ActionPerformed
        // TODO add your handling code here:
        FParamReportPrintRabotnik f = new FParamReportPrintRabotnik(null, true, 27);
        f.setVisible(true);
    }//GEN-LAST:event_jMenuItem105ActionPerformed

    private void jMenuItem106ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem106ActionPerformed
        // TODO add your handling code here:
        FParamReportPrintRabotnik f = new FParamReportPrintRabotnik(null, true, 28);
        f.setVisible(true);
    }//GEN-LAST:event_jMenuItem106ActionPerformed

    private void jMenuItem107ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem107ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem107ActionPerformed

    private void jMenuItem108ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem108ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Названия характеристик", lMProperty);
        jTabbedPane1.setSelectedComponent(lMProperty);        
    }//GEN-LAST:event_jMenuItem108ActionPerformed

    private void jMenuItem109ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem109ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Доп. характеристики КК", lMModelProperty);
        jTabbedPane1.setSelectedComponent(lMModelProperty);        
    }//GEN-LAST:event_jMenuItem109ActionPerformed

    private void jMenuItem110ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem110ActionPerformed
        // TODO add your handling code here:
        LMModelComment lm = new LMModelComment(null, true, 0);
        lm.setVisible(true);
    }//GEN-LAST:event_jMenuItem110ActionPerformed

    private void jMenuItem111ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem111ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Анализ по новинкам", lAnalitikaNovinka);
        jTabbedPane1.setSelectedComponent(lAnalitikaNovinka);        
        
    }//GEN-LAST:event_jMenuItem111ActionPerformed

    private void jMenuItem112ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem112ActionPerformed
        // TODO add your handling code here:
        
        LTimeOperation lt = new LTimeOperation(this);
        jTabbedPane1.addTab("Распределение", lt);
        jTabbedPane1.setSelectedComponent(lt);        
        
        //JDialogPaint jd = new JDialogPaint(null, true);
        //jd.setVisible(true);
        
        if(1==1) return;
        
        /*FChart2 f = new FChart2(null, true, IOPrognoz.getQtySaleForChar2(137, new Date(118, 1, 1), new Date()),1868, 884, "Артикул:", true,137, 6, new Date(118, 1, 1), new Date());
        f.setVisible(true);
        
        if(1==1) return;*/
        
        
        FGetPrognoz1 ff = new FGetPrognoz1(this);
        //ff.sendPadamert(1669, new Date(118, 1, 1), new Date(), new Date(), new Date(118, 12, 31), new Date(), 2019);
        //ff.sendPadamert(1669, new Date(118, 1, 1), new Date(), new Date(), new Date(), new Date(), new Date(), 2019);
        ff.sendPadamert(165, new Date(118, 1, 1), new Date(), new Date(), new Date(), new Date(), new Date(), 2019);
        //ff.sendPadamert(1310, new Date(118, 2, 1), new Date(), new Date(), new Date(), new Date());
        jTabbedPane1.addTab("Прогнозирование1", ff);
        jTabbedPane1.setSelectedComponent(ff);
        //ff.setVisible(true);
    }//GEN-LAST:event_jMenuItem112ActionPerformed

    private void jMenuItem113ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem113ActionPerformed
        // TODO add your handling code here:
        LCalendar lc = new LCalendar(null, true);
        lc.setVisible(true);
    }//GEN-LAST:event_jMenuItem113ActionPerformed

    private void jMenuItem114ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem114ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Доп. маршруты", lDopMarshrut);
        jTabbedPane1.setSelectedComponent(lDopMarshrut);        
    }//GEN-LAST:event_jMenuItem114ActionPerformed

    private void jMenuItem115ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem115ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Маршруты1", lMarshrut1);
        jTabbedPane1.setSelectedComponent(lMarshrut1);
    }//GEN-LAST:event_jMenuItem115ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        jMenuItem38ActionPerformed(null);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        jMenuItem116ActionPerformed(null);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        jMenuItem11ActionPerformed(null);        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        jMenuItem115ActionPerformed(null);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        jMenuItem41ActionPerformed(null);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jMenuItem116ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem116ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Остатки1", lScladProduct1);
        jTabbedPane1.setSelectedComponent(lScladProduct1);
    }//GEN-LAST:event_jMenuItem116ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        jMenuItem1ActionPerformed(null);
    }//GEN-LAST:event_formWindowClosing

    private void jMenuItem117ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem117ActionPerformed
        // TODO add your handling code here:
        
        FParamReportPrintRabotnik f = new FParamReportPrintRabotnik(null, true, 29);
        f.setVisible(true);
    }//GEN-LAST:event_jMenuItem117ActionPerformed

    private void jMenuItem118ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem118ActionPerformed
        // TODO add your handling code here:
        FParamReportPrintRabotnik f = new FParamReportPrintRabotnik(null, true, 30);
        f.setVisible(true);
    }//GEN-LAST:event_jMenuItem118ActionPerformed

    private void jMenuItem119ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem119ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Склад лоскутов", lScladLoskut);
        jTabbedPane1.setSelectedComponent(lScladLoskut);
    }//GEN-LAST:event_jMenuItem119ActionPerformed

    private void jMenuItem120ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem120ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Принятие лоскутов", lScladLoskut1);
        jTabbedPane1.setSelectedComponent(lScladLoskut1);
    }//GEN-LAST:event_jMenuItem120ActionPerformed

    private void jMenuItem121ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem121ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Списание лоскутов", lScladLoskutSale);
        jTabbedPane1.setSelectedComponent(lScladLoskutSale);
    }//GEN-LAST:event_jMenuItem121ActionPerformed

    private void jMenuItem122ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem122ActionPerformed
        // TODO add your handling code here:
        FParamReportPrintRabotnik f = new FParamReportPrintRabotnik(null, true, 32);
        f.setVisible(true);
    }//GEN-LAST:event_jMenuItem122ActionPerformed

    private void jMenuItem123ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem123ActionPerformed
        // TODO add your handling code here:
        FParamReportPrintRabotnik f = new FParamReportPrintRabotnik(null, true, 33);
        f.setVisible(true);
    }//GEN-LAST:event_jMenuItem123ActionPerformed

    private void jMenuItem124ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem124ActionPerformed
        // TODO add your handling code here:
        FParamReportPrintRabotnik f = new FParamReportPrintRabotnik(null, true, 34);
        f.setVisible(true);
    }//GEN-LAST:event_jMenuItem124ActionPerformed

    private void jMenuItem126ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem126ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Детали термо печати", lTermoPrintDetali);
        jTabbedPane1.setSelectedComponent(lTermoPrintDetali);                
    }//GEN-LAST:event_jMenuItem126ActionPerformed

    private void jMenuItem127ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem127ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Рабочее время", lUOperDoc);
        jTabbedPane1.setSelectedComponent(lUOperDoc);
    }//GEN-LAST:event_jMenuItem127ActionPerformed

    private void jMenuItem128ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem128ActionPerformed
        // TODO add your handling code here:
        FParamReportPrintRabotnik f = new FParamReportPrintRabotnik(null, true, 35);
        f.setVisible(true);
    }//GEN-LAST:event_jMenuItem128ActionPerformed

    private void jMenuItem129ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem129ActionPerformed
        // TODO add your handling code here:
        FParamReportPrintRabotnik f = new FParamReportPrintRabotnik(null, true, 36);
        f.setVisible(true);
    }//GEN-LAST:event_jMenuItem129ActionPerformed

    private void jMenuItem125ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem125ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Общий план задач", lModelPlanHaupt);
        jTabbedPane1.setSelectedComponent(lModelPlanHaupt);
    }//GEN-LAST:event_jMenuItem125ActionPerformed

    private void jMenuItem130ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem130ActionPerformed
        // TODO add your handling code here:
        FParamReportPrintRabotnik f = new FParamReportPrintRabotnik(null, true, 37);
        f.setVisible(true);
    }//GEN-LAST:event_jMenuItem130ActionPerformed

    private void jMenuItem131ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem131ActionPerformed
        // TODO add your handling code here:
        FParamReportPrintRabotnik f = new FParamReportPrintRabotnik(null, true, 38);
        f.setVisible(true);
    }//GEN-LAST:event_jMenuItem131ActionPerformed

    private void jMenuItem132ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem132ActionPerformed
        // TODO add your handling code here:
        FParamReportPrintRabotnik f = new FParamReportPrintRabotnik(null, true, 39);
        f.setVisible(true);
    }//GEN-LAST:event_jMenuItem132ActionPerformed

    private void jMenuItem133ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem133ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Расчет задач", fCalcTimeModel);
        jTabbedPane1.setSelectedComponent(fCalcTimeModel);
    }//GEN-LAST:event_jMenuItem133ActionPerformed

    private void jMenuItem134ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem134ActionPerformed
        // TODO add your handling code here:
        FParamReportPrintRabotnik f = new FParamReportPrintRabotnik(null, true, 40);
        
        f.setVisible(true);
    }//GEN-LAST:event_jMenuItem134ActionPerformed

    private void jMenuItem136ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem136ActionPerformed
        // TODO add your handling code here:
        FParamReportPrintRabotnik f = new FParamReportPrintRabotnik(null, true, 42);
        f.setVisible(true);
    }//GEN-LAST:event_jMenuItem136ActionPerformed

    private void jMenuItem135ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem135ActionPerformed
        // TODO add your handling code here:
        FParamReportPrintRabotnik f = new FParamReportPrintRabotnik(null, true, 41);
        f.setVisible(true);
        //546465
    }//GEN-LAST:event_jMenuItem135ActionPerformed

    private void jMenuItem137ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem137ActionPerformed
        // TODO add your handling code here:        
        LPlanArticle lPlanArticle = new LPlanArticle(this);
        jTabbedPane1.addTab("План задач", lPlanArticle);
        jTabbedPane1.setSelectedComponent(lPlanArticle);
    }//GEN-LAST:event_jMenuItem137ActionPerformed

    private void jMenuItem138ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem138ActionPerformed
        // TODO add your handling code here:        
        jTabbedPane1.addTab("Сезоны работы", lMapProject);
        jTabbedPane1.setSelectedComponent(lMapProject);
    }//GEN-LAST:event_jMenuItem138ActionPerformed

    private void jMenuItem139ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem139ActionPerformed
        // TODO add your handling code here:
        FParamReportPrintRabotnik f = new FParamReportPrintRabotnik(null, true, 45);
        f.setVisible(true);
    }//GEN-LAST:event_jMenuItem139ActionPerformed

    private void jMenuItem140ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem140ActionPerformed
        // TODO add your handling code here:
        FParamReportPrintRabotnik f = new FParamReportPrintRabotnik(null, true, 46);
        f.setVisible(true);
    }//GEN-LAST:event_jMenuItem140ActionPerformed

    private void jMenuItem141ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem141ActionPerformed
        // TODO add your handling code here:
        FParamReportPrintRabotnik f = new FParamReportPrintRabotnik(null, true, 47);
        f.setVisible(true);
    }//GEN-LAST:event_jMenuItem141ActionPerformed

    private void jMenuItem142ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem142ActionPerformed
        // TODO add your handling code here:
        FParamReportPrintRabotnik f = new FParamReportPrintRabotnik(null, true, 48);
        f.setVisible(true);
    }//GEN-LAST:event_jMenuItem142ActionPerformed

    private void jMenuItem143ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem143ActionPerformed
        // TODO add your handling code here:
        FParamReportPrintRabotnik f = new FParamReportPrintRabotnik(null, true, 49);
        f.setVisible(true);
    }//GEN-LAST:event_jMenuItem143ActionPerformed

    private void jMenuItem144ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem144ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.addTab("Описание операций", lOperationTextGruppa);
        jTabbedPane1.setSelectedComponent(lOperationTextGruppa);
    }//GEN-LAST:event_jMenuItem144ActionPerformed

    private void jMenuItem145ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem145ActionPerformed
        // TODO add your handling code here:
        FParamReportPrintRabotnik f = new FParamReportPrintRabotnik(null, true, 50);
        f.setVisible(true);
    }//GEN-LAST:event_jMenuItem145ActionPerformed

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
            java.util.logging.Logger.getLogger(THaupt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        /*java.awt.EventQueue.invokeLater(() -> {
            new THaupt().setVisible(true);
        });*/
        
        if(args.length>0){
            for(int i=0;i<args.length;i++){
                String ag = args[i];                
                switch(ag){
                    case "-em":
                        String str_file = "c:\\1.xml";
                        if((i+1)< args.length){
                            str_file = args[i+1];
                        }
                        FSaveExcel excel =new FSaveExcel(null, true);
                        excel.saveModelToXmlFile(str_file);
                        break;
                }
            }
            System.exit(0);
        }
        
        java.awt.EventQueue.invokeLater(() -> {
            new THaupt().setVisible(true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu13;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem100;
    private javax.swing.JMenuItem jMenuItem101;
    private javax.swing.JMenuItem jMenuItem102;
    private javax.swing.JMenuItem jMenuItem103;
    private javax.swing.JMenuItem jMenuItem104;
    private javax.swing.JMenuItem jMenuItem105;
    private javax.swing.JMenuItem jMenuItem106;
    private javax.swing.JMenuItem jMenuItem107;
    private javax.swing.JMenuItem jMenuItem108;
    private javax.swing.JMenuItem jMenuItem109;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem110;
    private javax.swing.JMenuItem jMenuItem111;
    private javax.swing.JMenuItem jMenuItem112;
    private javax.swing.JMenuItem jMenuItem113;
    private javax.swing.JMenuItem jMenuItem114;
    private javax.swing.JMenuItem jMenuItem115;
    private javax.swing.JMenuItem jMenuItem116;
    private javax.swing.JMenuItem jMenuItem117;
    private javax.swing.JMenuItem jMenuItem118;
    private javax.swing.JMenuItem jMenuItem119;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem120;
    private javax.swing.JMenuItem jMenuItem121;
    private javax.swing.JMenuItem jMenuItem122;
    private javax.swing.JMenuItem jMenuItem123;
    private javax.swing.JMenuItem jMenuItem124;
    private javax.swing.JMenuItem jMenuItem125;
    private javax.swing.JMenuItem jMenuItem126;
    private javax.swing.JMenuItem jMenuItem127;
    private javax.swing.JMenuItem jMenuItem128;
    private javax.swing.JMenuItem jMenuItem129;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem130;
    private javax.swing.JMenuItem jMenuItem131;
    private javax.swing.JMenuItem jMenuItem132;
    private javax.swing.JMenuItem jMenuItem133;
    private javax.swing.JMenuItem jMenuItem134;
    private javax.swing.JMenuItem jMenuItem135;
    private javax.swing.JMenuItem jMenuItem136;
    private javax.swing.JMenuItem jMenuItem137;
    private javax.swing.JMenuItem jMenuItem138;
    private javax.swing.JMenuItem jMenuItem139;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem140;
    private javax.swing.JMenuItem jMenuItem141;
    private javax.swing.JMenuItem jMenuItem142;
    private javax.swing.JMenuItem jMenuItem143;
    private javax.swing.JMenuItem jMenuItem144;
    private javax.swing.JMenuItem jMenuItem145;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem24;
    private javax.swing.JMenuItem jMenuItem25;
    private javax.swing.JMenuItem jMenuItem26;
    private javax.swing.JMenuItem jMenuItem27;
    private javax.swing.JMenuItem jMenuItem28;
    private javax.swing.JMenuItem jMenuItem29;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem30;
    private javax.swing.JMenuItem jMenuItem31;
    private javax.swing.JMenuItem jMenuItem32;
    private javax.swing.JMenuItem jMenuItem33;
    private javax.swing.JMenuItem jMenuItem34;
    private javax.swing.JMenuItem jMenuItem35;
    private javax.swing.JMenuItem jMenuItem36;
    private javax.swing.JMenuItem jMenuItem37;
    private javax.swing.JMenuItem jMenuItem38;
    private javax.swing.JMenuItem jMenuItem39;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem40;
    private javax.swing.JMenuItem jMenuItem41;
    private javax.swing.JMenuItem jMenuItem42;
    private javax.swing.JMenuItem jMenuItem43;
    private javax.swing.JMenuItem jMenuItem44;
    private javax.swing.JMenuItem jMenuItem45;
    private javax.swing.JMenuItem jMenuItem46;
    private javax.swing.JMenuItem jMenuItem47;
    private javax.swing.JMenuItem jMenuItem48;
    private javax.swing.JMenuItem jMenuItem49;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem50;
    private javax.swing.JMenuItem jMenuItem51;
    private javax.swing.JMenuItem jMenuItem52;
    private javax.swing.JMenuItem jMenuItem53;
    private javax.swing.JMenuItem jMenuItem54;
    private javax.swing.JMenuItem jMenuItem55;
    private javax.swing.JMenuItem jMenuItem56;
    private javax.swing.JMenuItem jMenuItem57;
    private javax.swing.JMenuItem jMenuItem58;
    private javax.swing.JMenuItem jMenuItem59;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem60;
    private javax.swing.JMenuItem jMenuItem61;
    private javax.swing.JMenuItem jMenuItem62;
    private javax.swing.JMenuItem jMenuItem63;
    private javax.swing.JMenuItem jMenuItem64;
    private javax.swing.JMenuItem jMenuItem65;
    private javax.swing.JMenuItem jMenuItem66;
    private javax.swing.JMenuItem jMenuItem67;
    private javax.swing.JMenuItem jMenuItem68;
    private javax.swing.JMenuItem jMenuItem69;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem70;
    private javax.swing.JMenuItem jMenuItem71;
    private javax.swing.JMenuItem jMenuItem72;
    private javax.swing.JMenuItem jMenuItem73;
    private javax.swing.JMenuItem jMenuItem74;
    private javax.swing.JMenuItem jMenuItem75;
    private javax.swing.JMenuItem jMenuItem76;
    private javax.swing.JMenuItem jMenuItem77;
    private javax.swing.JMenuItem jMenuItem78;
    private javax.swing.JMenuItem jMenuItem79;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem80;
    private javax.swing.JMenuItem jMenuItem81;
    private javax.swing.JMenuItem jMenuItem82;
    private javax.swing.JMenuItem jMenuItem83;
    private javax.swing.JMenuItem jMenuItem84;
    private javax.swing.JMenuItem jMenuItem85;
    private javax.swing.JMenuItem jMenuItem86;
    private javax.swing.JMenuItem jMenuItem87;
    private javax.swing.JMenuItem jMenuItem88;
    private javax.swing.JMenuItem jMenuItem89;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenuItem jMenuItem90;
    private javax.swing.JMenuItem jMenuItem91;
    private javax.swing.JMenuItem jMenuItem92;
    private javax.swing.JMenuItem jMenuItem93;
    private javax.swing.JMenuItem jMenuItem94;
    private javax.swing.JMenuItem jMenuItem95;
    private javax.swing.JMenuItem jMenuItem96;
    private javax.swing.JMenuItem jMenuItem97;
    private javax.swing.JMenuItem jMenuItem98;
    private javax.swing.JMenuItem jMenuItem99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables

    /**
     * Формирование интерфейса
     */
    private void getOperator() {
        jMenuItem2.setVisible(false);
        jMenuItem3.setVisible(false);
        jMenuItem4.setVisible(false);
        jMenuItem5.setVisible(false);
        jMenuItem6.setVisible(false);
        jMenuItem7.setVisible(false);
        jMenuItem8.setVisible(false);
        jMenuItem9.setVisible(false);
        jMenuItem10.setVisible(false);
        jMenuItem11.setVisible(false);
        jMenuItem12.setVisible(false);
        jMenuItem13.setVisible(false);
        jMenuItem14.setVisible(false);
        jMenuItem15.setVisible(false);
        jMenuItem16.setVisible(false);
        jMenuItem17.setVisible(false);
        jMenuItem18.setVisible(false);
        jMenuItem19.setVisible(false);
        jMenuItem20.setVisible(false);
        jMenuItem21.setVisible(false);
        jMenuItem22.setVisible(false);
        jMenuItem23.setVisible(false);
        jMenuItem24.setVisible(false);
        jMenuItem25.setVisible(false);
        jMenuItem26.setVisible(false);
        jMenuItem27.setVisible(false);
        jMenuItem28.setVisible(false);
        jMenuItem29.setVisible(false);
        jMenuItem30.setVisible(false);
        jMenuItem31.setVisible(false);
        jMenuItem32.setVisible(false);
        jMenuItem33.setVisible(false);
        jMenuItem34.setVisible(false);
        jMenuItem35.setVisible(false);
        jMenuItem36.setVisible(false);
        jMenuItem37.setVisible(false);
        jMenuItem38.setVisible(false);
        jMenuItem39.setVisible(false);
        jMenuItem40.setVisible(false);
        jMenuItem40.setVisible(false);
        jMenuItem42.setVisible(false);
        jMenuItem43.setVisible(false);
        jMenuItem44.setVisible(false);
        jMenuItem45.setVisible(false);
        jMenuItem46.setVisible(false);
        jMenuItem47.setVisible(false);
        jMenuItem48.setVisible(false);
        jMenuItem49.setVisible(false);
        jMenuItem50.setVisible(false);
        jMenuItem51.setVisible(false);
        jMenuItem54.setVisible(false);
        jMenuItem55.setVisible(false);
        jMenuItem56.setVisible(false);
        jMenuItem57.setVisible(false);
        jMenuItem58.setVisible(false);
        jMenuItem59.setVisible(false);
        jMenuItem60.setVisible(false);
        jMenuItem62.setVisible(false);
        jMenuItem63.setVisible(false);
        jMenuItem64.setVisible(false);
        jMenuItem65.setVisible(false);
        jMenuItem66.setVisible(false);
        jMenuItem67.setVisible(false);
        jMenuItem68.setVisible(false);
        
        jMenuItem71.setVisible(false);
        jMenuItem72.setVisible(false);
        jMenuItem74.setVisible(false);
        jMenuItem75.setVisible(false);
        jMenuItem76.setVisible(false);
        jMenuItem77.setVisible(false);
        jMenuItem80.setVisible(false);
        jMenuItem81.setVisible(false);
        jMenuItem86.setVisible(false);
        jMenuItem89.setVisible(false);
        
        jMenuItem91.setVisible(false);
        
        jMenuItem93.setVisible(false);
        jMenuItem94.setVisible(false);
        jMenuItem95.setVisible(false);
        jMenuItem96.setVisible(false);
        jMenuItem97.setVisible(false);
        jMenuItem98.setVisible(false);
        jMenuItem99.setVisible(false);
        jMenuItem100.setVisible(false);
        jMenuItem101.setVisible(false);
        jMenuItem102.setVisible(false);
        jMenuItem103.setVisible(false);
        jMenuItem104.setVisible(false);
        jMenuItem105.setVisible(false);
        
        jMenuItem107.setVisible(false);
        jMenuItem110.setVisible(false);
        
        jMenuItem115.setVisible(false);
        jMenuItem116.setVisible(false);
        jMenuItem117.setVisible(false);
        jMenuItem118.setVisible(false);        
        jMenuItem119.setVisible(false);
        jMenuItem120.setVisible(false);
        jMenuItem121.setVisible(false);
        
        jMenuItem126.setVisible(false);
        jMenuItem128.setVisible(false);
        jMenuItem129.setVisible(false);
        
        jMenuItem132.setVisible(false);
        jMenuItem138.setVisible(false);
        jMenuItem139.setVisible(false);
        
        jMenuItem140.setVisible(false);
        jMenuItem141.setVisible(false);
        jMenuItem142.setVisible(false);
        jMenuItem143.setVisible(false);
        
        jMenu2.setVisible(false);
        jMenu3.setVisible(false);
        jMenu4.setVisible(false);
        jMenu5.setVisible(false);
        jMenu6.setVisible(false);
        jMenu7.setVisible(false);
        jMenu8.setVisible(false);
        jMenu9.setVisible(false);
        jMenu10.setVisible(false);
        jMenu12.setVisible(false);
        jMenu13.setVisible(false);
        
        jToolBar1.setVisible(false);
        jButton2.setVisible(false);
        jButton3.setVisible(false);
        jButton4.setVisible(false);
        jButton5.setVisible(false);
        jButton6.setVisible(false);
        jButton7.setVisible(false);
        jButton8.setVisible(false);
        
        //************************
        //  Справочники
        //*************************
        // Операции Конфекционные карты
        if(IOOperator.getSetupOperator(15)>0)
        {
            jMenu2.setVisible(true);
            jMenuItem43.setVisible(true);
            jMenuItem7.setVisible(true);
            
            
        }
        // Конфекционные карты
        if(IOOperator.getSetupOperator(1)>0)
        {
            jMenu2.setVisible(true);
            jMenuItem9.setVisible(true);
            jMenuItem110.setVisible(true);
            
            jButton4.setVisible(true);
            jToolBar1.setVisible(true);
        }
        
        // Конфекционные карты - комментарий
        if(IOOperator.getSetupOperator(68)>0)
        {
            jMenu2.setVisible(true);
            jMenuItem9.setVisible(true);
            jMenuItem110.setVisible(true);
        }
        
        // настройки пользователей
        if(IOOperator.getSetupOperator(14)>0)
        {
            jMenu4.setVisible(true);
            jMenuItem42.setVisible(true);
        }
        // справочники
        // фурнитура
        if(IOOperator.getSetupOperator(13)>0)
        {
            jMenu2.setVisible(true);
            jMenuItem24.setVisible(true);
        }
        // тип полотна
        if(IOOperator.getSetupOperator(30)>0)
        {
            jMenu2.setVisible(true);
            jMenuItem2.setVisible(true);
        }
        // группы полотен
        if(IOOperator.getSetupOperator(31)>0)
        {
            jMenu2.setVisible(true);
            jMenuItem59.setVisible(true);
        }
        // группы фурнитуры
        if(IOOperator.getSetupOperator(32)>0)
        {
            jMenu2.setVisible(true);
            jMenuItem60.setVisible(true);
        }
        //******************
        // поставщики полотна
        if(IOOperator.getSetupOperator(33)>0)
        {
            jMenu2.setVisible(true);
            jMenuItem6.setVisible(true);
        }
        // поставщики фурнитуры
        if(IOOperator.getSetupOperator(34)>0)
        {
            jMenu2.setVisible(true);
            jMenuItem30.setVisible(true);
        }
        // группы операций
        if(IOOperator.getSetupOperator(35)>0)
        {
            jMenu2.setVisible(true);
            jMenuItem43.setVisible(true);
        }
        // цвет полотна
        if(IOOperator.getSetupOperator(36)>0)
        {
            jMenu2.setVisible(true);
            jMenuItem5.setVisible(true);
        }
        // цвет ниток
        if(IOOperator.getSetupOperator(37)>0)
        {
            jMenu2.setVisible(true);
            jMenuItem26.setVisible(true);
        }
        // цвет фурнитуры
        if(IOOperator.getSetupOperator(38)>0)
        {
            jMenu2.setVisible(true);
            jMenuItem29.setVisible(true);
        }
        // места хранения
        if(IOOperator.getSetupOperator(40)>0)
        {
            jMenu2.setVisible(true);
            jMenuItem21.setVisible(true);
        }
        
        // все стравочники
        if(IOOperator.getSetupOperator(39)>0)
        {
            jMenu2.setVisible(true);
            jMenuItem10.setVisible(true);
            jMenuItem12.setVisible(true);
            jMenuItem25.setVisible(true);
            jMenuItem13.setVisible(true);
            jMenuItem14.setVisible(true);
            jMenuItem15.setVisible(true);
            jMenuItem16.setVisible(true);
            jMenuItem17.setVisible(true);
            jMenuItem18.setVisible(true);
            jMenuItem19.setVisible(true);
            jMenuItem20.setVisible(true);
            jMenuItem27.setVisible(true);
            jMenuItem28.setVisible(true);
            jMenuItem37.setVisible(true);            
            jMenuItem126.setVisible(true);
        }
        
        //****************************************************************
        // Склад полотна
        if(IOOperator.getSetupOperator(3)>0)
        {            
            jMenu3.setVisible(true);
            //jMenuItem22.setVisible(true);
            jMenuItem116.setVisible(true);
            
            jButton8.setVisible(true);
            jToolBar1.setVisible(true);
            
            if(IOOperator.getSetupOperator(3)>1)
            {
                jMenuItem3.setVisible(true);
                jMenuItem34.setVisible(true);
                jMenuItem36.setVisible(true);
                jMenuItem48.setVisible(true);
                jMenuItem64.setVisible(true);
                jMenuItem65.setVisible(true);
                jMenuItem66.setVisible(true);
                jMenuItem68.setVisible(true);
            }
        }
        
        //лоскуты
        if(IOOperator.getSetupOperator(69)>0)
        {
            jMenu3.setVisible(true);
            jMenuItem119.setVisible(true);
            jMenuItem120.setVisible(true);
            jMenuItem121.setVisible(true);            
        }
        
        // Склад полотна поставки и возвраты поставщику
        if(IOOperator.getSetupOperator(51)>0)
        {            
            jMenu3.setVisible(true);            
            jMenuItem3.setVisible(true);                
            jMenuItem64.setVisible(true);     
            
            jButton2.setVisible(true);
            jToolBar1.setVisible(true);
        }
        
        //***************************************************************
        // Склад фурнитуры
        if(IOOperator.getSetupOperator(4)>0)
        {
            jMenu7.setVisible(true);            
            jMenuItem32.setVisible(true);
            jMenuItem95.setVisible(true);
            jMenuItem98.setVisible(true);
            jMenuItem99.setVisible(true);
            jMenuItem100.setVisible(true);
            jMenuItem101.setVisible(true);
            jMenuItem102.setVisible(true);
            if(IOOperator.getSetupOperator(4)>1)
            {
                jMenuItem31.setVisible(true);
                jMenuItem58.setVisible(true);
            }
        }
        // Склад фурнитуры цех
        if(IOOperator.getSetupOperator(67)>0)
        {
            jMenu7.setVisible(true);            
            jMenuItem96.setVisible(true);
            jMenuItem97.setVisible(true);
            jMenuItem95.setVisible(true);            
            jMenuItem100.setVisible(true);
            jMenuItem101.setVisible(true);
        }
        
        //****************************************************************
        // Задачи
        
        // Обработка маршрутов
        if(IOOperator.getSetupOperator(10)>0 || IOOperator.getSetupOperator(11)>0 || IOOperator.getSetupOperator(12)>0 || IOOperator.getSetupOperator(18)>0 )
        {
            jMenu5.setVisible(true);            
            //jMenuItem40.setVisible(true);
            jMenuItem115.setVisible(true);
            
            jButton6.setVisible(true);
            jToolBar1.setVisible(true);
            
        }
       
        // Отправка маршрутов
        if(IOOperator.getSetupOperator(9)>0)
        {
            jMenu5.setVisible(true);            
            jMenuItem44.setVisible(true);
        }
        // Детали с вышивкой
        if(IOOperator.getSetupOperator(22)>0)
        {
            jMenu5.setVisible(true);            
            jMenuItem47.setVisible(true);
        }
        // Детали с принтом
        if(IOOperator.getSetupOperator(21)>0)
        {
            jMenu5.setVisible(true);            
            jMenuItem46.setVisible(true);
        }
        // Возврат на склад
        if(IOOperator.getSetupOperator(20)>0)
        {
            jMenu5.setVisible(true);            
            jMenuItem45.setVisible(true);
        }
        // Обработка настилов
        if(IOOperator.getSetupOperator(19)>0)
        {
            jMenu5.setVisible(true);            
            jMenuItem38.setVisible(true);
            
            jButton3.setVisible(true);
            jToolBar1.setVisible(true);
        }
        
        // Формирование настилов
        if(IOOperator.getSetupOperator(29)>0)
        {
            jMenu5.setVisible(true);            
            jMenuItem51.setVisible(true);
        }
        // Отбработка задач
        if(IOOperator.getSetupOperator(41)>0)
        {
            jMenu5.setVisible(true);            
            jMenuItem35.setVisible(true);
        }
        // Отпуск полотна для задач
        if(IOOperator.getSetupOperator(17)>0)
        {
            jMenu5.setVisible(true);            
            jMenuItem33.setVisible(true);
        }
        // Формирование задач
        if(IOOperator.getSetupOperator(16)>0)
        {
            jMenu5.setVisible(true);            
            jMenuItem8.setVisible(true);
        }
        
        // Набор фурнитуры
        if(IOOperator.getSetupOperator(42)>0)
        {
            jMenu5.setVisible(true);            
            jMenuItem39.setVisible(true);
        }
        
        // Формирование комплектовок
        if(IOOperator.getSetupOperator(7)>0)
        {
            jMenu5.setVisible(true);            
            jMenuItem11.setVisible(true);
            
            jButton5.setVisible(true);
            jToolBar1.setVisible(true);
        }
        
        // Ручной стол
        if(IOOperator.getSetupOperator(48)>0)
        {
            jMenu5.setVisible(true);            
            jMenuItem74.setVisible(true);
            jMenuItem75.setVisible(true);
        }
        
        // Склад кроя
        if(IOOperator.getSetupOperator(65)>0)
        {
            jMenu5.setVisible(true);            
            jMenuItem93.setVisible(true);            
        }
        
        // Склад кроя
        if(IOOperator.getSetupOperator(71)>0)
        {
            jMenu5.setVisible(true);            
            jMenuItem93.setVisible(true);            
        }
        
        // Претензии
        if(IOOperator.getSetupOperator(44)>0 || IOOperator.getSetupOperator(45)>0)
        {
            jMenu5.setVisible(true);            
            jMenuItem62.setVisible(true);
        }
        
        //*************************************************************
        // Учет
        // Учет рабочего времени
        if(IOOperator.getSetupOperator(2)>0)
        {
            jMenu8.setVisible(true);            
            jMenuItem41.setVisible(true);
            
            jButton7.setVisible(true);
            jToolBar1.setVisible(true);
        }
        
        // Учет зп швейный цех
        if(IOOperator.getSetupOperator(43)>0)
        {
            jMenu8.setVisible(true);            
            jMenuItem53.setVisible(true);
        }
        
        
        
        //************************************************************
        // Затраты
        // Затраты
        if(IOOperator.getSetupOperator(25)>0)
        {
            jMenu10.setVisible(true);            
            jMenuItem49.setVisible(true);
        }
        
        // курс уе
        if(IOOperator.getSetupOperator(52)>0)
        {
            jMenu10.setVisible(true);            
            jMenuItem50.setVisible(true);
        }
        
        // 
        if(IOOperator.getSetupOperator(53)>0)
        {
            jMenu10.setVisible(true);            
            jMenu13.setVisible(true);            
            jMenuItem54.setVisible(true);
            jMenuItem140.setVisible(true);
        }
        if(IOOperator.getSetupOperator(54)>0)
        {
            jMenu10.setVisible(true);            
            jMenu13.setVisible(true);            
            jMenuItem55.setVisible(true);
            jMenuItem141.setVisible(true);
        }
        if(IOOperator.getSetupOperator(55)>0)
        {
            jMenu10.setVisible(true);            
            jMenu13.setVisible(true);            
            jMenuItem56.setVisible(true);
            jMenuItem142.setVisible(true);
        }
        if(IOOperator.getSetupOperator(56)>0)
        {
            jMenu10.setVisible(true);            
            jMenuItem76.setVisible(true);
        }
        if(IOOperator.getSetupOperator(57)>0)
        {
            jMenu10.setVisible(true);            
            jMenuItem57.setVisible(true);
        }
        if(IOOperator.getSetupOperator(58)>0)
        {
            jMenu10.setVisible(true);            
            jMenuItem67.setVisible(true);
        }
        if(IOOperator.getSetupOperator(59)>0)
        {
            jMenu10.setVisible(true);            
            jMenuItem71.setVisible(true);
            jMenuItem128.setVisible(true);
        }
        if(IOOperator.getSetupOperator(60)>0)
        {
            jMenu10.setVisible(true);            
            jMenuItem72.setVisible(true);
        }
        if(IOOperator.getSetupOperator(61)>0)
        {
            jMenu10.setVisible(true);            
            jMenuItem77.setVisible(true);
        }
        if(IOOperator.getSetupOperator(62)>0)
        {
            jMenu10.setVisible(true);            
            jMenuItem80.setVisible(true);
        }
        if(IOOperator.getSetupOperator(63)>0)
        {
            jMenu10.setVisible(true);            
            jMenuItem81.setVisible(true);
        }
        
        if(IOOperator.getSetupOperator(74)>0)
        {
            jMenu10.setVisible(true);            
            jMenuItem91.setVisible(true);
        }
        
        if(IOOperator.getSetupOperator(75)>0)
        {
            jMenu10.setVisible(true);            
            jMenuItem89.setVisible(true);
        }
        
        if(IOOperator.getSetupOperator(76)>0)
        {
            jMenu10.setVisible(true);            
            jMenuItem117.setVisible(true);
        }
        
        if(IOOperator.getSetupOperator(77)>0)
        {
            jMenu10.setVisible(true);            
            jMenuItem118.setVisible(true);
        }
        if(IOOperator.getSetupOperator(78)>0)
        {
            jMenu10.setVisible(true);            
            jMenuItem129.setVisible(true);
        }
        if(IOOperator.getSetupOperator(79)>0)
        {
            jMenu10.setVisible(true);            
            jMenuItem132.setVisible(true);
        }
        if(IOOperator.getSetupOperator(80)>0)
        {
            jMenu10.setVisible(true);            
            jMenuItem139.setVisible(true);
        }
        

        
        if(IOOperator.getSetupOperator(64)>0)
        {
            jMenu10.setVisible(true);            
            jMenu13.setVisible(true);            
            jMenuItem86.setVisible(true);
            jMenuItem91.setVisible(true);
            jMenuItem57.setVisible(true);
            jMenuItem103.setVisible(true);
            jMenuItem104.setVisible(true);
            jMenuItem105.setVisible(true);
            jMenuItem89.setVisible(true);
            jMenuItem143.setVisible(true);
        }
        
        //************************************************************
        //отчеты
        if(IOOperator.getSetupOperator(27)>0)
        {
            jMenu6.setVisible(true);
            jMenuItem23.setVisible(true);
        }
        
        //********************************************************
        // Сервис обновление
        if(IOOperator.getSetupOperator(46)>0)
        {
            jMenu4.setVisible(true);
            jMenuItem63.setVisible(true);
        }
        
        //*************************************************************
        //аналитика
        if(IOOperator.getSetupOperator(26)>0)
        {
            jMenu9.setVisible(true);
        }
        
        if(IOOperator.getSetupOperator(66)>0)
        {
            jMenu9.setVisible(true);
            jMenuItem94.setVisible(true);
        }
        
        
        
        // *************************************************************
        // планирование
        if(IOOperator.getSetupOperator(73)>0)
        {
            jMenu12.setVisible(true);
            jMenuItem138.setVisible(true);
        }
        
    }
}
