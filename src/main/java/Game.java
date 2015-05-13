import java.awt.Canvas;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Timer;

import javax.swing.JFrame;

/**
 * Created by user on 29/03/2015.
 */
public class Game extends Canvas implements Runnable, MouseListener, MouseMotionListener, ActionListener {
    public static final double  serialVersionUID = 1L;
    public static final int WIDTH = 400;
    public static final int HEIGHT = WIDTH/12*9;
    public static final int SCALE = 2;
    public static final String TITLE = "Drag & Drop puzzle";
    public boolean running = true;
    public Thread thread;
    public int i = 0;
    Menu menu = new Menu();

    public Game() {
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }
     private synchronized void start() {
        if(running)
            return;

        running = true;
        thread = new Thread(this);
        thread.start();
    }

    private synchronized void stop() {
        if(!running)
            return;

        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(1);
    }

    public void run() {
        while(running) {
            if(i == 1){
                running = false;
                System.out.println(running);
                this.repaint();
            }
        }
        stop();
    }


    public void paint(Graphics g) {
        if(i == 0) {
            menu.paint(g);
        }
        if(i == 1) {
            this.setBackground(Color.black);
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        JFrame frame = new JFrame(game.TITLE);
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        game.repaint();




    }

    public void mouseClicked(MouseEvent e) {
        menu.mouseClicked(e);
    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void mouseDragged(MouseEvent e) {

    }

    public void mouseMoved(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        if (x >= this.WIDTH / 2 + 120 && x < this.WIDTH / 2 + 120 + 100) {
            if (y >= 150 && y <= 150 + 50) {
                this.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }else{
                this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));}
        }else{
            this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));}
    }
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}