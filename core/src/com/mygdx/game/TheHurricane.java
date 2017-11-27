package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TheHurricane extends ApplicationAdapter {
	SpriteBatch batch;
	Texture bg , drop, umbrella, light;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		bg = new Texture("bg.png");
		drop  = new Texture("drop.png");
		umbrella = new Texture("umbrella.png");
		light = new Texture("lightning.png");
	}

	@Override
	public void render () {
		batch.begin();
		batch.draw(bg,0,0);
		batch.draw(drop,4,5);
		batch.draw(umbrella,10,0);
		batch.draw(light,100,100);
		batch.end();
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
