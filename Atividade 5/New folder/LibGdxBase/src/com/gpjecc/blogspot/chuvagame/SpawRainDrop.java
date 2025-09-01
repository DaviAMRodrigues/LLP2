package com.gpjecc.blogspot.chuvagame;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.graphics.Texture;

public interface SpawRainDrop {

    // Interface for spawning raindrops
    void spawnRaindrop(Array<Rectangle> raindrops, Texture dropImage, long lastDropTime);

    // Default method to spawn a raindrop
    default void spawnRaindropImpl(Array<Rectangle> raindrops, Texture dropImage, long lastDropTime) {
        Rectangle raindrop = new Rectangle();
        raindrop.x = MathUtils.random(0, 800 - 64);
        raindrop.y = 480;
        raindrop.width = dropImage.getWidth();
        raindrop.height = dropImage.getHeight();
        raindrops.add(raindrop);
        lastDropTime = TimeUtils.nanoTime();
    }
} 
