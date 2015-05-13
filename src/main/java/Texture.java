import java.awt.image.BufferedImage;

/**
 * Created by user on 04/04/2015.
 */
public class Texture {

    public SpriteSheet bs, ps, rs, ws;
    private BufferedImage blockSheet = null;
    private BufferedImage playerSheet = null;
    private BufferedImage rockSheet = null;
    private BufferedImage watSheet = null;

    public BufferedImage[] block = new BufferedImage[4];
    //This contains the textures of the palyer.
    public BufferedImage[] player = new BufferedImage[10];
    public BufferedImage[] rock = new BufferedImage[2];
    public BufferedImage back;
    public BufferedImage wat;


    public Texture() {

        BufferedImageLoader loader = new BufferedImageLoader();

        try{
            blockSheet = loader.loadImage("/tex.png");
            playerSheet = loader.loadImage("/player.png");
            rockSheet = loader.loadImage(("/rock.jpg"));
            back = loader.loadImage("/back.jpg");
            wat = loader.loadImage("/wat.jpg");
        } catch(Exception e) {
            e.printStackTrace();
        }

        bs = new SpriteSheet(blockSheet);
        ps = new SpriteSheet(playerSheet);
        rs = new SpriteSheet(rockSheet);
        ws = new SpriteSheet(wat);
        getTextures();
    }

    private void getTextures() {
        block[0] = bs.grabImage(3, 1, 48, 48); //Grass.
        block[1] = bs.grabImage(4, 1, 48, 48); //Grass block.
        block[2] = bs.grabImage(7, 5, 48, 48); // Bambou
        block[3] = bs.grabImage(1, 10, 48, 48); // eau.
        //Adding the player textures icons.
        player[0] = ps.grabImage(1, 1, 123, 132);
        player[1] = ps.grabImage(2, 1, 124, 132);
        player[2] = ps.grabImage(3, 1, 125, 132);
        player[3] = ps.grabImage(4, 1, 126, 132);
        player[4] = ps.grabImage(5, 1, 127, 132);
        player[5] = ps.grabImage(6, 1, 127, 132);
        player[6] = ps.grabImage(7, 1, 127, 132);
        player[7] = ps.grabImage(8, 1, 127, 132);
        player[8] = ps.grabImage(1, 2, 127, 132);
        player[9] = ps.grabImage(2, 2, 127, 132);

        rock[0] = rs.grabImage(1, 1, 511, 511);
        rock[1] = ws.grabImage(1,1, 511, 300);

    }

    public static void main(String[] args) {
        System.out.println("Hello World");
    }



}
