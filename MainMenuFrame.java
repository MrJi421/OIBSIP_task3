import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuFrame extends JFrame {
    private double balance = 0.0; // Initialize balance to 0.0

    public MainMenuFrame() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);
        panel.setBackground(new Color(240, 240, 240));
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximize the window automatically

        JButton transactionsButton = new JButton("Transactions History");
        transactionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TransactionsHistoryFrame historyFrame = new TransactionsHistoryFrame();
                historyFrame.setVisible(true);
            }
        });
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(transactionsButton, constraints);


        // Withdraw Button
        JButton withdrawButton = new JButton("Withdraw Money");
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WithdrawFrame withdrawFrame = new WithdrawFrame(balance);
                withdrawFrame.setVisible(true);
            }
        });
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(withdrawButton, constraints);

        // Deposit Button
        JButton depositButton = new JButton("Deposit Money");
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DepositFrame depositFrame = new DepositFrame(balance);
                depositFrame.setVisible(true);
            }
        });
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(depositButton, constraints);

        // Transfer Button
        JButton transferButton = new JButton("Transfer Money");
        transferButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TransferFrame transferFrame = new TransferFrame();
                transferFrame.setVisible(true);
            }
        });
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(transferButton, constraints);

        JButton quitButton = new JButton("Logout");
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //LoginFrame loginframe = new LoginFrame();
                //loginframe.setVisible(true);
                dispose();
            }
        });
        constraints.gridx = 0;
        constraints.gridy = 4;
        panel.add(quitButton, constraints);

        add(panel);
    }
}
