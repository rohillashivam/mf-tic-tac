package com.mfl.tictac.game;

import java.util.List;
import java.util.UUID;

import com.mfl.tictac.game.state.GameState;
import com.mfl.tictac.player.Player;

public class Game {

	private UUID id;
	
	private List<Player> playerList;
	
	private GameState state;
	
	public Game(List<Player> playerList) {
		this.id = UUID.randomUUID();
		this.playerList = playerList;
	}

	public UUID getId() {
		return id;
	}

	public List<Player> getPlayerList() {
		return playerList;
	}

	public GameState getState() {
		return state;
	}
	
	public void setState(GameState state) {
		this.state = state;
	}
}
