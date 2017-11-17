package edu.sjsu.cmpe275.lab2.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.sjsu.cmpe275.lab2.model.Opponent;

public interface OpponentRepository extends CrudRepository<Opponent, Long> {

	@Query("SELECT * FROM opponent where player_id = :playerId and opponent_id = :opponentId")
	public Opponent findByPlayers(@Param("player_id") String playerId,
			@Param("opponent_id") String opponentId);

}
