package jp.co.sfrontier.ss3.app;

/**
 * 方向を定義するためのクラス
 */
public enum Direction {
	UP, DOWN, LEFT, RIGHT;
	/**
	 * プレイヤーが入力した文字列をDirection 列挙型の定数に変換する。
	 * @param input
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static Direction fromString(String input) throws IllegalArgumentException {
		return Direction.valueOf(input.trim().toUpperCase());
	}
}
