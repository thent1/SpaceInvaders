import java.awt.*;
import javax.swing.*;
public class Background {
    Image img = new ImageIcon("res/space.png").getImage();
    int imgWidth = img.getWidth(null);
    int imgHeight = img.getHeight(null);
    int imgX = 0;
    int imgY1 = 0;
    int imgY2 = imgHeight;
    float speed = 6f;
    float totalSpeed = 10f;
    public void paint(Graphics graphics) {
        graphics.drawImage(img, imgX, imgY1, imgWidth, imgHeight, null);
        graphics.drawImage(img, imgX, imgY2, imgWidth, imgHeight, null);

    }
    public void update() {
        totalSpeed += speed;
        if (totalSpeed >= 1) {
            totalSpeed -=1;
            imgY1 += 1;
            imgY2 += 1;
            if(imgY2 >= 0) {
                imgY1 = 0;
                imgY2 = img.getHeight(null)*-1;
            }
        }
    }
}