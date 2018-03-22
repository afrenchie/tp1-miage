package com.acme.mailreader.domain;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class MailComparatorTest {
	
	private MailComparator comparator;

	@Before
	public void setUp() throws Exception {
		this.comparator = new MailComparator();
	}

	@Test
	public final void egauxSiDeuxMailsNuls() {
		Mail mail1 = null;
		Mail mail2 = null;
		assertThat(comparator.compare(mail1, mail2), is(0));
	}
	
	@Test
	public final void egauxSiUnDesMailsNuls() {
		Mail mail1 = new Mail();
		Mail mail2 = null;
		assertThat(comparator.compare(mail1, mail2), is(0));
	}
	
	//TODO
	//Autres tests unitaires

	@Test
	public final void statutDifferentsMails() {
		Mail mail1 = new Mail();
		Mail mail2 = new Mail();
		mail1.setStatut(Mail.Statut.UNSENT);
		mail2.setStatut(Mail.Statut.SENT);
		assertThat(comparator.compare(mail1, mail2), is(1));
	}
	
}
