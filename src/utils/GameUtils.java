package utils;

import main.GamePanel;

public class GameUtils {
    GamePanel gamePanel = GamePanel.getInstance();

    public double calculateDistance(double[] point1, double[] point2) {
        if (point1.length != 2 || point2.length != 2) {
            throw new IllegalArgumentException("Both points must have two coordinates");
        }

        double a = Math.abs(point1[0] - point2[0]);
        double b = Math.abs(point1[1] - point2[1]);

        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }

    public boolean isOffScreen(double[] screenPosition) {
        return screenPosition[0] + gamePanel.scaledTileSize < 0 &&
                screenPosition[0] > gamePanel.getWidth() &&
                screenPosition[1] + gamePanel.scaledTileSize < 0 &&
                screenPosition[1] > gamePanel.getHeight();
    }
}
