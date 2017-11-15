package edu.sjsu.cmpe275.lab2.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sjsu.cmpe275.lab2.dao.SponsorRepositry;
import edu.sjsu.cmpe275.lab2.model.Sponsor;

@Service
@Transactional
public class SponsorService {

	@Autowired
	SponsorRepositry sponsorRepositry;

	public Sponsor createSponsor(Sponsor sponsor) {
		Sponsor createdSponsor = sponsorRepositry.save(sponsor);
		return createdSponsor;
	}

	public Sponsor getSponsor(String sponsorId) {
		Sponsor sponsor = sponsorRepositry.findOne(new Long(sponsorId));
		return sponsor;
	}

	public void deleteSponsor(String sponsorId) {
		sponsorRepositry.delete(new Long(sponsorId));
	}

	public Sponsor updateSponsor(Sponsor sponsor, Sponsor sponsorRequest) {

		Sponsor updatedSponsor = null;
		sponsor.setName(sponsorRequest.getName());
		if (sponsorRequest.getAddress() != null) {
			sponsor.setAddress(sponsorRequest.getAddress());
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
