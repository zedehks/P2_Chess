package P2_Chess;

public abstract class Ficha
{
    protected int x,y;
    
    protected String colour;
    
    abstract boolean move(int x, int y);
    abstract void eat(Ficha f);
    abstract void getEaten();
    abstract void showAvailableMoves();
}
