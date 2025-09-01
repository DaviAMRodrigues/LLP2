package com.gpjecc.blogspot.chuvagame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.Iterator;

public class Gota {
    private Texture dropImage;
    private Sound dropSound;
    private Array<Rectangle> raindrops;
    private long lastDropTime;

    private void spawnRaindrop() {
      Rectangle raindrop = new Rectangle();
      raindrop.x = MathUtils.random(0, 800-64);
      raindrop.y = 480;
      raindrop.width = 64;
      raindrop.height = 64;
      raindrops.add(raindrop);
      lastDropTime = TimeUtils.nanoTime();
   }

    public void create(){
        dropImage = new Texture(Gdx.files.internal("assets/droplet.png"));
        dropSound = Gdx.audio.newSound(Gdx.files.internal("assets/drop.wav"));
        raindrops = new Array<Rectangle>();
        spawnRaindrop();
    }

    public void draw(SpriteBatch batch) {
        for (Rectangle raindrop : raindrops) {
            batch.draw(dropImage, raindrop.x, raindrop.y);
        }
    }

    public void update() {
        if (TimeUtils.nanoTime() - lastDropTime > 1000000000) {
            spawnRaindrop();
        }
    }

    public Iterator<Rectangle> iterator() {
        return raindrops.iterator();
    }

    public void moveRainDrop(Iterator<Rectangle> iter, Balde bucket) {
        while(iter.hasNext()) {
            Rectangle raindrop = iter.next();         
            raindrop.y -= 200 * Gdx.graphics.getDeltaTime();
            if(raindrop.y + 64 < 0) iter.remove();
            if(raindrop.overlaps(bucket.getBucket())) {
               dropSound.play();
               iter.remove();
            }
         }
    }

    public void dispose() {
        dropImage.dispose();
        dropSound.dispose();
    }
}
