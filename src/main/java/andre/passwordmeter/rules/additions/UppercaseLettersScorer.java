package andre.passwordmeter.rules.additions;

import andre.passwordmeter.rules.AdditionScorer;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Order(value = 2)
public class UppercaseLettersScorer implements AdditionScorer {

    public Integer getScore(String password) {
        int count = getCount(password);
        if(count==0) return 0;
        return (password.length()-count)*2;
    }

    @Override
    public Integer getCount(String password) {
        int uppercaseCount = 0;
        for(Character c : password.toCharArray()){
            if(c>='A' && c<='Z'){
                uppercaseCount += 1;
            }
        }
        return uppercaseCount;
    }

    @Override
    public String name() {
        return "Uppercase Letters";
    }


}
