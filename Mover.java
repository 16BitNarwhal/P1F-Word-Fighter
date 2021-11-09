import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Mover
 * Capable of moving
 * 
 * @version (a version number or a date)
 */
public class Mover extends Actor
{
    protected Vector2 pos;
    
    /*
     * Initialize mover
     */
    public Mover(Vector2 pos) {
        this.pos = pos; 
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
    
    /**
     * move 1 step towards a target
     */
    public void moveTowards(Vector2 target, float speed) {
        if (!touchingTarget(target)) {
            Vector2 dir = Vector2.sub(target, pos).normalize();
            move(dir.mult(speed));
        }
    }
    
    /**
     * sets the position of an entity
     */
    public void setPos(Vector2 movement) {
        pos = movement.get();
    } 
    
    /**
     * returns whether 'touching' (or within a certain distance) of target
     */
    public boolean touchingTarget(Vector2 target) {
        return touchingTarget(target, 1);
    }
    
    public boolean touchingTarget(Vector2 target, float dist) {
        // return true if there is no target
        if (target == null) return true;
        return (Vector2.distance(pos, target) <= dist);
    }
    
    /**
     * getters and setters
     */
    public Vector2 getPos() { return this.pos; }
    
}
