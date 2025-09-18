package jp.co.sfrontier.ss3.app;

/**
 * 勝敗を記録するためのクラス
 */
public class GameStatus {
	private int totalGames = 0;
	private int wins = 0;
	
	/**
	 * 勝利数をカウントするメソッド
	 * @param isWin（true: 勝ち, false: 負け)
	 */
	public void recordGame(boolean isWin) {
		totalGames++;
		if (isWin) {
			wins++;
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public double getWinRate() {
		if (totalGames == 0) {
			return 0.0;
		}
		return (double) wins/totalGames * 100;
	}
	
	public void printStatas() {
		System.out.printf("総対戦数: %d, 勝ち数: %d, 勝率: %.2f%%\n", totalGames, wins, getWinRate());
	}
}
