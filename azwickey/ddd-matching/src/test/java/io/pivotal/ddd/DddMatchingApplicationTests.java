package io.pivotal.ddd;

import io.pivotal.ddd.matching.model.proposal.Client;
import io.pivotal.ddd.matching.model.proposal.Expectations;
import io.pivotal.ddd.matching.model.proposal.Progress;
import io.pivotal.ddd.matching.model.proposal.Proposal;
import org.assertj.core.util.Sets;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.NotNull;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DddMatchingApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void testProposalInit(){
		Proposal p = Proposal.submittedAs(new Client(), new Expectations());
		Assert.assertNotNull(p.id());
		Assert.assertTrue(p.progress().isSubmitted());
		Assert.assertFalse(p.progress().isPricingAccepted());
		Assert.assertFalse(p.progress().isPricingRejected());
	}

	@Test
	public void testProposalAccepted(){
		Proposal p = Proposal.submittedAs(new Client(), new Expectations());
		Assert.assertNotNull(p.id());
		p.acceptPrice();
		Assert.assertTrue(p.progress().isSubmitted());
		Assert.assertTrue(p.progress().isPricingAccepted());
		Assert.assertFalse(p.progress().isPricingRejected());
	}

	@Test
	public void testProposalRejected(){
		Proposal p = Proposal.submittedAs(new Client(), new Expectations());
		Assert.assertNotNull(p.id());
		p.rejectPrice();
		Assert.assertTrue(p.progress().isSubmitted());
		Assert.assertFalse(p.progress().isPricingAccepted());
		Assert.assertTrue(p.progress().isPricingRejected());
	}

}
