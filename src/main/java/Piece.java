import org.w3c.dom.css.Rect;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by user on 08/04/2015.
 */
public abstract class Piece {
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
    public Point wheel1;
    public Point wheel2;
    public Point door;
    public Point glass;
    public Point light;
    public Point wheel1Pos;
    public Point wheel2Pos;
    public Point doorPos;
    public Point glassPos;
    public Point lightPos;

    public Piece(int x, int y, String type, ElementId id) {
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
}
