import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WithdrawFrame extends JFrame {
    private JTextField amountField;
    private final double initialBalance; // Declare balance as final

    public WithdrawFrame(final double balance) { // Add final keyword before balance
        this.initialBalance = balance;

        setTitle("Withdraw Money");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximize the window automatically

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);

        JLabel amountLabel = new JLabel("Enter the amount to withdraw:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(amountLabel, constraints);

        amountField = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 0;
        panel.add(amountField, constraints);

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String amountString = amountField.getText();
                if (!amountString.isEmpty()) {
                    try {
                        double amount = Double.parseDouble(amountString);
                        if (amount <= 0) {
                            JOptionPane.showMessageDialog(null, "Invalid amount. Please enter a positive number.", "Error", JOptionPane.ERROR_MESSAGE);
                        } else if (amount > initialBalance) {
                            JOptionPane.showMessageDialog(null, "Insufficient funds.", "Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            double newBalance = initialBalance - amount; // Create a new variable to hold updated balance
                            JOptionPane.showMessageDialog(null, "Withdrawal successful. Remaining balance: $" + newBalance);
                            dispose(); // Close the withdraw frame
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter an amount.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        panel.add(withdrawButton, constraints);

        add(panel);
    }
}
