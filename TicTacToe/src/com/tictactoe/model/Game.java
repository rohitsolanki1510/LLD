package com.tictactoe.model;

import java.util.ArrayList;
import java.util.List;

import com.tictactoe.enums.GameState;
import com.tictactoe.strategy.WinningStrategy;

public class Game {
	private final Board board;
	private final List<Player> players;
	private final List<Move> moves;
	private Player winner;
	private GameState gameState;
	private final WinningStrategy winningStrategy;

	private Game(GameBuilder gameBuilder) {
		this.board = gameBuilder.board;
		this.players = gameBuilder.players;
		this.moves = new ArrayList<>();
		this.winner = null;
		this.gameState = GameState.IN_PROGRESS;
		winningStrategy=new WinningStrategy();
	}

	public void printGameBoard() {
		board.print();
	}

	public void nextMove() {
		Player player = players.get(moves.size()%players.size());
		Cell cell = player.makeMove(this.board);

		Move move = new Move(cell, player);
		this.moves.add(new Move(cell, player));

		if (winningStrategy.checkWinner(this.board, move)){
			this.gameState = GameState.CONCLUDED;
			this.winner = player;
			return;
		}

		if (this.moves.size() == this.board.getDimension() * this.board.getDimension()) {
			this.gameState = GameState.DRAW;
			return;
		}
	}
	

	public static class GameBuilder {
		private Board board;
		private List<Player> players;
		private List<Move> moves;

		private GameBuilder() {
		}

		public static GameBuilder getBuilder() {
			return new GameBuilder();
		}

		public GameBuilder board(Board board) {
			this.board = board;
			return this;
		}

		public GameBuilder players(List<Player> players) {
			this.players = players;
			return this;
		}

		public Game build() {
			return new Game(this);
		}

	}

	public Board getBoard() {
		return board;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public List<Move> getMoves() {
		return moves;
	}

	public Player getWinner() {
		return winner;
	}

	public GameState getGameState() {
		return gameState;
	}

}
