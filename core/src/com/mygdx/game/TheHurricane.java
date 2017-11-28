package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.Random;

public class TheHurricane extends Game {
	SpriteBatch batch;
	Texture bg , drop, umbrella, light;
	Random random = new Random();
	@Override
	public void create () {
		batch = new SpriteBatch();
		bg = new Texture("bg.png");
		drop  = new Texture("drop.png");
		umbrella = new Texture("umbrella.png");
		light = new Texture("lightning.png");
		batch = new SpriteBatch();
		setScreen(new GameScreen(this));

	}

	@Override
	public void render () {
		//int randItem = random.nextInt(2);
		//batch.begin();
		//batch.draw(bg,0,0);
		//batch.draw(drop,4,5);
		/*
		if(randItem == 1) {
			batch.draw(umbrella, 120, 0);
		}
		else(randItem == 2){
			batch.draw(light, 100, 100);
		}
		*/
		super.render();
		//batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		bg.dispose();
		drop.dispose();
		umbrella.dispose();
		light.dispose();
	}
}
