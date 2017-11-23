/*
 * 
 */
package edu.sjsu.cmpe275.lab2.mapper;

import java.util.List;

import edu.sjsu.cmpe275.lab2.model.Sponsor;

// TODO: Auto-generated Javadoc
/**
 * The Class SponsorListResponse.
 */
public class SponsorListResponse {
	
	/** The msg. */
	private String msg;
	
	/** The sponsors. */
	private List<Sponsor> sponsors;

	/**
	 * Gets the msg.
	 *
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * Sets the msg.
	 *
	 * @param msg the new msg
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * Gets the sponsors.
	 *
	 * @return the sponsors
	 */
	public List<Sponsor> getSponsors() {
		return sponsors;
	}

	/**
	 * Sets the sponsors.
	 *
	 * @param sponsors the new sponsors
	 */
	public void setSponsors(List<Sponsor> sponsors) {
		this.sponsors = sponsors;
	}

}
