import java.util.ArrayList;

public class GUIRunner {
    public static void main(String[] args) {
        ArrayList<Word> words = new ArrayList<>();
        String[] text = {"red", "yellow", "green", "blue", "banana", "apple", "watermelon", "berry", "shirt", "pants", "jacket", "socks", "hair", "eyes", "arm", "face"};
        for (String w : text)
        {
            words.add(new Word(w));
        }

        // Categories need to be in order of difficulty
        Category[] categories = new Category[4];


        Word[] colorWords = {new Word("red"), new Word("yellow"), new Word("green"), new Word("blue")};
        Category colors = new Category(colorWords, "COLORS", 0);

        Word[] fruitWords = {new Word("apple"), new Word("banana"), new Word("watermelon"), new Word("berry")};
        Category fruits = new Category(fruitWords, "FRUITS", 1);
        
        Word[] clothesWords = {new Word("shirt"), new Word("pants"), new Word("jacket"), new Word("socks")} ;
        Category clothing = new Category(clothesWords, "CLOTHES", 2);

        Word[] bodyWords = {new Word("hair"), new Word("eyes"), new Word("arm"), new Word("face")};
        Category body = new Category(bodyWords, "BODY PARTS", 3);

        // Word[] compWords = {new Word("yellow"), new Word("red"), new Word("green"), new Word("blue")};
        // Category comp = new Category(compWords, "COMPARE");
        // System.out.println(comp.equals(colors));

        // Word w = new Word("apple");
        // System.out.println(w.inCategory(fruits));

        categories[0] = colors;
        categories[1] = fruits;
        categories[2] = clothing;
        categories[3] = body;

        // TestingGUI vc = new TestingGUI(words, categories);
        // vc.setUpGUI();
        // vc.setUpButtonListeners();
        ViewConnections vc = new ViewConnections(words, categories);
        vc.setUpGUI();
        vc.setUpButtonListeners();
        
    }
}