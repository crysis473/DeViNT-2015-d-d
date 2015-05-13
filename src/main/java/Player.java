import java.awt.*;
import java.util.LinkedList;

/**
 * Created by user on 03/04/2015.
 */
public class Player extends GameObject{
    private float gravity = 0.5f;
    protected boolean falling = true;
    protected boolean jumping = false;
    private final float MAX_SPEED = 10;
    private Handler handler;
    private Texture tex = TestGame.getInstance();
    private Animation walkAnimation;

    public void setGravityX(float gravityX) {
        this.gravityX = gravityX;
    }

    private float gravityX = 0f;

    public void setWidth(float width) {
        this.width = width;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setGravity(float gravity) {
        this.gravity = gravity;
    }

    public void setFalling(boolean falling) {
        this.falling = falling;
    }

    public void setJumping(boolean jumping) {
        this.jumping = jumping;
    }

    public float getGravity() {
        return gravity;
    }

    public boolean isFalling() {
        return falling;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public boolean isJumping() {
        return jumping;
    }

    public Player(float x, float y,Handler handler, ObjectId id) {
        super(x, y, id);
        this.handler = handler;
        width = 125;
        height = 132;
        walkAnimation = new Animation(5, tex.player[0], tex.player[1], tex.player[2], tex.player[3], tex.player[4], tex.player[5], tex.player[6], tex.player[7]);
    }

    @Override
    public void tick(LinkedList<GameObject> objects) {
        x += velX;
        y += velY;
        velX += gravityX;
        velX -= gravityY;
        if(falling || jumping) {
            velY += gravity;
        }
        if(velY > MAX_SPEED) {
            velY = MAX_SPEED;}
        if(velX > 4) {
            velX = 4;
        }
        if(velX < -4) {
            velX = -4;
        }
        if(velX < 0){
            velX += 0.05f;
            if( velX > -0.01){
                velX = 0;
            }
        }
        if(velX > 0) {
            velX -= 0.05f;
            if(velX < 0.01) {
                velX = 0;
            }
        }


        collision(objects);
        walkAnimation.runAnimation();
    }
    private void collision(LinkedList<GameObject> objects) {
        for(int i = 0; i < handler.objects.size(); i++) {
            GameObject tempObject = handler.objects.get(i);
            if(tempObject.getId() == ObjectId.TestObject) {
                if(getBounds().intersects(tempObject.getBounds())) {
                    y = tempObject.getY() - height + 10;
                    velY = 0;
                    falling = false;
                    jumping = false;
                } else
                    falling = true;
                if(getBoundsRight().intersects(tempObject.getBounds())) {
                    x = tempObject.getX() - width + 37;
                }
                if(getBoundsLeft().intersects(tempObject.getBounds())) {
                    x = tempObject.getX() + tempObject.width - 35;
                }
            } else if(tempObject.getId() == ObjectId.Flag) {
                // Change the level (go to the construction level.
                if(getBounds().intersects(tempObject.getBounds()))
                    handler.changeLvl();
            }
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLUE);
        if(velX != 0)
            walkAnimation.drawAnimation(g, (int)x, (int)y);
        else
            g.drawImage(tex.player[0], (int)x,(int)y, (int)width, (int)height, null);

        /*g.fillRect((int)x, (int)y, (int)width, (int)height);
        Graphics2D g2d = (Graphics2D)g;
        g.setColor(Color.RED);
        g2d.draw(getBounds());
        g2d.draw(getBoundsRight());
        g2d.draw(getBoundsTop());
        g2d.draw(getBoundsLeft());*/

    }

    @Override
    public  Rectangle getBounds() {
        return new Rectangle((int)x + (int)width/2 - ((int)width/2)/2 + 10, (int)y +(int)height/2, (int)width/2 - 20, (int)height/2 - 10);
    }

    public Rectangle getBoundsRight() {
        return new Rectangle((int)x + (int)width - 42, (int)y + + 3+5, 5, (int)height - 10 - 20);
    }

    public Rectangle getBoundsLeft() {
        return new Rectangle((int)x - 5 + 40, (int)y + 5 + 10, 5, (int)height - 40);
    }


    public Rectangle getBoundsTop() {
        return new Rectangle((int)x + (int)width/2 - ((int)width/2)/2 + 10, (int)y, (int)width/2 - 20, (int)height/2);
    }
}
