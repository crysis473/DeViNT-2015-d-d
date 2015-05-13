import javax.swing.text.html.FormView;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
/**
 * Created by user on 30/04/2015.
 */
public class AssemblMouseListener implements MouseListener, MouseMotionListener {

    private String state;
    private ConstructionGame game;
    private Piece[] pieces;

    public AssemblMouseListener(ConstructionGame game) {
        this.game = game;
        state = game.getState();
        this.pieces = game.pieces;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(game.getState().equals("CAR")) {
            for(int i = 0; i < pieces.length; i++) {
                if(e != null && pieces[i] != null ){
                    if(pieces[i].getBounds().contains(e.getPoint())) {
                        pieces[i].isClicked = true;
                    }
                }}
            System.out.println("x -> " + e.getX() + ", y -> " + e.getY());
        }

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

    public void replacePeaces() {
        if(pieces[5].getBounds().contains(pieces[0].wheel1)) {
            pieces[5].x = (int) pieces[0].wheel1.getX() - 54;
            pieces[5].y = (int) pieces[0].wheel1.getY() - 56;
        } else {
            pieces[5].x = 10;
            pieces [5].y = 10;
        }
        if(pieces[1].getBounds().contains(pieces[0].wheel2)) {
            pieces[1].x = (int)pieces[0].wheel2.getX() - 51;
            pieces[1].y = (int)pieces[0].wheel2.getY() - 61;
        } else {
            pieces[1].x = 10;
            pieces[1].y = 130;
        }
        if(pieces[2].getBounds().contains(pieces[0].door)) {
            pieces[2].x = (int)pieces[0].door.getX() - 106;
            pieces[2].y = (int)pieces[0].door.getY() - 60;
        } else {
            pieces[2].x = 10;
            pieces[2].y = 250;
        }
        if(pieces[3].getBounds().contains(pieces[0].glass)) {
            pieces[3].x = (int)pieces[0].glass.getX() - 73;
            pieces[3].y = (int)pieces[0].glass.getY()- 24;
        } else {
            pieces[3].x = 10;
            pieces[3].y = 370;
        }
        if(pieces[4].getBounds().contains(pieces[0].light)) {
            pieces[4].x = (int)pieces[0].light.getX() - 35;
            pieces[4].y = (int)pieces[0].light.getY() - 16;
        } else {
            pieces[4].x = 10;
            pieces[4].y = 424;
        }
    }
}
