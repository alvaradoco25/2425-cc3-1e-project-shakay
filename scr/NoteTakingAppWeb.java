import javax.swing.*;
import java.awt.*;

public class LoginWindow extends JFrame {
    public LoginWindow() {
        setTitle("My First Login");
        setSize(450, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        // Labels and Fields
        JLabel signinLabel = new JLabel("SignIn");
        JTextField signinField = new JTextField(15); // Corrected from JLabelField to JTextField

        JLabel signupLabel = new JLabel("SignUp");
        JTextField signupField = new JTextField(15); // Corrected from JtextField to JTextField

        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField(15);

        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(15);

        // Buttons
        JButton signInButton = new JButton("SignIn");
        JButton signUpButton = new JButton("SignUp");

        // SignIn button action
        signInButton.addActionListener(e -> {
            String signin = signinField.getText();
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());
            JOptionPane.showMessageDialog(this, "SignIn\nEmail: " + email + "\nPassword: " + password);
        });

        // SignUp button action
        signUpButton.addActionListener(e -> {
            String signup = signupField.getText();
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());
            JOptionPane.showMessageDialog(this, "SignUp\nEmail: " + email + "\nPassword: " + password);
        });

        // GridBagConstraints setup
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);  // Spacing between components

        // SignIn Label and Field
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(signinLabel, gbc);

        gbc.gridx = 1;
        add(signinField, gbc);

        // Email Label and Field
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(emailLabel, gbc);

        gbc.gridx = 1;
        add(emailField, gbc);

        // Password Label and Field
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(passwordLabel, gbc);

        gbc.gridx = 1;
        add(passwordField, gbc);

        // SignIn Button
        gbc.gridx = 1;
        gbc.gridy = 3;
        add(signInButton, gbc);

        // SignUp Button
        gbc.gridx = 1;
        gbc.gridy = 4;
        add(signUpButton, gbc);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginWindow login = new LoginWindow();
            login.setVisible(true);
        });
    }
}
