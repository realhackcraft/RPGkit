package utils;

import main.GamePanel;

public class GameUtils {
    GamePanel gamePanel = GamePanel.getInstance();

    public double calculateDistance(double[] point1, double[] point2) {
        if (point1.length != 2 || point2.length != 2) {
            throw new IllegalArgumentException("Both points must have two coordinates");
        }

        double a = point1[0] - point2[0];
        double b = point1[1] - point2[1];

        return Math.sqrt(a * a + b * b);
    }

    public boolean isOffScreen(double[] screenPosition) {
        return screenPosition[0] + gamePanel.scaledTileSize < 0 ||  // completely on the left of the game panel
                screenPosition[0] > gamePanel.getWidth() ||           // completely on the right of the game panel
                screenPosition[1] + gamePanel.scaledTileSize < 0 ||  // completely above the game panel
                screenPosition[1] > gamePanel.getHeight();           // completely beneath the game panel
    }
}
