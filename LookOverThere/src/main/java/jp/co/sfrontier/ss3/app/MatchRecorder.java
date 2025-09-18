package jp.co.sfrontier.ss3.app;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 対戦結果を記録するためのクラス
 */
public class MatchRecorder {
    private static final String FILE_NAME = "match_history.txt";

    /**
     * 対戦結果をファイルに記録する
     * @param player プレイヤーの選択した方向
     * @param computer コンピュータの選択した方向
     * @param isWin 勝敗（true: 勝ち, false: 負け）
     */
    public static void record(Direction player, Direction computer, boolean isWin) {
        String result = isWin ? "Win" : "Lose";
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String line = String.format("%s あなた: %s 相手: %s 結果: %s%n", timestamp, player, computer, result);

        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            writer.write(line);
        } catch (IOException e) {
            System.err.println("対戦記録の保存に失敗しました: " + e.getMessage());
        }
    }
}
