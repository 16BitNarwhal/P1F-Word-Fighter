import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * World where game will take place
 * 
 */
public class GameWorld extends World {
    
    private int score=0, enemyScore;
    private Player player;
    private Enemy enemy;
    public static Healthbar playerHealthbar, enemyHealthbar;
    private LetterBox letterbox; ;
    private Image scoreText;
    private Image scoreT; 
    
    /**
     * Constructor for objects of class GameWorld.
     * 
     */
    public GameWorld() {     
        super(1000, 600, 1); 
        setBackground(new GreenfootImage("gameBackground.png"));
        Image.clearImages();

        player = new Player();
        addObject(player, 0, 0);
        playerHealthbar = new Healthbar(player, "left");
        addObject(playerHealthbar, 220, 80);
        
        enemy = new ZombieM();
        addObject(enemy, 0, 0);
        enemyScore = enemy.getCombatScore();
        enemyHealthbar = new Healthbar(enemy, "right");
        addObject(enemyHealthbar, 780, 80); 
        
        scoreT = new Image(null, new GreenfootImage("SCORE", 50, Color.WHITE, new Color(0,0,0,0)));
        addObject(scoreT, 500, 30);
        scoreText = new Image(null, new GreenfootImage("0", 50, Color.WHITE, new Color(0,0,0,0)));
        addObject(scoreText, 500, 80);
        
        LetterBox letterbox = new LetterBox();
        addObject(letterbox, 210, 480);
        
        FinishedWordBox finishedwordbox = new FinishedWordBox();
        addObject(finishedwordbox, 722, 454); 
        
        CheckWordButton checkButton = new CheckWordButton();
        addObject(checkButton, 900, 544);
        
        WordFetcher.fetchWords(); 
                
        for (Image img : Image.getAllImages()) { 
            addObject(img, 0, 0);
        }
        
        MainSound.stop();
        MainSound.setSound(new GreenfootSound("FightTheme.mp3"));
        MainSound.play();
    }
    
    private long beatTimer=0; // time to beat enemy
    private long enemyTimer=0; // time before spawn new enemy
    private boolean finishedGame=false;
    /**
     * Adds an enemy for the player to battle whenever the previous enemy is dead.
     * If the player is dead, end the game and display "GAME OVER"
     */
    public void act() {
        
        // player is null, gameover
        if (player.isDead()) {
            if (!finishedGame) {
                GameOver gameOverText = new GameOver(new Vector2(500, 380));
                addObject(gameOverText, 0, 0);
                
                GameOverBtn gameOverBtn = new GameOverBtn();
                addObject(gameOverBtn, 500, 400);
                
                finishedGame = true;
            }
        }
        
        // enemy is null, new enemy, update score
        if (enemy.isDead()) {
            enemyTimer++;
            if (enemyTimer > 60 * 3) {
                if (Utils.random() <= 0.10) { // 10% chance spawning boss
                    enemy = new JackBoss();
                } else {
                    Enemy[] chooseFrom = { new ZombieM(), new ZombieF(), new NinjaM(), new NinjaF() };
                    int idx = Utils.random(0, chooseFrom.length-1);
                    enemy = chooseFrom[idx];
                } 
                enemy.setDifficulty(score);
                enemyHealthbar.setFighter(enemy);
                addObject(enemy, 0, 0);
                enemyTimer=0;
                
                enemyScore = enemy.getCombatScore();
                score += enemyScore;
                scoreText.setImage(new GreenfootImage(String.valueOf(score), 50, Color.WHITE, new Color(0,0,0,0)));
                beatTimer=0; 
            } 
        }
        
        beatTimer++; 
        
    }
    
    /**
     * returns the world's player
     * @return player
     */
    public Player getPlayer() { return this.player; }
    
    /**
     * returns the current enemy
     * @return enemy
     */
    public Enemy getEnemy() { return this.enemy; }
    
    /**
     * returns the box containing letters
     * @return letter box
     */
    public LetterBox getLetterBox() { return this.letterbox; }
    
    /**
     * returns the player's health bar
     * @return player healthbar
     */
    public static Healthbar getPlayerHealthBar(){return playerHealthbar;}
    
    /**
     * returns the enemy's health bar
     * @return enemy healthbar
     */
    public static Healthbar getEnemyHealthBar(){return enemyHealthbar;}
    
    /**
     * sets the player health bar
     * @param Healthbar healthbar
     */
    public static void setPBar(Healthbar healthbar) 
    {
        playerHealthbar = healthbar;
    }
}
