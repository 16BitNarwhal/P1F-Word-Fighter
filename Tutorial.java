import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tutorial here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tutorial extends World
{

    /**
     * Constructor for objects of class Tutorial.
     * 
     */
    public Tutorial()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1);
        setBackground(new GreenfootImage("updated tutorial.png"));
        getBackground().scale(1000, 600);
    }
    
    /**
     * Checks if the y key is pressed down every frame. 
     * If so, change world.
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("y"))
        {
            Greenfoot.setWorld(new GameWorld());
        }
    }
}
