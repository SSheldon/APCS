import javax.swing.*;
import java.awt.*;

public class Project_2_7
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setSize(300,300);
        
        JPanel p1 = new JPanel();
        p1.setBackground(Color.black);
        JPanel p2 = new JPanel();
        p2.setBackground(Color.white);
        JPanel p3 = new JPanel();
        p3.setBackground(Color.black);
        JPanel p4 = new JPanel();
        p4.setBackground(Color.white);
        JPanel p5 = new JPanel();
        p5.setBackground(Color.black);
        JPanel p6 = new JPanel();
        p6.setBackground(Color.white);
        JPanel p7 = new JPanel();
        p7.setBackground(Color.black);
        JPanel p8 = new JPanel();
        p8.setBackground(Color.white);
        JPanel p9 = new JPanel();
        p9.setBackground(Color.black);
        
        Container pane = frame.getContentPane();
        pane.setLayout(new GridLayout(3, 3));
        pane.add(p1);
        pane.add(p2);
        pane.add(p3);
        pane.add(p4);
        pane.add(p5);
        pane.add(p6);
        pane.add(p7);
        pane.add(p8);
        pane.add(p9);
        
        frame.setVisible(true);
    }
}