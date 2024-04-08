import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HospitalLoginGUI extends JFrame implements ActionListener {
    private JTextField usernameField;
    private JTextField passwordField;
    private JButton loginButton;

    public HospitalLoginGUI() {
        // Set window title
        setTitle("Hospital Management System - Login");

        // Create components
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Login");

        // Set layout
        setLayout(new BorderLayout());
        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.add(usernameLabel);
        inputPanel.add(usernameField);
        inputPanel.add(passwordLabel);
        inputPanel.add(passwordField);

        // Add components to the frame
        add(inputPanel, BorderLayout.CENTER);
        add(loginButton, BorderLayout.SOUTH);

        // Set action command and action listener for the login button
        loginButton.setActionCommand("login");
        loginButton.addActionListener(this);

        // Set default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set frame size and make it visible
        setSize(300, 150);
        setLocationRelativeTo(null); // Center the window on the screen
        setVisible(true);
    }

    // ActionListener implementation
    public void actionPerformed(ActionEvent e) {
        if ("login".equals(e.getActionCommand())) {
            String username = usernameField.getText();
            String password = new String(passwordField.getText());

            // Check username and password (dummy check for demonstration)
            if (username.equals("admin") && password.equals("admin123")) {
                JOptionPane.showMessageDialog(this, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                // Open main application window or perform other actions here
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Main method to run the GUI
    public static void main(String[] args) {
        // Run the GUI in the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new HospitalLoginGUI();
            }
        });
    }
}
