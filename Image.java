import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class Image here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Image extends GUI {
    
    private static ArrayList<Image> allImages = new ArrayList<Image>();
    
    private Actor parent;
    private Vector2 pos, offset;
    
    public Image(Actor pa, GreenfootImage image) {
        this(pa, image, new Vector2());
    }
    
    public Image(Actor pa, GreenfootImage image, Vector2 offset) {
        this.parent = pa; 
        setImage(image);
        this.offset = offset;
        allImages.add(this);
    }
    
    public void act() {
        try { 
            pos = Vector2.add(new Vector2(this.parent.getX(), this.parent.getY()), offset);
            setLocation(pos.getX(), pos.getY());
        } catch(Exception e) {
            
        }
    }
    
    public static ArrayList<Image> getAllImages() {
        return allImages;
    }
    
    public static void clearImages() {
        allImages.clear();
    }
    
    public Actor getParent() {
        return this.parent;
    }
    
}
