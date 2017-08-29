package andre.passwordmeter.rules.deductions;

import andre.passwordmeter.rules.DeductionScorer;
import org.assertj.core.util.Sets;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Component
@Order(value = 9)
public class SequentialSymbolsScorer implements DeductionScorer {

    private static final Pattern SYMBOLS = Pattern.compile("[^0-9\\sA-Za-z]{3,}");

    @Override
    public Integer getScore(String password) {
        return -getCount(password)*3;
    }

    @Override
    public Integer getCount(String password) {
        Matcher m = SYMBOLS.matcher(password);
        Set<Character> found = Sets.newHashSet();
        Integer count = 0;
        while(m.find()){
            String match = m.group();
            Set<Character> chars = Sets.newHashSet();
            for(Character c : match.toCharArray()){
                chars.add(c);
            }
            if(chars.size()>=3){
                count += chars.size()-2;
            }
            found.addAll(chars);
        }
        return count;
    }

    @Override
    public String name() {
        return "Sequential Symbols (3+)";
    }


}
