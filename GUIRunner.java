import java.util.ArrayList;

public class GUIRunner {
    public static void main(String[] args) {
        ArrayList<Word> words = new ArrayList<>();
        String[] text = {"red", "yellow", "green", "blue", "banana", "apple", "watermelon", "berry", "shirt", "pants", "jacket", "socks", "hair", "eyes", "arm", "face"};
        for (String w : text)
        {
            words.add(new Word(w));
        }

        ViewConnections vc = new ViewConnections(words);
        vc.setUpGUI();
        vc.setUpButtonListeners();
    }
}