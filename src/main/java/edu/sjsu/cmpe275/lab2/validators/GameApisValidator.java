/*
 * 
 */
package edu.sjsu.cmpe275.lab2.validators;

import edu.sjsu.cmpe275.lab2.mapper.PlayerRequest;
import edu.sjsu.cmpe275.lab2.mapper.PlayerResponse;
import edu.sjsu.cmpe275.lab2.mapper.SponsorResponse;
import edu.sjsu.cmpe275.lab2.model.Sponsor;

// TODO: Auto-generated Javadoc
/**
 * The Class GameApisValidator.
 */
public class GameApisValidator {

	/**
	 * Validate create sponsor request.
	 *
	 * @param sponsor the sponsor
	 * @param sponsorResponse the sponsor response
	 * @return true, if successful
	 */
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

	/**
	 * Validate create player request.
	 *
	 * @param player the player
	 * @param playerResponse the player response
	 * @return true, if successful
	 */
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
