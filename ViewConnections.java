import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.BorderLayout;

/*
 * GUI for the Connections Game
 */
public class ViewConnections
{
    private JFrame frame;

    private GameButton button0;
    private GameButton button1;
    private GameButton button2;
    private GameButton button3;
    private GameButton button4;
    private GameButton button5;
    private GameButton button6;
    private GameButton button7;
    private GameButton button8;
    private GameButton button9;
    private GameButton button10;
    private GameButton button11;
    private GameButton button12;
    private GameButton button13;
    private GameButton button14;
    private GameButton button15;
    GameButton[] buttonList = {button0, button1, button2, button3, button4, button5, button6, button7,
                            button8, button9, button10, button11, button12, button13, button14, button15};

    private GameButton submit;
    private JLabel triesLabel;

    private JPanel row1;
    private JPanel row2;
    private JPanel row3;
    private JPanel row4;

    private Category[] categories;
    ArrayList<GameButton> clicked = GameButton.getClicked();

    private int numRowsGuessed;
    private int numTries;


    public ViewConnections(ArrayList<Word> words, Category[] cats)
    {
        Collections.shuffle(words);
        button0 = new GameButton(words.get(0).getText());
        button1 = new GameButton(words.get(1).getText());
        button2 = new GameButton(words.get(2).getText());
        button3 = new GameButton(words.get(3).getText());
        button4 = new GameButton(words.get(4).getText());
        button5 = new GameButton(words.get(5).getText());
        button6 = new GameButton(words.get(6).getText());
        button7 = new GameButton(words.get(7).getText());
        button8 = new GameButton(words.get(8).getText());
        button9 = new GameButton(words.get(9).getText());
        button10 = new GameButton(words.get(10).getText());
        button11 = new GameButton(words.get(11).getText());
        button12 = new GameButton(words.get(12).getText());
        button13 = new GameButton(words.get(13).getText());
        button14 = new GameButton(words.get(14).getText());
        button15 = new GameButton(words.get(15).getText());
    
        submit = new GameButton("SUBMIT");

        frame = new JFrame();
        categories = cats;
        
        numTries = 4;
        numRowsGuessed = 0;

        triesLabel = new JLabel("Tries Left: " + numTries, JLabel.CENTER);
    }


