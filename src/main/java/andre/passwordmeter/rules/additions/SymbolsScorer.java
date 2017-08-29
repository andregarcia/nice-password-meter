package andre.passwordmeter.rules.additions;


import andre.passwordmeter.rules.AdditionScorer;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Component
@Order(value = 5)
public class SymbolsScorer implements AdditionScorer {

    private Pattern pattern = Pattern.compile("[^0-9A-Za-z\\s]");

    @Override
    public Integer getScore(String password) {
        return getCount(password)*6;
    }

    @Override
    public Integer getCount(String password) {
        Matcher m = pattern.matcher(password);
        Integer symbolCount = 0;
        while(m.find()){
            symbolCount += m.group().length();
        }
        return symbolCount;
    }

    @Override
    public String name() {
        return "Symbols";
    }

}
