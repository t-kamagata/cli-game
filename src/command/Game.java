package command;

import static command.Hand.*;

import java.util.Random;

public class Game {
	
	private Hand p1;
	private Hand com;
	private Random rnd;
	Game() {
		p1 = None;
		com = None;
		rnd = new Random();
	}
	
	/**
	 * 勝敗の判定
	 * @return
	 * 1: playerの勝利<br>
	 * 0: 引き分け<br>
	 * -1: コンピュータの勝利
	 */
	int judge() {
		switch(p1) {
		case Rock:
			switch(com) {
			case Rock:
				return 0;
			case Paper:
				return -1;
			case Scissors:
				return 1;
			}
		case Paper:
			switch(com) {
			case Rock:
				return 1;
			case Paper:
				return 0;
			case Scissors:
				return -1;
			}
		case Scissors:
			switch(com) {
			case Rock:
				return -1;
			case Paper:
				return 1;
			case Scissors:
				return 0;
			}
		}
		return 3;
	}
	String handToString(Hand hand) {
		switch(hand) {
		case Rock:
			return "グー";
		case Paper:
			return "パー";
		case Scissors:
			return "チョキ";
		}
		return "エラー";
	}
	void print() {
		System.out.printf("Player:%s vs Com:%s\n", handToString(p1), handToString(com));
	}
	void setPlayerHand(Hand hand) {
		p1 = hand;
	}
	void setComHandRandom() {
		Hand h = Hand.values()[rnd.nextInt(1, 4)];
		com = h;
	}
}
