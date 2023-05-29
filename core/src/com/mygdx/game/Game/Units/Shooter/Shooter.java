package com.mygdx.game.Game.Units.Shooter;

import com.mygdx.game.Game.Units.BaseHero;
import com.mygdx.game.Game.Units.Coordinate.Coordinate;
import com.mygdx.game.Game.Units.Villager;

import java.util.ArrayList;

public abstract class Shooter extends BaseHero {

    protected int ammo, accuracy;
    protected Villager villager;


    public Shooter(int hp, int maxHp, int armor, int damage, int ammo, int accuracy,
                   int initiative, String name, ArrayList<BaseHero> team, Coordinate coordinate) {
        super(hp, maxHp, armor, damage, initiative, name, team, coordinate);
        this.ammo = ammo;
        this.accuracy = accuracy;
        this.villager = null;
    }


    @Override
    public String getInfo() {
        return super.getInfo() + ", AMMO " + ammo + ", ACC " + accuracy;
    }

    @Override
    public void step(ArrayList<BaseHero> units) {
        if (!isDeath() && this.ammo != 0) {
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
                units.get(minDistanceIdx).damaged(this.damage);
                this.ammo--;
            }
        }
    }


    public void putAmmo() {
        this.ammo++;
    }

    public Villager getVillager() {
        return villager;
    }

    public void setVillager(Villager villager) {
        this.villager = villager;
    }
}