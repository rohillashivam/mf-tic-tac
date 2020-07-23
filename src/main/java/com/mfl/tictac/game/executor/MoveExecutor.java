package com.mfl.tictac.game.executor;

import java.util.Objects;

import com.mfl.tictac.board.Board;
import com.mfl.tictac.game.Move;

public class MoveExecutor {

	public void execute(Board board, Move move) {
		//if(Objects.isNull(move))
		//	throw exception
		board.updateBoard(move);
	}
}
