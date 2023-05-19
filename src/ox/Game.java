package ox;

public class Game {
	State turn;
	State[][] board;
	
	Game() {
		turn = State.Circle;
		board = new State[5][5];
		for(int i = 0; i < board.length; i++)
			for(int j = 0; j < board.length; j++) {
				if(i == 0 || i == 4
						|| j == 0 || j == 4) {
						board[i][j] = State.Block;
					} else
						board[i][j] = State.Empty;
			}
	}
	void flipTurn() {
		turn = oppTurn();
	}
	State oppTurn() {
		if(turn == State.Circle)
			return State.Cross;
		else
			return State.Circle;
	}
	void setBoardState(int i, int j) {
		board[i][j] = turn;
	}
	void printBoard() {
		System.out.println("     1   2   3 ");
		System.out.println("   -------------");
		
		for(int i = 1; i < board.length-1; i++) {
			for(int j = 1; j < board.length-1; j++) {
				if(j == 1)
					System.out.printf("%2d", i);
				System.out.printf(" |%2s", board[i][j]);
				if(j == board.length - 2)
					System.out.println(" |");
			}
			System.out.println("   -------------");
		}
	}
	
	boolean puttable(int i, int j) {
		if(board[i][j] == State.Empty)
			return true;
		else
			return false;
	}
	boolean winnerDetermined() {
		for(int i = 0; i < 3; i++) {  // 行方向に捜査
			if(board[i+1][1] == turn
					&& board[i+1][2] == turn
					&& board[i+1][3] == turn) 
				return true;
		}
		for(int i = 0; i < 3; i++) {  // 列方向に捜査
			if(board[1][i+1] == turn
					&& board[2][i+1] == turn
					&& board[3][i+1] == turn) 
				return true;
		}
		if(board[1][1] == turn
				&& board[2][2] == turn
				&& board[3][3] == turn)  // 左上から右下
			return true;
		if(board[3][1] == turn
				&& board[2][2] == turn
				&& board[1][3] == turn)  // 左下から右上
			return true;
		
		return false;
	}

	boolean occupied() {
		for(int i = 0; i < board.length; i++)
			for(int j = 0; j < board.length; j++)
				if(board[i][j] == State.Empty)
					return false;
		return true;
	}
}

