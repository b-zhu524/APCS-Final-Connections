import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JButton;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.border.LineBorder;

/**
 * @author Bolang Zhu 
 * Changes the following settings for JButton
 * Font
 * Roundneess of button
 * 
 * Allows other classes to change the appearance upon clicking and unclicking
 */
public class GameButton extends JButton
{
    private static ArrayList<GameButton> clicked = new ArrayList<>();

    /**
     * 
     * @param text
     */
    public GameButton(String text)
    {
        super(text);
        // super.setBorderPainted(false);
        super.setOpaque(true);

        super.setBorder(new LineBorder(Color.BLACK));

        setFontBlack();
        setColorUnclicked();
    }

    /**
     * 
     */
    public void clickButton()
    {
        setColorClicked();
        setFontWhite();
        clicked.add(this);
    }

    /**
     * 
     */
    public void unclickButton()
    {
        setColorUnclicked();
        setFontBlack();
        clicked.remove(this);
    }

    public static void unclickAllButtons()
    {
        int n = clicked.size();
        for ( int i=0; i<n; i++)
        {
            clicked.get(0).unclickButton();
        }
    }

    public static ArrayList<GameButton> getClicked()
    {
        return clicked;
    }

    public void setSubmitUnavailable()
    {
        setColorUnclicked();
        setFontBlack();
    }

    public void setSubmitAvailable()
    {
        setColorClicked();
        setFontWhite();
    }

    /**
     * Makes the button hop up and down on the Panel 
     */
    public void animate()
    {

    }

    private void setInsets()
    {
    }

    private void setColorUnclicked()
    {
        // super.setBackground(new Color(240, 240, 230));
        super.setBackground(new Color(230, 230, 220));
    }

    private void setColorClicked()
    {
        super.setBackground(new Color(90, 90, 80));
    }

    private void setFontWhite()
    {
        super.setFont(new Font("Arial", Font.BOLD, 22));
        super.setForeground(Color.WHITE);
    }
    private void setFontBlack()
    {
        super.setFont(new Font("Arial", Font.BOLD, 17));
        super.setForeground(Color.BLACK);
    }

    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setSize(new Dimension(500, 500));
        GameButton gb = new GameButton("testing");
        jf.add(gb);

        jf.setVisible(true);
    }
}
