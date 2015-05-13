
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * Created by user on 02/04/2015.
 */
public class TestGame extends Canvas implements Runnable, MouseMotionListener, MouseListener {

    private static Texture tex;
    public boolean running;
    public Thread thread;
    private GameObject object;
    final public static int WIDTH = /*950*/ 1050;
    final public static int HEIGHT = 800; //650
    public Window window;
    public Window2 window2;
    //Object
    private Handler handler;
    //Camera
    private Camera cam;
    private Random r = new Random();
    private BufferedImage level = null;
    //The level
    public static int LEVEL = 1;


    private void init() {
        BufferedImageLoader loader = new BufferedImageLoader();
        level = loader.loadImage("/level.png"); // Loading the level.
        handler = new Handler();
        handler.game = this;
        //handler.setWindow(window);
        cam = new Camera(0,0);
        tex = new Texture();
        loadImageLevel(level);
        //handler.addObject(new Player(100, 100, handler, ObjectId.Player));
        //handler.createLevel();
        this.addKeyListener(new KeyInput(handler));
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
    }

    private void loadImageLevel(BufferedImage image) {
        int w = image.getWidth();
        int h = image.getHeight();

        System.out.println("Width, Height" + w + " " + h);

        for(int xx = 0; xx < h; xx++) {
            for(int yy = 0; yy < w; yy++) {
                int pixel = image.getRGB(xx, yy);
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = (pixel) & 0xff;

                if(red == 255 && green == 255 && blue == 255) handler.addObject(new TestObject(xx*48, yy*48, 0,  ObjectId.TestObject));
                if(red == 0 && green == 255 && blue == 0) handler.addObject(new TestObject(xx*48, yy*48, 1, ObjectId.TestObject));
                if(red == 0 && green == 0 && blue == 255) handler.addObject(new Player(xx*32, yy*32, handler, ObjectId.Player));
                if(red == 255 && green == 0 && blue == 0) handler.addObject(new TestObject(xx*48, yy*48,3, ObjectId.TestObject));
                if(red == 255 && green == 255 && blue == 0) handler.addObject(new TestObject(xx*48, yy*48,2, ObjectId.TestObject));
                if(red == 120 && green == 120 && blue == 120) handler.addObject(new RockObject(500, 1056,0, ObjectId.RockObject));
                if(red == 120 && green == 120 && blue == 120) handler.addObject(new RockObject(500 + 511, 1056,0, ObjectId.RockObject));
                if(red == 120 && green == 120 && blue == 120) handler.addObject(new RockObject(500 + 511 + 511, 1056,1, ObjectId.RockObject));
                if(red == 120 && green == 120 && blue == 120) handler.addObject(new RockObject(500 + 511 + 511 + 511, 1056,1, ObjectId.RockObject));
                if(red == 120 && green == 120 && blue == 120) handler.addObject(new RockObject(500 + 511 + 511 + 511 + 511 -200, 1056,0, ObjectId.RockObject));
                if(red == 120 && green == 120 && blue == 120) handler.addObject(new RockObject(500 + 511 + 511 + 511 + 511 -200 + 511, 1056,0, ObjectId.RockObject));
                if(red == 120 && green == 120 && blue == 120) handler.addObject(new RockObject(500 + 511 + 511 + 511 + 511 -200 + 511 + 511, 1056,0, ObjectId.RockObject));
                if(red == 120 && green == 120 && blue == 120) handler.addObject(new RockObject(500 - 511, 1056,0, ObjectId.RockObject));
                if(red == 120 && green == 120 && blue == 120) handler.addObject(new RockObject(500 - 511, 1056,0, ObjectId.RockObject));
                if(red == 100 && green == 100 && blue == 100) handler.addObject(new Flag(500 + 511 + 4100 , 800, ObjectId.Flag));


            }
        }
    }

    public synchronized void start() {
        if(running)
            return;

        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public void ChangeLvl() {
        window.changeGame();
        //window2.changeGame();
        //window.frame.add(construction);
    }

    public void run() {
        init();
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int updates = 0;
        int frames = 0;
        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                tick();
                updates++;
                delta--;
            }
            render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                frames = 0;
                updates = 0;
            }
        }
    }

    private void tick() {
        handler.tick();
        for (int i = 0; i < handler.objects.size(); i++) {
            if (handler.objects.get(i).getId() == ObjectId.Player) {
                cam.tick(handler.objects.get(i));
            }
        }
    }

    private void render() {

        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null) {
            this.createBufferStrategy(2);
            return;
        }
        if(running) {
        Graphics g = bs.getDrawGraphics();

        Graphics2D g2d = (Graphics2D)g;
        /////////////////////////////////////////////////////
        // Draw here everything in relation to the game.
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, getWidth(), getHeight());
        g2d.translate(cam.getX()/10, 0);
        g.drawImage(tex.back, 0, 0, null);
        g2d.translate(-cam.getX()/10,0);
        g2d.translate(cam.getX(), cam.getY());
        handler.render(g);
        g2d.translate(-cam.getX(), -cam.getY());
        /////////////////////////////////////////////////////
        g.dispose();
        g2d.dispose();
        bs.show();}
    }

    public static void main(String[] args) {
        //TestGame game = new TestGame();
        //game.window = new Window(TestGame.WIDTH, TestGame.HEIGHT, "TestGame", game);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println(e.getX());
        System.out.println(e.getY());
        /*for(int i = 0; i < handler.objects.size(); i++) {
            GameObject tempObject = handler.objects.get(i);
            if (tempObject.getId() == ObjectId.Player) {
                if(e.getX() > tempObject.getX() && e.getX() < tempObject.getX() + tempObject.getWidth() && e.getY() > tempObject.getY() && e.getY() < tempObject.getY() + tempObject.getHeight()) {
                    tempObject.setX(e.getX() - tempObject.getWidth()/2);
                    tempObject.setY(e.getY() - tempObject.getHeight()/2);
                }
            } else return;
        }*/
        for(int i = 0; i < handler.objects.size(); i++) {
            GameObject tempObject = handler.objects.get(i);
            if(tempObject.isClicked()) {
                tempObject.setX(e.getX() - tempObject.getWidth()/2);
                tempObject.setY(e.getY() - tempObject.getHeight()/2);
                System.out.println("Dragged");
            }
        }
    }

    public static Texture getInstance() {
        return tex;
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject tempObject = handler.objects.get(i);
            if (tempObject.getId() == ObjectId.Player) {
                if (e.getX() > tempObject.getX() && e.getX() < tempObject.getX() + tempObject.getWidth() && e.getY() > tempObject.getY() && e.getY() < tempObject.getY() + tempObject.getHeight()) {
                    tempObject.setClicked(true);
                    System.out.println("clicked");
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject tempObject = handler.objects.get(i);
            if (tempObject.getId() == ObjectId.Player) {
                if (e.getX() > tempObject.getX() && e.getX() < tempObject.getX() + tempObject.getWidth() && e.getY() > tempObject.getY() && e.getY() < tempObject.getY() + tempObject.getHeight()) {
                    tempObject.setClicked(true);
                    System.out.println("pressed");
                }
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject tempObject = handler.objects.get(i);
            tempObject.setClicked(false);
            System.out.println("relased");
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public Handler getHandler() {
        return handler;
    }
}
