/**
 * Created by user on 03/04/2015.
 */
public class Camera {

    private float x, y;
    boolean b = false;

    public Camera(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void tick(GameObject player) {
        if(player.getVelX() > 0)
        x += (Game.WIDTH -player.getX() - x -200) * 0.017;
        else if(player.getVelX() == 0) {
            x += (Game.WIDTH -player.getX() - x) * 0.017;
        }
        else if(player.getVelX() < 0)
            x += (Game.WIDTH -player.getX() - x + 200) * 0.017;

        y += (Game.HEIGHT -player.getY() - y + 100) * 0.04;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getX() {
        return (int)x;
    }

    public int getY() {
        return (int)y;
    }
}

