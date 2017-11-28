package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen extends ScreenAdapter{
    public SpriteBatch batch;
    private TheHurricane TheHurricane;
    private Texture drop;
    private  Texture umbrella;
    private Texture light;
    private int xUmb;
    private int yDrop;

    public GameScreen(TheHurricane TheHurricane) {
        this.TheHurricane = TheHurricane;
        umbrella = new Texture("umbrella.png");
        drop = new Texture("drop.png");
        light = new Texture("lightning.png");
        xUmb = 100;
        yDrop = 700;

    }

    public void render (float delta) {
        Gdx.gl.glClearColor(0, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        update(delta);
        SpriteBatch batch = TheHurricane.batch;
        batch.begin();
        batch.draw(umbrella, xUmb, -40);
        batch.draw(drop,100,yDrop);
        batch.draw(light,350,yDrop);
        batch.end();
    }

    private void update(float delta) {
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            xUmb = 100;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            xUmb = 250;
        }
        /*
        if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
            yUmb += 10;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            yUmb -= 10;
        }
        */
        yDrop -= delta;
    }
}
