package edu.bristol;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IMDBRatingTest
{
    @Test
    public void testAverageRating()
    {
        double averageRating;
        IMDBRating rater = new IMDBRating();

        averageRating = rater.addNewRating(2);
        assertTrue(averageRating == 2.0, "Adding 1st rating: average should be 2.0");

        averageRating = rater.addNewRating(4);
        assertTrue(averageRating == 3.0, "Adding 2nd rating: average should be 3.0");

        averageRating = rater.addNewRating(6);
        assertTrue(averageRating == 4.0, "Adding 3rd rating: average should be 4.0");

        averageRating = rater.addNewRating(8);
        assertTrue(averageRating == 5.0, "Adding 4th rating: average should be 5.0");

        averageRating = rater.addNewRating(10);
        assertTrue(averageRating == 6.0, "Adding 5th rating: average should be 6.0");

        averageRating = rater.addNewRating(8);
        assertTrue(averageRating == 38.0/6.0, "Adding 6th rating: average should be 6.3 recurring");

        averageRating = rater.addNewRating(7);
        assertTrue(averageRating == 45.0/7.0, "Adding 7th rating: average should be 4.0");

        averageRating = rater.addNewRating(9);
        assertTrue(averageRating == 54.0/8.0, "Adding 8th rating: average should be 4.0");

        averageRating = rater.addNewRating(6);
        assertTrue(averageRating == 60.0/9.0, "Adding 9th rating: average should be 4.0");

        averageRating = rater.addNewRating(6);
        assertTrue(averageRating == 66.0/10.0, "Adding 10th rating: average should be 4.0");

        averageRating = rater.addNewRating(2);
        assertTrue(averageRating == 68.0/11.0, "Adding 11th rating: average should be 4.0");

        averageRating = rater.addNewRating(3);
        assertTrue(averageRating == 71.0/12.0, "Adding 12th rating: average should be 4.0");

        averageRating = rater.addNewRating(5);
        assertTrue(averageRating == 76.0/13.0, "Adding 13th rating: average should be 4.0");

        averageRating = rater.addNewRating(8);
        assertTrue(averageRating == 84.0/14, "Adding 14th rating: average should be 5.0");

        averageRating = rater.addNewRating(10);
        assertTrue(averageRating == 94.0/15.0, "Adding 15th rating: average should be 6.0");

        averageRating = rater.addNewRating(8);
        assertTrue(averageRating == 102.0/16.0, "Adding 16th rating: average should be 6.3 recurring");

        averageRating = rater.addNewRating(7);
        assertTrue(averageRating == 109.0/17.0, "Adding 17th rating: average should be 4.0");

        averageRating = rater.addNewRating(9);
        assertTrue(averageRating == 118.0/18.0, "Adding 18th rating: average should be 4.0");

    }
}
