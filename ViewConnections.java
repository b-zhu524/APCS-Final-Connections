import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ViewConnections
{
    private JButton b0;
    private JButton b1;
    private JButton b2;
    private JButton b3;
    private JButton b4;
    private JButton b5;
    private JButton b6;
    private JButton b7;
    private JButton b8;
    private JButton b9;
    private JButton b10;
    private JButton b11;
    private JButton b12;
    private JButton b13;
    private JButton b14;
    private JButton b15;

    public void setButtons(Word[] words)
    {        
        b0 = new JButton(words[0].getText());
        b1 = new JButton(words[1].getText());
        b2 = new JButton(words[2].getText());
        b3 = new JButton(words[3].getText());
        b4 = new JButton(words[4].getText());
        b5 = new JButton(words[5].getText());
        b6 = new JButton(words[6].getText());
        b7 = new JButton(words[7].getText());
        b8 = new JButton(words[8].getText());
        b9 = new JButton(words[9].getText());
        b10 = new JButton(words[10].getText());
        b11 = new JButton(words[11].getText());
        b12 = new JButton(words[12].getText());
        b13 = new JButton(words[13].getText());
        b14 = new JButton(words[14].getText());
        b15 = new JButton(words[15].getText());
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new GridLayout(4, 4));        

        for ( int i=0; i<16; i++ )
        {
            frame.add(new JButton("apple"));
        }

        frame.setVisible(true);
    }
}