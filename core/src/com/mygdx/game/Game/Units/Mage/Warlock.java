package com.mygdx.game.Game.Units.Mage;

import com.mygdx.game.Game.Units.BaseHero;
import com.mygdx.game.Game.Units.Coordinate.Coordinate;
import com.mygdx.game.Game.Units.HeroParameters;

import java.util.ArrayList;
import java.util.Random;

public class Warlock extends Mage {

    public Warlock(String name, ArrayList<BaseHero> team, Coordinate coordinate) {
        super((int) (HeroParameters.Warlock[0] * (new Random().nextInt(51) + 50) / 100), HeroParameters.Warlock[0],
                HeroParameters.Warlock[1], HeroParameters.Warlock[2], HeroParameters.Warlock[3],
                HeroParameters.Warlock[4], HeroParameters.Warlock[5], name, team, coordinate);
    }


    @Override
    public String toString() {
        return "Чародей";
    }
}