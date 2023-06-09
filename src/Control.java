import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Control extends KeyAdapter {
    Player player;

    public Control(Player player) {
        this.player = player;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        player.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        super.keyReleased(e);
        player.keyReleased(e);
    }
}