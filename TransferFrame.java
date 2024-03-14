import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransferFrame extends JFrame {
    private JTextField amountField;
    private JTextField accountNumberField;

    public TransferFrame() {
        setTitle("Transfer Money");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximize the window automatically

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);

        JLabel amountLabel = new JLabel("Amount:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(amountLabel, constraints);

        amountField = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 0;
        panel.add(amountField, constraints);

        JLabel accountNumberLabel = new JLabel("Account Number:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(accountNumberLabel, constraints);

        accountNumberField = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 1;
        panel.add(accountNumberField, constraints);

        JButton transferButton = new JButton("Transfer");
        transferButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get amount and account number from text fields
                double amount = Double.parseDouble(amountField.getText());
                String accountNumber = accountNumberField.getText();
                
                // Check if amount is valid
                if (amount <= 0) {
                    JOptionPane.showMessageDialog(null, "Invalid amount. Please enter a valid amount.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Check if account number is valid (assuming some predefined valid account numbers)
                if (!isValidAccount(accountNumber)) {
                    JOptionPane.showMessageDialog(null, "Invalid account number. Please enter a valid account number.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Perform the transfer
                boolean success = performTransfer(amount, accountNumber);

                // Display appropriate message based on transfer result
                if (success) {
                    JOptionPane.showMessageDialog(null, "Transfer of $" + amount + " to account number " + accountNumber + " successful.");
                    dispose(); // Close the transfer frame
                } else {
                    JOptionPane.showMessageDialog(null, "Transfer failed. Please try again later.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        constraints.gridx = 1;
        constraints.gridy = 2;
        panel.add(transferButton, constraints);

        add(panel);
    }

    private boolean isValidAccount(String accountNumber) {
        // In a real application, you would perform validation against a list of valid account numbers
        // For demonstration purposes, let's assume any account number is valid
        return true;
    }

    private boolean performTransfer(double amount, String accountNumber) {
        // In a real application, you would perform the actual transfer logic (e.g., update balances, log transaction)
        // For demonstration purposes, let's just return true to simulate a successful transfer
        return true;
    }
}
