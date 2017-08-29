package andre.passwordmeter.rules;

import andre.passwordmeter.rules.additions.UppercaseLettersScorer;
import org.junit.Test;

import static org.junit.Assert.*;


public class UppercaseLettersScorerTest {

    private static UppercaseLettersScorer uppercaseLettersScorer = new UppercaseLettersScorer();

    @Test
    public void testGetScore(){
        String password = "AbCDe";
        Integer score = uppercaseLettersScorer.getScore(password);
        assertEquals(4, score.intValue());
    }

}
