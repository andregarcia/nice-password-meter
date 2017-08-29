package andre.passwordmeter.rules.deductions;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by andregarcia on 28/08/17.
 */
public class SequentialNumbersScorerTest {

    private SequentialNumbersScorer sequentialNumbersScorer = new SequentialNumbersScorer();

    @Test
    public void getScore() throws Exception {
        String password = "1236543";
        assertEquals(-9, sequentialNumbersScorer.getScore(password).intValue());
    }

    @Test
    public void getCount() throws Exception {
        String password = "1236543";
        assertEquals(3, sequentialNumbersScorer.getCount(password).intValue());
    }

}