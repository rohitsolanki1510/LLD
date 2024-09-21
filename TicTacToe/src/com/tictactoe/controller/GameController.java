package com.tictactoe.controller;

import java.util.List;

import com.tictactoe.model.Board;
import com.tictactoe.model.Game;
import com.tictactoe.model.Game.GameBuilder;
import com.tictactoe.model.Player;

public class GameController {
	
	public Game startGame(int dimension,List<Player> players) {
		return GameBuilder.getBuilder()
				.board(new Board(dimension))
				.players(players).build();
	}
	
	
	public void makeMove(Game game) {
		game.nextMove();
	}
	
	public void printBoard(Game game) {
		game.printGameBoard();
	}
	
	
	public void undo(Game game) {
		
	}

}
