package com.mygdx.game.Game.Units.Mage;

import com.mygdx.game.Game.Units.BaseHero;
import com.mygdx.game.Game.Units.Coordinate.Coordinate;

import java.util.ArrayList;

public abstract class Mage extends BaseHero {

    protected int mana, maxMana;


    public Mage(int hp, int maxHp, int armor, int damage, int mana, int maxMana,
                int initiative, String name, ArrayList<BaseHero> team, Coordinate coordinate) {
        super(hp, maxHp, armor, damage, initiative, name, team, coordinate);
        this.mana = mana;
        this.maxMana = maxMana;
    }


    @Override
    public String getInfo() {
        return super.getInfo() + ", MP " + mana + "/" + maxMana;
    }

    @Override
    public void step(ArrayList<BaseHero> units) {
        if (!isDeath()) {
            int minOutHpIdx = -1, idx = 0;
            double minOutHp = 1;
            for (BaseHero unit : this.team) {
                if (!unit.isDeath() && unit.getHp() < unit.getMaxHp() &&
                        (double) unit.getHp() / unit.getMaxHp() < minOutHp) {
                    minOutHp = (double) unit.getHp() / unit.getMaxHp();
                    minOutHpIdx = idx;
                }
                idx++;
            }
            if (minOutHpIdx != -1) this.team.get(minOutHpIdx).damaged(-this.damage);
        }
    }
}