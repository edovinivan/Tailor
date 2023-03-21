/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.List;

import org.example.Gui.Form.FDocumentF;
import org.example.Gui.Form.Helps.FGetDate;
import org.example.Gui.THaupt;
import org.example.Gui.model.ModelDocumentF;
import java.awt.Component;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import org.example.util.IODocumentF;
import org.example.util.IOOperator;

/**
 *
 * @author ivan
 */
public class LDocumentF extends javax.swing.JPanel {

    /**
     * Creates new form LDocumentF
     * @param th1
     */
    public LDocumentF(THaupt th1) {
        initComponents();
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, 10);
        d2 = c.getTime();
        c.add(Calendar.DAY_OF_MONTH, -100);
        d1 = c.getTime();
        th = th1;
    }
    Date d1, d2;
    THaupt th;
    ModelDocumentF model = new ModelDocumentF();

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
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
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

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/add.png"))); // NOI18N
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

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/edit.png"))); // NOI18N
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

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/remove.png"))); // NOI18N
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

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/refresh.png"))); // NOI18N
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

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/filter.png"))); // NOI18N
        jButton6.setText("Фильтр");
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton6);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/go.png"))); // NOI18N
        jButton7.setText("Переместить");
        jButton7.setFocusable(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton7);

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/1.png"))); // NOI18N
        jButton8.setText("Отменить");
        jButton8.setFocusable(false);
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton8);

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/2.png"))); // NOI18N
        jButton9.setText("Принять");
        jButton9.setFocusable(false);
        jButton9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton9);

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/bac.png"))); // NOI18N
        jButton10.setText("Вернуть");
        jButton10.setFocusable(false);
        jButton10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton10.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton10);

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
        int h = (jTable1.getWidth()-150)/3;
        
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(0);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(0).setMinWidth(0);
        
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(30);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(h);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(120);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(2*h);
        
    }//GEN-LAST:event_jTable1ComponentResized

    boolean f = true;
    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        if(f)
        {
            model.setData(d1, d2);
            jTable1.setModel(model);
            jTable1.setShowGrid(true);
            jTable1.getTableHeader().setReorderingAllowed(false);
            jTable1ComponentResized(null);
            //for (int i = 0; i < jTable1.getColumnModel().getColumnCount(); i++) 
            jTable1.getColumnModel().getColumn(1).setCellRenderer(jTableRenderer);
            //jTable1.getColumnModel().getColumn(6).setCellRenderer(jTableRenderer1);
            //jTable1.getColumnModel().getColumn(7).setCellRenderer(jTableRenderer1);
            f = false;
            if(IOOperator.getSetupOperator(4)<2)
            {
                jButton2.setVisible(false);
                jButton4.setVisible(false);
                jButton7.setVisible(false);
                jButton8.setVisible(false);
            }
            if(IOOperator.getSetupOperator(67)<2)
            {
                jButton9.setVisible(false);
                jButton10.setVisible(false);                
            }
        }
    }//GEN-LAST:event_formComponentShown

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        FGetDate fg = new FGetDate(null, true, d1, d2);
        fg.setVisible(true);
        if(fg.getResult())
        {
            d1 = fg.getDate1();
            d2 = fg.getDate2();
            model.setData(d1, d2);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        model.setData(d1, d2);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        th.closeTabPage();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
 
        FDocumentF ff = new FDocumentF(null, true, 0);
        ff.setVisible(true);
        model.setData(d1, d2);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int h = jTable1.getSelectedRow();
        if(h == -1) return;        
        FDocumentF ff = new FDocumentF(null, true, (int)jTable1.getValueAt(h, 0));
        ff.setVisible(true);
        model.setData(d1, d2);
        jTable1.setRowSelectionInterval(h, h);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int h = jTable1.getSelectedRow();
        if(h==-1)
            return;        
        if (JOptionPane.showConfirmDialog(null, "Вы действительно хотите удалить документ №<" + jTable1.getValueAt(h, 2) + ">?", "Вопрос.", JOptionPane.YES_NO_OPTION) == 0) 
        {
            int r = IODocumentF.delDocumentF((int)jTable1.getValueAt(h, 0));
            switch(r)
            {
                case -1:
                    JOptionPane.showMessageDialog(null, "Документ уже удален.");
                    break;
                case -2:
                    JOptionPane.showMessageDialog(null, "Документ закрыт.");    
                    break;
                case -3:
                    JOptionPane.showMessageDialog(null, "Ошибка удаления");        
                    break;
                case -4:
                    JOptionPane.showMessageDialog(null, "Ошибка удаления строки");        
                    break;
                default:
                    model.setData(d1, d2);
            }            
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        int h = jTable1.getSelectedRow();
        if(h==-1)
            return;        
        if (JOptionPane.showConfirmDialog(null, "Вы действительно хотите закрыть документ №<" + jTable1.getValueAt(h, 2) + ">?", "Вопрос.", JOptionPane.YES_NO_OPTION) == 0) 
        {
            int r = IODocumentF.sendDocumentF((int)jTable1.getValueAt(h, 0));
            switch(r)
            {
                case -1:
                    JOptionPane.showMessageDialog(null, "Документ удален.");
                    break;
                case -2:
                    JOptionPane.showMessageDialog(null, "Документ уже закрыт.");    
                    break;
                case -3:
                    JOptionPane.showMessageDialog(null, "В документе нет строк.");        
                    break;                
                default:
                    model.setData(d1, d2);
            }            
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        int h = jTable1.getSelectedRow();
        if(h==-1)
            return;        
        if (JOptionPane.showConfirmDialog(null, "Вы действительно хотите открыть документ №<" + jTable1.getValueAt(h, 2) + ">?", "Вопрос.", JOptionPane.YES_NO_OPTION) == 0) 
        {
            int r = IODocumentF.reSendDocumentF((int)jTable1.getValueAt(h, 0));
            switch(r)
            {
                case -1:
                    JOptionPane.showMessageDialog(null, "Документ удален.");
                    break;
                case -2:
                    JOptionPane.showMessageDialog(null, "Документ уже открыт.");    
                    break;
                case -3:
                    JOptionPane.showMessageDialog(null, "В документе нет строк.");        
                    break;                                    
                default:
                    model.setData(d1, d2);
            }            
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        int h = jTable1.getSelectedRow();
        if(h==-1)
            return;        
        if (JOptionPane.showConfirmDialog(null, "Вы действительно хотите принять документ №<" + jTable1.getValueAt(h, 2) + ">?", "Вопрос.", JOptionPane.YES_NO_OPTION) == 0) 
        {
            int r = IODocumentF.closeDocumentF((int)jTable1.getValueAt(h, 0));
            switch(r)
            {
                case -1:
                    JOptionPane.showMessageDialog(null, "Документ удален.");
                    break;
                case -2:
                    JOptionPane.showMessageDialog(null, "Документ уже принят.");    
                    break;
                case -3:
                    JOptionPane.showMessageDialog(null, "В документе нет строк.");        
                    break;                
                default:
                    model.setData(d1, d2);
            }            
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        int h = jTable1.getSelectedRow();
        if(h==-1)
            return;        
        if (JOptionPane.showConfirmDialog(null, "Вы действительно хотите вернуть документ №<" + jTable1.getValueAt(h, 2) + ">?", "Вопрос.", JOptionPane.YES_NO_OPTION) == 0) 
        {
            int r = IODocumentF.openDocumentF((int)jTable1.getValueAt(h, 0));
            switch(r)
            {
                case -1:
                    JOptionPane.showMessageDialog(null, "Документ удален.");
                    break;
                case -2:
                    JOptionPane.showMessageDialog(null, "Документ уже открыт.");    
                    break;
                case -3:
                    JOptionPane.showMessageDialog(null, "В документе нет строк.");        
                    break;                                    
                default:
                    model.setData(d1, d2);
            }            
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    // подсветка и картинки в таблицу                       
    final ImageIcon edit = new ImageIcon(getClass().getResource("/org/example/images/1.png"));
    final ImageIcon ok = new ImageIcon(getClass().getResource("/org/example/images/2.png"));
    final ImageIcon bac = new ImageIcon(getClass().getResource("/org/example/images/go.png"));

    private final DefaultTableCellRenderer jTableRenderer = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            JLabel cell = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (column == 1) {
                switch (Integer.parseInt(cell.getText())) {
                    case 0:
                        cell.setIcon(edit);
                        cell.setText("");
                        break;
                    case 1:
                        cell.setIcon(bac);
                        cell.setText("");
                        break;
                    case 2:
                        cell.setIcon(ok);
                        cell.setText("");
                        break;    
                    
                }
            }
            return cell;
        }

    };
    
    /*private final DefaultTableCellRenderer jTableRenderer1 = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            JLabel cell = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            cell.setHorizontalAlignment(JLabel.RIGHT);
            return cell;
        }

    };*/
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
