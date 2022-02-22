package edu.bristol;

public class IMDBRating {
    private float currentAverage = 0;
    private int ratingCount = 0;

    public float addNewRating(int newRating) {
        float previousTotal = currentAverage * ratingCount;
        float newTotal = previousTotal + newRating;
        ratingCount++;
        currentAverage = newTotal / ratingCount;
        currentAverage = Math.round(currentAverage * 10.0) / 10.0f;
        return currentAverage;
    }
}
