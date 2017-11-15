package edu.sjsu.cmpe275.lab2.validators;

import edu.sjsu.cmpe275.lab2.mapper.SponsorResponse;
import edu.sjsu.cmpe275.lab2.model.Sponsor;

public class GameApisValidator {

	public static boolean validateCreateSponsorRequest(Sponsor sponsor,
			SponsorResponse sponsorResponse) {
		boolean isValid = true;
		if (sponsor == null) {
			sponsorResponse.setMsg("Invalid request.");
			isValid = false;
		} else if (sponsor.getName() == null) {
			sponsorResponse.setMsg("Name cannot be empty for Sponsor.");
			isValid = false;
		}

		return isValid;
	}

}
