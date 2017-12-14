package co.donebyme.matching.model.proposal;


import co.vaughnvernon.mockroservices.fn.Tuple2;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class Progress {
    public enum Spec {
        PRICING, SCHEDULING
    }

    private enum Status {
        SUBMITTED, ACCEPTED, REJECTED;
    }

    private final Set<Tuple2<Spec, Status>> specs = new HashSet<>();


    private Progress(Set<Tuple2<Spec, Status>> cSpecs) {
        this.specs.addAll(cSpecs);
    }

    private Progress with(Spec s, Status st) {
        Set<Tuple2<Spec, Status>> newSpecs = new HashSet<>();
        newSpecs.addAll(this.specs);
        newSpecs.add(Tuple2.from(s, st));
        return new Progress(newSpecs);
    }

    public Progress pricingAccepted() {
        return with(Spec.PRICING, Status.ACCEPTED);
    }

    public Progress pricingRejected() {
        return with(Spec.PRICING, Status.REJECTED);
    }

    public Progress pricingSubmitted() {return with(Spec.PRICING, Status.SUBMITTED);}

    public static Progress NONE = new Progress(new HashSet<>());

    public boolean isComplete() {
        return isSuccessful() || isFailed();
    }

    public boolean isSuccessful() {
        for (Tuple2<Spec, Status> sTup : specs) {
            if (sTup._1 == Spec.SCHEDULING && sTup._2 == Status.ACCEPTED) {
                return true;
            }
        }
        return false;
    }

    public boolean isFailed() {
        for (Tuple2<Spec, Status> sTup : specs) {
            if (sTup._2 == Status.REJECTED)  {
                return true;
            }
        }
        return false;
    }

    public boolean isSubmitted(){
        for (Tuple2<Spec, Status> sTup : specs){
            if ((sTup._2 == Status.SUBMITTED)) {
                return true;
            }
        }
        return false;
    }

    public boolean isPriceAccepted(){
        for (Tuple2<Spec, Status> sTup : specs){
            if ((sTup._1 == Spec.PRICING && sTup._2 == Status.ACCEPTED)) {
                return true;
            }
        }
        return false;
    }


}
