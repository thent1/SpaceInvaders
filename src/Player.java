import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Player {
    Image img = new ImageIcon("res/spaceship.png").getImage();
    int imgWidth = img.getWidth(null);
    int imgHeight = img.getHeight(null);
    int imgX = 300;
    int imgY = 760;
    int move = 0;
    int speed = 4;
    int shotDelay = 400;
    long lastShot = 0;
    boolean isShooting = false;
    public void paint(Graphics graphics) {
        graphics.drawImage(img, imgX, imgY, imgWidth, imgHeight, null);

    }

    public void update() {
        imgX += move;
        if (imgX <= 0) {
            imgX = 0;
        }

        if (imgX >= 830) {
            imgX = 830;
        }
        if ((System.currentTimeMillis()-lastShot)>shotDelay) {
            isShooting = true;
        }
    }
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_D) {
            move = speed;
        }
        if (key == KeyEvent.VK_A) {
            move = -speed;
        }
        if(key == KeyEvent.VK_SPACE) {
            if(isShooting == true) {
                Space.playerProjectiles.add(new PlayerProjectile(imgX + 64, imgY - 50));
                isShooting = false;
                lastShot = System.currentTimeMillis();
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_D) {
            move = 0;
        }
        if (key == KeyEvent.VK_A) {
            move = 0;
        }
    }
}
