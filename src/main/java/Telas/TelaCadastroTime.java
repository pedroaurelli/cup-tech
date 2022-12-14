/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Telas;

import DAO.TimeDAO;
import Model.Time;
import javax.swing.JOptionPane;

/**
 *
 * @author zpeed
 */
public class TelaCadastroTime extends javax.swing.JFrame {

  /**
   * Creates new form Tela_CadastroTime
   */
  public TelaCadastroTime () {
    initComponents();
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
    inputNomeTime = new javax.swing.JTextField();
    btnCadastrar = new javax.swing.JButton();
    btnVoltar = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Cup-Tech");
    setBackground(new java.awt.Color(147, 157, 186));

    jPanel1.setBackground(new java.awt.Color(204, 204, 204));

    inputNomeTime.setBorder(javax.swing.BorderFactory.createTitledBorder("Nome do time"));
    inputNomeTime.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        inputNomeTimeActionPerformed(evt);
      }
    });

    btnCadastrar.setText("Cadastrar");
    btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnCadastrarActionPerformed(evt);
      }
    });

    btnVoltar.setText("Voltar");
    btnVoltar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnVoltarActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(27, 27, 27)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(btnCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
          .addComponent(inputNomeTime, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
          .addComponent(btnVoltar))
        .addContainerGap(31, Short.MAX_VALUE))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(16, 16, 16)
        .addComponent(btnVoltar)
        .addGap(33, 33, 33)
        .addComponent(inputNomeTime, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(81, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(23, 23, 23)
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(25, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(20, 20, 20)
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(38, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void inputNomeTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNomeTimeActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_inputNomeTimeActionPerformed

  private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
    // TODO add your handling code here:
    String time = inputNomeTime.getText();
    String sigla = time.substring(0, 3).toUpperCase();
    
    try {
      Time novoTime = new Time (time, sigla, 0);
      TimeDAO timeDao = new TimeDAO();
      
      boolean isCheio = timeDao.estaCheio();
              
      timeDao.listar().size();
      
      if (isCheio) {
        timeDao.cadastrar(novoTime);
        JOptionPane.showMessageDialog(null, "Time cadastrado com sucesso!");
        this.dispose();
      } else {
        JOptionPane.showMessageDialog(null, "Limite de cadastro");
        this.dispose();
      }
              
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
    }
  }//GEN-LAST:event_btnCadastrarActionPerformed

  private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
    // TODO add your handling code here:
    this.dispose();
  }//GEN-LAST:event_btnVoltarActionPerformed

  /**
   * @param args the command line arguments
   */
  public static void main (String args[]) {
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
    }
    catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(TelaCadastroTime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(TelaCadastroTime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(TelaCadastroTime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(TelaCadastroTime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run () {
        new TelaCadastroTime().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnCadastrar;
  private javax.swing.JButton btnVoltar;
  private javax.swing.JTextField inputNomeTime;
  private javax.swing.JPanel jPanel1;
  // End of variables declaration//GEN-END:variables
}
