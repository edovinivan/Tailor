/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Arbait;

import org.example.Gui.Arbait.Model.ModelZadacha;
import org.example.Gui.Form.Helps.FGetDate;
import org.example.Gui.THaupt;
import java.awt.Component;
import java.awt.event.KeyEvent;
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
import org.example.logic.Zadacha;
import org.example.util.IOOperator;
import org.example.util.IOZadacha;

/**
 *
 * @author ivan
 */
public class LZadachaNastils extends javax.swing.JPanel {

    /**
     * Creates new form LZadachaNastils
     * @param th1
     * @param hd - ручной стол
     */
    public LZadachaNastils(THaupt th1, int hd) {
        initComponents();
        hand = hd;
        th = th1;        
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, 10);
        d2 = c.getTime();
        c.add(Calendar.DAY_OF_MONTH, -90);
        d1 = c.getTime();
        jButton7.setVisible(false);
        jButton8.setVisible(false);
        jLabel1.setText("");
    }
    
    THaupt th;
    ModelZadacha model = new ModelZadacha(2);
    Date d1, d2;
    TableRowSorter<TableModel> sorter;
    int hand;

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
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
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

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/cascade.png"))); // NOI18N
        jButton6.setText("Настилы");
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
        jButton7.setText("Отработать");
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

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/refresh.png"))); // NOI18N
        jButton9.setText("Обновить");
        jButton9.setFocusable(false);
        jButton9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton9);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/images/filter.png"))); // NOI18N
        jButton2.setText("Фильтр");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jCheckBox1.setText("Закрытые");
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
       
        int h = (jTable1.getWidth()-310)/4;
        
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
        
        jTable1.getColumnModel().getColumn(10).setPreferredWidth(0);
        jTable1.getColumnModel().getColumn(10).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(10).setMinWidth(0);
        
    }//GEN-LAST:event_jTable1ComponentResized

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        if(IOOperator.getSetupOperator(29)>1)
        {
            jButton7.setVisible(true);
            jButton8.setVisible(true);
        }
        model.setDataForCreateNastils(d1, d2, hand, jCheckBox1.isSelected());
        jTable1.setModel(model);
        jTable1.setShowGrid(true);                    
        jTable1.getTableHeader().setReorderingAllowed(false);   
        jTable1.getColumnModel().getColumn(1).setCellRenderer(jTableRenderer);
        jTable1ComponentResized(null);
        sorter = new TableRowSorter<TableModel>(model);        
        jTable1.setRowSorter(sorter);
    }//GEN-LAST:event_formComponentShown

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        int h = jTable1.getSelectedRow();
        if(h==-1)
            return;
        LZadachaNastil lz = new LZadachaNastil(null, true, (int)jTable1.getValueAt(h, 0));
        lz.setSize(getWidth()-50, getHeight()+150);
        lz.setVisible(true);
        //model.setDataForCreateNastils(d1, d2, hand, jCheckBox1.isSelected());
        //jTable1.setRowSelectionInterval(h, h);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        FGetDate fg = new FGetDate(null, true, d1, d2);
        fg.setVisible(true);
        if(fg.getResult())
        {
            d1 = fg.getDate1();
            d2 = fg.getDate2();
            model.setDataForCreateNastils(d1, d2, hand, jCheckBox1.isSelected());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        int h = jTable1.getSelectedRow();
        if(h==-1)
            return;
        //h = (int) jTable1.getValueAt(h, 0);
        if (JOptionPane.showConfirmDialog(null, "Вы действительно сформировали все настилы для задания <" + jTable1.getValueAt(jTable1.getSelectedRow(), 2) + "> как ?", "Вопрос.", JOptionPane.YES_NO_OPTION) == 0) 
        {
            Zadacha zz = IOZadacha.getListZadacha((int)jTable1.getValueAt(h, 0), 0).get(0);
            
            if(zz.getStatus()>2)
            {
                JOptionPane.showMessageDialog(null, "Задание уже утверждено!");
                return;
            }
            
            if(zz.getStatus()<2)
            {
                JOptionPane.showMessageDialog(null, "Задание еще в стадии редактирования!");
                return;
            }
            
            // проверим все или нет закрыты настилы
            int r =IOZadacha.getCloseZadacha((int)jTable1.getValueAt(h, 0));
            if(r<0)
            {
                if(r==-1)
                {
                    JOptionPane.showMessageDialog(null, "В заданий есть не отработанные настилы!");
                    return;
                }
                
                if(r==-2)
                {
                    JOptionPane.showMessageDialog(null, "В заданий есть не отработанные полотна!");
                    return;
                }
            } 
                        
            if(IOZadacha.setNewStatusZadacha((int)jTable1.getValueAt(jTable1.getSelectedRow(), 0), 3))
            {
                model.setDataForCreateNastils(d1, d2, hand, jCheckBox1.isSelected());
                jTable1.setRowSelectionInterval(h, h);
            }
            else
                JOptionPane.showMessageDialog(null, "Ошибка закрытия");
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        int h = jTable1.getSelectedRow();
        if(h==-1)
            return;
        //h = (int) jTable1.getValueAt(h, 0);
        if (JOptionPane.showConfirmDialog(null, "Вы действительно хотите открыть задание <" + jTable1.getValueAt(jTable1.getSelectedRow(), 2) + "> для формирования настилов?", "Вопрос.", JOptionPane.YES_NO_OPTION) == 0) 
        {
            Zadacha zz = IOZadacha.getListZadacha((int)jTable1.getValueAt(h, 0), 0).get(0);
            
            if(zz.getStatus()>3)
            {
                JOptionPane.showMessageDialog(null, "Нельзя открыть задание!");
                return;
            }
            
            if(zz.getStatus()<=2)
            {
                //JOptionPane.showMessageDialog(null, "Задание еще в стадии редактирования!");
                return;
            }
            
            // посмотрим все или нет закрыты принты и вышивки
            //List<ZadachaPrintDetali> ls = IOZadachaPrintDetali.getListZadachaPrintDetaliForZadacha(zz.getZadacha());
            // Изменим статус на закрытый
            //for(ZadachaPrintDetali z: ls)               
            //    IOZadachaPrintDetali.updateStatusPD(z.getZadachaprintdetali(), 1);
                
            if(IOZadacha.setOldStatusZadacha((int)jTable1.getValueAt(jTable1.getSelectedRow(), 0), 2))
            {
                model.setDataForCreateNastils(d1, d2, hand, jCheckBox1.isSelected());
                jTable1.setRowSelectionInterval(h, h);
            }
            else
                JOptionPane.showMessageDialog(null, "Ошибка открытия");
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        model.setDataForCreateNastils(d1, d2, hand, jCheckBox1.isSelected());
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        th.closeTabPage();
    }//GEN-LAST:event_jButton1ActionPerformed

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
    
    // подсветка и картинки в таблицу                       
    final ImageIcon edit = new ImageIcon(getClass().getResource("/org/example/images/1.png"));
    final ImageIcon ok1 = new ImageIcon(getClass().getResource("/org/example/images/2.png"));    
    final ImageIcon ok3 = new ImageIcon(getClass().getResource("/org/example/images/clos.png"));
    public DefaultTableCellRenderer jTableRenderer = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            JLabel cell = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            
            int v = Integer.parseInt(cell.getText());
                if (column == 1) {
                    switch (v) {
                        case 2:
                            cell.setIcon(edit);
                            cell.setText("");                            
                            break;
                        case 3:
                            cell.setIcon(ok1);
                            cell.setText("");
                            break;
                        default:
                            cell.setIcon(ok3);
                            cell.setText("");
                            break;
                    }
                }
            return cell;
        }

    };

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
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
