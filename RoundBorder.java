import javax.swing.JFrame;
import javax.swing.border.Border;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Component;


/**
 * @author Bolang Zhu
 */
public class RoundBorder implements Border
{
    private int radius;

    public RoundBorder(int radius)
    {
        this.radius = radius;
    }
    
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height)
    {
        g.drawRoundRect(x, y, width-1, height-1, radius, radius);
    }

    public Insets getBorderInsets(Component c)
    {
        return new Insets(radius+1, radius+1, radius+2, radius);
    }

    public boolean isBorderOpaque()
    {
        return true;
    }
}
