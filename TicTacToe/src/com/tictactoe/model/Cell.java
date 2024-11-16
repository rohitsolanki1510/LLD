package com.tictactoe.model;


public class Cell {
	private int row;
	private int col;
	private Player player;
	private boolean isCellEmpty;

	public Cell(int row, int col) {
		this.row = row;
		this.col = col;
		this.isCellEmpty = true;
	}

	public void display() {
		if (isCellEmpty) {
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

	public Boolean getCellState() {
		return isCellEmpty;
	}

	public void setCellState(Boolean isCellEmpty) {
		this.isCellEmpty = isCellEmpty;
	}
	
	

}
