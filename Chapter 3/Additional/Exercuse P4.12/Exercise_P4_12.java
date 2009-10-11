import javax.swing.*;
import java.awt.*;

class Exercise_P4_12
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setSize(600, 200);
        frame.getContentPane().add(new BarGraphs());    
        frame.setVisible(true);
    }
}
