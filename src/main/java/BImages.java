import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

/**
 * Created by user on 31/03/2015.
 */
public class BImages {
    private static String WHEEL = "C:\\Users\\user\\Desktop\\hioo\\wheel.png";
    private static String DOOR = "C:\\Users\\user\\Desktop\\hioo\\door1.png";
    private static String CARCASS = "C:\\Users\\user\\Desktop\\hioo\\carcass.png";
    private static String LIGHT = "C:\\Users\\user\\Desktop\\hioo\\light.png";
    private static String GLASS = "C:\\Users\\user\\Desktop\\hioo\\glass.png";
    public URL urlToImage = this.getClass().getResource("wheel.png");
    BufferedImage wheel;
    BufferedImage wheel2;
    BufferedImage carcass;
    BufferedImage door;
    BufferedImage glass;
    BufferedImage light;
    int wheelX = 0;
    int wheelY = 0;
    int carcassY = 340;
    int carcassX = 80;
    int wheel2Y = 70;
    int wheel2X = 5;
    int doorY = 140;
    int doorX = 5;
    int glassX = 5;
    int glassY = 210;
    int lightX = 5;
    int lightY = 250;

    public BImages() {
        try {
            wheel = ImageIO.read(new File(WHEEL));
            wheel2 = ImageIO.read(new File(WHEEL));
            door = ImageIO.read(new File(DOOR));
            carcass = ImageIO.read(new File(CARCASS));
            glass = ImageIO.read(new File(GLASS));
            light = ImageIO.read(new File(LIGHT));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getX(BufferedImage element) {
        if(light.equals(element)) {
            return lightX;
        } else if(wheel.equals(element)) {
            return 5;
        } else if(wheel2.equals(element)) {
            return wheel2X;
        } else if(door.equals(element)) {
            return doorX;
        } else if(carcass.equals(element)) {
            return carcassX;
        } else if(glass.equals(element)) {
            return glassX;
        } else if(light.equals(element)) {
            return lightX;
        } else return 0;
    }

    public int getY(BufferedImage element) {
        if(light.equals(element)) {
            return lightY;
        } else if(wheel.equals(element)) {
            return 5;
        } else if(wheel2.equals(element)) {
            return wheel2Y;
        } else if(door.equals(element)) {
            return doorY;
        } else if(carcass.equals(element)) {
            return carcassY;
        } else if(glass.equals(element)) {
            return glassY;
        } else if(light.equals(element)) {
            return lightY;
        } else return 0;
    }

    public int getWidth(BufferedImage element) {
        if(light.equals(element)) {
            return light.getWidth();
        } else if(wheel.equals(element)) {
            return wheel.getWidth();
        } else if(wheel2.equals(element)) {
            return wheel2.getWidth();
        } else if(door.equals(element)) {
            return door.getWidth();
        } else if(carcass.equals(element)) {
            return carcass.getWidth();
        } else if(glass.equals(element)) {
            return glass.getWidth();
        } else if(light.equals(element)) {
            return light.getWidth();
        } else return 0;
    }

    public int getHeight(BufferedImage element) {
        if(light.equals(element)) {
            return light.getHeight();
        } else if(wheel.equals(element)) {
            return wheel.getHeight();
        } else if(wheel2.equals(element)) {
            return wheel2.getHeight();
        } else if(door.equals(element)) {
            return door.getHeight();
        } else if(carcass.equals(element)) {
            return carcass.getHeight();
        } else if(glass.equals(element)) {
            return glass.getHeight();
        } else if(light.equals(element)) {
            return light.getHeight();
        } else return 0;
    }

    public void setX(BufferedImage element, int number) {
        if(light.equals(element)) {
            lightX = number;
        } else if(wheel.equals(element)) {
            wheelX = number;
        } else if(wheel2.equals(element)) {
            wheel2X = number;
        } else if(door.equals(element)) {
            doorX = number;
        } else if(carcass.equals(element)) {
            carcassX = number;
        } else if(glass.equals(element)) {
            glassX = number;
        } else if(light.equals(element)) {
            lightX = number;
        } else return;
    }

    public void setY(BufferedImage element, int number) {
        if(light.equals(element)) {
            lightY = number;
        } else if(wheel.equals(element)) {
            wheelY = number;
        } else if(wheel2.equals(element)) {
            wheel2Y = number;
        } else if(door.equals(element)) {
            doorY = number;
        } else if(carcass.equals(element)) {
            carcassY = number;
        } else if(glass.equals(element)) {
            glassY = number;
        } else if(light.equals(element)) {
            lightY = number;
        } else return;
    }


}
