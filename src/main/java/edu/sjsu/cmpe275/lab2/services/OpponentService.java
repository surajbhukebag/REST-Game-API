/*
 * 
 */
package edu.sjsu.cmpe275.lab2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sjsu.cmpe275.lab2.dao.PlayerRespository;
import edu.sjsu.cmpe275.lab2.model.Player;

// TODO: Auto-generated Javadoc
/**
 * The Class OpponentService.
 */
@Service
public class OpponentService {
	
	
	/** The player respository. */
	@Autowired
	private PlayerRespository playerRespository;
	
	/**
	 * Adds the opponent.
	 *
	 * @param player the player
	 * @param opponent the opponent
	 * @return the player
	 */
	public Player addOpponent(Player player, Player opponent) {
		

		player.getOpponents().add(opponent);		
		opponent.getOpponents().add(player);
		Player p = playerRespository.save(player);
		 playerRespository.save(opponent);

		
		return p;
	}

}
