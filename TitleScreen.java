import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * title screen.
 * 
 * @author Charles
 * @version Jan 05
 */
public class TitleScreen extends World
{
    GreenfootSound recordsOn = new GreenfootSound("putyourrecordson.mp3");
    Label titleLabel = new Label("Elephant Extinction", 90);
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 

        addObject(titleLabel, getWidth()/2, getHeight()/2);
        prepare();
    }

    /**
     * the main world act loop
     */
    public void act()
    {
        //starts the game if user press spacebar
        if(Greenfoot.isKeyDown("space"))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
            recordsOn.play();
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Elephant elephant = new Elephant();
        addObject(elephant,476,123);
        Label label = new Label("press <space> to start", 40);
        addObject(label,306,290);
        Label label2 = new Label("space to shoot, press left, and right arrow key to move", 30);
        addObject(label2,308,257);
    }
}
