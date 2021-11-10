import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Ninja enemy (female ver.) that attacks player
 * 
 */
public class NinjaF extends Enemy {
    
    /**
     * Constructs a NinjaF
     */
    public NinjaF() {
        super(10, 7, 9, 5);
        
        initAnim("ninja/female/Attack", 10,
            "ninja/female/Idle", 10,
            "ninja/female/Run", 10,
            "ninja/female/Dead", 10,
            10, 0.4f);
    } 
    
}
