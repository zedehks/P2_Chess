/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_Chess;

import java.awt.Component;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

/**
 *
 * @author waldonavas
 */
public class Deprecated_Spiel extends javax.swing.JFrame
{

    /**
     * Creates new form Deprecated_Spiel
     */
    
    static ArrayList<ArrayList> wPieces;
    static ArrayList<JLabel> w_Pawn;
    static ArrayList<JLabel> w_Tower;
    static ArrayList<JLabel> w_Knight;
    static ArrayList<JLabel> w_Bishop;
    static ArrayList<JLabel> w_Royalty;
    
    static ArrayList<ArrayList> bPieces;
    static ArrayList<JLabel> b_Pawn;
    static ArrayList<JLabel> b_Tower;
    static ArrayList<JLabel> b_Knight;
    static ArrayList<JLabel> b_Bishop;
    static ArrayList<JLabel> b_Royalty;
    
    static final String[] TURNS = { "white","black" };
    static String currentTurn;
    static boolean isMoving = false;
    static JLabel selectedPiece;
    
    public Deprecated_Spiel()
    {
        initComponents();
         
        
        wPieces= new ArrayList<>();   
        w_Pawn = new ArrayList<>();
        w_Tower = new ArrayList<>();
        w_Knight = new ArrayList<>();
        w_Bishop = new ArrayList<>();
        w_Royalty = new ArrayList<>();
        
        wPieces.add(w_Pawn);
        wPieces.add(w_Tower);
        wPieces.add(w_Knight);
        wPieces.add(w_Bishop);
        wPieces.add(w_Royalty);
        
        bPieces= new ArrayList<>();   
        b_Pawn = new ArrayList<>();
        b_Tower = new ArrayList<>();
        b_Knight = new ArrayList<>();
        b_Bishop = new ArrayList<>();
        b_Royalty = new ArrayList<>();
        
        bPieces.add(w_Pawn);
        bPieces.add(w_Tower);
        bPieces.add(w_Knight);
        bPieces.add(w_Bishop);
        bPieces.add(w_Royalty);
        
        spawnPieces(TURNS[0]);
        spawnPieces(TURNS[1]);
        
        currentTurn = TURNS[0];
    }
    
    final void spawnPieces(String c)
    {
        spawnPawns(c);
        spawnTowers(c);
        spawnKnights(c);
        spawnBishops(c);
        spawnRoyalty(c);
    }
    
    final void spawnPawns(String c)
    {
        for (int i = 0; i < 8; i++)
        { 
            switch(c)
            {
                case "white":
                w_Pawn.add( new JLabel() );
                w_Pawn.get(i).setIcon(new javax.swing.ImageIcon(getClass().getResource("/P2_Chess/sprites/Weiß/Peon.png")));
                w_Pawn.get(i).setLocation(PosX.get(2), PosY.get(i+1));
                w_Pawn.get(i).setSize(new java.awt.Dimension(71,71));
                w_Pawn.get(i).setVisible(true);
                w_Pawn.get(i).setToolTipText(2+":"+(i+1));


                layers.add(w_Pawn.get(i));
                layers.setLayer(w_Pawn.get(i), JLayeredPane.POPUP_LAYER);

                w_Pawn.get(i).addMouseListener(new java.awt.event.MouseAdapter()
                {
                    public void mousePressed(java.awt.event.MouseEvent evt)
                    {
                        pawnMousePressed(evt);
                    }
                }); 
                break;
                    
                case "black":
                b_Pawn.add( new JLabel() );
                b_Pawn.get(i).setIcon(new javax.swing.ImageIcon(getClass().getResource("/P2_Chess/sprites/Schwarz/Peon.png")));
                b_Pawn.get(i).setLocation(PosX.get(7), PosY.get(i+1));
                b_Pawn.get(i).setSize(new java.awt.Dimension(71,71));
                b_Pawn.get(i).setVisible(true);
                b_Pawn.get(i).setToolTipText(7+":"+(i+1));


                layers.add(b_Pawn.get(i));
                layers.setLayer(b_Pawn.get(i), JLayeredPane.POPUP_LAYER);

                b_Pawn.get(i).addMouseListener(new java.awt.event.MouseAdapter()
                {
                    public void mousePressed(java.awt.event.MouseEvent evt)
                    {
                        pawnMousePressed(evt);
                    }
                }); 
                break;
                    
            }
        }
    }
    
