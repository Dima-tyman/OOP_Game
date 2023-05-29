package com.mygdx.game.Game.Units;

import com.mygdx.game.Game.Units.Coordinate.Coordinate;

import java.util.ArrayList;

public abstract class BaseHero implements GameInterface, Comparable<BaseHero> {

    protected int hp, maxHp, armor, damage, initiative, lvl; //exp
    protected String name;
    protected ArrayList<BaseHero> team = new ArrayList<>();
    protected Coordinate coordinate;


    public BaseHero(int hp, int maxHp, int armor, int damage,
                    int initiative, String name, ArrayList<BaseHero> team, Coordinate coordinate) {
        this.hp = hp;
        this.maxHp = maxHp;
        this.armor = armor;
        this.damage = damage;
        this.initiative = initiative;
        this.lvl = 1; //добавиться поле очки уровня и метод повышения уровня
        //this.exp = 0;
        this.name = name;
        this.team.addAll(team);
        for (BaseHero unit : team) unit.team.add(this);
        this.coordinate = coordinate;
    }


    @Override
    public String getInfo() {
        return name + " HP " + hp + "/" + maxHp + ", ARM " + armor + ", DMG " + damage;
        //return name + " (" + lvl + " лвл), здоровье: " + hp + "/" + maxHp + ", броня: " + armor + ", урон: " + damage;
    }

    @Override
    public int compareTo(BaseHero o) {
        return Integer.compare(o.initiative, this.initiative);
    }

    @Override
    public void step(ArrayList<BaseHero> units) {}


    public void damaged(int damage) {
        if (damage > 0) {
            this.hp -= damage - this.armor;
            if (this.hp < 0) this.hp = 0;
        } else {
            this.hp -= damage;
            if (this.hp > this.maxHp) {this.hp = this.maxHp;}
        }
    }

    public boolean isDeath() {return hp <= 0;}

    public ArrayList<BaseHero> getTeam() {
        return this.team;
    }

    public int getHp() {
        return hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }
}