package model.gamelogic;

public class CoordinatesHelper {
    public static boolean areApproximatelyEqual(float point1, float point2) {
        return Math.abs(point1 - point2) <= 0.1;
    }
}

