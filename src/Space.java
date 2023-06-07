import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Space extends JPanel implements ActionListener {
    Timer timer = new Timer(5, this);
    Background background = new Background();
    Player player = new Player();

    public Space() {
        addKeyListener(new Control(player));
        setFocusable(true);
        timer.start();
    }
    public void update() {
        background.update();
    }

    @Override
    public void paint(Graphics graphics) {
        background.paint(graphics);
        player.paint(graphics);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    update();
    repaint();
    }
}
