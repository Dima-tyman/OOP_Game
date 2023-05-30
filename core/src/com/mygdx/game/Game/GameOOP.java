package com.mygdx.game.Game;

import com.mygdx.game.Game.Units.*;

import java.util.ArrayList;
import java.util.Collections;

public class GameOOP {

    public ArrayList<BaseHero> holyTeam = new ArrayList<>();
    public ArrayList<BaseHero> darkTeam = new ArrayList<>();
    public ArrayList<BaseHero> allTeam = new ArrayList<>();

    public GameOOP() {
        Init.initTeam(this.holyTeam, 0);
        Init.initTeam(this.darkTeam, 9);
        this.allTeam.addAll(this.holyTeam);
        this.allTeam.addAll(this.darkTeam);
        Collections.sort(this.allTeam);
    }

    public void step() {
            for (BaseHero unit : allTeam) {
                unit.step(allTeam);
        }
    }

    // 0 - game continue; 1 - holy win; -1 - dark win; 2 - all team die
    public int winner() {
        boolean holyDie = true;
        boolean darkDie = true;

        for (BaseHero unit : holyTeam) {
            if (!unit.isDeath()) holyDie = false;
            break;
        }
        for (BaseHero unit : darkTeam) {
            if (!unit.isDeath()) darkDie = false;
            break;
        }

        if (holyDie == darkDie) return 0;
        else if (holyDie) return -1;
        else if (darkDie) return 1;
        else return 2;
    }
}