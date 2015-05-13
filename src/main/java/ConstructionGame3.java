import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;

/**
 * Created by user on 07/04/2015.
 */
public class ConstructionGame3 extends Canvas implements Runnable, MouseMotionListener, MouseListener {

    public static int HEIGHT = 700, WIDTH = 1200;
    public boolean running;
    private Thread thread;
    public Food[] foods = new Food[14];
    public String state = "menu";
    public int score = 0;
    public String voiture = "Construire une voiture";
    public String recette = "Recette de cuisine";
    public String differences = "trouver les differnces";
    public String titre = "Paul l'assembleur";
    public boolean presqueEnd = false;
    public Window2 window2 = null;
    public ConstructionGame2 game2 = null;
    public ConstructionGame game1 = null;



    public synchronized void start() {
        window2= new Window2(ConstructionGame.WIDTH, ConstructionGame.HEIGHT, "Assemblage", this);
        if (running)
            this.run();

        running = true;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
       /* for(int i = 0; i < pieces.length; i++) {
            if(pieces[i].getBounds().contains(e.getPoint())) {
                pieces[i].isClicked = true;
            }
        }*/
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {


    }


    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {



    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void run() {
        setCursor(new Cursor(Cursor.HAND_CURSOR));

        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.loadImages();
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int updates = 0;
        int frames = 0;
        System.out.println("enter run");
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                updates++;
                delta--;
            }
            render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                frames = 0;
                updates = 0;
            }
        }
    }

    private void tick() {
        //handler.tick();
    }

    private void loadImages() {

    }

    private void render() {

        if (this.getBufferStrategy() == null) {
            this.createBufferStrategy(2);
        }
        BufferStrategy bs = this.getBufferStrategy();
        //if (bs == null) {

        //} if(running) {*/
        Graphics g = bs.getDrawGraphics();
        Graphics2D g2d = (Graphics2D) g;

            //TODO
            Font fnt1 = new Font("Courrier", Font.BOLD, 30);
            g2d.setColor(Color.CYAN);
            g.fillRect(0, 0, WIDTH + 300, HEIGHT);
            g2d.setColor(Color.YELLOW);
            g2d.setFont(fnt1);
            g2d.drawString(voiture, 300, 300);


    }

    public void isAlive() {
        System.out.println("j");
    }

    public String getState() {
        return this.state;
    }

}
