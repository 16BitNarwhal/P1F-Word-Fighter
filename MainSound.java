import greenfoot.*; 
/**
 * Write a description of class SoundPlayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainSound {
    
    private static GreenfootSound sound;
    public static void setSound(GreenfootSound s) {
        sound = s;
    }
    
    public static void play() {
        sound.playLoop();
    }
    
    public static void stop() {
        try {
            sound.stop();  
        } catch (Exception e) {
            
        }
    }
    
}
