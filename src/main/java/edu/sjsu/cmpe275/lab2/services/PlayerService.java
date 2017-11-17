package edu.sjsu.cmpe275.lab2.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sjsu.cmpe275.lab2.dao.PlayerRespository;
import edu.sjsu.cmpe275.lab2.model.Player;

@Service
@Transactional
public class PlayerService {

	@Autowired
	PlayerRespository playerRepositry;

	public Player createPlayer(Player player) {
		Player createdPlayer = playerRepositry.save(player);
		return createdPlayer;
	}

	public Player getPlayer(String playerId) {
		Player player = playerRepositry.findOne(new Long(playerId));
		return player;
	}

	public void deletePlayer(String playerId) {
		playerRepositry.delete(new Long(playerId));
	}

	public Player updatePlayer(Player player, Player playerRequest) {

		Player updatePlayer = null;

		player.setFirstname(playerRequest.getFirstname());
		player.setLastname(playerRequest.getLastname());

		if (playerRequest.getAddress() != null) {
			player.setAddress(playerRequest.getAddress());
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

		updatePlayer = playerRepositry.save(player);
		return updatePlayer;
	}

}
