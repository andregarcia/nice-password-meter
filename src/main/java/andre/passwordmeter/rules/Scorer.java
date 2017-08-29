package andre.passwordmeter.rules;


public interface Scorer {

    Integer getScore(String password);

    Integer getCount(String password);

    String name();

}
