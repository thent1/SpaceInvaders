import javax.swing.*;
import java.awt.*;

public class EnemyGreen extends Enemy {
    private int dirY = 0;

    public EnemyGreen(int x, int y) {
        img = new ImageIcon("res/greenSpaceship.png").getImage();
        imgX = x;
        imgY = y;
        imgWidth = img.getWidth(null);
        imgHeight = img.getHeight(null);
        range = random.nextInt(100) + 50;
        xLeft = imgX - range;
        if (xLeft < 0) {
            xLeft = 0;
        }
        xRight = imgX + range;
        if (xRight > Main.WIDTH - imgWidth) {
            xRight = Main.WIDTH - imgWidth;
        }
    }

    @Override
    public void update() {
        if (random.nextInt(16) == 0) {
            dirY = random.nextInt(2);
        }
        super.update();
        if (canMove) {
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
            if (dirY == 0) {
                imgY -= speed;
                if (imgY < 0) {
                    imgY += speed;
                    dirY = 1;
                }
            }
            if (dirY == 1) {
                imgY += speed;
                if (imgY > 500) {
                    imgY -= speed;
                    dirY = 0;
                }
            }
        } else {
            if ((System.currentTimeMillis() - time) > timeStop) {
                canMove = true;
            }
        }
    }

    @Override
    public Rectangle getRectangle() {
        Rectangle rectangle = new Rectangle(imgX + 10, imgY + 10, imgWidth - 20, imgHeight - 20);
        return rectangle;
    }
}
