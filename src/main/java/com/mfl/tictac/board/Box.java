package com.mfl.tictac.board;

// TODO add the builder
public final class Box {

	private final int row;
	private final int col;
	private final char ch;
	
	public Box(int row, int col, char ch) {
		this.row = row;
		this.col = col;
		this.ch = ch;
	}
	
	public int getRow() {
		return this.row;
	}
	
	public int getCol() {
		return this.col;
	}
	
	public char getCh() {
		return this.ch;
	}
	
}
