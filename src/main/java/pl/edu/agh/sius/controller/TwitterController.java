package pl.edu.agh.sius.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.agh.sius.service.TwitterService;
import pl.edu.agh.sius.service.Util;
import twitter4j.Status;
import twitter4j.TwitterException;

import java.util.List;


/**
 * Created by ja on 06.05.17.
 */
@RestController
public class TwitterController {

    @Autowired
    private TwitterService twitterService;

    @Autowired
    Util util;


    @RequestMapping(value = "/getInfo/{name}", method = RequestMethod.GET)
    public ResponseEntity<List<Status>> getInfo(@PathVariable("name") String name) throws TwitterException {
        List<Status> response = twitterService.getInfoAboutGame(name);
        if(response != null)
            return util.createOkResponse(response);
        else
            return util.createBadResponse(response);
    }


}
