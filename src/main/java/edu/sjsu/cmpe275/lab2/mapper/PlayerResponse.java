package edu.sjsu.cmpe275.lab2.mapper;

import edu.sjsu.cmpe275.lab2.model.Player;

public class PlayerResponse {
	
	private String msg;
	
	private Player player;
	
	private String group = "Group 13";

	
	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

}
