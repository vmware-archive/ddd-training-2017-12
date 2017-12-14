package io.pivotal.ddd.matching.model.proposal;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;

/**
 * Created by azwickey on 12/13/17.
 */
public final class Progress {

    private enum Spec {SUBMITTED, PRICING_ACCEPTED, PRICING_REJECTED}
    private final Set<Spec> specs = new HashSet<>();

    public Progress() {
        this.specs.add(Spec.SUBMITTED);
    }

    private Progress(Set<Spec> specs) {
        this.specs.addAll(specs);
    }

    private void addSpec(Spec spec) {
        this.specs.add(spec);
    }

    public Progress moveToPriceAccepted() {
        Progress p = new Progress(this.specs);
        p.addSpec(Spec.PRICING_ACCEPTED);
        return p;
    }

    public Progress moveToPriceRejected() {
        Progress p = new Progress(this.specs);
        p.addSpec(Spec.PRICING_REJECTED);
        return p;
    }

    public boolean isPricingAccepted() {
        return specs.contains(Spec.PRICING_ACCEPTED);
    }

    public boolean isPricingRejected() {
        return specs.contains(Spec.PRICING_REJECTED);
    }

    public boolean isSubmitted() {
        return specs.contains(Spec.SUBMITTED);
    }
}
