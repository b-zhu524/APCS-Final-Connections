/*
 * represents individual words. the game has 16 of them
 */
public class Word {
    private String text;
    private Category category;
    boolean found;

    public Word(String txt, Category cat)
    {
        text = txt;
        category = cat;
        found = false;
    }

    // getters

    public String getText()
    {
        return text;
    }

    public Category getCategory()
    {
        return category;
    }

    // setters

    public void findWord()
    {
        found = true;
    }
}
