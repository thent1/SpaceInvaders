import javax.swing.*;
import java.awt.*;
public class PlayerProjectile {
    Image img = new ImageIcon("res/playershot.png").getImage();
    int imgWidth = img.getWidth(null);
    int imgHeight = img.getHeight(null);
    int imgX;
    int imgY;
    int speed = 6;
    int damage = 8;

    public PlayerProjectile(int imgX, int imgY) {
        this.imgX = imgX;
        this.imgY = imgY;
    }

    public void update() {
        imgY -= speed;
    }

    public void paint(Graphics graphics) {
            graphics.drawImage(img, imgX, imgY, imgWidth, imgHeight, null);
    }
    public Rectangle getRectangle() {
        Rectangle rectangle = new Rectangle(imgX, imgY, imgWidth, imgHeight);
        return rectangle;
    }
}