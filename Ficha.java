package P2_Chess;

import javax.swing.JLabel;

public abstract class Ficha extends JLabel
{
    protected int x,y;
    
    protected char colour;
    
    protected boolean hasMoved;
    
    protected boolean isDed;
    
    public Ficha()
    {
        this.addMouseListener(new java.awt.event.MouseAdapter()
        {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                PieceMousePressed(evt);
            }
        }); 
    }
    
    ///////////////////
    
    void mover(int x, int y)
    {
        this.x = x;
        this.y = y;
        
        this.hasMoved = true;
        this.setLocation(PosX.get(x), PosY.get(y));
        this.setToolTipText(x+":"+y);
    }
    
    void getEaten()
    {
        this.setVisible(false);
        this.isDed = true;
        this.setSize(0, 0);
        Ajedrez.layers.remove(this);
    }
    void seekTargets(){};
    
    void showAvailableMoves()
    {
        Tablero.spawnValidMove(colour,x,y, this, true, false);
        //seekTargets();
        
    }
    void PieceMousePressed(java.awt.event.MouseEvent evt)
    {
        if(Tablero.turn == this.colour)
        {
            if(Tablero.isMoving )
            {
                Ajedrez.cleanGlows();
            }
            showAvailableMoves();
            Tablero.isMoving = true;
            
        }
    }
    

    /********************
    *
    *Movement Prototypes
    *
    ********************/

    void crossMovement()
    {
        
        int xPos = x;
        int yPos = y;
        while(true)
        {
            xPos += 1;
            if(xPos > 8)
                break;
            if(!Tablero.spawnValidMove(colour, xPos, y, this, false, false))
            {
                if(Tablero.checkSpace(xPos, y).colour != this.colour )
                    Tablero.spawnValidMove(colour, xPos, y, this, false, true);
                break;
            } 
        }
        xPos = x;
        while(true)
        {
            xPos -= 1;
            if(xPos < 1)
                break;
            if(!Tablero.spawnValidMove(colour, xPos, y, this, false, false))
            {
                if(Tablero.checkSpace(xPos, y).colour != this.colour )
                    Tablero.spawnValidMove(colour, xPos, y, this, false, true);
                break;
            }
        }
        
        while(true)
        {
            yPos += 1;
            if(yPos > 8)
                break;
            if(!Tablero.spawnValidMove(colour, x, yPos, this, false, false))
            {
                if(Tablero.checkSpace(x, yPos).colour != this.colour )
                    Tablero.spawnValidMove(colour, x, yPos, this, false, true);
                break;
            } 
        }
        yPos =y;
        while(true)
        {
            yPos -= 1;
            if(yPos < 1)
                break;
            if(!Tablero.spawnValidMove(colour, x, yPos, this, false, false))
            {
                if(Tablero.checkSpace(x, yPos).colour != this.colour )
                    Tablero.spawnValidMove(colour, x, yPos, this, false, true);
                break;
            } 
        }
    }
    
    void diagonalMovement()
    {
        int xPos = x;
        int yPos = y;
        while(true)
        {
            xPos += 1;
            yPos += 1;
            if(xPos > 8 || yPos > 8)
                break;
            if(!Tablero.spawnValidMove(colour, xPos, yPos, this, false, false))
            {
                if( (Tablero.checkSpace(xPos,yPos)).colour != this.colour )
                    Tablero.spawnValidMove(colour, xPos, yPos, this, false, true);
                break; 
            }
        }
        xPos = x;
        yPos = y;
        while(true)
        {
            xPos -= 1;
            yPos -= 1;
            if(xPos < 1 || yPos < 1)
                break;
            if(!Tablero.spawnValidMove(colour, xPos, yPos, this, false, false))
            {
                if( (Tablero.checkSpace(xPos,yPos)).colour != this.colour )
                    Tablero.spawnValidMove(colour, xPos, yPos, this, false, true);
                break; 
            }
        }
        xPos = x;
        yPos = y;
        while(true)
        {
            yPos += 1;
            xPos -= 1;
            if(yPos > 8 || xPos < 1)
                break;
            if(!Tablero.spawnValidMove(colour, xPos, yPos, this, false, false))
            {
                if( (Tablero.checkSpace(xPos,yPos)).colour != this.colour )
                    Tablero.spawnValidMove(colour, xPos, yPos, this, false, true);
                break; 
            } 
        }
        xPos = x;
        yPos = y;
        while(true)
        {
            yPos -= 1;
            xPos += 1;
            if(yPos < 1 || xPos > 8)
                break;
            if(!Tablero.spawnValidMove(colour, xPos, yPos, this, false, false))
            {
                if( (Tablero.checkSpace(xPos,yPos)).colour != this.colour )
                    Tablero.spawnValidMove(colour, xPos, yPos, this, false, true);
                break; 
            } 
        }
    }
}
