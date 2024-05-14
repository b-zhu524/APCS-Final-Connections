import java.awt.GridLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;


public class ViewConnections extends JFrame
{
    private JFrame frame;
    private ArrayList<JButton> clicked;

    private ArrayList<Word> words;

    private JButton button0;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton button10;
    private JButton button11;
    private JButton button12;
    private JButton button13;
    private JButton button14;
    private JButton button15;


    // no args constructor for testing only
    public ViewConnections()
    {
        button0 = new JButton("fruit");
        button1 = new JButton("fruit");
        button2 = new JButton("fruit");
        button3 = new JButton("fruit");
        button4 = new JButton("fruit");
        button5 = new JButton("fruit");
        button6 = new JButton("fruit");
        button7 = new JButton("fruit");
        button8 = new JButton("fruit");
        button9 = new JButton("fruit");
        button10 = new JButton("fruit");
        button11 = new JButton("fruit");
        button12 = new JButton("fruit");
        button13 = new JButton("fruit");
        button14 = new JButton("fruit");
        button15 = new JButton("fruit");
        
        frame = new JFrame();
        clicked = new ArrayList<>();
    }

    public ViewConnections(ArrayList<Word> words)
    {
        this.words = words;
        Collections.shuffle(words);
        button0 = new JButton(words.get(0).getText());
        button1 = new JButton(words.get(1).getText());
        button2 = new JButton(words.get(2).getText());
        button3 = new JButton(words.get(3).getText());
        button4 = new JButton(words.get(4).getText());
        button5 = new JButton(words.get(5).getText());
        button6 = new JButton(words.get(6).getText());
        button7 = new JButton(words.get(7).getText());
        button8 = new JButton(words.get(8).getText());
        button9 = new JButton(words.get(9).getText());
        button10 = new JButton(words.get(10).getText());
        button11 = new JButton(words.get(11).getText());
        button12 = new JButton(words.get(12).getText());
        button13 = new JButton(words.get(13).getText());
        button14 = new JButton(words.get(14).getText());
        button15 = new JButton(words.get(15).getText());

        frame = new JFrame();
        clicked = new ArrayList<>();
    }

    public void setUpGUI()
    {
        GridBagConstraints constraints = new GridBagConstraints();

        frame.setSize(500, 500);
        frame.setTitle("CONNECTIONS");
        frame.setBackground(Color.LIGHT_GRAY);
        frame.setLayout(new GridLayout(4, 4));

        frame.add(button0, constraints);
        frame.add(button1, constraints);
        frame.add(button2, constraints);
        frame.add(button3, constraints);
        frame.add(button4, constraints);
        frame.add(button5, constraints);
        frame.add(button6, constraints);
        frame.add(button7, constraints);
        frame.add(button8, constraints);
        frame.add(button9, constraints);
        frame.add(button10, constraints);
        frame.add(button11, constraints);
        frame.add(button12, constraints);
        frame.add(button13, constraints);
        frame.add(button14, constraints);
        frame.add(button15, constraints);
                
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void setUpButtonListeners()
    {
        ActionListener buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                JButton buttonClicked = (JButton) event.getSource();

                // if the button is already clicked, unclick it
                if (clicked.contains(buttonClicked))
                {
                    clicked.remove(buttonClicked);
                    buttonClicked.setBackground(Color.LIGHT_GRAY);
                    buttonClicked.setBorderPainted(true);
                    buttonClicked.setOpaque(false);
                }
                else
                {
                    if (clicked.size() < 4)
                    {
                        clicked.add(buttonClicked);
                        buttonClicked.setBackground(Color.LIGHT_GRAY);
                        buttonClicked.setOpaque(true);
                        buttonClicked.setBorderPainted(false);
                    }
                }

            }
        };
        button0.addActionListener(buttonListener);
        button1.addActionListener(buttonListener);
        button2.addActionListener(buttonListener);
        button3.addActionListener(buttonListener);
        button4.addActionListener(buttonListener);
        button5.addActionListener(buttonListener);
        button6.addActionListener(buttonListener);
        button7.addActionListener(buttonListener);
        button8.addActionListener(buttonListener);
        button9.addActionListener(buttonListener);
        button10.addActionListener(buttonListener);
        button11.addActionListener(buttonListener);
        button12.addActionListener(buttonListener);
        button13.addActionListener(buttonListener);
        button14.addActionListener(buttonListener);
        button15.addActionListener(buttonListener);
    }
}
