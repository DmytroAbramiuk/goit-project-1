package UserInterface;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class StartPanel extends JPanel {

    private JTextField usernameField;
    private JPanel gameplayPanel;
    private JButton startButton;

    public StartPanel() {
        initialize();
    }

    private void initialize() {
        this.setPreferredSize(new Dimension(SizesOfComponents.PANEL_WIDTH,
                SizesOfComponents.PANEL_HEIGHT));
        this.setLayout(null);

        LogoCreator.createCitiesLogo(this);
        createGameplayPanel();

        this.setVisible(true);
    }

    private void createGameplayPanel() {
        gameplayPanel = new JPanel();
        gameplayPanel.setBounds(0,
                SizesOfComponents.PANEL_HEIGHT / 4,
                400,
                SizesOfComponents.PANEL_HEIGHT - SizesOfComponents.PANEL_HEIGHT / 4);
        gameplayPanel.setLayout(new FlowLayout());

        createUsernameLabel();
        createUsernameField();
        createStartButton();

        this.add(gameplayPanel);
    }

    private void createStartButton() {
        startButton = new JButton("START GAME");
        startButton.setPreferredSize(new Dimension(SizesOfComponents.START_BUTTON_WIDTH,
                SizesOfComponents.START_BUTTON_HEIGHT));
        startButton.setFont(FontCreator.makeFont(12));
        startButton.setBorder(new LineBorder(Color.BLACK));

        eventListenerForStartButton();

        gameplayPanel.add(startButton);
    }

    private void createUsernameLabel() {
        JLabel userNameLabel = new JLabel("Put your username:");
        userNameLabel.setFont(FontCreator.makeFont(15));

        gameplayPanel.add(userNameLabel);
    }

    private void createUsernameField() {
        usernameField = new JTextField();
        usernameField.setFont(FontCreator.makeFont(15));
        usernameField.setPreferredSize(new Dimension(SizesOfComponents.USERNAME_FIELD_WIDTH,
                SizesOfComponents.USERNAME_FIELD_HEIGHT));

        gameplayPanel.add(usernameField);
    }



    private void eventListenerForStartButton() {
        startButton.addActionListener(e -> {
            if (usernameField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Put your username to start game");
            } else {
                replacePanel();
            }
        });
    }

    private void replacePanel() {
        Container container = getRootPane().getContentPane();
        container.setFocusable(false);
        container.removeAll();

        GamePanel gamePanel = new GamePanel(usernameField.getText());
        container.add(gamePanel);

        gamePanel.requestFocusInWindow();

        container.revalidate();
        container.repaint();
    }
}
