import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;

/**
 * Created by user on 07/04/2015.
 */
public class ConstructionGame extends Canvas implements Runnable, MouseMotionListener, MouseListener {

    public static int HEIGHT = 800, WIDTH = 1200;
    public boolean running;
    private Thread thread;
    public Piece[] pieces = new Piece[10];
    public Food[] foods = new Food[14];
    public String state = "car";
    public int score = 0;
    public String voiture = "Construire une voiture";
    public String recette = "Recette de cuisine";
    public String differences = "trouver les differnces";
    public String titre = "Paul l'assembleur";
    public boolean presqueEnd = false;
    public Window2 window2 = null;
    public Rectangle rec = new Rectangle(990 , 470 - 400, 150, 35);
    public Rectangle recQuitter = new Rectangle(990, 600, 150, 35);
    public String endMessage = " ";
    public String fin = " ";
    public boolean finCliqued = false;
    public Menu menu = new Menu();

    public synchronized void start() {
        window2= new Window2(ConstructionGame.WIDTH, ConstructionGame.HEIGHT, "TestGame", this);
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

    public void checkInPlace() {
        int n = 0;
        for (int i = 0; i < 5; i++) {
                if (pieces[i].isInPlace == true)
                    n++;
        }
        if(n == 5)
            fin = "Fin";
        System.out.println(n);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (state.equals("car")) {
            for (int i = 0; i < pieces.length; i++) {
                if (e != null && pieces[i] != null) {
                    if (pieces[i].getBounds().contains(e.getPoint())) {
                        pieces[i].isClicked = true;
                    }
                }
            }
            System.out.println("x -> " + e.getX() + ", y -> " + e.getY());
        }
            if( !fin.equals(" ") && rec.contains(e.getPoint())) {
                System.out.println(finCliqued);
                if(score > 40) {
                    endMessage = "Excenllent !!";
                }
                else if(score <= 40 && score >20)
                    endMessage = "Bien !";
                else if(score <= 20 && score >= 0)
                    endMessage = "Moyen.";
                else if(score < 0)
                    endMessage = "Perdu !";
                finCliqued = true;
            }

        if(recQuitter.contains(e.getPoint())) {
            menu.start();
            window2.frame.setVisible(false);
            window2.frame.dispose();
        }


    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (state.equals("car")) {
            for (int i = 0; i < pieces.length; i++) {
                if (e != null && pieces[i] != null) {
                    if (pieces[i].getBounds().contains(e.getPoint())) {
                        pieces[i].isClicked = false;
                    }
                }
            }
            if (pieces[5].getBounds().contains(pieces[0].wheel1)) {
                pieces[5].x = (int) pieces[0].wheel1.getX() - 54;
                pieces[5].y = (int) pieces[0].wheel1.getY() - 56;
                if (pieces[5].isInPlace == false)
                    score = score + 10;
                pieces[5].isInPlace = true;
            } else {
                if (pieces[5].x != 10) {
                    pieces[5].x = 10;
                    pieces[5].y = 10;
                    score = score - 5;
                }
            }
            if (pieces[1].getBounds().contains(pieces[0].wheel2)) {
                pieces[1].x = (int) pieces[0].wheel2.getX() - 51;
                pieces[1].y = (int) pieces[0].wheel2.getY() - 61;
                if (pieces[1].isInPlace == false)
                    score = score + 10;
                pieces[1].isInPlace = true;
            } else {
                if (pieces[1].x != 10) {
                    pieces[1].x = 10;
                    pieces[1].y = 130;
                    score = score - 5;
                }
            }
            if (pieces[2].getBounds().contains(pieces[0].door)) {
                pieces[2].x = (int) pieces[0].door.getX() - 106;
                pieces[2].y = (int) pieces[0].door.getY() - 60;
                if (pieces[2].isInPlace == false)
                    score = score + 10;
                pieces[2].isInPlace = true;
            } else {
                if (pieces[2].x != 10) {
                    pieces[2].x = 10;
                    pieces[2].y = 250;
                    score = score - 5;
                }
            }
            if (pieces[3].getBounds().contains(pieces[0].glass)) {
                pieces[3].x = (int) pieces[0].glass.getX() - 73;
                pieces[3].y = (int) pieces[0].glass.getY() - 24;
                if (pieces[3].isInPlace == false)
                    score = score + 10;
                pieces[3].isInPlace = true;
            } else {
                if (pieces[3].x != 10) {
                    pieces[3].x = 10;
                    pieces[3].y = 370;
                    score = score - 5;
                }
            }
            if (pieces[4].getBounds().contains(pieces[0].light)) {
                pieces[4].x = (int) pieces[0].light.getX() - 35;
                pieces[4].y = (int) pieces[0].light.getY() - 16;
                if (pieces[4].isInPlace == false)
                    score = score + 10;
                pieces[4].isInPlace = true;
            } else {
                if (pieces[4].x != 10) {
                    pieces[4].x = 10;
                    pieces[4].y = 424;
                    score = score - 5;
                }
            }
        }
        checkInPlace();
    }


    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(state.equals("car")) {
            for (int i = 0; i < pieces.length; i++) {
                if (e != null && pieces[i] != null) {
                    if (pieces[i].id == ElementId.Element) {
                        if (pieces[i].isClicked == true) {
                            pieces[i].x = e.getX() - pieces[i].width / 2;
                            pieces[i].y = e.getY() - pieces[i].height / 2;
                        }
                    }
                }
            }
        }
        if(state.equals("recipe")) {
            for (int i = 0; i < foods.length; i++) {
                if (foods[i] != null) {
                    if (foods[i].id == ElementId.FoodElement) {
                        if (foods[i].isClicked == true) {
                            foods[i].x = e.getX() - foods[i].width / 2;
                            foods[i].y = e.getY() - foods[i].height / 2;
                        }
                    }
                }
            }
        }
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
        if(state.equals("car")) {
            pieces[0] = new Car(230, 400, "car", ElementId.Car);
            pieces[5] = new Element(10, 10, "wheel1", ElementId.Element);
            pieces[1] = new Element(10, 130, "wheel2", ElementId.Element);
            pieces[2] = new Element(10, 250, "door", ElementId.Element);
            pieces[3] = new Element(10, 370, "glass", ElementId.Element);
            pieces[4] = new Element(10, 424, "light", ElementId.Element);
            //pieces[5] = new Car(100, pieces[4].y + 50 + 5, "car", ElementId.Car);
            for (int i = 0; i < 6; i++) {
                pieces[i].loadImage();
            }
        }
        if(state.equals("recipe")) {
            foods[5] = new FoodElement(10, 10, "egg", ElementId.FoodElement);
            foods[6] = new FoodElement(10, 115, "farine", ElementId.FoodElement);
            foods[2] = new FoodElement(10, 245, "apple", ElementId.FoodElement);
            foods[3] = new FoodElement(getWidth() - 320 - 10, 5, "oven", ElementId.Car);
            foods[1] = new FoodElement(240, 100, "bo", ElementId.Car);
            foods[0] = new FoodElement(400, 300, "mold", ElementId.Car);
            foods[4] = new FoodElement(10, 400, "pate", ElementId.FoodElement);

            for (int i = 0; i < 7; i++) {
                foods[i].loadImage();
            }
        }
        if(state.equals("menu")) {
            //Nothing
        }
    }

