/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Arbait;

import org.example.Gui.Arbait.Model.ModelZadachaKomplektovka;
import org.example.Gui.Form.Helps.FGetDate;
import org.example.Gui.Form.Report.LReport;
import org.example.Gui.THaupt;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.example.logic.ZadachaKomplektovka;
import org.example.logic.ZadachaKomplektovkaRazmeri;
import org.example.util.DateRenderer;
import org.example.util.IOOperator;
import org.example.util.IOZadachaKomplektovka;

/**
 *
 * @author ivan
 */
public class LAllKomplektovka extends javax.swing.JPanel {

    /**
     * Creates new form LAllKomplektovka
     * @param th1
     * @param ha
     */
    public LAllKomplektovka(THaupt th1, int ha) {
        initComponents();
        th = th1;
        hand = ha;
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, 10);
        d2 = c.getTime();
        c.add(Calendar.DAY_OF_MONTH, -17);
        d1 = c.getTime();
    }

    Date d1, d2;
    THaupt th;
    int hand;
    ModelZadachaKomplektovka model = new ModelZadachaKomplektovka();
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
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
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

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel.png"))); // NOI18N
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

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        jButton2.setText("Добавить");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        jButton3.setText("Изменить");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/remove.png"))); // NOI18N
        jButton4.setText("Удалить");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton4);

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/filter.png"))); // NOI18N
        jButton10.setText("Фильтр");
        jButton10.setFocusable(false);
        jButton10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton10.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton10);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh.png"))); // NOI18N
        jButton5.setText("Обновить");
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton5);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/2.png"))); // NOI18N
        jButton6.setText("Утвердить");
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton6);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1.png"))); // NOI18N
        jButton7.setText("Открыть");
        jButton7.setFocusable(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton7);

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/print.png"))); // NOI18N
        jButton8.setText("Печать");
        jButton8.setFocusable(false);
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton8);

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/basket.png"))); // NOI18N
        jButton9.setText("Копировать");
        jButton9.setFocusable(false);
        jButton9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton9);

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cascade.png"))); // NOI18N
        jButton11.setText("Размножить");
        jButton11.setFocusable(false);
        jButton11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton11.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton11);

        jCheckBox1.setText("Все");
        jCheckBox1.setFocusable(false);
        jCheckBox1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jCheckBox1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jCheckBox1);

        jLabel1.setText("jLabel1");
        jToolBar1.add(jLabel1);

        jTable1.setAutoCreateRowSorter(true);
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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTable1ComponentResized
        // TODO add your handling code here:
        if(jTable1.getColumnCount()<=0)
            return;
        int h = (jTable1.getWidth()-210)/4;
        
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(0);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(0).setMinWidth(0);
        
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(30);          
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(h);        
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(h);  
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(h);  
        
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(100);  
        
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(0);
        jTable1.getColumnModel().getColumn(6).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(6).setMinWidth(0);
        
        jTable1.getColumnModel().getColumn(7).setPreferredWidth(h);  
        jTable1.getColumnModel().getColumn(8).setPreferredWidth(80);
        
        jTable1.getColumnModel().getColumn(9).setPreferredWidth(0);
        jTable1.getColumnModel().getColumn(9).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(9).setMinWidth(0);
    }//GEN-LAST:event_jTable1ComponentResized

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        model.setDataForOperator(IOOperator.operator.getRabotnik().getRabotnik(), hand, d1, d2, jCheckBox1.isSelected());
        jTable1.setModel(model);
        jTable1.setShowGrid(true);                    
        jTable1.getTableHeader().setReorderingAllowed(false);   
        jTable1.getColumnModel().getColumn(1).setCellRenderer(model.jTableRenderer1);
        jTable1.getColumnModel().getColumn(5).setCellRenderer(new DateRenderer());
        jTable1ComponentResized(null);
        jLabel1.setText("");
        sorter = new TableRowSorter<TableModel>(model);        
        jTable1.setRowSorter(sorter);
    }//GEN-LAST:event_formComponentShown

    /**
     * Добавить комплектовку
     * @param evt 
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        FKomplektovka f = new FKomplektovka(null, true, 0, 0, IOOperator.operator.getRabotnik().getRabotnik(), 0, hand);
        f.setVisible(true);
        model.setDataForOperator(IOOperator.operator.getRabotnik().getRabotnik(), hand, d1, d2, jCheckBox1.isSelected());
        //model.setData(zadacha.getZadacha());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        th.closeTabPage();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        model.setDataForOperator(IOOperator.operator.getRabotnik().getRabotnik(), hand, d1, d2, jCheckBox1.isSelected());
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int h = jTable1.getSelectedRow();
        if(h==-1) return;
        FKomplektovka f = new FKomplektovka(null, true, 0, (int)jTable1.getValueAt(h, 0), IOOperator.operator.getRabotnik().getRabotnik(), 0, hand);
        f.setVisible(true);
        model.setDataForOperator(IOOperator.operator.getRabotnik().getRabotnik(), hand, d1, d2, jCheckBox1.isSelected());
        jTable1.setRowSelectionInterval(h, h);
        
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * Удалить
     * @param evt 
     */
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int h = jTable1.getSelectedRow();
        if(h==-1)
            return;
        h = (int) jTable1.getValueAt(h, 0);
        if (JOptionPane.showConfirmDialog(null, "Вы действительно хотите удалить комплектовку №<" + jTable1.getValueAt(jTable1.getSelectedRow(), 2) + ">?", "Вопрос.", JOptionPane.YES_NO_OPTION) == 0) 
        {
            ZadachaKomplektovka zk = IOZadachaKomplektovka.getListZadachaKomplektovka(0, h).get(0);
            if(zk.getStatus()>0)
            {
                JOptionPane.showMessageDialog(null, "Ошибка удаления! Комплектовка утверждена!");
                return;
            }
            
            if(IOZadachaKomplektovka.delZadachaKomplektovka(h))
                model.setDataForOperator(IOOperator.operator.getRabotnik().getRabotnik(), hand, d1, d2, jCheckBox1.isSelected());
            else
                JOptionPane.showMessageDialog(null, "Ошибка удаления");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * Утвердить
     * @param evt 
     */
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        int h = jTable1.getSelectedRow();
        if(h==-1)
            return;
        h = (int) jTable1.getValueAt(h, 0);
        if (JOptionPane.showConfirmDialog(null, "Вы действительно хотите утвердить комплектовку <" + jTable1.getValueAt(jTable1.getSelectedRow(), 2) + ">?", "Вопрос.", JOptionPane.YES_NO_OPTION) == 0) 
        {
            if(IOZadachaKomplektovka.getListZadachaKomplektovka(0, h).get(0).getStatus()!=0)
            {
                //JOptionPane.showMessageDialog(null, "Данную комплектовку нельзя утвердить. Она уже утверждена!");
                return;
            }
            
            //проверим есть или нет изделия
            int k=0;
            for(ZadachaKomplektovkaRazmeri r: IOZadachaKomplektovka.getListZadachaKomplektovkaRazmeri(h))
            {
                k = k + r.getQty();
            }
                
            if(k==0)
            {
                JOptionPane.showMessageDialog(null, "В комплектовке нет изделий!");
                return;
            }
            
            if(IOZadachaKomplektovka.setStatusKomplektovkaGut(h, 1))
            {
                h = jTable1.getSelectedRow();
                model.setDataForOperator(IOOperator.operator.getRabotnik().getRabotnik(), hand, d1, d2, jCheckBox1.isSelected());
                jTable1.setRowSelectionInterval(h, h);
            }
            else
                JOptionPane.showMessageDialog(null, "Ошибка утверждения");
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        // 89156720485
        int h = jTable1.getSelectedRow();
        if(h==-1)
            return;
        h = (int) jTable1.getValueAt(h, 0);
        if (JOptionPane.showConfirmDialog(null, "Вы действительно хотите открыть комплектовку <" + jTable1.getValueAt(jTable1.getSelectedRow(), 2) + ">?", "Вопрос.", JOptionPane.YES_NO_OPTION) == 0) 
        {
            if(IOZadachaKomplektovka.getListZadachaKomplektovka(0, h).get(0).getStatus()!=1)
            {
                JOptionPane.showMessageDialog(null, "Данную комплектовку нельзя открыть!");
                return;
            }
            if(IOZadachaKomplektovka.setStatusKomplektovkaEdit(h))
            {
                h = jTable1.getSelectedRow();
                model.setDataForOperator(IOOperator.operator.getRabotnik().getRabotnik(), hand, d1, d2, jCheckBox1.isSelected());
                jTable1.setRowSelectionInterval(h, h);
            }
            else
                JOptionPane.showMessageDialog(null, "Ошибка открытия!");
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        if(jTable1.getSelectedRow()==-1) return;
        LReport lr = new LReport(null, true, 7,(int)jTable1.getValueAt(jTable1.getSelectedRow(), 0));
        lr.setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        int h = jTable1.getSelectedRow();
        if(h==-1) return;
        int zk = IOZadachaKomplektovka.copyZadachaKomplektovka((int)jTable1.getValueAt(h, 0)).getZadachakomplektovka();
        FKomplektovka f = new FKomplektovka(null, true, 0, zk, IOOperator.operator.getRabotnik().getRabotnik(), 0, hand);
        f.setVisible(true);
        model.setDataForOperator(IOOperator.operator.getRabotnik().getRabotnik(), hand, d1, d2, jCheckBox1.isSelected());
        jTable1.setRowSelectionInterval(h, h);
        
    }//GEN-LAST:event_jButton9ActionPerformed

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

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        FGetDate fg = new FGetDate(null, true, d1, d2);
        fg.setVisible(true);
        if(fg.getResult())
        {
            d1 = fg.getDate1();
            d2 = fg.getDate2();
            jButton5ActionPerformed(null);
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        int h = jTable1.getSelectedRow();
        if(h==-1) return;
        int zk = IOZadachaKomplektovka.copyZadachaKomplektovkaAndRazmer((int)jTable1.getValueAt(h, 0)).getZadachakomplektovka();
        FKomplektovka f = new FKomplektovka(null, true, 0, zk, IOOperator.operator.getRabotnik().getRabotnik(), 0, hand);
        f.setVisible(true);
        model.setDataForOperator(IOOperator.operator.getRabotnik().getRabotnik(), hand, d1, d2, jCheckBox1.isSelected());
        jTable1.setRowSelectionInterval(h, h);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void setFilter()
    {
        sorter.setRowFilter(RowFilter.regexFilter("(?iu)"+jLabel1.getText(), 2));
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
