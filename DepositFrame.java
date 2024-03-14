import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DepositFrame extends JFrame {
    private JTextField amountField;
    private double balance;

    public DepositFrame(double balance) {
        this.balance = balance;

        setTitle("Deposit Money");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximize the window automatically

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);

        JLabel amountLabel = new JLabel("Enter the amount to deposit:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(amountLabel, constraints);

        amountField = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 0;
        panel.add(amountField, constraints);

        JButton depositButton = new JButton("Deposit");
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                depositAmount();
            }
        });
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        panel.add(depositButton, constraints);

        add(panel);
    }

    private void depositAmount() {
        String amountString = amountField.getText();
        if (!amountString.isEmpty()) {
            try {
                double amount = Double.parseDouble(amountString);
                if (amount <= 0) {
                    JOptionPane.showMessageDialog(null, "Invalid amount. Please enter a positive number.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    balance += amount;
                    JOptionPane.showMessageDialog(null, "Deposit successful. Current balance: $" + balance);
                    dispose(); // Close the deposit frame
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please enter an amount.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
