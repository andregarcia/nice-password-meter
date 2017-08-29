package andre.passwordmeter.rules.deductions;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by andregarcia on 28/08/17.
 */
public class SequentialLettersScorerTest {

    private static final SequentialLettersScorer sequentialLettersScorer =  new SequentialLettersScorer();


    @Test
    public void getScore() throws Exception {
        String password = "123abcd45pqr32dcba";
        assertEquals(-9, sequentialLettersScorer.getScore(password).intValue());

        password = "01298410298lçkjalshfd";
        assertEquals(0, sequentialLettersScorer.getScore(password).intValue());

        password = "";
        assertEquals(0, sequentialLettersScorer.getScore(password).intValue());
    }

    @Test
    public void getCount() throws Exception {
        String password = "123abcd45pqr32dcba";
        assertEquals(3, sequentialLettersScorer.getCount(password).intValue());

        password = "01298410298lçkjalshfd";
        assertEquals(0, sequentialLettersScorer.getCount(password).intValue());

        password = "";
        assertEquals(0, sequentialLettersScorer.getCount(password).intValue());
    }

}