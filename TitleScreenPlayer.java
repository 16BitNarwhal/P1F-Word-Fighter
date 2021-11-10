import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Player that contiously moves right (for the title screen)
 * 
 */
public class TitleScreenPlayer extends Player
{
    /**
     * Construct a TitleScreenPlayer
     */
    public TitleScreenPlayer() {
        super();
        setPos(new Vector2(0,400));
    }
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(pos.getX(), pos.getY());
        runAnim.animate();
        move(new Vector2(3, 0));
        if(getX() > 975)
        {
            setPos(new Vector2(0,400));
        }
    }    
}

