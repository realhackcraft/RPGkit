package entity;

import LDtk.EntityInstance;
import LDtk.FieldInstance;
import LDtk.LayerInstance;
import LDtk.Level;
import main.GamePanel;
import main.KeyHandler;
import utils.Direction;
import utils.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;

import static java.awt.event.KeyEvent.*;
import static utils.Direction.*;

public class Player extends Entity {
    private final GamePanel gamePanel;
    private final KeyHandler keyHandler;

    public Player(GamePanel gamePanel, KeyHandler keyHandler) {
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;
        this.direction = DOWN;
        this.spritesheet = new Spritesheet(16, 16);
        loadDataFromLDtk();
        loadSpritesheet();
    }

    private void loadSpritesheet() {
        spritesheet.loadImage("/player/images/player.png");
        spritesheet.cut();
    }

    public void loadDataFromLDtk() {
        Level[] levels = gamePanel.ldtk.getLevels();
        for (Level level : levels) {
            if (level.getIdentifier().equals("Level_0")) {
                for (LayerInstance layer : level.getLayerInstances()) {
                    if (layer.getIdentifier().equals("Entities") && layer.getType().equals("Entities")) {
                        for (EntityInstance entity : layer.getEntityInstances()) {
                            if (entity.getIdentifier().equals("PlayerStart")) {
                                this.x = entity.getPx()[0];
                                this.y = entity.getPx()[1];
                                for (FieldInstance field : entity.getFieldInstances()) {
                                    if (field.getIdentifier().equals("Direction")) {
                                        this.direction = Direction.valueOf((String) field.getValue());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        this.speed = 0.05;
    }

    @Override
    public void update(double delta) {
        if (keyHandler.isKeyPressed(VK_W)) {
            this.y -= this.speed * 10;
            this.direction = UP;
        }
        if (keyHandler.isKeyPressed(VK_A)) {
            this.x -= this.speed * 10;
            this.direction = LEFT;
        }
        if (keyHandler.isKeyPressed(VK_S)) {
            this.y += this.speed * 10;
            this.direction = DOWN;
        }
        if (keyHandler.isKeyPressed(VK_D)) {
            this.x += this.speed * 10;
            this.direction = RIGHT;
        }
    }

    @Override
    public void draw(Graphics2D g2d) {
        BufferedImage frame = switch (this.direction) {
            case UP -> spritesheet.getFrame(0, 0);
            case LEFT -> spritesheet.getFrame(0, 1);
            case DOWN -> spritesheet.getFrame(0, 2);
            case RIGHT -> Utils.images.flipHorizontal(spritesheet.getFrame(0, 1));
        };

        g2d.scale(gamePanel.tileScale, gamePanel.tileScale);
        g2d.drawImage(frame, (int) this.x, (int) this.y, gamePanel);
        g2d.scale(1, 1);
    }

}
