package com.chess.factory;

import java.util.HashMap;
import java.util.Map;

import com.chess.enums.PieceType;
import com.chess.model.piece.Piece;
import com.chess.strategy.BishopMovePlayingStrategy;
import com.chess.strategy.KingMoveStrategy;
import com.chess.strategy.KnightMoveStrategy;
import com.chess.strategy.PawnMoveStrategy;
import com.chess.strategy.QueenMoveStrategy;
import com.chess.strategy.RookMoveStrategy;

public class PieceFactory {
	
	Map<PieceType,Piece> piecesMap;
	
	public PieceFactory() {
		piecesMap=new HashMap<>();
		/*
		 * piecesMap.put(PieceType.KING, new Piece(PieceType.KING,new
		 * KingMoveStrategy())); piecesMap.put(PieceType.QUEEN,new
		 * Piece(PieceType.KING,new QueenMoveStrategy()));
		 * piecesMap.put(PieceType.BISHOP, new Piece(PieceType.BISHOP,new
		 * BishopMovePlayingStrategy())); piecesMap.put(PieceType.KNIGHT, new
		 * Piece(PieceType.KNIGHT,new KnightMoveStrategy()));
		 * piecesMap.put(PieceType.PAWN, new Piece(PieceType.PAWN,new
		 * PawnMoveStrategy())); piecesMap.put(PieceType.ROOK, new
		 * Piece(PieceType.ROOK,new RookMoveStrategy()));
		 */
	}
	
	public Piece getPiece(PieceType pieceType) {
		return piecesMap.get(pieceType);
	}
}
