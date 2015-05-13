
        import java.awt.*;
        import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
        import java.util.ArrayList;
        import javax.swing.Timer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.RepaintManager;

        public class DragImage extends JPanel implements MouseMotionListener, MouseListener, ActionListener{
            static int imageWidth = 60, imageHeight = 60;
            int imageX = 5, imageY = 5;
            //String imageFile = "C:\\Users\\user\\Desktop\\hioo\\wheel.png";
            //BufferedImage ima = ImageIO.read(new File(imageFile));}
            //Image img = Toolkit.getDefaultToolkit().getImage(imageFile);
            //Image imgP = img.getScaledInstance(imageWidth, imageHeight, Image.SCALE_DEFAULT);
            BufferedImage image;
            //BufferedImage ima;
            BImages bi = new BImages();
            BufferedImage wheel2;
            BufferedImage door;
            BufferedImage carcass;
            BufferedImage glass;
            BufferedImage light;
            boolean wheel = true;
            int wheelN = 0;
            int i = 0;
            int n = 0;
            int p = 0;
            private static final int TABLE_LENGTH = 20;
            private boolean boolWheel = false;
            private boolean boolWheel2 = false;
            private boolean boolDoor = false;
            private boolean boolGlass = false;
            private boolean boolLight = false;
            private BufferedImage[] images = new BufferedImage[TABLE_LENGTH];
            private static int numberOfElements = 6;

            public DragImage() {
                image = bi.wheel;
                wheel2 = bi.wheel2;
                door = bi.door;
                carcass = bi.carcass;
                glass = bi.glass;
                light = bi.light;
                images[0] = image;
                images[1] = wheel2;
                images[2] = door;
                images[3] = carcass;
                images[4] = glass;
                images[5] = light;
                addMouseMotionListener(this);
                addMouseListener(this);
                this.setOpaque(true);
                setBackground(java.awt.Color.blue);
            }

            public void update(Graphics g) {
                paintComponent(g);
            }
            


            public void mouseDragged(MouseEvent e) {
                dragWheel1(e);
                dragWheel2(e);
                dragDoor(e);
                dragGlass(e);
                //dragLight(e);
                i++;
                if(i%5 == 0)
      		      repaint();
          
                

            }

            public void dragOnElement(MouseEvent e, BufferedImage element) {
                if(isCursorOnElement(e, element) && boolDiff(boolElement(element))){
                    bi.setX(element, e.getX() - bi.getWidth(element)/2);
                    bi.setY(element, e.getY() - bi.getHeight(element) / 2);
                }
            }

            /**public void dragLight(MouseEvent e) {
                if(isCursorOnLight(e) && boolDiff(boolLight)) {
                    bi.lightX = e.getX() - bi.light.getWidth()/2;
                    bi.lightY = e.getY() - bi.light.getHeight()/2;
                }
            } **/

            public void dragDoor(MouseEvent e) {
                if(isCursorOnDoor(e) && boolDiff(boolDoor)) {
                    bi.doorX = e.getX() - bi.door.getWidth()/2;
                    bi.doorY = e.getY() - bi.door.getHeight()/2;
                }
            }

            public void dragGlass(MouseEvent e) {
                if(isCursorOnGlass(e) && boolDiff(boolGlass)) {
                    bi.glassX = e.getX() - bi.glass.getWidth()/2;
                    bi.glassY = e.getY() - bi.glass.getHeight()/2;
                }
            }

            public boolean boolElement(BufferedImage element) {
                if(element.equals(wheel))
                    return boolWheel;
                if(element.equals(wheel2))
                    return boolWheel2;
                if(element.equals(door))
                    return boolDoor;
                if(element.equals(glass))
                    return boolGlass;
                if(element.equals(light))
                    return boolLight;
                else return false;
            }
            public boolean isCursorOnElement(MouseEvent e, BufferedImage element) {
                if (e.getX() > bi.getX(element) && e.getX() < (bi.getX(element) + bi.getWidth(element)) && e.getY() > bi.getY(element) && e.getY() < (bi.getY(element) + bi.getHeight(element))) {
                    return true;
                } else return false;
            }

            public boolean isCursorOnGlass(MouseEvent e) {
                if (e.getX() > bi.glassX && e.getX() < (bi.glassX + bi.glass.getWidth()) && e.getY() > bi.glassY && e.getY() < (bi.glassY + bi.glass.getHeight())) {
                    return true;
                } else return false;
            }

            public boolean isCursorOnDoor(MouseEvent e) {
                if (e.getX() > bi.doorX && e.getX() < (bi.doorX + bi.door.getWidth()) && e.getY() > bi.doorY && e.getY() < (bi.doorY + bi.door.getHeight())) {
                    return true;
                } else return false;
            }
            public void dragWheel1(MouseEvent e) {
                if (isCursorOnWheel(e) && boolDiff(boolWheel)) {
                    imageX = e.getX() - imageWidth / 2;
                    imageY = e.getY() - imageHeight / 2;
                    setHandCursor();
                    boolWheel = true;
                } else {
                    setDefaultCursor();
                }
            }

            public void dragWheel2(MouseEvent e) {
                if(isCursorOnWheel2(e) && boolDiff(boolWheel2)) {
                    bi.wheel2X = e.getX() - bi.wheel2.getWidth()/2;
                    bi.wheel2Y = e.getY() - bi.wheel2.getWidth()/2;
                    setHandCursor();
                    boolWheel2 = true;
                } else
                    setDefaultCursor();
            }

            public boolean boolDiff(boolean bool) {
                boolean[] tab = {boolWheel, boolWheel2, boolDoor, boolGlass, boolLight};
                for(int i = 0; i < 4;  i++) {
                    if(tab[i] == true && bool != tab[i]){
                        return false;
                    }
                }
                return true;
            }


            public boolean isCursorOnWheel(MouseEvent e) {
                if (e.getX() > imageX && e.getX() < (imageX + imageWidth) && e.getY() > imageY && e.getY() < (imageY + imageHeight)) {
                    return true;
                } else return false;
            }

            public boolean isCursorOnWheel2(MouseEvent e) {
                if (e.getX() > bi.wheel2X && e.getX() < (bi.wheel2X + bi.wheel2.getWidth())) {
                    if (e.getY() > bi.wheel2Y && e.getY() < (bi.wheel2Y + bi.wheel2.getHeight())) {
                        return true;
                    } else return false;
                } else return false;
            }

            public void setHandCursor() {
                setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            public void setDefaultCursor() {
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            public void mouseMoved(MouseEvent e) {
                if (isCursorOnElement(e, image)) {
                    setHandCursor();
                    //boolWheel2 = true;
                } else if (isCursorOnElement(e, wheel2)) {
                    setHandCursor();
                    //boolWheel = true;
                } else if (isCursorOnElement(e, door)) {
                    setHandCursor();
                } else if (isCursorOnElement(e, glass)) {
                    setHandCursor();
                } else if(isCursorOnElement(e, light)) {
                    setHandCursor();
                } else {
                    setDefaultCursor();
                }
            }

            public void paint(Graphics g) {
                super.paint(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.drawImage(carcass,bi.carcassX,bi.carcassY,this);
                g2.drawImage(image, imageX, imageY, this);
                g2.drawImage(wheel2,bi.wheel2X,bi.wheel2Y,this);
                g2.drawImage(door,bi.doorX,bi.doorY,this);
                g2.drawImage(glass, bi.glassX, bi.glassY, this);
                g2.drawImage(light, bi.lightX, bi.lightY, this);
                Font fnt1 = new Font("arial", Font.BOLD, 20);
                g.setFont(fnt1);
                g.setColor(Color.RED);
                g.drawString("Mr Pascal a casse sa voiture", 100, 50);
                g.drawString("Pouvez vous l'aider a la reparer ?", 70, 70);
                g.setColor(Color.YELLOW);
                if(p == 1){
                    g.drawString("Un peu de concentration  ", 130, 230);
                    p++;
                } else {
                    if (n == 1) {
                        g.drawString("Tres bon debut !! ", 130, 120);

                    }
                    if (n == 3) {
                        g.drawString("Bien !! ", 130, 120);
                    }
                    if (n == 4) {
                        g.drawString("Vous y etes presque ! ", 130, 120);
                    }
                }
            }




    
    public void mouseClicked(MouseEvent e) {

    }

    
    public void mouseEntered(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    
    public void mouseExited(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
    	System.out.println(e.getX() + ","  + e.getY());
        if (isCursorOnWheel(e)) {
            boolWheel = true;
        } if(isCursorOnWheel2(e)) {
            boolWheel2 = true;
        } if(isCursorOnDoor(e)) {
            boolDoor = true;
        } if(isCursorOnGlass(e)) {
            boolGlass = true;
        } /*if(isCursorOnLight(e)) {
            boolLight = true;
        }*/
    }

    
    public void mouseReleased(MouseEvent e) {
        if(e.getX() < 161 && e.getX()>124 && e.getY() < 439 && e.getY() > 403 && (boolWheel)) {
            imageX = 119;
            imageY = 398;
            boolWheel = false;
            n++;
        } if(boolWheel){
            imageX = 5;
            imageY = 5;
            boolWheel = false;
        p++;}
         if(e.getX() < 358 && e.getX() > 308 && e.getY() > 395 && e.getY() < 440 &&  boolWheel2) {
            bi.wheel2X = 310;
            bi.wheel2Y = 394;
             boolWheel2 = false;
             n++;
         } if(boolWheel2) {
            bi.wheel2X = 5;
            bi.wheel2Y = 70;
                boolWheel2 = false;p++;
        } if(e.getX() < 278 && e.getX() > 178 && e.getY() < 427 && e.getY() > 350 && boolDoor) {
            bi.doorX = 178;
            bi.doorY = 369;
            boolDoor = false;
            n++;
        } if(boolDoor) {
            bi.doorY = 140;
            bi.doorX = 5;
            boolDoor = false;p++;
        } if(e.getX() < 279 && e.getX() > 204 && e.getY() < 371 && e.getY() > 348 && boolGlass) {
            bi.glassX = 204;
            bi.glassY = 348;
            boolGlass = false;
            n++;
        } if(boolGlass) {
            bi.glassX = 5;
            bi.glassY = 210;
            boolGlass = false;p++;
        }
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        boolWheel = false;
        repaint();
        //System.out.println(boolWheel);
    }

    public static void main(String[] args) {
        //String imageFile = "C:\\Users\\user\\Desktop\\hioo\\wheel.png";
        // Turn off double buffering
        RepaintManager.currentManager(null).setDoubleBufferingEnabled(false);

        //Image image = Toolkit.getDefaultToolkit().getImage(imageFile);
        //image = image.getScaledInstance(imageWidth, imageHeight, Image.SCALE_DEFAULT);
        JFrame frame = new JFrame("DragImage");
        DragImage drag = new DragImage();
        frame.getContentPane().add(drag);
        frame.setSize(400, 400 * 12 / 9);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        System.out.println(drag.image.toString());
        

    }

	public void actionPerformed(ActionEvent e) {


	}
        }

