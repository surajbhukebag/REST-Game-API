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
		
		// *** Added another record so that relationship is two way i.e. both players are opponents of each other.
		Opponent op2 = new Opponent();
		op2.setPlayerId(opponent.getId());
		op2.setOpponentId(player.getId());
		Opponent o2 = opponentRepository.save(op2);
		
		return o;
	}

}
