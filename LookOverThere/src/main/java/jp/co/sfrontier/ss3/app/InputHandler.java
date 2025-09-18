package jp.co.sfrontier.ss3.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

/**
 * プレイヤーの入力を管理するクラス
 */
public class InputHandler {

	private static final Logger logger = LoggerManager.createLogger(InputHandler.class);
	
	/**
	 * プレイヤーに方向を入力させる
	 * @return プレイヤーが選択した方向
	 */
	public static Direction getPlayerDirection() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			System.out.println("あっちむいて、、、");
			System.out.println("UP,DOWN,LEFT,RIGHTから選択してください");

			try {
				String input = reader.readLine();
				logger.info("ユーザー入力: " + input);

				if (input == null || input.trim().isEmpty()) {
					System.err.println("入力が空です。もう一度入力してください。");
					logger.warning("空の入力がありました");
					continue;
				}

				Direction direction = Direction.fromString(input);
				logger.info("プレイヤーの選択: " + direction);
				System.out.println("\nほい！");
				return direction;

			} catch (IllegalArgumentException e) {
				System.err.println("\n正しい文字を入力してください。（UP,DOWN,LEFT,RIGHT)");
				logger.warning("不正な入力: " + e.getMessage());
			} catch (IOException e) {
				System.err.println("\n入力エラーが発生しました。もう一度試してください。");
				logger.severe("入力エラー: " + e.getMessage());
			}
		}
	}
}
