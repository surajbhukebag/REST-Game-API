package edu.sjsu.cmpe275.lab2.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.sjsu.cmpe275.lab2.model.Player;

public interface PlayerRespository extends CrudRepository<Player, Long> {

	@Query(value = "SELECT * FROM player WHERE sponsor_id = ?1", nativeQuery = true)
	public List<Player> findPlayersBySponsor(
			@Param("sponsor_id") long sponsor_id);

}
