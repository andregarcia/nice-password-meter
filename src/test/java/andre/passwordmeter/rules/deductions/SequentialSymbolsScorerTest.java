package andre.passwordmeter.rules.deductions;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by andregarcia on 28/08/17.
 */
public class SequentialSymbolsScorerTest {

    private SequentialSymbolsScorer sequentialSymbolsScorer = new SequentialSymbolsScorer();

    @Test
    public void getScore() throws Exception {
        String password = "abc!@#$";
        assertEquals(-6, sequentialSymbolsScorer.getScore(password).intValue());
    }

    @Test
    public void getCount() throws Exception {
        String password = "abc!@#$";
        assertEquals(2, sequentialSymbolsScorer.getCount(password).intValue());
    }



}