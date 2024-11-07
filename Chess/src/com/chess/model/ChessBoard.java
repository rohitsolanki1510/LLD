package com.chess.model;

import com.chess.enums.Color;
import com.chess.model.piece.Bishop;
import com.chess.model.piece.King;
import com.chess.model.piece.Knight;
import com.chess.model.piece.Pawn;
import com.chess.model.piece.Piece;
import com.chess.model.piece.Queen;
import com.chess.model.piece.Rook;

public class ChessBoard {
	private Piece[][] board;
	
	public ChessBoard() {
		this.board = new Piece[8][8];
		initialiseBoard();
	}

	public void print() {
		//Logic to print board
		for(int row=0;row<8;row++) {
			for(int col=0;col<8;col++) {
				System.out.print((board[row][col]!=null?board[row][col].toString():"  ")+"|");
			}
			System.out.println();
			System.out.println("__|__|__|__|__|__|__|__|");
		}
	}
	
	public void initialiseBoard() {
		//Initialize white pieces
        board[0][0] = new Rook(Color.WHITE);
		board[0][1] = new Knight(Color.WHITE);
		board[0][2] = new Bishop(Color.WHITE);
		board[0][3] = new Queen(Color.WHITE);
		board[0][4] = new King(Color.WHITE);
		board[0][5] = new Bishop(Color.WHITE);
		board[0][6] = new Knight(Color.WHITE);
		board[0][7] = new Rook(Color.WHITE);
        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn(Color.WHITE);
        }        
        // Initialize black pieces
        board[7][0] = new Rook(Color.BLACK);
		board[7][1] = new Knight(Color.BLACK);
		board[7][2] = new Bishop(Color.BLACK);
		board[7][3] = new Queen(Color.BLACK);
		board[7][4] = new King(Color.BLACK);
		board[7][5] = new Bishop(Color.BLACK);
		board[7][6] = new Knight(Color.BLACK);
		board[7][7] = new Rook(Color.BLACK);
        for (int i = 0; i < 8; i++) {
            board[6][i] = new Pawn(Color.BLACK);
        }
		
	}
	
	public boolean isCheckmate(Color color) {
		//Logic to check is CheckMate
		return false;
	}
	
	public boolean isStalemate(Color color) {
		//Logic to check is StaleMate
		return false;
	}
	
	public Piece getPiece(int row,int col) {
		return board[row][col];
	}

	public Piece[][] getBoard() {
		return board;
	}
	
}
