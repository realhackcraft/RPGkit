package entity;

import utils.Direction;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Entity {
    public double x;
    public double y;
    public double speed;
    public Spritesheet spritesheet;
    public Direction direction;

    public abstract void update(double delta);
    public abstract void draw(Graphics2D g2d);
}
