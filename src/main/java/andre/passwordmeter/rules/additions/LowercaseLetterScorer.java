package andre.passwordmeter.rules.additions;


import andre.passwordmeter.rules.AdditionScorer;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value = 3)
public class LowercaseLetterScorer implements AdditionScorer {

    public Integer getScore(String password) {
        return (password.length()-getCount(password))*2;
    }

    public Integer getCount(String password) {
        int lowercaseCount = 0;
        for(Character c : password.toCharArray()){
            if(c>='a' && c<='z'){
                lowercaseCount += 1;
            }
        }
        return lowercaseCount;
    }

    @Override
    public String name() {
        return "Lowercase Letters";
    }


}
