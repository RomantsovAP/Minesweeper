import javax.swing.*;
import java.awt.*;
import sweeper.Box;
import sweeper.Coord;

public class JavaSweeper extends JFrame {
    private JPanel panel;

    private final int COLS = 15;
    private final int ROWS = 1;
    private final int IMAGE_SIZE = 50;

    public static void main(String[] args) {
        new JavaSweeper();
    }

    private JavaSweeper() {
        setImages();
        initPanel();
        initFrame();
    }

    private void initPanel() {
        this.panel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (Box box: Box.values()) {
                    Coord coord = new Coord(box.ordinal(), 0);
                    g.drawImage((Image) box.image, coord.x*IMAGE_SIZE,
                                                   coord.y * IMAGE_SIZE, this);
                }
            }
        };
        panel.setPreferredSize(new Dimension(COLS * IMAGE_SIZE,
                                            ROWS * IMAGE_SIZE));
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
        String filename = "img/" + name + ".png";
        ImageIcon icon = new ImageIcon(getClass().getResource(filename));
        return icon.getImage();
    }

    private void setImages() {
        for (Box box : Box.values()) {
            box.image = getImage(box.name().toLowerCase());
        }
    }
}
