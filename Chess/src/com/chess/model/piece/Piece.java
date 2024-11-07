package com.chess.model.piece;

import com.chess.enums.Color;

public abstract class Piece {
	private final Color color;
	
	public Piece(Color color) {
		this.color=color;
	}

	public Color getColor() {
		return color;
	}
	
	public abstract boolean validMove(int srcRow,int srcCol,int destRow,int destCol);

	@Override
	public String toString() {
		return color.toString();
	}

}
