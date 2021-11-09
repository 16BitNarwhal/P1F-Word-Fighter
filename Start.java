import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *
 */
public class Start extends GUI
{  
    /**
     * Instantiates a new Start button.
     */
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
     * Checks each frame if it is pressed.
     * If so, change the world.
     */
    public void act() 
    { 
        if(Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new Tutorial());
        }
        
    }
}
