package com.chess.model;

import java.util.ArrayList;
import java.util.List;
import com.chess.controller.exception.InvalidMoveException;
import com.chess.enums.Color;
import com.chess.enums.GameState;

public class Game {
	private ChessBoard board;
	private List<Player> players;
	private GameState state;
	private Player winner;
	private List<Move> moves;
	private int currentPlayer=0;
	
	
	public Game( List<Player> players) {
		this.board = new ChessBoard();
		this.players = players;
		this.state=GameState.IN_PROGRESS;
		currentPlayer=0;
		moves=new ArrayList<>();
	}

	public void printBoard() {
		board.print();
	}
	
	public void startGame() {
		printBoard();
		while(!isGameOver()) {
			Player player = players.get(currentPlayer);
	        System.out.println(player.getColor() + "'s turn.");

            try {
            	 // Get move from the player
    	        Move move = getPlayerMove(player);
                moves.add(move);
                printBoard();
            } catch (InvalidMoveException e) {
                System.out.println(e.getMessage());
                System.out.println("Try again!");
                continue;
            }
            
            // Switch to the next player
            currentPlayer = (currentPlayer + 1) % 2;
            
		}
		
		// Display game result
        displayResult();
	}
	 private boolean isGameOver() {
	        return board.isCheckmate(players.get(0).getColor()) || board.isCheckmate(players.get(1).getColor()) ||
	                board.isStalemate(players.get(0).getColor()) || board.isStalemate(players.get(1).getColor());
	 }
	 
	 private Move getPlayerMove(Player player)throws InvalidMoveException {
	       return player.makeMove(board);
	 }
	 
	 
	 private void displayResult() {
	        if (board.isCheckmate(Color.WHITE)) {
	        	winner=players.get(0).color==Color.WHITE?players.get(0):players.get(1);
	        	System.out.println(" Congratulations: "+winner.getColor()+" ,Black wins by checkmate!");
	            state=GameState.CHECKMATE;
	        } else if (board.isCheckmate(Color.BLACK)) {
	            System.out.println(" Congratulations: "+winner.getColor()+" ,White wins by checkmate!");
	            state=GameState.CHECKMATE;
	            winner=players.get(0).color==Color.BLACK?players.get(0):players.get(1);
	        } else if (board.isStalemate(Color.WHITE) || board.isStalemate(Color.BLACK)) {
	            System.out.println("The game ends in a stalemate!");
	            state=GameState.STALEMATE;
	        }
	    }
    	
}
