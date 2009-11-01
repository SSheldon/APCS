import javax.swing.*;
import java.awt.*;

public class Bar extends JPanel
{
    private BarCode barCode;
    
    public Bar(BarCode barCode)
    {
        this.barCode = barCode;
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        for (int i = 0; i < 32; i++)
        {
            g.drawRect(4 + i * 8, 20, 3,
                barCode.IsFullBar(i) ? -17 : -9);
        }
    }
}
