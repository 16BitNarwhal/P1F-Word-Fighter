import java.net.*;
import java.io.*;
import java.util.ArrayList;
/**
 * Write a description of class Word_Fetcher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordFetcher  
{
    // instance variables - replace the example below with your own
    private static String url = "https://raw.githubusercontent.com/first20hours/google-10000-english/master/google-10000-english-no-swears.txt";
    private static ArrayList<String> wordList;
    
    public static void readInto(ArrayList<String> list) throws Exception {
        URL wordsURL = new URL(url);
        BufferedReader in = new BufferedReader(
        new InputStreamReader(wordsURL.openStream()));
        String word;
        while ((word = in.readLine()) != null){
            list.add(word);
        }
        in.close();
    }
    
    /**
     * Fetch words in to arraylist
     */
    public static void fetchWords() {
        wordList = new ArrayList<String>();
        try {
            //problems with reading into method
            WordFetcher.readInto(wordList); 
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    
    public static ArrayList<String> getList() {
        return wordList;
    }
    
    public static boolean checkWord(String word) { 
        for(String str : wordList) {
            if (word.equals(str)) {
                return true;
            }
        }
        return false;
    }
    
}
