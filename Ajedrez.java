/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_Chess;

import java.awt.Frame;
import java.awt.Window;
import javax.swing.JLayeredPane;



/**
 *
 * @author waldonavas
 */
public class Ajedrez extends javax.swing.JFrame
{

    /**
     * Creates new form Ajedrez
     */
    public static java.net.URL glow = Ajedrez.class.getResource("/P2_Chess/sprites/glow.png");
    public static java.net.URL selectedglow = Ajedrez.class.getResource("/P2_Chess/sprites/selectedglow.png");
    public static java.net.URL enemyglow = Ajedrez.class.getResource("/P2_Chess/sprites/enemyglow2.png");
    
    public Ajedrez()
    {
        initComponents();
        this.setLocationRelativeTo(null);
        jDialog2.setLocationRelativeTo(null);
        jDialog3.setLocationRelativeTo(null);
        
        Tablero.turn = 'w';
        turn.setText("Empiezan las Piezas\nBlancas");
        layers.setLayer(tablero, JLayeredPane.FRAME_CONTENT_LAYER);
        Tablero.spawnPieces();
        
    }
    
    static void finish()
    {
       for(Frame f : Ajedrez.getFrames())
       {
           f.setVisible(false);
       }
       for(Window f : Ajedrez.getWindows())
       {
           f.setVisible(false);
       }
       
       new MainMenu().setVisible(true);
    }
    
    public static void cleanGlows()
    {
        int j = layers.getComponentCountInLayer(JLayeredPane.MODAL_LAYER);
        //System.out.println(j);
        for (int i = 0; i < j; i++)
        {
            layers.remove(layers.getComponentsInLayer(JLayeredPane.MODAL_LAYER)[0]);  
        }
        
        int k = layers.getComponentCountInLayer(JLayeredPane.DRAG_LAYER);
        for (int i = 0; i < k; i++)
        {
            layers.remove(layers.getComponentsInLayer(JLayeredPane.DRAG_LAYER)[0]);  
        }
        layers.repaint();
    }
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jDialog2 = new javax.swing.JDialog();
        retiro = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jDialog3 = new javax.swing.JDialog();
        jButton4 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        layers = new javax.swing.JLayeredPane();
        tablero = new javax.swing.JLabel();
        turn = new javax.swing.JLabel();
        chickenOut = new javax.swing.JButton();
        save = new javax.swing.JButton();

        jDialog2.setMinimumSize(new java.awt.Dimension(400, 207));
        jDialog2.setPreferredSize(new java.awt.Dimension(400, 207));
        jDialog2.setResizable(false);
        jDialog2.setSize(new java.awt.Dimension(400, 207));
        jDialog2.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        retiro.setText("I 'Aint No Chik'n!");
        retiro.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                retiroActionPerformed(evt);
            }
        });
        jDialog2.getContentPane().add(retiro, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        jLabel2.setText("¿Seguro que desea Retirarse? ");
        jDialog2.getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, -1, -1));

        jButton3.setText("Chicken Out");
        jButton3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton3ActionPerformed(evt);
            }
        });
        jDialog2.getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, -1, -1));

        jLabel3.setText("Esto contará como una derrota.");
        jDialog2.getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, -1, -1));

        jDialog3.setMinimumSize(new java.awt.Dimension(209, 175));
        jDialog3.setPreferredSize(new java.awt.Dimension(209, 175));
        jDialog3.setResizable(false);
        jDialog3.setSize(new java.awt.Dimension(209, 175));
        jDialog3.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton4.setText("Ok");
        jButton4.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton4ActionPerformed(evt);
            }
        });
        jDialog3.getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, -1, -1));

        jLabel4.setText("Se ha salvado el Juego.");
        jDialog3.getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Ajedréz");
        setMinimumSize(new java.awt.Dimension(850, 650));
        setResizable(false);
        setSize(new java.awt.Dimension(850, 650));
        getContentPane().setLayout(null);

        layers.setPreferredSize(new java.awt.Dimension(620, 620));

        tablero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/P2_Chess/sprites/board.png"))); // NOI18N
        tablero.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                tableroMousePressed(evt);
            }
        });
        layers.add(tablero);
        tablero.setBounds(5, 5, 600, 600);

        getContentPane().add(layers);
        layers.setBounds(10, 10, 620, 620);

        turn.setText("Atacan las Piezas Blancas\n");
        getContentPane().add(turn);
        turn.setBounds(650, 30, 180, 150);

        chickenOut.setText("Retirarse");
        chickenOut.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                chickenOutActionPerformed(evt);
            }
        });
        getContentPane().add(chickenOut);
        chickenOut.setBounds(670, 290, 140, 29);

        save.setText("Salvar Juego");
        save.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                saveActionPerformed(evt);
            }
        });
        getContentPane().add(save);
        save.setBounds(670, 220, 140, 29);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableroMousePressed(java.awt.event.MouseEvent evt)//GEN-FIRST:event_tableroMousePressed
    {//GEN-HEADEREND:event_tableroMousePressed
        cleanGlows();
        Tablero.isMoving = false;
    }//GEN-LAST:event_tableroMousePressed

    private void chickenOutActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_chickenOutActionPerformed
    {//GEN-HEADEREND:event_chickenOutActionPerformed
        jDialog2.setVisible(true);
    }//GEN-LAST:event_chickenOutActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_saveActionPerformed
    {//GEN-HEADEREND:event_saveActionPerformed
        Tablero.saveGame();
        Tablero.wPlayer = null;
        Tablero.bPlayer = null;
        this.setVisible(false);
        jDialog3.setVisible(true);
        
    }//GEN-LAST:event_saveActionPerformed

    private void retiroActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_retiroActionPerformed
    {//GEN-HEADEREND:event_retiroActionPerformed
       jDialog2.setVisible(false);
    }//GEN-LAST:event_retiroActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton3ActionPerformed
    {//GEN-HEADEREND:event_jButton3ActionPerformed
        Tablero.retirar();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton4ActionPerformed
    {//GEN-HEADEREND:event_jButton4ActionPerformed
        jDialog3.setVisible(false);
        this.setVisible(false);
        this.dispose();
        new MainMenu().setVisible(true);
        
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(Ajedrez.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(Ajedrez.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(Ajedrez.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(Ajedrez.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new Ajedrez().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton chickenOut;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JDialog jDialog3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    public static javax.swing.JLayeredPane layers;
    private static javax.swing.JButton retiro;
    public static javax.swing.JButton save;
    public static javax.swing.JLabel tablero;
    public static javax.swing.JLabel turn;
    // End of variables declaration//GEN-END:variables
}
