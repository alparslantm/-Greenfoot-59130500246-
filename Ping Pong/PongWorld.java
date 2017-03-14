import greenfoot.*; 


public class PongWorld extends KinectWorld
{
    private boolean idle;
    GreenfootSound myMusic = new GreenfootSound("Electro.mp3");

    
    public PongWorld()
    {
        super ();
        addObject(new ComputerPaddle(), 200, 30);
        addObject(new PlayerPaddle(), 200, 450);
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
        myMusic.play();
        
    }
    
}
