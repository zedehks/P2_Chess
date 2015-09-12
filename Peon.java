/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_Chess;
 
import javax.swing.ImageIcon;

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

        
    }
    
    

    @Override
    public void showAvailableMoves()
    {
        super.showAvailableMoves();
        seekTargets();
        switch(colour)
        {
            case 'w':
                if(x < 8)
                    Tablero.spawnValidMove(colour,x+1,y, this, false, false);
                if(!hasMoved && Tablero.checkSpace(x+2, y) == null && Tablero.checkSpace(x+1 ,y) == null)
                    Tablero.spawnValidMove(colour,x+2,y, this, false, false);
                break;
            case 'b':
                if(x > 1)
                    Tablero.spawnValidMove(colour,x-1,y, this, false, false);
                if(!hasMoved && Tablero.checkSpace(x-2, y) == null && Tablero.checkSpace(x-1 ,y) == null)
                    Tablero.spawnValidMove(colour,x-2,y, this, false, false);    
        }
    }
    
    @Override
    void seekTargets()
    {
        int pawnColor = 0;
        switch(colour)
        {
            case 'w':
                pawnColor = x+1;
                break;
            case 'b':
                pawnColor = x-1;
        }
        
        if(Tablero.checkSpace(pawnColor, y+1) != null && Tablero.checkSpace(pawnColor, y+1).colour != this.colour )
            Tablero.spawnValidMove(colour, pawnColor, y+1, this, false, true);
        if(Tablero.checkSpace(pawnColor, y-1) != null && Tablero.checkSpace(pawnColor, y-1).colour != this.colour)
            Tablero.spawnValidMove(colour, pawnColor, y-1, this, false, true);
        
        if(Tablero.checkSpace(x, y+1) instanceof Peon && Tablero.checkSpace(x, y+1).colour != this.colour && ((Peon)Tablero.checkSpace(x,y+1)).enPassantEatable)
        {
            Tablero.spawnValidMove(colour, pawnColor, y+1, this, false, true);
            canEnPassant = true;
        }
        if(Tablero.checkSpace(x, y-1) instanceof Peon && Tablero.checkSpace(x, y-1).colour != this.colour && ((Peon)Tablero.checkSpace(x,y-1)).enPassantEatable)
        {
            Tablero.spawnValidMove(colour, pawnColor, y-1, this, false, true);
            canEnPassant =  true;
        }
        
         
        
        
        
        
    }

}
