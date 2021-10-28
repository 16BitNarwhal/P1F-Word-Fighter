import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Player class
 * Controls the player
 * 
 */
public class Player extends Fighter
{
    public Player() {
        super(new Vector2(100,100), 10, 100, 5, 10);
        
        initAnim("knight/Attack", 10,
            "knight/Idle", 10,
            "knight/Run", 10,
            "knight/Dead", 10, 
            10, 0.3f);
    }
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
    }    
}
