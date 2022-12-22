/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Analit;

import org.example.Gui.FOT.FParamReportPrintRabotnik;
import org.example.Gui.Form.Helps.FGetDate;
import org.example.Gui.Form.Helps.FGetModel;
import org.example.Gui.THaupt;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.example.logic.ModelProduct;
import org.example.logic.plan.PModelPlan;
import org.example.logic.plan.PModelPlanProduct;
import org.example.util.HelpClass;
import org.example.util.IOModel;
import org.example.util.plan.IOModelPlan;

/**
 *
 * @author ivan
 */
public class LModelPlan extends javax.swing.JPanel {

    /**
     * Creates new form LModelPlan
     * @param th1
     */
    public LModelPlan(THaupt th1) {
        initComponents();
        th = th1;
        Calendar c = Calendar.getInstance();        
        d1 = c.getTime();
        c.add(Calendar.DAY_OF_MONTH, +60);
        d2 = c.getTime();
        jLabel1.setText("");    
        jButton2.setVisible(false);
        jButton6.setVisible(false);
    }

    
    Date d1, d2;
    THaupt th;
    ModelModelPlan  model = new ModelModelPlan();
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
        jButton8 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
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

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/filter.png"))); // NOI18N
        jButton8.setText("Фильтр");
        jButton8.setFocusable(false);
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton8);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/magn.png"))); // NOI18N
        jButton6.setText("Просмотр");
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton6);

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/redo.png"))); // NOI18N
        jButton9.setText("Артикул");
        jButton9.setToolTipText("Изменить артикул задачи");
        jButton9.setFocusable(false);
        jButton9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton9);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/basket.png"))); // NOI18N
        jButton7.setText("Загруженность");
        jButton7.setFocusable(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton7);

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/print.png"))); // NOI18N
        jButton10.setText("Печать");
        jButton10.setFocusable(false);
        jButton10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton10.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton10);

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Hand.png"))); // NOI18N
        jButton11.setText("Проверка");
        jButton11.setFocusable(false);
        jButton11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton11.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton11);

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
            .addComponent(jScrollPane1)
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
        FModelPlan m = new FModelPlan(null, true, 0);
        m.setVisible(true);
        model.setData(d1, d2);
    }//GEN-LAST:event_jButton2ActionPerformed

    
        // подсветка и картинки в таблицу                       
    final ImageIcon edit1 = new ImageIcon(getClass().getResource("/images/1.png"));
    final ImageIcon ok1= new ImageIcon(getClass().getResource("/images/2.png"));
    final ImageIcon clos1 = new ImageIcon(getClass().getResource("/images/clos.png"));
    final ImageIcon block1 = new ImageIcon(getClass().getResource("/images/block.png"));
    final ImageIcon pen1 = new ImageIcon(getClass().getResource("/images/Pen.png"));

    public final DefaultTableCellRenderer jTableRenderer = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            JLabel cell = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            
            if (column == 11) {
                cell.setToolTipText(String.valueOf((Integer)jTable1.getValueAt(row, 12)));
                switch (Integer.parseInt(cell.getText())) {
                    case 0:
                        cell.setIcon(edit1);
                        cell.setText("");
                        
                        break;
                    case 1:
                        cell.setIcon(ok1);
                        cell.setText("");
                        break;
                    case 2:
                        cell.setIcon(clos1);
                        cell.setText("");
                        break;    
                    case 3:
                        cell.setIcon(block1);
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
        int h = (jTable1.getWidth()-570)/2;
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(0);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(0).setMinWidth(0);
        
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(50);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(30);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(h);
        jTable1.getColumnModel().getColumn(7).setPreferredWidth(h);
        jTable1.getColumnModel().getColumn(8).setPreferredWidth(80);
        jTable1.getColumnModel().getColumn(9).setPreferredWidth(80);
        
        jTable1.getColumnModel().getColumn(10).setPreferredWidth(0);
        jTable1.getColumnModel().getColumn(10).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(10).setMinWidth(0);
        
        jTable1.getColumnModel().getColumn(11).setPreferredWidth(30);
        
        jTable1.getColumnModel().getColumn(12).setPreferredWidth(0);
        jTable1.getColumnModel().getColumn(12).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(12).setMinWidth(0);
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
            jTable1.getColumnModel().getColumn(2).setCellRenderer(jTableRendererImage);
            jTable1.getColumnModel().getColumn(8).setCellRenderer(HelpClass.jTableRendererColumnRight);
            jTable1.getColumnModel().getColumn(9).setCellRenderer(HelpClass.jTableRendererColumnRight);
            jTable1.getColumnModel().getColumn(11).setCellRenderer(jTableRenderer);
            sorter = new TableRowSorter<TableModel>(model);
            jTable1.setRowSorter(sorter);
            f = false;
            jTable1.requestFocusInWindow();
        }
    }//GEN-LAST:event_formComponentShown

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int h = jTable1.getSelectedRow();
        if(h==-1) return;
        FModelPlan m = new FModelPlan(null, true, (int)jTable1.getValueAt(h, 0));
        m.setVisible(true);
        model.setData(d1, d2);
        jTable1.setRowSelectionInterval(h, h);
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        model.setData(d1, d2);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int h = jTable1.getSelectedRow();
        if(h==-1) return;
        if (JOptionPane.showConfirmDialog(null, "Вы действительно хотите удалить задачу?", "Вопрос.", JOptionPane.YES_NO_OPTION) == 0) 
        {
            int r = IOModelPlan.delPModelPlan((int)jTable1.getValueAt(h, 0));
            if(r==0)
                model.setData(d1, d2);
            if(r==-1)        
                JOptionPane.showMessageDialog(null, "Ошибка удаления! Задача отправленна на закупку.");
            if(r==-2)        
                JOptionPane.showMessageDialog(null, "Ошибка удаления! Задача отправленна на закупку.");            
            if(r==-3)        
                JOptionPane.showMessageDialog(null, "Ошибка удаления! Задача распределена в цех");            
        }
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        FModelPlanTimeTable f = new FModelPlanTimeTable(null, true, d1, d2);
        f.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        int h = jTable1.getSelectedRow();
        if(h==-1) return;
        FModelPlanTimeZagruzka ff = new FModelPlanTimeZagruzka(null, true, (int)jTable1.getValueAt(h, 0), (Date)jTable1.getValueAt(h, 3));
        ff.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        FGetDate fg = new FGetDate(null, true, d1, d2);
        fg.setVisible(true);
        if(fg.getResult())
        {
            d1 = fg.getDate1();
            d2 = fg.getDate2();
            model.setData(d1, d2);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

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

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        int h = jTable1.getSelectedRow();
        if(h==-1) return;
        if (JOptionPane.showConfirmDialog(null, "Вы действительно хотите заменить конфекционную карту?", "Вопрос.", JOptionPane.YES_NO_OPTION) == 0) 
        {
            PModelPlan pp = IOModelPlan.getPModelPlan((int)jTable1.getValueAt(h, 0));
            FGetModel fg= new FGetModel(null, true, pp.getModel().getModel());            
            fg.setSize(getWidth(), getHeight());
            fg.setVisible(true);
            if(fg.getResult())
            {            
                //IOModel.getListModel(fg.getResultValue(), -1, false).get(0);
                
                
                if(pp.getStatus()>1)
                {
                    JOptionPane.showMessageDialog(null, "Нельзя изменить артикул. Уже запланировали закупку полотна по данной задаче.");
                    return;
                }
                pp.setModel(IOModel.getListModel(fg.getResultValue(), -1, false).get(0));
                IOModelPlan.setPModelPlan(pp);
                
                //заменим товары для задачи
                //удалим все товары которые применяются для задачи
                IOModelPlan.delModelPlanProductForMP(pp.getPmodelplan());
                // сохраним товары которые нужны для заявки
                PModelPlanProduct p1;
                    for (ModelProduct m : IOModel.getListModelProduct(pp.getModel().getModel(), -1, 1)) 
                    {
                        p1 = new PModelPlanProduct();
                        p1.setModelproduct(m);
                        p1.setPmodelplan(pp);
                        p1.setPmodelplanproduct(0);
                        p1.setQty(BigDecimal.ZERO);
                        if (m.getTipproduct().getTipproduct() == 1) {
                            p1.setColor(pp.getColor());
                        } else {
                            p1.setColor(m.getColor());
                        }
                        p1.setProduct(m.getProduct());
                        IOModelPlan.setPModelPlanProduct(p1);
                    }
                
                model.setData(d1, d2);
                jTable1.setRowSelectionInterval(h, h);
            }
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        FParamReportPrintRabotnik f = new FParamReportPrintRabotnik(null, true, 31);
        f.setVisible(true);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        int h = jTable1.getSelectedRow();
        if(h==-1) return;
        PModelPlan pm = IOModelPlan.getPModelPlan((int)jTable1.getValueAt(h, 0));
        FGetDateMPlan1 fd = new FGetDateMPlan1(null, true);
        fd.setDataTemp1();
        fd.setDates(pm.getDates7(), pm.getDates8(), pm.getDates1(), pm.getDates(), pm.getDates5(), pm.getDates6());
        fd.setVisible(true);
        if(fd.getResult())
        {
             th.sendPrognoz2(pm.getModel().getModel(), fd.getDate1() , fd.getDate2(), fd.getDate3() , fd.getDate4(), fd.getDate5(), fd.getDate6(), fd.getYar(), pm.getPmodelplan());
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    
    private void setFilter()
    {
        sorter.setRowFilter(RowFilter.regexFilter("(?iu)"+jLabel1.getText(), 6));
    }
    
    
    // подсветка и картинки в таблицу                       
    final ImageIcon edit = new ImageIcon(getClass().getResource("/images/1.png"));
    final ImageIcon ok = new  ImageIcon(getClass().getResource("/images/2.png"));
    final ImageIcon clos= new ImageIcon(getClass().getResource("/images/clos.png"));

    private final DefaultTableCellRenderer jTableRendererImage = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            JLabel cell = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (column == 2) {
                switch (Integer.parseInt(cell.getText())) {
                    case 0:
                        cell.setIcon(edit);
                        cell.setText("");
                        break;
                    case 1:
                        cell.setIcon(ok);
                        cell.setText("");
                        break;
                    case 2:
                        cell.setIcon(clos);
                        cell.setText("");
                        break;    
                    
                }
            }
            return cell;
        }

    };
    

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
