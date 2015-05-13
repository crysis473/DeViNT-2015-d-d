import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;

/**
 * Created by user on 07/04/2015.
 */
public class ConstructionGame2 extends Canvas implements Runnable, MouseMotionListener, MouseListener {

    public static int HEIGHT = 700, WIDTH = 900;
    public boolean running;
    private Thread thread;
    public Food[] foods = new Food[14];
    public String state = "recipe";
    public int score = 0;
    public String voiture = "Construire une voiture";
    public String recette = "Recette de cuisine";
    public String differences = "trouver les differnces";
    public String titre = "Paul l'assembleur";
    public boolean presqueEnd = false;
    public Window2 window2 = null;
    public String four = "";
    public boolean fourCliqued = false;
    public Rectangle rec = new Rectangle(990 , 470, 150, 35);
    public Rectangle recQuitter = new Rectangle(990, 600, 150, 35);
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

    @Override
    public void mousePressed(MouseEvent e) {
        if (state.equals("recipe")) {
            for (int i = 0; i < foods.length; i++) {
                if (e != null && foods[i] != null) {
                    if (foods[i].getBounds().contains(e.getPoint())) {
                        foods[i].isClicked = true;
                    }
                }
            }
            System.out.println("x -> " + e.getX() + ", y -> " + e.getY());

            if (foods[2].getBounds().contains(e.getPoint())) {
                foods[2] = new FoodElement(10, 275, "sliced_apple", ElementId.FoodElement);
                foods[2].loadImage();
                foods[2].isClicked = true;
                foods[2].isPeeled = true;
            }
        }
        if(!four.equals("") && rec.contains(e.getPoint())) {
            fourCliqued = true;
            score = score + 10;
        }
        if(recQuitter.contains(e.getPoint())) {
            menu.start();
            window2.frame.setVisible(false);
            window2.frame.dispose();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

            for (int i = 0; i < 7; i++) {
                if (foods[i] != null) {
                    if (foods[i].getBounds().contains(e.getPoint())) {
                        foods[i].isClicked = false;
                    }
                }
            }
            if(foods[1].getBounds().contains(foods[5].getPoint())) {
                foods[5].x = -100; foods[5].y = -100;
                foods[5].noRen = true;
                Food f = foods[1];
                foods[1] = new FoodElement(f.x, f.y, "bol_plein", ElementId.Car );
                foods[1].loadImage();
                if(f.fixedFarine == true) {
                    foods[1].fixedFarine = true;
                }
                if(foods[1].fixedEgg == false)
                    score = score + 10;
                foods[1].fixedEgg = true;
                foods[5].isInPlace = true;
                if(foods[1].fixedEgg == true && foods[1].fixedFarine == true) {
                    foods[1].id = ElementId.FoodElement;
                }
            } else {
                if (foods[5].x != 10 && foods[5].isInPlace == false && foods[1].isInPlace == false) {
                    foods[5].x = 10;
                    foods[5].y = 10;
                    score = score - 5;
                }
            }
            if(foods[1].getBounds().contains(foods[3].getPoint())) {
                foods[3].x = -150; foods[3].y = -150;
                if(foods[1].fixedFarine == false)
                    score = score + 10;
                foods[1].fixedFarine = true;
                foods[3].isInPlace = true;
                if(foods[1].fixedEgg == true && foods[1].fixedFarine == true) {
                    foods[1].id = ElementId.FoodElement;
                }
            } else {
                if (foods[3].x != 10 && foods[3].isInPlace == false) {
                    foods[3].x = 10;
                    foods[3].y = 115;
                    score = score - 5;
                }
            }
            /*if(foods[2].type.equals("sliced_apple") && foods[0].isFull == true && foods[0].getBounds().contains(foods[2].getPoint()) && foods[2].isPeeled) {
                System.out.println("pate");
                foods[2].x = -300; foods[2].y = -300;
                foods[2].noRen = true;
                Food f = foods[0];
                System.out.println("draa");
                if(foods[0].isAppeled == false) {
                    score = score + 10;
                    foods[0].isAppeled = true;
                }
                foods[2].isInPlace = true;
                foods[1].isInPlace = true;
            } else {
                if (foods[2].x != 10 && foods[2].isInPlace == false) {
                    foods[2].x = 10;
                    foods[2].y = 275;
                    score = score - 5;
                }
            }*/
            if(foods[0].getBounds().contains(foods[4].getPoint())) {
                foods[4].x = -300; foods[4].y = -300;
                foods[4].noRen = true;
                Food f = foods[0];
                foods[0] = new FoodElement(f.x, f.y, "mold_pate", ElementId.Car );
                foods[0].loadImage();
                System.out.println(foods[0].isPate);
                if(foods[0].isPate == false) {
                    score = score + 10;
                    foods[0].isPate = true;
                }
                foods[4].isInPlace = true;
                System.out.println(foods[0].isPate);
            } else {
                if (foods[4].x != 10 && foods[4].isInPlace == false) {
                    foods[4].x = 10;
                    foods[4].y = 400;
                    score = score - 5;
                }
            }
            if(foods[2].getBounds().contains(foods[0].getPoint()) && foods[0].isFull == true) {
                four = "Au Four";
            }
            if(foods[1].getBounds().contains(foods[0].getPoint()) && foods[0].isPate) {
                System.out.println("pate");
                foods[1].x = -300; foods[1].y = -300;
                foods[1].noRen = true;
                foods[1].isInPlace = true;
                Food f = foods[0];
                foods[0] = new FoodElement(f.x, f.y, "mold_pate_bol", ElementId.Car );
                foods[0].loadImage();
                if(foods[0].isFull == false) {
                    score = score + 10;
                    foods[0].isFull = true;
                }
                foods[0].isInPlace = true;
                System.out.println(foods[0].isPate);
            } else {
                if (foods[1].x != 240 && foods[1].isInPlace == false && foods[1].id == ElementId.FoodElement) {
                    foods[1].x = 240;
                    foods[1].y = 100;
                    score = score - 5;
                }
            }
    }


    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

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

            foods[5] = new FoodElement(10, 10, "egg", ElementId.FoodElement);
            foods[3] = new FoodElement(10, 115, "farine", ElementId.FoodElement);
            foods[2] = new FoodElement(10, 245, "apple", ElementId.FoodElement);
            foods[6] = new FoodElement(getWidth() - 320 - 10, 5, "oven", ElementId.Car);
            foods[1] = new FoodElement(240, 100, "bo", ElementId.Car);
            foods[0] = new FoodElement(400, 300, "mold", ElementId.Car);
            foods[4] = new FoodElement(10, 400, "pate", ElementId.FoodElement);

            for (int i = 0; i < 7; i++) {
                foods[i].loadImage();
            }

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
        if(state == "recipe") {
            g.setColor(Color.CYAN);
            g.fillRect(0, 0, WIDTH + 300, HEIGHT);
            for (int i = 0; i < 7; i++) {
                //if (foods[i].noRen == false) {
                foods[i].render(g);
                //}
            }
            Font fnt1 = new Font("arial", Font.BOLD, 30);
            g.setFont(fnt1);
            g.drawString("SCORE : " + score + "/50", 200, 50);
            g.setColor(Color.BLACK);
            g.drawString(four, 1000, 500);
            g2d.draw(rec);
            if(fourCliqued == true) {
                g.setColor(Color.CYAN);
                Font fnt2 = new Font("arial", Font.BOLD, 80);
                g.setFont(fnt2);
                g.fillRect(0, 0, WIDTH + 300, HEIGHT);
                g.setColor(Color.RED);
                g.drawString("BRAVO !!", 400, 300);
                g.drawString("SCORE : " + score + "/50", 200, 80);
                FoodElement tarteCuite = new FoodElement(400, 300, "mold_pate_bol_apple", ElementId.Car);
                tarteCuite.loadImage();
                tarteCuite.render(g);
            }
            g.setColor(Color.green);
            g2d.draw(recQuitter);
            g.setFont(fnt1);
            g.drawString("QUITER", 995, 625);
            bs.show();
        }
    }

    public void isAlive() {
        System.out.println("j");
    }

    public String getState() {
        return this.state;
    }

}