    final void spawnTowers(String c)
    {
        
        for (int i = 0; i < 2; i++)
        {
            switch(c)
            {
                case "white":
                w_Tower.add(new JLabel());
                w_Tower.get(i).setIcon(new javax.swing.ImageIcon(getClass().getResource("/P2_Chess/sprites/Weiß/tower.png")));
                w_Tower.get(i).setVisible(true);
                w_Tower.get(i).setSize(new java.awt.Dimension(71,71));

                switch(i)
                {
                    case 0:
                        w_Tower.get(i).setLocation(PosX.get(1), PosY.get(8));
                        w_Tower.get(i).setToolTipText(1+":"+8);
                        break;
                    case 1:
                        w_Tower.get(i).setLocation(PosX.get(1), PosY.get(1));
                        w_Tower.get(i).setToolTipText(1+":"+1);
                }
                layers.add(w_Tower.get(i));
                layers.setLayer(w_Tower.get(i), JLayeredPane.POPUP_LAYER);
                w_Tower.get(i).addMouseListener(new java.awt.event.MouseAdapter()
                {
                    public void mousePressed(java.awt.event.MouseEvent evt)
                    {
                        pawnMousePressed(evt);
                    }
                }); 
                break;
                    
                case "black":
                b_Tower.add(new JLabel());
                b_Tower.get(i).setIcon(new javax.swing.ImageIcon(getClass().getResource("/P2_Chess/sprites/Schwarz/tower.png")));
                b_Tower.get(i).setVisible(true);
                b_Tower.get(i).setSize(new java.awt.Dimension(71,71));

                switch(i)
                {
                    case 0:
                        b_Tower.get(i).setLocation(PosX.get(8), PosY.get(8));
                        b_Tower.get(i).setToolTipText(8+":"+8);
                        break;
                    case 1:
                        b_Tower.get(i).setLocation(PosX.get(8), PosY.get(1));
                        b_Tower.get(i).setToolTipText(8+":"+1);
                }
                layers.add(b_Tower.get(i));
                layers.setLayer(b_Tower.get(i), JLayeredPane.POPUP_LAYER);
                b_Tower.get(i).addMouseListener(new java.awt.event.MouseAdapter()
                {
                    public void mousePressed(java.awt.event.MouseEvent evt)
                    {
                        pawnMousePressed(evt);
                    }
                }); 
                break;
                    
            }
            
        }
    }
    
    final void spawnKnights(String c)
    {
        for (int j = 0; j < 2; j++)
        {
            switch(c)
            {
                case "white":
                w_Knight.add(new JLabel());
                w_Knight.get(j).setIcon(new javax.swing.ImageIcon(getClass().getResource("/P2_Chess/sprites/Weiß/movieBob.png")));
                w_Knight.get(j).setVisible(true);
                w_Knight.get(j).setSize(new java.awt.Dimension(71,71));

                switch(j)
                {
                    case 0:
                        w_Knight.get(j).setLocation(PosX.get(1), PosY.get(7));
                        w_Knight.get(j).setToolTipText(1+":"+7);
                        break;
                    case 1:
                        w_Knight.get(j).setLocation(PosX.get(1), PosY.get(2));
                        w_Knight.get(j).setToolTipText(1+":"+2);
                }
                layers.add(w_Knight.get(j));
                layers.setLayer(w_Knight.get(j), JLayeredPane.POPUP_LAYER);
                w_Knight.get(j).addMouseListener(new java.awt.event.MouseAdapter()
                {
                    public void mousePressed(java.awt.event.MouseEvent evt)
                    {
                        pawnMousePressed(evt);
                    }
                }); 
                    break;
                case "black":
                b_Knight.add(new JLabel());
                b_Knight.get(j).setIcon(new javax.swing.ImageIcon(getClass().getResource("/P2_Chess/sprites/Schwarz/movieBob.png")));
                b_Knight.get(j).setVisible(true);
                b_Knight.get(j).setSize(new java.awt.Dimension(71,71));

                switch(j)
                {
                    case 0:
                        b_Knight.get(j).setLocation(PosX.get(8), PosY.get(7));
                        b_Knight.get(j).setToolTipText(8+":"+7);
                        break;
                    case 1:
                        b_Knight.get(j).setLocation(PosX.get(8), PosY.get(2));
                        b_Knight.get(j).setToolTipText(8+":"+2);
                }
                layers.add(b_Knight.get(j));
                layers.setLayer(b_Knight.get(j), JLayeredPane.POPUP_LAYER);
                b_Knight.get(j).addMouseListener(new java.awt.event.MouseAdapter()
                {
                    public void mousePressed(java.awt.event.MouseEvent evt)
                    {
                        pawnMousePressed(evt);
                    }
                });
            }
            
        }
    }
    
