package com.mygdx.game.Game.Units.Coordinate;

public enum Direction {
    U(0, 1),
    L(-1, 0),
    D(0, -1),
    R(1, 0);

    private final int dx;
    private final int dy;

    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }
}
