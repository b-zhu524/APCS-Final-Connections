import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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


    public ViewConnections(ArrayList<Word> words, ArrayList<Category> cat)
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
        GridBagConstraints constraints = new GridBagConstraints(); // none so far

        frame.setSize(500, 500);
        frame.setTitle("CONNECTIONS");
        frame.setBackground(Color.LIGHT_GRAY);

        JPanel bottomGrid = new JPanel();
        bottomGrid.setLayout(new GridLayout(1, 1));
        bottomGrid.setPreferredSize(new Dimension(120, 120));
        
        bottomGrid.add(submit);
        bottomGrid.add(triesLabel);

        JPanel wordGrid = new JPanel();
        wordGrid.setLayout(new GridLayout(4, 4));

        // JPanel row1 = new JPanel();
        // row1.setLayout(new GridLayout(1, 4));

        // JPanel row2 = new JPanel();
        // row1.setLayout(new GridLayout(1, 4));

        // JPanel row3 = new JPanel();
        // row1.setLayout(new GridLayout(1, 4));

        // JPanel row4 = new JPanel();
        // row1.setLayout(new GridLayout(1, 4));

        // row1.add(button0, constraints);
        // row1.add(button1, constraints);
        // row1.add(button2, constraints);
        // row1.add(button3, constraints);
        // row2.add(button4, constraints);
        // row2.add(button5, constraints);
        // row2.add(button6, constraints);
        // row2.add(button7, constraints);
        // row3.add(button8, constraints);
        // row3.add(button9, constraints);
        // row3.add(button10, constraints);
        // row3.add(button11, constraints);
        // row4.add(button12, constraints);
        // row4.add(button13, constraints);
        // row4.add(button14, constraints);
        // row4.add(button15, constraints);

        // frame.add(bottomGrid, BorderLayout.SOUTH);
        // frame.add(row1);
        // frame.add(row2);
        // frame.add(row3);
        // frame.add(row4);

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

        Category guessedClass = new Category(wordsClicked);
        String catName = guessedClass.getName();
        
    }

    private void swapWords(JButton b1, JButton b2)
    {
        String temp = b1.getText();
        b1.setText(b2.getText());
        b2.setText(temp);
    }
}