    final void spawnBishops(String c)
    {
        for (int j = 0; j < 2; j++)
        {
            switch(c)
            {
                case "white":
                w_Bishop.add(new JLabel());
                w_Bishop.get(j).setIcon(new javax.swing.ImageIcon(getClass().getResource("/P2_Chess/sprites/Weiß/bishop.png")));
                w_Bishop.get(j).setVisible(true);
                w_Bishop.get(j).setSize(new java.awt.Dimension(71,71));

                switch(j)
                {
                    case 0:
                        w_Bishop.get(j).setLocation(PosX.get(1), PosY.get(6));
                        w_Bishop.get(j).setToolTipText(1+":"+6);
                        break;
                    case 1:
                        w_Bishop.get(j).setLocation(PosX.get(1), PosY.get(3));
                        w_Bishop.get(j).setToolTipText(1+":"+3);
                }
                layers.add(w_Bishop.get(j));
                layers.setLayer(w_Bishop.get(j), JLayeredPane.POPUP_LAYER);
                w_Bishop.get(j).addMouseListener(new java.awt.event.MouseAdapter()
                {
                    public void mousePressed(java.awt.event.MouseEvent evt)
                    {
                        pawnMousePressed(evt);
                    }
                });
                break;
                case "black":
                b_Bishop.add(new JLabel());
                b_Bishop.get(j).setIcon(new javax.swing.ImageIcon(getClass().getResource("/P2_Chess/sprites/Schwarz/bishop.png")));
                b_Bishop.get(j).setVisible(true);
                b_Bishop.get(j).setSize(new java.awt.Dimension(71,71));

                switch(j)
                {
                    case 0:
                        b_Bishop.get(j).setLocation(PosX.get(8), PosY.get(6));
                        b_Bishop.get(j).setToolTipText(8+":"+6);
                        break;
                    case 1:
                        b_Bishop.get(j).setLocation(PosX.get(8), PosY.get(3));
                        b_Bishop.get(j).setToolTipText(8+":"+3);
                }
                layers.add(b_Bishop.get(j));
                layers.setLayer(b_Bishop.get(j), JLayeredPane.POPUP_LAYER);
                b_Bishop.get(j).addMouseListener(new java.awt.event.MouseAdapter()
                {
                    public void mousePressed(java.awt.event.MouseEvent evt)
                    {
                        pawnMousePressed(evt);
                    }
                });
            }
            
        }
    }
    
