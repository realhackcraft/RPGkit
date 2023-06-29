package main;

import LDtk.TilesetDefinition;
import utils.Utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

/**
 * The TileSet class represents a set of tiles that are used to form a larger image.
 * Internally, it uses an ArrayList of BufferedImages to store the individual tiles.
 * It also provides methods for loading, cutting, and retrieving individual frames.
 */

public class TileSet {
    /**
     * This variable represents an ArrayList that holds BufferedImage objects.
     * It is used to store all the frames of an animation sequence. The ArrayList
     * implementation provides flexibility to dynamically add or remove frames at runtime.
     *
     * @see java.util.ArrayList
     * @see java.awt.image.BufferedImage
     */
    ArrayList<BufferedImage> frames = new ArrayList<>();

    /**
     * Represents the number of columns in the TileSet.
     */
    private long colCount;

    /**
     * This is a private final variable that holds the definition of a Tileset.
     * The TilesetDefinition class is used to define a set of tiles that may be used in a game or simulation.
     * It holds information on the size of the tiles, as well as how the tiles are arranged within the tileset image.
     * The variable is marked final so that it cannot be reassigned after it is set.
     */
    private final TilesetDefinition tileSet;

    /**
     * This variable represents an image in the BufferedImage format.
     * It can be used to store and manipulate images in the application.
     *
     * @see BufferedImage
     */
    private BufferedImage image;

    /**
     * Constructor for creating a TileSet object.
     *
     * @param tileSet the TilesetDefinition object for setting tileset details
     * @throws IllegalArgumentException when tileset path not found or invalid
     */
    public TileSet(TilesetDefinition tileSet) {
        this.tileSet = tileSet;
        loadImage('/' + Utils.paths.normalizePath("world/" + tileSet.getRelPath()));
    }

    /**
     * Returns the specific frame of the TileSet object's frames collection.
     *
     * @param frame the index of the requested frame
     * @return the BufferedImage of the requested frame
     */
    public BufferedImage getFrame(int frame) {
        return frames.get(frame);
    }

    /**
     * Returns the specific frame of the TileSet object's frames collection based on row and column.
     *
     * @param row the integer value representing the row index of the requested frame
     * @param col the integer value representing the column index of the requested frame
     * @return the BufferedImage of the requested frame referenced by row and column indices
     */
    public BufferedImage getFrame(int row, int col) {
        return frames.get((int) (col + row * colCount));
    }

    /**
     * Sets the image property of the TileSet object and updates the colCount property based
     * on the image's width and the tile grid size property of the TileSet object.
     *
     * @param image the BufferedImage that represents the image to be loaded as the
     *              TileSet object's image property
     */
    public void loadImage(BufferedImage image) {
        this.image = image;
        this.colCount = (image.getWidth() - 2 * this.tileSet.getPadding()) / this.tileSet.getTileGridSize();
    }

    /**
     * Loads the image from the given file path using the ImageIO class and sets the image property
     * of the TileSet object. It also updates the colCount property based on the image's width and
     * the tile grid size property of the TileSet object.
     *
     * @param path the String file path of the image to be loaded
     */
    private void loadImage(String path) {
        try {
            this.image = ImageIO.read(Objects.requireNonNull(getClass().getResource(path)));
            this.colCount = image.getWidth() / this.tileSet.getTileGridSize();
        } catch (IOException e) {
            System.err.println("Error loading image: " + path);
        }
    }

    /**
     * Cuts the loaded image into individual tiles based on the tile grid size and spacing properties
     * of the TileSet object. It adds each tile to the frames list property for later use.
     *
     * @throws NullPointerException if the loaded image is null
     */
    public void cut() {
        for (long y = 0; y < image.getHeight(); y += this.tileSet.getTileGridSize() + this.tileSet.getSpacing()) {
            for (long x = 0; x < image.getWidth(); x += this.tileSet.getTileGridSize() + this.tileSet.getSpacing()) {
                BufferedImage sprite = image.getSubimage((int) x,
                        (int) y,
                        (int) this.tileSet.getTileGridSize(),
                        (int) this.tileSet.getTileGridSize());
                frames.add(sprite);
            }
        }
    }
}
