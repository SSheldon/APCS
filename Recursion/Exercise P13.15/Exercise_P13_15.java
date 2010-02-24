import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Exercise_P13_15 extends JPanel
{
    private int i;
    
    public Exercise_P13_15()
    {
        i = 0;
        addMouseListener(new MouseAdapter()
            {
                public void mousePressed(MouseEvent e)
                {
                    i++;
                    repaint();
                }
            });
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        DrawSide(g, new Point(0, 520), new Point(300, 0), i);
        DrawSide(g, new Point(300, 0), new Point(600, 520), i);
        DrawSide(g, new Point(600, 520), new Point(0, 520), i);
    }
    
    private void DrawSide(Graphics g, Point p1, Point p2, int i)
    {
        if (i == 0)
        {
            g.drawLine(p1.x, p1.y, p2.x, p2.y);
        }
        else
        {
            Point t1 = new Point(p1.x + (p2.x - p1.x) / 3,
                                 p1.y + (p2.y - p1.y) / 3),
                  t2 = new Point(p2.x - (p2.x - p1.x) / 3,
                                 p2.y - (p2.y - p1.y) / 3),
                   m = new Point(p1.x + (p2.x - p1.x) / 2,
                                 p1.y + (p2.y - p1.y) / 2);
            double angle = Math.atan2(-(p2.getX() - p1.getX()),
                p2.getY() - p1.getY());
            double length = p1.distance(t1) / 2.0 * Math.sqrt(3);
            m.translate((int)(Math.cos(angle) * length),
                (int)(Math.sin(angle) * length));
            DrawSide(g, p1, t1, i - 1);
            DrawSide(g, t1, m,  i - 1);
            DrawSide(g, m,  t2, i - 1);
            DrawSide(g, t2, p2, i - 1);
        }
    }
    
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setSize(609, 728);
        frame.getContentPane().add(new Exercise_P13_15());
        frame.setVisible(true);
    }
}
