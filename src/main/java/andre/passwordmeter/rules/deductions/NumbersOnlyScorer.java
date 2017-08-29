package andre.passwordmeter.rules.deductions;

import andre.passwordmeter.rules.DeductionScorer;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
@Order(value = 2)
public class NumbersOnlyScorer implements DeductionScorer {

    private Pattern pattern = Pattern.compile("^[0-9]*$");

    @Override
    public Integer getScore(String password) {
        return -getCount(password);
    }

    @Override
    public Integer getCount(String password) {
        Matcher m = pattern.matcher(password);
        if(m.find()){
            return m.group().length();
        }
        return 0;
    }

    @Override
    public String name() {
        return "Numbers Only";
    }

}
