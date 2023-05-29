package com.mygdx.game.Game.Units.Warrior;

import com.mygdx.game.Game.Units.BaseHero;
import com.mygdx.game.Game.Units.Coordinate.Coordinate;
import com.mygdx.game.Game.Units.HeroParameters;

import java.util.ArrayList;
import java.util.Random;

public class Bandit extends Warrior {

    public Bandit(String name, ArrayList<BaseHero> team, Coordinate coordinate) {
        super((int) (HeroParameters.Bandit[0] * (new Random().nextInt(51) + 50) / 100), HeroParameters.Bandit[0],
                HeroParameters.Bandit[1], HeroParameters.Bandit[2], HeroParameters.Bandit[3],
                HeroParameters.Bandit[4], HeroParameters.Bandit[5], name, team, coordinate);
    }


    @Override
    public String toString() {
        return "Бандит";
    }
}