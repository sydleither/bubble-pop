import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class Mouse implements MouseListener{
    int xClick;
    int yClick;

    public void mouseClicked(MouseEvent e){
        this.xClick = e.getX();
        this.yClick = e.getY();
    }

    public void mousePressed(MouseEvent e){ }

    public void mouseReleased(MouseEvent e){ }

    public void mouseEntered(MouseEvent e){ }

    public void mouseExited(MouseEvent e){ }
}