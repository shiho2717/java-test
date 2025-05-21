package swingdemo;
import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class HelloSwing {
    public static void main(String[] args) {
        // GUIの作成はイベントディスパッチスレッドで行う
        SwingUtilities.invokeLater(() -> {
            // フレーム（ウィンドウ）作成
            JFrame frame = new JFrame("Swingの例");

            // ラベルに文字列を設定
            JLabel label = new JLabel("ようこそ、Javaの世界へ", JLabel.CENTER);

            label.setFont(new Font("Serif", Font.PLAIN, 30)); 
            // フレームにラベルを追加
            frame.add(label);

            // フレームのサイズを設定
            frame.setSize(400, 200);

            // 閉じるボタンでアプリ終了
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // ウィンドウを画面中央に表示
            frame.setLocationRelativeTo(null);

            // 表示
            frame.setVisible(true);
            
            JButton button = new JButton();
            frame.add(button, BorderLayout.SOUTH);

            button.addActionListener(e -> {
                label.setText("ok");
            });

            frame.setVisible(true);
        });
    }
}