package andre.passwordmeter.service;


import andre.passwordmeter.response.Complexity;
import andre.passwordmeter.response.ScoreResponse;
import andre.passwordmeter.response.ScoreResponseDesctiptionEntry;
import andre.passwordmeter.rules.AdditionScorer;
import andre.passwordmeter.rules.DeductionScorer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ScoreService {

    @Autowired
    private List<AdditionScorer> additionScorerList;

    @Autowired
    private List<DeductionScorer> deductionScorerList;

    public ScoreResponse getScore(String password){
        ScoreResponse scoreResponse = new ScoreResponse();
        addAdditionsResults(password, scoreResponse);
        addDeductionResults(password, scoreResponse);
        scoreResponse.setComplexity(Complexity.getComplexity(scoreResponse.getScore()));
        scoreResponse.setPassword(password);
        return scoreResponse;
    }

    private void addAdditionsResults(String password, ScoreResponse scoreResponse){
        for(AdditionScorer addSc : additionScorerList){
            Integer score = addSc.getScore(password);
            ScoreResponseDesctiptionEntry scoreResponseDesctiptionEntry = new ScoreResponseDesctiptionEntry(
                    addSc.name(),
                    addSc.getCount(password),
                    score
            );
            scoreResponse.addAdditionsResponseDescriptionEntry(scoreResponseDesctiptionEntry);
            scoreResponse.addScore(score);
        }
    }

    private void addDeductionResults(String password, ScoreResponse scoreResponse){
        for(DeductionScorer dedSc : deductionScorerList){
            Integer score = dedSc.getScore(password);
            ScoreResponseDesctiptionEntry scoreResponseDesctiptionEntry = new ScoreResponseDesctiptionEntry(
                    dedSc.name(),
                    dedSc.getCount(password),
                    score
            );
            scoreResponse.addDeductionResponseDescriptionEntry(scoreResponseDesctiptionEntry);
            scoreResponse.addScore(score);
        }
    }

}
