import javax.swing.*;

public class Main {

     private static JFrame jFrame;
     private static final int WIDTH = 1000;
     private static final int HEIGHT = 1000;

    public static void main(String[] args) {
        jFrame = new JFrame("Space Invaders");
        jFrame.setSize(WIDTH, HEIGHT);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.setLocationRelativeTo(null);
        jFrame.add(new Space());
        jFrame.setVisible(true);
    }
}