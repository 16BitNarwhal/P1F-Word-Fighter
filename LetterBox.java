import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LetterBox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LetterBox extends GUI
{
    /**
     * Act - do whatever the LetterBox wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
    }    
    public LetterBox(){
        this.setImage("letter square.png");
        GreenfootImage image = getImage();
        image.scale(400, 240);
    }
}
