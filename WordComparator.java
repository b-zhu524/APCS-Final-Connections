import java.util.Comparator;

public class WordComparator implements Comparator<Word>
{
    public int compare(Word w1, Word w2)
    {
        return w1.getText().compareTo(w2.getText());
    }
}
