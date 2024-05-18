import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.Insets;
import java.awt.BorderLayout;


/*
 * GUI for the Connections Game
 */
public class TestingGUI extends JFrame
{
    private JFrame frame;

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
    private JLabel triesLabel;

    private ArrayList<JButton> clicked;
    private ArrayList<Word> wordsClicked;
    private int numRowsGuessed;
    private ArrayList<Category> categories;
    private int numTries;


    public TestingGUI(ArrayList<Word> words, ArrayList<Category> cat)
    {
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
        wordsClicked = new ArrayList<>();
        categories = cat;
        
        numTries = 4;
        numRowsGuessed = 0;

        triesLabel = new JLabel("Tries Left: " + numTries, JLabel.CENTER);
    }


    public void setUpGUI()
    {
        // set up the frame
        frame.setSize(500, 500);
        frame.setTitle("CONNECTIONS");
        frame.setBackground(Color.LIGHT_GRAY);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        // set up the words grid
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        JPanel row1 = new JPanel();
        row1.setLayout(new GridLayout(1, 4));
        row1.add(button0);
        row1.add(button1);
        row1.add(button2);
        row1.add(button3);
        container.add(row1);

        JPanel row2 = new JPanel();
        row2.setLayout(new GridLayout(1, 4));
        row2.add(button4);
        row2.add(button5);
        row2.add(button6);
        row2.add(button7);
        container.add(row2);

        JPanel row3 = new JPanel();
        row3.setLayout(new GridLayout(1, 4));
        row3.add(button8);
        row3.add(button9);
        row3.add(button10);
        row3.add(button11);
        container.add(row3);
	

        JPanel row4 = new JPanel();
        row4.setLayout(new GridLayout(1, 4));
        row4.add(button12);
        row4.add(button13);
        row4.add(button14);
        row4.add(button15);
        container.add(row4);
	

        // add to bottomgrid
        JPanel bottomGrid = new JPanel();
        bottomGrid.setLayout(new GridLayout(1, 1));
        bottomGrid.setPreferredSize(new Dimension(120, 120));
        
        bottomGrid.add(submit);
        bottomGrid.add(triesLabel);

        frame.add(bottomGrid, BorderLayout.SOUTH);
        frame.add(container);

        // run
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
                String wordText = buttonClicked.getText();
                Word clickedWord = new Word(wordText);

                // can't click flipped words
                if (!clickedWord.isValid())
                {
                    return;
                }

                if (buttonClicked.equals(submit))
                {
                    if (clicked.size() == 4)
                    {
                        buttonClicked.setBackground(Color.green);
                        buttonClicked.setOpaque(true);
                        buttonClicked.setBorderPainted(false);
                        // checkWords
                        int result = checkWords();
                        if (result == 1)
                        {
                            reshuffle();
                            numRowsGuessed++;
                        }
                        else if (result == 0)
                        {
                            // print one word wrong, so close

                            numTries--;
                            triesLabel.setText("Tries Left: " + numTries);
                        }
                        else
                        {
                            //print wrong

                            numTries--;
                            triesLabel.setText("Tries Left: " + numTries);
                        }
                        // timer to change the color back
                    }
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
                            wordsClicked.add(clickedWord);

                            buttonClicked.setBackground(Color.gray);
                            buttonClicked.setOpaque(true);
                            buttonClicked.setBorderPainted(false);
                        }
                    }
                }

                if (numTries == 0)
                {
                    // GAME OVER
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


    /**
     * 
     * @return 1 if exact, 0 if off by one, -1 if off by more than one
     */
    private int checkWords()
    {
        ArrayList<Word> compareList = new ArrayList<>();
        for (JButton w : clicked)
        {
            compareList.add(new Word(w.getText()));
        }

        Category checkCat = new Category(compareList);

        for ( Category c : categories )
        {
            if (c.compareCategory(checkCat) == 1)
            {
                return 1;
            }
            else if (c.compareCategory(checkCat) == 0)
            {
                return 0;
            }
        }
        return -1;
    }

    private void reshuffle()
    {
        int r = numRowsGuessed - 1;

        JButton[] buttons = {button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11, button12, button13,
                            button14, button15};
        Category guessedClass = new Category(wordsClicked);
        String catName = guessedClass.getName();
        ArrayList<Word> wordList = guessedClass.getWords();
        
    }

    private void swapWords(JButton b1, JButton b2)
    {
        String temp = b1.getText();
        b1.setText(b2.getText());
        b2.setText(temp);
    }
}

