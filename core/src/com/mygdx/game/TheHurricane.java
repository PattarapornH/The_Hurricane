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
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
