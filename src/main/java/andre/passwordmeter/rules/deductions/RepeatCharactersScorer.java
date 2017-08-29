package andre.passwordmeter.rules.deductions;

import andre.passwordmeter.rules.DeductionScorer;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value = 3)
public class RepeatCharactersScorer implements DeductionScorer {


    @Override
    public Integer getScore(String password) {
        Double score = 0d;
        int nRepeatedChar = 0;
        int nUniqueChar = 0;
        for(int a=0; a<password.length(); a++){

            boolean charRepeated = false;
            for(int b=0; b<password.length(); b++){
                if(a==b) continue;
                if(password.charAt(a)==password.charAt(b)){
                    charRepeated = true;
                    score += Math.abs(password.length()/((float)b-a));
                }
            }
            if(charRepeated){
                nRepeatedChar += 1;
                nUniqueChar = password.length() - nRepeatedChar;
                score = nUniqueChar > 0 ? Math.ceil(score/nUniqueChar) : Math.ceil(score);
            }

        }
        return -score.intValue();
    }

    @Override
    public Integer getCount(String password) {
        Integer count = 0;
        for(int a=0; a<password.length(); a++){
            boolean charRepeated =false;
            for(int b=0; b<password.length(); b++){
                if(a==b) continue;
                if(password.charAt(a)==password.charAt(b)){
                    charRepeated = true;
                }
            }
            if(charRepeated){
                count += 1;
            }
        }
        return count;
    }

    @Override
    public String name() {
        return "Repeat Characters";
    }


}
