package io.pivotal.ddd.matching.model.proposal;

import java.util.UUID;

/**
 * Created by azwickey on 12/13/17.
 */
public class ProposalId {

    private final String id;

    public ProposalId() {
        this.id = UUID.randomUUID().toString();
    }

    public String id() {
        return id;
    }
}
