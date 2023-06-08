import javax.swing.*;
import java.awt.*;

public class EnemyBlue extends Enemy {
    public EnemyBlue(int x, int y) {
        img = new ImageIcon("res/blueSpaceship.png").getImage();
        imgX = x;
        imgY = y;
        imgWidth = img.getWidth(null);
        imgHeight = img.getHeight(null);
        range = random.nextInt(100)+50;
        xLeft = imgX - range;
        if (xLeft < 0) {
            xLeft = 0;
        }
        xRight = imgX + range;
        if (xRight > Main.WIDTH-imgWidth) {
            xRight = Main.WIDTH-imgWidth;
        }
    }

    @Override
    public void update() {
        super.update();
        if (canMove == true) {
            if (route) {
                imgX += speed;
            } else {
                imgX -= speed;
            }
            if (imgX < xLeft || imgX > xRight) {
                route = !route;
                canMove = false;
                time = System.currentTimeMillis();
            }
        } else {
            if ((System.currentTimeMillis()-time)>timeStop) {
                canMove = true;
            }
        }
    }

    @Override
    public Rectangle getRectangle() {
        Rectangle rectangle = new Rectangle(imgX+10, imgY-+5, imgWidth-20, imgHeight-20);
        return rectangle;
    }
}