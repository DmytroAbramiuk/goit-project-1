package Interface;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class StartPanel extends JPanel {

    private final static int PANEL_WIDTH = 400;
    private final static int PANEL_HEIGHT = 500;
    private final static int START_BUTTON_HEIGHT = 35;
    private final static int START_BUTTON_WIDTH = 130;
    private final static int CITIES_LABEL_HEIGHT = 80;
    private final static int CITIES_LABEL_WIDTH = 200;
    private final static int USERNAME_FIELD_WIDTH = 170;
    private final static int USERNAME_FIELD_HEIGHT = 35;
    private final static int USERNAME_LABEL_WIDTH = 170;
    private final static int USERNAME_LABEL_HEIGHT = 35;

    public StartPanel() {
        initialize();
    }

    private void initialize() {
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setLayout(null);
        this.setBackground(new Color(229, 171, 102, 186));

        createStartButton();
        createCitiesLabel();
        createUsernameTextField();
        createUsernameLabel();

        this.setVisible(true);
    }

    private void createCitiesLabel() {
        Font font = new Font("Arial Black", Font.BOLD, 50);
        JLabel citiesLabel = new JLabel("CITIES");

        citiesLabel.setHorizontalAlignment(SwingConstants.CENTER);

        citiesLabel.setFont(font);
        citiesLabel.setBounds((PANEL_WIDTH / 2) - (CITIES_LABEL_WIDTH / 2),
                10,
                CITIES_LABEL_WIDTH,
                CITIES_LABEL_HEIGHT);

        this.add(citiesLabel);
    }

    private void createStartButton() {
        JButton startButton = new JButton("START GAME");
        Font font = new Font("Arial Black", Font.BOLD, 12);
        startButton.setFont(font);

        startButton.setBounds((PANEL_WIDTH / 2) - (START_BUTTON_WIDTH / 2),
                (PANEL_HEIGHT / 2) - (START_BUTTON_HEIGHT / 2),
                START_BUTTON_WIDTH,
                START_BUTTON_HEIGHT);

        startButton.setBorder(new LineBorder(Color.BLACK));
        startButton.setBackground(new Color(229, 171, 102, 158));

        eventListenerForStartButton(startButton);

        this.add(startButton);
    }

    private void eventListenerForStartButton(JButton startButton){
        startButton.addActionListener(e -> {
            Container container = getRootPane().getContentPane();
            container.setFocusable(false);
            container.removeAll();

            GamePanel gamePanel = new GamePanel();
            container.add(gamePanel);

            gamePanel.requestFocusInWindow();

            validate();
            repaint();

            setVisible(true);
            System.out.println("game was started!!!");
        });
    }

    private void createUsernameLabel() {
        Font font = new Font("Arial Black", Font.BOLD, 15);
        JLabel usernameLabel = new JLabel("Put your username");
        usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);

        usernameLabel.setFont(font);
        usernameLabel.setBounds((PANEL_WIDTH / 2) - (USERNAME_LABEL_WIDTH / 2),
                PANEL_HEIGHT / 2 - (START_BUTTON_HEIGHT + USERNAME_LABEL_HEIGHT + USERNAME_FIELD_HEIGHT) + 10,
                USERNAME_FIELD_WIDTH,
                USERNAME_LABEL_HEIGHT);

        this.add(usernameLabel);
    }

    private void createUsernameTextField() {
        JTextField usernameField = new JTextField();
        usernameField.setBounds((PANEL_WIDTH / 2) - (USERNAME_FIELD_WIDTH / 2),
                (PANEL_HEIGHT / 2) - (USERNAME_FIELD_HEIGHT / 2) - START_BUTTON_HEIGHT - 10,
                USERNAME_FIELD_WIDTH,
                USERNAME_FIELD_HEIGHT);

        Font font = new Font("Arial Black", Font.BOLD, 20);
        usernameField.setFont(font);

        usernameField.setBorder(new LineBorder(Color.BLACK));
        usernameField.setBackground(new Color(229, 171, 102, 158));

        this.add(usernameField);
    }
}
