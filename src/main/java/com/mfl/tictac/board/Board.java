package com.mfl.tictac.board;

import com.mfl.tictac.game.Game;
import com.mfl.tictac.game.Move;
import com.mfl.tictac.game.executor.GameProcessor;

// Singleton
public class Board {

	private Box[][] boxMatrix = null;
	
	private GameProcessor processor;
	
	private Game game;
	
	public Board(Game game) {
		boxMatrix = new Box[3][3];
		processor = new GameProcessor();
		this.game = game;
	}
	
	public void updateBoard(Move move) {
		int row = move.getBox().getRow();
		int col = move.getBox().getCol();
		boxMatrix[row][col] = move.getBox();
		processor.processGame(move, boxMatrix, game);
	}

	public void printBoard() {
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(boxMatrix[i][j] == null)
					System.out.print("- ");
				else
					System.out.print(boxMatrix[i][j].getCh()+" ");
			}
			System.out.println();
		}
	}

	public boolean isBoxFilled(Box box) {
		if(boxMatrix[box.getRow()][box.getCol()] != null)
			return true;
		
		return false;
	}
}
