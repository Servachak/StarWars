package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Background {
    class Star{
        Vector2 position;
        float speed;

        public Star() {
            position = new Vector2(
                    MathUtils.random(0,1280),
                    MathUtils.random(0,720));

            speed = MathUtils.random(0.5f,2.0f);
        }
        public void update(){
            position.x -= speed;
            if (position.x < - 40){
                position.x = 1280;
                position.y = MathUtils.random(0,720);
                speed = MathUtils.random(0.7f,4.0f);
            }
        }
    }

    Texture backgroundTexture;

    Texture starTexture;
    Star[] stars;



    public Background(){

        backgroundTexture = new Texture("allfonsru-1222.jpg");
        starTexture = new Texture("зірка.png");
        stars = new Star[250];
        for (int i = 0; i < stars.length; i++) {
           stars[i] = new  Star();
        }


    }

    public void render(SpriteBatch batch) {

        batch.draw(backgroundTexture, 0, 0);

        for (int i = 0; i < stars.length; i++) {
            batch.draw(starTexture, stars[i].position.x, stars[i].position.y);
        }
    }


    public void update(){
        for (int i = 0; i < stars.length; i++) {
            stars[i].update();
        }

    }

}
