import java.awt.*;
import java.util.LinkedList;

/**
 * Created by user on 02/04/2015.
 */
public class RockObject extends GameObject {
    private int type;
    public RockObject(float x, float y,int type, ObjectId id) {
        super(x, y, id);
        this.type = type;
        this.width = 512;
        this.height = 512;
    }
    private Texture tex = TestGame.getInstance();

    @Override
    public void tick(LinkedList<GameObject> object) {

    }

    @Override
    public void render(Graphics g) {
        if(type == 0) { //Rock block/
            g.drawImage(tex.rock[0], (int)x, (int)y, null);
            g.setColor(Color.red);
           // g.drawRect((int)x, (int)y, (int) width, (int)height);

        }
        if(type == 1) { //Rock block/
            g.drawImage(tex.rock[1], (int) x, (int)y, null);
            g.setColor(Color.red);
            // g.drawRect((int)x, (int)y, (int) width, (int)height);

        }
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, (int)width, (int)height);
    }

    @Override
    public boolean isJumping() {
        return false;
    }

    @Override
    public void setJumping(boolean bool) {

    }

    public int getWidth() {
        return (int)width;
    }

    public int getHeight() {
        return (int)height;
    }

}
