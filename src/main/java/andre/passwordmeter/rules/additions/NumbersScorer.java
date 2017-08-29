package andre.passwordmeter.rules.additions;


import andre.passwordmeter.rules.AdditionScorer;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value = 4)
public class NumbersScorer implements AdditionScorer {

    @Override
    public Integer getScore(String password) {
        return getCount(password)*4;
    }

    @Override
    public Integer getCount(String password) {
        int numberCount = 0;
        for(Character c : password.toCharArray()){
            if(c>='0' && c<='9'){
                numberCount += 1;
            }
        }
        return numberCount;
    }

    @Override
    public String name() {
        return "Numbers";
    }

}
