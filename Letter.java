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
    private boolean picked = false;
    private boolean moved = false;
    private Vector2 initPos; 
    private char letter;
    
    public Letter(Vector2 initialPos) {
        super(initialPos);
        this.initPos = initialPos;
        
        newLetter();
    }
    
    /**
     * Act - do whatever the Letters wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
        if(Greenfoot.mousePressed(this)) {
            picked = !picked;
            if (FinishedWordBox.isFull()) {
                picked = false;
            }
            
            if (picked) {
                FinishedWordBox.addLetter(this);
            } else {
                FinishedWordBox.removeLetter(this);
            }
            
        }
        if(!picked) {
            this.setPos(this.initPos);
        }
    }
    
    public void updatePos() {
        int idx = FinishedWordBox.getIndex(this);
        Vector2 newPos = new Vector2(525, 454);
        newPos.setX(newPos.getX() + idx * 100);
        this.setPos(newPos);
    }
    
    public char getLetter() {
        return this.letter;
    }
    
    public void newLetter() {
        this.picked = false;
        
        int idx = Utils.random(25);
        letter = alphabet[idx];
        GreenfootImage theButton = new GreenfootImage("tileset/png/tiles/" + alphabet[idx] + "_button.png");
        theButton.scale(100, 100);
        this.setImage(theButton);
    }
}
