// test frame --- not part of the connections game

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ViewConnections
{
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