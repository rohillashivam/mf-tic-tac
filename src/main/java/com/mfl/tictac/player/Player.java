package com.mfl.tictac.player;

import com.mfl.tictac.player.state.PlayerState;

public class Player {

	private int id;
	private String name;
	private char playerChar;
	private PlayerState state;
	
	public Player(int id, String name, char playerChar) {
		super();
		this.id = id;
		this.name = name;
		this.playerChar = playerChar;
		this.state = PlayerState.IN_GAME;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public char getPlayerChar() {
		return playerChar;
	}

	public PlayerState getState() {
		return state;
	}

	public void updateState(PlayerState state) {
		this.state = state;
	}
	
}
