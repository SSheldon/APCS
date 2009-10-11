import javax.swing.*;
import java.awt.*;

public class BarGraphs extends JPanel
{
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawString("Golden Gate", 10, 30);
        g.drawString("Brooklyn", 10, 70);
        g.drawString("Delaware Memorial", 10, 110);
        g.drawString("Mackinac", 10, 150);
        g.drawRect(120, 15, 420, 20);
        g.drawRect(120, 55, 160, 20);
        g.drawRect(120, 95, 215, 20);
        g.drawRect(120, 135, 380, 20);
    }
}
