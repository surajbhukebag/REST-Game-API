package edu.sjsu.cmpe275.lab2.validators;

import edu.sjsu.cmpe275.lab2.mapper.PlayerRequest;
import edu.sjsu.cmpe275.lab2.mapper.PlayerResponse;
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
		} else if (sponsor.getName().equals("")) {
			sponsorResponse.setMsg("Name cannot be empty for Sponsor.");
			isValid = false;
		}
		return isValid;
	}

	// Validation Method for Player
	public static boolean validateCreatePlayerRequest(PlayerRequest player,
			PlayerResponse playerResponse) {
		boolean isValid = true;
		if (player == null) {
			playerResponse.setMsg("Invalid request.");
			isValid = false;
		} else if (player.getFirstname() == null) {
			playerResponse.setMsg("First Name cannot be empty for Player.");
			isValid = false;
		} else if (player.getFirstname().equals("")) {
			playerResponse.setMsg("First Name cannot be empty for Player.");
			isValid = false;
		} else if (player.getLastname() == null) {
			playerResponse.setMsg("Last Name cannot be empty for Player.");
			isValid = false;
		} else if (player.getLastname().equals("")) {
			playerResponse.setMsg("Last Name cannot be empty for Player.");
			isValid = false;
		} else if (player.getEmail() == null) {
			playerResponse.setMsg("Email cannot be empty for Player.");
			isValid = false;
		} else if (player.getEmail().equals("")) {
			playerResponse.setMsg("Email cannot be empty for Player.");
			isValid = false;
		}

		return isValid;
	}

}
