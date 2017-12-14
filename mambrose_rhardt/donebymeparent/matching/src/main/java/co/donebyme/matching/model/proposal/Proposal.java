package co.donebyme.matching.model.proposal;

public class Proposal  {

    private ProposalId id;
    private Client client;
    private Expectations expectations;
    private Progress progress;

    public Proposal(ProposalId id, Client client, Expectations expectations, Progress progress) {
        this.id = id;
        this.client = client;
        this.expectations = expectations;
        this.progress = progress;
    }

    public static Proposal submittedAs(Client c, Expectations e) {
        return new Proposal(new ProposalId(), c, e, Progress.NONE.pricingSubmitted());
    }

    public boolean isComplete() {
        return progress.isComplete();
    }

    public boolean isSubmitted(){
        return progress.isSubmitted();
    }

    public boolean isSuccessful() {
        return progress.isSuccessful();
    }

    public boolean isFailed() {
        return progress.isFailed();
    }

    public boolean isPricingAccepted(){
        return progress.isPriceAccepted();
    }

    public Proposal acceptPrice() {
        return new Proposal(this.id, this.client, this.expectations, progress.pricingAccepted());
    }

    public Proposal rejectPrice() {
        return new Proposal(this.id, this.client, this.expectations, progress.pricingRejected());
    }


}
