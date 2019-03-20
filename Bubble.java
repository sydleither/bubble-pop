import java.awt.*;
public class Bubble{
    int frameWidth;
    int frameHeight;
    Color col;
    int x, y, xV, yV, size;

    public Bubble(int frameWidth, int frameHeight){
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;

        x = (int)(Math.random()*(frameWidth-250))+size;
        y = (int)(Math.random()*(frameHeight-250))+size;
        xV = (int)(Math.random()*30-15);
        yV = (int)(Math.random()*30-15);
        size = (int)(Math.random()*200+100);
        int r = (int)(Math.random()*256);
        int g = (int)(Math.random()*256);
        int b = (int)(Math.random()*256);
        col = new Color(r,g,b);
    }

    //bounce ball of sides of frame and change direction it moves
    public void move(Graphics g){
        if(x<=0 || x+size>=frameWidth){
            xV *= -1;
        }
        if(y<=0 || y+size>=frameHeight){
            yV *= -1;
        }
        x += xV;
        y += yV;
        g.setColor(col);
        g.fillOval(x, y, size, size);
    }
}