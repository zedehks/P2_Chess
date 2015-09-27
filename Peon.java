/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_Chess;
 
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;

public class Peon extends Ficha
{
    boolean enPassantEatable;
    boolean canEnPassant;
    
    public Peon(char colour, int x, int y)
    {
        super();
        this.colour = colour;
        switch(colour)
        {
            case 'w':
                this.setIcon(new ImageIcon(getClass().getResource("/P2_Chess/sprites/Weiß/Peon.png")));
                break;
            case 'b':
                this.setIcon(new ImageIcon(getClass().getResource("/P2_Chess/sprites/Schwarz/Peon.png")));
        }
        
        this.x = x;
        this.y = y;
        
        this.setLocation(PosX.get(x), PosY.get(y));
        
        hasMoved = false;
        isDed = false;
        enPassantEatable = false;
        canEnPassant = false;
        
        this.setToolTipText(x+":"+y);
        this.setVisible(true);
        this.setSize(new java.awt.Dimension(71,71));
        
        
    }

    @Override
    void mover(int x, int y)
    {
        if(enPassantEatable)
            enPassantEatable = false;        
        
        if(!hasMoved)
           enPassantEatable = true;  
        
        super.mover(x, y);
        
        int pawnColor=0;
        switch(colour)
        {
            case 'w':
                pawnColor = 8;
                break;
            case 'b':
                pawnColor = 1;
        }
        
        if(this.x == pawnColor)
            crownMe();
    }
    
    

    @Override
    public void showAvailableMoves()
    {
        super.showAvailableMoves();
        seekTargets(false);
        switch(colour)
        {
            case 'w':
                if(x < 8)
                    Tablero.spawnValidMove(colour,x+1,y, this, false, false,false);
                if(!hasMoved && Tablero.checkSpace(x+2, y) == null && Tablero.checkSpace(x+1 ,y) == null)
                    Tablero.spawnValidMove(colour,x+2,y, this, false, false,false);
                break;
            case 'b':
                if(x > 1)
                    Tablero.spawnValidMove(colour,x-1,y, this, false, false,false);
                if(!hasMoved && Tablero.checkSpace(x-2, y) == null && Tablero.checkSpace(x-1 ,y) == null)
                    Tablero.spawnValidMove(colour,x-2,y, this, false, false,false);    
        }
    }
    
    @Override
    void seekTargets(boolean isChecking4Checkmate)
    {
        Ficha target;
        int pawnColor = 0;
        switch(colour)
        {
            case 'w':
                pawnColor = x+1;
                break;
            case 'b':
                pawnColor = x-1;
        }
        
        if(!isChecking4Checkmate)
        {
            if(Tablero.checkSpace(pawnColor, y+1) != null && Tablero.checkSpace(pawnColor, y+1).colour != this.colour )
                Tablero.spawnValidMove(colour, pawnColor, y+1, this, false, true,false);
            if(Tablero.checkSpace(pawnColor, y-1) != null && Tablero.checkSpace(pawnColor, y-1).colour != this.colour)
                Tablero.spawnValidMove(colour, pawnColor, y-1, this, false, true,false);
            
            
            //en passant
            if(Tablero.checkSpace(x, y+1) instanceof Peon && Tablero.checkSpace(x, y+1).colour != this.colour && ((Peon)Tablero.checkSpace(x,y+1)).enPassantEatable)
            {
                Tablero.spawnValidMove(colour, pawnColor, y+1, this, false, true,false);
                canEnPassant = true;
            }
            if(Tablero.checkSpace(x, y-1) instanceof Peon && Tablero.checkSpace(x, y-1).colour != this.colour && ((Peon)Tablero.checkSpace(x,y-1)).enPassantEatable)
            {
                Tablero.spawnValidMove(colour, pawnColor, y-1, this, false, true,false);
                canEnPassant =  true;
            }
        }
        else
        {
            target = Tablero.checkSpace(pawnColor, y+1);
            check4Check(target);
            target = Tablero.checkSpace(pawnColor, y-1);
            check4Check(target);
        }

    }
    
    void removeEnPassant()
    {
        if(canEnPassant)
            canEnPassant = false;
    }
    
    void crownMe()
    {
        ArrayList a = null;
        switch(colour)
        {
            case 'w':
                a = Tablero.wPieces;
                break;
            case 'b':
                a = Tablero.bPieces;
        }
        Reina nueva = new Reina(this.colour,this.x,this.y);
        Ajedrez.layers.add(nueva);
        Ajedrez.layers.setLayer(nueva, JLayeredPane.POPUP_LAYER);
        a.add(nueva);
        this.getEaten();
    }

}
