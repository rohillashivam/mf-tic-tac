package com.mfl.tictac.game.validation;

import com.mfl.tictac.board.Board;
import com.mfl.tictac.board.Box;
import com.mfl.tictac.game.Move;

public class MoveValidator {

	private Board board;
	public MoveValidator(Board board) {
		this.board = board;
	}

	public boolean validate(Move move) {
		// TODO player shjould not be null, move is not null 
		int num = move.getNum();
		if(num < 1 || num > 9)
			return false;
		return true;
	}

	public boolean isBoxAlreadyOnBoard(Box box) {
		return board.isBoxFilled(box);
	}
}
