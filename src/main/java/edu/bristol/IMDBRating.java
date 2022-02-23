
package edu.bristol;

import java.text.DecimalFormat;

public class IMDBRating
{
    private float currentAverage = 0;
    private int ratingCount = 0;

    public float addNewRating(int newRating)
    {
        if (isValidRating(newRating)) {
            int previousTotal = (int)(currentAverage * ratingCount);
            float newTotal = previousTotal + newRating;
            ratingCount++;
            currentAverage = toTwoDecimal(newTotal / ratingCount);
            System.out.println("current average is " + currentAverage);
            return currentAverage;
        }
        else
            return Float.NaN;
    }
    public boolean isValidRating(int rateNumber)
    {
        if (rateNumber < 0 || rateNumber > 10) return false;
        else return true;
    }
    public float toTwoDecimal(float originalNumber)
    {
        DecimalFormat df = new DecimalFormat("0.00");
        float newNumber = Float.parseFloat(df.format(originalNumber));
        return newNumber;
    }
}
