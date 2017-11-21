package edu.sjsu.cmpe275.lab2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.sjsu.cmpe275.lab2.mapper.OpponentResponse;
import edu.sjsu.cmpe275.lab2.model.Player;
import edu.sjsu.cmpe275.lab2.services.OpponentService;
import edu.sjsu.cmpe275.lab2.services.PlayerService;

@Controller
@RequestMapping("/opponent")
public class OpponentController {
	
	@Autowired
	PlayerService playerService;
	
	@Autowired
	OpponentService opponentService;
	
	
	@PostMapping(path = "/{player1}/{player2}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addOpponent(@PathVariable(value = "player1") String player1Id, @PathVariable(value = "player2") String player2Id) {
		
		ResponseEntity res = null;
		HttpStatus httpStatus = null;
		OpponentResponse opponentResponse = new OpponentResponse();
		System.out.println("Player 1 ID = " + player1Id);
		System.out.println("Player 2 ID = " + player2Id);
		Player playerOne = playerService.getPlayer(player1Id);
		Player playerTwo = playerService.getPlayer(player2Id);
		if(playerOne == null || playerTwo == null) {
			opponentResponse.setMsg("Player do not exist");
			httpStatus= HttpStatus.NOT_FOUND;
		}
		else {
			Player o = opponentService.addOpponent(playerOne, playerTwo);
			opponentResponse.setMsg("Successfully added opponent");
			
			// *** Added the HttpStatus
			httpStatus= HttpStatus.OK;
		}
		
		res = new ResponseEntity(opponentResponse, httpStatus);
		return res;
		
	}

}
