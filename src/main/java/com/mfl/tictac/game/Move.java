package com.mfl.tictac.game;

import com.mfl.tictac.board.Box;
import com.mfl.tictac.exception.UnavailableBoxException;
import com.mfl.tictac.game.validation.MoveValidator;
import com.mfl.tictac.player.Player;

public class Move {

	private int num;
	
	private Player player;
	
	private MoveValidator validator;
	
	private Box box;
	
	public Move(int num, MoveValidator validator, Player player) {
		this.num = num;
		this.validator = validator;
		this.player = player;
		onCreateMove();
	}

	private void onCreateMove() throws UnavailableBoxException {
		if(!validator.validate(this)) {
			throw new UnavailableBoxException("Box is not available on bvoard");
		}
		int col = (num%3) == 0 ? 3 : num%3;
		int row = num % 3 == 0 ? (num/3 - 1) : (num/3);
		//row = row-1;
		this.box = new Box(row, col-1, player.getPlayerChar());
		if(validator.isBoxAlreadyOnBoard(box))
			throw new UnavailableBoxException("Unvailable box");
	}
	
	public Box getBox() {
		return this.box;
	}

	public int getNum() {
		return this.num;
	}
	
	public Player getPLayer() {
		return this.player;
	}
}
