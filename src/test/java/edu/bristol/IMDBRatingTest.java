package edu.bristol;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class IMDBRatingTest
{
    public String findTitle(String string)
    {
        int idx = string.indexOf("anchor\" id=");
        int len = "anchor\" id=".length();
        String rest = string.substring(idx+len);
        int i=1;
        while(rest.charAt(i)!='"'){
            i++;
        }
        String finalString = rest.replace('_',' ');
        return finalString.substring(0,i+1);
    }

    public ArrayList<String> findDifference(ArrayList<String> imdb, ArrayList<String> wiki)
    {
        ArrayList<String> missingMovie = new ArrayList<>();
        for(String movie:wiki){
            if(!imdb.contains(movie)){
                missingMovie.add(movie);
            }
        }
        return missingMovie;
    }

    @Test
    public void testAverageRating()
    {
        float averageRating=0;
        IMDBRating rater = new IMDBRating();

        for(int i=1;i<=10;i++){
            averageRating = rater.addNewRating(i);
        }
        System.out.println(averageRating);
        assertEquals(5.5, averageRating, "average should be 5.5 but it was " + averageRating);
    }

    @Test
    public void testAverageRating2()
    {
        float averageRating;
        IMDBRating rater = new IMDBRating();

        for(int i=1;i<=10;i++){
            rater.addNewRating(i);
        }
        rater.addNewRating(8);
        averageRating = rater.addNewRating(8);
        System.out.println(averageRating);
        assertEquals(averageRating, (float) 71 / (float) 12, "average should be 5.5 but it was " + averageRating);
    }

    @Test
    public void testOutRange()
    {
        float averageRating;
        IMDBRating rater = new IMDBRating();

        for(int i=1;i<=10;i++){
            rater.addNewRating(i);
        }
        averageRating = rater.addNewRating(0);
        System.out.println(averageRating);
        assertEquals(5.5, averageRating, "average should be 5.5 but it was " + averageRating);
    }

    @Test
    public void testOutRange2()
    {
        float averageRating;
        IMDBRating rater = new IMDBRating();

        for(int i=1;i<=10;i++){
            rater.addNewRating(i);
        }
        averageRating = rater.addNewRating(-1);
        System.out.println(averageRating);
        assertEquals(5.5, averageRating, "average should be 5.5 but it was " + averageRating);
    }

    @Test
    public void testOutRange3()
    {
        float averageRating;
        IMDBRating rater = new IMDBRating();

        for(int i=1;i<=10;i++){
            rater.addNewRating(i);
        }
        averageRating = rater.addNewRating(12);
        System.out.println(averageRating);
        assertEquals(5.5, averageRating, "average should be 5.5 but it was " + averageRating);
    }

    @Test
    public void releaseTestIMDBSearch() throws IOException {
        URL url = new URL("https://www.imdb.com/search/title/?locations=bristol&role=nm0263368");
        HttpURLConnection connection =(HttpURLConnection)url.openConnection();
        connection.setDoOutput(true);
        connection.setRequestMethod("GET");
        InputStream stream = connection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        String nextLine = reader.readLine();
        ArrayList<String> titleIMDB = new ArrayList<>();
        while(nextLine != null) {
            // Check the line to see what it contains
            if(nextLine.contains("<img alt=\"")){
                //System.out.println(nextLine);
                titleIMDB.add(nextLine.substring(11));
            }
            nextLine = reader.readLine();
        }
        System.out.println(titleIMDB);

        URL url2 = new URL("https://en.wikipedia.org/wiki/Shoestring_(TV_series)");
        HttpURLConnection connection2 =(HttpURLConnection)url2.openConnection();
        connection2.setDoOutput(true);
        connection2.setRequestMethod("GET");
        InputStream stream2 = connection2.getInputStream();
        BufferedReader reader2 = new BufferedReader(new InputStreamReader(stream2));
        nextLine = reader2.readLine();
        ArrayList<String> titleWiki = new ArrayList<>();
        while(nextLine != null) {
            // Check the line to see what it contains
            if(nextLine.contains("<span class=\"anchor\" id=\"")){
                //System.out.println(findTitle(nextLine));
                titleWiki.add(findTitle(nextLine));
            }
            nextLine = reader2.readLine();
        }
        System.out.println(titleWiki);

        System.out.println(findDifference(titleIMDB, titleWiki));

    }

}
