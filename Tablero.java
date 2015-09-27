package P2_Chess;

import static P2_Chess.Ajedrez.layers;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;


public class Tablero
{
    public static Ficha[] wPieces;
    public static Ficha[] bPieces;
    public static boolean isMoving = false;
    public static char turn = 'w';
    
    
    
    static void spawnPieces()
    {
        wPieces = new Ficha[16];
        bPieces = new Ficha[16];
        
        spawnPawns('w',wPieces);
        spawnPawns('b',bPieces);
        
        spawnTowers('w',wPieces);
        spawnTowers('b',bPieces);
        
        spawnKnights('w',wPieces);
        spawnKnights('b',bPieces);
        
       spawnBishops('w',wPieces);
        spawnBishops('b',bPieces);
        
        spawnKing('w',wPieces);
        spawnKing('b',bPieces);
        
        spawnQueen('w',wPieces);
        spawnQueen('b',bPieces);
        
        
        
        
        
        
    }
    
    static void spawnPawns(char c, Ficha[] b)
    {
        for (int i = 0; i < 8; i++)
        {
            switch(c)
            {
                case 'w':
                    b[i] = new Peon(c,2,i+1);
                    break;
                case 'b':
                    b[i] = new Peon(c,7,i+1);
            }
            
            Ajedrez.layers.add(b[i]);
            Ajedrez.layers.setLayer(b[i], JLayeredPane.POPUP_LAYER);
            
        }
    }
    
    static void spawnTowers(char c, Ficha[] b)
    {
        int x = setColourX(c);
        
        b[8] = new Torre(c,x,1);
        Ajedrez.layers.add(b[8]);
        Ajedrez.layers.setLayer(b[8], JLayeredPane.POPUP_LAYER);
        
        b[9] = new Torre(c,x,8);
        Ajedrez.layers.add(b[9]);
        Ajedrez.layers.setLayer(b[9], JLayeredPane.POPUP_LAYER);
    }
    
    static void spawnKnights(char c, Ficha[] b)
    {   
        int x = setColourX(c);
        
        b[10] = new Caballo(c,x,2);
        Ajedrez.layers.add(b[10]);
        Ajedrez.layers.setLayer(b[10], JLayeredPane.POPUP_LAYER);
        
        b[11] = new Caballo(c,x,7);
        Ajedrez.layers.add(b[11]);
        Ajedrez.layers.setLayer(b[11], JLayeredPane.POPUP_LAYER);
    }
    
    static void spawnBishops(char c, Ficha[] b)
    {
        int x = setColourX(c);
        
        b[12] = new Alfil(c,x,3);
        Ajedrez.layers.add(b[12]);
        Ajedrez.layers.setLayer(b[12], JLayeredPane.POPUP_LAYER);
        
        b[13] = new Alfil(c,x,6);
        Ajedrez.layers.add(b[13]);
        Ajedrez.layers.setLayer(b[13], JLayeredPane.POPUP_LAYER);
    }
    
    static void spawnKing(char c, Ficha[] b)
    {
        int x = setColourX(c);
        
        b[14] = new Rey(c,x,4);
        Ajedrez.layers.add(b[14]);
        Ajedrez.layers.setLayer(b[14], JLayeredPane.POPUP_LAYER);
        
        
    }
    
    static void spawnQueen(char c, Ficha[] b)
    {
        int x = setColourX(c);
        
        b[15] = new Reina(c,x,5);
        Ajedrez.layers.add(b[15]);
        Ajedrez.layers.setLayer(b[15], JLayeredPane.POPUP_LAYER);
    }
    
    static int setColourX(char c)
    {
        switch(c)
        {
            case 'w':
                return 1;
            case 'b':
                return 8;
        }
        return 0;
    }
    
    
    public static boolean spawnValidMove(char c, int x, int y, Ficha parent, boolean isPieceIndicator)
    {
        if(checkSpace(x,y) || isPieceIndicator)
        {  
            JLabel square = new JLabel();
            
            if(isPieceIndicator)
                square.setIcon(new ImageIcon(Ajedrez.selectedglow));
            else
                square.setIcon(new ImageIcon(Ajedrez.glow));

            square.setToolTipText(x+":"+y);
            square.setSize(new java.awt.Dimension(71,71));
            square.setLocation(PosX.get(x), PosY.get(y));
            square.setVisible(true);

            square.addMouseListener(new java.awt.event.MouseAdapter()
            {
                public void mousePressed(java.awt.event.MouseEvent evt)
                {
                    squareMousePressed(evt, parent);
                }
            });


            layers.add(square);
            layers.setLayer(square, JLayeredPane.MODAL_LAYER);
            return true;//se pudo crear? ok, regreso true
        }
        else
        {
            //System.out.println("Espacio ("+x+", "+y+ ") esta Ocupado");
            return false;//regresa falso si no se pudo crear
        }
        
        
    }
    
    static void squareMousePressed(java.awt.event.MouseEvent evt, Ficha parent)
    {
        JLabel glow = (JLabel)evt.getComponent();
        Ajedrez.cleanGlows();
        
        Integer x =Integer.parseInt( glow.getToolTipText().split(":")[0]);
        Integer y =Integer.parseInt( glow.getToolTipText().split(":")[1]);
        
        parent.mover( x,y );
        parent.setLocation(glow.getX(),glow.getY());
        changeTurn();
        
    }
    
    static boolean checkSpace(int x, int y)
    {
        Component[] pieces = Ajedrez.layers.getComponentsInLayer(JLayeredPane.POPUP_LAYER);
        
        for (Component piece : pieces)
        {
            Integer xPos = Integer.parseInt(((Ficha) piece).getToolTipText().split(":")[0]);
            Integer yPos = Integer.parseInt(((Ficha) piece).getToolTipText().split(":")[1]);
            if(xPos == x && yPos == y)
                return false;//regresa falso si hay algo en x,y
        }
        return true;//regresa true si no hay nada en x,y
    }
    
    static boolean canBeEaten(Ficha s, Ficha parent)
    {
        return parent.colour != s.colour;
    }
    
    
    
    static void changeTurn()
    {
        switch(turn)
        {
            case 'w':
                turn = 'b';
                Ajedrez.turn.setText("Atacan las Piezas\nNegras");
                break;
            case 'b':
                turn = 'w';
                Ajedrez.turn.setText("Atacan las Piezas\nBlancas");
        }
    }
    
    
}
