package andre.passwordmeter.response;

import org.assertj.core.util.Lists;

import java.util.List;


public class AdditionsResponseDescription {

    private List<ScoreResponseDesctiptionEntry> scores;

    public AdditionsResponseDescription(){
        this.scores = Lists.newArrayList();
    }

    public List<ScoreResponseDesctiptionEntry> getScores() {
        return scores;
    }

    public void addScoreResponseDesctiptionEntry(ScoreResponseDesctiptionEntry scoreResponseDesctiptionEntry) {
        this.scores.add(scoreResponseDesctiptionEntry);
    }

}
