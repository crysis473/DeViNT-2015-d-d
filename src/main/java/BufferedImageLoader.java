import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Created by user on 04/04/2015.
 */
public class BufferedImageLoader {

    private BufferedImage image;
    public BufferedImage loadImage (String path) {
        URL location = BufferedImageLoader.class.getProtectionDomain().getCodeSource().getLocation();
        String pa = location.getPath();
        String pa1 = pa.replace("/", "\\");
        String pa2 = pa1.substring(1);
        //File file = new File(getClass());
        //String absolute = file.getAbsolutePath();
        //String absolute2 = absolute;
        //File file1 = new File(absolute2);
        File file2 = new File(pa2 + path);
        try {
            image = ImageIO.read(file2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(absolute2);
        //System.out.println(file2.getAbsolutePath());
        //System.out.println(pa2+path);
        //System.out.println(file2.getAbsolutePath());
        //System.out.println("C:\\Users\\user\\Desktop\\Devint\\Devint usb\\drag-and-drop" + path);
        //System.out.println(getClass().getResource(""));
        System.out.println(pa2+path);
        return image;
    }

}
