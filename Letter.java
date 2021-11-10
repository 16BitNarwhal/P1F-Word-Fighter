import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo);
import java.util.ArrayList;
/**
 * Letter class
 * Moves around to make words
 * 
 */
public class Letter extends Mover
{
    private char[] consonants = {'b', 'c', 'd', 'f', 'g', 'h', 
                                'j', 'k', 'l', 'm', 'n', 'p', 
                                'q', 'r', 's', 't', 'v', 'w', 'x', 
                                'y', 'z'};
    private char[] vowels = {'a','e','i','o','u'};
    private boolean picked = false;
    private boolean moved = false;
    private Vector2 initPos; 
    private char letter;
    
    /**
     * Construct a letter
     * 
     * @param Vector2 initial position
     */
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
    
    /**
     * updates the letter's position
     */
    public void updatePos() {
        int idx = FinishedWordBox.getIndex(this);
        Vector2 newPos = new Vector2(525, 454);
        newPos.setX(newPos.getX() + idx * 100);
        this.setPos(newPos);
    }
    
    /**
     * returns the character held by the letter
     * @return character
     */
    public char getLetter() {
        return this.letter;
    }
    
    /**
     * reinitializes the letter with a new random character from a - z
     */
    public void newLetter() {
        this.picked = false;
        
        GreenfootImage theButton;
        if (Utils.random() <= 0.5) { // 50% chance of creating vowel
            int idx = Utils.random(vowels.length-1);
            letter = vowels[idx];
            theButton = new GreenfootImage("tileset/png/tiles/" + vowels[idx] + "_button.png");
        } else {
            int idx = Utils.random(consonants.length-1);
            letter = consonants[idx];
            theButton = new GreenfootImage("tileset/png/tiles/" + consonants[idx] + "_button.png");
        }
        
        theButton.scale(100, 100);
        this.setImage(theButton);
    }
}
