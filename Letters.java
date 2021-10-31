import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo);
import java.util.ArrayList;
/**
 * Letter class
 * For making words
 * 
 */
public class Letters extends Mover
{
    private char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 
                                'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 
                                'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 
                                'y', 'z'};
    private boolean state = true;
    private boolean moved = false;
    private Vector2 original = new Vector2(70, 405);
    public static Vector2 onTheLine = new Vector2(525, 454);
    public Letters(Vector2 initialPos) {
        super(onTheLine);
        int letter = Utils.random(25);
        GreenfootImage theButton = new GreenfootImage("tileset/png/tiles/" + alphabet[letter + 1] + "_button.png");
        theButton.scale(100, 100);
        this.setImage(theButton);
    }
    
    /**
     * Act - do whatever the Letters wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mousePressed(this))
        {
            state = !state;
        }
        if(state)
        {
            this.setPos(original);
            super.act();
        }
        else
        {
            this.setPos(onTheLine);
            super.act();
        }
    }
}
