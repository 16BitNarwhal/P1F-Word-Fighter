import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Zombie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ZombieF extends Enemy
{
    public ZombieF() {
        super(16, 7, 10, 8);
        
        initAnim("zombie/female/Attack", 8,
            "zombie/female/Idle", 15,
            "zombie/female/Walk", 10,
            "zombie/female/Dead", 12,
            10, 0.4f);
    } 
    
}
