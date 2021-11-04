import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * World where game will take place
 * 
 */
public class GameWorld extends World {
    
    private Player player;
    private Enemy enemy;
    GreenfootSound battle = new GreenfootSound("FightTheme.mp3");
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
        
        LetterBox letterbox = new LetterBox();
        addObject(letterbox, 210, 480);
        
        FinishedWordBox finishedwordbox = new FinishedWordBox();
        addObject(finishedwordbox, 722, 454); 
        
        CheckWordButton oK = new CheckWordButton();
        addObject(oK, 900, 544);
        
        WordFetcher.fetchWords();
    }
    
    public void act() {
        // enemy is null, new enemy, update score
        battle.playLoop();
    }
    
    /**
     * Getters and setters
     */
    public Player getPlayer() { return this.player; }    
    public Enemy getEnemy() { return this.enemy; }
}
