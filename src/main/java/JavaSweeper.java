import javax.swing.*;
import java.awt.*;

public class JavaSweeper extends JFrame {
    JPanel panel;

    public static void main(String[] args) {
        new JavaSweeper();
    }

    public JavaSweeper() {
        this.panel = new JPanel();
        panel.setPreferredSize(new Dimension(500, 300));
        this.add(panel);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Java sweeper");
        this.setVisible(true);
        this.setResizable(false );
        this.pack();
        this.setLocationRelativeTo(null);
    }
}
