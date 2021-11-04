import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class CheckWordButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CheckWordButton extends GUI
{
    private GreenfootImage theButton = new GreenfootImage("gui/tile078.png");
    
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)) {
            if (FinishedWordBox.checkWord()) {
                int size = FinishedWordBox.getWord().size();
                FinishedWordBox.clearLetters();
                // player attack enemy
            } else {
                // 
            }
        }
    }    
    
    public CheckWordButton() {
        theButton.scale(100, 100);
        this.setImage(theButton);
    }
}
