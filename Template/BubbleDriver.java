import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class BubbleDriver extends JPanel{
    static Mouse mouse = new Mouse();
    static final int frameWidth = 1000;
    static final int frameHeight = 700;

    ArrayList<Bubble> bubbles = new ArrayList<>();
    int numberOfBubbles = 10;
    int score = 500;

    public BubbleDriver(){

    }

    public void paintComponent(Graphics g){

    }

    public static void main(String[] args){
        JFrame frame = new JFrame("Bubbles!");
        frame.setDefaultLookAndFeelDecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(frameWidth, frameHeight);
        frame.addMouseListener(mouse);
        frame.setContentPane(new BubbleDriver());
        frame.setVisible(true);
    }

    public boolean bubblePopped(int i){
        return mouse.xClick >= bubbles.get(i).x && bubbles.get(i).x+bubbles.get(i).size >= mouse.xClick &&
                mouse.yClick >= bubbles.get(i).y && bubbles.get(i).y+bubbles.get(i).size >= mouse.yClick;
    }
}