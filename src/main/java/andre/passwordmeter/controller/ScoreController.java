package andre.passwordmeter.controller;


import andre.passwordmeter.response.ScoreResponse;
import andre.passwordmeter.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @RequestMapping(path="/score", method = GET)
    public ScoreResponse getScore(@RequestParam String password){
        return scoreService.getScore(password);
    }

}
