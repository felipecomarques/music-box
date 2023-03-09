/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfacegrafica;

import banco.BaixoDAO;
import banco.GuitarraDAO;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import produtos.Baixo;
import produtos.Guitarra;

/**
 *
 * @author felip
 */
public class Estoque extends javax.swing.JFrame {

    /**
     * Creates new form Estoque
     */
    public Estoque() {
        initComponents();
        this.setLocationRelativeTo(null);

        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelo);
        jTable1.setRowSorter(sorter);

        DefaultTableModel modelo2 = (DefaultTableModel) jTable2.getModel();
        TableRowSorter<DefaultTableModel> sorter2 = new TableRowSorter<>(modelo2);
        jTable2.setRowSorter(sorter2);

        jTable1.getColumn("id").setMinWidth(0);
        jTable1.getColumn("id").setMaxWidth(0);

        jTable2.getColumn("id").setMinWidth(0);
        jTable2.getColumn("id").setMaxWidth(0);

        //TextPrompt TP1 = new TextPrompt("Digite aqui para pesquisar", jTextField1);
        LerJTable();
    }

    private void LerJTable() {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        DefaultTableModel modelo2 = (DefaultTableModel) jTable2.getModel();

        modelo.setNumRows(0);
        modelo2.setNumRows(0);

        GuitarraDAO guiDAO = new GuitarraDAO();
        for (Guitarra g : guiDAO.encontrar(null)) {
            modelo.addRow(new Object[]{
                g.getID(),
                g.getMarca(),
                g.getModelo(),
                g.getEstadoUso(),
                g.getMadeiraCorpo(),
                g.getMadeiraBraco(),
                g.getCaptacao(),
                g.getTipocorpo(),
                g.getRaio(),
                g.getEstoque(),
                g.getPreco(),});
        }

        BaixoDAO bassDAO = new BaixoDAO();
        for (Baixo b : bassDAO.encontrar(null)) {
            modelo2.addRow(new Object[]{
                b.getID(),
                b.getMarca(),
                b.getModelo(),
                b.getEstadoUso(),
                b.getMadeiraCorpo(),
                b.getMadeiraBraco(),
                b.getCaptacao(),
                b.getNumCordas(),
                b.getPassiovoativo(),
                b.getEstoque(),
                b.getPreco(),});
        }
    }

    private void AtualizarTabelaConstante(JFrame x) {
        Thread t = new Thread(() -> {
            while (x.isVisible()) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    LerJTable();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Estoque.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        t.start();
    }

    public void PesquisarGuitarras() {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setNumRows(0);
        GuitarraDAO guiDAO = new GuitarraDAO();
        for (Guitarra guita : guiDAO.encontrar(jTextField1.getText())) {
            modelo.addRow(new Object[]{
                guita.getID(),
                guita.getMarca(),
                guita.getModelo(),
                guita.getEstadoUso(),
                guita.getMadeiraCorpo(),
                guita.getMadeiraBraco(),
                guita.getCaptacao(),
                guita.getTipocorpo(),
                guita.getRaio(),
                guita.getEstoque(),
                guita.getPreco()
            });
        }
    }

    //PesquisarDisco//
    public void PesquisarBaixo() {
        DefaultTableModel modelo2 = (DefaultTableModel) jTable2.getModel();
        modelo2.setNumRows(0);
        BaixoDAO bassDAO = new BaixoDAO();
        for (Baixo bass : bassDAO.encontrar(jTextField1.getText())) {
            modelo2.addRow(new Object[]{
                bass.getID(),
                bass.getMarca(),
                bass.getModelo(),
                bass.getEstadoUso(),
                bass.getMadeiraCorpo(),
                bass.getMadeiraBraco(),
                bass.getCaptacao(),
                bass.getNumCordas(),
                bass.getPassiovoativo(),
                bass.getEstoque(),
                bass.getPreco()
            });
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MusicBox");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Marca", "Modelo", "Uso", "Corpo", "Braço", "Captação", "Tipo de corpo", "Raio", "Estoque", "Preço"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jTabbedPane1.addTab("Guitarras", jScrollPane1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Marca", "Modelo", "Uso", "Corpo", "Braço", "Captação", "Cordas", "Passivo/Ativo", "Estoque", "Preço"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jTabbedPane1.addTab("Baixos", jScrollPane2);

        jButton1.setText("Voltar");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setText("Editar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton2.setText("Cadastrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton4)
                    .addComponent(jButton2)))
        );

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Sistema MusicBox");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(237, 237, 237)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jButton6.setText("Vender");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Menu MP = new Menu();
        MP.setVisible(true);
        dispose();
        AtualizarTabelaConstante(this);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jTextField1.setText(null);
        CadastroEscolha CE = new CadastroEscolha();
        CE.setVisible(true);
        AtualizarTabelaConstante(CE);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jTextField1.setText(null);
        if (jTable1.getSelectedRow() != -1 && jTabbedPane1.getSelectedIndex() == 0) {
            if (jTable1.getSelectedRowCount() > 1) {
                JOptionPane.showMessageDialog(null, "Não pode editar mais de um item!");
            } else {
                Guitarra g = new Guitarra();
                Editar ED;
                // marca, modelo, uso, madeiracorpo, madeiraBraco, captacao, tipocorpo, raio, estoque, preco
                int id = (int) jTable1.getValueAt(jTable1.getSelectedRow(), 0);
                String marca = (String) jTable1.getValueAt(jTable1.getSelectedRow(), 1);
                String modelo = (String) jTable1.getValueAt(jTable1.getSelectedRow(), 2);
                String uso = (String) jTable1.getValueAt(jTable1.getSelectedRow(), 3);
                String madeiracorpo = (String) jTable1.getValueAt(jTable1.getSelectedRow(), 4);
                String madeiraBraco = (String) jTable1.getValueAt(jTable1.getSelectedRow(), 5);
                String captacao = (String) jTable1.getValueAt(jTable1.getSelectedRow(), 6);
                String tipocorpo = (String) jTable1.getValueAt(jTable1.getSelectedRow(), 7);
                double raio = (double) jTable1.getValueAt(jTable1.getSelectedRow(), 8);
                int estoque = (int) jTable1.getValueAt(jTable1.getSelectedRow(), 9);
                double preco = (double) jTable1.getValueAt(jTable1.getSelectedRow(), 10);
                ED = new Editar(id, marca, modelo, uso, madeiracorpo, madeiraBraco, captacao, raio, tipocorpo, estoque, preco);
                ED.setVisible(true);
                AtualizarTabelaConstante(ED);
            }
        } else if (jTable2.getSelectedRow() != -1 && jTabbedPane1.getSelectedIndex() == 1) {
            if (jTable2.getSelectedRowCount() > 1) {
                JOptionPane.showMessageDialog(null, "Não pode editar mais de um item!");
            } else {
                Baixo b = new Baixo();
                Editar ED;
                int id = (int) jTable2.getValueAt(jTable2.getSelectedRow(), 0);
                String marca = (String) jTable2.getValueAt(jTable2.getSelectedRow(), 1);
                String modelo = (String) jTable2.getValueAt(jTable2.getSelectedRow(), 2);
                String uso = (String) jTable2.getValueAt(jTable2.getSelectedRow(), 3);
                String madeiracorpo = (String) jTable2.getValueAt(jTable2.getSelectedRow(), 4);
                String madeiraBraco = (String) jTable2.getValueAt(jTable2.getSelectedRow(), 5);
                String captacao = (String) jTable2.getValueAt(jTable2.getSelectedRow(), 6);
                int numcordas = (int) jTable2.getValueAt(jTable2.getSelectedRow(), 7);
                String passivoativo = (String) jTable2.getValueAt(jTable2.getSelectedRow(), 8);
                int estoque = (int) jTable2.getValueAt(jTable2.getSelectedRow(), 9);
                double preco = (double) jTable2.getValueAt(jTable2.getSelectedRow(), 10);
                ED = new Editar(id, marca, modelo, uso, madeiracorpo, madeiraBraco, captacao, numcordas, passivoativo, estoque, preco);
                ED.setVisible(true);
                AtualizarTabelaConstante(ED);
            }
        } else {
            JOptionPane.showMessageDialog(null, "É necessário selecionar algum item nas tabelas!");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        jTextField1.setText(null);
        if (jTable1.getSelectedRow() != -1 && jTabbedPane1.getSelectedIndex() == 0) {
            if (jTable1.getSelectedRowCount() > 1) {
                JOptionPane.showMessageDialog(null, "Não pode editar mais de um item!");
            } else {
                Guitarra g = new Guitarra();
                Vender VE;
                // marca, modelo, uso, madeiracorpo, madeiraBraco, captacao, tipocorpo, raio, estoque, preco
                int id = (int) jTable1.getValueAt(jTable1.getSelectedRow(), 0);
                String marca = (String) jTable1.getValueAt(jTable1.getSelectedRow(), 1);
                String modelo = (String) jTable1.getValueAt(jTable1.getSelectedRow(), 2);
                int estoque = (int) jTable1.getValueAt(jTable1.getSelectedRow(), 9);
                double preco = (double) jTable1.getValueAt(jTable1.getSelectedRow(), 10);
                VE = new Vender(id, marca, modelo, estoque, preco, true);
                VE.setVisible(true);
                AtualizarTabelaConstante(VE);
            }
        } else if (jTable2.getSelectedRow() != -1 && jTabbedPane1.getSelectedIndex() == 1) {
            if (jTable2.getSelectedRowCount() > 1) {
                JOptionPane.showMessageDialog(null, "Não pode editar mais de um item!");
            } else {
                Baixo b = new Baixo();
                Vender VE;
                int id = (int) jTable2.getValueAt(jTable2.getSelectedRow(), 0);
                String marca = (String) jTable2.getValueAt(jTable2.getSelectedRow(), 1);
                String modelo = (String) jTable2.getValueAt(jTable2.getSelectedRow(), 2);
                int estoque = (int) jTable2.getValueAt(jTable2.getSelectedRow(), 9);
                double preco = (double) jTable2.getValueAt(jTable2.getSelectedRow(), 10);
                VE = new Vender(id, marca, modelo, estoque, preco, false);
                VE.setVisible(true);
                AtualizarTabelaConstante(VE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "É necessário selecionar algum item nas tabelas!");
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        if (jTabbedPane1.getSelectedIndex() == 0) {
            PesquisarGuitarras();
        } else {
            PesquisarBaixo();
        }
    }//GEN-LAST:event_jTextField1KeyTyped

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Estoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Estoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Estoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Estoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Estoque().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
