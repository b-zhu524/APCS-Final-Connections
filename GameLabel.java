import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
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
    
    public GameLabel(Category cat)
    {
        catText = cat.printCategory();

    }
    
    private void setFontSize()
    {
        super.setFont(getFont());
    }
    
    private void setFontType()
    {

    }
    private void setBackgroundColor()
    {
        super.setBackground(getBackground());
    }

}
