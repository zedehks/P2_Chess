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
public class Caballo extends Ficha
{
    public Caballo(char colour, int x, int y)
    {
        super();
        this.colour = colour;
        switch(colour)
        {
            case 'w':
                this.setIcon(new ImageIcon(getClass().getResource("/P2_Chess/sprites/Weiß/movieBob.png")));
                break;
            case 'b':
                this.setIcon(new ImageIcon(getClass().getResource("/P2_Chess/sprites/Schwarz/movieBob.png")));
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
    void eat(Ficha f)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void getEaten()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void showAvailableMoves()
    {
        super.showAvailableMoves();
        
        if(x > 2)
        {
            if(y > 1)
                Tablero.spawnValidMove(colour, x-2, y-1, this, false);
            if(y < 8)
                Tablero.spawnValidMove(colour, x-2, y+1, this, false);
        }
        if(x > 1)
        {
            if(y > 2)
                Tablero.spawnValidMove(colour, x-1, y-2, this, false);
            if(y < 7)
                Tablero.spawnValidMove(colour, x-1, y+2, this, false);
        }
        
        if(x < 7)
        {
            if(y > 1)
                Tablero.spawnValidMove(colour, x+2, y-1, this, false);
            if(y < 8)
                Tablero.spawnValidMove(colour, x+2, y+1, this, false);
        }
        if(x < 8)
        {
          if(y > 2)
                Tablero.spawnValidMove(colour, x+1, y-2, this, false);
            if(y < 7)
                Tablero.spawnValidMove(colour, x+1, y+2, this, false);  
        }
    }
    
}
