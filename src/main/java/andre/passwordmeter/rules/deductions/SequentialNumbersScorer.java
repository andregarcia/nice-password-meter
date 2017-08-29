package andre.passwordmeter.rules.deductions;

import andre.passwordmeter.rules.DeductionScorer;
import org.assertj.core.util.Sets;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Set;


@Component
@Order(value = 8)
public class SequentialNumbersScorer implements DeductionScorer {

    private static final String NUMBERS = "0123456789";
    private static final String NUMBERS_REVERSED = new StringBuilder(NUMBERS).reverse().toString();
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
        return "Sequential Numbers (3+)";
    }

    private Integer getCountForward(String password, Set<String> skip){
        Integer count = 0;
        for(int i = 0; i< NUMBERS.length()-MIN_SEQUENCE+1; i++){
            String sequence = NUMBERS.substring(i, i+MIN_SEQUENCE);
            if(skip.contains(sequence)) continue;
            for(int j=0; j<password.length(); j++){
                if(j+MIN_SEQUENCE>password.length()) break;
                if(password.substring(j, j+MIN_SEQUENCE).toLowerCase().equals(sequence)){
                    skip.add(sequence);
                    skip.add(new StringBuilder(sequence).reverse().toString());
                    count += 1;
                }
            }
        }
        return count;
    }

    private Integer getCountReverse(String password, Set<String> skip){
        Integer count = 0;
        for(int i = 0; i< NUMBERS_REVERSED.length()-MIN_SEQUENCE+1; i++){
            String sequence = NUMBERS_REVERSED.substring(i, i+MIN_SEQUENCE);
            if(skip.contains(sequence)) continue;
            for(int j=0; j<password.length(); j++){
                if(j+MIN_SEQUENCE>password.length()) break;
                if(password.substring(j, j+MIN_SEQUENCE).toLowerCase().equals(sequence)){
                    skip.add(sequence);
                    skip.add(new StringBuilder(sequence).reverse().toString());
                    count += 1;
                }
            }
        }
        return count;
    }
}
