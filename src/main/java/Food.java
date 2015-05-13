import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Food {
    public int x;
    public int y;
    public BufferedImage image;
    public int height;
    public int width;
    public ElementId id;
    public String type;
    public BufferedImageLoader loader;
    public boolean isClicked;
    public boolean isInPlace;
    public Point apple;
    public Point sliced_apple;
    public Point bol;
    public Point bol_plein;
    public Point egg;
    public Point farine;
    public Point mold;
    public Point mold_pate;
    public Point mold_pate_bol;
    public Point getMold_pate_bol_apple;
    public Point oven;
    public Point Sliced_apple;
    public boolean fixedFarine = false;
    public boolean fixedEgg = false;
    public boolean isPeeled = false;
    public boolean isPate = false;
    public boolean isFull = false;
    public boolean isAppeled = false;
    public boolean noRen = false;

    public Food(int x, int y, String type, ElementId id) {
        this.x = x;
        this.y = y;
        this.id = id;
        loader = new BufferedImageLoader();
        this.type = type;
    }

    public abstract void loadImage();

    public abstract void tick();

    public abstract void render(Graphics g);

    public abstract Rectangle getBounds();

    public abstract Point getPoint();

}