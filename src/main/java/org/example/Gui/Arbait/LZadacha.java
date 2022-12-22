/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Arbait;


import org.example.Gui.Arbait.Model.ModelZadacha1;
import org.example.Gui.Form.Helps.FGetDate;
import org.example.Gui.Form.Report.LReport;
import org.example.Gui.THaupt;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.example.logic.Zadacha;
import org.example.util.IOOperator;
import org.example.util.IOZLog;
import org.example.util.IOZadacha;
import org.example.util.IOZadachaDopSP;

/**
 *
 * @author ivan
 */
public class LZadacha extends javax.swing.JPanel {

    /**
     * Creates new form LZadacha
     * @param th1
     * @param stat
     */
    public LZadacha(THaupt th1, int stat) {
        initComponents();
        th = th1;
        status = stat;
        //jButton8.setVisible(false);
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, 10);
        d2 = c.getTime();
        c.add(Calendar.DAY_OF_MONTH, -90);
        d1 = c.getTime();
        jButton2.setVisible(false);
        jButton4.setVisible(false);
        jButton6.setVisible(false);
        jButton7.setVisible(false);   
        jLabel1.setText("");
    }

    int status;
    THaupt th;
    Date d1, d2;
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
        jButton5 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
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

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/filter.png"))); // NOI18N
        jButton9.setText("Фильтр");
        jButton9.setFocusable(false);
        jButton9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton9);

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

        jLabel1.setText("jLabel1");
        jToolBar1.add(jLabel1);

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

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
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 737, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Закрыть
     * @param evt 
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        th.closeTabPage();
    }//GEN-LAST:event_jButton1ActionPerformed

    ModelZadacha1 model = new ModelZadacha1(0);
    /**
     * Добавить
     * @param evt 
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:        
        FZadacha fz = new FZadacha(null, true, 0, new Dimension(getWidth()-50, getHeight()-50));
        fz.setVisible(true);
        model.setData(d1, d2, -1);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTable1ComponentResized
        // TODO add your handling code here:
        if(jTable1.getColumnCount()<=0)
            return;
        int h = (jTable1.getWidth()-370)/4;
        
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(0);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(0).setMinWidth(0);
        
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(h);  
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(30);  
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(h);  
        
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(h);  
        
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(120);  
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(80);  
        jTable1.getColumnModel().getColumn(7).setPreferredWidth(80);  
        jTable1.getColumnModel().getColumn(8).setPreferredWidth(h);  
        
        jTable1.getColumnModel().getColumn(9).setPreferredWidth(0);
        jTable1.getColumnModel().getColumn(9).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(9).setMinWidth(0);
        
        jTable1.getColumnModel().getColumn(10).setPreferredWidth(30);  
        jTable1.getColumnModel().getColumn(11).setPreferredWidth(30);  
        
    }//GEN-LAST:event_jTable1ComponentResized

    boolean fv = true;
    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:     
        if(fv)
        {
            if (IOOperator.getSetupOperator(16) > 1) 
            {
                jButton2.setVisible(true);
                jButton4.setVisible(true);
                jButton6.setVisible(true);
                jButton7.setVisible(true);
            }
            model.setData(d1, d2, -1);
            jTable1.setModel(model);
            jTable1.setShowGrid(true);
            jTable1.getTableHeader().setReorderingAllowed(false);
            jTable1.getColumnModel().getColumn(1).setCellRenderer(model.jTableRenderer);
            jTable1.getColumnModel().getColumn(10).setCellRenderer(model.jTableRendererHand);
            jTable1.getColumnModel().getColumn(11).setCellRenderer(model.jTableRendererPh);
            jTable1ComponentResized(null);
            sorter = new TableRowSorter<TableModel>(model);        
            jTable1.setRowSorter(sorter);
            jTable1.requestFocusInWindow();
            fv = false;
        }
    }//GEN-LAST:event_formComponentShown

    /**
     * изменить
     * @param evt 
     */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int h = jTable1.getSelectedRow();
        if(jTable1.getSelectedRow() == -1) return;
        FZadacha fz = new FZadacha(null, true, (int)jTable1.getValueAt(jTable1.getSelectedRow(), 0) , new Dimension(getWidth()-50, getHeight()-50));
        fz.setVisible(true);
        model.setData(d1, d2, -1);
        jTable1.setRowSelectionInterval(h, h);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount() == 2)
            jButton3ActionPerformed(null);
    }//GEN-LAST:event_jTable1MouseClicked

    /**
     * обновить 
     * @param evt 
     */
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        model.setData(d1, d2, -1);
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * удалить
     * @param evt 
     */
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int h = jTable1.getSelectedRow();
        if(h==-1)
            return;
        h = (int) jTable1.getValueAt(h, 0);
        if (JOptionPane.showConfirmDialog(null, "Вы действительно хотите удалить задание <" + jTable1.getValueAt(jTable1.getSelectedRow(), 2) + ">?", "Вопрос.", JOptionPane.YES_NO_OPTION) == 0) 
        {
            if(!IOZadachaDopSP.getListZadachaDopScladProduct(h).isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Ошибка удаления! У задачи есть дополнительные материалы. Удалите их.");
                return;
            }
            if(IOZadacha.getListZadacha(h, 0).get(0).getStatus()!=0)
            {
                JOptionPane.showMessageDialog(null, "Данную задачу нельзя удалить. Она уже утверждена!");
                return;
            }
            IOZLog.setZLog(h, 0, 1, "Удалили задачу");
            if(IOZadacha.delZadacha(h))
                model.setData(d1, d2, -1);
            else
                JOptionPane.showMessageDialog(null, "Ошибка удаления");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * Провести
     * @param evt 
     */
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        int h = jTable1.getSelectedRow();
        if(h==-1)
            return;
        //h = (int) jTable1.getValueAt(h, 0);
        if (JOptionPane.showConfirmDialog(null, "Вы действительно хотите утвердить задание <" + jTable1.getValueAt(jTable1.getSelectedRow(), 2) + ">?", "Вопрос.", JOptionPane.YES_NO_OPTION) == 0) 
        {
            
            Zadacha zz = IOZadacha.getListZadacha((int)jTable1.getValueAt(h, 0), 0).get(0);
            
            if(zz.getCountsall()==0)
            {
                JOptionPane.showMessageDialog(null, "У задания нет размеров!");
                return;
            }
            
            if(zz.getStatus()>0)
            {
                JOptionPane.showMessageDialog(null, "Задание уже утверждено!");
                return;
            }
            
            IOZLog.setZLog(zz.getZadacha(), 0, 1, "Утвердили задачу");
            
            if(IOZadacha.setNewStatusZadacha((int)jTable1.getValueAt(jTable1.getSelectedRow(), 0), 1))
            {
                model.setData(d1, d2, -1);
                jTable1.setRowSelectionInterval(h, h);
            }
            else
                JOptionPane.showMessageDialog(null, "Ошибка утверждения");
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    /**
     * Открыть
     * @param evt 
     */
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        int h = jTable1.getSelectedRow();
        if(h==-1)
            return;
        //h = (int) jTable1.getValueAt(h, 0);
        if (JOptionPane.showConfirmDialog(null, "Вы действительно хотите отменить задание <" + jTable1.getValueAt(jTable1.getSelectedRow(), 2) + ">?", "Вопрос.", JOptionPane.YES_NO_OPTION) == 0) 
        {
            Zadacha zz = IOZadacha.getListZadacha((int)jTable1.getValueAt(h, 0), 0).get(0);
            if(zz.getStatus()>1)
            {
                JOptionPane.showMessageDialog(null, "Задание нельзя отменить. Сначало отмените набор материала.");
                return;
            }
            // проверим на набор товара
            if(!IOZadacha.getListZadachaScladProductForZadacha((int)jTable1.getValueAt(h, 0)).isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Задание нельзя отменить. У задачи набран товар!");
                return;
            }
            
            
            IOZLog.setZLog(zz.getZadacha() , 0, 1, "Открыли задачу");
            
            if(IOZadacha.setOldStatusZadacha((int)jTable1.getValueAt(jTable1.getSelectedRow(), 0), 0))
            {
                model.setData(d1, d2, -1);
                jTable1.setRowSelectionInterval(h, h);
            }
            else
                JOptionPane.showMessageDialog(null, "Ошибка отмены");
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        if(jTable1.getSelectedRow()==-1) return;
        LReport lr = new LReport(null, true, 2,(int)jTable1.getValueAt(jTable1.getSelectedRow(), 0));
        lr.setVisible(true);
        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        FGetDate fg = new FGetDate(null, true, d1, d2);
        fg.setVisible(true);
        if(fg.getResult())
        {
            d1 = fg.getDate1();
            d2 = fg.getDate2();
            model.setData(d1, d2, -1);
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
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
    }//GEN-LAST:event_jTable1KeyReleased

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        // TODO add your handling code here:
        jLabel1.setText("");
        setFilter();
    }//GEN-LAST:event_jScrollPane1MouseClicked

    
    private void setFilter()
    {
        sorter.setRowFilter(RowFilter.regexFilter("(?iu)"+jLabel1.getText(), 3));
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
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
