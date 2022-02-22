package edu.bristol;

public class IMDBRating
{
    private float currentAverage = 0;
    private int ratingCount = 0;

    public float addNewRating(int newRating)
    {   if(newRating<1){
          newRating =1;
        }
        if(newRating>10){
            newRating=10;
        }
        int previousTotal = (int) (currentAverage * ratingCount);
        int newTotal = previousTotal + newRating;
        ratingCount++;
        //currentAverage = newTotal / ratingCount;
        currentAverage = newTotal / (float)ratingCount;
        return currentAverage;
    }
}
