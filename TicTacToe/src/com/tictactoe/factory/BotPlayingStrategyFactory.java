package com.tictactoe.factory;

import com.tictactoe.enums.BotDifficultyLevel;
import com.tictactoe.strategy.BotPlayingStrategy;
import com.tictactoe.strategy.EasyPlayingStrategy;

public class BotPlayingStrategyFactory {
	
	public static BotPlayingStrategy getBotPlayingStrategy(BotDifficultyLevel botDifficultyLevel) {
		return new EasyPlayingStrategy();
	}
}
