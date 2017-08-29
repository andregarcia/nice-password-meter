package andre.passwordmeter.response;

import org.assertj.core.util.Lists;

import java.util.List;


public class DeductionResponseDescription {

    private List<ScoreResponseDesctiptionEntry> scores;

    public DeductionResponseDescription() {
        this.scores = Lists.newArrayList();
    }

    public List<ScoreResponseDesctiptionEntry> getScores() {
        return scores;
    }

    public void addScoreResponseDesctiptionEntry(ScoreResponseDesctiptionEntry scoreResponseDesctiptionEntry) {
        this.scores.add(scoreResponseDesctiptionEntry);
    }

}
