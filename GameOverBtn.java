import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 */
public class GameOverBtn extends GUI {
    
    private World thisWorld;

    /**
     *  Instantiates a new 200 x 200 game over button
     */
    public GameOverBtn() {
        setImage(new GreenfootImage("/gui/tile062.png"));
        getImage().scale(200, 200);
        thisWorld = this.getWorld();
    }
    private int transparency=0;

    /**
     * Fades into the scene
     */
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
