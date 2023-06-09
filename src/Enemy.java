import java.awt.*;
import java.util.Random;

public class Enemy {
    public int speed = 1;
    Image img;
    int imgX;
    int imgY;
    int imgWidth;
    int imgHeight;
    boolean route;
    int xLeft;
    int xRight;
    int range;
    Random random = new Random();
    boolean canMove = true;
    long time;
    int timeStop = 1000;
    int health = 20;

    public void paint(Graphics graphics) {
        graphics.drawImage(img, imgX, imgY, imgWidth, imgHeight, null);
    }

    public void update() {

    }

    public Rectangle getRectangle() {
        return null;
    }

    public void takingDamage(int damage) {
        health -= damage;
    }
}
