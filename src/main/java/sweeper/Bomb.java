package sweeper;

class Bomb {
    private Matrix bombMap;
    private int totalBombs;

    Bomb(int totalBombs) {
        this.totalBombs = totalBombs;
        fixBombsCount();
    }

    int getTotalBombs() {
        return totalBombs;
    }

    void start() {
        bombMap = new Matrix(Box.ZERO);
        for (int i = 0; i < totalBombs; i++) {
            placeBomb();
        }
    }

    Box get(Coord coord) {
        return bombMap.get(coord);
    }

    private void fixBombsCount() {
        int maxBombs = Ranges.getSize().x * Ranges.getSize().y / 2;
        if (totalBombs > maxBombs) {
            totalBombs = maxBombs;
        }
    }

    private void placeBomb() {
        while (true) {
            Coord randomCoord  = Ranges.getRandomCoord();
            if (Box.BOMB == bombMap.get(randomCoord)){
                continue;
            }
            bombMap.set(randomCoord, Box.BOMB);
            incNumbersAroundBomb(randomCoord);
            break;
        }
    }

    private void incNumbersAroundBomb(Coord randomCoord) {
        for (Coord coord : Ranges.getCoordsAround(randomCoord)) {
            if (bombMap.get(coord) != Box.BOMB) {
                bombMap.set(coord, bombMap.get(coord).nextNumberBox());
             }
        }
    }


}
