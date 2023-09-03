package UserInterface;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class StartPanel extends JPanel {

    private JTextField usernameField;
    private JPanel startPanel;
    private JButton startButton;
    private JButton difficultyButton;
    private int difficultyIndex = 0;
    private final List<String> difficulties;

    public StartPanel() {
        this.difficulties = new ArrayList<>();
        difficulties.add("EASY");
        difficulties.add("MEDIUM");
        difficulties.add("HARD");
        difficulties.add("INSANE");
        initialize();
    }

    private void initialize() {
        this.setPreferredSize(new Dimension(SizesOfComponents.PANEL_WIDTH,
                SizesOfComponents.PANEL_HEIGHT));
        this.setLayout(null);

        LogoCreator.createCitiesLogo(this);
        createStartPanel();

        this.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (BackgroundImageCreator.createBackground() != null) {
            g.drawImage(BackgroundImageCreator.createBackground(), 0, 0, getWidth(), getHeight(), this);
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
        createDifficultyButton();

        this.add(startPanel);
    }

    private void createStartButton() {
        startButton = new JButton();
        startButton.setPreferredSize(new Dimension(SizesOfComponents.START_PANEL_BUTTON_WIDTH,
                SizesOfComponents.START_PANEL_BUTTON_HEIGHT));
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

    private void createDifficultyButton() {
        difficultyButton = new JButton();
        difficultyButton.setPreferredSize(new Dimension(SizesOfComponents.START_PANEL_BUTTON_WIDTH,
                SizesOfComponents.START_PANEL_BUTTON_HEIGHT));
        difficultyButton.setFont(FontCreator.makeFont(12));
        difficultyButton.setBorder(new ButtonStyle(50, "EASY"));
        difficultyButton.setBackground(DefaultColors.transparent);
        difficultyButton.setForeground(DefaultColors.backgroundColor);

        eventListenerForDifficultyButton();

        startPanel.add(difficultyButton);
    }

    private void eventListenerForDifficultyButton() {
        difficultyButton.addActionListener(e -> {
            if (difficultyIndex == 3)
                difficultyIndex = 0;
            else {
                difficultyIndex++;
            }
            difficultyButton.setBorder(new ButtonStyle(50, difficulties.get(difficultyIndex)));

            ShadowRemover.removeShadow(difficultyButton);
        });
        difficultyButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                ShadowRemover.removeShadow(difficultyButton);
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

        GamePanel gamePanel = new GamePanel(usernameField.getText(), difficultyIndex);
        container.add(gamePanel);

        gamePanel.requestFocusInWindow();

        container.revalidate();
        container.repaint();
    }
}