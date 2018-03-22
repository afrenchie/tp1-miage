package com.acme.mailreader.domain;

import java.time.Instant;
import java.time.LocalDate;

import org.junit.Ignore;
import org.junit.Test;

import com.acme.mailreader.utils.DateIncorrecteException;

public class MailTest {
	
	@Test(expected=DateIncorrecteException.class)
	public final void erreurSiDateAvant1979() throws DateIncorrecteException {
		Mail m = new Mail();
		m.setDate(Instant.parse("1900-01-01T00:00:00.00Z"));
	}

}
