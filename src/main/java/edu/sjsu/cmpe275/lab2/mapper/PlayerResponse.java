/*
 * 
 */
package edu.sjsu.cmpe275.lab2.mapper;

import edu.sjsu.cmpe275.lab2.model.Player;

// TODO: Auto-generated Javadoc
/**
 * The Class PlayerResponse.
 */
public class PlayerResponse {
	
	/** The msg. */
	private String msg;
	
	/** The player. */
	private Player player;
	
	/** The group. */
	private String group = "Group 13";

	
	/**
	 * Gets the group.
	 *
	 * @return the group
	 */
	public String getGroup() {
		return group;
	}

	/**
	 * Sets the group.
	 *
	 * @param group the new group
	 */
	public void setGroup(String group) {
		this.group = group;
	}

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
	 * Gets the player.
	 *
	 * @return the player
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * Sets the player.
	 *
	 * @param player the new player
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

}
