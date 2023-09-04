package UserInterface;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import SizesAndColoursOfComponents.*;
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
        this.setPreferredSize(new Dimension(SizesOfComponents.PANEL_WIDTH.getValue(),
                SizesOfComponents.PANEL_HEIGHT.getValue()));
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
                SizesOfComponents.PANEL_HEIGHT.getValue() / 4,
                400,
                SizesOfComponents.PANEL_HEIGHT.getValue() - SizesOfComponents.PANEL_HEIGHT.getValue() / 4);
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
        startButton.setPreferredSize(new Dimension(SizesOfComponents.START_PANEL_BUTTON_WIDTH.getValue(),
                SizesOfComponents.START_PANEL_BUTTON_HEIGHT.getValue()));
        startButton.setFont(FontCreator.makeFont(12));
        startButton.setBorder(new ButtonStyle(50, "START"));
        startButton.setBackground(DefaultColorsOfComponents.TRANSPARENTCOLOR.getColor());
        startButton.setForeground(DefaultColorsOfComponents.BACKGROUNDCOLOR.getColor());

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
        difficultyButton.setPreferredSize(new Dimension(SizesOfComponents.START_PANEL_BUTTON_WIDTH.getValue(),
                SizesOfComponents.START_PANEL_BUTTON_HEIGHT.getValue()));
        difficultyButton.setFont(FontCreator.makeFont(12));
        difficultyButton.setBorder(new ButtonStyle(50, "EASY"));
        difficultyButton.setBackground(DefaultColorsOfComponents.TRANSPARENTCOLOR.getColor());
        difficultyButton.setForeground(DefaultColorsOfComponents.BACKGROUNDCOLOR.getColor());

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
        usernameField.setPreferredSize(new Dimension(SizesOfComponents.USERNAME_FIELD_WIDTH.getValue(),
                SizesOfComponents.USERNAME_FIELD_HEIGHT.getValue()));
        usernameField.setBorder(new LineBorder(DefaultColorsOfComponents.BACKGROUNDCOLOR.getColor()));
        usernameField.setBackground(Color.black);
        usernameField.setForeground(DefaultColorsOfComponents.BACKGROUNDCOLOR.getColor());

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