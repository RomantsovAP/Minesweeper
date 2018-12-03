package sweeper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ranges {
    private static Coord size;
    private static List<Coord> allCords;
    private static Random random = new Random();

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

    static boolean inRange(Coord coord) {
        return coord.x >= 0 && coord.x < size.x && coord.y >=0 && coord.y < size.y;
    }

    static Coord getRandomCoord() {
        return new Coord(random.nextInt(size.x), random.nextInt(size.y));
    }

    static List<Coord> getCoordsAround(Coord coord) {
        Coord around;
        List<Coord> list = new ArrayList<>();
        for (int x = coord.x -1; x <= coord.x + 1; x++) {
            for (int y = coord.y - 1; y <= coord.y + 1; y++) {
                around = new Coord(x,y);
                if (inRange(around) && !around.equals(coord)) {
                    list.add(around);
                }
            }
        }
        return list;
    }
}