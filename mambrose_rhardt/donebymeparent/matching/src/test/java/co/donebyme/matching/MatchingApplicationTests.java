package co.donebyme.matching;

import static org.junit.Assert.*;

import co.donebyme.matching.model.proposal.Client;
import co.donebyme.matching.model.proposal.ClientId;
import co.donebyme.matching.model.proposal.Expectations;
import co.donebyme.matching.model.proposal.Proposal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MatchingApplicationTests {

	//@Test
	public void contextLoads() {
	}

	private Client client() {
		return Client.of(new ClientId());
	}

	private Expectations expectations() {
		return Expectations.of("expectations summary",
									"expectations description",
									99.95, Calendar.getInstance());
	}

	private Proposal proposal() {
		return Proposal.submittedAs(client(), expectations());
	}

	@Test
	public void proposalSubmits() {
		Proposal proposal = proposal();
		assertTrue(proposal.isSubmitted());
		assertFalse(proposal.isComplete());
		assertFalse(proposal.isFailed());
		assertFalse(proposal.isSuccessful());
	}

	@Test
	public void proposalPriceAccepted() {
		Proposal proposal = proposal().acceptPrice();
		assertFalse(proposal.isSuccessful());
		assertFalse(proposal.isFailed());
		assertTrue(proposal.isSubmitted());
		assertFalse(proposal.isComplete());
		assertTrue(proposal.isPricingAccepted());
	}

	@Test
	public void proposalPriceRejected(){
		Proposal proposal = proposal().rejectPrice();
		assertTrue(proposal.isFailed());
		assertTrue(proposal.isComplete());
		assertTrue(proposal.isSubmitted());
		assertFalse(proposal.isSuccessful());
	}



}
