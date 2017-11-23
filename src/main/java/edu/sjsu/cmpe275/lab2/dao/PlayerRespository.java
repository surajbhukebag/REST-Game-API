/*
 * 
 */
package edu.sjsu.cmpe275.lab2.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.sjsu.cmpe275.lab2.model.Player;

// TODO: Auto-generated Javadoc
/**
 * The Interface PlayerRespository.
 */
public interface PlayerRespository extends CrudRepository<Player, Long> {

	/**
	 * Find players by sponsor.
	 *
	 * @param sponsor_id the sponsor id
	 * @return the list
	 */
	@Query(value = "SELECT * FROM player WHERE sponsor_id = ?1", nativeQuery = true)
	public List<Player> findPlayersBySponsor(
			@Param("sponsor_id") long sponsor_id);

	/**
	 * Find player by email.
	 *
	 * @param email the email
	 * @return the player
	 */
	@Query(value = "SELECT * FROM player WHERE email = ?1", nativeQuery = true)
	public Player findPlayerByEmail(@Param("email") String email);

}
