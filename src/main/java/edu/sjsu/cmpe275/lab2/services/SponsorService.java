/*
 * 
 */
package edu.sjsu.cmpe275.lab2.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sjsu.cmpe275.lab2.dao.SponsorRepositry;
import edu.sjsu.cmpe275.lab2.model.Sponsor;

// TODO: Auto-generated Javadoc
/**
 * The Class SponsorService.
 */
@Service
@Transactional
public class SponsorService {

	/** The sponsor repositry. */
	@Autowired
	SponsorRepositry sponsorRepositry;

	/**
	 * Creates the sponsor.
	 *
	 * @param sponsor the sponsor
	 * @return the sponsor
	 */
	public Sponsor createSponsor(Sponsor sponsor) {
		Sponsor createdSponsor = sponsorRepositry.save(sponsor);
		return createdSponsor;
	}

	/**
	 * Gets the sponsor.
	 *
	 * @param sponsorId the sponsor id
	 * @return the sponsor
	 */
	public Sponsor getSponsor(String sponsorId) {
		Sponsor sponsor = sponsorRepositry.findOne(new Long(sponsorId));
		return sponsor;
	}

	/**
	 * Delete sponsor.
	 *
	 * @param sponsorId the sponsor id
	 */
	public void deleteSponsor(String sponsorId) {
		sponsorRepositry.delete(new Long(sponsorId));
	}

	/**
	 * Update sponsor.
	 *
	 * @param sponsor the sponsor
	 * @param sponsorRequest the sponsor request
	 * @return the sponsor
	 */
	public Sponsor updateSponsor(Sponsor sponsor, Sponsor sponsorRequest) {

		Sponsor updatedSponsor = null;
		sponsor.setName(sponsorRequest.getName());
		if (sponsorRequest.getStreet() != null) {
			sponsor.setStreet(sponsorRequest.getStreet());
		}
		if (sponsorRequest.getCity() != null) {
			sponsor.setCity(sponsorRequest.getCity());
		}
		if (sponsorRequest.getDescription() != null) {
			sponsor.setDescription(sponsorRequest.getDescription());
		}
		if (sponsorRequest.getState() != null) {
			sponsor.setState(sponsorRequest.getState());
		}
		if (sponsorRequest.getZip() != null) {
			sponsor.setZip(sponsorRequest.getZip());
		}

		updatedSponsor = sponsorRepositry.save(sponsor);
		return updatedSponsor;
	}

}
