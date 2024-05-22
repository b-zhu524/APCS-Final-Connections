/*
 * represents a category of four words. there are four categories in the game.
 */

import java.util.*;

public class Category
{
    private Word[] words;
    private String categoryName;
    private int difficulty; // int between 0 - 3 inclusive

    /**
     * This constructor is only for the compareCategory method, where the difficulty and categoryName do not matter
     * @param words
     */
    public Category(Word[] words)
    {
        this.words = words;
        sortWords();
    }
    
    public Category(Word[] words, String catName, int difficulty)
    {
        this.words = words;
        sortWords();

        categoryName = catName;

        this.difficulty = difficulty;
    }
    
    /**
     * 
     * @return returns 1 if they're exactly equal
     * returns 0 if it's off by 1
     * returns -1 if it's off by more than 1
     */
    public int compareCategory(Category other)
    {
        other.sortWords();
        int numoff = 0;

        for ( int i=0; i<4; i++ )
        {
            if (!words[i].equals(other.getWords()[i]))
            {
                numoff++;
            }
        }

        if (numoff == 0)
        {
            return 1;
        }
        else if (numoff == 1)
        {
            return 0;
        }
        return -1;
    }

    private void sortWords()
    {
        Arrays.sort(words, new WordComparator());
    }

    /**
     * getter method for categoryName
     * @return the name of the category
     */
    public String getName()
    {
        return categoryName;
    }

    /**
     * getter method for Words field
     * @return Array of words
     */
    public Word[] getWords()
    {
        return words;
    }

    /**
     * getter method for the difficulty field
     * @return difficulty from 0-3 inclusive (0 being easiest, and 3 being hardest)
     */
    public int getDifficulty()
    {
        return difficulty;
    }

    public boolean equals(Category other)
    {
        sortWords();
        other.sortWords();
        for ( int i=0; i<words.length; i++ )
        {
            if (!words[i].equals(other.getWords()[i]))
            {
                return false;
            }
        }
        return true;
    }

    public void setWords(Word[] newWords)
    {
	    words = newWords;
    }

    public void setName(String newName)
    {
	    categoryName = newName;
    }

    /**
     * only for debugging
     * @return cName: words
     * EX: 
     * COLORS: blue green red yellow
     */
    public String getCategoryInfo()
    {
        String ret = "";
        ret += categoryName + ": ";
        for (int i=0; i<4; i++)
        {
            ret += words[i].getText().toUpperCase();
            if ( i < 3 )
            {
                ret += ", ";
            }
        }
        return ret;
    }
}
