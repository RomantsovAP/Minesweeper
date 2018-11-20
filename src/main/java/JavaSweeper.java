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
                g.drawImage(getImage("bomb"), 0,0, this);
                g.drawImage(getImage("num1"), 50,0, this);
                g.drawImage(getImage("num1"), 50,50, this);
                g.drawImage(getImage("num1"), 0,50, this);
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

    private Image getImage(String name) {
        ImageIcon icon = new ImageIcon("src/main/resources/img/" + name + ".png");
        return icon.getImage();
    }

}
