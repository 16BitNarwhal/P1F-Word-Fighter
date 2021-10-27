import greenfoot.*;
/**
 * Animation component of an actor
 * 
 */
public class Animation  
{
    private Actor actor;
    private GreenfootImage[] frames;
    private int numberFrames;
    private int fps;

    /**
     * Constructor for objects of class Animation
     */
    public Animation(Actor actor, String filepath, int numberFrames, int fps, double scale) {
        this.actor = actor;
        this.numberFrames = numberFrames;
        this.fps = fps;
        this.frames = new GreenfootImage[numberFrames];
        for (int i=0;i<numberFrames;i++) {
            this.frames[i] = new GreenfootImage(filepath + " (" + String.valueOf(i+1) + ").png");
            int w = this.frames[i].getWidth();
            int h = this.frames[i].getHeight();
            this.frames[i].scale((int)(w * scale), (int)(h * scale));
        }
    }
    
    private long frame = 0;
    /**
     * Animate method (should called on every act())
     */
    public void animate() {
        frame++;
        int fr = 60 / fps;
        frame %= fr * numberFrames;
        actor.setImage(frames[(int)(frame / fr)]);
    }
    
    /**
     * Getters and setters
     */
    public void resetFrame() { 
        frame = 0;
    }
    
    public int getFPS() { 
        return this.fps;
    }
    
}
