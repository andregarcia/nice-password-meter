package andre.passwordmeter.rules.additions;


import andre.passwordmeter.rules.AdditionScorer;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
@Order(value = 7)
public class RequirementsScorer implements AdditionScorer {

    private Pattern symbolsPattern = Pattern.compile("[^0-9A-Za-z\\s]");

    @Override
    public Integer getScore(String password) {
        int count = getCount(password);
        if(count<=3) return 0;
        return getCount(password)*2;
    }

    @Override
    public Integer getCount(String password) {
        Integer count = 0;
        count += containsAtLeastEightChars(password) ? 1 : 0;
        count += containsUppercase(password) ? 1 : 0;
        count += containsLowercase(password) ? 1 : 0;
        count += containsNumbers(password) ? 1 : 0;
        count += containsSymbols(password) ? 1 : 0;
        return count;
    }

    @Override
    public String name() {
        return "Requirements";
    }

    private boolean containsAtLeastEightChars(String password){
        return password.length()>=8;
    }

    private boolean containsUppercase(String password){
        for(Character c : password.toCharArray()){
            if(c>='A' && c<='Z'){
                return true;
            }
        }
        return false;
    }

    private boolean containsLowercase(String password){
        for(Character c : password.toCharArray()){
            if(c>='a' && c<='z'){
                return true;
            }
        }
        return false;
    }

    private boolean containsNumbers(String password){
        for(Character c : password.toCharArray()){
            if(c>='0' && c<='9'){
                return true;
            }
        }
        return false;
    }

    private boolean containsSymbols(String password){
        Matcher m = symbolsPattern.matcher(password);
        return m.find();
    }
}
