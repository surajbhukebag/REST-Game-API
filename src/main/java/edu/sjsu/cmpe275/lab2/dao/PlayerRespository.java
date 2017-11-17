package edu.sjsu.cmpe275.lab2.dao;

import org.springframework.data.repository.CrudRepository;
import edu.sjsu.cmpe275.lab2.model.Player;

public interface PlayerRespository extends CrudRepository<Player, Long> {

}
