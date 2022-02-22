package edu.bristol;

public class IMDBRating
{
    private float currentAverage = 0;
    private int ratingCount = 0;

    public float addNewRating(int newRating)
    {

	System.out.println("Hi there");

        int previousTotal = (int) (currentAverage * ratingCount);
        int newTotal = previousTotal + newRating;
        ratingCount++;
        currentAverage = newTotal / ratingCount;
        return currentAverage;
    }
}
