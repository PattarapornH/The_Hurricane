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
    //private Texture drop;
    private  Texture umbrella;
    private  Texture bg;
    private int x;
    private int y;

    public GameScreen(TheHurricane TheHurricane) {
        this.TheHurricane = TheHurricane;
        umbrella = new Texture("umbrella.png");
        x = 100;
        y = 100;
    }

    public void render (float delta) {
        //	System.out.println("Hello " + delta);
        Gdx.gl.glClearColor(0, 0, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //	x+=5;
        //batch.draw(bg);
        update(delta);
        SpriteBatch batch = TheHurricane.batch;
        batch.begin();
        batch.draw(umbrella, x, y);
        batch.end();
    }

    private void update(float delta) {
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            x -= 10;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            x += 10;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
            y += 10;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            y -= 10;
        }
    }
}
