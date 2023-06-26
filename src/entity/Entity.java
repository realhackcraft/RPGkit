package entity;

import utils.Direction;

import java.awt.*;

public abstract class Entity {
    public double x;
    public double y;
    public double speed;
    public TileSet tileSet;
    public Direction direction;

    public abstract void update(double delta);

    public abstract void draw(Graphics2D g2d);
}
