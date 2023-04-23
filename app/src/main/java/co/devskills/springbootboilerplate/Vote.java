package co.devskills.springbootboilerplate;

import java.util.UUID;

public class Vote {
    private String key;
    private UUID clientId;
    private UUID pollId;

    public Vote(String key, UUID clientId, UUID pollId) {
        this.key = key;
        this.clientId = clientId;
        this.pollId = pollId;
    }

    public String getKey() {
        return key;
    }

    public String getClientId() {
        return clientId.toString();
    }

    public String getPollId() {
        return pollId.toString();
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setClientId(UUID clientId) {
        this.clientId = clientId;
    }

    public void setPollId(UUID pollId) {
        this.pollId = pollId;
    }

}
