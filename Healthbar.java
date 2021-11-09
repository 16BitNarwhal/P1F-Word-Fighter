import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Heatlhbar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Healthbar extends GUI { 
    
    private Fighter fighter;
    private Image icon;
    private String location;
    private Image hpText;
    
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
    
    public void act() {
        // update health based on fighter health
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
    
    public void setFighter(Fighter fighter) {
        this.fighter = fighter;
    }
    
    public void removeHpText(){
        getWorld().removeObject(hpText);
    }
}
