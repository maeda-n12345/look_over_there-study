package jp.co.sfrontier.ss3.app;

/**
 * あっちむいてほいゲームのメインクラス
 */
public class Main {
	/**
	 * あっち向いてほいを実行するためのメインメソッド
	 * @param args
	 */
	public static void main(String[] args) {
		GameEngine game = new GameEngine();
		game.play();
	}
}
