import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class FinishedWordBox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FinishedWordBox extends GUI
{
    private static ArrayList<Letter> word;
    private static int maxLetters = 5;
    
    public FinishedWordBox() {
        this.setImage("finishedWordBox.png");
        GreenfootImage image = getImage();
        image.scale(488, 94);
        word = new ArrayList<Letter>(); 
    }
    
    public static int getIndex(Letter letter) {
        for (int i=0;i<word.size();i++) {
            if (letter == word.get(i)) {
                return i;
            }
        }
        return -1;
    }
    
    public static void removeLetter(Letter letter) {
        word.remove(letter);
        for (int i=0;i<word.size();i++) {
            word.get(i).updatePos();
        }
    }
    
    public static void addLetter(Letter letter) {
        if (!isFull()) {
            word.add(letter);
            letter.updatePos();
        }
    }
    
    public static void clearLetters() {
        word.clear();
    }
    
    public static boolean isFull() {
        return word.size()==maxLetters;
    }
    
    public static ArrayList<Letter> getWord() {
        return word;
    }
}
