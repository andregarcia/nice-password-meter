package andre.passwordmeter.rules.additions;

import andre.passwordmeter.rules.AdditionScorer;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value = 1)
public class NumberOfCharactersScorer implements AdditionScorer {


    public Integer getScore(String password) {
        return getCount(password)*4;
    }


    public Integer getCount(String password) {
        return password.length();
    }

    @Override
    public String name() {
        return "Number of Characters";
    }


}
