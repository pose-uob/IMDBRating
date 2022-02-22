package edu.bristol;

public class IMDBRating
{
    private float accumulateRate = 0;
    private float currentAverage = 0;
    private int ratingCount = 0;

    public float addNewRating(int newRating)
    {
        if(newRating >=1 && newRating<=10) {
            accumulateRate += newRating;
            ratingCount++;
            currentAverage = accumulateRate / ratingCount;
        }
        return currentAverage;
    }
}
