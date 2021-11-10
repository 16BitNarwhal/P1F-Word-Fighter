import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 *
 */
public class FinishedWordBox extends GUI
{
    private static ArrayList<Letter> word;
    private static int maxLetters = 5;
    
    /**
     * The constructor for the finished word box.
     * Sets the image and size to 488 x 94 and initializes the arraylist that holds the word. 
     */
    public FinishedWordBox() {
        this.setImage("finishedWordBox.png");
        GreenfootImage image = getImage();
        image.scale(488, 94);
        word = new ArrayList<Letter>(); 
    }
    
    /**
     * Returns the index of a letter in the word arraylist.
     */
    public static int getIndex(Letter letter) {
        for (int i=0;i<word.size();i++) {
            if (letter == word.get(i)) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Removes a letter from the word arraylist and shifts everything back one index
     */
    public static void removeLetter(Letter letter) {
        word.remove(letter);
        for (int i=0;i<word.size();i++) {
            word.get(i).updatePos();
        }
    }
    
    /**
     * Adds a letter onto the back end of the word
     */
    public static void addLetter(Letter letter) {
        if (!isFull()) {
            word.add(letter);
            letter.updatePos();
        }
    }
    
    /**
     * Uses the word fetcher to check if the word in the arraylist is a valid word
     */
    public static boolean checkWord() {
        String str = "";
        for (Letter l : word) {
            str += l.getLetter();
        }
        return WordFetcher.checkWord(str);
    }
    
    /**
     * Clears all letters from the arraylist
     */
    public static void clearLetters() {
        for (int i=0;i<word.size();i++) {
            word.get(i).newLetter();
        }
        word.clear();         
    }
    
    /**
     * Returns if the array is full
     */
    public static boolean isFull() {
        return word.size()==maxLetters;
    }
    
    /**
     * Returns the arraylist containing the words
     */
    public static ArrayList<Letter> getWord() {
        return word;
    } 
}
