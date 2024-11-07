package com.tictactoe.launcher;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.tictactoe.controller.GameController;
import com.tictactoe.enums.BotDifficultyLevel;
import com.tictactoe.enums.GameState;
import com.tictactoe.enums.PlayerType;
import com.tictactoe.model.BotPlayer;
import com.tictactoe.model.Game;
import com.tictactoe.model.HumanPlayer;
import com.tictactoe.model.Player;
import com.tictactoe.model.WinningStrategy;

public class TicTacToeLauncher {

	public static void main(String[] args) {
		System.out.println("Welcome to TicTacToe Game!");

		GameController gameController = new GameController();
		Scanner scanner = new Scanner(System.in);
		Player playerA = new HumanPlayer("Rohit", 'X',"", PlayerType.HUMAN);
		Player playerB = new HumanPlayer("Roger", 'O',"", PlayerType.HUMAN);
		//Player playerB = new BotPlayer("ChatGPT", 'O',"", PlayerType.BOT, BotDifficultyLevel.EASY);
		List<Player> players = new ArrayList<>();
		players.add(playerA);
		players.add(playerB);


		Game game = gameController.startGame(3, players);
		while (game.getGameState().equals(GameState.IN_PROGRESS)) {
			game.printGameBoard();

			//System.out.println("Do you want to undo?(y/n)");
			//String undo = scanner.next();

			/*
			 * if (undo.equalsIgnoreCase("y")) { game.undo(); continue; }
			 */

			game.nextMove();
		}
		game.printGameBoard();
		if (game.getGameState().equals(GameState.CONCLUDED)) {
			System.out.println(game.getWinner().getName() + " have won");
		}

		if (game.getGameState().equals(GameState.DRAW)) {
			System.out.println("It's a draw");
		}
	}

}
