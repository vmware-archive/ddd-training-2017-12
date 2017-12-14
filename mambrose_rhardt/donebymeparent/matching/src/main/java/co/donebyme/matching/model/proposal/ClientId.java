package co.donebyme.matching.model.proposal;

import java.util.UUID;

public class ClientId {
    private String id;
    public ClientId() {
        this.id = UUID.randomUUID().toString();
    }
}
