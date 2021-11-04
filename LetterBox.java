import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LetterBox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LetterBox extends GUI
{
    Letter[][] letters = new Letter[2][4];
    public LetterBox() {
        this.setImage("letter square.png");
        GreenfootImage image = getImage();
        image.scale(400, 240);
        
    }
    
    public void InitLetters() {
        Vector2 origin = new Vector2(60, 420);
        for (int i=0;i<2;i++) {
            for (int j=0;j<4;j++) {
                Vector2 initPos = new Vector2(origin.getX() + (j*100), origin.getY() + (i*100));
                Letter letter = new Letter(initPos);
                getWorld().addObject(letter, 0, 0);
                letters[i][j] = letter;
            }
        }
    }
    
    boolean firstAct = true;
    public void act() {
        if (firstAct) {
            InitLetters();
            firstAct = false;
        }
        
    }    

}
