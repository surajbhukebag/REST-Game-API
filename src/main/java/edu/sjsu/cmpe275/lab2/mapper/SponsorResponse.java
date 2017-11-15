package edu.sjsu.cmpe275.lab2.mapper;


import edu.sjsu.cmpe275.lab2.model.Sponsor;

public class SponsorResponse {
	
	private String msg;
	
	private Sponsor sponsor;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Sponsor getSponsor() {
		return sponsor;
	}

	public void setSponsor(Sponsor sponsor) {
		this.sponsor = sponsor;
	}

}
