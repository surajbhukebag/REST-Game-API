package edu.sjsu.cmpe275.lab2.controller;

import java.util.List;

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

import edu.sjsu.cmpe275.lab2.mapper.SponsorResponse;
import edu.sjsu.cmpe275.lab2.model.Player;
import edu.sjsu.cmpe275.lab2.model.Sponsor;
import edu.sjsu.cmpe275.lab2.services.PlayerService;
import edu.sjsu.cmpe275.lab2.services.SponsorService;
import edu.sjsu.cmpe275.lab2.validators.GameApisValidator;

@Controller
@RequestMapping(path = "/sponsor")
public class SponsorController {

	@Autowired
	SponsorService sponsorService;

	@Autowired
	PlayerService playerService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addNewSponsor(@RequestBody Sponsor sponsor) {

		SponsorResponse sponsorResponse = new SponsorResponse();
		boolean isValid = GameApisValidator.validateCreateSponsorRequest(
				sponsor, sponsorResponse);
		ResponseEntity res = null;
		HttpStatus httpStatus = null;

		if (isValid) {
			Sponsor savedSponsor = sponsorService.createSponsor(sponsor);
			sponsorResponse.setSponsor(savedSponsor);
			sponsorResponse.setMsg("Successfull created a new Sponsor");
			httpStatus = HttpStatus.OK;
		} else {
			httpStatus = HttpStatus.BAD_REQUEST;
		}

		res = new ResponseEntity(sponsorResponse, httpStatus);

		return res;
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAllSponsors() {

		ResponseEntity res = null;
		HttpStatus httpStatus = null;

		return res;

	}

	@GetMapping(path = "/{sponsorId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getSponsor(
			@PathVariable(value = "sponsorId") String sponsorId) {

		SponsorResponse sponsorResponse = new SponsorResponse();
		ResponseEntity res = null;
		HttpStatus httpStatus = null;
		Sponsor sponsor = sponsorService.getSponsor(sponsorId);
		if (sponsor != null) {
			sponsorResponse.setSponsor(sponsor);
			sponsorResponse.setMsg("Successfully Retrieved Sponsor Details.");
			httpStatus = HttpStatus.OK;
		} else {
			sponsorResponse.setMsg("Sponsor does not exist");
			httpStatus = HttpStatus.NOT_FOUND;
		}

		res = new ResponseEntity(sponsorResponse, httpStatus);
		return res;
	}

	@DeleteMapping(path = "/{sponsorId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deleteSponsor(
			@PathVariable(value = "sponsorId") String sponsorId) {

		SponsorResponse sponsorResponse = new SponsorResponse();
		ResponseEntity res = null;
		HttpStatus httpStatus = null;
		Sponsor sponsor = sponsorService.getSponsor(sponsorId);
		if (sponsor != null) {
			List<Player> players = playerService.getPlayerBySponsor(sponsor);
			if (players.isEmpty()) {
				sponsorResponse.setSponsor(sponsor);
				sponsorService.deleteSponsor(sponsorId);
				sponsorResponse.setMsg("Successfully Deleted Sponsor.");
				httpStatus = HttpStatus.OK;
			} else {
				sponsorResponse
						.setMsg("Sponsor Exist for some players. Cannot be deleted");
				httpStatus = HttpStatus.BAD_REQUEST;
			}
		} else {
			sponsorResponse.setMsg("Sponsor does not exist");
			httpStatus = HttpStatus.NOT_FOUND;
		}

		res = new ResponseEntity(sponsorResponse, httpStatus);
		return res;
	}

	@PostMapping(path = "/{sponsorId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateSponsor(
			@PathVariable(value = "sponsorId") String sponsorId,
			@RequestBody Sponsor sponsorRequest) {

		SponsorResponse sponsorResponse = new SponsorResponse();
		ResponseEntity res = null;
		HttpStatus httpStatus = null;
		boolean isValid = GameApisValidator.validateCreateSponsorRequest(
				sponsorRequest, sponsorResponse);
		if (isValid) {
			Sponsor sponsor = sponsorService.getSponsor(sponsorId);
			if (sponsor != null) {

				Sponsor updatedSponsor = sponsorService.updateSponsor(sponsor,
						sponsorRequest);
				sponsorResponse.setSponsor(updatedSponsor);
				sponsorResponse.setMsg("Sponsor updated Successfully");
				httpStatus = HttpStatus.OK;

			} else {
				sponsorResponse.setMsg("Sponsor does not exist");
				httpStatus = HttpStatus.NOT_FOUND;
			}

		} else {
			httpStatus = HttpStatus.BAD_REQUEST;
		}

		res = new ResponseEntity(sponsorResponse, httpStatus);
		return res;
	}

}
