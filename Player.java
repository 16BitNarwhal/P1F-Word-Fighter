import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Player class
 * Controls the player
 * 
 */
public class Player extends Fighter
{
    private Enemy enemy; 
    private GreenfootSound sword = new GreenfootSound("swordSlash.mp3");
    public Player() {
        super(new Vector2(0,250), 100, 5, 10);
        
        initAnim("knight/Attack", 10,
            "knight/Idle", 10,
            "knight/Run", 10,
            "knight/Dead", 10, 
            10, 0.3f);
    }
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        super.act();
        if (this.isDead()) {
            return;
        }
        if (this.state == "enter") {
            GameWorld world = (GameWorld) getWorld();
            enemy = world.getEnemy();
            setAnimDir(0);
            
            runAnim.animate();
            moveTowards(new Vector2(200, 250), 2.5f);
            
            if (touchingTarget(new Vector2(200, 250))) {
                this.state = "idle";
                runAnim.resetFrame();
            }
        } else if (this.state == "idle") {
            if (!touchingTarget(new Vector2(200, 250))) {
                runAnim.animate();
                moveTowards(new Vector2(200, 250), 15);
            } else {
                idleAnim.animate();
            }
             
            // activate letters / words
            // deactivate letters while enemy or player is attacking
            // if make word, animate attack 
        } else if (this.state == "attack") {
            if (!touchingTarget(enemy.getPos(), 50)) {
                runAnim.animate();
                moveTowards(enemy.getPos(), 15);
            } else {
                attackAnim.animate();
                if (attackAnim.finishedAnim()) {
                    // enemy.losehealth
                    GameWorld world = (GameWorld) getWorld();
                    super.attack(world.getEnemy());
                    sword.play();
                    this.state = "idle"; 
                    attackAnim.resetFrame();
                    runAnim.resetFrame();
                }
            }
        }
    }
    
    public void attack() { 
        this.state = "attack";
        runAnim.resetFrame();
        idleAnim.resetFrame();
    }
}
