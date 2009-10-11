import javax.swing.*;
import java.awt.*;

public class Project_3_6
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setSize(300, 200);
        frame.getContentPane().add(new IllusionPanel());    
        frame.setVisible(true);
    }
}