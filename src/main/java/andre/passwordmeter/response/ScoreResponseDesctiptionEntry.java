package andre.passwordmeter.response;


import java.text.Normalizer;
import java.util.Locale;
import java.util.regex.Pattern;

public class ScoreResponseDesctiptionEntry {

    private static final Pattern NONLATIN = Pattern.compile("[^\\w-]");
    private static final Pattern WHITESPACE = Pattern.compile("[\\s]");

    private String text;

    private Integer count;

    private Integer bonus;

    private String id;

    public ScoreResponseDesctiptionEntry(String text, Integer count, Integer bonus) {
        this.text = text;
        this.count = count;
        this.bonus = bonus;
        this.id = textToId(text);
    }

    public String getText() {
        return text;
    }

    public Integer getCount() {
        return count;
    }

    public Integer getBonus() {
        return bonus;
    }

    public String getId() {
        return id;
    }

    private static String textToId(String text){
        String nowhitespace = WHITESPACE.matcher(text).replaceAll("-");
        String normalized = Normalizer.normalize(nowhitespace, Normalizer.Form.NFD);
        String slug = NONLATIN.matcher(normalized).replaceAll("");
        return slug.toLowerCase(Locale.ENGLISH);
    }
}
