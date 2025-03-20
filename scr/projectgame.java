import javax.swing.*;
import java.awt.*;

public class WindowOptions extends JFrame {
    public WindowOptions() {
        setTitle("My First Window");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        JButton hideButton = new JButton("Hide");
        JButton minimizeButton = new JButton("Minimize");
        JButton exitButton = new JButton("Exit");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(hideButton, gbc);

        gbc.gridx = 1;
        add(minimizeButton, gbc);

        gbc.gridx = 2;
        add(exitButton, gbc);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            WindowOptions window = new WindowOptions();
            window.setVisible(true);
        });
    }
}
