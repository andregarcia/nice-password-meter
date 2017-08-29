package andre.passwordmeter.rules;

import andre.passwordmeter.rules.additions.NumberOfCharactersScorer;
import org.junit.Test;

import static org.junit.Assert.*;


public class NumberOfCharactersScorerTest {

    private static NumberOfCharactersScorer numberOfCharactersScorer = new NumberOfCharactersScorer();

    @Test
    public void testGetScore(){
        String password = "ah,kh123n ";
        Integer score = numberOfCharactersScorer.getScore(password);
        assertEquals(40, score.intValue());
    }

}