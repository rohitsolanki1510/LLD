package com.chess.model.piece;

import com.chess.enums.Color;

public class Rook extends Piece {

	public Rook(Color color) {
		super(color);
	}

	@Override
	public boolean validMove(int srcRow, int srcCol, int destRow, int destCol) {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public String toString() {
		return (getColor()==Color.WHITE?"W":"B")+"R" ;
	}

}
