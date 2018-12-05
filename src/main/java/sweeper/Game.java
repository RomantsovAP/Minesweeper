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
        if (!isGameOver()) {
            openBox(coord);
            checkWinner();
        }
    }

    private void checkWinner() {
        if(GameState.PLAYED == state) {
            if (flag.getTotalClosed() ==  bomb.getTotalBombs()) {
                state = GameState.WINNER;
                flag.setFlagedToLastClosedBoxes();
            }
        }
    }


    private void openBox(Coord coord) {
        switch (flag.get(coord)) {
            case OPENED: break;
            case FLAGED: break;
            case CLOSED:
                switch (bomb.get(coord)) {
                    case ZERO: openBoxesAroundZero(coord); break;
                    case BOMB: openBombs(coord); break;
                    default: flag.setOpenedToBox(coord);

                }
        }
    }

    private void openBombs(Coord bombedCoord) {
        flag.setBombedToBox(bombedCoord);
        for (Coord coord : Ranges.getAllCords()) {
            if (Box.BOMB == bomb.get(coord)) {
                flag.setOpenedToClosedBox(coord);
            } else {
                flag.setNoBombToFlagedBox(coord);
            }
        }

        state = GameState.BOMBED;
    }

    private void openBoxesAroundZero(Coord coord) {
        flag.setOpenedToBox(coord);
        for (Coord currnetCoord : Ranges.getCoordsAround(coord)) {
            openBox(currnetCoord);
        }
    }

    public void pressRightButton(Coord coord) {
        if (!isGameOver()) {
            flag.toggleFlagedToBox(coord);
        }
    }

    private boolean isGameOver() {
        if (GameState.PLAYED != state) {
            start();
            return true;
        } else {
            return false;
        }

    }

    public int getTotalBombs() {
        return bomb.getTotalBombs();
    }

    public int getTotalFlaged() {
        return flag.getTotalFlaged();
    }

}
