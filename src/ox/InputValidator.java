package ox;

import java.util.Scanner;

public class InputValidator {
	static int[] returnValidValue(Scanner sc, State turn) {
		while(true) {
			try {
				if(turn == State.Circle)
					System.out.print("[Turn: O]どこに置きますか？(行 列)>");
				else
					System.out.print("[Turn: X]どこに置きますか？(行 列)>");
				
				String[] values = sc.nextLine().split(" ");
				if(values.length != 2) {
					System.out.println("行列の空白区切りで入力してください (ex:1 2)");
					continue;
				}
				int row = Integer.parseInt(values[0]);
				int column = Integer.parseInt(values[1]);
				if(row <= 0 || row >= 4) {
					System.out.println("行の位置を1～3の範囲で入力してください");
					continue;
				}
				if(column <= 0 || column >= 4) {
					System.out.println("列の位置を1～3の範囲で入力してください");
					continue;
				}
				return new int[] {row, column};
			}catch(Exception e) {
				System.out.println("数値を入力してください");
				continue;
			}
		}
	}
}
