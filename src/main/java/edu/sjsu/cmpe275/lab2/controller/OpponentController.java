/*
 *  Controller file for Opponent.
 */
package edu.sjsu.cmpe275.lab2.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.sjsu.cmpe275.lab2.mapper.OpponentResponse;
import edu.sjsu.cmpe275.lab2.model.Player;
import edu.sjsu.cmpe275.lab2.services.OpponentService;
import edu.sjsu.cmpe275.lab2.services.PlayerService;

// TODO: Auto-generated Javadoc
/**
 * The Class OpponentController.
 */
@Controller
@RequestMapping("/opponent")
public class OpponentController {

	/** The player service. */
	@Autowired
	PlayerService playerService;

	/** The opponent service. */
	@Autowired
	OpponentService opponentService;

	/**
	 * Adds the opponent.
	 *
	 * @param player1Id the player 1 id
	 * @param player2Id the player 2 id
	 * @return the response entity
	 */
	@PutMapping(path = "/{player1}/{player2}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addOpponent(@PathVariable(value = "player1") String player1Id,
			@PathVariable(value = "player2") String player2Id) {

		ResponseEntity res = null;
		HttpStatus httpStatus = null;
		OpponentResponse opponentResponse = new OpponentResponse();
		System.out.println("Player 1 ID = " + player1Id);
		System.out.println("Player 2 ID = " + player2Id);
		Player playerOne = playerService.getPlayer(player1Id);
		Player playerTwo = playerService.getPlayer(player2Id);

		if (playerOne == null) {
			opponentResponse.setMsg("Player does not exist");
			httpStatus = HttpStatus.NOT_FOUND;
		} else if (playerTwo == null) {
			opponentResponse.setMsg("Opponent does not exist");
			httpStatus = HttpStatus.NOT_FOUND;
		}
		else if (playerOne.getOpponents().contains(playerTwo)) {
			opponentResponse.setMsg("Player " + player1Id + " already has " + player2Id + " as opponnet");
			httpStatus = HttpStatus.OK;
		} else {
			Player o = opponentService.addOpponent(playerOne, playerTwo);
			opponentResponse.setMsg("Successfully added opponent");

			// *** Added the HttpStatus
			httpStatus = HttpStatus.OK;
		}
		res = new ResponseEntity(opponentResponse, httpStatus);
		return res;
	}

	/**
	 * Delete opponent.
	 *
	 * @param playerId the player id
	 * @param opponentId the opponent id
	 * @return the response entity
	 */
	@DeleteMapping(path = "/{player1}/{player2}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deleteOpponent(@PathVariable(value = "player1") String playerId,
			@PathVariable(value = "player2") String opponentId) {

		ResponseEntity res = null;
		HttpStatus httpStatus = null;
		OpponentResponse opponentResponse = new OpponentResponse();
		System.out.println("Player 1 ID = " + playerId);
		System.out.println("Opponent ID = " + opponentId);

		Player player = playerService.getPlayer(playerId);
		Player opponent = playerService.getPlayer(opponentId);

		if (player == null) {
			opponentResponse.setMsg("Player does not exist");
			httpStatus = HttpStatus.NOT_FOUND;
		} else if (opponent == null) {
			opponentResponse.setMsg("Opponent does not exist");
			httpStatus = HttpStatus.NOT_FOUND;
		} else {
			Set<Player> playerOpponenstSet = player.getOpponents();
			Set<Player> opponentOpponenstSet = opponent.getOpponents();

			if (playerOpponenstSet == null) {
				opponentResponse.setMsg("Player " + playerId + " does not have any Opponents ");
				httpStatus = HttpStatus.NOT_FOUND;
			} else if (playerOpponenstSet.contains(opponent) && opponentOpponenstSet.contains(player)) {

				playerOpponenstSet.remove(opponent);
				player.setOpponents(playerOpponenstSet);
				playerService.updatePlayer(player);

				opponentOpponenstSet.remove(player);
				opponent.setOpponents(opponentOpponenstSet);
				playerService.updatePlayer(opponent);

				opponentResponse.setMsg("Successfully removed opponent");
				httpStatus = HttpStatus.OK;
			} else {
				opponentResponse.setMsg("Player " + playerId + " does not have " + opponentId + " as Opponent");
				httpStatus = HttpStatus.NOT_FOUND;
			}
		}

		res = new ResponseEntity(opponentResponse, httpStatus);
		return res;

	}

}
