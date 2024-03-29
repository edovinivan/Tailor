/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Arbait;

import org.example.Gui.Arbait.Model.ModelAllNastil;
import org.example.Gui.THaupt;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import static javax.swing.SwingConstants.RIGHT;
import javax.swing.table.DefaultTableCellRenderer;
import org.example.util.HelpClass;
import org.example.util.IOOperator;
import org.example.util.IOZadachaNastil;

/**
 *
 * @author ivan
 * Список настилов в которых есть возвращаемые полотна
 * 
 */
public class LAllNastilForReturn extends javax.swing.JPanel {

    /**
     * Creates new form LAllNastilForReturn
     * @param th1
     */
    public LAllNastilForReturn(THaupt th1) {
        initComponents();
        th  =th1;
        jButton3.setVisible(false);
    }
    
    THaupt th;
    ModelAllNastil model = new ModelAllNastil();

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

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/bac.png"))); // NOI18N
        jButton2.setText("Возвраты");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/2.png"))); // NOI18N
        jButton3.setText("Отработать");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

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
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        th.closeTabPage();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int h = jTable1.getSelectedRow();
        if(h==-1) return;
        FReturn fr = new FReturn(null, true, (int)jTable1.getValueAt(h, 0));
        fr.setVisible(true);
        model.setData(2,2, -1);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTable1ComponentResized
        // TODO add your handling code here:
        if(jTable1.getColumnCount()<=0)
            return;
        int h = (jTable1.getWidth()-380)/4;
        
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(0);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(0).setMinWidth(0);
        
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(30);  
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(h);  
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(h);  
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(h);  
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(60);        
        
        
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(0);
        jTable1.getColumnModel().getColumn(6).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(6).setMinWidth(0);
        
        jTable1.getColumnModel().getColumn(7).setPreferredWidth(0);
        jTable1.getColumnModel().getColumn(7).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(7).setMinWidth(0);
        
        jTable1.getColumnModel().getColumn(8).setPreferredWidth(0);
        jTable1.getColumnModel().getColumn(8).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(8).setMinWidth(0);
        
        jTable1.getColumnModel().getColumn(9).setPreferredWidth(80);        
        jTable1.getColumnModel().getColumn(10).setPreferredWidth(80);        
        jTable1.getColumnModel().getColumn(11).setPreferredWidth(h);        
        jTable1.getColumnModel().getColumn(12).setPreferredWidth(100);        
        jTable1.getColumnModel().getColumn(13).setPreferredWidth(30);        
    }//GEN-LAST:event_jTable1ComponentResized

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        if(IOOperator.getSetupOperator(20)==2)
        {
            jButton3.setVisible(true);
        }
        model.setData(2,2, -1);
        jTable1.setModel(model);
        jTable1.setShowGrid(true);                    
        jTable1.getTableHeader().setReorderingAllowed(false);   
        jTable1.getColumnModel().getColumn(1).setCellRenderer(jTableRenderer);
        jTable1.getColumnModel().getColumn(9).setCellRenderer(jTableRenderer1);
        jTable1.getColumnModel().getColumn(10).setCellRenderer(jTableRenderer1);
        jTable1.getColumnModel().getColumn(13).setCellRenderer(jTableRenderer3);
        jTable1.getColumnModel().getColumn(5).setCellRenderer(HelpClass.jTableRendererColumnRight);
        jTable1ComponentResized(null);
    }//GEN-LAST:event_formComponentShown

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int h = jTable1.getSelectedRow();
        if(h==-1) return;
        if (JOptionPane.showConfirmDialog(null, "Вы действительно хотите утвердить возврат полотна из настила <" + jTable1.getValueAt(jTable1.getSelectedRow(), 3) + ">?", "Вопрос.", JOptionPane.YES_NO_OPTION) == 0) {
            /*if (!IOZadachaNastil.executeNastilForQty((int)jTable1.getValueAt(h, 0))) {
                JOptionPane.showMessageDialog(null, "Общий вес настила не соответствует сумме итоговых весов!");                
                return;
            }
            if(1==1)
            {
                JOptionPane.showMessageDialog(null, "Ок!");                
              return;
            }*/
            
            if (!IOZadachaNastil.executeNastilForQtyReturn((int)jTable1.getValueAt(h, 0))) {
                JOptionPane.showMessageDialog(null, "Общий вес возвращаемых полотен не соответствует введенному весу для возврата!");                
                return;
            }
                       
            
            int r = IOZadachaNastil.setStatusOkForNastil((int)jTable1.getValueAt(h, 0), 3);
            if(r==0)
                model.setData(2,2, -1);
            else
                JOptionPane.showMessageDialog(null, "Ошибка утверждения. ");
        }   
    }//GEN-LAST:event_jButton3ActionPerformed

    // подсветка и картинки в таблицу                       
    final ImageIcon edit = new ImageIcon(getClass().getResource("/org/example/images/1.png"));
    final ImageIcon ok1 = new ImageIcon(getClass().getResource("/org/example/images/2.png"));
    //final ImageIcon ok3 = new ImageIcon(getClass().getResource("/org/example/images/clos.png"));
    
    private DefaultTableCellRenderer jTableRenderer = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            JLabel cell = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (column == 1) {
                int v = Integer.parseInt(cell.getText());
                switch (v) {
                    case 2:
                        cell.setIcon(edit);
                        cell.setText("");
                        break;
                    case 3:
                    case 4:
                        cell.setIcon(ok1);
                        cell.setText("");
                        break;
                }
            }
            return cell;
        }

    };
    
    // подсветка и картинки в таблицу                       
    final ImageIcon hand = new ImageIcon(getClass().getResource("/org/example/images/Hand.png"));
    
    
    private DefaultTableCellRenderer jTableRenderer3 = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            JLabel cell = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);            
            int v = Integer.parseInt(cell.getText());
            cell.setIcon(null);
            cell.setText("");
            if(v==1)
                cell.setIcon(hand);            
            return cell;
        }

    };
    
    
    private DefaultTableCellRenderer jTableRenderer1 = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            JLabel cell = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            cell.setHorizontalAlignment(RIGHT);
            return cell;
        }

    };
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