    final void spawnRoyalty(String c)
    {
        for (int i = 0; i < 2; i++)
        {
            switch(c)
            {
                case "white":
                w_Royalty.add( new JLabel() );
                w_Royalty.get(i).setSize(new java.awt.Dimension(71,71));
                w_Royalty.get(i).setVisible(true);

                switch (i)
                {
                    case 0:
                        w_Royalty.get(i).setIcon(new javax.swing.ImageIcon(getClass().getResource("/P2_Chess/sprites/Weiß/Königin.png")));
                        w_Royalty.get(i).setLocation(PosX.get(1), PosY.get(5));
                        w_Royalty.get(i).setToolTipText(1+":"+(5));
                        break;
                    case 1:
                        w_Royalty.get(i).setIcon(new javax.swing.ImageIcon(getClass().getResource("/P2_Chess/sprites/Weiß/König.png")));
                        w_Royalty.get(i).setLocation(PosX.get(1), PosY.get(4));
                        w_Royalty.get(i).setToolTipText(1+":"+(4));      
                }
                layers.add(w_Royalty.get(i));
                layers.setLayer(w_Royalty.get(i), JLayeredPane.POPUP_LAYER);
                w_Royalty.get(i).addMouseListener(new java.awt.event.MouseAdapter()
                {
                    public void mousePressed(java.awt.event.MouseEvent evt)
                    {
                        pawnMousePressed(evt);
                    }
                });  
                break;
                case "black":
                    b_Royalty.add( new JLabel() );
                    b_Royalty.get(i).setSize(new java.awt.Dimension(71,71));
                    b_Royalty.get(i).setVisible(true);

                    switch (i)
                    {
                        case 0:
                            b_Royalty.get(i).setIcon(new javax.swing.ImageIcon(getClass().getResource("/P2_Chess/sprites/Schwarz/Königin.png")));
                            b_Royalty.get(i).setLocation(PosX.get(8), PosY.get(5));
                            b_Royalty.get(i).setToolTipText(8+":"+(5));
                            break;
                        case 1:
                            b_Royalty.get(i).setIcon(new javax.swing.ImageIcon(getClass().getResource("/P2_Chess/sprites/Schwarz/König.png")));
                            b_Royalty.get(i).setLocation(PosX.get(8), PosY.get(4));
                            b_Royalty.get(i).setToolTipText(8+":"+(4));      
                    }
                    layers.add(b_Royalty.get(i));
                    layers.setLayer(b_Royalty.get(i), JLayeredPane.POPUP_LAYER);
                    b_Royalty.get(i).addMouseListener(new java.awt.event.MouseAdapter()
                    {
                        public void mousePressed(java.awt.event.MouseEvent evt)
                        {
                            pawnMousePressed(evt);
                        }
                    }); 
            }
        }
    }
    
    static String searchArrayLists(JLabel l)
    {
        if(w_Pawn.contains(l) || w_Tower.contains(l) || w_Knight.contains(l) || w_Bishop.contains(l) || w_Royalty.contains(l))
            return "white";
        else if(b_Pawn.contains(l) || b_Tower.contains(l) || b_Knight.contains(l) || b_Bishop.contains(l) || b_Royalty.contains(l))
            return "black";
        return null;
    }
    
    
    private void pawnMousePressed(java.awt.event.MouseEvent evt)
    {
        if(!isMoving)
        {                  
            if(searchArrayLists( (JLabel)(evt.getSource())  ).equals(currentTurn))
            {
                isMoving = true;
                System.out.println( ((JLabel)evt.getSource()).getToolTipText().split(":")[0] );
                Integer x = Integer.parseInt( ((JLabel)evt.getSource()).getToolTipText().split(":")[0] );
                System.out.println("x: "+x);
                Integer y = Integer.parseInt( ((JLabel)evt.getSource()).getToolTipText().split(":")[1] );
                System.out.println("y: "+y);

                selectedPiece = (JLabel)evt.getSource();

                try
                {    
                    switch(searchArrayLists(selectedPiece))
                    {
                        case "white":
                            spawnValidMove(x+1,y, selectedPiece);
                            break;
                        case "black":
                            spawnValidMove(x-1,y, selectedPiece);
                            break;
                        default:
                            System.out.println("something went wrong");
                    }
                }
                catch (NullPointerException e)
                {
                    System.out.println("La pieza ya no se puede mover.");
                    isMoving = false;
                    selectedPiece = null;
                }
                
            }
            else
                System.out.println("not ur turn");
            }
        else
        {
            System.out.println("Wait for ur turn !");
        }
        
    }
    
    private JLabel findLabel(int x, int y)
    {
       for(Component n : (layers.getComponentsInLayer(JLayeredPane.POPUP_LAYER)))
       {
           if(n.getX() == x && n.getY() == y && n!= Tablero)
               return (JLabel)n;
       }
        return null;
    }
    
