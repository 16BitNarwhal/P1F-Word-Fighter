import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * World where game will take place
 * 
 */
public class GameWorld extends World {
    
    private int score=0;
    private Player player;
    private Enemy enemy;
    private LetterBox letterbox;
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
    
    private long beatTimer=0; // time to beat enemy
    private long enemyTimer=0; // time before spawn new enemy
    public void act() {
        
        // enemy is null, new enemy, update score
        if (enemy.isDead()) {
            enemyTimer++;
            if (enemyTimer > 60 * 3) {
                // random subclass (not zombie)
                enemy = new Zombie();
                addObject(enemy, 0, 0);
                enemyTimer=0;
                beatTimer=0;
                
            }
        } 
        
        beatTimer++;
        battle.playLoop();
        
    }
    
    /**
     * Getters and setters
     */
    public Player getPlayer() { return this.player; }    
    public Enemy getEnemy() { return this.enemy; }
    public LetterBox getLetterBox() { return this.letterbox; }
}
