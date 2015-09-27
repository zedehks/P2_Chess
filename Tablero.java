package P2_Chess;

import static P2_Chess.Ajedrez.layers;
import java.awt.Component;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;


public class Tablero
{
    public static ArrayList<Ficha> wPieces;
    public static ArrayList<Ficha> bPieces;
    public static boolean isMoving = false;
    
    static boolean whiteCheck = false;
    static boolean blackCheck = false;
    
    public static char turn = 'w';
    
    public static Jugador wPlayer = MainMenu.currentPlayer;
    public static Jugador bPlayer;
    
    
    
    
    
    static void spawnPieces()
    {
        wPieces = new ArrayList<>();
        bPieces = new ArrayList<>();
        
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
    
    static void spawnPawns(char c, ArrayList b)
    {
        Peon nuevo = null;
        for (int i = 0; i < 8; i++)
        {
            switch(c)
            {
                case 'w':
                    nuevo = new Peon(c,2,i+1);
                    break;
                case 'b':
                    nuevo = new Peon(c,7,i+1);
            }
            b.add(nuevo);
            Ajedrez.layers.add(nuevo);
            Ajedrez.layers.setLayer(nuevo, JLayeredPane.POPUP_LAYER);
            
        }
    }
    
    static void spawnTowers(char c, ArrayList b)
    {
        int x = setColourX(c);
        Torre nuevo = new Torre(c,x,1);
        Ajedrez.layers.add(nuevo);
        Ajedrez.layers.setLayer(nuevo, JLayeredPane.POPUP_LAYER);
        b.add(nuevo);
        
        Torre nuevo1 = new Torre(c,x,8);
        Ajedrez.layers.add(nuevo1);
        Ajedrez.layers.setLayer(nuevo1, JLayeredPane.POPUP_LAYER);
        b.add(nuevo1);
    }
    
    static void spawnKnights(char c, ArrayList b)
    {   
        int x = setColourX(c);
        
        Caballo nuevo = new Caballo(c,x,2);
        Ajedrez.layers.add(nuevo);
        Ajedrez.layers.setLayer(nuevo, JLayeredPane.POPUP_LAYER);
        b.add(nuevo);
        
        Caballo nuevo1 = new Caballo(c,x,7);
        Ajedrez.layers.add(nuevo1);
        Ajedrez.layers.setLayer(nuevo1, JLayeredPane.POPUP_LAYER);
        b.add(nuevo1);
    }
    
    static void spawnBishops(char c, ArrayList b)
    {
        int x = setColourX(c);
        
        Alfil nuevo = new Alfil(c,x,3);
        Ajedrez.layers.add(nuevo);
        Ajedrez.layers.setLayer(nuevo, JLayeredPane.POPUP_LAYER);
        b.add(nuevo);
        
        Alfil nuevo1 = new Alfil(c,x,6);
        Ajedrez.layers.add(nuevo1);
        Ajedrez.layers.setLayer(nuevo1, JLayeredPane.POPUP_LAYER);
        b.add(nuevo1);
    }
    
    static void spawnKing(char c, ArrayList b)
    {
        int x = setColourX(c);
        
        Rey nuevo = new Rey(c,x,4);
        Ajedrez.layers.add(nuevo);
        Ajedrez.layers.setLayer(nuevo, JLayeredPane.POPUP_LAYER);
        b.add(nuevo);
        
        
    }
    
    static void spawnQueen(char c, ArrayList b)
    {
        int x = setColourX(c);
        
        Reina nueva = new Reina(c,x,5);
        Ajedrez.layers.add(nueva);
        Ajedrez.layers.setLayer(nueva, JLayeredPane.POPUP_LAYER);
        b.add(nueva);
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
    
    
    public static boolean spawnValidMove(char c, int x, int y, Ficha parent, boolean isPieceIndicator, boolean isTarget, boolean isCheck)
    {
        if(checkSpace(x,y)== null || isPieceIndicator||isTarget||isCheck)
        {  
            JLabel square = new JLabel();
            
            if(isPieceIndicator)
                square.setIcon(new ImageIcon(Ajedrez.selectedglow));
            else if(isTarget || isCheck)
                square.setIcon(new ImageIcon(Ajedrez.enemyglow));
            else
                square.setIcon(new ImageIcon(Ajedrez.glow));

            square.setToolTipText(x+":"+y);
            if(isTarget)
                square.setText("x");
            
            square.setSize(new java.awt.Dimension(71,71));
            square.setLocation(PosX.get(x), PosY.get(y));
            square.setVisible(true);

            if(!isCheck)
            {
                square.addMouseListener(new java.awt.event.MouseAdapter()
                {
                    public void mousePressed(java.awt.event.MouseEvent evt)
                    {
                        squareMousePressed(evt, parent);
                    }
                });
            }


            layers.add(square);
            layers.setLayer(square, JLayeredPane.MODAL_LAYER);
            if(isTarget)
                layers.setLayer(square, JLayeredPane.DRAG_LAYER);
            if(isCheck)
                layers.setLayer(square, JLayeredPane.DEFAULT_LAYER);
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
        
        if( glow.getText().equals("x") )
        {
            if(parent instanceof Peon && ((Peon)parent).canEnPassant)
            {
                switch(parent.colour)
                {
                    case 'w':
                        checkSpace(x-1,y).getEaten();
                        break;
                    case 'b':
                        checkSpace(x+1,y).getEaten();
                }
                
            }
            else
                checkSpace(x,y).getEaten();               
        }


        parent.mover( x,y );
        parent.setLocation(glow.getX(),glow.getY());
        changeTurn();
        
    }
    
    static Ficha checkSpace(int x, int y)
    {
        Component[] pieces = Ajedrez.layers.getComponentsInLayer(JLayeredPane.POPUP_LAYER);
        
        for (Component piece : pieces)
        {
            Integer xPos = Integer.parseInt(((Ficha) piece).getToolTipText().split(":")[0]);
            Integer yPos = Integer.parseInt(((Ficha) piece).getToolTipText().split(":")[1]);
            if(xPos == x && yPos == y)
                return (Ficha)piece;//regresa falso si hay algo en x,y
        }
        return null;//regresa true si no hay nada en x,y
    }            
    
    static void changeTurn()
    {
        cleanChecks();
        
        check4Checks();
        
        
        
        switch(turn)
        {
            case 'w':
                turn = 'b';
                Ajedrez.turn.setText("Atacan las Piezas\nNegras");
                Ajedrez.save.setEnabled(false);
                break;
            case 'b':
                turn = 'w';
                Ajedrez.turn.setText("Atacan las Piezas\nBlancas");
                Ajedrez.save.setEnabled(true);
                
        }
    }
    static void check4Checks()
    {                        
        for(Ficha f : wPieces)
        {
            if(f != null)
                f.seekTargets(true);
        }
        for(Ficha f : bPieces)
        {
            if(f != null)
                f.seekTargets(true);
        }    
        if(!whiteCheck && !blackCheck)
            Tablero.broadcastCheck('c');
    }
    
    static void broadcastCheck(char kingColor)
    {
        
      switch(kingColor)
      {
          case 'w':
              whiteCheck = true;
              
              break;
          case 'b':
              blackCheck = true;
              
              break;
          case 'c':
              whiteCheck = false;
              blackCheck = false;
              cleanChecks();
              
      }
    }
    
    static void removeEnPassant()
    {
        for (int i = 0; i < wPieces.size();i++)
        {
            if(wPieces.get(i) instanceof Peon)
                ((Peon)wPieces.get(i)).removeEnPassant();
        }
        
        for (int i = 0; i < bPieces.size();i++)
        {
            if(bPieces.get(i) instanceof Peon)
                ((Peon)bPieces.get(i)).removeEnPassant();
        }
    }
    
    static void cleanChecks()
    {
        int j = layers.getComponentCountInLayer(JLayeredPane.DEFAULT_LAYER);
        for (int i = 0; i < j; i++)
        {
            layers.remove(layers.getComponentsInLayer(JLayeredPane.DEFAULT_LAYER)[0]);  
        }
        layers.repaint();
    }
    
    static void saveGame()
    {
        try(FileOutputStream fos = new FileOutputStream(Data.ROOT+"/"+wPlayer.usuario+"/vs"+bPlayer.usuario+".cht") )
        {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            oos.writeChar(turn);
            oos.writeObject(wPieces);
            oos.writeObject(bPieces);
            oos.writeObject(Ajedrez.layers);
            oos.close();
            fos.close();
        }
        catch(IOException e)
        {
            System.out.println("Exception: "+e);
        }
    }
    
    static void loadGame(String user, String oponente)
    {
       try(FileInputStream fis = new FileInputStream(Data.ROOT+"/"+user+"/vs"+oponente+".cht"))
        {
            ObjectInputStream ois = new ObjectInputStream(fis);
            
            //wPieces.clear();
            //bPieces.clear();
            for(Component f : layers.getComponentsInLayer(JLayeredPane.POPUP_LAYER))
            {
                layers.remove(f);
            }
            
            turn = ois.readChar();
            switch(turn)
            {
                case 'b':
                    Ajedrez.turn.setText("Atacan las Piezas\nNegras");
                    break;
                case 'w':
                    Ajedrez.turn.setText("Atacan las Piezas\nBlancas");
            }                                                       
            
            wPieces = (ArrayList<Ficha>)ois.readObject();
            bPieces = (ArrayList<Ficha>)ois.readObject();
            
            for (Ficha f : wPieces)
            {
                layers.add(f);
                f.addMouseListener(new java.awt.event.MouseAdapter()
                {
                    @Override
                    public void mousePressed(java.awt.event.MouseEvent evt)
                    {
                        f.PieceMousePressed(evt);
                    }
                });
                Ajedrez.layers.setLayer(f, JLayeredPane.POPUP_LAYER);
            }
            for(Ficha f : bPieces)
            {
                layers.add(f);
                f.addMouseListener(new java.awt.event.MouseAdapter()
                {
                    @Override
                    public void mousePressed(java.awt.event.MouseEvent evt)
                    {
                        f.PieceMousePressed(evt);
                    }
                });
                Ajedrez.layers.setLayer(f, JLayeredPane.POPUP_LAYER);
            }
            
            Ajedrez.layers.repaint();
            
            
            
            
        }
        catch(IOException e)
        {
            System.out.println("Exception: "+e);
            e.printStackTrace();
        } 
        catch(ClassNotFoundException e)
        {
            System.out.println("El archivo no existe");
        }
        catch(NullPointerException e)
        {}
    }

    static void endGame(char loser, boolean retiro)
    {
        switch(loser)
        {
            case 'b':
                wPlayer.puntos += 3;
                try
                {
                    Data.fileWriter(wPlayer);
                    Data.writeLog( "\n"+genWinMsg(wPlayer,bPlayer,retiro));
                    Ajedrez.finish();
                }
                catch(IOException e)
                {}

                break;
            case 'w':
                bPlayer.puntos += 3;
                try
                {
                    Data.fileWriter(bPlayer);
                    Data.writeLog( "\n"+genWinMsg(bPlayer,wPlayer,retiro));
                    Ajedrez.finish();
                }
                catch(IOException e)
                {}

        }
    }
    
    static void retirar()
    {
        endGame(turn,true);
    }
       /** 
        * Laziness extreme!
        * @param winner Pretty self-explanatory kek
        * @param loser Same here jej
        * @param retiro ¿Terminó el juego por retiro o muerte?
        * @return El mensajito listo para grabar
        */
    public static String genWinMsg(Jugador winner, Jugador loser, boolean retiro)
    {
        if(retiro)
            return loser.usuario+" se ha retirado, dejando a "+winner.usuario+" como ganador.\n";
        else
            return winner.usuario+" ha vencido a "+loser.usuario+".\n"; 
    }
    
    
}
