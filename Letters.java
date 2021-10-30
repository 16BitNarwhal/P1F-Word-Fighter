import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Letter class
 * For making words
 * 
 */
public class Letters extends Mover
{
    private boolean state = true;
    private boolean moved = false;
    private Vector2 original = new Vector2(180, 320);
    public static Vector2 onTheLine = new Vector2(619, 454);
    private GreenfootImage buttonA = new GreenfootImage("aButton.png");
    public Letters(Vector2 initialPos) {
        super(onTheLine);
        buttonA.scale(100, 80);
        this.setImage(buttonA);
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
            System.out.println("Clicked!" + state);
        }
        if(state)
        {
            this.setPos(original);
        }
        else
        {
            this.setPos(onTheLine);
            System.out.println("pos changed");
        }
    }
}
