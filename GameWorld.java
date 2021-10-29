import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * World where game will take place
 * 
 */
public class GameWorld extends World {
    
    private Player player;
    private Enemy enemy;
    
    /**
     * Constructor for objects of class GameWorld.
     * 
     */
    public GameWorld() {     
        super(1000, 600, 1); 
        setBackground(new GreenfootImage("gameBackground.png"));
        player = new Player();
        addObject(player, 0, 0);
        
        enemy = new Zombie();
        addObject(enemy, 0, 0);
    }
    
    public void act() {
        // enemy is null, new enemy, update score
    }
    
    /**
     * Getters and setters
     */
    public Player getPlayer() { return this.player; }    
    public Enemy getEnemy() { return this.enemy; }
}
