package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.List;

public class WorldRenderer {
    public SpriteBatch batch;
    private Texture drop;
    private Texture umbrella;
    private Texture light;
    private Texture bg;

    private int xUmb = 100;
    private int yDrop;
    private int yLight;
    private  int speed;
    private int randItem;
    private int randX;
    private int xItem;

    private List<Texture> items;

    private World world;
    private TheHurricane TheHurricane;


    public WorldRenderer(TheHurricane TheHurricane){

        bg = new Texture("bg.png");
        drop = new Texture("drop.png");
        light = new Texture("lightning.png");
        umbrella = new Texture("umbrella.png");
        this.world = new World();
        this.TheHurricane = TheHurricane;

    }

    public void render(float delta){
        SpriteBatch batch = TheHurricane.batch;
        update(delta);
        batch.draw(bg,0,0);
        /*** UMBRELLA ***/
        batch.draw(umbrella,xUmb,0);
    }

    public void update(float delta){
        randItem = world.random(randItem);
        randX = world.random(randX);

        if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT)){
            xUmb = 100;
        }
        else if(Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)){
            xUmb = 250;
        }
    }


}
