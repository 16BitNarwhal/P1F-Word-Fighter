import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Fighter class
 * Capable of attacking, losing health, and dying
 *  
 * @version (a version number or a date)
 */
public class Fighter extends Mover
{
    protected int hp, maxHp;
    protected int minAtk, maxAtk;
    protected Animation attackAnim, runAnim, idleAnim, deadAnim;
    
    /*
     * initialize fighter
     */
    public Fighter(Vector2 pos, float speed, int hp, int minAtk, int maxAtk) {
        super(pos, speed);
        this.maxHp = hp;
        this.hp = hp;
        this.minAtk = minAtk;
        this.maxAtk = maxAtk; 
    }
    
    public void act() {
        super.act();
        //runAnim.animate();
    }
    
    /*
     * deal (randomized) damage to an opponent
     */
    public void attack(Fighter opponent) {
        opponent.loseHp(Utils.random(this.minAtk, this.maxAtk));
    }
    
    /*
     * lose a certain amount of heatlh
     */
    public void loseHp(int atk) {
        this.hp -= atk;
        if (this.hp <= 0) {
            // dead
            getWorld().removeObject(this);
        }
    }
    
    /*
     * initialize anims
     * attack, run, idle
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
    
}
