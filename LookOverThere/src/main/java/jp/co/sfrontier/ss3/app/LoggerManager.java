package jp.co.sfrontier.ss3.app;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * ログを生成するためのクラス
 */
public class LoggerManager {
	/**
	 * 指定されたクラスに対応する Logger を作成し、ログをgame.logに出力できるようにする
	 * @param clazz ログを関連付けたいクラス
	 * @return ロガーを返す
	 */
	public static Logger createLogger(Class<?> clazz) {
		Logger logger = Logger.getLogger(clazz.getName());
		try {
			FileHandler fh = new FileHandler("game.log", true);
			fh.setFormatter(new SimpleFormatter());
			logger.addHandler(fh);
			logger.setLevel(Level.ALL);
		} catch (IOException e) {
			System.err.println("ログファイルの初期化に失敗しました: " + e.getMessage());
		}
		return logger;
	}
}
