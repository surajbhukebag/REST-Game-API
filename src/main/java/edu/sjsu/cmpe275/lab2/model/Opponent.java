package edu.sjsu.cmpe275.lab2.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Opponent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	// @Id
	private long playerId;

	// @Id
	private long opponentId;

	public long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(long playerId) {
		this.playerId = playerId;
	}

	public long getOpponentId() {
		return opponentId;
	}

	public void setOpponentId(long opponentId) {
		this.opponentId = opponentId;
	}

}
