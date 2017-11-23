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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addNewSponsor(
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "description", required = false) String description,
			@RequestParam(value = "street", required = false) String street,
			@RequestParam(value = "city", required = false) String city,
			@RequestParam(value = "state", required = false) String state,
			@RequestParam(value = "zip", required = false) String zip) {

		ResponseEntity res = null;
		HttpStatus httpStatus = null;
		SponsorResponse sponsorResponse = new SponsorResponse();
		if (name == null) {
			sponsorResponse.setMsg("Name cannot be empty for Sponsor.");
			httpStatus = HttpStatus.BAD_REQUEST;
		} else if (name.equals("")) {
			sponsorResponse.setMsg("Name cannot be empty for Sponsor.");
			httpStatus = HttpStatus.BAD_REQUEST;
		} else {

			Sponsor sponsor = new Sponsor();
			sponsor.setName(name);
			sponsor.setStreet(street);
			sponsor.setCity(city);
			sponsor.setDescription(description);
			sponsor.setState(state);
			sponsor.setZip(zip);
			Sponsor savedSponsor = sponsorService.createSponsor(sponsor);
			sponsorResponse.setSponsor(savedSponsor);
			sponsorResponse.setMsg("Successfull created a new Sponsor");
			httpStatus = HttpStatus.OK;

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
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "description", required = false) String description,
			@RequestParam(value = "street", required = false) String street,
			@RequestParam(value = "city", required = false) String city,
			@RequestParam(value = "state", required = false) String state,
			@RequestParam(value = "zip", required = false) String zip) {

		ResponseEntity res = null;
		HttpStatus httpStatus = null;
		SponsorResponse sponsorResponse = new SponsorResponse();

		if (name == null) {
			sponsorResponse.setMsg("Name cannot be empty for Sponsor.");
			httpStatus = HttpStatus.BAD_REQUEST;
		} else if (name.equals("")) {
			sponsorResponse.setMsg("Name cannot be empty for Sponsor.");
			httpStatus = HttpStatus.BAD_REQUEST;
		} else {
			Sponsor sponsor = sponsorService.getSponsor(sponsorId);
			if (sponsor != null) {
				Sponsor sponsorRequest = new Sponsor();
				sponsorRequest.setName(name);
				sponsorRequest.setStreet(street);
				sponsorRequest.setCity(city);
				sponsorRequest.setDescription(description);
				sponsorRequest.setState(state);
				sponsorRequest.setZip(zip);
				Sponsor updatedSponsor = sponsorService.updateSponsor(sponsor,
						sponsorRequest);
				sponsorResponse.setSponsor(updatedSponsor);
				sponsorResponse.setMsg("Sponsor updated Successfully");
				httpStatus = HttpStatus.OK;

			} else {
				sponsorResponse.setMsg("Sponsor does not exist");
				httpStatus = HttpStatus.NOT_FOUND;
			}

		}

		res = new ResponseEntity(sponsorResponse, httpStatus);
		return res;
	}

}
