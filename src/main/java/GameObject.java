import java.awt.*;
import java.util.LinkedList;

/**
 * Created by user on 02/04/2015.
 */
public abstract class GameObject {
    protected float width;
    protected float height;
    protected float x, y;
    protected float velX, velY;
    protected ObjectId id;
    protected boolean clicked;

    public void setGravityY(float gravityY) {
        this.gravityY = gravityY;
    }

    protected float gravityX = 0;
    protected float gravityY = 0;

    public GameObject(float x, float y, ObjectId id) {
        this.x = x;
        this.y = y;
        this.id = id;
        clicked = false;
    }

    public abstract void tick(LinkedList<GameObject> object);

    public abstract void render(Graphics g);

    public abstract Rectangle getBounds();

    public abstract boolean isJumping();

    public abstract void setJumping(boolean bool);

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getVelX() {
        return velX;
    }

    public float getVelY() {
        return velY;
    }

    public void setVelX(float velX) {
        this.velX = velX;
    }

    public void setVelY(float velY) {
        this.velY = velY;
    }

    public void setGravityX(float gravityX) {
        this.gravityX = gravityX;
    }

    public ObjectId getId() {
        return id;
    }

    public int getWidth() {
        return (int)width;
    }

    public int getHeight() {
        return (int)height;
    }

    public boolean isClicked() {
        return clicked;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }
}
