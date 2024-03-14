import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransactionsHistoryFrame extends JFrame {
    public TransactionsHistoryFrame() {
        setTitle("Transactions History");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximize the window automatically

        // Simulated transaction history data
        String[] transactions = {
                "1. January 1, 2024 - Withdraw $100",
                "2. January 2, 2024 - Deposit $500"
                // Add more transaction history data as needed
        };

        JPanel panel = new JPanel(new BorderLayout());
        JTextArea textArea = new JTextArea(10, 30);
        textArea.setEditable(false);

        // Populate the text area with transaction history data
        StringBuilder sb = new StringBuilder();
        for (String transaction : transactions) {
            sb.append(transaction).append("\n");
        }
        textArea.setText(sb.toString());

        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        add(panel);
    }
}
