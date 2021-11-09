import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Fighter class
 * Capable of attacking, losing health, and dying 
 * 
 */
public class Fighter extends Mover
{
    protected String state;
    protected int hp, maxHp;
    protected int minAtk, maxAtk; 
    protected Animation attackAnim, runAnim, idleAnim, deadAnim; 
    
    /**
     * Construct a Fighter
     * 
     * @param Vector2 initial position
     * @param int health
     * @param int minimum attack damage
     * @param int maximum attack damage
     */
    public Fighter(Vector2 pos, int hp, int minAtk, int maxAtk) {
        super(pos);
        this.maxHp = hp;
        this.hp = hp;
        this.minAtk = minAtk;
        this.maxAtk = maxAtk; 
        this.state = "enter";
    }
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        super.act();   
        if (isDead()) {
            deadAnim.animate();
            if (deadAnim.finishedAnim()) {
                getWorld().removeObject(this);
            }
        } 
    } 
    
    /**
     * deal (randomized) damage to an opponent
     * 
     * @param Fighter the opponent to deal damage to
     */
    public void attack(Fighter opponent) {
        opponent.loseHp(Utils.random(this.minAtk, this.maxAtk));
    }
    
    /**
     * lose a certain amount of health
     * 
     * @param int amount of health to lose
     */
    public void loseHp(int atk) {
        this.hp -= atk;
        if (this.hp<0) {
            this.hp=0;
        }
    }
    
    /**
     * initialize animations
     * 
     * @param String file path for attack animation
     * @param int number of frames in attack animation
     * @param String file path for idle animation
     * @param int number of frames in idle animation
     * @param String file path for running animation
     * @param int number of frames in running animation
     * @param String file path for death animation
     * @param int number of frames in death animation
     * @param int fps the all animations run at
     * @param float scale the size of each frame
     */
    protected void initAnim(String attackFilePath, int attackFrames,
                            String idleFilePath, int idleFrames,
                            String runFilePath, int runFrames,
                            String deadFilePath, int deadFrames,
                            int fps, float scale) {
        attackAnim = new Animation(this, attackFilePath, attackFrames, fps, scale);
        runAnim = new Animation(this, runFilePath, runFrames, fps, scale);
        idleAnim = new Animation(this, idleFilePath, idleFrames, fps, scale);
        deadAnim = new Animation(this, deadFilePath, deadFrames, fps, scale);
    }
    
    /**
     * set the visual direction of the fighter
     * 
     * @param int direction: 0 -> right, 1 -> left
     */
    protected void setAnimDir(int dir) {
        runAnim.setDir(dir);
        idleAnim.setDir(dir);
        attackAnim.setDir(dir);
        deadAnim.setDir(dir);
    }
    
    /**
     * returns fighter's current state
     * @return state
     */
    public String getState() { return this.state; }
    
    /**
     * returns whether the fighter's health has reached zero
     * @return isDead
     */
    public boolean isDead() { return this.hp <= 0; } 
    
    /**
     * returns the percentage of health lost (as a decimal)
     * @return health lost
     */
    public float getHpLoss() { return 1.0f - ((float)this.hp / (float)this.maxHp); }
    
    /**
     * returns current health
     * @return health
     */
    public int getHp() { return this.hp; }
    
}
