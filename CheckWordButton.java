import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 *The button that checks if a word is present in the 
 *finished word box.
 */
public class CheckWordButton extends GUI
{
    private GreenfootImage theButton = new GreenfootImage("gui/tile078.png");
    private GreenfootSound wrong = new GreenfootSound("wrongAnswer.mp3");
    /**
     *The constructor for the CheckWordButton class.
     *100x100 image of the button
     */
    public CheckWordButton() {
        theButton.scale(100, 100);
        this.setImage(theButton);
    }

    /**
     * Checks if it is clicked every frame. 
     * If so, checks for word
     * Word cannot be smaller than 2 letters
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)) {
            int size = FinishedWordBox.getWord().size();
            if (FinishedWordBox.checkWord()) { 
                FinishedWordBox.clearLetters();
                
                if (size > 1) {
                    GameWorld world = (GameWorld) getWorld();
                    if (world.getEnemy().isDead()) return;
                    world.getPlayer().attack();
                }
            } 
            else if (size > 0)
            {
                wrong.play();
            }
        }
    }    
    
    
}
