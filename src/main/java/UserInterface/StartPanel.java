package UserInterface;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class StartPanel extends JPanel {

    private JTextField usernameField;
    private JPanel startPanel;
    private JButton startButton;
    private BufferedImage backgroundImage;

    public StartPanel() {
        initialize();
    }

    private void initialize() {
        this.setPreferredSize(new Dimension(SizesOfComponents.PANEL_WIDTH,
                SizesOfComponents.PANEL_HEIGHT));
        this.setLayout(null);

        createBackground();
        LogoCreator.createCitiesLogo(this);
        createStartPanel();

        this.setVisible(true);
    }

    private void createBackground() {
        try {
            backgroundImage = ImageIO.read(new File("src/main/java/Files/background.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    private void createStartPanel() {
        startPanel = new JPanel();
        startPanel.setBounds(0,
                SizesOfComponents.PANEL_HEIGHT / 4,
                400,
                SizesOfComponents.PANEL_HEIGHT - SizesOfComponents.PANEL_HEIGHT / 4);
        startPanel.setOpaque(false);
        startPanel.setLayout(new FlowLayout());

        createUsernameLabel();
        createUsernameField();
        createStartButton();

        this.add(startPanel);
    }

    private void createStartButton() {
        startButton = new JButton();
        startButton.setPreferredSize(new Dimension(SizesOfComponents.START_BUTTON_WIDTH,
                SizesOfComponents.START_BUTTON_HEIGHT));
        startButton.setFont(FontCreator.makeFont(12));
        startButton.setBorder(new ButtonStyle(50, "START"));
        startButton.setBackground(DefaultColors.transparent);
        startButton.setForeground(DefaultColors.backgroundColor);

        eventListenerForStartButton();

        startPanel.add(startButton);
    }

    private void eventListenerForStartButton() {
        startButton.addActionListener(e -> {
            if (usernameField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Put your username to start game");
            } else {
                replacePanel();
            }
            ShadowRemover.removeShadow(startButton);
        });

        startButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                ShadowRemover.removeShadow(startButton);
            }
        });
    }

    private void createUsernameLabel() {
        JLabel userNameLabel = new JLabel("Your username:");
        userNameLabel.setFont(FontCreator.makeFont(20));

        startPanel.add(userNameLabel);
    }

    private void createUsernameField() {
        usernameField = new JTextField();
        usernameField.setFont(FontCreator.makeFont(20));
        usernameField.setPreferredSize(new Dimension(SizesOfComponents.USERNAME_FIELD_WIDTH,
                SizesOfComponents.USERNAME_FIELD_HEIGHT));
        usernameField.setBorder(new LineBorder(DefaultColors.backgroundColor));
        usernameField.setBackground(Color.black);
        usernameField.setForeground(DefaultColors.backgroundColor);

        usernameField.addActionListener(e -> repaint());

        startPanel.add(usernameField);
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