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
		Mail mail1 = new Mail.Builder("Mail test").statut(Mail.Statut.UNSENT).build();
		Mail mail2 = new Mail.Builder("Mail test").statut(Mail.Statut.SENT).build();
		assertThat(comparator.compare(mail1, mail2), is(1));
	}
	
}
