/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Form;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.example.logic.Files;
import org.example.logic.Model;
import org.example.logic.ModelChex;
import org.example.logic.ModelFiles;
import org.example.logic.ModelKleevaya;
import org.example.logic.ModelOperation;
import org.example.logic.ModelPrintDetali;
import org.example.logic.ModelProduct;
import org.example.logic.ModelSablon;
import org.example.util.IOModel;
import org.example.util.IOSaveData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.example.util.HelpClass;
import org.example.util.IOFiles;

/**
 *
 * @author ivan
 */
public class FSaveExcel extends javax.swing.JDialog {

    /**
     * Creates new form FSaveExcel
     * @param parent
     * @param modal
     */
    public FSaveExcel(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jDateChooser1.setDate(new Date());
        jDateChooser2.setDate(new Date());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Выгрузка данных");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Выгрузка выполненных операций в цехах за период");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Выгрузить");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Дата с");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Дата по");

        jDateChooser1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jDateChooser2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox1.setText("Группировать по группам операций");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Операции конфекционных карт");

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("Выгрузить");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Выгрузить конфекционные карты в файлы");

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setText("Выгрузить");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Выгрузить КК в Xml");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Маршруты (отправлены и в работе)");

        jButton5.setText("Выгрузить");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jCheckBox1)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jButton5))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JFileChooser jf = new JFileChooser();        
        if(jf.showSaveDialog(this) == JFileChooser.APPROVE_OPTION)
        {
            IOSaveData.saveRabotnikOperation(jf.getSelectedFile().getAbsolutePath(), jDateChooser1.getDate(), jDateChooser2.getDate(), jCheckBox1.isSelected());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        setLocationRelativeTo(null);
    }//GEN-LAST:event_formWindowOpened

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        JFileChooser jf = new JFileChooser();        
        if(jf.showSaveDialog(this) == JFileChooser.APPROVE_OPTION)
        {
            IOSaveData.saveOperationModel(jf.getSelectedFile().getAbsolutePath());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        /*int i = 0;
        for(Model m: IOModel.getListModel(-1, 2, true))
        {
            try (PrintWriter outs = new PrintWriter(new OutputStreamWriter(new FileOutputStream("c:\\123\\"+m.getArticle().replace("\\", "-").replace("/", "-")+".csv", false), "cp1251"), false)) {
                outs.println("Модель;"+m.getTipmodel().getName());
                outs.println("Артикул;"+m.getArticle());
                outs.println("Название;"+m.getName());
                outs.println("Дата;"+m.getDates());
                outs.println("Норма расхода бейки;"+m.getBeika());
                outs.println("1 размер;"+m.getFirstrazmeri().getName());
                outs.println("Последний размер;"+m.getEndrazmeri().getName());
                outs.println("Раскладчик 1;"+m.getRaskladchik().getName());
                outs.println("Раскладчик 2;"+m.getRaskladchik1().getName());
                outs.println("Ответственный;"+m.getOtvetst());
                outs.println("Материал;Тип;Кол-во;Цвет;Цвет нитки");
                for(ModelProduct mp: IOModel.getListModelProduct(m.getModel(), -1, 1))
                    outs.println(mp.getProduct().getName()+";"+mp.getTipproduct().getName()+";"+mp.getQty().setScale(2, RoundingMode.HALF_UP)+";"+mp.getColor().getName()+";"+mp.getNitkicolor().getName());
                outs.println("Фурнитура;Кол-во;Цвет");
                for(ModelProduct mp: IOModel.getListModelProduct(m.getModel(), -1, 1))
                    outs.println(mp.getProduct().getName()+";"+mp.getQty().setScale(2, RoundingMode.HALF_UP)+";"+mp.getColor().getName());
                
                outs.println("Операция;Описание;Время;Сумма");
                for(ModelOperation o: IOModel.getListModelOperation(m.getModel(), -1))
                {
                    //o.getTimes().multiply(o.getSummao()).divide(new BigDecimal("3600"),6,RoundingMode.HALF_UP).setScale(2, RoundingMode.HALF_UP)
                    
                    outs.println(o.getOperation().getName()+";"+o.getText()+";"+o.getTimes().setScale(2, RoundingMode.HALF_UP)+";"+o.getTimes().multiply(o.getRazrad().getSumma()).divide(new BigDecimal("3600"),6, RoundingMode.HALF_UP).setScale(2, RoundingMode.HALF_UP).toString().replace(".", ","));
                }
                
               

                outs.close();

            } catch (UnsupportedEncodingException | FileNotFoundException ex) {
                System.out.println("ERROR " + ex);
            }
            i++;
            if(i>10)
            break;
        }*/
        
        int i = 0;
        
            try (PrintWriter outs = new PrintWriter(new OutputStreamWriter(new FileOutputStream("c:\\123\\mmm.csv", false), "cp1251"), false)) 
            {
                for (Model m : IOModel.getListModel(-1, 2, true)) 
                {
                    outs.println("Модель;" + m.getTipmodel().getName());
                    outs.println("Артикул;" + m.getArticle());
                    outs.println("Название;" + m.getName());
                    outs.println("Дата;" + m.getDates());
                    outs.println("Норма расхода бейки;" + m.getBeika());
                    outs.println("1 размер;" + m.getFirstrazmeri().getName());
                    outs.println("Последний размер;" + m.getEndrazmeri().getName());
                    outs.println("Раскладчик 1;" + m.getRaskladchik().getName());
                    outs.println("Раскладчик 2;" + m.getRaskladchik1().getName());
                    outs.println("Ответственный;" + m.getOtvetst());
                    outs.println("Материал;Тип;Кол-во;Цвет;Цвет нитки");
                    for (ModelProduct mp : IOModel.getListModelProduct(m.getModel(), -1, 1)) {
                        outs.println(mp.getProduct().getName() + ";" + mp.getTipproduct().getName() + ";" + mp.getQty().setScale(2, RoundingMode.HALF_UP) + ";" + mp.getColor().getName() + ";" + mp.getNitkicolor().getName());
                    }
                    outs.println("Фурнитура;Кол-во;Цвет");
                    for (ModelProduct mp : IOModel.getListModelProduct(m.getModel(), -1, 2)) {
                        outs.println(mp.getProduct().getName() + ";" + mp.getQty().setScale(2, RoundingMode.HALF_UP) + ";" + mp.getColor().getName());
                    }

                    outs.println("Операция;Описание;Время;Сумма");
                    for (ModelOperation o : IOModel.getListModelOperation(m.getModel(), -1)) {
                        //o.getTimes().multiply(o.getSummao()).divide(new BigDecimal("3600"),6,RoundingMode.HALF_UP).setScale(2, RoundingMode.HALF_UP)

                        outs.println(o.getOperation().getName() + ";" + o.getText() + ";" + o.getTimes().setScale(2, RoundingMode.HALF_UP) + ";" + o.getTimes().multiply(o.getRazrad().getSumma()).divide(new BigDecimal("3600"), 6, RoundingMode.HALF_UP).setScale(2, RoundingMode.HALF_UP).toString().replace(".", ","));
                    }
                    i++;
                    //if(i>10)
                    //   break;
                    
                    
                    outs.println("");
                    outs.println("");
                }              

                outs.close();

            } catch (UnsupportedEncodingException ex) {
                System.out.println("ERROR " + ex);
            } catch (FileNotFoundException ex) {
            Logger.getLogger(FSaveExcel.class.getName()).log(Level.SEVERE, null, ex);
        }
          
            
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        new File("d:\\123.xml").delete();
        XMLForWtite();
        Element e1 = doc.createElement("Models");
        Element e2, e3, e4, e5, e6, e7, e8, e9;
        
        Element e10, e11, e12, e13, e14, e15, e16, e17, e18, e19;
        Element e20, e21, e22, e23, e24, e25, e26, e27, e28, e29;
        int i = 0;
        for(Model m: IOModel.getListModel(-1, -1, false))
        {
            e2 = doc.createElement("Model");
            
            e2.setAttribute("price", m.getPrice().setScale(4, RoundingMode.HALF_UP).toString());                     
            e2.setAttribute("article", m.getArticle());                     
            e2.setAttribute("date", HelpClass.getPrintDate1(m.getDates()));                     
            e2.setAttribute("name", m.getName());   
            
            
            e3 = doc.createElement("textsite");            
            e3.setTextContent(" "+m.getTextsite());
            e2.appendChild(e3);  
            
            
            e6 = doc.createElement("otv");            
            e6.setTextContent(m.getOtvetst() + " ");
            e2.appendChild(e6);                     
            
            e7 = doc.createElement("beika");            
            e7.setTextContent(m.getBeika() + " ");
            e2.appendChild(e7);           
            
            e8 = doc.createElement("texts");            
            e8.setTextContent(m.getText() + " ");
            e2.appendChild(e8);                     
            
            e9 = doc.createElement("razm1");            
            e9.setAttribute("nom", "" + m.getFirstrazmeri().getNom());
            e9.setAttribute("name", "" + m.getFirstrazmeri().getName());
            e9.setAttribute("id", "" + m.getFirstrazmeri().getRazmeri());
            e9.setAttribute("gruppa_id", "" + m.getFirstrazmeri().getRazmerigruppa().getRazmerigruppa());
            e9.setAttribute("gruppa_name", "" + m.getFirstrazmeri().getRazmerigruppa().getName());
            
            e2.appendChild(e9);    
            
            
            e10 = doc.createElement("razmend");            
            e10.setAttribute("nom", "" + m.getEndrazmeri().getNom());
            e10.setAttribute("name", "" + m.getEndrazmeri().getName());
            e10.setAttribute("id", "" + m.getEndrazmeri().getRazmeri());
            e10.setAttribute("gruppa_id", "" + m.getEndrazmeri().getRazmerigruppa().getRazmerigruppa());
            e10.setAttribute("gruppa_name", "" + m.getEndrazmeri().getRazmerigruppa().getName());
            e2.appendChild(e10);    
            
            e11 = doc.createElement("raskladchik1");            
            e11.setAttribute("nom", "" + m.getRaskladchik().getRaskladchik());
            e11.setAttribute("name", "" + m.getRaskladchik().getName());
            e2.appendChild(e11);  
            
            e12 = doc.createElement("raskladchik2");            
            e12.setAttribute("nom", "" + m.getRaskladchik1().getRaskladchik());
            e12.setAttribute("name", "" + m.getRaskladchik1().getName());
            e2.appendChild(e12); 
            
            
            e13 = doc.createElement("status");            
            e13.setTextContent(""+m.getStatus());
            e2.appendChild(e13);  
            
            e14 = doc.createElement("tipmodel");            
            e14.setAttribute("id", "" + m.getTipmodel().getTipmodel());
            e14.setAttribute("name", "" + m.getTipmodel().getName());
            e14.setAttribute("koef", "" + m.getTipmodel().getKoef().setScale(4, RoundingMode.CEILING));
            e2.appendChild(e14);  
            
            
            e15 = doc.createElement("info");            
            e15.setAttribute("PM1", m.getPm1().setScale(4, RoundingMode.HALF_UP).toString());
            e15.setAttribute("PM2", m.getPm2().setScale(4, RoundingMode.HALF_UP).toString());
            e15.setAttribute("PM1_1", m.getPm1_1().setScale(4, RoundingMode.HALF_UP).toString());
            e15.setAttribute("PM1_2", m.getPm1_2().setScale(4, RoundingMode.HALF_UP).toString());
            e15.setAttribute("PM1_3", m.getPm1_3().setScale(4, RoundingMode.HALF_UP).toString());
            e15.setAttribute("PM1_4", m.getPm1_4().setScale(4, RoundingMode.HALF_UP).toString());
            e15.setAttribute("PM1_5", m.getPm1_5().setScale(4, RoundingMode.HALF_UP).toString());
            e15.setAttribute("PM1_6", m.getPm1_6().setScale(4, RoundingMode.HALF_UP).toString());
            e15.setAttribute("PM1_7", m.getPm1_7().setScale(4, RoundingMode.HALF_UP).toString());
            e15.setAttribute("PM1_8", m.getPm1_8().setScale(4, RoundingMode.HALF_UP).toString());
            e15.setAttribute("PM1_9", m.getPm1_9().setScale(4, RoundingMode.HALF_UP).toString());
            e15.setAttribute("PM2_1", m.getPm2_1().setScale(4, RoundingMode.HALF_UP).toString());
            e15.setAttribute("PM2_2", m.getPm2_2().setScale(4, RoundingMode.HALF_UP).toString());
            e15.setAttribute("PM2_3", m.getPm2_3().setScale(4, RoundingMode.HALF_UP).toString());
            e15.setAttribute("PM2_4", m.getPm2_4().setScale(4, RoundingMode.HALF_UP).toString());
            e15.setAttribute("PM2_5", m.getPm2_5().setScale(4, RoundingMode.HALF_UP).toString());
            e15.setAttribute("PM2_6", m.getPm2_6().setScale(4, RoundingMode.HALF_UP).toString());
            e15.setAttribute("PM2_7", m.getPm2_7().setScale(4, RoundingMode.HALF_UP).toString());
            e15.setAttribute("PM2_8", m.getPm2_8().setScale(4, RoundingMode.HALF_UP).toString());
            e15.setAttribute("PM2_9", m.getPm2_9().setScale(4, RoundingMode.HALF_UP).toString());
            e15.setAttribute("PM3_1", ""+ m.getPm3_1());
            e15.setAttribute("PM3_2", ""+ m.getPm3_2());
            e15.setAttribute("PM3_3", ""+ m.getPm3_3());
            e15.setAttribute("PM3_4", ""+ m.getPm3_4());
            e15.setAttribute("PM3_5", ""+ m.getPm3_5());
            e15.setAttribute("PM3_6", ""+ m.getPm3_6());
            e15.setAttribute("PM3_7", ""+ m.getPm3_7());
            e15.setAttribute("PM3_8", ""+ m.getPm3_8());
            e15.setAttribute("PM3_9", ""+ m.getPm3_9());
            e15.setAttribute("PM3", ""+ m.getPm3());
            e15.setAttribute("PM4", ""+ m.getPm4());           
            
            e2.appendChild(e15);
            
            
            // материалы
            e20 = doc.createElement("materials");     
            e20.setAttribute("doptext", "Материалы для модели");
            for(ModelProduct mp : IOModel.getListModelProduct(m.getModel(), -1, 1))
            {
                e16 = doc.createElement("material");            
                
                
                e17 = doc.createElement("prod");            
                e17.setAttribute("id", ""+ mp.getProduct().getProduct());           
                e17.setAttribute("name", ""+ mp.getProduct().getName());           
                e17.setAttribute("koef", ""+ mp.getProduct().getKoef().setScale(4, RoundingMode.HALF_UP).toString());           
                e17.setAttribute("measure", ""+ mp.getProduct().getMeasure().getName());           
                e17.setAttribute("prodgruppa_id", ""+ mp.getProduct().getProductgruppa().getProductgruppa());           
                e17.setAttribute("prodgruppa_name", ""+ mp.getProduct().getProductgruppa().getName());     
                e16.appendChild(e17);  
                
                e16.setAttribute("color_id", ""+ mp.getColor().getColor());           
                e16.setAttribute("color_name", ""+ mp.getColor().getName());           
                
                e16.setAttribute("color_n_id", ""+ mp.getNitkicolor().getColor());           
                e16.setAttribute("color_n_name", ""+ mp.getNitkicolor().getName());         
                
                e16.setAttribute("qty", ""+ mp.getQty().setScale(4, RoundingMode.HALF_UP).toString());           
                e16.setAttribute("qty_end", ""+ mp.getQty_end().setScale(4, RoundingMode.HALF_UP).toString());           
                e16.setAttribute("qty_start", ""+ mp.getQty_start().setScale(4, RoundingMode.HALF_UP).toString());                           
                
                e16.setAttribute("tipproduct_id", ""+ mp.getTipproduct().getTipproduct());           
                e16.setAttribute("tipproduct_name", ""+ mp.getTipproduct().getName());           
                
                e20.appendChild(e16);  
            }
            e2.appendChild(e20);  
            
            // фурнитура
            e20 = doc.createElement("furnituras");    
            e20.setAttribute("doptext", "Фурнитура для модели");
            for(ModelProduct mp : IOModel.getListModelProduct(m.getModel(), -1, 2))
            {
                e16 = doc.createElement("furnitura");            
                
                
                e17 = doc.createElement("prod");            
                e17.setAttribute("id", ""+ mp.getProduct().getProduct());           
                e17.setAttribute("name", ""+ mp.getProduct().getName());           
                e17.setAttribute("koef", ""+ mp.getProduct().getKoef().setScale(4, RoundingMode.HALF_UP).toString());           
                e17.setAttribute("measure", ""+ mp.getProduct().getMeasure().getName());           
                e17.setAttribute("prodgruppa_id", ""+ mp.getProduct().getProductgruppa().getProductgruppa());           
                e17.setAttribute("prodgruppa_name", ""+ mp.getProduct().getProductgruppa().getName());     
                e16.appendChild(e17);  
                
                e16.setAttribute("color_id", ""+ mp.getColor().getColor());           
                e16.setAttribute("color_name", ""+ mp.getColor().getName());           
                
                //e16.setAttribute("color_n_id", ""+ mp.getNitkicolor().getColor());           
                //e16.setAttribute("color_n_name", ""+ mp.getNitkicolor().getName());         
                
                e16.setAttribute("qty", ""+ mp.getQty().setScale(4, RoundingMode.HALF_UP).toString());           
                //e16.setAttribute("qty_end", ""+ mp.getQty_end().setScale(4, RoundingMode.HALF_UP).toString());           
                //e16.setAttribute("qty_start", ""+ mp.getQty_start().setScale(4, RoundingMode.HALF_UP).toString());                           
                
                //e16.setAttribute("tipproduct_id", ""+ mp.getTipproduct().getTipproduct());           
                //e16.setAttribute("tipproduct_name", ""+ mp.getTipproduct().getName());           
                
                e20.appendChild(e16);  
            }
            e2.appendChild(e20);
            
            // детали с вышывкой
            e20 = doc.createElement("vichivkas");
            e20.setAttribute("doptext", "Детали с вышивкой");
            for(ModelPrintDetali md: IOModel.getListModelPrintDetali(m.getModel(), -1, 2))
            {
                e18 = doc.createElement("vichivka");
                e18.setAttribute("id", "" + md.getPrintdetali().getPrintdetali());
                e18.setAttribute("name", "" + md.getPrintdetali().getName());
                e20.appendChild(e18);  
            }
            e2.appendChild(e20);
            // детали с принтом
            e20 = doc.createElement("prints");
            e20.setAttribute("doptext", "Детали с принтом");
            for(ModelPrintDetali md: IOModel.getListModelPrintDetali(m.getModel(), -1, 1))
            {
                e18 = doc.createElement("print");
                e18.setAttribute("id", "" + md.getPrintdetali().getPrintdetali());
                e18.setAttribute("name", "" + md.getPrintdetali().getName());
                e20.appendChild(e18);  
            }
            e2.appendChild(e20);
            
            
            //шаблоны
            e20 = doc.createElement("sablons");
            e20.setAttribute("doptext", "Шаблоны");
            for(ModelSablon md: IOModel.getListModelSablon(m.getModel(), -1))
            {
                e18 = doc.createElement("sablon");
                e18.setAttribute("id", "" + md.getSablon().getSablon());
                e18.setAttribute("name", "" + md.getSablon().getName());
                e18.setAttribute("qty", "" + md.getQty());
                e20.appendChild(e18);  
            }
            e2.appendChild(e20);
            
            //клеевая  
            e20 = doc.createElement("kleevayas");
            e20.setAttribute("doptext", "Клеевая");
            for(ModelKleevaya md: IOModel.getListModelKleevaya(m.getModel(), -1))
            {
                e18 = doc.createElement("kleevaya");
                e18.setAttribute("id", "" + md.getKleevaya().getKleevaya() );
                e18.setAttribute("name", "" + md.getKleevaya().getName());
                e18.setAttribute("qty", "" + md.getQty());
                e20.appendChild(e18);  
            }
            e2.appendChild(e20);
            
            //цеха
            e20 = doc.createElement("chexs");
            e20.setAttribute("doptext", "Цеха где используется");
            for(ModelChex mc: IOModel.getListModelChexForModel(m.getModel()))
            {
                e18 = doc.createElement("chex");
                e18.setAttribute("name", "" + mc.getChex().getName());
                e18.setAttribute("vals", "" + mc.getVals());                
                e20.appendChild(e18);  
            }
            e2.appendChild(e20);
            
            //термопечать
            e20 = doc.createElement("termos");
            e20.setAttribute("doptext", "Детали с термо печатью");
            for(ModelPrintDetali md: IOModel.getListModelPrintDetali(m.getModel(), -1, 3))
            {
                e18 = doc.createElement("termo");
                e18.setAttribute("id", "" + md.getPrintdetali().getPrintdetali());
                e18.setAttribute("name", "" + md.getPrintdetali().getName());
                e20.appendChild(e18);  
            }
            e2.appendChild(e20);
            
            //операции
            e18 = doc.createElement("operations");
            e18.setAttribute("doptext", "Операции");
            
            for(ModelOperation mo: IOModel.getListModelOperation(m.getModel(), -1))
            {
                e19 = doc.createElement("operation");
                e19.setAttribute("nom", "" + mo.getNom());
                e19.setAttribute("rab", mo.getRabotnik());
                e19.setAttribute("texts", mo.getText());
                e19.setAttribute("qty", "" + mo.getQty());
                e19.setAttribute("op_id", "" + mo.getOperation().getOperation());
                e19.setAttribute("op_name", "" + mo.getOperation().getName());
                e19.setAttribute("op_idg", "" + mo.getOperation().getOperationgruppa().getOperationgruppa());
                e19.setAttribute("op_nameg", "" + mo.getOperation().getOperationgruppa().getName());
                
                e19.setAttribute("summao", "" + mo.getSummao().setScale(2, RoundingMode.HALF_UP).toString());
                e19.setAttribute("times", "" + mo.getTimes().setScale(2, RoundingMode.HALF_UP).toString());
                
                e19.setAttribute("razr_nom", mo.getRazrad().getNom());
                e19.setAttribute("razr_id", "" + mo.getRazrad().getRazrad());
                e19.setAttribute("razr_pric", mo.getRazrad().getSumma().setScale(4, RoundingMode.HALF_UP).toString());
                                                
                e18.appendChild(e19);                     
            }            

            e2.appendChild(e18);                     
            
            
            //фотографии
            /*e18 = doc.createElement("fotos");
            e18.setAttribute("doptext", "Фотографии");
            
            for(ModelFiles mf: IOModel.getListModelFiles(m.getModel(), 0))
            {
                e19 = doc.createElement("foto");
                e19.setAttribute("name", mf.getFiles().getName());
                e19.setAttribute("hau", "" + mf.getHaupt());
                e19.setAttribute("fil_id", "" + mf.getFiles().getFiles());
                //e19.setTextContent(new String(mf.getFiles().getObj()));     
                
                // не выгружаем файлы
                //IOFiles.saveFile(mf.getFiles().getObj(), "d:\\"+mf.getFiles().getFiles());            
                e18.appendChild(e19);                     
            }
            
            e2.appendChild(e18);    */                 
            
                                    
            e1.appendChild(e2);                     
            
            
            i++;
            //if(i>5)
            //    break;
        }
        doc.appendChild(e1);
        writeXLMToFile("d:\\123.xml");
        
        System.exit(0);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        
        Date d1 = jDateChooser1.getDate();
        Date d2 = jDateChooser2.getDate();
        if(d1 == null || d2 == null){
            JOptionPane.showMessageDialog(null, "Введите дату");
            return;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        JFileChooser jf = new JFileChooser();        
        if(jf.showSaveDialog(this) == JFileChooser.APPROVE_OPTION)
        {
            IOSaveData.saveMsrhrut(jf.getSelectedFile().getAbsolutePath(), formatter.format(d1), formatter.format(d2));
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * Запись xml в файл
     * @param file_name 
     */
    public void writeXLMToFile(String file_name)
    {
        try {
            DOMSource source = new DOMSource(doc);
            FileWriter writer = new FileWriter(new File(file_name));
            StreamResult result = new StreamResult(writer);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            
            transformer.transform(source, result);
        } catch (IOException ex) {
            System.out.println(ex);
        } catch (TransformerConfigurationException ex) {
            System.out.println(ex);
        } catch (TransformerException ex) {
            System.out.println(ex);
        }
    }
    
    
    private void XMLForWtite() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            //DocumentBuilder builder = factory.newDocumentBuilder();
            //DOMImplementation impl = builder.getDOMImplementation(); 
            //doc = impl.createDocument(null, null, null);
            doc = factory.newDocumentBuilder().newDocument();
        } catch (ParserConfigurationException ex) {
            //Logger.getLogger(XMLForEgais.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    Document doc;
    
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
            java.util.logging.Logger.getLogger(FSaveExcel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                FSaveExcel dialog = new FSaveExcel(new javax.swing.JFrame(), true);
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
    private javax.swing.JCheckBox jCheckBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
