import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import sweeper.Box;
import sweeper.Coord;
import sweeper.Game;
import sweeper.Ranges;

public class JavaSweeper extends JFrame {
    private JPanel panel;
    private JLabel label;

    private final int COLS = 9;
    private final int ROWS = 9;
    private final int BOMBS = 10;
    private final int IMAGE_SIZE = 50;
    private Game game;

    public static void main(String[] args) {
        new JavaSweeper();
    }

    private JavaSweeper() {
        game = new Game(COLS, ROWS, BOMBS);
        game.start();
        setImages();
        initPanel();
        initLabel();
        initFrame();
    }

    private void initLabel() {
        label = new JLabel(getMessage());
        label.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(label, BorderLayout.SOUTH);

    }

    private void initPanel() {
        this.panel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (Coord coord: Ranges.getAllCords()) {
                    g.drawImage((Image) game.getBox(coord).image, coord.x*IMAGE_SIZE,
                                                   coord.y * IMAGE_SIZE, this);
                }
            }
        };

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX() / IMAGE_SIZE;
                int y = e.getY() / IMAGE_SIZE;
                Coord coord = new Coord(x, y);
                switch (e.getButton()) {
                    case MouseEvent.BUTTON1:
                        game.pressLeftButton(coord);
                        break;
                    case MouseEvent.BUTTON3:
                        game.pressRightButton(coord);
                        break;
                    case MouseEvent.BUTTON2:
                        game.start();
                        break;
                }
                panel.repaint();
                label.setText(getMessage());
            }
        });

        panel.setPreferredSize(new Dimension(Ranges.getSize().x * IMAGE_SIZE,
                                            Ranges.getSize().y * IMAGE_SIZE));
        this.add(panel);
    }

    private void initFrame() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Java sweeper");
        this.setResizable(false );
        this.pack();
        this.setVisible(true);
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
        setIconImage(getImage("icon"));
    }

    private String getMessage() {
        String result = "DEBUG!";
        switch (game.getState()){
             case BOMBED: result = "Ba-Da-Bum!!! You Lose!"; break;
             case WINNER: result = "Congratulations!"; break;
             case PLAYED:
                 default: if (game.getTotalFlaged() == 0) {
                                result = "Welcome!";
                            } else {
                                result = "Think twice! Flagged " + game.getTotalFlaged() + " of " + game.getTotalBombs() + " bombs.";
                            }
                 break;
         }
         return result;
    }
}
