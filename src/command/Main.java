package command;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in)) {
			System.out.println("じゃんけんゲーム");
			var game = new Game();
			int result = 0;
			while(result == 0) {
				System.out.print("グー:1 チョキ:2 パー:3> ");
				int idx = scan.nextInt();
				game.setPlayerHand(Hand.values()[idx]);
				game.setComHandRandom();
				
				game.print();
				result = game.judge();
			}
			
			if(result == 1) {
				System.out.println("Playerの勝利");
			} else {
				System.out.println("Computerの勝利");
			}
		}
	}
}
