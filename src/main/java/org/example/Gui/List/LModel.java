/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.List;

import org.example.Gui.Form.FModel;
import org.example.Gui.Form.FModelParameter;
import org.example.Gui.Form.LModelOperation;
import org.example.Gui.Form.ModelTextSite;
import org.example.Gui.Form.Report.LReport;
import org.example.Gui.THaupt;
import org.example.Gui.model.model.ModelModel1;
import java.awt.Component;
import java.awt.event.KeyEvent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.example.logic.Model;
import org.example.util.IOModel;
import org.example.util.IOOperator;

/**
 *
 * @author ivan
 */
public class LModel extends javax.swing.JPanel {

    /**
     * Creates new form LModel
     * @param th1
     */
    public LModel(THaupt th1) {
        initComponents();
        th = th1;
  
        jLabel1.setText("");        
        
        jButton2.setVisible(false);                
                //jButton3.setVisible(false);                
                jButton4.setVisible(false);                
                //jButton5.setVisible(false);                
                jButton7.setVisible(false);                
                jButton8.setVisible(false);                
                jButton9.setVisible(false);                
                jButton10.setVisible(false);                
                jButton11.setVisible(false);                
                jButton12.setVisible(false);                
                jButton13.setVisible(false);                
                jButton14.setVisible(false);                
                jButton18.setVisible(false);                
               // jButton16.setVisible(false); 
        
        
    }
    

