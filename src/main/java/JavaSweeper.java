import javax.swing.*;
import java.awt.*;

public class JavaSweeper extends JFrame {
    private JPanel panel;

    public static void main(String[] args) {
        new JavaSweeper();
    }

    private JavaSweeper() {
        initPanel();
        initFrame();
    }

    private void initPanel() {
        this.panel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawLine(0,0,500,300);
            }
        };
        panel.setPreferredSize(new Dimension(500, 300));
        this.add(panel);
    }

    private void initFrame() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Java sweeper");
        this.setVisible(true);
        this.setResizable(false );
        this.pack();
        this.setLocationRelativeTo(null);
    }

}
