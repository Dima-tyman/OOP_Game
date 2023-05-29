package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Game.GameOOP;
import com.mygdx.game.Game.Units.*;
import com.mygdx.game.Game.Units.Coordinate.Coordinate;
import com.mygdx.game.Game.Units.Mage.*;
import com.mygdx.game.Game.Units.Shooter.*;
import com.mygdx.game.Game.Units.Warrior.*;

import java.util.Random;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture fone, Monk, Warlock, CrossBowMan, Sniper, Bandit, SpearMan, Villager;
	Music music;
	GameOOP game;

	int dx, dy; //correct coordinate

	@Override
	public void create () {
		batch = new SpriteBatch();

		game = new GameOOP();
		dx = Gdx.graphics.getWidth() / Coordinate.maxX;
		dy = (Gdx.graphics.getHeight() - 100) / Coordinate.maxY;

		fone = new Texture("фоны/" + Fones.values()[new Random().nextInt(Fones.values().length)] + ".png");
		Monk = new Texture("персонажи/Monk.png");
		Warlock = new Texture("персонажи/Warlock.png");
		CrossBowMan = new Texture("персонажи/CrossBowMan.png");
		Sniper = new Texture("персонажи/Sniper.png");
		Bandit = new Texture("персонажи/Bandit.png");
		SpearMan = new Texture("персонажи/SpearMan.png");
		Villager = new Texture("персонажи/Villager.png");

		music = Gdx.audio.newMusic(Gdx.files.internal("Музыка/paul-romero-rob-king-combat-theme-0" + (new Random().nextInt(4) + 1) + ".mp3"));
		music.setLooping(true);
		music.setVolume(0.15f);
		music.play();
	}

	@Override
	public void render () {
		batch.begin();
		batch.draw(fone, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		for (BaseHero unit : game.allTeam) {
			if (unit.getClass() == Monk.class) {
				batch.draw(Monk, unit.getCoordinate().getCoordinate()[0] * dx, unit.getCoordinate().getCoordinate()[1] * dy);
			}
			else if (unit.getClass() == Warlock.class) {
				batch.draw(Warlock, unit.getCoordinate().getCoordinate()[0] * dx, unit.getCoordinate().getCoordinate()[1] * dy);
			}
			else if (unit.getClass() == Crossbowman.class) {
				batch.draw(CrossBowMan, unit.getCoordinate().getCoordinate()[0] * dx, unit.getCoordinate().getCoordinate()[1] * dy);
			}
			else if (unit.getClass() == Sniper.class) {
				batch.draw(Sniper, unit.getCoordinate().getCoordinate()[0] * dx, unit.getCoordinate().getCoordinate()[1] * dy);
			}
			else if (unit.getClass() == Bandit.class) {
				batch.draw(Bandit, unit.getCoordinate().getCoordinate()[0] * dx, unit.getCoordinate().getCoordinate()[1] * dy);
			}
			else if (unit.getClass() == Spearman.class) {
				batch.draw(SpearMan, unit.getCoordinate().getCoordinate()[0] * dx, unit.getCoordinate().getCoordinate()[1] * dy);
			}
			else if (unit.getClass() == Villager.class) {
				batch.draw(Villager, unit.getCoordinate().getCoordinate()[0] * dx, unit.getCoordinate().getCoordinate()[1] * dy);
			}
		}

		for (BaseHero unit : game.allTeam) {
			unit.step(game.allTeam);
		}

		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		fone.dispose();
	}
}
