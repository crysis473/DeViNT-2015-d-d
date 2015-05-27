import javax.swing.*;
import java.awt.*;

public class Window2 {
    public JFrame frame;
    public Canvas game;

    public Window2(int w, int h, String title, Canvas game) {
        game.setPreferredSize(new Dimension(w, h));
        //game.setMaximumSize(new Dimension(w, h));
        //game.setMinimumSize(new Dimension(w, h));
        this.game = game;
        frame = new JFrame(title);
        frame.add(this.game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    /*public static void main(String args[]) {
        ConstructionGame3 game = new ConstructionGame3();
        game.state = "menu";
        game.start();
        //Window2 window = new Window2(ConstructionGame2.WIDTH, ConstructionGame2.HEIGHT, "TestGame", game);
    }*/
}