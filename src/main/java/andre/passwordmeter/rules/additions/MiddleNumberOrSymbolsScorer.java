package andre.passwordmeter.rules.additions;


import andre.passwordmeter.rules.AdditionScorer;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
@Order(value = 6)
public class MiddleNumberOrSymbolsScorer implements AdditionScorer {

    private Pattern pattern = Pattern.compile("[^A-Za-z\\s]");

    @Override
    public Integer getScore(String password) {
        return getCount(password)*2;
    }

    @Override
    public Integer getCount(String password) {
        Integer count = 0;
        Matcher m = pattern.matcher(password.substring(1, password.length()-1));
        while(m.find()){
            count += m.group().length();
        }
        return count;
    }

    @Override
    public String name() {
        return "Middle Numbers or Symbols";
    }


}
