package co.devskills.springbootboilerplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PresentationController {

    // Presentation service to handle business logic
    @Autowired
    private PresentationService presentationService;

    // POST /presentations
    @PostMapping("/presentations")
    public ResponseEntity<Object> createPresentation(@PathVariable List<Poll> polls) {
        // Implementation for creating a new presentation
        Presentation presentation = new Presentation(polls);
        return ResponseEntity.status(HttpStatus.CREATED).body(presentation.getPresentationId());
    }

    // PUT /presentations/ABC/polls/current
    @PutMapping("/presentations/{presentation_id}/polls/current")
    public ResponseEntity<?> displayNextPoll(@PathVariable("presentation_id") Presentation presentation) {
        // Call presentation service to get the next poll
        Poll nextPoll = presentationService.getNextPoll(presentation);

        if (nextPoll == null) {
            // If poll is null, return 404 response indicating presentation finished
            return ResponseEntity.notFound().build();
        }

        // Create the response object with poll details
        Map<String, Object> response = new HashMap<>();
        response.put("poll_id", nextPoll.getPollId());
        response.put("question", nextPoll.getQuestion());
        response.put("options", nextPoll.getOptions());

        return ResponseEntity.ok(response);
    }

    // GET /presentations/ABC/polls/current
    @GetMapping("/presentations/{presentation_id}/polls/current")
    public ResponseEntity<?> getCurrentPoll(@PathVariable("presentation_id") Presentation presentation) {
        // Call presentation service to get the current poll
        Poll currentPoll = presentationService.getCurrentPoll(presentation);

        if (currentPoll == null) {
            // if no polls shown currently, return 409
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        // Create the response object with poll details
        Map<String, Object> response = new HashMap<>();
        response.put("poll_id", currentPoll.getPollId());
        response.put("question", currentPoll.getQuestion());
        response.put("options", currentPoll.getOptions());

        return ResponseEntity.ok(response);
    }

    /*
    // POST endpoint for accepting votes for the current poll
    @PostMapping("/{presentationId}/polls/current/votes")
    public ResponseEntity<?> submitVoteForCurrentPoll(@RequestBody Presentation presentation, @RequestBody Vote vote) {
        String key = vote.getKey();
        String clientId = vote.getClientId();
        String pollId = vote.getPollId();

        boolean voteAligned = presentationService.submitVoteForCurrentPoll(presentation, key, clientId, pollId);

        if (voteAligned) {
            // if vote is aligned, return 204
            return ResponseEntity.noContent().build();
        } else {
            // if vote is not aligned, return 409
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    // GET endpoint for fetching all votes for a specific poll
    @GetMapping("/{presentationId}/polls/{pollId}/votes")
    public ResponseEntity<List<Vote>> getAllVotesForPoll(@RequestBody Presentation presentation, @RequestBody Poll poll) {
        List<Vote> votes = presentationService.getAllVotesForPoll(presentation, poll);
        return ResponseEntity.ok(votes);
    }
     */
}

