import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 */

public class Image extends GUI {
    
    private static ArrayList<Image> allImages = new ArrayList<Image>();
    
    private Actor parent;
    private Vector2 pos, offset;
    
    /**
     * Instantiates a new Image object.
     */
    public Image(Actor pa, GreenfootImage image) {
        this(pa, image, new Vector2());
    }
    
    /**
     * Instantiates a new Image object. 2nd Constructor.
     */
    public Image(Actor pa, GreenfootImage image, Vector2 offset) {
        this.parent = pa; 
        setImage(image);
        this.offset = offset;
        allImages.add(this);
    }
    
    /**
     * Tries to set its location every frame
     */
    public void act() {
        try { 
            pos = Vector2.add(new Vector2(this.parent.getX(), this.parent.getY()), offset);
            setLocation(pos.getX(), pos.getY());
        } catch(Exception e) {
            
        }
    }
    
    /**
     * Returns the arraylist of all images.
     */
    public static ArrayList<Image> getAllImages() {
        return allImages;
    }
    
    /**
     * Clears all images.
     */
    public static void clearImages() {
        allImages.clear();
    }
    
    /**
     * Returns the parent of the object
     */
    public Actor getParent() {
        return this.parent;
    }
    
}
