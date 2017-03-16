import greenfoot.*;

public class PlayerPaddle extends Paddle
{
    /**
     * Create a player paddle.
     */
    public PlayerPaddle()
    {
    }
    
    /**
     * Place the paddle at the x-location of the hand of the user.
     */
    public void act() 
    {
        if (Greenfoot.isKeyDown("left")) {
            moveLeft();
        }
        if (Greenfoot.isKeyDown("right")) {
            moveRight();
        }
    }    
}
