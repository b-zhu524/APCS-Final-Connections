/*
 * represents individual words. the game has 16 of them
 */

import java.util.*;

public class Word implements Comparable<Word>
{
    private String text;
    private boolean isFlipped;
    private static HashSet<Word> flippedWords;

    public Word(String text)
    {
        this.text = text;
        isFlipped = false;
    }

    public int compareTo(Word other)
    {
        return text.compareTo(other.getText());
    }

    public boolean equals(Word other)
    {
        return text.equals(other.getText());
    }

    // Getters
    public String getText()
    {
        return text;
    }

    // todo
    public boolean isCategory(Catetgory cat)
    {
    }

    public boolean isValid()
    {
        return !isFlipped;
    }
}
