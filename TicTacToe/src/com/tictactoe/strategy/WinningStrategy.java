package com.tictactoe.strategy;

import java.util.HashMap;
import java.util.Map;
import com.tictactoe.model.Board;
import com.tictactoe.model.Move;
import com.tictactoe.model.Player;

public class WinningStrategy {
	Map<Integer, Map<Character, Integer>> rowWiseCharMap = new HashMap<>();
	Map<Integer, Map<Character, Integer>> colWiseCharMap = new HashMap<>();
	Map<Integer, Map<Character, Integer>> diagonalCharMap = new HashMap<>();

	public boolean checkWinner(Board board, Move lastMove) {
		addToRowWiseMap(board, lastMove);
		addToColWiseMap(board, lastMove);
		addTodiagonalMap(board, lastMove);
		
		if (checkRow(board, lastMove) || checkColumn(board, lastMove) || checkDiagonal(board, lastMove)) {
			return true;
		}
		return false;
	}

	private boolean checkRow(Board board, Move move) {
		int row = move.getCell().getRow();

		return rowWiseCharMap.containsKey(row)
				&& rowWiseCharMap.get(row).get(move.getPlayer().getCharacter()) == board.getDimension();
	}

	private boolean checkColumn(Board board, Move move) {
		int col = move.getCell().getCol();

		return colWiseCharMap.containsKey(col)
				&& colWiseCharMap.get(col).get(move.getPlayer().getCharacter()) == board.getDimension();
	}

	private boolean checkDiagonal(Board board, Move move) {
		int row = move.getCell().getRow();
		int col = move.getCell().getCol();
		boolean leftDiagonalCheck = false;
		boolean rightDiagonalCheck = false;

		if (row == col) {
			leftDiagonalCheck = diagonalCharMap.containsKey(1)
					&& diagonalCharMap.get(1).get(move.getPlayer().getCharacter()) == board.getDimension();
		}

		if (row + col == board.getDimension() -1) {
			rightDiagonalCheck = diagonalCharMap.containsKey(2)
					&& diagonalCharMap.get(2).get(move.getPlayer().getCharacter()) == board.getDimension();
		}

		return leftDiagonalCheck || rightDiagonalCheck;
	}

	private void addToRowWiseMap(Board board, Move lastMove) {
		int row = lastMove.getCell().getRow();
		Player player = lastMove.getPlayer();

		if (!rowWiseCharMap.containsKey(row)) {
			rowWiseCharMap.put(row, new HashMap<>());
		}

		Map<Character, Integer> rowCountMap = rowWiseCharMap.get(row);
		rowCountMap.put(player.getCharacter(), rowCountMap.getOrDefault(player.getCharacter(), 0) + 1);
	}

	private void addToColWiseMap(Board board, Move lastMove) {
		int col = lastMove.getCell().getCol();
		Player player = lastMove.getPlayer();

		if (!colWiseCharMap.containsKey(col)) {
			colWiseCharMap.put(col, new HashMap<>());
		}

		Map<Character, Integer> colCountMap = colWiseCharMap.get(col);
		colCountMap.put(player.getCharacter(), colCountMap.getOrDefault(player.getCharacter(), 0) + 1);
	}

	private void addTodiagonalMap(Board board, Move lastMove) {
		int row = lastMove.getCell().getRow();
		int col = lastMove.getCell().getCol();
		Player player = lastMove.getPlayer();

		if (row == col) {
			if (!diagonalCharMap.containsKey(1)) {
				diagonalCharMap.put(1, new HashMap<>());
			}
			Map<Character, Integer> leftDiagonal = diagonalCharMap.get(1);
			leftDiagonal.put(player.getCharacter(), leftDiagonal.getOrDefault(player.getCharacter(), 0) + 1);
		}

		if (row + col == board.getDimension() - 1) {
			if (!diagonalCharMap.containsKey(2)) {
				diagonalCharMap.put(2, new HashMap<>());
			}
			Map<Character, Integer> rightDiagonal = diagonalCharMap.get(2);
			rightDiagonal.put(player.getCharacter(), rightDiagonal.getOrDefault(player.getCharacter(), 0) + 1);
		}

	}
}
