/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Arbait;

import org.example.Gui.Arbait.Model.ModelZadacha;
import org.example.Gui.Form.Report.LReport;
import org.example.Gui.THaupt;
import java.awt.Component;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.example.logic.Zadacha;
import org.example.util.IOOperator;
import org.example.util.IOSetup;
import org.example.util.IOZadacha;
import org.example.util.IOZadachaKomplektovka;
import org.example.util.IOZadachaNastil;

/**
 *
 * @author ivan
 */
public class LZadachaMaterial extends javax.swing.JPanel {

    /**
     * Creates new form LZadachaMaterial
     * @param th1
     */
    public LZadachaMaterial(THaupt th1) {
        initComponents();
        th = th1;
        jButton3.setVisible(false);
        jButton4.setVisible(false);
        jLabel1.setText("");
    }
    
    THaupt th;
    ModelZadacha model = new ModelZadacha(1);
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
        jButton6 = new javax.swing.JButton();
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

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        jButton2.setText("Изменить");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/2.png"))); // NOI18N
        jButton3.setText("Утвердить");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1.png"))); // NOI18N
        jButton4.setText("Открыть");
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

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/print.png"))); // NOI18N
        jButton6.setText("Печать");
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton6);

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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    boolean fl = true;
    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        if(fl)
        {
            if (IOOperator.getSetupOperator(17) > 1) {
                jButton3.setVisible(true);
                jButton4.setVisible(true);
            }
            model.setDataForGetMaterial();
            jTable1.setModel(model);
            jTable1.setShowGrid(true);
            jTable1.getTableHeader().setReorderingAllowed(false);
            jTable1.getColumnModel().getColumn(1).setCellRenderer(jTableRenderer);
            jTable1.getColumnModel().getColumn(10).setCellRenderer(model.jTableRendererHand);
            jTable1ComponentResized(null);
            sorter = new TableRowSorter<TableModel>(model);
            jTable1.setRowSorter(sorter);
            fl = false;
        }
    }//GEN-LAST:event_formComponentShown

    // подсветка и картинки в таблицу                       
    final ImageIcon edit = new ImageIcon(getClass().getResource("/images/1.png"));
    final ImageIcon ok1 = new ImageIcon(getClass().getResource("/images/2.png"));
    final ImageIcon ok2 = new ImageIcon(getClass().getResource("/images/up.png"));
    final ImageIcon ok3 = new ImageIcon(getClass().getResource("/images/cascade.png"));
    final ImageIcon ok10 = new ImageIcon(getClass().getResource("/images/clos.png"));
    public DefaultTableCellRenderer jTableRenderer = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            JLabel cell = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            //if (vid == 1) {
            int v = Integer.parseInt(cell.getText());
                if (column == 1) {
                    switch (v) {
                        case 0:
                            cell.setIcon(edit);
                            cell.setText("");
                            break;
                        case 1:
                            cell.setIcon(edit);
                            cell.setText("");
                            break;
                        case 2:
                            cell.setIcon(ok1);
                            cell.setText("");
                            break;
                        case 3:
                            cell.setIcon(ok3);
                            cell.setText("");
                            break;
                        case 10:
                            cell.setIcon(ok10);
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
        int h = (jTable1.getWidth()-340)/4;
        
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
        
        jTable1.getColumnModel().getColumn(10).setPreferredWidth(30);  
        
        jTable1.getColumnModel().getColumn(9).setPreferredWidth(0);
        jTable1.getColumnModel().getColumn(9).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(9).setMinWidth(0);
    }//GEN-LAST:event_jTable1ComponentResized

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        th.closeTabPage();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * Изменить
     * @param evt 
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int h = jTable1.getSelectedRow();
        if(h==-1)
            return;
        Zadacha zz = IOZadacha.getListZadacha((int)jTable1.getValueAt(h, 0), 0).get(0);
        if(zz.getStatus()==0)
        {
            JOptionPane.showMessageDialog(null, "Задание еще в стадии редактирования! Нельзя набирать товар!");
            return;
        }            
        
        FGetProductForZadachaIzSclad fg = new FGetProductForZadachaIzSclad(null, true, (int)jTable1.getValueAt(h, 0), 1);
        fg.setSize(getWidth()-50, getHeight());
        fg.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * Отработать
     * @param evt 
     */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int h = jTable1.getSelectedRow();
        if(h==-1)
            return;
        //h = (int) jTable1.getValueAt(h, 0);
        if (JOptionPane.showConfirmDialog(null, "Вы действительно хотите утвердить задание <" + jTable1.getValueAt(jTable1.getSelectedRow(), 2) + "> на набранный товар?", "Вопрос.", JOptionPane.YES_NO_OPTION) == 0) 
        {
            Zadacha zz = IOZadacha.getListZadacha((int)jTable1.getValueAt(h, 0), 0).get(0);
            
            if(zz.getStatus()>1)
            {
                JOptionPane.showMessageDialog(null, "Задание уже утверждено!");
                return;
            }
            
            if(zz.getStatus()==0)
            {
                JOptionPane.showMessageDialog(null, "Задание еще в стадии редактирования!");
                return;
            }
            
            if(IOZadacha.getListZadachaScladProductForZadacha((int)jTable1.getValueAt(jTable1.getSelectedRow(), 0)).isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Полотна не набраны!!");
                return;
            }
            
            
            // временно отключим
            // проверим есть или нет в данной задаче полотна которые не проверили
            if(IOSetup.getSetuValInt(4)==1)
            {
                if (!IOZadacha.checkProductForListDocument((int) jTable1.getValueAt(jTable1.getSelectedRow(), 0))) 
                {
                    JOptionPane.showMessageDialog(null, "В задаче набраны полотна, которые пришли вместе с полотнами которые еще не проверены!!!");
                    return;
                }
            }
            
                
            if(IOZadacha.setNewStatusZadacha((int)jTable1.getValueAt(jTable1.getSelectedRow(), 0), 2))
            {
                IOZadacha.updateNetMForZadacha((int)jTable1.getValueAt(jTable1.getSelectedRow(), 0), 0);
                model.setDataForGetMaterial();
                jTable1.setRowSelectionInterval(h, h);
            }
            else
                JOptionPane.showMessageDialog(null, "Ошибка утверждения");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int h = jTable1.getSelectedRow();
        if(h==-1)
            return;
        //h = (int) jTable1.getValueAt(h, 0);
        if (JOptionPane.showConfirmDialog(null, "Вы действительно хотите открыть задание <" + jTable1.getValueAt(jTable1.getSelectedRow(), 2) + "> для набора товаров?", "Вопрос.", JOptionPane.YES_NO_OPTION) == 0) 
        {
            
            Zadacha zz = IOZadacha.getListZadacha((int)jTable1.getValueAt(h, 0), 0).get(0);
            if(IOZadachaNastil.getListZadachaNastil(zz.getZadacha(), -1).size()>0)
            //if(zz.getStatus()>2)
            {
                JOptionPane.showMessageDialog(null, "По заданию сформированны настилы! Нельзя открыть задание!");
                return;
            }
            
            // проверим комплектовки
            if(!IOZadachaKomplektovka.getListZadachaKomplektovka(zz.getZadacha(), -1).isEmpty())
            {
                JOptionPane.showMessageDialog(null, "По заданию сформированны комплектовки! Нельзя открыть задание!");
                return;
            }
            
            if(zz.getStatus()<=1)
            {
                //JOptionPane.showMessageDialog(null, "Задание еще в стадии редактирования!");
                return;
            }
                
            if(IOZadacha.setOldStatusZadacha((int)jTable1.getValueAt(jTable1.getSelectedRow(), 0), 1))
            {
                model.setDataForGetMaterial();
                jTable1.setRowSelectionInterval(h, h);
            }
            else
                JOptionPane.showMessageDialog(null, "Ошибка открытия");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        model.setDataForGetMaterial();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        if(jTable1.getSelectedRow()==-1) return;
        LReport lr = new LReport(null, true, 8,(int)jTable1.getValueAt(jTable1.getSelectedRow(), 0));
        lr.setVisible(true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
