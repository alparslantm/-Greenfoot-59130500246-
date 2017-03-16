import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class StartsScreen extends World
{

    /**
     * Constructor for objects of class StartsScreen.
     * 
     */
    public StartsScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
       
    }
    public void act (){
       
    }
    private void prepare(){
            StartButton startbutton = new StartButton();
            addObject(startbutton, 500, 55);
            return;
    }
   
}
