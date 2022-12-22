/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Form.Helps;

import org.example.Gui.model.ModelColor;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author ivan
 */
public class FGetColor extends javax.swing.JDialog {

    /**
     * Creates new form FGetColor
     * @param parent
     * @param modal
     * @param s
     * @param vid
     */
    public FGetColor(java.awt.Frame parent, boolean modal, int s, int vid) {
        super(parent, modal);
        initComponents();
        createWindow(s, vid);
        model.setData();
    }

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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Выбор цвета");

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel.png"))); // NOI18N
        jButton1.setText("Отмена");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton1);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/2.png"))); // NOI18N
        jButton2.setText("Выбрать");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton2);

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
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
                if(String.valueOf(evt.getKeyChar()).matches("[A-Za-zА-Яа-я0-9/-]"))                
                {
                    jLabel1.setText(jLabel1.getText()+evt.getKeyChar());
                    setFilter();                    
                }                 
        }
    }//GEN-LAST:event_jTable1KeyPressed

    private void setFilter()
    {
        sorter.setRowFilter(RowFilter.regexFilter("(?iu)"+jLabel1.getText(), 1));
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FGetColor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FGetColor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FGetColor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FGetColor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                FGetColor dialog = new FGetColor(new javax.swing.JFrame(), true, 0, 0);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables

    boolean result = false;
    int result_id;
    ModelColor model;// = new ModelColor();
    TableRowSorter<TableModel> sorter;
    /**
     * Результат диалога
     * @return 
     */
    public boolean getResult()
    {
        return result;
    }
    /**
     * ид результата
     * @return 
     */
    public int getResultValue()
    {
        return result_id;
    }
    
    private void widthTable()
    {
        if(jTable1.getColumnCount()<=0)
            return;
        int h = jTable1.getWidth();
        
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(0);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(0).setMinWidth(0);        
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(h); 
    }
    
    /**
     * Построение окна
     * @param s 
     */
    private void createWindow(int s, int vid)
    {
        jLabel1.setText("");
        model = new ModelColor(vid);
        result_id = s;
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowOpened(java.awt.event.WindowEvent evt) {
                openWindows();
            }
        });
        
        jTable1.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent evt) {
                widthTable();
            }
        });
        
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setVisible(false);
            }
        });
        
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getClickOk();
            }
        });
        
    }
    
    private void openWindows()
    {
        setLocationRelativeTo(null);
        
        jTable1.setModel(model);
        jTable1.setShowGrid(true);                    
        jTable1.getTableHeader().setReorderingAllowed(false);   
        widthTable();
        sorter = new TableRowSorter<TableModel>(model);        
        jTable1.setRowSorter(sorter);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }

            private void jTable1MouseClicked(MouseEvent evt) {
                if(evt.getClickCount() == 2)
                    getClickOk();
            }
        });
        if(result_id>0)
        {
            for(int i =0;i<jTable1.getRowCount();i++)
            {
                if((int)jTable1.getValueAt(i, 0) == result_id)
                {
                    jTable1.changeSelection(i, 0, false, false);
                    break;
                }
            }
        }
    }
    
    private void getClickOk()
    {
        int h = jTable1.getSelectedRow();
        if(h==-1) return;
        result_id = (int)jTable1.getValueAt(h, 0);
        result = true;
        setVisible(false);
    }
    
    /**
     * Цвета для выбора в комплектовке
     * @param k
     */
    public void colorForKomplektovka(int k)
    {
        model.colorForKomplektovka(k);
    }
}
