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

    private int score = 0;
    private int time;

    private int gameBeforePlay = -1;
    private int gamePlaying = 0;
    private int gameOver = 1;
    private int gameState = -1;

    public Texture [] itemsRandom = new Texture[2];
    public Texture [] itemsFall = new Texture[4];

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
        gameOverTexture = new Texture("game-over.png");
        this.world = world;
        this.TheHurricane = TheHurricane;
        font.setColor(Color.BLACK);
        font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        itemsRandom[0] = drop;
        itemsRandom[1] = light;
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
                world.totalTime = 20;
                world.score = 0;
                for(int i = 0;i < 4;i++){
                    itemsFall[i] = null;
                }
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
        batch.draw(umbrella,world.xUmb,0);
        /*** RANDOM ITEM ***/
        for(int i = 0; i < 4 ;i++){
            if(world.count == i){
                itemsFall[i] = itemsRandom[world.randItem];
                world.xFallPos[i] = xItemsRandom[world.randX];
                world.yFallPos[i] = 600;
            }
        }
        if(itemsFall[0] != null){
            batch.draw(itemsFall[0], world.xFallPos[0], world.yFallPos[0]);
        }
        if(itemsFall[1] != null){
            batch.draw(itemsFall[1], world.xFallPos[1], world.yFallPos[1]);
        }
        if(itemsFall[2] != null){
            batch.draw(itemsFall[2], world.xFallPos[2], world.yFallPos[2]);
        }
        if(itemsFall[3] != null){
            batch.draw(itemsFall[3], world.xFallPos[3], world.yFallPos[3]);
        }
    }

    public void renderGameOver(){
        SpriteBatch batch = TheHurricane.batch;
        font.getData().setScale(2);
        batch.draw(bg,0,0);
        font.draw(batch,"SCORE : "+ Integer.toString(score),140,640);
        font.draw(batch,"PRESS DOWN TO PLAY AGAIN",40,250);
        batch.draw(gameOverTexture,110,300);
        batch.draw(umbrella,175,50);
        batch.draw(drop,50,50);
        batch.draw(light,360,50);
    }

    public void update() {
        world.updateRandomPos();
        world.Timer();
        score = scorer();
        time = world.sec;
    }

    public int scorer(){
        for(int i = 0 ;i < 4; i++){
            if(world.yFallPos[i] == 0){
                if(world.xFallPos[i] == world.xUmb){
                    if(itemsFall[i] == drop){
                        score += 5;
                    }
                    else if(itemsFall[i] == light){
                        score -= 3;
                    }
                }
                else if(world.xFallPos[i] != world.xUmb){
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