import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class StartButton extends Actor
{
    
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
