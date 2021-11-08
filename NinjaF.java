import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Zombie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NinjaF extends Enemy {
    public NinjaF() {
        super(10, 7, 9, 5);
        
        initAnim("ninja/female/Attack", 10,
            "ninja/female/Idle", 10,
            "ninja/female/Run", 10,
            "ninja/female/Dead", 10,
            10, 0.4f);
    } 
    
}
