import java.net.*;
import java.io.*;
import java.util.ArrayList;
/**
 * WordFetcher class for fetching words from the internet
 * 
 */
public class WordFetcher  
{ 
    private static String url = "https://raw.githubusercontent.com/first20hours/google-10000-english/master/google-10000-english-no-swears.txt";
    private static ArrayList<String> wordList;
    
    /**
     * Reads the words from url into a list
     * 
     * @param ArrayList<String> list
     */
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
     * Fetch words in to static arraylist
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
    
    /**
     * Returns the word list
     * @return list
     */
    public static ArrayList<String> getList() {
        return wordList;
    }
    
    /**
     * Checks if the given word is valid (in the list of words)
     * @return word in list
     */
    public static boolean checkWord(String word) { 
        for(String str : wordList) {
            if (word.equals(str)) {
                return true;
            }
        }
        return false;
    }
    
}
