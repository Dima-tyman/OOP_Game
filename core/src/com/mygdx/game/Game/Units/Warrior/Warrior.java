package com.mygdx.game.Game.Units.Warrior;

import com.mygdx.game.Game.Units.BaseHero;
import com.mygdx.game.Game.Units.Coordinate.Coordinate;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Warrior extends BaseHero {

    protected int resistance, ultimateDamage;


    public Warrior(int hp, int maxHp, int armor, int damage, int resistance, int ultimateDamage,
                   int initiative, String name, ArrayList<BaseHero> team, Coordinate coordinate) {
        super(hp, maxHp, armor, damage, initiative, name, team, coordinate);
        this.resistance = resistance;
        this.ultimateDamage = ultimateDamage;
    }


    @Override
    public String getInfo() {
        return super.getInfo() + ", RES " + resistance + ", ULT " + ultimateDamage;
    }

    @Override
    public void step(ArrayList<BaseHero> units) {
        if (!isDeath()) {
            double minDistance = Double.MAX_VALUE;
            int minDistanceIdx = -1, idx = 0;
            for (BaseHero unit : units) {
                if (unit != this && !this.team.contains(unit) && !unit.isDeath() &&
                        this.getCoordinate().getMinDistance(unit.getCoordinate()) < minDistance) {
                    minDistance = this.getCoordinate().getMinDistance(unit.getCoordinate());
                    minDistanceIdx = idx;
                }
                idx++;
            }

            if (minDistanceIdx != -1) {
                if (minDistance < 2) {
                    units.get(minDistanceIdx).damaged(this.damage);
                } else {
                    this.move(units.get(minDistanceIdx).getCoordinate());
                }
            }
        }
    }

    public void move(Coordinate target) {
        int Ax = this.getCoordinate().getCoordinate()[0];
        int Ay = this.getCoordinate().getCoordinate()[1];

        int distX = target.getCoordinate()[0] - Ax;
        int distY = target.getCoordinate()[1] - Ay;

        int[] destination = new int[2];

        if (Math.abs(distX) >= Math.abs(distY)) {
            destination[0] = (distX > 0 ? Ax + 1 : Ax - 1);
            destination[1] = Ay;
        } else {
            destination[0] = Ax;
            destination[1] = distY > 0 ? Ay + 1 : Ay - 1;
        }

        for (BaseHero unit : this.team) {
            if (Arrays.equals(unit.getCoordinate().getCoordinate(), destination)) {
                int[] dir = this.getCoordinate().findShortPath(target, this.team);
                this.getCoordinate().setCoordinate(Ax + dir[0], Ay + dir[1]);
                return;
            }
        }

        this.getCoordinate().setCoordinate(destination);
    }
}