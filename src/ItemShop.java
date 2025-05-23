import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ItemShop {
  public static void main(String[] args) {
    JFrame frame = new JFrame("道具屋");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 200);
    frame.setLocationRelativeTo(null);

    JPanel panel = new JPanel();

    // アイテム一覧
    String[] items = {"やくそう", "どくけしそう", "まほうのせいすい","せいなるナイフ"};
    
    //在庫
    int[] stock = {3, 2, 1, 1}; 
    
    ArrayList<String> history = new ArrayList<>();

    // ★ 案内ラベルと一覧ラベルの追加
    JLabel messageLabel = new JLabel("アイテムどれが欲しいですか？");
    StringBuilder itemList = new StringBuilder("<html>");
    for (int i = 0; i < items.length; i++) {
      itemList.append(i).append(": ").append(items[i]).append("<br>");
    }
    itemList.append("</html>");
    JLabel itemListLabel = new JLabel(itemList.toString());

    JLabel label = new JLabel("アイテム番号を入力:");
    JTextField input = new JTextField(5);
    JButton button = new JButton("購入する");
    JLabel resultLabel = new JLabel("ここにメッセージが表示されます");

 // ② 購入ボタン処理の中身を書き換える
    button.addActionListener(e -> {
      try {
        int index = Integer.parseInt(input.getText());

        // 配列範囲チェック（手前でやる）
        if (index < 0 || index >= items.length) {
          throw new ArrayIndexOutOfBoundsException();
        }

        if (stock[index] <= 0) {
          resultLabel.setText("「" + items[index] + "」は売り切れです！");
          return;
        }

        // 正常購入
        stock[index]--;
        resultLabel.setText("「" + items[index] + "」を購入しました！ 残り：" + stock[index] + "個");
        history.add(items[index]); //

      } catch (ArrayIndexOutOfBoundsException ex) {
        JOptionPane.showMessageDialog(frame, "その番号のアイテムは売っていません！", "エラー",
            JOptionPane.ERROR_MESSAGE);
      } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(frame, "番号を半角数字で入力してください！", "入力エラー",
            JOptionPane.ERROR_MESSAGE);
      } catch (Exception ex) {
        JOptionPane.showMessageDialog(frame,
            "想定外のエラーが発生しました。\n" + ex.toString(),
            "予期しないエラー",
            JOptionPane.ERROR_MESSAGE);
      }
    });
    
    JButton historyButton = new JButton("履歴を見る");
    historyButton.addActionListener(e -> {
        if (history.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "まだ購入履歴がありません。");
        } else {
            StringBuilder sb = new StringBuilder("購入履歴：\n");
            for (String item : history) {
                sb.append("- ").append(item).append("\n");
            }
            JOptionPane.showMessageDialog(frame, sb.toString());
        }
    });
    

    // パネルに部品を追加
    panel.add(messageLabel);
    panel.add(itemListLabel);
    panel.add(label);
    panel.add(input);
    panel.add(button);
    panel.add(historyButton);
    panel.add(resultLabel);

    frame.add(panel);
    frame.setVisible(true);
  }
}
