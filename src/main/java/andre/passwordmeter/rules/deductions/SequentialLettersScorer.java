package andre.passwordmeter.rules.deductions;


import andre.passwordmeter.rules.DeductionScorer;
import org.assertj.core.util.Sets;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Set;


@Component
@Order(value = 7)
public class SequentialLettersScorer implements DeductionScorer {

    private static final String LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String LETTERS_REVERSED = new StringBuilder(LETTERS).reverse().toString();
    private static final Integer MIN_SEQUENCE = 3;

    @Override
    public Integer getScore(String password) {
        return -getCount(password)*3;
    }

    @Override
    public Integer getCount(String password) {
        Set<String> found = Sets.newHashSet();
        return getCountForward(password, found) + getCountReverse(password, found);
    }

    @Override
    public String name() {
        return "Sequential Letters (3+)";
    }

    private Integer getCountForward(String password, Set<String> skip){
        Integer count = 0;
        for(int i=0; i<LETTERS.length()-MIN_SEQUENCE+1; i++){
            String sequence = LETTERS.substring(i, i+MIN_SEQUENCE);
            if(skip.contains(sequence.toLowerCase())) continue;
            for(int j=0; j<password.length(); j++){
                if(j+MIN_SEQUENCE>password.length()) break;
                if(password.substring(j, j+MIN_SEQUENCE).toLowerCase().equals(sequence)){
                    addToSkip(skip, sequence);
                    count += 1;
                    break;
                }
            }
        }
        return count;
    }

    private Integer getCountReverse(String password, Set<String> skip){
        Integer count = 0;
        for(int i=0; i<LETTERS_REVERSED.length()-MIN_SEQUENCE+1; i++){
            String sequence = LETTERS_REVERSED.substring(i, i+MIN_SEQUENCE);
            if(skip.contains(sequence.toLowerCase())) continue;
            for(int j=0; j<password.length(); j++){
                if(j+MIN_SEQUENCE>password.length()) break;
                if(password.substring(j, j+MIN_SEQUENCE).toLowerCase().equals(sequence)){
                    addToSkip(skip, sequence);
                    count += 1;
                    break;
                }
            }
        }
        return count;
    }

    private void addToSkip(Set<String> skip, String sequence){
        skip.add(sequence);
        skip.add(sequence.toLowerCase());
        skip.add(sequence.toUpperCase());
        skip.add(new StringBuilder(sequence).reverse().toString());
        skip.add(new StringBuilder(sequence).reverse().toString().toLowerCase());
    }

}
