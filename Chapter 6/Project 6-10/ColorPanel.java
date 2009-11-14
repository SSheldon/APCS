import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ColorPanel extends JPanel
{
    private Circle circle1, circle2;
    private Timer timer;
    
    public ColorPanel(Color backColor, int width, int height)
    {
        setBackground(backColor);
        setPreferredSize(new Dimension(width, height));
        addMouseListener(new StopListener());
        
        circle1 = new Circle(50, height / 2, 25, Color.red);
        circle1.setDirection((int)(Math.random() * 360.0));
        circle1.setVelocity(5);
        
        circle2 = new Circle(width - 50, height / 2, 25, Color.blue);
        circle2.setDirection((int)(Math.random() * 360.0));
        circle2.setVelocity(5);
        
        timer = new Timer(5, new MoveListener());
        timer.start();
    }
    
    public void paintComponent(Graphics g)
    {
        if (!timer.isRunning())
        {
            CheckCircle(circle1, false);
            CheckCircle(circle2, false);
        }        
        super.paintComponent(g);
        circle1.fill(g);
        circle2.fill(g);
    }
    
    private void CheckCircle(Circle circle, boolean reflect)
    {
        int x = circle.getX();
        int y = circle.getY();
        int radius = circle.getRadius();
        int d = circle.getDirection();
        int width = getWidth();            
        int height = getHeight();
        // Check for boundaries and reverse direction if necessary
        if (x - radius < 0)
        {
            circle.setX(radius);
            if (reflect) circle.setDirection(Reflect(d, 0));
        }
        if (x + radius > width)
        {
            circle.setX(width - radius);
            if (reflect) circle.setDirection(Reflect(d, 180));
        }
        if (y - radius < 0)
        {
            circle.setY(radius);
            if (reflect) circle.setDirection(Reflect(d, 90));
        }
        if (y + radius > height)
        {
            circle.setY(height - radius);
            if (reflect) circle.setDirection(Reflect(d, 270));
        }
    }
    
    private static int Reflect(int direction, int normal)
    {
        int negatedNormal = normal + 180 * (normal >= 180 ? -1 : 1);
        int ai = AngleBetween(direction, negatedNormal);
        int result;
        if (direction > negatedNormal && 
            (negatedNormal != 0 || direction < 180))
            result = (normal - ai);
        else result = (normal + ai);
        result %= 360;
        if (result < 0)result += 360;
        return result;
    }
    
    private static int AngleBetween(int d1, int d2)
    {
        int a = Math.abs(d1 - d2);
        a %= 360;
        if (a > 180) a = 360 - a;
        return a;
    }
    
    private class MoveListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            CheckCircle(circle1, true);
            circle1.move();
            CheckCircle(circle2, true);
            circle2.move();
            repaint();
        }
    }
    
    private class StopListener extends MouseAdapter
    {
        public void mousePressed(MouseEvent e)
        {
            if (timer.isRunning()) timer.stop();
            else timer.start();
        }
    }
}
