package jp.co.sfrontier.ss3.app;

import java.util.Random;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * ゲームの流れを管理するクラス
 */
public class GameEngine {

	private static final Logger logger = LoggerManager.createLogger(GameEngine.class);
	private GameStatus status = new GameStatus();

	private Direction computer;
	private Direction player;

	/**
	 * ゲームを実行する
	 */
	public void play() {
		try (Scanner scanner = new Scanner(System.in)) {
			while (true) {
				player = InputHandler.getPlayerDirection();
				computer = getRandomDirection();

				System.out.println("あなた：" + player);
				System.out.println("相手：" + computer);
				System.out.println();

				boolean isWin = (player == computer);
				judgeResult(isWin);
				MatchRecorder.record(player, computer, isWin);
				status.recordGame(isWin);
				status.printStatas();

				System.out.println("\nもう一度プレイしますか？(Y/N)");
				String input = scanner.nextLine().trim().toUpperCase();
				if (!input.equals("Y")) {
					System.out.println("ゲームを終了します。");
					break;
				}
			}
		}
	}

	/**
	 * コンピュータがランダムに方向を指定する
	 */
	private Direction getRandomDirection() {
		Direction[] directions = Direction.values();
		Direction selected = directions[new Random().nextInt(directions.length)];
		logger.info("コンピュータの選択: " + selected);
		return selected;
	}

	/**
	 * 勝敗を判定する
	 * @param isWin 勝敗（true: 勝ち, false: 負け）
	 */
	private void judgeResult(boolean isWin) {
		if (isWin) {
			System.out.println("You Win!");
			logger.info("勝敗判定: 勝ち");
		} else {
			System.out.println("You Lose!");
			logger.info("勝敗判定: 負け");
		}
	}
}
