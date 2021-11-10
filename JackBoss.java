import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Jack boss enemy that attacks player
 * 
 */
public class JackBoss extends Enemy {
    
    /**
     * Construct a JackBoss
     */
    public JackBoss() {
        // totally not overpowered
        super(10, 1, 100, 5);
        
        initAnim("jack/Slide", 10,
            "jack/Idle", 10,
            "jack/Run", 8,
            "jack/Dead", 10,
            10, 0.4f);
    } 
    
}
