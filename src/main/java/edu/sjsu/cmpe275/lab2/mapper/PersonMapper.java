package edu.sjsu.cmpe275.lab2.mapper;

import edu.sjsu.cmpe275.lab2.model.Player;
import edu.sjsu.cmpe275.lab2.model.Sponsor;

public class PersonMapper {

	public static Player buildPlayer(PlayerRequest playerRequest,
			Sponsor sponsor) {
		Player player = new Player();
		player.setFirstname(playerRequest.getFirstname());
		player.setLastname(playerRequest.getLastname());
		player.setEmail(playerRequest.getEmail());
		if(playerRequest.getId() != null) {
			player.setId(playerRequest.getId());
		}
		if (playerRequest.getAddress() != null) {
			player.setStreet(playerRequest.getAddress());
		}
		if (playerRequest.getCity() != null) {
			player.setCity(playerRequest.getCity());
		}
		if (playerRequest.getDescription() != null) {
			player.setDescription(playerRequest.getDescription());
		}
		if (playerRequest.getState() != null) {
			player.setState(playerRequest.getState());
		}
		if (playerRequest.getZip() != null) {
			player.setZip(playerRequest.getZip());
		}
		if (sponsor != null) {
			player.setSponsor(sponsor);
		}
		
		return player;
	}

}