    ModelModel1 model = new ModelModel1();
    THaupt th;
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
        jButton10 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jButton9 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
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

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/go.png"))); // NOI18N
        jButton10.setText("Копировать");
        jButton10.setFocusable(false);
        jButton10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton10.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton10);

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

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/basket.png"))); // NOI18N
        jButton13.setText("Внести изменения");
        jButton13.setFocusable(false);
        jButton13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton13.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton13);

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

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/print.png"))); // NOI18N
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

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/2.png"))); // NOI18N
        jButton7.setText("Утвердить");
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
        jButton8.setText("Открыть");
        jButton8.setFocusable(false);
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton8);
        jToolBar1.add(jSeparator1);

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/configure.png"))); // NOI18N
        jButton9.setText("Операции");
        jButton9.setFocusable(false);
        jButton9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton9);

        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/compose.png"))); // NOI18N
        jButton15.setText("Описание");
        jButton15.setFocusable(false);
        jButton15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton15.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton15);

        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/Filled.png"))); // NOI18N
        jButton16.setText("Параметры");
        jButton16.setFocusable(false);
        jButton16.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton16.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton16);

        jCheckBox1.setText("Старые");
        jCheckBox1.setFocusable(false);
        jCheckBox1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jCheckBox1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jCheckBox1);

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/down.png"))); // NOI18N
        jButton11.setText("В файл");
        jButton11.setFocusable(false);
        jButton11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton11.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton11);

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/up.png"))); // NOI18N
        jButton12.setText("Из файла");
        jButton12.setFocusable(false);
        jButton12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton12.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton12);

        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/house.png"))); // NOI18N
        jButton14.setText("Все");
        jButton14.setToolTipText("Сбросить фильтр");
        jButton14.setFocusable(false);
        jButton14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton14.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton14);

        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/Pen.png"))); // NOI18N
        jButton17.setText("Комментарии");
        jButton17.setFocusable(false);
        jButton17.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton17.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton17);

        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/Hand.png"))); // NOI18N
        jButton18.setText("Артикул");
        jButton18.setToolTipText("Внести изменения в главый артикул");
        jButton18.setFocusable(false);
        jButton18.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton18.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton18);

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
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1096, Short.MAX_VALUE)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 1096, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE))
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
        int h = (jTable1.getWidth()-210)/4;
        
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(0);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(0).setMinWidth(0);
        
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(30);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(50);        
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(h);        
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(h);        
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(h);        
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(h);        
        jTable1.getColumnModel().getColumn(7).setPreferredWidth(30);        
        jTable1.getColumnModel().getColumn(8).setPreferredWidth(100);        
        
        jTable1.getColumnModel().getColumn(9).setPreferredWidth(0);
        jTable1.getColumnModel().getColumn(9).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(9).setMinWidth(0);
        
    }//GEN-LAST:event_jTable1ComponentResized

    boolean f = true;
    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        //System.out.println("1="+IOOperator.getSetupOperator(1));
        if (f) 
        {
            jLabel1.setText("");
            jButton9.setVisible(false);
            // если операции кк разрешены
            if (IOOperator.getSetupOperator(15) > 0) {
                jButton9.setVisible(true);
            }

            //System.out.println("1="+IOOperator.getSetupOperator(1));
            
            // если разрешено редактирокание кк
            if (IOOperator.getSetupOperator(1) > 1) {
                jButton10.setVisible(true);
                jButton2.setVisible(true);
                jButton4.setVisible(true);
                jButton7.setVisible(true);
                jButton8.setVisible(true);
                jButton13.setVisible(true);
                jButton18.setVisible(true);
            }
            
            // комментарий и печать
            if (IOOperator.getSetupOperator(68) > 0) 
            {
                jButton6.setVisible(true);
                jButton17.setVisible(true);                
            }
            
            jButton4.setVisible(IOOperator.operator.getOperator()==1);                

            //model.setData(-1, jCheckBox1.isSelected());
            model.setData(jCheckBox1.isSelected());
            jTable1.setModel(model);

            sorter = new TableRowSorter<TableModel>(model);
            jTable1.setRowSorter(sorter);

            jTable1.getColumnModel().getColumn(1).setCellRenderer(model.jTableRenderer);
            jTable1.getColumnModel().getColumn(7).setCellRenderer(model.jTableRenderer1);
            jTable1.getColumnModel().getColumn(3).setCellRenderer(jTableRenderer);
            jTable1.setShowGrid(true);
            jTable1.getTableHeader().setReorderingAllowed(false);
            jTable1ComponentResized(null);
            jTable1.requestFocusInWindow();
            f = false;
        }
        //FModel fm = new FModel(null, true, 3, getWidth(), getHeight());
        //fm.setVisible(true);
        
    }//GEN-LAST:event_formComponentShown

    
    public DefaultTableCellRenderer jTableRenderer = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            JLabel cell = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            cell.setToolTipText((String) jTable1.getValueAt(row, 9));
            return cell;
        }

    };
    
    
    /**
     * Добавить
     * @param evt 
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        FModel fm = new FModel(null, true, 0, getWidth(), getHeight());
        fm.setVisible(true);
        //model.setData(-1,jCheckBox1.isSelected());
        model.setData(jCheckBox1.isSelected());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int h = jTable1.getSelectedRow();
        if(h==-1) return;
        FModel fm = new FModel(null, true, (int)jTable1.getValueAt(h, 0), getWidth(), getHeight());
        fm.setVisible(true);
        //model.setData(-1,jCheckBox1.isSelected());        
        model.setData(jCheckBox1.isSelected());
        jTable1.setRowSelectionInterval(h, h);
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==2)
            jButton3ActionPerformed(null);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int h = jTable1.getSelectedRow();
        if(h==-1)
            return;
        h = (int) jTable1.getValueAt(h, 0);
        //if (JOptionPane.showConfirmDialog(null, "Вы действительно хотите удалить конфекционную карту <" + jTable1.getValueAt(jTable1.getSelectedRow(), 5)+ ">  " + jTable1.getValueAt(jTable1.getSelectedRow(), 2) + "?", "Вопрос.", JOptionPane.YES_NO_OPTION) == 0) 
        if (JOptionPane.showConfirmDialog(null, "Вы действительно хотите удалить конфекционную карту <" + jTable1.getValueAt(jTable1.getSelectedRow(), 6)+ ">  " + jTable1.getValueAt(jTable1.getSelectedRow(), 3) + "?", "Вопрос.", JOptionPane.YES_NO_OPTION) == 0) 
        {
            if(IOModel.getListModel(h, 0, true).get(0).getStatus()>=1)
            {
                JOptionPane.showMessageDialog(null, "Данная конфекционаая карта закрыта для редактирования. Её нельзя удалить!");
                return;
            }
            if(IOModel.delModel(h))
               // model.setData(-1,jCheckBox1.isSelected());
                model.setData(jCheckBox1.isSelected());
            else
                JOptionPane.showMessageDialog(null, "Ошибка удаления");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        //model.setData(-1,jCheckBox1.isSelected());
        model.setData(jCheckBox1.isSelected());
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * отчеты
     * @param evt 
     */
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        if(jTable1.getSelectedRow()==-1) return;
        LReport lr = new LReport(null, true, 1,(int)jTable1.getValueAt(jTable1.getSelectedRow(), 0));
        lr.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        int h = jTable1.getSelectedRow();
        if(h==-1)
            return;
        h = (int) jTable1.getValueAt(h, 0);
        //if (JOptionPane.showConfirmDialog(null, "Вы действительно хотите закрыть для редактирования конфекционную карту  <" + jTable1.getValueAt(jTable1.getSelectedRow(), 5)+ ">  " + jTable1.getValueAt(jTable1.getSelectedRow(), 2) + "?", "Вопрос.", JOptionPane.YES_NO_OPTION) == 0) 
        if (JOptionPane.showConfirmDialog(null, "Вы действительно хотите закрыть для редактирования конфекционную карту  <" + jTable1.getValueAt(jTable1.getSelectedRow(), 6)+ ">  " + jTable1.getValueAt(jTable1.getSelectedRow(), 3) + "?", "Вопрос.", JOptionPane.YES_NO_OPTION) == 0) 
        {
            if(IOModel.updateStatusModel(h, 1))
                //model.setData(-1,jCheckBox1.isSelected());
                model.setData(jCheckBox1.isSelected());
            else
                JOptionPane.showMessageDialog(null, "Ошибка изменения статуса");
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        int h = jTable1.getSelectedRow();
        if(h==-1)
            return;
        h = (int) jTable1.getValueAt(h, 0);
        //if (JOptionPane.showConfirmDialog(null, "Вы действительно хотите открыть для редактирования <" + jTable1.getValueAt(jTable1.getSelectedRow(), 5)+ ">  " + jTable1.getValueAt(jTable1.getSelectedRow(), 2) + "?", "Вопрос.", JOptionPane.YES_NO_OPTION) == 0) 
        if (JOptionPane.showConfirmDialog(null, "Вы действительно хотите открыть для редактирования <" + jTable1.getValueAt(jTable1.getSelectedRow(), 6)+ ">  " + jTable1.getValueAt(jTable1.getSelectedRow(), 3) + "?", "Вопрос.", JOptionPane.YES_NO_OPTION) == 0) 
        {
            if(IOModel.getTrueModelInZadacha(h))
            {
                JOptionPane.showMessageDialog(null, "Данная конфекционная карта уже используется в заданиях. Её нельзя открыть для редактирование!");
                return;
            }
            if(IOModel.updateStatusModel(h, 0))
                //model.setData(-1,jCheckBox1.isSelected());
                model.setData(jCheckBox1.isSelected());
            else
                JOptionPane.showMessageDialog(null, "Ошибка изменения статуса");
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        int h = jTable1.getSelectedRow();
        if(h==-1)
            return;
        h = (int) jTable1.getValueAt(h, 0);
        if(IOModel.getListModel(h, 0, true).get(0).getStatus()==0)
        {
            JOptionPane.showMessageDialog(null, "Конфекционная карта еще не утверждена!");
            return;
        }
        /*if(IOModel.getListModel(h, 0).get(0).getStatus()==2)
        {
            JOptionPane.showMessageDialog(null, "Конфекционная карта уже закрыта!");
            return;
        }*/
        LModelOperation lm = new LModelOperation(null, true, h);
        lm.setVisible(true);
        h = jTable1.getSelectedRow();
        //model.setData(-1,jCheckBox1.isSelected());
        model.setData(jCheckBox1.isSelected());
        jTable1.setRowSelectionInterval(h, h);
        
        
    }//GEN-LAST:event_jButton9ActionPerformed

    /**
     * Копировать модель
     * @param evt 
     */
    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        int h = jTable1.getSelectedRow();
        if(h==-1)
            return;
        
        if (JOptionPane.showConfirmDialog(null, "Вы действительно хотите скопировать <" + jTable1.getValueAt(jTable1.getSelectedRow(), 6)+ ">  " + jTable1.getValueAt(jTable1.getSelectedRow(), 3) + "?", "Вопрос.", JOptionPane.YES_NO_OPTION) == 0) 
        {
            h = IOModel.copyModel((int)jTable1.getValueAt(h, 0));
            FModel fm = new FModel(null, true, h, getWidth(), getHeight());
            fm.setVisible(true);
            //model.setData(-1,jCheckBox1.isSelected());            
            model.setData(jCheckBox1.isSelected());
        }
        
        
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        int h = jTable1.getSelectedRow();
        if(h==-1)
            return;
        //if (JOptionPane.showConfirmDialog(null, "Вы действительно хотите сохранить <" + jTable1.getValueAt(jTable1.getSelectedRow(), 5) + ">  " + jTable1.getValueAt(jTable1.getSelectedRow(), 2) + "?", "Вопрос.", JOptionPane.YES_NO_OPTION) == 0) 
        if (JOptionPane.showConfirmDialog(null, "Вы действительно хотите сохранить <" + jTable1.getValueAt(jTable1.getSelectedRow(), 6) + ">  " + jTable1.getValueAt(jTable1.getSelectedRow(), 3) + "?", "Вопрос.", JOptionPane.YES_NO_OPTION) == 0) 
        {
            JFileChooser jf = new JFileChooser();
            if (jf.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) 
            {
                h = (int)jTable1.getValueAt(h, 0);
                IOModel.saveModelInFile(h, jf.getSelectedFile().getAbsolutePath());
            }

        }
    }//GEN-LAST:event_jButton11ActionPerformed

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

    //внести изменения
    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        int h = jTable1.getSelectedRow();
        if(h==-1)
            return;
        Model mm = IOModel.getListModel((int)jTable1.getValueAt(h, 0), 0, true).get(0);
        if(mm.getStatus()<1)
        {
            JOptionPane.showMessageDialog(null, "Конфекционная карта еще не закрыта.");
            return;
        }
        
        if(mm.getStatus()>2)
        {
            JOptionPane.showMessageDialog(null, "Конфекционная карта неактивна.");
            return;
        }
        
        if(!IOModel.getTrueModelInZadacha(mm.getModel()))
        {
            JOptionPane.showMessageDialog(null, "Данная конфекционная карта не используется в заданиях. Её можно открыть для редактирования!");
            return;
        }
        
        if (JOptionPane.showConfirmDialog(null, "Вы действительно хотите изменить <" + jTable1.getValueAt(jTable1.getSelectedRow(), 6)+ ">  " + jTable1.getValueAt(jTable1.getSelectedRow(), 3) + "?", "Вопрос.", JOptionPane.YES_NO_OPTION) == 0) 
        {
            
            h = IOModel.copyModel1((int)jTable1.getValueAt(h, 0));
            FModel fm = new FModel(null, true, h, getWidth(), getHeight());
            fm.setVisible(true);
            //model.setData(-1,jCheckBox1.isSelected());            
            model.setData(jCheckBox1.isSelected());
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        jLabel1.setText("");                
        setFilter();
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        int h = jTable1.getSelectedRow();
        if(h==-1)
            return;
        ModelTextSite ms = new ModelTextSite(null, true, (int)jTable1.getValueAt(h, 0));
        ms.setVisible(true);
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
        int h = jTable1.getSelectedRow();
        if(h==-1)
            return;
        FModelParameter fp = new FModelParameter(null, true,(int)jTable1.getValueAt(h, 0));
        fp.setVisible(true);
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
        int h = jTable1.getSelectedRow();
        if(h==-1) return;
        LMModelComment fm = new LMModelComment(null, true, (int)jTable1.getValueAt(h, 0));
        fm.setVisible(true);
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        // TODO add your handling code here:
        jTable1.requestFocusInWindow();
    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
        int h = jTable1.getSelectedRow();
        if(h==-1)
            return;
        Model mods = IOModel.getModel((int)jTable1.getValueAt(h, 0));
        String newHArticle = JOptionPane.showInputDialog("Введите главный артикул", mods.getHarticle());
        if(!newHArticle.equals(mods.getHarticle())){
            if(!IOModel.updateHArticleForModel(mods.getModel(), newHArticle)){
                JOptionPane.showMessageDialog(null, "Ошибка изменения главного артикула!");
            } else{
                model.setData(jCheckBox1.isSelected());
            }
        }
    }//GEN-LAST:event_jButton18ActionPerformed

    
    private void setFilter()
    {
        sorter.setRowFilter(RowFilter.regexFilter("(?iu)"+jLabel1.getText(), 3));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
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
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
