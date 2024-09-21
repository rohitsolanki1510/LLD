package com.tictactoe.model;

import java.util.Scanner;

import com.tictactoe.enums.CellState;
import com.tictactoe.enums.PlayerType;
import com.tictactoe.validation.CellValidation;

public class HumanPlayer extends Player {
	private Scanner scanner; 

	public HumanPlayer(String name, Character character, String userName, PlayerType playerType) {
		super(name, character, userName,playerType);
		 scanner = new Scanner(System.in);
	}

	public PlayerType getPlayerType() {
		return playerType;
	}

	@Override
	Cell makeMove(Board board) {
		System.out.println(this.getName() + ", It's your move. Please input the row and column");
        int row,col;
        do{
            row = scanner.nextInt();
            col = scanner.nextInt();
        }while(!CellValidation.validateRowCol(board,row,col));

        Cell cell = board.getBoardCells().get(row).get(col);
        cell.setCellState(CellState.FILLED);
        cell.setPlayer(this);

        return cell;
	}
	
	
	
}
