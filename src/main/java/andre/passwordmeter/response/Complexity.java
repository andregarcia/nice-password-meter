package andre.passwordmeter.response;

/**
 * Created by andregarcia on 28/08/17.
 */
public enum Complexity {

    TOO_SHORT,      //0%
    VERY_WEAK,      //0-20
    WEAK,           //20-40
    GOOD,           //40-60
    STRONG,         //60-80
    VERY_STRONG;    //80-100

    public static Complexity getComplexity(Integer score){
        if(score<=0) return TOO_SHORT;
        if(score>0 && score<20) return VERY_WEAK;
        if(score>=20 && score<40) return WEAK;
        if(score>=40 && score<60) return GOOD;
        if(score>=60 && score<80) return STRONG;
        return VERY_STRONG;
    }

}
