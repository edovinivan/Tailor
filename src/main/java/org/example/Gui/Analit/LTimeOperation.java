/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Analit;

import org.example.Gui.Form.Helps.FGetDate;
import org.example.Gui.THaupt;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.example.logic.ModelOperation;
import org.example.logic.OperationGruppa;
import org.example.logic.plan.PModelPlan;
import org.example.util.HelpClass;
import org.example.util.IOModel;
import org.example.util.IOOperation;
import org.example.util.plan.IOModelPlan;
import org.example.util.plan.IOTimeOpChex;

/**
 *
 * @author ivan
 */
public class LTimeOperation extends javax.swing.JPanel {

    /**
     * Creates new form LTimeOperation
     * @param th1
     */
    public LTimeOperation(THaupt th1) {
        initComponents();
        th = th1;
        jDateChooser1.setDate(new Date());
        jDateChooser2.setDate(new Date());
        jLabel5.setText("");
    }

    THaupt th;
    ModelModelPlan1  model = new ModelModelPlan1();
    ModelTimeOperation2 model1 = new ModelTimeOperation2();
    ModelTimeChexOperation model2 = new ModelTimeChexOperation();
    List<TimeChexOperation> listTc;
    List<TimeChexOperation> listTcCurrent;
    
    TableRowSorter<TableModel> sorter;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelPaint1 = new org.example.Gui.Analit.JPanelPaint();
        jPanelPaint2 = new org.example.Gui.Analit.JPanelPaint();
        jPanelPaint3 = new org.example.Gui.Analit.JPanelPaint();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanelPaint1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout jPanelPaint1Layout = new javax.swing.GroupLayout(jPanelPaint1);
        jPanelPaint1.setLayout(jPanelPaint1Layout);
        jPanelPaint1Layout.setHorizontalGroup(
            jPanelPaint1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 265, Short.MAX_VALUE)
        );
        jPanelPaint1Layout.setVerticalGroup(
            jPanelPaint1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 245, Short.MAX_VALUE)
        );

        jPanelPaint2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout jPanelPaint2Layout = new javax.swing.GroupLayout(jPanelPaint2);
        jPanelPaint2.setLayout(jPanelPaint2Layout);
        jPanelPaint2Layout.setHorizontalGroup(
            jPanelPaint2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 266, Short.MAX_VALUE)
        );
        jPanelPaint2Layout.setVerticalGroup(
            jPanelPaint2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 245, Short.MAX_VALUE)
        );

        jPanelPaint3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout jPanelPaint3Layout = new javax.swing.GroupLayout(jPanelPaint3);
        jPanelPaint3.setLayout(jPanelPaint3Layout);
        jPanelPaint3Layout.setHorizontalGroup(
            jPanelPaint3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 258, Short.MAX_VALUE)
        );
        jPanelPaint3Layout.setVerticalGroup(
            jPanelPaint3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 244, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Советская");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Солмановка");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Уварово");

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jTable2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/cancel.png"))); // NOI18N
        jButton1.setText("Закрыть");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jDateChooser1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jDateChooser1.setPreferredSize(new java.awt.Dimension(150, 25));
        jToolBar1.add(jDateChooser1);

        jDateChooser2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jDateChooser2.setPreferredSize(new java.awt.Dimension(150, 25));
        jToolBar1.add(jDateChooser2);

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton4.setText("Показать");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton4);

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("В цех");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setText("Вернуть");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton5.setText("Тест");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel4.setText("jLabel4");

        jTable3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable3.setRowHeight(26);
        jTable3.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jTable3ComponentResized(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);

        jButton6.setText("Дата работы");
        jButton6.setToolTipText("Перенести дату работы");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel5.setText("jLabel5");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelPaint1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)))
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelPaint2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelPaint3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelPaint1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelPaint2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelPaint3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton6)
                                .addGap(67, 67, 67)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        th.closeTabPage();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        // TODO add your handling code here:
        //jLabel1.s
        printGraf();
    }//GEN-LAST:event_formComponentResized

    boolean g = true;
    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        if(g)
        {
            //model.setDataForNoChex(jDateChooser1.getDate(), jDateChooser2.getDate());
            jTable1.setModel(model);
            jTable1.setShowGrid(true);
            jTable1.getTableHeader().setReorderingAllowed(false);
            jTable1.getColumnModel().getColumn(3).setCellRenderer(HelpClass.jTableRendererColumnRight);
            jTable1.getColumnModel().getColumn(4).setCellRenderer(jTableRenderer);
            
            jTable1ComponentResized(null);
            sorter = new TableRowSorter<TableModel>(model);
            jTable1.setRowSorter(sorter);
            
            
            jTable2.setModel(model1);
            jTable2.setShowGrid(true);
            jTable2.getTableHeader().setReorderingAllowed(false);
            jTable2ComponentResized(null);
            
            jTable3.setModel(model2);
            jTable3.setShowGrid(true);
            jTable3.getTableHeader().setReorderingAllowed(false);
            jTable3.getColumnModel().getColumn(2).setCellRenderer(HelpClass.jTableRendererColumnRight);
            jTable3.getColumnModel().getColumn(3).setCellRenderer(HelpClass.jTableRendererColumnRight);
            jTable3.getColumnModel().getColumn(4).setCellRenderer(HelpClass.jTableRendererColumnRight);
            jTable3.getColumnModel().getColumn(5).setCellRenderer(HelpClass.jTableRendererColumnRight);
            jTable3ComponentResized(null);
            
            
            /*jTable1.getColumnModel().getColumn(2).setCellRenderer(jTableRendererImage);
            jTable1.getColumnModel().getColumn(8).setCellRenderer(HelpClass.jTableRendererColumnRight);
            jTable1.getColumnModel().getColumn(9).setCellRenderer(HelpClass.jTableRendererColumnRight);
            jTable1.getColumnModel().getColumn(11).setCellRenderer(jTableRenderer);*/
            g = false;
        }
        else
        {
            printGraf();
        }
    }//GEN-LAST:event_formComponentShown

    // подсветка и картинки в таблицу                       
    final ImageIcon edit = new ImageIcon(getClass().getResource("/org/example/images/1.png"));    

    private final DefaultTableCellRenderer jTableRenderer = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            JLabel cell = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (column == 4) {
                switch (Integer.parseInt(cell.getText())) {
                    case 1:
                        cell.setIcon(edit);
                        cell.setText("");
                        break;
                    case 0:
                        cell.setIcon(null);
                        cell.setText("");
                        break;
                    
                }
            }
            return cell;
        }

    };
    
    
    private void jTable1ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTable1ComponentResized
        // TODO add your handling code here:
        if(jTable1.getColumnCount()<=0)
            return;
        int h = (jTable1.getWidth()-90)/2;
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(0);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(0).setMinWidth(0);
        
        
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(h);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(h);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(60);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(30);
        
        
        
        
        
    }//GEN-LAST:event_jTable1ComponentResized

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        model.setDataForNoChex(jDateChooser1.getDate(), jDateChooser2.getDate());
        jTable1ComponentResized(null);
        
        //model1.setData(jDateChooser1.getDate(), jDateChooser2.getDate());
        //jTable2ComponentResized(null);        
        
        listTc = IOTimeOpChex.getChexOp(jDateChooser1.getDate(), jDateChooser2.getDate());
        
        listTcCurrent = new ArrayList<>(listTc);
        
        for(TimeChexOperation l: listTcCurrent)        
            l.setQty_current(IOTimeOpChex.getOpInCexCurrent(l.getOper(), l.getChex()));
        
        
        
        
        //model2.setDate(listTc);
        //jTable3ComponentResized(null);
        
        printGraf();
        
        String s = "";
        
        for(OperationGruppa o: IOOperation.getListOperationGruppa(-1))
        {
            s = s + o.getOperationgruppa() + " - " + o.getName() + "  ";
        }
        jLabel4.setText(s);
        
    }//GEN-LAST:event_jButton4ActionPerformed

    
    private void addCurrentTime()
    {
        for(TimeChexOperation l: listTc) 
        {
            for(TimeChexOperation l1: listTcCurrent) 
            {
                if(l1.getChex() == l.getChex())
                {
                    if(l1.getOper() == l.getOper())
                    {
                        l.setQty_current(l1.getQty_current());
                        continue;
                    }
                }
            }
        }
    }
    
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int h = jTable1.getSelectedRow();
        if(h==-1)
            return;
        FSendPModelToChex fp = new FSendPModelToChex(null, true);
        PModelPlan p = IOModelPlan.getPModelPlan((int)jTable1.getValueAt(h, 0));
        fp.setData(p);
        fp.setVisible(true);
        if(fp.getResult())
        {
            model.setDataForNoChex(jDateChooser1.getDate(), jDateChooser2.getDate());
            if(h<jTable1.getRowCount())
                jTable1.setRowSelectionInterval(h, h);
            
            //model1.setData(jDateChooser1.getDate(), jDateChooser2.getDate());
            //jTable2ComponentResized(null);
            
            listTc = IOTimeOpChex.getChexOp(jDateChooser1.getDate(), jDateChooser2.getDate());
            addCurrentTime();
            printGraf();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable2ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTable2ComponentResized
        // TODO add your handling code here:
         if(jTable2.getColumnCount()<=0)
            return;
        int h = (jTable2.getWidth()-50)/3;
        
        
        jTable2.getColumnModel().getColumn(0).setPreferredWidth(0);
        jTable2.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable2.getColumnModel().getColumn(0).setMinWidth(0);
        
        jTable2.getColumnModel().getColumn(1).setPreferredWidth(h);
        jTable2.getColumnModel().getColumn(2).setPreferredWidth(h);
        jTable2.getColumnModel().getColumn(3).setPreferredWidth(h);
        jTable2.getColumnModel().getColumn(4).setPreferredWidth(50);
        
        
    }//GEN-LAST:event_jTable2ComponentResized

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        /*int h = jTable2.getSelectedRow();
        if(h==-1)
            return;
        IOTimeOpChex.delPTimeChex((int)jTable2.getValueAt(h, 0));
        
        model.setDataForNoChex(jDateChooser1.getDate(), jDateChooser2.getDate());*/
        
        //if(h<jTable1.getRowCount())
        //    jTable1.setRowSelectionInterval(h, h);
            
        //model1.setData(jDateChooser1.getDate(), jDateChooser2.getDate());
        //    jTable2ComponentResized(null);
        
        int h = jTable3.getSelectedRow();
        String ss = "";
        if(h!=-1)
        {
            ss = (String) jTable3.getValueAt(h, 0);
        }
        
        FReturnTimeOperationChex fr = new FReturnTimeOperationChex(null, true, jDateChooser1.getDate(), jDateChooser2.getDate(), ss);
        fr.setVisible(true);
        if(fr.getResult())
        {
            model.setDataForNoChex(jDateChooser1.getDate(), jDateChooser2.getDate());
            listTc = IOTimeOpChex.getChexOp(jDateChooser1.getDate(), jDateChooser2.getDate());
            addCurrentTime();
            printGraf();
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        int h = jTable1.getSelectedRow();
        if(h==-1) return;
        PModelPlan p = IOModelPlan.getPModelPlan((int)jTable1.getValueAt(h, 0));
        List<ModelOperation> ls = IOModel.getListModelOperation(p.getModel().getModel(), -1);
        for(TimeChexOperation t: listTc)
            t.setQty_pm(0);
        
        for(ModelOperation m: ls)
        {
            for(TimeChexOperation t: listTc)
            {
                if(t.getOper() == m.getOperation().getOperationgruppa().getOperationgruppa())
                {
                    t.setQty_pm(t.getQty_pm() + m.getTimes().multiply(new BigDecimal(p.getNoChex())).intValue());
                }
            }            
        }
        
        printGraf();      
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTable3ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTable3ComponentResized
        // TODO add your handling code here:
         if(jTable3.getColumnCount()<=0)
            return;
        int h = (jTable3.getWidth()-240)/2;
        
        
        jTable3.getColumnModel().getColumn(0).setPreferredWidth(h);       
        jTable3.getColumnModel().getColumn(1).setPreferredWidth(h);
        jTable3.getColumnModel().getColumn(2).setPreferredWidth(60);
        jTable3.getColumnModel().getColumn(3).setPreferredWidth(60);
        jTable3.getColumnModel().getColumn(4).setPreferredWidth(60);
        jTable3.getColumnModel().getColumn(5).setPreferredWidth(60);
    }//GEN-LAST:event_jTable3ComponentResized

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==2)
        {
            jButton5ActionPerformed(null);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        int h = jTable1.getSelectedRow();
        if(h==-1)
            return;        
        if (JOptionPane.showConfirmDialog(null, "Вы действительно хотите перенести дату изготовления артикула<" + jTable1.getValueAt(h, 1)+ "> цвет <"+jTable1.getValueAt(h, 2)+">?", "Вопрос.", JOptionPane.YES_NO_OPTION) == 0) 
        {
            PModelPlan mp = IOModelPlan.getPModelPlan((int)jTable1.getValueAt(h, 0));
            FGetDate fg = new FGetDate(null, true, mp.getDates() , mp.getDates());
            fg.setText1("Новая дата");
            fg.setVisible(true);
            if(fg.getResult())
            {
                mp.setDates(fg.getDate1());
                IOModelPlan.setPModelPlan(mp);
                model.setDataForNoChex(jDateChooser1.getDate(), jDateChooser2.getDate());
                listTc = IOTimeOpChex.getChexOp(jDateChooser1.getDate(), jDateChooser2.getDate());
                addCurrentTime();
                printGraf();
            }
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        // TODO add your handling code here:
        switch(evt.getKeyCode())
        {
            // удалить значение
            
            case KeyEvent.VK_ESCAPE:
            {
                jLabel5.setText("");                
                setFilter();
                break;
            }                  
            case KeyEvent.VK_BACK_SPACE:
            {
                jLabel5.setText(jLabel5.getText().substring(0, (jLabel5.getText().length()-1)>0?(jLabel5.getText().length()-1):0));                
                setFilter();
                break;
            }            
            default:
                //if(String.valueOf(evt.getKeyChar()).matches("[0-9а-яА-Яa-zA-Z-\\s\\w]"))                
                if(String.valueOf(evt.getKeyChar()).matches("[A-Za-zА-Яа-я0-9/]"))                
                {
                    jLabel5.setText(jLabel5.getText()+evt.getKeyChar());
                    setFilter();                    
                }                 
        }
    }//GEN-LAST:event_jTable1KeyPressed

    private void setFilter()
    {
        sorter.setRowFilter(RowFilter.regexFilter("(?iu)"+jLabel5.getText(), 6));
    }
    
    
    private void printGraf()
    {
        if(listTc == null)
            return;
        if(listTc.isEmpty())
            return;
        ArrayList<Integer> ls1 = new ArrayList<>();
        ArrayList<Integer> ls2 = new ArrayList<>();
        ArrayList<Integer> ls3 = new ArrayList<>();
        
        List<String> l1 = new ArrayList<>();
        List<String> l2 = new ArrayList<>();
        List<String> l3 = new ArrayList<>();
        
        
        model2.setDate(listTc);
        jTable3ComponentResized(null);
        
        
        //System.out.println("aaaaa > " + listTc.size());
        
        for(TimeChexOperation t: listTc)
        {
            
            //System.out.println(t.getChexName() + "   " + t.getOperName() + " =  " + t.getQty_max());
            // советская
            if(t.getChex() == 1)
            {
                ls1.add(t.getQty_chex());
                ls1.add(t.getQty_pm());
                ls1.add(t.getQty_max());
                l1.add(String.valueOf(t.getOper()));
            }
            
            //уварово
            if(t.getChex() == 2)
            {
                ls2.add(t.getQty_chex());
                ls2.add(t.getQty_pm());
                ls2.add(t.getQty_max());
                l2.add(String.valueOf(t.getOper()));
            }
            
            //солмановка
            if(t.getChex() == 7)
            {
                ls3.add(t.getQty_chex());
                ls3.add(t.getQty_pm());
                ls3.add(t.getQty_max());
                l3.add(String.valueOf(t.getOper()));
            }
        }
        
        jPanelPaint1.setDataName(l1);
        jPanelPaint2.setDataName(l2);
        jPanelPaint3.setDataName(l3);
        
        jPanelPaint1.paintAll1(ls1);
        jPanelPaint2.paintAll1(ls2);
        jPanelPaint3.paintAll1(ls3);
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private org.example.Gui.Analit.JPanelPaint jPanelPaint1;
    private org.example.Gui.Analit.JPanelPaint jPanelPaint2;
    private org.example.Gui.Analit.JPanelPaint jPanelPaint3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
