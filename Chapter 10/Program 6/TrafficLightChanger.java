import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TrafficLightChanger extends JFrame
{
    private TrafficLight light;
    private JButton button;
    
    public TrafficLightChanger()
    {
        light = new TrafficLight();
        button = new JButton("Change");
        button.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    light.Change();
                }
            });
        getContentPane().add(light, BorderLayout.CENTER);
        getContentPane().add(button, BorderLayout.SOUTH);
        setSize(123, 220);
        setResizable(false);
        setVisible(true);
    }
    
    public static void main(String[] args)
    {
        TrafficLightChanger x = new TrafficLightChanger();
    }
}