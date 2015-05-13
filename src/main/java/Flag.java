//import sun.plugin.dom.css.Rect;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by user on 07/04/2015.
 */
public class Flag extends GameObject {

    public Flag(float x, float y, ObjectId id) {
        super(x, y, id);
    }

    @Override
    public void tick(LinkedList<GameObject> object) {

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillRect((int)x, (int)y, 32, 32);
        g.setColor(Color.RED);
        g.drawRect((int)x, (int)y, 32, 32);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 32, 32);
    }

    @Override
    public boolean isJumping() {
        return false;
    }

    @Override
    public void setJumping(boolean bool) {

    }
}
