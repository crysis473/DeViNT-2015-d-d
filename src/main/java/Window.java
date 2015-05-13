import javax.swing.*;
import java.awt.*;

/**
 * Created by user on 03/04/2015.
 */
public class Window {
    public JFrame frame;
    public TestGame game;
    public ConstructionGame constructionGame;
    public Handler handler;

    public Window(int w, int h, String title, TestGame game) {
        game.setPreferredSize(new Dimension(w, h));
        game.setMaximumSize(new Dimension(w, h));
        game.setMinimumSize(new Dimension(w, h));
        this.game = game;
        game.window = this;
        frame = new JFrame(title);
        frame.add(this.game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        game.start();


    }

    public void changeGame() {
        game.running = false;
        game.thread.interrupt();
        frame.remove(game);
        game = null;
        System.out.println("Construction game added yeah !!");
        constructionGame = new ConstructionGame();
        constructionGame.setPreferredSize(new Dimension(1050, 800));
        frame.add(constructionGame);
        constructionGame.start();
        System.out.println("Construction game added yeah !!");
        constructionGame.isAlive();
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.repaint();
    }

    public static void main(String[] args) {
        TestGame game = new TestGame();
        Window window = new Window(ConstructionGame.WIDTH, ConstructionGame.HEIGHT, "TestGame", game);
    }

}
