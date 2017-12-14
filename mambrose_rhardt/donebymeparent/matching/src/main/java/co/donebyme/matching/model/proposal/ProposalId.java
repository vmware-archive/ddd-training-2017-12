package co.donebyme.matching.model.proposal;

import java.util.UUID;

public class ProposalId {
    private String id;
    public ProposalId() {
        this.id = UUID.randomUUID().toString();
    }
}
