import javax.swing.*;
import java.awt.*;

public class Project_4_12
{   
    public static void main(String[] args)
    {
        int rows = Integer.parseInt(JOptionPane.showInputDialog(
            "Enter the number of rows:", "8"));
        int cols = Integer.parseInt(JOptionPane.showInputDialog(
            "Enter the number of columns:", "8"));
        
        JFrame frame = new JFrame();
        frame.setSize(400,400);
        Container pane = frame.getContentPane();
        pane.setLayout(new GridLayout(rows, cols));
        boolean red = true;
        for (int i = 0; i < rows * cols; i++)
        {
            if ((cols % 2 == 0) && (i % cols == 0)) red = !red;
            pane.add(new JPanel());
            pane.getComponent(i).setBackground(
                red ? Color.red : Color.black);
            red = !red;
        }        
        frame.setVisible(true);     
    }
}