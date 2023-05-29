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
}