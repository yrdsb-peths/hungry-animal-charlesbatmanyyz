import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * food for our elephant/
 * 
 * @author Charles
 * @version jan 05
 */
public class Asteroid extends Actor
{
    private static int speed = 3;
    
    /**
     * Act - do whatever the Apple wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        GreenfootSound elephantSound = new GreenfootSound("eyuh.mp3");
        
        setLocation(getX(), getY() + speed);
        
        // remove apple and draw game over when apple gets to bottom
        MyWorld world = (MyWorld) getWorld();
        if(getY() >= world.getHeight())
        {
            int x = Greenfoot.getRandomNumber(600);
            int y = 0;
            
            setLocation(x, y + speed);
        }
        if(isTouching(Laser.class))
        {
            world.removeObject(this);
            world.createAsteroid();
            world.increaseScore();
            elephantSound.play();
        }
    }
    
    public static void setSpeed(int spd)
    {
        speed = spd;
    }
    
}
