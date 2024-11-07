package com.chess.model.piece;

import com.chess.enums.Color;

public class Pawn extends Piece {

	public Pawn(Color color) {
		super(color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean validMove(int srcRow, int srcCol, int destRow, int destCol) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String toString() {
		return  (getColor()==Color.WHITE?"W":"B")+"P" ;
	}
}