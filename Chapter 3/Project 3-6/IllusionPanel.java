import javax.swing.*;
import java.awt.*;

public class IllusionPanel extends JPanel
{
    public IllusionPanel() { }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        int x1 = 50, x2 = 250, y1 = 50, y2 = 100;
        g.drawLine(x1, y1, x2, y1);
        g.drawLine(x1, y1, x1 + 10, y1 - 10);
        g.drawLine(x1, y1, x1 + 10, y1 + 10);
        g.drawLine(x2, y1, x2 - 10, y1 - 10);
        g.drawLine(x2, y1, x2 - 10, y1 + 10);
        g.drawLine(x1, y2, x2, y2);
        g.drawLine(x1, y2, x1 - 10, y2 - 10);
        g.drawLine(x1, y2, x1 - 10, y2 + 10);
        g.drawLine(x2, y2, x2 + 10, y2 - 10);
        g.drawLine(x2, y2, x2 + 10, y2 + 10);
    }
}