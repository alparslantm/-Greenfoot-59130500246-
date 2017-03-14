import greenfoot.*;

/**
 * A simple paddle for a pong game. Used as superclass for specific kinds of paddle.
 * 
 * @author 
 * @version 1.0
 */
public class Paddle extends Actor
{
    /**
     * Move to the left.
     */
    protected void moveLeft()
    {
        setLocation (getX()-3, getY());
    }    

    /**
     * Move to the right.
     */
    protected void moveRight()
    {
        setLocation (getX()+3, getY());
    }    
}
