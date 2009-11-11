import java.awt.*;

public class Circle
{
    private int centerX, centerY, radius;
    private Color color;
    private int velocity, direction;
    
    public Circle(int x, int y, int r, Color c)
    {
        centerX = x;
        centerY = y;
        radius = r;
        color = c;
        velocity = 0;
        direction = 0;
    }
    
    public int getX() { return centerX; }
    public int getY() { return centerY; }
    public int getRadius() { return radius; }
    public Color getColor() { return color; }
    public void setX(int x) { centerX = x; }
    public void setY(int y) { centerY = y; }
    public void setRadius(int r) { radius = r; }
    public void setColor(Color c) { color = c; }
    
    public void draw(Graphics g)
    {
        Color oldColor = g.getColor();
        g.setColor(color);
        // Translates circle's center to rectangle's origin for drawing.
        g.drawOval(centerX - radius, centerY - radius, radius * 2, radius * 2);
        g.setColor(oldColor);
    }
    
    public void fill(Graphics g)
    {
        Color oldColor = g.getColor();
        g.setColor(color);
        // Translates circle's center to rectangle's origin for drawing.
        g.fillOval(centerX - radius, centerY - radius, radius * 2, radius * 2);
        g.setColor(oldColor);
    }
    
    public boolean containsPoint(int x, int y)
    {
        int xSquared = (x - centerX) * (x - centerX);
        int ySquared = (y - centerY) * (y - centerY);
        int radiusSquared = radius * radius;
        return xSquared + ySquared - radiusSquared <= 0;
    }
    
    public void move(int xAmount, int yAmount)
    {
        centerX = centerX + xAmount;
        centerY = centerY + yAmount;
    }
    
    public void setVelocity(int v)
    {
        velocity = v;
    }
    
    public void setDirection(int degrees)
    {
        direction = degrees % 360;
    }
    
    public void turn(int degrees)
    {
        direction = (direction + degrees) % 360;
    }
    
    public void move()
    {
        move((int)(velocity * Math.cos(Math.toRadians(direction))),
             (int)(velocity * Math.sin(Math.toRadians(direction))));
    }
}