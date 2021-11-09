import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Start here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Start extends GUI
{  
    public Start() {
        setImage(new GreenfootImage("/gui/tile002.png"));
        GreenfootImage image = getImage();
        image.scale(120,120);
        setImage(image); 
         
        MainSound.stop();
        MainSound.setSound(new GreenfootSound("mainMenu.mp3"));
        MainSound.play(); 
    }
    /**
     * Act - do whatever the Start wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    { 
        if(Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new Tutorial());
        }
        
    }
}
