/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_Chess;

import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Roberto
 */
public class NewPlayer extends javax.swing.JFrame {
   
    public String u, p;    
    public Jugador newPlayer;
    
    
    public NewPlayer(){
        initComponents();        
    }
               
   public void goToMainMenu(){
        new MainMenu().setVisible(true);
        this.dispose();
    }
    
    public void goToMenu(){
        new Menu().setVisible(true);
        this.dispose();
    }
        
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Alert = new javax.swing.JDialog();
        jLabel2 = new javax.swing.JLabel();
        btnokay = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtnewuser = new javax.swing.JTextField();
        btnCreaJugador = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtnewpassword = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        Alert.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Alert.setMinimumSize(new java.awt.Dimension(150, 110));
        Alert.setPreferredSize(new java.awt.Dimension(275, 100));
        Alert.setSize(new java.awt.Dimension(275, 100));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("Contraseña Invalida!");

        btnokay.setText("Okay");
        btnokay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnokayActionPerformed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/P2_Chess/assets/alert2.png"))); // NOI18N

        javax.swing.GroupLayout AlertLayout = new javax.swing.GroupLayout(Alert.getContentPane());
        Alert.getContentPane().setLayout(AlertLayout);
        AlertLayout.setHorizontalGroup(
            AlertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AlertLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGroup(AlertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AlertLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2))
                    .addGroup(AlertLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(btnokay)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        AlertLayout.setVerticalGroup(
            AlertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AlertLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AlertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AlertLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnokay, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtnewuser.setMinimumSize(new java.awt.Dimension(6, 23));
        txtnewuser.setPreferredSize(new java.awt.Dimension(6, 23));
        txtnewuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnewuserActionPerformed(evt);
            }
        });

        btnCreaJugador.setText("Crear");
        btnCreaJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreaJugadorActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Nuevo Jugador");

        txtnewpassword.setPreferredSize(new java.awt.Dimension(6, 23));
        txtnewpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnewpasswordActionPerformed(evt);
            }
        });
        txtnewpassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnewpasswordKeyPressed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Usuario");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Contraseña");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtnewuser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtnewpassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(150, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addGap(50, 50, 50)
                .addComponent(btnCreaJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtnewuser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtnewpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnCreaJugador))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtnewuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnewuserActionPerformed

    }//GEN-LAST:event_txtnewuserActionPerformed

    private void btnCreaJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreaJugadorActionPerformed
   
        u = txtnewuser.getText();
        p = txtnewpassword.getText();
        
        try{
            if(Data.playerExist(u)){
                if(Data.passwordValid(p)){        
                    newPlayer = Data.createPlayer(u, p);
                    Data.fileWritter(newPlayer);
                    goToMainMenu();
                }
                else{
                    Alert.setVisible(true);                
                    btnokay.remove(Alert);
                }
            }
            
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    
    }//GEN-LAST:event_btnCreaJugadorActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        goToMenu();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtnewpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnewpasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnewpasswordActionPerformed

    private void btnokayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnokayActionPerformed
       Alert.dispose();
    }//GEN-LAST:event_btnokayActionPerformed

    private void txtnewpasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnewpasswordKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            btnCreaJugadorActionPerformed(null);
        }
    }//GEN-LAST:event_txtnewpasswordKeyPressed

    
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
            java.util.logging.Logger.getLogger(NewPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run(){
                    new NewPlayer().setVisible(true);                    
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog Alert;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCreaJugador;
    private javax.swing.JButton btnokay;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField txtnewpassword;
    private javax.swing.JTextField txtnewuser;
    // End of variables declaration//GEN-END:variables
}
