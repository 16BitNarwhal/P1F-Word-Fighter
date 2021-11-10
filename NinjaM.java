import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Ninja enemy (male ver.) that attacks the player
 */
public class NinjaM extends Enemy {
    
    /**
     * Construct a NinjaM
     */
    public NinjaM() {
        super(10, 8, 10, 7);
        
        initAnim("ninja/male/Attack", 10,
            "ninja/male/Idle", 10,
            "ninja/male/Run", 10,
            "ninja/male/Dead", 10,
            10, 0.4f);
    } 
    
}
