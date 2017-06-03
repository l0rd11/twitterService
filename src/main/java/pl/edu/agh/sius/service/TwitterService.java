package pl.edu.agh.sius.service;

import twitter4j.Status;
import twitter4j.TwitterException;

import java.util.List;

/**
 * Created by ja on 06.05.17.
 */
public interface TwitterService {
    List<Status> getInfoAboutGame(String name) throws TwitterException;
}
