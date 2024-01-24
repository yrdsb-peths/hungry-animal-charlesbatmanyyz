import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * elephant the hero of the game.
 * 
 * @author charles 
 * @version jan 05
 */
public class Elephant extends Actor
{
    GreenfootSound elephantSound = new GreenfootSound("eyuh.mp3");
    GreenfootImage[] idleRight = new GreenfootImage[8];
    GreenfootImage[] idleLeft = new GreenfootImage[8];
    private long lastSpawnTime;
    private int spawnCooldown = 700;
    
    //direction the elephant is facing
    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();
    /**
     * constructor
     */
    
    public Elephant()
    {
        for(int i = 0; i < idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleRight[i].scale(50, 50);
        }
        
        for(int i = 0; i < idleLeft.length; i++)
        {
            idleLeft[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(50, 50);
        }
        
        animationTimer.mark();
        
        
        //initial elephant image
        setImage(idleRight[0]);
    }
    
    int imageIndex = 0;
    /**
     * animate the elephant
     */
    public void animateElephant()
    {
        if(animationTimer.millisElapsed() < 100)
        {
            return;
        }
        animationTimer.mark();
        
        if(facing.equals("right"))
        {
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
        else
        {
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
    }
    
    /**
     * Act - do whatever the elephant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        if(Greenfoot.isKeyDown("left"))
        {
            move(-3);
            
            facing = "left";
        }
        else if(Greenfoot.isKeyDown("right"))
        {
            move(3);
            facing = "right";
        }
        
        if(Greenfoot.isKeyDown("space") && canSpawn())
        {
            spawnLaser();
        }
        
        // remove Asteroid if touching
        eat();
        
        
        //animate the elephant
        animateElephant();
    }
    
    /**
     * eat the Asteroid and spawn neww Asteroid if an Asteroid is eaten
     */
    public void eat()
    {
        if(isTouching(Asteroid.class))
        {
            MyWorld world = (MyWorld) getWorld();
            world.gameOver();
        }
        
    }
    private void spawnLaser()
    {
        Laser laser = new Laser();
        int spawnX = getX();
        int spawnY= getY();
        getWorld().addObject(laser, spawnX, spawnY);
        lastSpawnTime = System.currentTimeMillis();
    }
    
    private boolean canSpawn()
    {
        return (System.currentTimeMillis() - lastSpawnTime) >= spawnCooldown;
    }
}
