package edu.sjsu.cmpe275.lab2.mapper;

import edu.sjsu.cmpe275.lab2.model.Player;

public class PlayerResponse {
	
	private String msg;
	
	private Player player;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Player getPlayerr() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

}
