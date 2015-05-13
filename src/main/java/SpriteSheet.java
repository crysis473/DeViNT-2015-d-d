import java.awt.image.BufferedImage;

/**
 * Created by user on 04/04/2015.
 */
public class SpriteSheet {

    private BufferedImage image;

    public SpriteSheet(BufferedImage image) {
        this.image = image;
    }

    public BufferedImage grabImage(int col, int row, int width, int height) {
        BufferedImage tempImg = image.getSubimage((col * width) - width + 1, (row * height) - height, width, height);
        return tempImg;
    }

}
