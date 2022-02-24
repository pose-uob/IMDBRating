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

        averageRating = rater.addNewRating(-3);
        assertTrue(averageRating == 3.0, "Ignoring negative number -2");

        averageRating = rater.addNewRating(3);
        assertTrue(averageRating == 3.0, "Adding 3: average should be 3.0");

        averageRating = rater.addNewRating(8);
        assertTrue(averageRating == 4.0, "Adding 8: average should be 4.0");

        averageRating = rater.addNewRating(19);
        assertTrue(averageRating == 4.1,"Ignoring too large number 20");
    }
}
