package sweeper;

public class Game {

    private Bomb bomb;
    private Flag flag;

    public Game(int cols, int rows, int bombs) {
        Ranges.setSize(new Coord(cols, rows));
        bomb = new Bomb(bombs);
        flag = new Flag();
    }

    public void start() {
        bomb.start();
        flag.start();
    }


    public Box getBox(Coord coord) {
        Box result;
        if (Box.OPENED == flag.get(coord)) {
            result = bomb.get(coord);
        } else {
            result = flag.get(coord);
        }
        return result;
    }

    public void pressLeftButton(Coord coord) {
        flag.setOpenedToBox(coord);
    }

    public void pressRightButton(Coord coord) {
        flag.toggleFlagedToBox(coord);
    }

}
