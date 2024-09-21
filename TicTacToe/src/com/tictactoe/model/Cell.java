package com.tictactoe.model;

import com.tictactoe.enums.CellState;

public class Cell {
	private int row;
	private int col;
	private Player player;
	private CellState cellState;

	public Cell(int row, int col) {
		this.row = row;
		this.col = col;
		this.cellState = CellState.EMPTY;
	}

	public void display() {
		if (cellState.equals(CellState.EMPTY)) {
			System.out.print("|_|");
		} else {
			System.out.print("|" + player.getCharacter() + "|");
		}
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public Player getPlayer() {
		return player;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public CellState getCellState() {
		return cellState;
	}

	public void setCellState(CellState cellState) {
		this.cellState = cellState;
	}
	
	

}
