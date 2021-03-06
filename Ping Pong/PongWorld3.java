import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PongWorld3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PongWorld3 extends KinectWorld
{
   private boolean idle;
    GreenfootSound myMusic = new GreenfootSound("Electro.mp3");
    /**
     * Constructor for objects of class PongWorld3.
     * 
     */
   public PongWorld3()
    {
        super ();
        addObject(new ComputerPaddle(), 200, 90);
        addObject(new PlayerPaddle(), 200, 350);
        addObject(new Ball(), getWidth()/2, getHeight()/2);
        idle = true;
         prepare();
        
    }
    private void prepare(){
            HomeButton homebutton = new HomeButton();
            addObject(homebutton, 23, 23);
            NextButton nextbutton = new NextButton();
            addObject(nextbutton,615,23);
            return;
    }
    
    /**
     * Nothing to do.
     */
    public void act()
    {
        super.act();
        click();
         myMusic.play();
    }
        private void click(){
       if(Greenfoot.mouseClicked(this)){
       Greenfoot.setWorld(new StartsScreen());
       } 
    }
}
