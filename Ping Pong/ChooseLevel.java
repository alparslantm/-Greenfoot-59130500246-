import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ChooseLevel extends World
{

    
    public ChooseLevel()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(500, 350, 1); 
    }
    
    public void act() {
        if(Greenfoot.mouseClicked(this)) {
            MouseInfo mi = Greenfoot.getMouseInfo();
            int x = mi.getX();
            if(x < 167)
                Greenfoot.setWorld(new PongWorld());
            else if(x > 334)
                Greenfoot.setWorld(new PongWorld3());
            else
                Greenfoot.setWorld(new PongWorld2());
        }
    }
    
    
}
