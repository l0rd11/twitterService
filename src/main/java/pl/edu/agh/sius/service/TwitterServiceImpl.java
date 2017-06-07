package pl.edu.agh.sius.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Created by ja on 06.05.17.
 */
@Service
public class TwitterServiceImpl implements TwitterService {


    @Override
    @HystrixCommand(fallbackMethod = "fallback")
    public List<Status> getInfoAboutGame(String name) throws TwitterException {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("sX1jQOfHbG4oFNEXULUUBeJuj")
                .setOAuthConsumerSecret("vlQPK8UfDBR230pwmbJRlUGyUiWjJVrDBD0aqTrdTFNAqjG1oJ")
                .setOAuthAccessToken("1106934434-QEKAJLIM7WNtVjA96SpPDzjaxzslwx8oQHYXrtG")
                .setOAuthAccessTokenSecret("LIIBDQyEqh4Y2rFC9hf1uRsq48HRmZu6iE72541dByU8s");
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        try {
            Query query = new Query(name);
            QueryResult result;
            result = twitter.search(query);
            List<Status> tweets = result.getTweets();
            return tweets;

        } catch (TwitterException te) {
            te.printStackTrace();
            throw new TwitterException(te);


        }

    }



    @HystrixCommand
    public List<Status> fallback(String name) {
        ArrayList<Status> result = new ArrayList<>();
        return result;
    }
}
