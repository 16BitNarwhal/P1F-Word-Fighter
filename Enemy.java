import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Enemy fights and attacks the player
 * 
 */
public class Enemy extends Fighter
{
    private long atkCooldown;
    private long atkTimer;
    private Player player;
    private GreenfootSound hit = new GreenfootSound("hurt.mp3");
    
    /**
     * Construct an enemy
     * 
     * @param int Health
     * @param int Minimum attack damage
     * @param int Maximum attack damage
     * @param float Cooldown time between attacks
     */
    public Enemy(int hp, int minAtk, int maxAtk, float atkCooldown) {
        super(new Vector2(1000, 250), hp, minAtk, maxAtk);
        this.atkCooldown = (long)(atkCooldown * 60f);
        this.atkTimer = 0;
         
    }
    
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' butactton gets pressed in the environment.
     */
    public void act() {
        super.act();
        if (this.isDead()) {
            return;
        }
        if (this.state == "enter") { 
            GameWorld world = (GameWorld) getWorld();
            player = world.getPlayer(); 
            setAnimDir(1);
            
            runAnim.animate();
            moveTowards(new Vector2(850, 250), 2.5f);
            
            if (touchingTarget(new Vector2(850, 250))) {
                this.state = "idle";
                runAnim.resetFrame();
            }
        } else if (this.state == "idle") {
            if (!touchingTarget(new Vector2(850, 250))) {
                runAnim.animate();
                moveTowards(new Vector2(850, 250), 15);
            } else {
                idleAnim.animate();
            }
            
            this.atkTimer++;
            if (this.atkTimer >= this.atkCooldown && !player.isDead() && player.getState() == "idle") {
                this.state = "attack";
                this.atkTimer = 0;
                idleAnim.resetFrame();
                runAnim.resetFrame();
            }
             
        } else if (this.state == "attack") {
            if (!touchingTarget(player.getPos(), 50)) {
                runAnim.animate();
                moveTowards(player.getPos(), 15);
            } else {
                attackAnim.animate();
                if (attackAnim.finishedAnim()) { 
                    GameWorld world = (GameWorld) getWorld();
                    attack(world.getPlayer());
                    hit.play();
                    this.state = "idle";
                    attackAnim.resetFrame();
                    runAnim.resetFrame();
                }
            }  
        }
    }    
    
    /**
     * increase health and strength by player's score
     * 
     * @param int Player's current score
     */
    public void setDifficulty(int playerScore) {
        this.maxHp += (int)((float) playerScore / 7f);
        this.hp = maxHp;
        this.minAtk += (int)((float) playerScore / 15f);
        this.maxAtk += (int)((float) playerScore / 15f);
    }
    
    /**
     * Return score (to give to player) based off attack damage and health
     * 
     * @return Combat score
     */
    public int getCombatScore() {
        float h = (float) maxHp / 5f;
        float a = (float) Utils.random(minAtk, maxAtk) / 2f;
        return (int)(a+h);
    }
    
}
