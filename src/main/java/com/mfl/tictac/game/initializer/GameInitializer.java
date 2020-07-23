package com.mfl.tictac.game.initializer;

import java.util.ArrayList;
import java.util.List;

import com.mfl.tictac.board.Board;
import com.mfl.tictac.game.Game;
import com.mfl.tictac.game.orchestrator.GameOrchestrator;
import com.mfl.tictac.player.Player;

public class GameInitializer {

	public GameOrchestrator initilize() {
		List<Player> playerList = initializePlayers();
		Game game = new Game(playerList);
		Board board = new Board(game);
		return new GameOrchestrator(game, board, playerList);
	}

	private List<Player> initializePlayers() {
		Player playerO = new Player(1, "Anuj", 'O');
		Player playerX = new Player(2, "Shivam", 'X');
		
		List<Player> playerList = new ArrayList<Player>(2);
		playerList.add(playerO);
		playerList.add(playerX);
		return playerList;
	}
}