    private void render() {

            if(this.getBufferStrategy() == null) {
                this.createBufferStrategy(2);}
            BufferStrategy bs = this.getBufferStrategy();
            //if (bs == null) {

            //} if(running) {*/
            Graphics g = bs.getDrawGraphics();
            Graphics2D g2d = (Graphics2D)g;
            if(state.equals("car")) {
                g.setColor(Color.CYAN);
                g.fillRect(0, 0, WIDTH + 300, HEIGHT);
                for (int i = 0; i < 6; i++) {
                    pieces[i].render(g);
            }

                Font fnt1 = new Font("arial", Font.BOLD, 30);
                g.setFont(fnt1);
            g.drawString("SCORE : " + score + "/50", 200, 50);
                g.setColor(Color.red);
                g2d.draw(recQuitter);
                g.setFont(fnt1);
                g.drawString("QUITER", 995, 625);
                g.setColor(Color.BLACK);
                g.drawString(fin, 1000 + 40, 500 - 400);
                g2d.draw(rec);
                if(finCliqued == true) {
                    g.setColor(Color.CYAN);
                    Font fnt2 = new Font("arial", Font.BOLD, 80);
                    g.setFont(fnt2);
                    g.fillRect(0, 0, WIDTH + 300, HEIGHT);
                    g.setColor(Color.RED);
                    g.drawString(endMessage, 400, 300);
                    g.drawString("SCORE : " + score + "/50", 200, 80);
                    g.setColor(Color.red);
                    g2d.draw(recQuitter);
                    g.setFont(fnt1);
                    g.drawString("QUITER", 995, 625);
                }
                bs.show();
            //}
            //System.out.println("Rendering !!");
        }

        /*if(state.equals("recipe")) {
            g.setColor(Color.CYAN);
            g.fillRect(0, 0, WIDTH + 300, HEIGHT);
            for (int i = 0; i < 7; i++) {
                //if(presqueEnd == true && (i == 0||i == 3)) {
                    foods[i].render(g);
                //}
            }
            g.drawString("SCORE : " + score + "/50", 200, 10);
            g.setColor(Color.BLACK);
            g.drawString(fin, 1000, 500);
            g2d.draw(rec);
            bs.show();
        }*/
    }

    public void isAlive() {
        System.out.println("j");
    }

    public String getState() {
        return this.state;
    }

}
