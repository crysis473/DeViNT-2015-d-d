import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class Menu extends JPanel implements MouseListener, MouseMotionListener {
    public Rectangle cuisineButton = new Rectangle(Game.WIDTH/2 + 120, 150, 340, 50);
    public Rectangle voitureButton = new Rectangle(Game.WIDTH/2 + 120, 250, 400, 50);
    public Rectangle quitButton = new Rectangle(Game.WIDTH/2 + 120, 350, 170, 50);
    public Rectangle differences = new Rectangle(Game.WIDTH/2 + 120, 450, 420, 50);
    public JFrame frame = null;

    public Menu() {
        setBackground(Color.cyan);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    public void start() {
        frame = new JFrame("Jeu d'assemblage");
        frame.setPreferredSize(new Dimension(1000,700));
        frame.add(this);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.blue);
        g.fillRect(0, 0, 2000, 2000 );
        Font fnt0 = new Font("arial", Font.BOLD, 50);
        Font fnt1 = new Font("arial", Font.BOLD, 30);
        //Drawing the title of the game.
        g.setFont(fnt0);
        g.setColor(Color.ORANGE);
        g.drawString("Paul L'assembleur", 500/2, 100);

        g.setFont(fnt1);
        //Drawing the
        g.drawString("Recette Cuisine", cuisineButton.x + 19, cuisineButton.y + 30);
        g2d.draw(cuisineButton);
        //Drawing the help button.
        g.drawString("Construction voiture", voitureButton.x + 19, voitureButton.y + 30);
        g2d.draw(voitureButton);
        //Drawing the quitButton.
        g.drawString("Aventure", quitButton.x + 9, quitButton.y + 30);
        g2d.draw(quitButton);

        g.drawString("Trouvez les differences", differences.x + 9, differences.y + 30);
        g2d.draw(differences);
        Font fnt2 = new Font("arial", Font.BOLD, 20);
        g.setFont(fnt2);
        g.drawString("DEVINT 2015", 840, 650);


    }

    
    public void mouseClicked(MouseEvent e) {

        if(cuisineButton.contains(e.getPoint())) {
            ConstructionGame2 game = new ConstructionGame2();
            game.start();
            frame.setVisible(false);
            frame.dispose();
            System.out.println("ok");
        }
        if(voitureButton.contains(e.getPoint())) {
            ConstructionGame game = new ConstructionGame();
            game.start();
            frame.setVisible(false);
            frame.dispose();
            System.out.println("ok");
        }

        System.out.println(e.getX() + " " + e.getY());

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
        if(cuisineButton.contains(e.getPoint()) || voitureButton.contains(e.getPoint()) || quitButton.contains(e.getPoint()) || differences.contains(e.getPoint())) {
            setCursor(new Cursor(Cursor.HAND_CURSOR));
        } else {
            setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }
}


