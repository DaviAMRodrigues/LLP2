//http://resizeimage.net/
//https://www.freesound.org//

package gpjecc.blogspot.com;

import java.util.Iterator;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

public class SimpleGame extends ApplicationAdapter {
	private Texture dropImage;
	private Texture bucketImage;
	private Texture raioImage;
	private Texture bubbleImage;
	private Texture bulletImage;
	private Sound dropSound;
	private Sound raioSound;
	private Sound tiroSound;
	private Music rainMusic;
	private SpriteBatch batch;
	private OrthographicCamera camera;
	private BitmapFont font;
	private Movel bucket;
	private Array<Movel> moveis;
	private long lastDropTime;

	@Override
	public void create() {
		Texture.setEnforcePotImages(false);

		// load the images for the droplet and the bucket, 64x64 pixels each
		dropImage = new Texture(Gdx.files.internal("assets/droplet.png"));
		raioImage = new Texture(Gdx.files.internal("assets/raio.png"));// <-- Adicionando imagem de raio
		bucketImage = new Texture(Gdx.files.internal("assets/bucket.png"));
		bubbleImage = new Texture(Gdx.files.internal("assets/bubble.png")); // <-- Adicionando imagem de bolha
		bulletImage = new Texture(Gdx.files.internal("assets/bullet.png")); // <-- Adicionando imagem de bala

		// load the drop sound effect and the rain background "music"
		dropSound = Gdx.audio.newSound(Gdx.files.internal("assets/drop.wav"));
		rainMusic = Gdx.audio.newMusic(Gdx.files.internal("assets/rain.mp3"));
		raioSound = Gdx.audio.newSound(Gdx.files.internal("assets/thunder.mp3"));
		tiroSound = Gdx.audio.newSound(Gdx.files.internal("assets/tiro.mp3")); 

		// start the playback of the background music immediately
		rainMusic.setLooping(true);
		rainMusic.play();

		// create the camera and the SpriteBatch
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);
		batch = new SpriteBatch();

		font = new BitmapFont();
		font.setColor(Color.YELLOW);
		font.setScale(2);

		// create a Rectangle to logically represent the bucket
		spawnBucket();

		// create the raindrops array and spawn the first raindrop
		moveis = new Array<Movel>();
		spawnMovel();
	}

	private void spawnBucket() {
		Rectangle rectangle = new Rectangle();
		rectangle.x = 800 / 2 - 64 / 2; // center the bucket horizontally
		rectangle.y = 20; // bottom left corner of the bucket is 20 pixels above
							// the bottom screen edge
		rectangle.width = 64;
		rectangle.height = 64;
		bucket = new Bucket(rectangle, bucketImage, null);
	}

	private void spawnMovel() {
		Rectangle raindrop = new Rectangle();
		raindrop.x = MathUtils.random(0, 800 - 64);
		raindrop.y = 480;
		raindrop.width = 64;
		raindrop.height = 64;
		Movel movel = new Chuva(raindrop, dropImage, dropSound);
		moveis.add(movel);
		lastDropTime = TimeUtils.nanoTime();
	}

	private void spawnRaio() {
		Rectangle raio = new Rectangle();
		raio.x = MathUtils.random(0, 800 - 64);
		raio.y = 480;
		raio.width = 64;
		raio.height = 64;
		Movel movel = new Raio(raio, raioImage, raioSound);
		moveis.add(movel);
		lastDropTime = TimeUtils.nanoTime();
	}

	private void spawnBolaDeSabao() {
		Rectangle bubble = new Rectangle();
		bubble.x = MathUtils.random(0, 800 - 64);
		bubble.y = 0;
		bubble.width = 64;
		bubble.height = 64;
		Movel movel = new BolaDeSabao(bubble, bubbleImage, dropSound);
		moveis.add(movel);
		lastDropTime = TimeUtils.nanoTime();
	}

	private void spawnBullet() {
		Rectangle bullet = new Rectangle();
		bullet.x = 800;
		bullet.y = MathUtils.random(0, 480 - 64);
		bullet.width = 64;
		bullet.height = 64;
		Movel movel = new Bullet(bullet, bulletImage, tiroSound);
		movel.PlaySound();
		moveis.add(movel);
		lastDropTime = TimeUtils.nanoTime();
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
		bucket.desenha(batch);
		for (Movel movel : moveis) {
			movel.desenha(batch);
			;
		}
		font.draw(batch, "Pontos = " + ((Bucket) bucket).pontos, 650, 460);
		batch.end();

		// process user input
		bucket.handleEvent(camera);

		// check if we need to create a new raindrop
		if (TimeUtils.nanoTime() - lastDropTime > 1000000000) {
			float chance = MathUtils.random() ; // <-- Adicionando aleatoriedade para spawn de movel
			if (chance < 0.25f) { 
				spawnMovel();
			} else if (chance < 0.50f && chance > 0.25f) { 
				spawnBolaDeSabao();
			}else if (chance < 0.75f && chance > 0.50f) { 

				spawnBullet();
			}
			else { 
				spawnRaio();
			}
		}
		// move the raindrops, remove any that are beneath the bottom edge of
		// the screen or that hit the bucket. In the later case we play back
		// a sound effect as well.
		Iterator<Movel> iter = moveis.iterator();
		while (iter.hasNext()) {
			Movel movel = iter.next();

			movel.move();

			if (movel instanceof Chuva) { // Testa se o movel é da classe chuva
				if (movel.getmRectangle().y + 64 < 0)
					iter.remove();
				if (movel.getmRectangle().overlaps(bucket.getmRectangle())) {
					movel.PlaySound();
					bucket.PlaySound();
					((Bucket) bucket).pontos++;
					iter.remove();
				}
			}

			if (movel instanceof BolaDeSabao) { // Testa se o movel é da classe bolha
				if (movel.getmRectangle().y > 480)
					iter.remove();
			}

			if (movel instanceof Bullet) { // Testa se o movel é da classe bolha
				if (movel.getmRectangle().x < 0)
					iter.remove();
			}

			if (movel instanceof Raio) { // Testa se o movel é da classe raio
				if (movel.getmRectangle().y + 64 < 0)
					iter.remove();
				if (movel.getmRectangle().overlaps(bucket.getmRectangle())) {
					movel.PlaySound();
					bucket.PlaySound();
					((Bucket) bucket).pontos = 0;
					iter.remove();
				}
				
			}
		}
	}
	
	//Deleta arquivos
	@Override
	public void dispose() {
		// dispose of all the native resources
		dropImage.dispose();
		bucketImage.dispose();
		raioImage.dispose();
		bubbleImage.dispose();

		font.dispose();

		dropSound.dispose();
		raioSound.dispose();
		rainMusic.dispose();
		batch.dispose();
	}
}