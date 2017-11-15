package edu.sjsu.cmpe275.lab2.mapper;

import java.util.List;

import edu.sjsu.cmpe275.lab2.model.Sponsor;

public class SponsorListResponse {
	
	private String msg;
	
	private List<Sponsor> sponsors;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<Sponsor> getSponsors() {
		return sponsors;
	}

	public void setSponsors(List<Sponsor> sponsors) {
		this.sponsors = sponsors;
	}

}
