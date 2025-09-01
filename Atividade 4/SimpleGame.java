package com.gpjecc.blogspot.chuvagame;

import java.util.Iterator;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class SimpleGame extends ApplicationAdapter {
  

   private Music rainMusic;
   private SpriteBatch batch;
   private OrthographicCamera camera; 
   private Balde bucket;
   private Gota raindrop;


   @Override
   public void create() {
      // load the images for the droplet and the bucket, 64x64 pixels each
      rainMusic = Gdx.audio.newMusic(Gdx.files.internal("assets/rain.mp3"));

      // start the playback of the background music immediately
      rainMusic.setLooping(true);
      rainMusic.play();

      // create the camera and the SpriteBatch
      camera = new OrthographicCamera();
      camera.setToOrtho(false, 800, 480);
      batch = new SpriteBatch();

      bucket = new Balde();
      bucket.create();

      // create the raindrops array and spawn the first raindrop
      raindrop = new Gota();
      raindrop.create();
   }

   @Override
   public void render() {
      // clear the screen with a dark blue color. The
      // arguments to glClearColor are the red, green
      // blue and alpha component in the range [0,1]
      // of the color to be used to clear the screen.
      Gdx.gl.glClearColor(0, 0, 0.2f, 1);
      Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

      // tell the camera to update its matrices.
      camera.update();

      // tell the SpriteBatch to render in the
      // coordinate system specified by the camera.
      batch.setProjectionMatrix(camera.combined);

      // begin a new batch and draw the bucket and
      // all drops
      batch.begin();
      bucket.draw(batch);
      raindrop.draw(batch);
      batch.end();

      // process user input
      if(Gdx.input.isTouched()) {
         Vector3 touchPos = new Vector3();
         touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
         camera.unproject(touchPos);
         bucket.setBucketX(touchPos.x - 64 / 2);
         //System.out.println("Mouse");
      }
      if(Gdx.input.isKeyPressed(Keys.LEFT)) bucket.setBucketX(bucket.getBucketX() - 200 * Gdx.graphics.getDeltaTime());
      if(Gdx.input.isKeyPressed(Keys.RIGHT)) bucket.setBucketX(bucket.getBucketX() + 200 * Gdx.graphics.getDeltaTime());

      // make sure the bucket stays within the screen bounds
      if(bucket.getBucketX() < 0) bucket.setBucketX(0);
      if(bucket.getBucketX() > 800 - 64) bucket.setBucketX(800 - 64);

      // check if we need to create a new raindrop
      raindrop.update();
      // move the raindrops, remove any that are beneath the bottom edge of
      // the screen or that hit the bucket. In the later case we play back
      // a sound effect as well.
      Iterator<Rectangle> iter = raindrop.iterator();      
      raindrop.moveRainDrop(iter, bucket);
   }

   @Override
   public void dispose() {
      // dispose of all the native resources
      raindrop.dispose();
      bucket.dispose();
      rainMusic.dispose();
      batch.dispose();
   }
}