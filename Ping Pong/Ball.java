import greenfoot.*;


public class Ball extends Actor
{
    private int deltaX;         // x movement speed
    private int deltaY;         // y movement speed
    private int radius;
    private int delay;
    private int playerScore;
    private int computerScore;
    
    
    public Ball()
    {
        deltaX = 2;
        deltaY = 3;
        radius = getImage().getWidth() / 2;
        delay = 200;
        playerScore = 0;
        computerScore = 0;
        
    }

    
    public void addedToWorld(World world)
    {
        showScores();
    }
    
    
    public void act() 
    {
        if (delay > 0) {
            delay--;
            return;
        }
        
        checkWalls();
        checkPaddle();
        setLocation (getX() + deltaX, getY() + deltaY);
        checkOut();
    }
    
    
    private void checkWalls()
    {
        if (getX() <= radius || getX() >= getWorld().getWidth()-radius) {
            deltaX = -deltaX;
        }
    }
    
    
    private void checkPaddle()
    {
        Actor paddle = getOneIntersectingObject(Paddle.class);
        if (paddle != null) {
            deltaY = -deltaY;
            deltaX = Math.round((getX()-paddle.getX()) / 9.0f);
        }
    }
    
    
    private void checkOut()
    {
        if (getY() < 10  ||  getY() > getWorld().getHeight()-10) {
            // ball is out
            if (getY() < 10) {
                playerScore++;
                Greenfoot.playSound("goalsound1.wav");
            }
            else {
                computerScore++;
                Greenfoot.playSound("goalsound1.wav");
            }
            showScores();

            // reset ball
            setLocation (getWorld().getWidth()/2, getWorld().getHeight()/2);
            delay = 200;
            deltaX = 1;
        }
    }
    
    /**
     * Show the current scores on screen.
     */
    private void showScores()
    {
        getWorld().showText("SCORE: "+playerScore, 80, 260);
        getWorld().showText("SCORE: "+computerScore, 80, 220);
    }
}
