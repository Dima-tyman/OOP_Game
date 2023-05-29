package com.mygdx.game.Game;

import com.mygdx.game.Game.Units.*;
import com.mygdx.game.Game.Units.Coordinate.Coordinate;
import com.mygdx.game.Game.Units.Mage.*;
import com.mygdx.game.Game.Units.Shooter.*;
import com.mygdx.game.Game.Units.Warrior.*;

import java.util.ArrayList;
import java.util.Random;

public class Init {

    private static final int COUNT_CLASS = 7;

    private static final int countUnitInTeams = 10;

    public static void initTeam(ArrayList<BaseHero> team, int x) {
        for (int i = 0; i < countUnitInTeams; i++) {
            switch (new Random().nextInt(COUNT_CLASS)) {
                case 0: {
                    team.add(new Monk(getName(), team, new Coordinate(x, i)));
                    break;
                }
                case 1: {
                    team.add(new Warlock(getName(), team, new Coordinate(x, i)));
                    break;
                }
                case 2: {
                    team.add(new Sniper(getName(), team, new Coordinate(x, i)));
                    break;
                }
                case 3: {
                    team.add(new Crossbowman(getName(), team, new Coordinate(x, i)));
                    break;
                }
                case 4: {
                    team.add(new Bandit(getName(), team, new Coordinate(x, i)));
                    break;
                }
                case 5: {
                    team.add(new Spearman(getName(), team, new Coordinate(x, i)));
                    break;
                }
                case 6: {
                    team.add(new Villager(getName(), team, new Coordinate(x, i)));
                    break;
                }
            }
        }
    }

    private static String getName() {
        return String.valueOf(Names.values()[new Random().nextInt(Names.values().length)]);
    }
}