    final void spawnValidMove(int x, int y, JLabel i)
    {  
        
        if( findLabel(x,y) == null  ||  !currentTurn.equals(searchArrayLists(findLabel(x,y))) )
        {
            JLabel valid = new JLabel(new ImageIcon("/P2_Chess/sprites/glow.png"));
            valid.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Chess/sprites/glow.png")));
            valid.setLocation(PosX.get(x), PosY.get(y));
            valid.setSize(new java.awt.Dimension(71,71));

            valid.setVisible(true);
            selectedPiece = valid;
            layers.add(valid);
            layers.setLayer(valid, JLayeredPane.DRAG_LAYER);

            valid.addMouseListener(new java.awt.event.MouseAdapter()
             {
                 public void mousePressed(java.awt.event.MouseEvent evt)
                 {
                     squareMousePressed(evt, layers.getPosition(i), i);
                 }
             });
        }
        else
        {
            System.out.println("lol");
        }
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

        layers = new javax.swing.JLayeredPane();
        Tablero = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chess");
        setMinimumSize(new java.awt.Dimension(850, 650));
        setResizable(false);
        getContentPane().setLayout(null);

        layers.setMaximumSize(new java.awt.Dimension(600, 600));
        layers.setPreferredSize(new java.awt.Dimension(620, 620));

        Tablero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/P2_Chess/sprites/board.png"))); // NOI18N
        Tablero.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                TableroMousePressed(evt);
            }
        });
        layers.add(Tablero);
        Tablero.setBounds(5, 5, 600, 600);
        layers.setLayer(Tablero, javax.swing.JLayeredPane.PALETTE_LAYER);

        getContentPane().add(layers);
        layers.setBounds(10, 10, 620, 620);

        jButton1.setText("Retirar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jButton1MouseClicked(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(650, 40, 85, 29);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TableroMousePressed(java.awt.event.MouseEvent evt)//GEN-FIRST:event_TableroMousePressed
    {//GEN-HEADEREND:event_TableroMousePressed
        for (int i = 0; i < (layers.getComponentCountInLayer(JLayeredPane.DRAG_LAYER)); i++)
        {
            if((layers.getComponentsInLayer(JLayeredPane.DRAG_LAYER))[i].equals(selectedPiece))
            {
               layers.remove(i);
               layers.repaint();
            }
        }
        isMoving = false;
    }//GEN-LAST:event_TableroMousePressed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jButton1MouseClicked
    {//GEN-HEADEREND:event_jButton1MouseClicked
        this.dispose();
        MainMenu lol = new MainMenu();
        lol.setVisible(true);
    }//GEN-LAST:event_jButton1MouseClicked
    
    private void squareMousePressed(java.awt.event.MouseEvent evt, int i, JLabel caller)
    {
        if(evt.getComponent().isVisible())
        {
            
            caller.setLocation(evt.getComponent().getX(),evt.getComponent().getY());
            Integer x =Integer.parseInt( caller.getToolTipText().split(":")[0]);
            switch(searchArrayLists(caller))
            {
                case "white":
                    x+=1;
                    break;
                case "black":
                    x-=1;
                default:
                    System.out.println("something went wrong lol");
            }
            
            Integer y =Integer.parseInt( caller.getToolTipText().split(":")[1]);

            caller.setToolTipText( x + ":"+ y);
            isMoving = false;
            switch(currentTurn)
            {
                case "white":
                    currentTurn = "black";
                    break;
                case "black":
                    currentTurn = "white";
            } 
        }
        evt.getComponent().setVisible(false);
    }
    
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
            java.util.logging.Logger.getLogger(Deprecated_Spiel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(Deprecated_Spiel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(Deprecated_Spiel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(Deprecated_Spiel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new Deprecated_Spiel().setVisible(true);
            }
        });
        
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Tablero;
    private javax.swing.JButton jButton1;
    private javax.swing.JLayeredPane layers;
    // End of variables declaration//GEN-END:variables
}
