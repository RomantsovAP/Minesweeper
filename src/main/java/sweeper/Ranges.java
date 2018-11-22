package sweeper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ranges {
    private static Coord size;
    private static List<Coord> allCords;
    static Random random;

    static void setSize(Coord size) {
        Ranges.size = size;
        allCords = new ArrayList<Coord>();
        for (int x = 0; x < size.x; x++) {
            for (int y = 0; y <size.y ; y++) {
                allCords.add(new Coord(x,y));
            }
        }
    }

    public static Coord getSize() {
        return size;
    }



    public static List<Coord> getAllCords() {
        return allCords;
    }

    static List<Coord> getCoordsArpund(Coord coord) {
        return new ArrayList<Coord>();
    }

    static Coord getRandomCoord() {
        return new Coord(0,0);
    }

    public static boolean inRange(Coord coord) {
        return coord.x >= 0 && coord.x < size.x && coord.y >=0 && coord.y < size.y;
    }

}
