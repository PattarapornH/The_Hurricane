package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;

public class WorldRenderer {
    public SpriteBatch batch;
    private Texture drop;
    private Texture umbrella;
    private Texture light;
    private Texture bg;
    private Texture tornado;
    private Texture gameOverTexture;

    public int xUmb = 100;
    private int randItem;
    private int randX;
    private int count = 0;
    private int score = 0;
    private int time;

    private int gameBeforePlay = -1;
    private int gamePlaying = 0;
    private int gameOver = 1;
    private int gameState = -1;

    private List<Texture> itemsRandom;
    public Texture [] itemsFall = new Texture[4];
    public  int [] xFallPos = new int [4];
    public int [] yFallPos = new int[4];

    int [] xItemsRandom = {100,250};

    BitmapFont font = new BitmapFont();

    private World world;
    private TheHurricane TheHurricane;


    public WorldRenderer(TheHurricane TheHurricane,World world){

        bg = new Texture("bg.png");
        drop = new Texture("drop.png");
        light = new Texture("lightning.png");
        umbrella = new Texture("umbrella.png");
        tornado = new Texture("windstorm.png");
        gameOverTexture = new Texture("game-over2.png");
        this.world = new World();
        this.TheHurricane = TheHurricane;
        font.setColor(Color.BLACK);
        font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        itemsRandom = new ArrayList<Texture>();
        itemsRandom.add(drop);
        itemsRandom.add(light);
    }

    public void render(){
        if(gameState == gameBeforePlay){
            renderGameStart();
            if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){
                gameState = gamePlaying;
            }
        }
        else if(gameState == gamePlaying){
            renderGamePlay();
            if(time == 0){
                gameState = gameOver;
            }
        }
        else if(gameState == gameOver){
            renderGameOver();
            if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){
                gameState = gamePlaying;
            }
        }
    }
    
    public void renderGameStart(){
        SpriteBatch batch = TheHurricane.batch;
        font.getData().setScale(2);
        batch.draw(bg,0,0);
        font.draw(batch,"THE  HURRICANE",125,650);
        font.draw(batch,"PRESS DOWN TO PLAY",80,250);
        batch.draw(tornado,100,300);
        batch.draw(umbrella,175,50);
        batch.draw(drop,50,50);
        batch.draw(light,360,50);
    }
    public void renderGamePlay(){
        SpriteBatch batch = TheHurricane.batch;
        update();
        font.getData().setScale(1);
        batch.draw(bg,0,0);
        font.draw(batch,"SCORE : "+ Integer.toString(score),400,675);
        font.draw(batch,"TIME : "+ Integer.toString(time),25,675);
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

    public void renderGameOver(){
        SpriteBatch batch = TheHurricane.batch;
        font.getData().setScale(2);
        batch.draw(bg,0,0);
        font.draw(batch,"SCORE : "+ Integer.toString(score),125,640);
        font.draw(batch,"PRESS DOWN TO PLAY AGAIN",40,250);
        batch.draw(gameOverTexture,100,300);
        batch.draw(umbrella,175,50);
        batch.draw(drop,50,50);
        batch.draw(light,360,50);
    }

    public void update() {
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
        //score = this.world.scorer();
        score = scorer();
        time = this.world.Timer();
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