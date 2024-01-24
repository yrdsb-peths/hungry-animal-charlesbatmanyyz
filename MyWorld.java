import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The world our hero lives in.
 * 
 * @author feng
 * @version jan 05
 */
public class MyWorld extends World
{
    public int score = 0;
    Label scoreLabel;
    int level = 1;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {   
        
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);
        
        //create the elephant object
        Elephant elephant = new Elephant();
        addObject(elephant, 300, 350);
        
        //create a label
        scoreLabel = new Label(0, 40);
        addObject(scoreLabel, 40, 20);
        
        //spawns a new Asteroid on top of screen
        createAsteroid();
        createAsteroid();
        createAsteroid();
        
        
    }
    
    /**
     * end the game and draw a giant "game over" label on the screen
     */
    public void gameOver()
    {
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel, 300, 200);
    }
    
    /**
     * increase score
     */
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
        
        if(score % 5 == 0)
        {
            level += 1;
        }
    }
    /**
     * create a new Asteroid random location on top of the screen
     */
    public void createAsteroid()
    {
        Asteroid asteroid = new Asteroid();
        Asteroid.setSpeed(level);
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(asteroid, x, y);
        
    }
        
    
}
