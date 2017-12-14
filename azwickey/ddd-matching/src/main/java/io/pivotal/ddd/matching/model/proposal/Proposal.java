package io.pivotal.ddd.matching.model.proposal;

/**
 * Created by azwickey on 12/13/17.
 */
public class Proposal {

    private ProposalId id;
    private Progress progress;
    private Client client;
    private Expectations expectations;

    private Proposal(Client c, Expectations e) {
        this.id = new ProposalId();
        this.client = c;
        this.expectations = e;
        this.progress = new Progress();
    }

    public ProposalId id() {
        return this.id;
    }

    public Progress progress() {
        return this.progress;
    }

    public static Proposal submittedAs(Client c, Expectations expectations){
        return new Proposal(c, expectations);
    }

    public void acceptPrice() {
        this.progress = this.progress.moveToPriceAccepted();
    }

    public void rejectPrice(){
        this.progress = this.progress.moveToPriceRejected();
    }

}
