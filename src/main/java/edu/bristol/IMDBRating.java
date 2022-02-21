package edu.bristol;

public class IMDBRating
{
    private double currentAverage = 0;
    private int ratingCount = 0;

    public double addNewRating(int newRating)
    {
        double previousTotal = (currentAverage * ratingCount);
        float newTotal = previousTotal + newRating;
        ratingCount++;
        currentAverage = newTotal / ratingCount;
        System.out.println(currentAverage);
        return currentAverage;
    }
}
