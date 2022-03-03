package edu.bristol;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IMDBRatingTest
{
    @Test
    public void testAverageRating()
    {
        float averageRating;
        IMDBRating rater = new IMDBRating();

        averageRating = rater.addNewRating(2);
        assertTrue(averageRating == 2.0, "Adding 1st rating: average should be 2.0");

        averageRating = rater.addNewRating(4);
        assertTrue(averageRating == 3.0, "Adding 2nd rating: average should be 3.0");

    }
    @Test
    public void testAverageRating2()
    {
        float averageRating;
        IMDBRating rater = new IMDBRating();

        averageRating = rater.addNewRating(1);
        assertTrue(averageRating == 1.0, "Adding 1st rating: average should be 1.0");

        averageRating = rater.addNewRating(2);
        assertTrue(averageRating == 1.5, "Adding 2nd rating: average should be 1.5");

    }
    @Test
    public void testAverageRating3()
    {
        float averageRating;
        IMDBRating rater = new IMDBRating();

        averageRating = rater.addNewRating(2);
        assertTrue(averageRating == 2.0);

        averageRating = rater.addNewRating(11);
        assertTrue(averageRating == 2.0);

        averageRating = rater.addNewRating(-1);
        assertTrue(averageRating == 2.0);

    }
}
