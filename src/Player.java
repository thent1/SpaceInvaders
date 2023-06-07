import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Player {
    Image img = new ImageIcon("res/spaceship.png").getImage();
    int imgWidth = img.getWidth(null);
    int imgHeight = img.getHeight(null);
    int imgX = 600;
    int imgY1 = 600;

    public void paint(Graphics graphics) {
        graphics.drawImage(img, imgX, imgY1, imgWidth, imgHeight, null);

    }

    public void keyPressed(KeyEvent e) {

    }

    public void keyReleased(KeyEvent e) {

    }
}
