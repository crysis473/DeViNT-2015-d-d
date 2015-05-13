import java.awt.*;

/**
 * Created by user on 08/04/2015.
 */
public class Car extends Piece {

    public Car(int x, int y, String type, ElementId id) {
        super(x, y, type, id);
        isInPlace = true;
        isClicked = false;
        wheel1 = new Point(x + 622, y + 175);
        wheel2 = new Point(x + 143, y + 179);
        glass = new Point(x + 419, y + 52);
        door = new Point(x + 387, y + 128);
        light = new Point(x + 56, y + 117);
        //wheel1Pos = new Point(x)
    }

    @Override
    public void loadImage() {
        try { image = loader.loadImage("..\\ressource\\car.png");
        width = image.getWidth();
        height = image.getHeight();
            width = image.getWidth();
            height = image.getHeight();} catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(image, x, y, null);
        g.setColor(Color.RED);
        /*g.drawRect(x, y, width, height);
        g.drawRect((int)wheel1.getX(), (int)wheel1.getY(), 2, 2);
        g.drawRect((int)wheel2.getX(), (int)wheel2.getY(), 2, 2);
        g.drawRect((int)glass.getX(), (int)glass.getY(), 2, 2);
        g.drawRect((int)door.getX(), (int)door.getY(), 2, 2);
        g.drawRect((int)light.getX(), (int)light.getY(), 2, 2);*/



    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
    // Le menu changes evidement !!!
    //kanban.
}
