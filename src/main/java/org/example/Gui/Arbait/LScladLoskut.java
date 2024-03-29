/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Arbait;

import org.example.Gui.Arbait.Model.ModelSclasLoskut;
import org.example.Gui.Form.FHistoryOperation;
import org.example.Gui.Form.FOperation;
import org.example.Gui.Form.Report.LReport;
import org.example.Gui.THaupt;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.math.RoundingMode;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.example.logic.ScladLoskut;
import org.example.util.HelpClass;
import org.example.util.IOOperationHistory;
import org.example.util.IOScladLoskut;

/**
 *
 * @author ivan
 */
public class LScladLoskut extends javax.swing.JPanel {

    /**
     * Creates new form LScladLoskut
     * @param th1
     * @param tip1 - 1 - принятие 
     */
    public LScladLoskut(THaupt th1, int tip1) {
        initComponents();
        th = th1;
        tip = tip1;    
        jButton2.setVisible(tip==1);
        jButton4.setVisible(tip==2);
        jButton5.setVisible(tip==2);
        jButton6.setVisible(tip==2);
    }
    
    int tip;
    THaupt th;
    ModelSclasLoskut model = new ModelSclasLoskut();
    TableRowSorter<TableModel> sorter;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

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

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/2.png"))); // NOI18N
        jButton2.setText("Принять");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/bac.png"))); // NOI18N
        jButton6.setText("Вернуть");
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton6);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/refresh.png"))); // NOI18N
        jButton3.setText("Обновить");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/redo.png"))); // NOI18N
        jButton4.setText("Все");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton4);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/remove.png"))); // NOI18N
        jButton5.setText("Списать");
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton5);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/print.png"))); // NOI18N
        jButton7.setText("Печать");
        jButton7.setFocusable(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton7);

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/basket.png"))); // NOI18N
        jButton8.setText("История");
        jButton8.setFocusable(false);
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton8);

        jLabel1.setText("jLabel1");
        jToolBar1.add(jLabel1);

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        th.closeTabPage();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTable1ComponentResized
        // TODO add your handling code here:
         if(jTable1.getColumnCount()<=0)
            return;
        int h = (jTable1.getWidth()-310)/3;
        
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(0);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(0).setMinWidth(0);
        
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(30);          
        
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(120);  
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(h);          
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(h);  
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(h);  
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(80);  
        jTable1.getColumnModel().getColumn(7).setPreferredWidth(80);  
    }//GEN-LAST:event_jTable1ComponentResized


    boolean fv = true;
    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        if(fv)
        {
            model.setData(tip, false);
            jTable1.setModel(model);
            jTable1.setShowGrid(true);
            jTable1.getTableHeader().setReorderingAllowed(false);
            jTable1.getColumnModel().getColumn(1).setCellRenderer(jTableRenderer);
            jTable1.getColumnModel().getColumn(6).setCellRenderer(HelpClass.jTableRendererColumnRight);
            jTable1.getColumnModel().getColumn(7).setCellRenderer(HelpClass.jTableRendererColumnRight);
            jTable1ComponentResized(null);
            sorter = new TableRowSorter<TableModel>(model);        
            jTable1.setRowSorter(sorter);
            fv = false;
            jLabel1.setText("");
            TimerTask tt = new TimerTask() {
            @Override
            public void run() {                         
                int h = jTable1.getSelectedRow();
                model.setData(tip, false);
                jTable1.setRowSelectionInterval(h, h);
                if (h != -1) 
                    jTable1.setRowSelectionInterval(h, h);
            }
        };
        Timer tm = new Timer();                       
        tm.schedule(tt, 1200000, 1200000); 
            
        }
        jTable1.requestFocusInWindow();
    }//GEN-LAST:event_formComponentShown

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int h = jTable1.getSelectedRow();
        if(h==-1)
            return;
        ScladLoskut sl = IOScladLoskut.getScladLoskut((int)jTable1.getValueAt(h, 0));
        if(sl.getStatus()!=0)
            return;
        if (JOptionPane.showConfirmDialog(null, "Вы действительно хотите принять на склад <" + sl.getProduct().getName() + ">, в количестве "+sl.getQty().setScale(2, RoundingMode.HALF_UP)+"?", "Вопрос.", JOptionPane.YES_NO_OPTION) == 0) 
        {
            sl.setStatus(1);
            IOScladLoskut.setScladLoskut(sl);
            IOOperationHistory.saveOperationHistory("Приняли на склад", sl.getZadachanastil().getZadachanastil(), 1);
            model.setData(tip, false);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        model.setData(tip, true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        int h = jTable1.getSelectedRow();
        if(h==-1)
            return;
        ScladLoskut sl = IOScladLoskut.getScladLoskut((int)jTable1.getValueAt(h, 0));
        if(sl.getOstatok().signum()==0)
            return;
        FScladLoskutSale fs = new FScladLoskutSale(null, true, sl.getScladloskut());
        fs.setVisible(true);
        if(fs.getResult())
        {
            model.setData(tip, false);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        model.setData(tip, false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        int h = jTable1.getSelectedRow();
        if(h==-1)
            return;
        ScladLoskut sl = IOScladLoskut.getScladLoskut((int)jTable1.getValueAt(h, 0));
        if(sl.getStatus()!=1)
            return;
        if (JOptionPane.showConfirmDialog(null, "Вы действительно хотите вернуть со склада <" + sl.getProduct().getName() + ">, в количестве "+sl.getQty().setScale(2, RoundingMode.HALF_UP)+"?", "Вопрос.", JOptionPane.YES_NO_OPTION) == 0) 
        {
            if(!IOScladLoskut.getScladLoskutSaleForSL(sl.getScladloskut()).isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Выбранное полотно уже списывали!");
                return;
            }
            sl.setStatus(0);
            IOScladLoskut.setScladLoskut(sl);
            
            IOOperationHistory.saveOperationHistory("Вернули со склада", sl.getZadachanastil().getZadachanastil(), 1);
            
            model.setData(tip, false);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        // TODO add your handling code here:
        switch(evt.getKeyCode())
        {
            // удалить значение
            
            case KeyEvent.VK_ESCAPE:
            {
                jLabel1.setText("");                
                setFilter();
                break;
            }                  
            case KeyEvent.VK_BACK_SPACE:
            {
                jLabel1.setText(jLabel1.getText().substring(0, (jLabel1.getText().length()-1)>0?(jLabel1.getText().length()-1):0));                
                setFilter();
                break;
            }            
            default:
                //if(String.valueOf(evt.getKeyChar()).matches("[0-9а-яА-Яa-zA-Z-\\s\\w]"))                
                if(String.valueOf(evt.getKeyChar()).matches("[A-Za-zА-Яа-я0-9/]"))                
                {
                    jLabel1.setText(jLabel1.getText()+evt.getKeyChar());
                    setFilter();                    
                }                 
        }
    }//GEN-LAST:event_jTable1KeyPressed

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        // TODO add your handling code here:
        jTable1.requestFocusInWindow();
    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        //if(jTable1.getSelectedRow()==-1) return;
        LReport lr = new LReport(null, true, 18,0);
        lr.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        int h = jTable1.getSelectedRow();
        if(h==-1)
            return;
        ScladLoskut sl = IOScladLoskut.getScladLoskut((int)jTable1.getValueAt(h, 0));
        FHistoryOperation fo = new FHistoryOperation(null, true, sl.getZadachanastil().getZadachanastil(), 1);
        fo.setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    // подсветка и картинки в таблицу                       
    final ImageIcon edit = new ImageIcon(getClass().getResource("/org/example/images/1.png"));
    final ImageIcon ok1 = new ImageIcon(getClass().getResource("/org/example/images/2.png"));
    public DefaultTableCellRenderer jTableRenderer = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            JLabel cell = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            int v = Integer.parseInt(cell.getText());
                if (column == 1) {
                    switch (v) {
                        case 0:
                            cell.setIcon(edit);
                            cell.setText("");
                            break;
                        case 1:
                            cell.setIcon(ok1);
                            cell.setText("");
                            break;
                    }
                }
            return cell;
        }

    };
    
    
    private void setFilter()
    {
        sorter.setRowFilter(RowFilter.regexFilter("(?iu)"+jLabel1.getText(), 4));
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
