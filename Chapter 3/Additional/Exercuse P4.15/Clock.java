import javax.swing.*;
import java.awt.*;

public class Clock extends JPanel
{
    int hours, minutes;

    public Clock(int hours, int minutes)
    {
        SetTime(hours, minutes);
    }
    
    public void SetTime(int hours, int minutes)
    {
        if (hours <= 12 && hours >= 1) this.hours = hours;
        if (minutes <= 59 && minutes >= 0) this.minutes = minutes;
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        //draw clock
        g.drawOval(10, 10, 250, 250);
        g.drawLine(135, 10, 135, 25);                        //12
        g.drawLine(135, 260, 135, 245);                      //6
        g.drawLine(10, 135, 25, 135);                        //3
        g.drawLine(260, 135, 245, 135);                      //9
        g.drawLine(135 + 108, 135 + 62, 135 + 95, 135 + 55); //4
        g.drawLine(135 - 108, 135 + 62, 135 - 95, 135 + 55); //8
        g.drawLine(135 - 108, 135 - 62, 135 - 95, 135 - 55); //10
        g.drawLine(135 + 108, 135 - 62, 135 + 95, 135 - 55); //2
        g.drawLine(135 + 62, 135 + 108, 135 + 55, 135 + 95); //5
        g.drawLine(135 - 62, 135 + 108, 135 - 55, 135 + 95); //7
        g.drawLine(135 - 62, 135 - 108, 135 - 55, 135 - 95); //11
        g.drawLine(135 + 62, 135 - 108, 135 + 55, 135 - 95); //1
        
        //Draw Hour Hand
        DrawHand(g, GetHourHandClockAngle(), 60);
        //Draw Minute Hand
        DrawHand(g, GetMinuteHandClockAngle(), 100);
    }
    
    public void DrawHand(Graphics g, double clockAngle, int length)
    {
        clockAngle -= Math.PI / 2;
        if (clockAngle < 0) clockAngle += 2 * Math.PI;
        g.drawLine(135, 135, 135 + (int)(length * Math.cos(clockAngle)),
            135 + (int)(length * Math.sin(clockAngle)));
    }
    
    private double Radians(double degrees)
    {
        return (degrees / 180) * Math.PI;
    }
    
    //a clock angle is measured clockwise from the positive y axis
    //a math angle is measured counter-clockwise from the positive x axis
    private double GetMinuteHandClockAngle()
    {
		return Radians(minutes * 6);
    }
    
    private double GetHourHandClockAngle()
    {
		return Radians((hours == 12 ? 0 : hours) * 30 + minutes / 2);
    }
}