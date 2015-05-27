import java.awt.*;

/**
 * Created by user on 08/04/2015.
 */
public class FoodElement extends Food {


    public FoodElement(int x, int y, String type, ElementId id) {
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
        try {
            if (type.equals("apple")) {
                image = loader.loadImage("..\\ressource\\apple.png");
            }

            else if (type.equals("bo")) {
                image = loader.loadImage("..\\ressource\\bo.png");
            }
            else if (type.equals("bol_plein")) {
                image = loader.loadImage("..\\ressource\\bol_plein.png");
            }
            else if (type.equals("egg")) {
                image = loader.loadImage("..\\ressource\\egg.png");
            }
            else if (type.equals("farine")) {
                image = loader.loadImage("..\\ressource\\farine.png");
            }
            else if (type.equals("mold")) {
                image = loader.loadImage("..\\ressource\\mold.png");
            }else if (type.equals("mold_pate")) {
                image = loader.loadImage("..\\ressource\\mold_pate.png");
            }else if (type.equals("mold_pate_bol")) {
                image = loader.loadImage("..\\ressource\\mold_pate_bol.png");
            }else if (type.equals("..\\ressource\\mold_pate_bol_apple")) {
                image = loader.loadImage("..\\ressource\\mold_pate_bol_apple.png");
            }else if (type.equals("oven")) {
            image = loader.loadImage("..\\ressource\\oven.jpeg");
            }else if (type.equals("sliced_apple")) {
                image = loader.loadImage("..\\ressource\\sliced_apple.png");
            }else if (type.equals("pate")) {
                image = loader.loadImage("..\\ressource\\pate.png");
            } else if (type.equals("")) {

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

    public Point getPoint() {
        return new Point(x + width/2, y + height/2);
    }
}
