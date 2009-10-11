import javax.swing.*;
import java.awt.*;

public class PieChart extends JPanel
{
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        //Golden Gate
        g.setColor(Color.red);
        g.fillArc(120, 10, 250, 250, 0, 129);
        //Brooklyn 49
        g.setColor(Color.yellow);
        g.fillArc(120, 10, 250, 250, 129, 49);
        //Delaware Memorial 66
        g.setColor(Color.green);
        g.fillArc(120, 10, 250, 250, 178, 66);
        //Mackinac 116
        g.setColor(Color.blue);
        g.fillArc(120, 10, 250, 250, 244, 116);
        //labels
        g.setColor(Color.black);
        g.drawString("Golden Gate", 360, 70);
        g.drawString("Brooklyn", 80, 70);
        g.drawString("Delaware Memorial", 10, 200);
        g.drawString("Mackinac", 370, 200);
    }
}