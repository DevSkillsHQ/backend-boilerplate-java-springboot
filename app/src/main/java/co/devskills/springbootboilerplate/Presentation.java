package co.devskills.springbootboilerplate;

import java.util.List;
import java.util.UUID;

public class Presentation {

    private UUID presentationId;
    private int current_poll_index;
    private List<Poll> polls;

    public Presentation(List<Poll> polls) {
        presentationId = UUID.randomUUID();
        this.polls = polls;
        this.current_poll_index = 0;
    }

    public int getCurrent_poll_index() {
        return current_poll_index;
    }

    public String getPresentationId(){
        return presentationId.toString();
    }

    public List<Poll> getPolls() {
        return polls;
    }

    public void setPolls(List<Poll> polls) {
        this.polls = polls;
    }

    public Poll getNextPoll() {
        current_poll_index++;

        if (current_poll_index < polls.size()) {
            return polls.get(current_poll_index);
        } else {
            return null;
        }
    }

    public Poll getCurrentPoll() {
        return polls.get(current_poll_index);
    }
}

