package sweeper;

class Flag {
    private Matrix flagMap;
    private int totalFlags;
    private int countOfClosedBoxes;

    void start() {
        flagMap = new Matrix(Box.CLOSED);
    }

    Box get(Coord coord) {
        return flagMap.get(coord);
    }

    void setOpenedToBox(Coord coord) {
        flagMap.set(coord, Box.OPENED);
    }

    void setBombedToBox(Coord coord) {
        flagMap.set(coord, Box.BOMBED);
    }

    void toggleFlagedToBox(Coord coord) {

    }

    void setNoBombToFlagedSafeBox() {

    }

    void setOpenedToClosedBombBox() {

    }

    int getCountOfFlagedBoxesAround() {
        return 0;
    }

    int getCountOfClosedBoxes() {
        return countOfClosedBoxes;
    }

    int getTotalFlags() {
        return totalFlags;
    }

    void setFlaggedToBox(Coord coord) {
        flagMap.set(coord, Box.FLAGED);
    }
}
