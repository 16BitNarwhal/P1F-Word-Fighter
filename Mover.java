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
    
    /**
     * Construct a mover
     * 
     * @param Vector2 initial position
     */
    public Mover(Vector2 pos) {
        this.pos = pos; 
    }
    
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' butactton gets pressed in the environment.
     */
    public void act() {
        setLocation(pos.getX(), pos.getY()); 
    }
    
    /**
     * move entity by some vector
     * 
     * @param Vector2 movement
     */
    public void move(Vector2 movement) {
        pos = Vector2.add(pos, movement);
    }
    
    /**
     * move 1 step towards a target
     * 
     * @param Vector2 target
     * @param float speed
     */
    public void moveTowards(Vector2 target, float speed) {
        if (!touchingTarget(target)) {
            Vector2 dir = Vector2.sub(target, pos).normalize();
            move(dir.mult(speed));
        }
    }
    
    /**
     * sets the position of an entity
     * 
     * @param Vector2 movement
     */
    public void setPos(Vector2 movement) {
        pos = movement.get();
    } 
    
    /**
     * returns whether 'touching' a target
     * 
     * @param Vector2 target
     * @return touching
     */
    public boolean touchingTarget(Vector2 target) {
        return touchingTarget(target, 1);
    }
    
    /**
     * returns whether within a certain distance of a target
     * 
     * @param Vector2 target
     * @param float distance
     * @return touching
     */
    public boolean touchingTarget(Vector2 target, float dist) {
        // return true if there is no target
        if (target == null) return true;
        return (Vector2.distance(pos, target) <= dist);
    }
    
    /**
     * returns current position
     * @return position
     */
    public Vector2 getPos() { return this.pos; }
    
}
