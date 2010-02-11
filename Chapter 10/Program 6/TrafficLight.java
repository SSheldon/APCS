import javax.swing.*;
import java.awt.*;

public class TrafficLight extends JPanel
{
    private boolean red = true, green = false, yellow = false;
    
    public void Change()
    {
        if (red)
        {
            yellow = true;
            red = false;
        }
        else if (yellow)
        {
            green = true;
            yellow = false;
        }
        else
        {
            red = true;
            green = false;
        }
        repaint();
    }
    
    public void paintComponent(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 50, 150);
        DrawRedLight(g, red);
        DrawGreenLight(g, green);
        DrawYellowLight(g, yellow);
    }
    
    public void DrawLight(Graphics g, Color color, int y)
    {
        g.setColor(color);
        g.fillOval(5, y, 40, 40);
    }
    
    public void DrawGreenLight(Graphics g, boolean on)
    {
        DrawLight(g, on ? Color.green : new Color(0, 96, 0), 105);
    }
    
    public void DrawYellowLight(Graphics g, boolean on)
    {
        DrawLight(g, on ? Color.yellow : new Color(96, 96, 0), 55);
    }
    
    public void DrawRedLight(Graphics g, boolean on)
    {
        DrawLight(g, on ? Color.red : new Color(96, 0, 0), 5);
    }
}