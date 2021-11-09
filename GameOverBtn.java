import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOverBtn here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOverBtn extends GUI {
    
    private World thisWorld;
    public GameOverBtn() {
        setImage(new GreenfootImage("/gui/tile062.png"));
        getImage().scale(200, 200);
        thisWorld = this.getWorld();
    }
    private int transparency=0;
    public void act() {
        if (transparency+2 <= 255) {
            getImage().setTransparency(transparency);
            transparency+=2;
        } else {
            if (Greenfoot.mouseClicked(this)) {
                Healthbar newPHealthBar = GameWorld.getPlayerHealthBar(); 
                GameWorld.setPBar(newPHealthBar);
                Greenfoot.setWorld(new GameWorld());
            }
        }
    }
}
