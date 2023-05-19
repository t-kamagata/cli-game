package ox;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		var game = new Game();
		
		try(Scanner sc = new Scanner(System.in)) {
			 while(true){  // ゲームループ
				 game.printBoard();
				int[] inputs = InputValidator.returnValidValue(sc, game.turn);
				
				if(!game.puttable(inputs[0], inputs[1])) {
					System.out.println("そこには置けません");
					continue;
				}
				game.setBoardState(inputs[0], inputs[1]);
				
				if(game.winnerDetermined()) {
					game.printBoard();
					winOrLoseMessage(game.turn);
					break;
				}
				if(game.occupied()) {
					game.printBoard();
					System.out.println("引き分け！");
					break;
				}
				game.flipTurn();
			}
		}
	}
	
	static void winOrLoseMessage(State turn) {
		if(turn == State.Circle)
			System.out.println("Player 〇の勝利！");
		else
			System.out.println("Player ×の勝利！");
	}
}
