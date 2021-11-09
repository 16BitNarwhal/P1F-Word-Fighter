import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Zombie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ZombieM extends Enemy
{
    public ZombieM() {
        super(20, 7, 1000, 10);
        
        initAnim("zombie/male/Attack", 8,
            "zombie/male/Idle", 15,
            "zombie/male/Walk", 10,
            "zombie/male/Dead", 12,
            10, 0.4f);
    } 
    
}
