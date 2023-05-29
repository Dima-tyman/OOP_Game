package com.mygdx.game.Game.Units.Warrior;

import com.mygdx.game.Game.Units.BaseHero;
import com.mygdx.game.Game.Units.Coordinate.Coordinate;
import com.mygdx.game.Game.Units.HeroParameters;

import java.util.ArrayList;
import java.util.Random;

public class Spearman extends Warrior {

    public Spearman(String name, ArrayList<BaseHero> team, Coordinate coordinate) {
        super((int) (HeroParameters.Spearman[0] * (new Random().nextInt(51) + 50) / 100), HeroParameters.Spearman[0],
                HeroParameters.Spearman[1], HeroParameters.Spearman[2], HeroParameters.Spearman[3],
                HeroParameters.Spearman[4], HeroParameters.Spearman[5], name, team, coordinate);
    }


    @Override
    public String toString() {
        return "Копейщик";
    }
}