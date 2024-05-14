/*
 * represents individual words. the game has 16 of them
 */
public class Word {
    private String text;
    boolean found;

    public Word(String txt)
    {
        text = txt;
        found = false;
    }

    // getters

    public String getText()
    {
        return text;
    }

    // setters

    public void findWord()
    {
        found = true;
    }
}
