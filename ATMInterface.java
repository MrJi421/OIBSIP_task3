import javax.swing.*;

public class ATMInterface {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            
            public void run() {
                
                JFrame frame = new LoginFrame();
                frame.setTitle("ATM Login");
                frame.setSize(300, 200);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximize the window automatically
            }
        });
    }
}
