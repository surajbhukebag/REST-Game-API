package edu.sjsu.cmpe275.lab2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.sjsu.cmpe275.lab2.mapper.PersonMapper;
import edu.sjsu.cmpe275.lab2.mapper.PlayerRequest;
import edu.sjsu.cmpe275.lab2.mapper.PlayerResponse;
import edu.sjsu.cmpe275.lab2.model.Player;
import edu.sjsu.cmpe275.lab2.model.Sponsor;
import edu.sjsu.cmpe275.lab2.services.PlayerService;
import edu.sjsu.cmpe275.lab2.services.SponsorService;
import edu.sjsu.cmpe275.lab2.validators.GameApisValidator;

@Controller
@RequestMapping("/player")
public class PlayerController {

	@Autowired
	PlayerService playerService;

	@Autowired
	SponsorService sponsorService;

	// Create a Player

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createPlayer(@RequestBody PlayerRequest player) {

		PlayerResponse playerResponse = new PlayerResponse();
		boolean isValid = GameApisValidator.validateCreatePlayerRequest(player,
				playerResponse);

		ResponseEntity res = null;
		HttpStatus httpStatus = null;

		if (isValid) {
			Sponsor existingSponsor = null;
			if (player.getSponsor() != null) {
				existingSponsor = sponsorService.getSponsor(String
						.valueOf(player.getSponsor()));
				if (existingSponsor == null) {
					httpStatus = HttpStatus.NOT_FOUND;
					playerResponse.setMsg("Sponsor does not exist");
					res = new ResponseEntity(playerResponse, httpStatus);
					return res;
				}

			}
			Player newPerson = PersonMapper
					.buildPlayer(player, existingSponsor);
			Player savedPlayer = playerService.createPlayer(newPerson);
			playerResponse.setPlayer(savedPlayer);
			playerResponse.setMsg("Successfull created a new Player");
			httpStatus = HttpStatus.OK;
		} else {
			httpStatus = HttpStatus.BAD_REQUEST;
		}

		res = new ResponseEntity(playerResponse, httpStatus);

		return res;

	}

	// Get A Player

	@GetMapping(path = "/{playerId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getPlayer(
			@PathVariable(value = "playerId") String playerId) {

		PlayerResponse playerResponse = new PlayerResponse();
		ResponseEntity res = null;
		HttpStatus httpStatus = null;
		Player player = playerService.getPlayer(playerId);
		if (player != null) {
			playerResponse.setPlayer(player);
			playerResponse.setMsg("Successfully Retrieved Player Details.");
			httpStatus = HttpStatus.OK;
		} else {
			playerResponse.setMsg("Player does not exist");
			httpStatus = HttpStatus.NOT_FOUND;
		}

		res = new ResponseEntity(playerResponse, httpStatus);
		return res;
	}

	@DeleteMapping(path = "/{playerId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deletePlayer(
			@PathVariable(value = "playerId") String playerId) {

		PlayerResponse playerResponse = new PlayerResponse();
		ResponseEntity res = null;
		HttpStatus httpStatus = null;
		Player player = playerService.getPlayer(playerId);
		if (player != null) {
			playerService.deletePlayer(playerId);
			playerResponse.setMsg("Successfully Deleted Player.");
			httpStatus = HttpStatus.OK;
		} else {
			playerResponse.setMsg("Player does not exist");
			httpStatus = HttpStatus.NOT_FOUND;
		}

		res = new ResponseEntity(playerResponse, httpStatus);
		return res;
	}

	@PostMapping(path = "/{playerId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updatePlayer(
			@PathVariable(value = "playerId") String playerId,
			@RequestBody PlayerRequest player) {

		PlayerResponse playerResponse = new PlayerResponse();
		boolean isValid = GameApisValidator.validateCreatePlayerRequest(player,
				playerResponse);

		ResponseEntity res = null;
		HttpStatus httpStatus = null;
		Sponsor existingSponsor = null;

		if (isValid) {

			Player existingPlayer = playerService.getPlayer(String
					.valueOf(playerId));
			if (existingPlayer != null) {
				
				if (player.getSponsor() != null) {
					existingSponsor = sponsorService.getSponsor(String
							.valueOf(player.getSponsor()));
					if (existingSponsor == null) {
						httpStatus = HttpStatus.NOT_FOUND;
						playerResponse.setMsg("Sponsor does not exist");
						res = new ResponseEntity(playerResponse, httpStatus);
						return res;
					}

				}
				player.setId(Long.valueOf(playerId));
				Player newPlayer = PersonMapper.buildPlayer(player,
						existingSponsor);
				Player savedPlayer = playerService.updatePlayer(existingPlayer, newPlayer);
				playerResponse.setPlayer(savedPlayer);
				playerResponse.setMsg("Successfull Updated Player");
				httpStatus = HttpStatus.OK;

			} else {
				playerResponse.setMsg("Player does not exist");
				httpStatus = HttpStatus.NOT_FOUND;
			}

		} else {
			httpStatus = HttpStatus.BAD_REQUEST;
		}

		res = new ResponseEntity(playerResponse, httpStatus);

		return res;

	}

}