    public void setUpGUI()
    {
        // set up the frame
        frame.setSize(500, 500);
        frame.setTitle("Create Groups of Four!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setBackground(Color.white);
        
        // set up the words grid
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        row1 = new JPanel();
        row1.setLayout(new GridLayout(1, 4));
        row1.add(button0);

        row1.add(button1);
        row1.add(button2);
        row1.add(button3);

        container.add(row1);

        container.add(Box.createVerticalStrut(10));

        row2 = new JPanel();
        row2.setLayout(new GridLayout(1, 4));
        row2.add(button4);
        row2.add(button5);
        row2.add(button6);
        row2.add(button7);
        container.add(row2);

        container.add(Box.createVerticalStrut(10));
        

        row3 = new JPanel();
        row3.setLayout(new GridLayout(1, 4));
        row3.add(button8);
        row3.add(button9);
        row3.add(button10);
        row3.add(button11);
        container.add(row3);
        
        container.add(Box.createVerticalStrut(10));


        row4 = new JPanel();
        row4.setLayout(new GridLayout(1, 4));
        row4.add(button12);
        row4.add(button13);
        row4.add(button14);
        row4.add(button15);
        container.add(row4);
        
        container.add(Box.createVerticalStrut(10));


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
                GameButton buttonClicked = (GameButton) event.getSource();


                if (buttonClicked.equals(submit))
                {
                    if (clicked.size() == 4)
                    {
                        
                        // checkWords
                        int result = getResult();

                        if (result == 1) // CORRECT
                        {
                            int cIndex = getCategoryIndex(clicked);
                            // add pause
                            reshuffle();
                            turnIntoLabel(numRowsGuessed, categories[cIndex].printCategory()); // need to print every word in the category. "FRUITS". is a placeholder
                            numRowsGuessed++;
                        }
                        else if (result == 0) // ONE AWAY!
                        {
                            System.out.println("ONE OFF");
                            numTries--;
                            triesLabel.setText("Tries Left: " + numTries);
                        }
                        else // WRONG
                        {
                            // completely wrong
                            numTries--;
                            triesLabel.setText("Tries Left: " + numTries);
                            
                        }


                        if (numTries == 0 || numRowsGuessed == 4)
                        {
                            if (numRowsGuessed == 4)
                            {
                                gameOver(true);
                            }
                            else 
                            {
                                gameOver(false);
                            }
                        }


                        // timer to wait
                        // change color back

                        GameButton.unclickAllButtons();                        
                        // pause so that submit lights up green/red for a second
                        submit.unclickButton();    

                    }
                }
                else
                {
                    if (clicked.contains(buttonClicked))
                    {
                        buttonClicked.unclickButton();
                        submit.setSubmitUnavailable();
                    }
                    else
                    {
                        if (clicked.size() < 4)
                        {
                            buttonClicked.clickButton();

                            if (clicked.size() == 4)
                            {
                                submit.setSubmitAvailable();
                            }
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


    // NEED TO IMPLEMENT
    private void gameOver(boolean won)
    {

    }

    private int getResult()
    {
        Category cat = makeCategory(clicked);
        for (Category c : categories)
        {
            int res = c.compareCategory(cat);
            if (res == 1)
            {
                return 1;
            }
            if (res == 0)
            {
                return 0;
            }
        }
        return -1;
    }

    private int getCategoryIndex(ArrayList<GameButton> buttonList)
    {
        Category checkedCat = makeCategory(buttonList);
        
        for ( int i=0; i<4; i++ )
        {
            if (categories[i].equals(checkedCat))
            {
                return i;
            }
        }
        
        return -1;
    }

    private Category getCategory( GameButton button )
    {
        for ( Category c : categories )
        {
            Word w = new Word(button.getText());
            if (w.inCategory(c))
            {
                return c;
            }
        }
        return null;
    }

    private Category makeCategory(ArrayList<GameButton> buttonList)
    {
        Word[] wordList = new Word[4];
        wordList[0] = new Word(buttonList.get(0).getText());
        wordList[1] = new Word(buttonList.get(1).getText());
        wordList[2] = new Word(buttonList.get(2).getText());
        wordList[3] = new Word(buttonList.get(3).getText());

        Category ret = new Category(wordList, ""); // name irrelevant
        return ret;
    }


    private void reshuffle()
    {
        int row = numRowsGuessed;
        ArrayList<GameButton> rowWords = getWords(row);
        Category clickedCat = getCategory(clicked.get(0));

        for ( int i=0; i<4; i++ )
        {
            for ( int j=0; j<4; j++ )
            {
                GameButton rw = rowWords.get(i);
                GameButton cw = clicked.get(j);

                if (!getCategory(rw).equals(clickedCat))
                {
                    if (!rowWords.contains(cw))
                    {
                        if (getCategory(cw).equals(clickedCat))
                        {
                            swapWords(rw, cw);
                            break;
                        }
                    }
                }
           }
        }
    }


    // HELPER METHODS
   
    private void turnIntoLabel(int r, String categoryInfo)
    {
        JLabel toAdd = new JLabel(categoryInfo, JLabel.CENTER);
        toAdd.setBackground(getColor(categoryInfo));

        toAdd.setOpaque(true);                        

        if (r == 0)
        {
            row1.remove(button0);
            row1.remove(button1);
            row1.remove(button2);
            row1.remove(button3);

            button0 = null;
            button1 = null;
            button2 = null;
            button3 = null;
            row1.add(toAdd);
        }
        else if (r == 1)
        {
            row2.remove(button4);
            row2.remove(button5);
            row2.remove(button6);
            row2.remove(button7);

            button4 = null;
            button5 = null;
            button6 = null;
            button7 = null;

            row2.add(toAdd);
        }
        else if (r == 2)
        {
            row3.remove(button8);
            row3.remove(button9);
            row3.remove(button10);
            row3.remove(button11);

            button8 = null;
            button9 = null;
            button10 = null;
            button11 = null;
            
            row3.add(toAdd);
       }
        else if (r == 3)
        {
            row4.remove(button12);
            row4.remove(button13);
            row4.remove(button14);
            row4.remove(button15);

            button12 = null;
            button13 = null;
            button14 = null;
            button15 = null;

            row4.add(toAdd);
        }

    }

    private Color getColor(String categoryInfo)
    {
        for ( int i=0; i<4; i++ )
        {
            if ( categoryInfo.equals(categories[i].printCategory()) )
            {
                if ( i == 0 )
                {
                    return new Color(240, 225, 140); // YELLOW from NYTIMES
                }

                else if ( i == 1 )
                {
                    return new Color(175, 195, 115); // GREEN from NYTIMES
                }
                else if ( i == 2 )
                {
                    return new Color(180, 195, 235); // LIGHT BLUE from NYTIMES
                }
                else
                {
                    return new Color(170, 130, 190); // PURPLE from NYTIMES
                }
            }
        }
        
        return null;
    }

    private void swapWords(GameButton b1, GameButton b2)
    {
        String temp = b1.getText();
        b1.setText(b2.getText());
        b2.setText(temp);
    }
    
    private ArrayList<GameButton> getWords(int row)
    {
        ArrayList<GameButton> ret = new ArrayList<>();

        if (row == 0)
        {
            ret.add(button0);
            ret.add(button1);
            ret.add(button2);
            ret.add(button3);
        }
        else if (row == 1)
        {
            ret.add(button4);
            ret.add(button5);
            ret.add(button6);
            ret.add(button7);
        }
        else if (row == 2)
        {
            ret.add(button8);
            ret.add(button9);
            ret.add(button10);
            ret.add(button11);
        }
        else if (row == 3)
        {
            ret.add(button12);
            ret.add(button13);
            ret.add(button14);
            ret.add(button15);
        }

        return ret;
    }
   
}
