package sweeper;

class Flag {
    private Matrix flagMap;
    private int totalFlaged;
    private int totalClosed;

    void start() {
        flagMap = new Matrix(Box.CLOSED);
        totalClosed = Ranges.getSquare();
        totalFlaged = 0;
    }

    Box get(Coord coord) {
        return flagMap.get(coord);
    }

    void setOpenedToBox(Coord coord) {
        flagMap.set(coord, Box.OPENED);
        totalClosed--;
    }

    void setBombedToBox(Coord coord) {
        flagMap.set(coord, Box.BOMBED);
    }

    void toggleFlagedToBox(Coord coord) {
        switch (flagMap.get(coord)) {
            case FLAGED: setClosedToBox(coord); break;
            case CLOSED: setFlaggedToBox(coord); break;
            case OPENED: break;
        }
    }

    private void setClosedToBox(Coord coord) {
        flagMap.set(coord, Box.CLOSED);
        totalFlaged--;
    }

    void setNoBombToFlagedSafeBox() {

    }

    void setOpenedToClosedBombBox() {

    }

    int getCountOfFlagedBoxesAround(Coord coord) {
        int count = 0;
        for (Coord currentCoord : Ranges.getCoordsAround(coord)) {
            if (Box.FLAGED == flagMap.get(currentCoord)) {
                count++;
            }
        }
        return count;
    }

    int getTotalFlaged() {
        return totalFlaged;
    }

    int getTotalClosed() {
        return totalClosed;
    }

    private void setFlaggedToBox(Coord coord) {
        flagMap.set(coord, Box.FLAGED);
        totalFlaged++;
    }

    void setFlagedToLastClosedBoxes() {
        for (Coord coord : Ranges.getAllCords()) {
            if (Box.CLOSED == flagMap.get(coord)) {
                 setFlaggedToBox(coord);
            }
        }
    }

    void setOpenedToClosedBox(Coord coord) {
        if (Box.CLOSED == flagMap.get(coord)){
            setOpenedToBox(coord);
        }
    }

    void setNoBombToFlagedBox(Coord coord) {
        if (Box.FLAGED == flagMap.get(coord)) {
            flagMap.set(coord, Box.NOBOMB);
        }
    }
}
