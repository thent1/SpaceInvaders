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
    public Space() {
        addKeyListener(new Control(player));
        setFocusable(true);
        timer.start();
    }
    public void update() {
        background.update();
        player.update();
        for (int i = 0; i<playerProjectiles.size();i++){
            playerProjectiles.get(i).update();
        }
    }

    @Override
    public void paint(Graphics graphics) {
        background.paint(graphics);
        player.paint(graphics);
        for (int i = 0; i<playerProjectiles.size();i++){
            playerProjectiles.get(i).paint(graphics);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    update();
    repaint();
    }
}
