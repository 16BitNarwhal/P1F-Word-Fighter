import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class FinishedWordBox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FinishedWordBox extends GUI
{
    private static ArrayList<Character> words;
    /**
     * Act - do whatever the FinishedWordBox wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    public FinishedWordBox()
    {
        this.setImage("finishedWordBox.png");
        GreenfootImage image = getImage();
        image.scale(488, 94);
        ArrayList<Character> words = new ArrayList<Character>();
        
    }
    public static ArrayList<Character> getArrayList()
    {
        return words;
    }
}
