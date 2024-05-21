import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import java.util.ArrayList;
import javax.swing.JFrame;

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
    // public static ArrayList<GameButton> clicked;

    /**
     * 
     * @param text
     */
    public GameButton(String text)
    {
       super(text);
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
        super.setBorderPainted(false);
        super.setOpaque(true);
    }

    /**
     * 
     */
    public void unclickButton()
    {
        setColorUnclicked();
        setFontBlack();
        super.setBorderPainted(true);
        super.setOpaque(false);
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
        super.setBackground(new Color(239, 239, 230));
    }

    private void setColorClicked()
    {
        super.setBackground(new Color(90, 90, 80));
    }

    private void setFontWhite()
    {
        super.setFont(new Font("Arial", Font.BOLD, 17));
        super.setForeground(Color.WHITE);
    }
    private void setFontBlack()
    {
        setFontWhite();
        super.setForeground(Color.BLACK);
    }

    // // FOR TESTING ONLY
    // public static void main(String[] args) {
    //     GameButton gb = new GameButton("TEST BUTTON");
    //     JFrame jf = new JFrame();
    //     jf.setSize(new Dimension(500, 500));
    //     jf.add(gb);
    //     jf.setVisible(true);
    //     gb.clickButton();
    //     // gb.unclickButton();
    // }
}
