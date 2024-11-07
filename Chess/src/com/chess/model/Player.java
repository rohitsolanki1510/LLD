package com.chess.model;

import com.chess.controller.exception.InvalidMoveException;
import com.chess.enums.Color;

public abstract class Player {
	protected String name;
	protected Color color;
	
	abstract Move makeMove(ChessBoard board) throws InvalidMoveException;

	public String getName() {
		return name;
	}

	public Color getColor() {
		return color;
	}
	
	
}
