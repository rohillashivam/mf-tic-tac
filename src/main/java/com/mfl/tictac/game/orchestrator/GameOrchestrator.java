package com.mfl.tictac.game.orchestrator;

import java.util.List;

import com.mfl.tictac.board.Board;
import com.mfl.tictac.game.Game;
import com.mfl.tictac.game.Move;
import com.mfl.tictac.game.executor.MoveExecutor;
import com.mfl.tictac.game.state.GameState;
import com.mfl.tictac.game.validation.MoveValidator;
import com.mfl.tictac.player.Player;
import com.mfl.tictac.player.state.PlayerState;

public class GameOrchestrator {

	private Game game;
	private Board board;
	private List<Player> players;
	private MoveValidator moveValidator;
	private MoveExecutor moveExecutor;
	
	public GameOrchestrator(Game game, Board board, List<Player> playerList) {
		this.game = game;
		this.board = board;
		this.players = playerList;
		moveValidator = new MoveValidator(board);
		game.setState(GameState.IN_PROGRESS);
		this.moveExecutor = new MoveExecutor();
	}

	public void orchestrate(int moveNum, char ch) {
		Player player = findPlayer(ch);
		Move move = buildMove(moveNum, player);
		moveExecutor.execute(board, move);
		board.printBoard();
	}

	private Player findPlayer(char ch) {
		for (Player playerData : players) {
			if(playerData.getPlayerChar() == ch) {
				return playerData;
			}
		}
		return null;
	}

	private Move buildMove(int moveNum, Player player) {
		return new Move(moveNum, moveValidator, player);
	}

	public boolean isGameOver() {
		return game.getState().equals(GameState.COMPLETED) || 
				game.getState().equals(GameState.DRAW) ? true : false;
	}

	public boolean isGameDrawn() {
		return game.getState().equals(GameState.DRAW);
	}

	public Player getWinner() {
		for (Player playerData : players) {
			if(playerData.getState().equals(PlayerState.WIN)) {
				return playerData;
			}
		}
		return null;
	}
}
