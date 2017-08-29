package andre.passwordmeter.rules.deductions;

import org.junit.Test;

import static org.junit.Assert.*;


public class RepeatCharactersScorerTest {

    private static RepeatCharactersScorer repeatCharactersScorer = new RepeatCharactersScorer();


    @Test
    public void testGetCount(){
        String password = "AaAAabc";
        Integer count = repeatCharactersScorer.getCount(password);
        assertEquals(5, count.intValue());

        password = "abEreErt";
        count = repeatCharactersScorer.getCount(password);
        assertEquals(4, count.intValue());

        password = "abcdef";
        count = repeatCharactersScorer.getCount(password);
        assertEquals(0, count.intValue());
    }

    @Test
    public void testGetScore(){
        String password = "AaAAabc";
        Integer count = repeatCharactersScorer.getScore(password);
        assertEquals(-4, count.intValue());

        password = "abEreErt";
        count = repeatCharactersScorer.getScore(password);
        assertEquals(-1, count.intValue());

        password = "abcdef";
        count = repeatCharactersScorer.getScore(password);
        assertEquals(0, count.intValue());
    }


}