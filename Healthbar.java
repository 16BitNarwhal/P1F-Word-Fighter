import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/** 
 */
public class Healthbar extends GUI { 
    
    private Fighter fighter;
    private Image icon;
    private String location;
    private Image hpText;
    
    /**
     * Starts a new healthbar, changing the location of the icon depending on if it is the player healthbar or enemy healthbar
     */
    public Healthbar(Fighter fighter, String loc) {
        this.fighter = fighter;
        this.location = loc;
        setImage(new GreenfootImage("healthbarBg.png"));
        
        GreenfootImage img;
        Vector2 pos;
        if (this.location == "left") {
            img = new GreenfootImage("knight/knightIcon.png");
            pos = new Vector2(-130, 0);
        } else {
            img = new GreenfootImage("zombie/male/zombieMIcon.png"); 
            pos = new Vector2(130, 0);
        }
        img.scale(130, 130);
        icon = new Image(this, img, pos);
        hpText = new Image(this, new GreenfootImage(String.valueOf(fighter.getHp()), 50, Color.WHITE, new Color(0,0,0,0)));
    }
    
    /**
     * Updates the health every second
     */
    public void act() {
        setImage(new GreenfootImage("healthbarBg.png"));
        GreenfootImage fill = getImage();
        fill.setColor(Color.RED); 
        int loss = (int)(290f * fighter.getHpLoss());
        if (this.location == "left") {
            fill.fillRect(33, 18, 290 - loss, 50);
        } else {
            fill.fillRect(33 + loss, 18, 290 - loss, 50);
        }
        
        hpText.setImage(new GreenfootImage(String.valueOf(fighter.getHp()), 50, Color.WHITE, new Color(0,0,0,0)));
    }
    
    /**
     * Sets the icon
     */
    public void setFighter(Fighter fighter) {
        this.fighter = fighter;
    }
}
