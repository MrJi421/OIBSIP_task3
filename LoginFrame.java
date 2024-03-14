import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    private JTextField userIdField;
    private JPasswordField pinField;

    public LoginFrame() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);
        panel.setBackground(new Color(240, 240, 240));

        JLabel userIdLabel = new JLabel("User ID:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(userIdLabel, constraints);

        userIdField = new JTextField(25);
        constraints.gridx = 1;
        constraints.gridy = 0;
        panel.add(userIdField, constraints);

        JLabel pinLabel = new JLabel("PIN:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(pinLabel, constraints);

        pinField = new JPasswordField(25);
        constraints.gridx = 1;
        constraints.gridy = 1;
        panel.add(pinField, constraints);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userId = userIdField.getText();
                String pin = new String(pinField.getPassword());
                // Add logic to validate user id and pin
                // For demonstration, let's just show the main menu after login
                dispose();
                JFrame mainMenuFrame = new MainMenuFrame();
                mainMenuFrame.setTitle("ATM Main Menu");
                mainMenuFrame.setSize(400, 300);
                mainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                mainMenuFrame.setLocationRelativeTo(null);
                mainMenuFrame.setVisible(true);
            }
        });
        constraints.gridx = 1;
        constraints.gridy = 2;
        panel.add(loginButton, constraints);

        add(panel);
    }
}
