import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.Insets;
import java.awt.BorderLayout;


/*
 * GUI for the Connections Game
 */
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

    private JButton submit;


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
    
        submit = new JButton("SUBMIT");

        frame = new JFrame();
        clicked = new ArrayList<>();
    }

    public void setUpGUI()
    {
        GridBagConstraints constraints = new GridBagConstraints(); // none so far

        frame.setSize(500, 500);
        frame.setTitle("CONNECTIONS");
        frame.setBackground(Color.LIGHT_GRAY);

        JPanel wordGrid = new JPanel();
        wordGrid.setLayout(new GridLayout(4, 4));

        JPanel bottomGrid = new JPanel();
        bottomGrid.setLayout(new GridLayout(1, 1));
        bottomGrid.setPreferredSize(new Dimension(120, 120));
        
        bottomGrid.add(submit);

        wordGrid.add(button0, constraints);
        wordGrid.add(button1, constraints);
        wordGrid.add(button2, constraints);
        wordGrid.add(button3, constraints);
        wordGrid.add(button4, constraints);
        wordGrid.add(button5, constraints);
        wordGrid.add(button6, constraints);
        wordGrid.add(button7, constraints);
        wordGrid.add(button8, constraints);
        wordGrid.add(button9, constraints);
        wordGrid.add(button10, constraints);
        wordGrid.add(button11, constraints);
        wordGrid.add(button12, constraints);
        wordGrid.add(button13, constraints);
        wordGrid.add(button14, constraints);
        wordGrid.add(button15, constraints);

        frame.add(bottomGrid, BorderLayout.SOUTH);
        frame.add(wordGrid);

        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void setUpButtonListeners()
    {
        ActionListener buttonListener = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                JButton buttonClicked = (JButton) event.getSource();

                if (buttonClicked.equals(submit))
                {
                    // add if condition (if (clicked.size() >= 4))
                    buttonClicked.setBackground(Color.green);
                    buttonClicked.setOpaque(true);
                    buttonClicked.setBorderPainted(false);

                    // timer to change the color back

                    // checkWords
                }
                else
                {
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
                            buttonClicked.setBackground(Color.yellow);
                            buttonClicked.setOpaque(true);
                            buttonClicked.setBorderPainted(false);
                        }
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

        submit.addActionListener(buttonListener);
    }


    private boolean isCategory()
    {
        return true;
    }

    private void rearrangeCategory()
    {

    }
}

