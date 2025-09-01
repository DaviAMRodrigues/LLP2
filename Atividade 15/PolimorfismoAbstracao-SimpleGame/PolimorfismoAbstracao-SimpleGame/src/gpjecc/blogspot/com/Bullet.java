package gpjecc.blogspot.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Bullet extends Movel {

    public Bullet(Rectangle rectangle, Texture texture, Sound sound) {
        super(rectangle, texture, sound);
    }

    @Override
    public void move() {
        getmRectangle().x -= 200 * Gdx.graphics.getDeltaTime();
    }

    @Override
    public void handleEvent(OrthographicCamera camera) {
        // Implement any specific event handling for BolaDeSabao if needed
    }
    
}
