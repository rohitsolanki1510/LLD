package com.tictactoe.model;

import java.util.ArrayList;
import java.util.List;

public class Board {
	private final int dimension;
	private final List<List<Cell>>  boardCells;
	
	public Board(int dimension) {
		this.dimension=dimension;
		boardCells=new ArrayList<>();
		initialiseBoard(boardCells);
	}
	
	public void print() {
		for(int i=0;i<dimension;i++) {
			for(int j=0;j<dimension;j++) {
				boardCells.get(i).get(j).display();
			}
			System.out.println();
		}
	}
	
	public void initialiseBoard(List<List<Cell>> boardCells) {
		for(int i=0;i<dimension;i++) {
			List<Cell> rowCells=new ArrayList<>();
			for(int j=0;j<dimension;j++) {
				rowCells.add(new Cell(i, j));
			}
			boardCells.add(rowCells);
		}
	}

	public int getDimension() {
		return dimension;
	}

	public List<List<Cell>> getBoardCells() {
		return boardCells;
	}
	
}
