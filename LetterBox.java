import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *
 */
public class LetterBox extends GUI
{
    private Letter[][] letters = new Letter[2][4];

    /**
     * Instantiates a new 400x240 LetterBox. 
     */
    public LetterBox() {
        this.setImage("letter square.png");
        GreenfootImage image = getImage();
        image.scale(400, 240);
        
    }
    
    /**
     * Fills the letterbox with letters
     */
    public void InitLetters() {
        Vector2 origin = new Vector2(60, 420);
        for (int i=0;i<2;i++) {
            for (int j=0;j<4;j++) {
                Vector2 initPos = new Vector2(origin.getX() + (j*100), origin.getY() + (i*100));
                Letter letter = new Letter(initPos);
                getWorld().addObject(letter, 0, 0);
                letters[i][j] = letter;
            }
        }
    }
    
    boolean firstAct = true;
    /**
     * Runs every frame.
     * If this is the first action, run.
     */
    public void act() {
        if (firstAct) {
            InitLetters();
            firstAct = false;
        }
    }
    
    /**
     * Checks if there is a valid word in the box.
     */
    public boolean checkLetters() {
        char[] arr = new char[8];
        for (int i=0;i<2;i++) {
            for (int j=0;j<4;j++) {
                arr[i*4 + j] = letters[i][j].getLetter();
            }
        }
        String s="";
        for (int i=0;i<8;i++) {
            s += arr[i];
            for (int j=0;j<8;j++) {
                if (i==j) continue;
                s += arr[j];
                for (int k=0;k<8;k++) {
                    if (i==k || j==k) continue;
                    s += arr[k];
                    if (WordFetcher.checkWord(s)) {
                        return true;
                    }
                    s = s.substring(0, s.length()-1);
                }
                s = s.substring(0, s.length()-1);
            }
            s = s.substring(0, s.length()-1);
        }
        return false;
    }

}
