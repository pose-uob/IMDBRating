package edu.bristol;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

        averageRating = rater.addNewRating(6);
        assertTrue(averageRating == 4.0, "Adding 3rd rating: average should be 4.0");

    }
    @Test
    public void testAverageRating2()
    {
        float averageRating;
        IMDBRating rater = new IMDBRating();

        averageRating = rater.addNewRating(2);
        assertEquals( 2.0, averageRating);

        averageRating = rater.addNewRating(3);
        assertEquals( 2.5, averageRating);
        //ratings greater than 10 is treated as 10
        averageRating = rater.addNewRating(16);
        assertEquals( 5.0, averageRating);
        //ratings less than 1 is treated as 1
        averageRating = rater.addNewRating(-12);
        assertEquals( 4, averageRating);

        averageRating = rater.addNewRating(4);
        assertEquals( 4.0, averageRating);
    }

}
