package com.acme.mailreader.domain;

import java.time.Instant;
import java.time.LocalDate;

import org.junit.Ignore;
import org.junit.Test;

import com.acme.mailreader.utils.DateIncorrecteException;
import com.acme.mailreader.utils.MailInvalideException;

public class MailTest {
	
	@Test(expected=DateIncorrecteException.class)
	public final void erreurSiDateAvant1979() throws DateIncorrecteException {
		Mail mail = new Mail.Builder("Mail test").date(Instant.parse("1900-01-01T00:00:00.00Z")).build();
	}
	
	@Test(expected=DateIncorrecteException.class)
	public final void erreurSiDateApres2100() throws DateIncorrecteException {
		Mail mail = new Mail.Builder("Mail test").date(Instant.parse("2200-01-01T00:00:00.00Z")).build();
	}
	
}
