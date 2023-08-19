package rpgkit.util;

import rpgkit.RPGKit;

public class GameUtils {
    RPGKit RPGKit = rpgkit.RPGKit.getInstance();

    public double calculateDistance(double[] point1, double[] point2) {
        if (point1.length != 2 || point2.length != 2) {
            throw new IllegalArgumentException("Both points must have two coordinates");
        }

        double a = point1[0] - point2[0];
        double b = point1[1] - point2[1];

        return Math.sqrt(a * a + b * b);
    }

    public boolean isOffScreen(double[] screenPosition) {
        return screenPosition[0] + RPGKit.scaledTileSize < 0 ||  // completely on the left of the game panel
                screenPosition[0] > RPGKit.getWidth() ||           // completely on the right of the game panel
                screenPosition[1] + RPGKit.scaledTileSize < 0 ||  // completely above the game panel
                screenPosition[1] > RPGKit.getHeight();           // completely beneath the game panel
    }
}
