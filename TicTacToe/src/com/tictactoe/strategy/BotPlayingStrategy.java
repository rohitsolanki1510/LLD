package com.tictactoe.strategy;

import com.tictactoe.model.Board;
import com.tictactoe.model.Cell;

public interface BotPlayingStrategy {
	Cell makeNextMove(Board board); 
}
