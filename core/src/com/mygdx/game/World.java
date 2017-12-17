package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;

import java.util.Random;

public class World {
    public float totalTime = 20;
    private float deltaTime;
    public int sec;
    public int score = 0;
    public int xUmb = 100;
    public int randItem ;
    public int randX ;
    public int count;

    public int [] yFallPos = new int[4];

    private Texture drop;
    private Texture light;
    public Texture [] itemsRandom = new Texture[2];
    public int [] xFallPos = new int [4];

    Random random = new Random();
    WorldRenderer worldRenderer;
    TheHurricane theHurricane;

    public void World(WorldRenderer worldRenderer) {
        this.theHurricane = new TheHurricane();
        this.worldRenderer = new WorldRenderer(theHurricane,this);
        drop = new Texture("drop.png");
        light = new Texture("lightning.png");
        itemsRandom[0] = drop;
        itemsRandom[1] = light;
    }


    public void Timer() {
        deltaTime = Gdx.graphics.getDeltaTime();
        sec = (int) (totalTime % 60);
        totalTime -= deltaTime;
    }

    public int random(int rand) {
        rand = random.nextInt(2);
        return rand;
    }

    public void updateRandomPos(){
        if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
            xUmb = 100;
            randItem = random(randItem);
            randX = random(randX);
            count++;
            for (int i = 0; i < 4; i++) {
                yFallPos[i] -= 150;
            }

        } else if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
            xUmb = 250;
            randItem = random(randItem);
            randX = random(randX);
            count++;
            for (int i = 0; i < 4; i++) {
                yFallPos[i] -= 150;
            }
        }
        if (count == 4) {
            count = 0;
        }
    }

}