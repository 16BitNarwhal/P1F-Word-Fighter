
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo);
import java.util.ArrayList;
/**
 * Letter class
 * For making words
 * 
 */
public class Letter extends Mover
{
    private char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 
                                'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 
                                'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 
                                'y', 'z'};
    private boolean picked = true;
    private boolean moved = false;
    private Vector2 original = new Vector2(70, 405);
    public static Vector2 onTheLine = new Vector2(525, 454);
    private char letter;
    
    public Letter(Vector2 initialPos) {
        super(onTheLine);
        int idx = Utils.random(25);
        letter = alphabet[idx];
        GreenfootImage theButton = new GreenfootImage("tileset/png/tiles/" + alphabet[idx] + "_button.png");
        theButton.scale(100, 100);
        this.setImage(theButton);
    }
    
    /**
     * Act - do whatever the Letters wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
        if(Greenfoot.mousePressed(this))
        {
            picked = !picked;
        }
        if(!picked) {
            this.setPos(original); 
        } else {
            this.setPos(onTheLine);
            int idx = FinishedWordBox.getIndex(this);
            // set position based on index
        }
    }
    
    public char getLetter() {
        return this.letter;
    }
}
