import java.util.List;
import java.util.Scanner;

import com.chess.enums.Color;
import com.chess.model.Game;
import com.chess.model.HumanPlayer;

public class GameLauncher {
	

	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter Player name choosing White: ");
	        String player1= scanner.next();
	        System.out.print("Enter Player name choosing Black: ");
	        String player2= scanner.next();
	        
	        Game game=new Game(List.of(new HumanPlayer(player1,Color.WHITE),new HumanPlayer(player2,Color.BLACK)));
	        game.startGame();
	}

}
