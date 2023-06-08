import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Space extends JPanel implements ActionListener {
    Timer timer = new Timer(5, this);
    Background background = new Background();
    Player player = new Player();
    static ArrayList<PlayerProjectile> playerProjectiles = new ArrayList<>();
    static ArrayList<Enemy> enemies = new ArrayList<>();
    public Space() {
        addKeyListener(new Control(player));
        setFocusable(true);
        timer.start();
        enemies.add(new EnemyBlue(200, 400));
        enemies.add(new EnemyGreen(500, 400));
        enemies.add(new EnemyRed(700, 400));
    }
    public void update() {
        background.update();
        player.update();
        for (int i = 0; i<playerProjectiles.size();i++){
            playerProjectiles.get(i).update();
        }
        for (int i = 0; i<enemies.size(); i++) {
            enemies.get(i).update();
            for (int j = 0; j < playerProjectiles.size(); j++) {
                if (enemies.get(i).getRectangle().intersects(playerProjectiles.get(j).getRectangle())) {
                    enemies.get(i).takingDamage(playerProjectiles.get(j).damage);
                    playerProjectiles.remove(j);
                }
            }
        }
        enemyRemove();
    }
    private void enemyRemove() {
        for (int i = 0; i<enemies.size(); i++) {
            if (enemies.get(i).health <= 0) {
                enemies.remove(i);
            }
        }
    }
    @Override
    public void paint(Graphics graphics) {
        background.paint(graphics);
        for (int i = 0; i<playerProjectiles.size();i++){
            playerProjectiles.get(i).paint(graphics);
            if (playerProjectiles.get(i).imgY<-20) {
                playerProjectiles.remove(i);
                i--;
            }
        }
        player.paint(graphics);
        for (int i = 0; i<enemies.size(); i++) {
            enemies.get(i).paint(graphics);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    update();
    repaint();
    }
}