package andre.passwordmeter.rules.deductions;

import andre.passwordmeter.rules.DeductionScorer;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Component
@Order(value = 6)
public class ConsecutiveNumbersScorer implements DeductionScorer {

    private Pattern pattern = Pattern.compile("[0-9]{2,}");

    @Override
    public Integer getScore(String password) {
        return -getCount(password)*2;
    }

    @Override
    public Integer getCount(String password) {
        Matcher m = pattern.matcher(password);
        Integer count = 0;
        while(m.find()){
            count += m.group().length()-1;
        }
        return count;
    }

    @Override
    public String name() {
        return "Consecutive Numbers";
    }

}
