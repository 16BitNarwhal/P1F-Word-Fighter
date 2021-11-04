import java.net.*;
import java.io.*;
import java.util.ArrayList;
/**
 * Write a description of class Word_Fetcher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Word_Fetcher  
{
    // instance variables - replace the example below with your own
    static String url = "https://raw.githubusercontent.com/first20hours/google-10000-english/master/google-10000-english-no-swears.txt";
    static ArrayList<String> myList;
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
     * Constructor for objects of class Word_Fetcher
     */
    public Word_Fetcher()
    {
        ArrayList<String> myList = new ArrayList<String>();
        try{
            //problems with reading into method
            Word_Fetcher.readInto(myList);
            } catch(Exception e) {
        }
        //myList now has a list of a ton of words in it
    }
    public static ArrayList<String> getList(){
        return myList;
    }
    public static boolean checkWord(String word)
    {
        for(String strung : myList)
        {
            if(word.equals(strung))
            {
                return true;
            }
        }
        return false;
    }
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return y;
    }
}
