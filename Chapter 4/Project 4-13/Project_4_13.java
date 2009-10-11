import javax.swing.*;
import java.awt.*;

public class Project_4_13
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setSize(208, 134);
        Container pane = frame.getContentPane();
        pane.setLayout(new GridLayout(1, 2));
        pane.add(new InducedContrastPanel(Color.black));
        pane.add(new InducedContrastPanel(Color.white));
        frame.setVisible(true); 
    }
}
