package com.mygdx.game.Game.Units.Coordinate;

import com.mygdx.game.Game.Units.BaseHero;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.Random;

public class Coordinate {

    public static int maxX = 10, maxY = 10;
    private int x, y;


    public Coordinate(int x, int y) {
        this.x = Math.min(x, maxX);
        this.y = Math.min(y, maxY);
    }

    public Coordinate(int x) {
        this(x, new Random().nextInt(10));
    }

    public Coordinate (int[] coordinate) {
        this(coordinate[0], coordinate[1]);
    }

    public Coordinate() {
        this(new Random().nextInt(10));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() == Coordinate.class) {
            return this.x == ((Coordinate) obj).x && this.y == ((Coordinate) obj).y;
        }
        return false;
    }

    @Override
    public String toString() {
        return Arrays.toString(new int[]{this.x, this.y});
    }

    public int[] findShortPath(Coordinate target, ArrayList<BaseHero> units) {
        Queue<Node> queue = new ArrayDeque<>();

        queue.add(new Node(this.x, this.y, null));

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (Direction dir : Direction.values()) {
                int newX = node.x + dir.getDx();
                int newY = node.y + dir.getDy();
                Direction newDir = node.dir == null ? dir : node.dir;

                if (newX == target.x && newY == target.y) {
                    return new int[] {newDir.getDx(), newDir.getDy()};
                }

                boolean isEmpty = true;
                for (BaseHero unit : units) {
                    if (Arrays.equals(unit.getCoordinate().getCoordinate(), new int[]{newX, newY})) {
                        isEmpty = false;
                    }
                }

                if (isEmpty) {
                    queue.add(new Node(newX, newY, newDir));
                }
            }
        }

        return new int[]{0, 0};
    }

    public static double getMinDistance(Coordinate a, Coordinate b) {
        return Math.sqrt((Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2)));
    }

    public double getMinDistance(Coordinate target) {
        return getMinDistance(this, target);
    }

    public void setCoordinate(Coordinate coordinate) {
        this.setCoordinate(coordinate.getCoordinate());
    }

    public void setCoordinate(int[] coordinate) {
        this.setCoordinate(coordinate[0], coordinate[1]);
    }

    public void setCoordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int[] getCoordinate() {
        return new int[]{this.x, this.y};
    }
}