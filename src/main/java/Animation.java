import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by user on 05/04/2015.
 */
public class Animation {

    private int speed;
    private int frames;

    private int index = 0;
    private int count = 0;

    // All the images that we are going to use in the animation.
    private BufferedImage[] images;
    // The image that we are displaying at the moment.
    private BufferedImage currentImg;

    // Infinite amount of parameters containing the BufferedImage.
    public Animation(int speed, BufferedImage... args) {
        this.speed = speed;
        images = new BufferedImage[args.length];
        for(int i = 0; i < args.length; i++) {
            images[i] = args[i];
        }
        frames = args.length;
    }

    public void runAnimation() {
        index++;
        if(index > speed) {
            index = 0;
            nextFrame();
        }
    }

    private void nextFrame() {
        for(int i = 0; i <  frames; i++) {
            if(count == i) {
                currentImg = images[i];
            }
        }
        count++;
        if(count > frames)
            count = 0;
    }

    public void drawAnimation(Graphics g, int x, int y) {
        g.drawImage(currentImg, x, y, null);
    }

    public void drawAnimation(Graphics g, int x, int y, int scaleX, int scaleY) {
        g.drawImage(currentImg, x, y, scaleX, scaleY, null);
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }
    // C'est un exemple de commentaire yahoo.

}
