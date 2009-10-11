import javax.swing.*;
import java.awt.*;

public class InducedContrastPanel extends JPanel
{
    public InducedContrastPanel(Color color)
    {
        setBackground(color);              
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.gray);
        g.fillRect(30, 30, 40, 40);
    }
}