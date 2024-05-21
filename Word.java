/*
 * represents individual words. the game has 16 of them
 */

import java.util.*;

public class Word
{
    private String text;
    private boolean isFlipped;

    public Word(String text)
    {
        this.text = text.toUpperCase();
        isFlipped = false;
    }

    public boolean equals(Word other)
    {
        return text.equals(other.getText());
    }

    public boolean inCategory(Category parent)
    {
        for ( Word w : parent.getWords() )
        {
            if (w.equals(this))
            {
                return true;
            }
        }
        return false;
    }

    // Getters
    public String getText()
    {
        return text;
    }

    public boolean isValid()
    {
        return !isFlipped;
    }
}
