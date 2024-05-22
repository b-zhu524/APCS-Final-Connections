import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;


public class GameLabel extends JLabel
{
    private String catText;
    private String catName;
    
    public GameLabel(Category cat)
    {
        catText = cat.getCategoryInfo();
        catName = cat.getName();
        setFont();
    }
    
    private void setFont()
    {
        super.setFont(new Font("Arial", Font.BOLD, 14));
        super.setForeground(Color.WHITE);
    }
   
    public static void setBackgroundColor()
    {

    }

    public void setRoundEdges()
    {
        
    }

    public Color getBackgroundColor(Category cat)
    {
        int difficulty = cat.getDifficulty();
        if ( difficulty == 0 )
        {
            return new Color(245, 224, 126); // YELLOW from NYTIMES
        }
        else if ( difficulty == 1 )
        {
            return new Color(167, 194, 104); // GREEN from NYTIMES
        }
        else if ( difficulty == 2 )
        {
            return new Color(180, 195, 235); // LIGHT BLUE from NYTIMES
        }
        else
        {
            return new Color(170, 130, 190); // PURPLE from NYTIMES
        }
    }

}
