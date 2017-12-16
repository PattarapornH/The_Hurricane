package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class GameScreen extends ScreenAdapter{
    public SpriteBatch batch;
    private TheHurricane TheHurricane;

    private World world;
    private WorldRenderer WorldRenderer;


    public GameScreen(TheHurricane TheHurricane) {
        this.TheHurricane = TheHurricane;
        this.world = new World();
        this.WorldRenderer = new WorldRenderer(this.TheHurricane,this.world);

    }

    public void render (float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        SpriteBatch batch = TheHurricane.batch;

        batch.begin();
        WorldRenderer.render();
        batch.end();
    }

    private void update(float delta) {
        world.Timer();
    }
}
