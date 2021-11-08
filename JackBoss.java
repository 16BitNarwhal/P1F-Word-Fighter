import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Zombie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JackBoss extends Enemy {
    
    public JackBoss() {
        // totally not overpowered
        super(10, 1, 100, 20);
        
        initAnim("jack/Slide", 10,
            "jack/Idle", 10,
            "jack/Run", 8,
            "jack/Dead", 10,
            10, 0.4f);
    } 
    
}
