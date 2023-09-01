package UserInterface;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    ImageIcon icon;

    public MainFrame() {
        icon = new ImageIcon("src/main/java/Files/Icon.png");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Cities");
        this.setIconImage(icon.getImage());

        StartPanel startPanel = new StartPanel();
        this.add(startPanel, BorderLayout.CENTER);

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
