package co.devskills.springbootboilerplate;
import java.util.List;
import java.util.UUID;

public class Poll {
    private UUID pollId;
    private String question;
    private List<Option> options;

    public Poll(String question, List<Option> options) {
        this.pollId = UUID.randomUUID();
        this.question = question;
        this.options = options;
    }

    public String getPollId() {
        return pollId.toString();
    }

    public String getQuestion() {
        return question;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }
}