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

    public int xUmb = 100;
    private int randItem;
    private int randX;
    private int count = 0;
    private int score = 0;

    private List<Texture> itemsRandom;
    public Texture [] itemsFall = new Texture[4];
    public  int [] xFallPos = new int [4];
    public int [] yFallPos = new int[4];

    int [] xItemsRandom = {100,250};

    private World world;
    private TheHurricane TheHurricane;


    public WorldRenderer(TheHurricane TheHurricane){

        bg = new Texture("bg.png");
        drop = new Texture("drop.png");
        light = new Texture("lightning.png");
        umbrella = new Texture("umbrella.png");
        this.world = new World();
        this.TheHurricane = TheHurricane;
        itemsRandom = new ArrayList<Texture>();
        itemsRandom.add(drop);
        itemsRandom.add(light);
    }

    public void render(float delta){
        SpriteBatch batch = TheHurricane.batch;
        update(delta);
        batch.draw(bg,0,0);
        /*** UMBRELLA ***/
        batch.draw(umbrella,xUmb,0);
        /*** RANDOM ITEM ***/
        for(int i = 0; i < 4 ;i++){
            if(count == i){
                itemsFall[i] = itemsRandom.get(randItem);
                xFallPos[i] = xItemsRandom[randX];
                yFallPos[i] = 600;
            }
        }
        if(itemsFall[0] != null){
            batch.draw(itemsFall[0], xFallPos[0], yFallPos[0]);
        }
        if(itemsFall[1] != null){
            batch.draw(itemsFall[1],xFallPos[1],yFallPos[1]);
        }
        if(itemsFall[2] != null){
            batch.draw(itemsFall[2],xFallPos[2],yFallPos[2]);
        }
        if(itemsFall[3] != null){
            batch.draw(itemsFall[3],xFallPos[3],yFallPos[3]);
        }
    }

    public void update(float delta) {
        world.Timer();
        if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
            xUmb = 100;
            randItem = world.random(randItem);
            randX = world.random(randX);
            count++;
            for (int i = 0; i < 4; i++) {
                yFallPos[i] -= 150;
            }

        } else if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
            xUmb = 250;
            randItem = world.random(randItem);
            randX = world.random(randX);
            count++;
            for (int i = 0; i < 4; i++) {
                yFallPos[i] -= 150;
            }
        }
        if (count == 4) {
            count = 0;
        }
        score = scorer();
        System.out.println(score);
    }
    public int scorer(){
        for(int i = 0 ;i < 4; i++){
            if(yFallPos[i] == 0){
                if(xFallPos[i] == xUmb){
                    if(itemsFall[i] == drop){
                        score += 5;
                    }
                    else if(itemsFall[i] == light){
                        score -= 3;
                    }
                }
                else if(xFallPos[i] != xUmb){
                    if(itemsFall[i] == drop){
                        score -= 2;
                    }
                }
            }
        }
        if(score < 0){
            score = 0;
        }
        return score;
    }
}