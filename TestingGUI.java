import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JButton;
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
    JButton[] buttonList = {button0, button1, button2, button3, button4, button5, button6, button7,
                            button8, button9, button10, button11, button12, button13, button14, button15};

    private JButton submit;
    private JLabel triesLabel;

    private JPanel row1;
    private JPanel row2;
    private JPanel row3;
    private JPanel row4;

    private ArrayList<JButton> clicked;
    private ArrayList<Word> wordsClicked;
    private Category[] categories;

    private int numRowsGuessed;
    private int numTries;


    public TestingGUI(ArrayList<Word> words, Category[] cats)
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
        frame.setBackground(Color.LIGHT_GRAY);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
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

        row2 = new JPanel();
        row2.setLayout(new GridLayout(1, 4));
        row2.add(button4);
        row2.add(button5);
        row2.add(button6);
        row2.add(button7);
        container.add(row2);

        row3 = new JPanel();
        row3.setLayout(new GridLayout(1, 4));
        row3.add(button8);
        row3.add(button9);
        row3.add(button10);
        row3.add(button11);
        container.add(row3);
	

        row4 = new JPanel();
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

                if (buttonClicked.equals(submit))
                {
                    if (clicked.size() == 4)
                    {
                        buttonClicked.setBackground(Color.green);
                        buttonClicked.setOpaque(true);
                        buttonClicked.setBorderPainted(false);
                        
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
                            System.out.println("SOMETHING WRONG");

                            // completely wrong
                            numTries--;
                            triesLabel.setText("Tries Left: " + numTries);
                        }
                        // timer to wait
                        // change color back

                        unclickAllButtons(); // weird bug. without unclicking submit, pressing 4 buttons in the same row in a row would freeze the program
                        
                        // pause so that submit lights up green for a second
                        unclickButton(submit);
                    }
                }
                else
                {
                    if (clicked.contains(buttonClicked))
                    {
                        unclickButton(buttonClicked);
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

    private int getCategoryIndex(ArrayList<JButton> buttonList)
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

    private Category getCategory( JButton button )
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

    private Category makeCategory(ArrayList<JButton> buttonList)
    {
        Word[] wordList = new Word[4];
        wordList[0] = new Word(buttonList.get(0).getText());
        wordList[1] = new Word(buttonList.get(1).getText());
        wordList[2] = new Word(buttonList.get(2).getText());
        wordList[3] = new Word(buttonList.get(3).getText());

        Category ret = new Category(wordList, ""); // name irrelevant
        return ret;
    }


    // BUG---does not move words around 
    private void reshuffle()
    {
        int row = numRowsGuessed;
        ArrayList<JButton> rowWords = getWords(row);
        Category clickedCat = getCategory(clicked.get(0));

        for ( int i=0; i<4; i++ )
        {
            for ( int j=0; j<4; j++ )
            {
                JButton rw = rowWords.get(i);
                JButton cw = clicked.get(j);

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

    // only for testing
    private void printJButton(ArrayList<JButton> printList)
    {
        for ( JButton jb : printList )
        {
            System.out.print(jb.getText());
        }
        System.out.println();
    }

    private void testSwap()
    {
        System.out.println(button0.getText() + " " + button1.getText());
        swapWords(button1, button0);
        System.out.println(button0.getText() + " " + button1.getText());
    }
    
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
                    return new Color(180, 195, 235);
                }
                else
                {
                    return new Color(170, 130, 190);
                }
            }
        }
        
        return null;
    }

    private void swapWords(JButton b1, JButton b2)
    {
        String temp = b1.getText();
        b1.setText(b2.getText());
        b2.setText(temp);
    }
    
    private ArrayList<JButton> getWords(int row)
    {
        ArrayList<JButton> ret = new ArrayList<>();

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

    private void unclickButton(JButton b)
    {
        b.setBackground(Color.LIGHT_GRAY);
        b.setBorderPainted(true);
        b.setOpaque(false);
        clicked.remove(b);
    }
    
    private void unclickAllButtons()
    {
        int n = clicked.size();
        for ( int i=0; i<n; i++)
        {
            unclickButton(clicked.get(0));
        }
    }
}
