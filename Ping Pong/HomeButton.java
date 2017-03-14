import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HomeButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HomeButton extends Actor
{
    /**
     * Act - do whatever the HomeButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
  
    
    
    public void act() 
    {
        click();
        
    }    
   private void click(){
    if(Greenfoot.mouseClicked(this)){
    Greenfoot.setWorld(new ChooseLevel());
    } 
    }
}
