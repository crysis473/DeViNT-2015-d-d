import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * Created by user on 03/04/2015.
 */
public class MouseInput implements MouseMotionListener {
    private Player player;
    private Handler handler;

    public MouseInput(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        for(int i = 0; i < handler.objects.size(); i++) {
            GameObject tempObject = handler.objects.get(i);
            if (tempObject.getId() == ObjectId.Player && e.getX() > player.getX() && e.getX() < player.getX() + player.getWidth() && e.getY() > player.getY() && e.getY() < player.getY() + player.getHeight()) {
                tempObject.setX(e.getX());
                tempObject.setY(e.getY());
            } else return;
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}