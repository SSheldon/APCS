import javax.swing.*;
import java.awt.*;

class Exercise_P4_13
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setSize(500, 305);
        frame.getContentPane().add(new PieChart());    
        frame.setVisible(true);
    }
}