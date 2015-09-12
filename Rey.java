/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_Chess;

import javax.swing.ImageIcon;

/**
 *
 * @author waldonavas
 */
public class Rey extends Ficha
{
    public Rey(char colour, int x, int y)
    {
        super();
        this.colour = colour;
        switch(colour)
        {
            case 'w':
                this.setIcon(new ImageIcon(getClass().getResource("/P2_Chess/sprites/Weiß/König.png")));
                break;
            case 'b':
                this.setIcon(new ImageIcon(getClass().getResource("/P2_Chess/sprites/Schwarz/König.png")));
        }
        
        this.x = x;
        this.y = y;
        
        this.setLocation(PosX.get(x), PosY.get(y));
        
        hasMoved = false;
        isDed = false;
        
        this.setToolTipText(x+":"+y);
        this.setVisible(true);
        this.setSize(new java.awt.Dimension(71,71));
        
        
    }

    @Override
    void showAvailableMoves()
    {
        super.showAvailableMoves();
        if(x < 8)
        {
            if(!Tablero.spawnValidMove(colour, x+1, y, this, false, false))
            {
                if(Tablero.checkSpace(x+1, y).colour != this.colour )
                    Tablero.spawnValidMove(colour, x+1, y, this, false, true);
            } 
            if(y < 8)
                if(!Tablero.spawnValidMove(colour, x+1, y+1, this, false, false))
                {
                    if(Tablero.checkSpace(x+1, y+1).colour != this.colour )
                        Tablero.spawnValidMove(colour, x+1, y+1, this, false, true);
                } 
            if(y > 1)
                if(!Tablero.spawnValidMove(colour, x+1, y-1, this, false, false))
                {
                    if(Tablero.checkSpace(x+1, y-1).colour != this.colour )
                        Tablero.spawnValidMove(colour, x+1, y-1, this, false, true);
                } 
        }
        
        if(x > 1)
        {
            if(!Tablero.spawnValidMove(colour, x-1, y, this, false, false))
                {
                    if(Tablero.checkSpace(x-1, y).colour != this.colour )
                        Tablero.spawnValidMove(colour, x-1, y, this, false, true);
                } 
            if (y > 1)
                if(!Tablero.spawnValidMove(colour, x-1, y-1, this, false, false))
                {
                    if(Tablero.checkSpace(x-1, y-1).colour != this.colour )
                        Tablero.spawnValidMove(colour, x-1, y-1, this, false, true);
                } 
            if(y < 8 )
                if(!Tablero.spawnValidMove(colour, x-1, y+1, this, false, false))
                {
                    if(Tablero.checkSpace(x-1, y+1).colour != this.colour )
                        Tablero.spawnValidMove(colour, x-1, y+1, this, false, true);
                } 
        }
        
        if(y < 8)
            if(!Tablero.spawnValidMove(colour, x, y+1, this, false, false))
                {
                    if(Tablero.checkSpace(x, y+1).colour != this.colour )
                        Tablero.spawnValidMove(colour, x, y+1, this, false, true);
                } 
        if(y > 1)
            if(!Tablero.spawnValidMove(colour, x, y-1, this, false, false))
                {
                    if(Tablero.checkSpace(x, y-1).colour != this.colour )
                        Tablero.spawnValidMove(colour, x, y-1, this, false, true);
                } 
        
    }
    
    
}
