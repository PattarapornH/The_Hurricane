package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;

public class WorldRenderer {
    public SpriteBatch batch;
    private Texture drop;
    private Texture umbrella;
    private Texture light;
    private Texture bg;

    private int xUmb=100;
    private int yDrop = 700;
    private int randItem;
    private int randX;
    private int xItem;

    private List<Texture> items;
    int [] yItem = {700,600,500,400,300,200,100};

    private World world;
    private TheHurricane TheHurricane;


    public WorldRenderer(TheHurricane TheHurricane){

        bg = new Texture("bg.png");
        drop = new Texture("drop.png");
        light = new Texture("lightning.png");
        umbrella = new Texture("umbrella.png");
        this.world = new World();
        this.TheHurricane = TheHurricane;
        items = new ArrayList<Texture>();
        items.add(drop);
        items.add(light);
    }

    public void render(float delta){
        SpriteBatch batch = TheHurricane.batch;
        update(delta);
        batch.draw(bg,0,0);
        /*** UMBRELLA ***/
        batch.draw(umbrella,xUmb,0);
        /*** RANDOM ITEM ***/
        batch.draw(items.get(randItem),125,yDrop);
    }

    public void update(float delta){
       // randItem = world.random(randItem);
        //randX = world.random(randX);
        world.Timer();
        if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT)){
            xUmb = 100;
            yDrop -=100 ;
            randItem = world.random(randItem);
            randX = world.random(randX);
        }
        else if(Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)){
            xUmb = 250;
            yDrop -= 100;
            randItem = world.random(randItem);
            randX = world.random(randX);
        }
        System.out.println(randItem);
    }


}
