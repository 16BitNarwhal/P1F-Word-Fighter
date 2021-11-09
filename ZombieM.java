import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Zombie enemy (male ver.) that attacks player
 * 
 */
public class ZombieM extends Enemy
{
    /**
     * Construct a ZombieM
     */
    public ZombieM() {
        super(20, 7, 10, 10);
        
        initAnim("zombie/male/Attack", 8,
            "zombie/male/Idle", 15,
            "zombie/male/Walk", 10,
            "zombie/male/Dead", 12,
            10, 0.4f);
    } 
    
}
