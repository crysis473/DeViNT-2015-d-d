import java.awt.*;
import java.util.LinkedList;

/**
 * Created by user on 03/04/2015.
 */
public class Handler {
    public TestGame game;
    public LinkedList<GameObject> objects = new LinkedList<GameObject>();
    private GameObject tempObject;
    public void tick() {
        for(int i = 0; i <  objects.size(); i++) {
            tempObject = objects.get(i);
            tempObject.tick(objects);
        }
    }

    public void render(Graphics g) {
        for(int i = 0; i < objects.size(); i++) {
            tempObject = objects.get(i);
            tempObject.render(g);
        }
    }

    public void changeLvl() {
        game.ChangeLvl();
    }

    public void addObject(GameObject object) {
        objects.add(object);
    }

    public void removeObject(GameObject object) {
        objects.remove(object);
    }

}
