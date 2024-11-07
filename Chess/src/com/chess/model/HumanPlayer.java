package com.chess.model;

import java.util.Scanner;

import com.chess.controller.exception.InvalidMoveException;
import com.chess.enums.Color;
import com.chess.model.piece.Piece;

public class HumanPlayer extends Player{
	
	public HumanPlayer(String name, Color color) {
		this.name = name;
		this.color = color;
	}

	
		@Override
		public Move makeMove(ChessBoard chessBoard) throws InvalidMoveException{
			// TODO: Implement logic to get a valid move from the player
	        // For simplicity, let's assume the player enters the move via console input
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter source row: ");
	        int srcRow = scanner.nextInt();
	        System.out.print("Enter source column: ");
	        int srcCol = scanner.nextInt();
	        System.out.print("Enter destination row: ");
	        int destRow = scanner.nextInt();
	        System.out.print("Enter destination column: ");
	        int destCol = scanner.nextInt();
	        
			Piece piece = chessBoard.getPiece(srcRow, srcCol);
			Piece destPiece = chessBoard.getPiece(destRow, destCol);
	        if (piece == null || piece.getColor() != this.getColor()) {
	            throw new InvalidMoveException("Invalid piece selection!");
	        }
	        
	        if(!piece.validMove(srcRow,srcCol,destRow,destCol)) {
	        	throw new InvalidMoveException("Illegal Move!");
	        }
	        
	        if(destPiece!=null && destPiece.getColor()== this.getColor()) {
	        		throw new InvalidMoveException("Cannot capture your own piece!");
	        }
	        
	        chessBoard.getBoard()[destRow][destCol]=piece;
	        chessBoard.getBoard()[srcRow][srcCol]=null;
	        
	        return new Move(piece, destRow, destCol);

		}

}
