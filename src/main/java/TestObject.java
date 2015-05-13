import java.awt.*;
import java.util.LinkedList;

/**
 * Created by user on 02/04/2015.
 */
public class TestObject extends GameObject {
    private int type;
    public TestObject(float x, float y,int type, ObjectId id) {
        super(x, y, id);
        this.type = type;
        this.width = 48;
        this.height = 48;
    }
    private Texture tex = TestGame.getInstance();

    @Override
    public void tick(LinkedList<GameObject> object) {

    }

    @Override
    public void render(Graphics g) {
        if(type == 0) { //Rock block/
            g.drawImage(tex.block[0], (int)x, (int)y, null);

        }
        if(type == 1) { //Grass block.
            g.drawImage(tex.block[1], (int)x, (int)y, null);
        }
        if(type == 2) { // Bambou.
            g.drawImage(tex.block[2], (int) x, (int) y, null);
        }
        if(type == 3) { // Bambou.
            g.drawImage(tex.block[3], (int) x, (int) y, null);
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
