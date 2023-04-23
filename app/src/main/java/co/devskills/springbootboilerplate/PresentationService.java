package co.devskills.springbootboilerplate;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PresentationService {

    public Poll getNextPoll(Presentation presentation) {
        return presentation.getNextPoll();
    }

    public Poll getCurrentPoll(Presentation presentation) {
        return presentation.getCurrentPoll();
    }

    public boolean submitVoteForCurrentPoll(Presentation presentation, String key, String clientId, String pollId) {
        return true;
    }

    public List<Vote> getAllVotesForPoll(Presentation presentation, Poll poll) {
        return null;
    }
}
