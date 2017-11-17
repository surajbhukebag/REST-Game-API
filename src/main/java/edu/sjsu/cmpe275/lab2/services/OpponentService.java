package edu.sjsu.cmpe275.lab2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sjsu.cmpe275.lab2.dao.OpponentRepository;
import edu.sjsu.cmpe275.lab2.model.Opponent;
import edu.sjsu.cmpe275.lab2.model.Player;

@Service
public class OpponentService {
	
	@Autowired
	private OpponentRepository opponentRepository;
	
	public Opponent addOpponent(Player player, Player opponent) {
		
		Opponent op = new Opponent();
		op.setPlayerId(player.getId());
		op.setOpponentId(opponent.getId());
		Opponent o = opponentRepository.save(op);
		
		return o;
	}

}
