/*
 * represents a category of four words. there are four categories in the game.
 */

import java.util.*;

public class Category
{
    private String categoryName;
    private ArrayList<Word> words;
    boolean found;

    public Category(String name, ArrayList<Word> words)
    {
        categoryName = name;
        this.words = words;
        found = false;
    }

    // todo
    public boolean allFound(String word1, String word2, String w3, String w4)
    {
        return true;
    }

    // getters
    public String getCategory()
    {
        return categoryName;
    }

    public ArrayList<Word> getWords()
    {
        return words;
    }

    public boolean categoryIsFound()
    {
        return found;
    }

    // setters

    public void setFound(boolean status)
    {
        found = status;
    }
}
