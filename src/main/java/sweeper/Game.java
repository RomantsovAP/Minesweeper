package sweeper;

public class Game {

    private Bomb bomb;
    private Flag flag;
    private GameState state;

    public GameState getState() {
        return state;
    }

    public Game(int cols, int rows, int bombs) {
        Ranges.setSize(new Coord(cols, rows));
        bomb = new Bomb(bombs);
        flag = new Flag();
    }

    public void start() {
        state = GameState.PLAYED;
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
        openBox(coord);
    }

    private void openBox(Coord coord) {
        switch (flag.get(coord)) {
            case OPENED: break;
            case FLAGED: break;
            case CLOSED:
                switch (bomb.get(coord)) {
                    case ZERO: break;
                    case BOMB: break;
                    default: flag.setOpenedToBox(coord);

                }
        }
    }

    public void pressRightButton(Coord coord) {
        flag.toggleFlagedToBox(coord);
    }

}
