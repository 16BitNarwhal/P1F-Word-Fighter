import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 */
public class GameOver extends GUI {
    
    private Vector2 pos = new Vector2(500, 600);
    private Vector2 targetPos;
    
    /**
     * Displays that the game is indeed over
     */
    public GameOver(Vector2 targetPos) {
        setImage(new GreenfootImage("gameOverText.png"));
        this.targetPos = targetPos;
    }
    
    /**
     * Slowly goes up from the low position
     */
    public void act() {
        setLocation(pos.getX(), pos.getY());
        if (Vector2.distance(pos, targetPos) > 1f) {
            Vector2 dir = Vector2.sub(targetPos, pos);
            dir = dir.normalize();
            pos = Vector2.add(pos, dir.mult(2));
        }
    }
    
}
