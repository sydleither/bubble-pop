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

    //add bubbles to array and create thread to "animate" them
    public BubbleDriver(){
        Thread thread = new Thread(){
            public void run(){
                while(true){
                    for(int i = 0; i< numberOfBubbles; i++){
                        bubbles.add(i, new Bubble(frameWidth,frameHeight));
                    }

                    for(int i = 0; i < 500; i++) {
                        for (int k = 0; k < numberOfBubbles; k++){
                            score = 500-i;
                            repaint();
                        }
                        try{
                            Thread.sleep(20);
                        }
                        catch (InterruptedException e) {
                        }
                    }

                }
            }
        };
        thread.start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.drawString("Score:"+score,450,15);

        //move each bubble
        for(int i = 0; i< numberOfBubbles; i++){
            bubbles.get(i).move(g);

            if(bubblePopped(i)){
                bubbles.remove(i);
                numberOfBubbles--;

                //end game successfully
                if(numberOfBubbles == 0 && score != 0){
                    g.setFont(new Font("TimesRoman", Font.PLAIN, 100));
                    g.setColor(Color.black);
                    g.drawString("You won!",250,300);
                    g.drawString("Score: "+score,250,400);
                }

                break;
            }

            //end game unsuccessfully
            if(numberOfBubbles != 0 && score == 1){
                bubbles.clear();
                numberOfBubbles = 0;
                g.setFont(new Font("TimesRoman", Font.PLAIN, 100));
                g.setColor(Color.black);
                g.drawString("You lose",250,300);
            }
        }
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
