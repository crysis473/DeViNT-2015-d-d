import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by user on 03/04/2015.
 */
public class KeyInput extends KeyAdapter {

    Handler handler;

    public KeyInput(Handler handler) {
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for(int i = 0; i < handler.objects.size(); i++) {
            GameObject tempObject = handler.objects.get(i);
            if(tempObject.getId() == ObjectId.Player) {
                if(key == KeyEvent.VK_D) tempObject.setGravityX(0.1f);
                if(key == KeyEvent.VK_Q) tempObject.setGravityY(0.1f);
                if(key == KeyEvent.VK_SPACE && !tempObject.isJumping()) {
                    tempObject.setJumping(true);
                    tempObject.setVelY(-12.5f);
                }
            }
        }
        if(key == KeyEvent.VK_ESCAPE){
            System.exit(1);
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        for(int i = 0; i < handler.objects.size(); i++) {
            GameObject tempObject = handler.objects.get(i);
            if(tempObject.getId() == ObjectId.Player) {
                if(key == KeyEvent.VK_D) tempObject.setGravityX(0);
                if(key == KeyEvent.VK_Q) tempObject.setGravityY(0);
            }
        }
    }

    public void freiner() {

    }

}
