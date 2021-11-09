import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Zombie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NinjaM extends Enemy {
    public NinjaM() {
        super(10, 8, 10, 7);
        
        initAnim("ninja/male/Attack", 10,
            "ninja/male/Idle", 10,
            "ninja/male/Run", 10,
            "ninja/male/Dead", 10,
            10, 0.4f);
    } 
    
}
