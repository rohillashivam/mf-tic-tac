package com.mfl.tictac.game.executor;

import com.mfl.tictac.board.Box;
import com.mfl.tictac.game.Game;
import com.mfl.tictac.game.Move;
import com.mfl.tictac.game.state.GameState;
import com.mfl.tictac.player.state.PlayerState;

/**
 * responsibilty of update Game and state
 * @author shivam.rohilla
 *
 */
public class GameProcessor {

	public void processGame(Move move, Box[][] boxMatrix, Game game) {
		if(processRow(move, boxMatrix)) {
			game.setState(GameState.COMPLETED);
			move.getPLayer().updateState(PlayerState.WIN);
			return;
		}
		if(processCol(move, boxMatrix)) {
			game.setState(GameState.COMPLETED);
			move.getPLayer().updateState(PlayerState.WIN);
			return;
		}
		
		if(processDaigonalLeft(move, boxMatrix)) {
			game.setState(GameState.COMPLETED);
			move.getPLayer().updateState(PlayerState.WIN);
			return;
		}
		if(processDaigonalRight(move, boxMatrix)) {
			game.setState(GameState.COMPLETED);
			move.getPLayer().updateState(PlayerState.WIN);
			return;
		}
			
	}

	private boolean processDaigonalRight(Move move, Box[][] boxMatrix) {
		int row = move.getBox().getRow();
		int col = move.getBox().getCol();
		//top to down
		row = 0; col=2;
		while(row < 3 && col >=0) {
			if(boxMatrix[row][col] == null)
				return false;
			if(boxMatrix[row][col].getCh() != move.getPLayer().getPlayerChar())
				return false;
			row++;
			col--;
		}
		
		return true;
	}

	private boolean processDaigonalLeft(Move move, Box[][] boxMatrix) {
		int row = move.getBox().getRow();
		int col = move.getBox().getCol();
		//top to down
		row = 0; col=0;
		while(row < 3 && col < 3) {
			if(boxMatrix[row][col] == null)
				return false;
			if(boxMatrix[row][col].getCh() != move.getPLayer().getPlayerChar())
				return false;
			row++;
			col++;
		}
		
		return true;
	}

	private boolean processCol(Move move, Box[][] boxMatrix) {
		int col = move.getBox().getCol();
		for(int i=0; i<3; i++) {
			if(boxMatrix[i][col] == null)
				return false;
			if(boxMatrix[i][col].getCh() != move.getPLayer().getPlayerChar())
				return false;
		}
		return true;
	}

	private boolean processRow(Move move, Box[][] boxMatrix) {
		int row = move.getBox().getRow();
		for(int i=0; i<3; i++) {
			if(boxMatrix[row][i] == null)
				return false;
			if(boxMatrix[row][i].getCh() != move.getPLayer().getPlayerChar())
				return false;
		}
		return true;
	}
}
