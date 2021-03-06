package com.acme.mailreader.utils;

import java.util.Comparator;

import com.acme.mailreader.model.Mail;

/**
 * Comparateur de mails
 * 
 * Comme on désire afficher les mails les plus importants en premier, l'element le plus grand retourne une valeur négative
 *
 */

public class MailComparator implements Comparator<Mail> {

	public static final int EGAUX = 0;
	public static final int PREMIER_PLUS_PETIT = 1;
	public static final int PREMIER_PLUS_GRAND = -1;

	public int compare(Mail mail1, Mail mail2) {
		if (unDesMailsNul(mail1, mail2)) {
			return EGAUX;
		}
		if (importanceDifferentsMails(mail1, mail2)) {
			return trierParImportance(mail1, mail2);
		}
		if (statutDifferentsMails(mail1, mail2)) {
			return trierParStatut(mail1, mail2);
		}
		if (sujetsDifferentsMails(mail1, mail2)) {
			return trierParSujet(mail1, mail2);
		}
		return mail1.getDate().compareTo(mail2.getDate());
	}

	private int trierParImportance(Mail mail1, Mail mail2) {
		if (mail1.isImportant() && !mail2.isImportant()) {
			return PREMIER_PLUS_GRAND;
		} else {
			return PREMIER_PLUS_PETIT;
		}
	}

	private int trierParStatut(Mail mail1, Mail mail2) {
		int comp = mail1.getStatut().ordinal() - mail2.getStatut().ordinal();
		return comp < 0 ? PREMIER_PLUS_PETIT : PREMIER_PLUS_GRAND;
	}

	private int trierParSujet(Mail mail1, Mail mail2) {
		if (mail1.getSujet() == null && mail2.getSujet() != null) {
			return PREMIER_PLUS_PETIT;
		}
		else if (mail1.getSujet() != null && mail2.getSujet() == null) {
			return PREMIER_PLUS_GRAND;
		}
		return mail1.getSujet().compareTo(mail2.getSujet());
	}

	private boolean unDesMailsNul(Mail mail1, Mail mail2) {
		return mail1 == null || mail2 == null;
	}

	private boolean importanceDifferentsMails(Mail mail1, Mail mail2) {
		return mail1.isImportant() != mail2.isImportant();
	}

	private boolean statutDifferentsMails(Mail mail1, Mail mail2) {
		return mail1.getStatut() != mail2.getStatut();
	}

	private boolean sujetsDifferentsMails(Mail mail1, Mail mail2) {
		if (mail1.getSujet() == null || mail2.getSujet() == null) {
			return true;
		}
		return !mail1.getSujet().equals(mail2.getSujet());
	}
}
