import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class PongWorld2 extends KinectWorld
{
    private boolean idle; 
    GreenfootSound myMusic = new GreenfootSound("Electro.mp3");
    
   public PongWorld2()
    {
        super ();
        addObject(new ComputerPaddle(), 200, 60);
        addObject(new PlayerPaddle(), 200, 380);
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
    
    
    public void act()
    {
        super.act();
        click ();
         myMusic.play();
    }
    private void click(){
    if(Greenfoot.mouseClicked(this)){
    Greenfoot.setWorld(new PongWorld3());
    } 
    }
}
