package com.tictactoe.model;

import com.tictactoe.enums.PlayerType;

public abstract class Player {
	protected String name;
	protected Character character;
	protected String userName;
	public PlayerType playerType;
	
	public Player(String name, Character character, String userName,PlayerType playerType) {
		this.name = name;
		this.character = character;
		this.userName = userName;
		this.playerType=playerType;
	}
	
	abstract Cell makeMove(Board board);

	public String getName() {
		return name;
	}

	public Character getCharacter() {
		return character;
	}

	public String getUserName() {
		return userName;
	}
	
	
}
