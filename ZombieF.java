import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Zombie enemy (female ver.) that attacks player
 * 
 */
public class ZombieF extends Enemy
{
    /**
     * Construct a ZombieF
     */
    public ZombieF() {
        super(16, 7, 10, 8);
        
        initAnim("zombie/female/Attack", 8,
            "zombie/female/Idle", 15,
            "zombie/female/Walk", 10,
            "zombie/female/Dead", 12,
            10, 0.4f);
    } 
    
}
