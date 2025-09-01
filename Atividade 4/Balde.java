package com.gpjecc.blogspot.chuvagame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Balde {
    private Texture bucketImage;
    private Rectangle bucket;

    public void create() {
        bucketImage = new Texture(Gdx.files.internal("assets/bucket.png"));
        bucket = new Rectangle();
        bucket.x = 800 / 2 - 64 / 2; // center the bucket horizontally
        bucket.y = 20; // bottom left corner of the bucket is 20 pixels above the bottom screen edge
        bucket.width = 64;
        bucket.height = 64;
    }

    public void draw(SpriteBatch batch) {
        // Render the bucket here using the batch and bucketImage
        // For example:
        // batch.draw(bucketImage, bucket.x, bucket.y, bucket.width, bucket.height);
        batch.draw(bucketImage, bucket.x, bucket.y);
    }

    public void setBucketX(float x) {
        bucket.x = x;
    }

    public float getBucketX() {
        return bucket.x;
    }

    public void dispose() {
        bucketImage.dispose();
    }

    public Rectangle getBucket() {
        return bucket;
    }
}
