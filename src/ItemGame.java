import java.awt.BorderLayout;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class ItemGame extends JFrame {

  // アイテム名と効果値の対応表
  private HashMap<String, Integer> itemMap = new HashMap<>();
  
  private HashMap<String, Integer> usageCount = new HashMap<>();

  // 使用履歴（順番付き）
  private LinkedList<String> history = new LinkedList<>();

  // 表示用テキストエリア
  private JTextArea logArea;

  public ItemGame() {
    setTitle("アイテム使用ゲーム");
    setSize(400, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());

    // アイテムを初期登録
    itemMap.put("薬草", 50);
    itemMap.put("爆弾", 100);
    itemMap.put("聖水", 30);
    itemMap.put("エリクサー",200);

    // UI構築
    JPanel topPanel = new JPanel();
    JButton useButton = new JButton("アイテムを使う");
    JButton undoButton = new JButton("取り消す");
    JButton showHistoryButton = new JButton("履歴をすべて表示");
    JButton showUsageCountButton = new JButton("使用回数を表示");

    topPanel.add(useButton);
    topPanel.add(undoButton);
    topPanel.add(showHistoryButton);
    topPanel.add(showUsageCountButton);
    add(topPanel, BorderLayout.NORTH);
    

    logArea = new JTextArea();
    logArea.setEditable(false);
    add(new JScrollPane(logArea), BorderLayout.CENTER);

    // イベント：アイテムを使う
    useButton.addActionListener(e -> {
      Object[] itemNames = itemMap.keySet().toArray();
      String selected = (String) JOptionPane.showInputDialog(this, "使うアイテムを選んでください：", "アイテム選択",
          JOptionPane.PLAIN_MESSAGE, null, itemNames, itemNames[0]);
      if (selected != null && itemMap.containsKey(selected)) {
        int effect = itemMap.get(selected);
        history.add(selected);
        logArea.append(selected + " を使った（効果値：" + effect + "）\n");
        usageCount.put(selected, usageCount.getOrDefault(selected, 0) + 1);
      }
    });

    // イベント：最後の操作を取り消す
    undoButton.addActionListener(e -> {
      if (!history.isEmpty()) {
        String last = history.removeLast();
        logArea.append("取り消した操作: " + last + "\n");
        usageCount.put(last, Math.max(0, usageCount.getOrDefault(last, 1) - 1));
      } else {
        logArea.append("取り消す操作がありません。\n");
        
      }
      
    });
    
    showHistoryButton.addActionListener(e -> {
        if (history.isEmpty()) {
          JOptionPane.showMessageDialog(this, "履歴はまだありません。", "履歴", JOptionPane.INFORMATION_MESSAGE);
        } else {
          StringBuilder sb = new StringBuilder("◆ 使用履歴一覧：\n");
          for (String item : history) {
            sb.append("- ").append(item).append("\n");
          }
          JOptionPane.showMessageDialog(this, sb.toString(), "履歴", JOptionPane.INFORMATION_MESSAGE);
        }
      });
    
    showUsageCountButton.addActionListener(e -> {
        StringBuilder sb = new StringBuilder("◆ 使用回数一覧：\n");
        for (String item : itemMap.keySet()) {
          int count = usageCount.getOrDefault(item, 0);
          sb.append(item).append("：").append(count).append("回\n");
        }
        JOptionPane.showMessageDialog(this, sb.toString(), "使用回数", JOptionPane.INFORMATION_MESSAGE);
      });
    }
  

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      ItemGame game = new ItemGame();
      game.setVisible(true);
    });
  }
}
