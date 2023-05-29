package com.mygdx.game.Game.Units.Coordinate;

public class Node {
    final int x;
    final int y;
    Direction dir;

    public Node(int x, int y, Direction dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }
}
