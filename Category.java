/*
 * represents a category of four words. there are four categories in the game.
 */

import java.util.*;

public class Category
{
    private ArrayList<Word> words;
    private boolean grouped;
    private String categoyName;

    public Category(ArrayList<Word> words)
    {
        this.words = words;
        grouped = false;
    }
    
    /**
     * 
     * @return returns 1 if they're exactly equal
     * returns 0 if it's off by 1
     * returns -1 if it's off by more than 1
     */
    public int compareCategory(Category other)
    {
    }

    private void sortWords()
    {
        words.sort()
    }

    public String getName()
    {
        return categoyName;
    }

    public ArrayList<Word> getWords()
    {
        return words;
    }
}
