import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Start here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Start extends GUI
{
    GreenfootSound main = new GreenfootSound("mainMenu.mp3");
    public Start() {
        setImage(new GreenfootImage("startButton.png"));
        GreenfootImage image = getImage();
        image.scale(120,120);
        setImage(image); 
    }
    /**
     * Act - do whatever the Start wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        main.playLoop();
        if(Greenfoot.mouseClicked(this)){
            main.stop();
            Greenfoot.setWorld(new Tutorial());
        }
        
    }    
}
