/*
 * 
 */
package edu.sjsu.cmpe275.lab2.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sjsu.cmpe275.lab2.dao.PlayerRespository;
import edu.sjsu.cmpe275.lab2.model.Player;
import edu.sjsu.cmpe275.lab2.model.Sponsor;

// TODO: Auto-generated Javadoc
/**
 * The Class PlayerService.
 */
@Service
@Transactional
public class PlayerService {

	/** The player repositry. */
	@Autowired
	PlayerRespository playerRepositry;

	/**
	 * Creates the player.
	 *
	 * @param player the player
	 * @return the player
	 */
	public Player createPlayer(Player player) {
		Player createdPlayer = playerRepositry.save(player);
		return createdPlayer;
	}

	/**
	 * Gets the player.
	 *
	 * @param playerId the player id
	 * @return the player
	 */
	public Player getPlayer(String playerId) {
		Player player = playerRepositry.findOne(new Long(playerId));
		return player;
	}

	/**
	 * Delete player.
	 *
	 * @param player the player
	 */
	public void deletePlayer(Player player) {

		playerRepositry.delete(player);

	}

	/**
	 * Update player.
	 *
	 * @param player the player
	 * @param playerRequest the player request
	 * @return the player
	 */
	public Player updatePlayer(Player player, Player playerRequest) {

		Player updatePlayer = null;

		player.setFirstname(playerRequest.getFirstname());
		player.setLastname(playerRequest.getLastname());
		player.setEmail(playerRequest.getEmail());

		if (playerRequest.getStreet() != null) {
			player.setStreet(playerRequest.getStreet());
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
		if (playerRequest.getSponsor() != null) {
			player.setSponsor(playerRequest.getSponsor());
		}
		if (player.getOpponents() != null) {
			playerRequest.setOpponents(player.getOpponents());
		}
		updatePlayer = playerRepositry.save(playerRequest);
		return updatePlayer;
	}

	/**
	 * Gets the player by sponsor.
	 *
	 * @param sponsor the sponsor
	 * @return the player by sponsor
	 */
	public List<Player> getPlayerBySponsor(Sponsor sponsor) {
		return playerRepositry.findPlayersBySponsor(sponsor.getId());
	}

	/**
	 * Update player.
	 *
	 * @param player the player
	 */
	public void updatePlayer(Player player) {
		playerRepositry.save(player);
	}

	/**
	 * Find player by email.
	 *
	 * @param email the email
	 * @return the player
	 */
	public Player findPlayerByEmail(String email) {
		return playerRepositry.findPlayerByEmail(email);
	}
}
