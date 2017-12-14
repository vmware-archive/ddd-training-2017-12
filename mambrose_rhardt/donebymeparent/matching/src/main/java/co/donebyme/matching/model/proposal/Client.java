package co.donebyme.matching.model.proposal;

public class Client {
    ClientId id;

    private Client(ClientId id) {
        this.id = id;
    }

    public static Client of(ClientId id) {
        return new Client(id);
    }

}
