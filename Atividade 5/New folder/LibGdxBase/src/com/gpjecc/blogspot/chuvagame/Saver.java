package com.gpjecc.blogspot.chuvagame;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.graphics.Texture;

public class Saver implements SpawRainDrop {

    private static final String savFile = "game_save.dat";

    public void saveGame(int vidas, int pontos, Rectangle bucket, Array<Rectangle> raindrops) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(savFile))) {
            out.writeInt(vidas);
            out.writeInt(pontos);
            out.writeFloat(bucket.x);
            out.writeFloat(bucket.y);
            out.writeInt(raindrops.size);
            for (Rectangle raindrop : raindrops) {
                out.writeFloat(raindrop.x);
                out.writeFloat(raindrop.y);
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar o jogo: " + e.getMessage());
        }
    }

    public void loadGame(GameStats stats, Rectangle bucket, Array<Rectangle> raindrops, Texture dropImage, long lastDropTime) {
        File file = new File(savFile);
        if (file.exists()) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(savFile))) {
                stats.vidas = in.readInt();
                stats.pontos = in.readInt();
                bucket.x = in.readFloat();
                bucket.y = in.readFloat();
                int raindropCount = in.readInt();
                raindrops.clear();
                for (int i = 0; i < raindropCount; i++) {
                    Rectangle raindrop = new Rectangle();
                    raindrop.x = in.readFloat();
                    raindrop.y = in.readFloat();
                    raindrop.width = dropImage.getWidth();
                    raindrop.height = dropImage.getHeight();
                    raindrops.add(raindrop);
                }
            } catch (IOException e) {
                System.err.println("Erro ao carregar o jogo: " + e.getMessage());
            }
        } else {
            bucket.x = 800 / 2 - 64 / 2;
            bucket.y = 20;
            spawnRaindrop(raindrops, dropImage, lastDropTime);
        }
    }

    @Override
    public void spawnRaindrop(Array<Rectangle> raindrops, Texture dropImage, long lastDropTime) {
        spawnRaindropImpl(raindrops, dropImage, lastDropTime);
    }

    public void resetGame() {
        File file = new File(savFile);
        if (file.exists()) {
            file.delete();
        }
    }
}
