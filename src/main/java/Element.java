import java.awt.*;

/**
 * Created by user on 08/04/2015.
 */
public class Element extends Piece {


    public Element(int x, int y, String type, ElementId id) {
        super(x, y, type, id);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(image, x, y, null);
        g.setColor(Color.red);
        //g.drawRect(x, y, width, height);
    }

    public void loadImage() {
       System.out.println(this.type);
        try {
           if (type.equals("wheel1")) {
               image = loader.loadImage("..\\ressource\\wheel1.png");
           }

           else if (type.equals("wheel2")) {
               image = loader.loadImage("..\\ressource\\wheel2.png");
           }
           else if (type.equals("door")) {
               image = loader.loadImage("..\\ressource\\door.png");
           }
           else if (type.equals("glass")) {
               image = loader.loadImage("..\\ressource\\glass.png");
           }
           else if (type.equals("light")) {
               image = loader.loadImage("..\\ressource\\light.png");
           }

           width = image.getWidth();
           height = image.getHeight();
       } catch (Exception e) {
           e.printStackTrace();
       }
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}
