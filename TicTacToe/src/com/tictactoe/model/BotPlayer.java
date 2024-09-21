package com.tictactoe.model;

import com.tictactoe.enums.BotDifficultyLevel;
import com.tictactoe.enums.PlayerType;
import com.tictactoe.factory.BotPlayingStrategyFactory;
import com.tictactoe.strategy.BotPlayingStrategy;

public class BotPlayer extends Player {
	private final BotDifficultyLevel difficultyLevel;
	private final BotPlayingStrategy botStrategy;

	public BotPlayer(String name, Character character, String userName,PlayerType playerType, BotDifficultyLevel difficultyLevel) {
		super(name, character, userName,playerType);
		this.difficultyLevel = difficultyLevel;
		this.botStrategy=BotPlayingStrategyFactory.getBotPlayingStrategy(difficultyLevel);
	}

	@Override
	public Cell makeMove(Board board) {
		return botStrategy.makeNextMove(board);
	}

	public BotDifficultyLevel getDifficultyLevel() {
		return difficultyLevel;
	}

	public BotPlayingStrategy getBotStrategy() {
		return botStrategy;
	}
	
}
	
