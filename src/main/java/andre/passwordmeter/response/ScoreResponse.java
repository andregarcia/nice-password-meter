package andre.passwordmeter.response;


public class ScoreResponse {

    private String password;

    private Integer score;

    private Complexity complexity;

    private AdditionsResponseDescription additions;

    private DeductionResponseDescription deductions;

    public ScoreResponse(){
        this.additions = new AdditionsResponseDescription();
        this.deductions = new DeductionResponseDescription();
        this.score = 0;
    }

    public ScoreResponse(Integer score, Complexity complexity) {
        this.score = score;
        this.complexity = complexity;
        this.additions = new AdditionsResponseDescription();
        this.deductions = new DeductionResponseDescription();
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public void addScore(Integer increment){
        this.score += increment;
    }

    public Complexity getComplexity() {
        return complexity;
    }

    public void setComplexity(Complexity complexity) {
        this.complexity = complexity;
    }

    public AdditionsResponseDescription getAdditionsResponseDescription() {
        return additions;
    }

    public void addAdditionsResponseDescriptionEntry(ScoreResponseDesctiptionEntry additionsResponseDescription){
        this.additions.addScoreResponseDesctiptionEntry(additionsResponseDescription);
    }

    public DeductionResponseDescription getDeductionResponseDescription() {
        return deductions;
    }

    public void addDeductionResponseDescriptionEntry(ScoreResponseDesctiptionEntry deductionResponseDescription){
        this.deductions.addScoreResponseDesctiptionEntry(deductionResponseDescription);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
