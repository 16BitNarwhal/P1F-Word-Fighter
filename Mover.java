import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Mover
 * Capable of moving
 * 
 * @version (a version number or a date)
 */
public class Mover extends Actor
{
    protected float moveSpeed;
    protected Vector2 pos;
    protected Vector2 target;
    
    /*
     * Initialize mover
     */
    public Mover(Vector2 pos, float speed) {
        this.pos = pos;
        this.moveSpeed = speed;
        this.target = null;
    }
    
    public void act() {
        setLocation(pos.getX(), pos.getY());
    }
    
    /*
     * move entity by some vector
     */
    public void move(Vector2 movement) {
        pos = Vector2.add(pos, movement);
    }
    
    /*
     * move 1 step towards a target
     */
    public void moveTowards(Vector2 target) {
        Vector2 dir = Vector2.sub(target, pos).normalize();
        move(dir.mult(this.moveSpeed));
    }
    
    /*
     * sets the position of an entity
     */
    public void setPos(Vector2 movement) {
        pos = movement.get();
    }
    
    /*
     * moves towards / follows an entity until stopped
     */
    public void follow(Vector2 target) {
        this.target = target; // reference the position of other entity
    }
    
    /*
     * stops following (if already following) by setting target to null
     */
    public void stopFollow() {
        this.target = null;
    }
    
    /*
     * returns whether 'touching' (or within a certain distance) of target
     */
    public boolean touchingTarget() {
        return touchingTarget(1);
    }
    
    public boolean touchingTarget(float dist) {
        // return true if there is no target
        if (this.target == null) return true;
        return (Vector2.distance(pos, target) <= dist);
    }
    
}
