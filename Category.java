/*
 * represents a category of four words. there are four categories in the game.
 */

import java.util.*;

public class Category
{
    private Word[] words;
    private String categoryName;

    public Category()
    {
        words = new Word[4];
        categoryName = new String();
    }
    
    public Category(Word[] words, String catName)
    {
        this.words = words;
        sortWords();

        categoryName = catName;
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
        // sort words;
        Arrays.sort(words, new WordComparator());
    }

    public String getName()
    {
        return categoryName;
    }

    public Word[] getWords()
    {
        return words;
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
    public String printCategory()
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
