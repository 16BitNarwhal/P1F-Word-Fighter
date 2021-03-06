import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TItleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TItleScreen extends World
{
    
    /**
     * Constructor for objects of class TItleScreen.
     * 
     */
    public TItleScreen() {
        super(1000, 600, 1);
        addObject(new TitleScreenPlayer(),0,0);
        prepare();
        setBackground(new GreenfootImage("titleScreen.png"));
        
    }
    
    /**
     * Prepares the title screen.
     */
    private void prepare()
    {
        Title title = new Title();
        addObject(title,475,350);
        Start startbutton = new Start();
        addObject(startbutton,500,400);
    }
}
