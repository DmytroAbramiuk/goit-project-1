package UserInterface;

import Computer.Computer;
import ListOfCities.ListOfCities;
import Player.Player;
import Player.WordValidator;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GamePanel extends JPanel {
    private final Player player;
    private final Computer computer;
    private JPanel computerPanel;
    private JPanel userPanel;
    private JTextField userTextField;
    private JButton stepButton;
    private BufferedImage backgroundImage;
    JButton surrenderButton;
    JLabel computerLabel;

    public GamePanel(String username) {
        this.player = new Player(username);
        this.computer = new Computer();
        initialize();
    }

    private void initialize() {
        this.setPreferredSize(new Dimension(SizesOfComponents.PANEL_WIDTH, SizesOfComponents.PANEL_HEIGHT));
        this.setLayout(null);

        LogoCreator.createCitiesLogo(this);
        createBackground();
        createComputerPanel();
        createUserPanel();

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

    private void createComputerPanel() {
        computerPanel = new JPanel();
        computerPanel.setBounds(0, SizesOfComponents.PANEL_HEIGHT / 2 - 70, 400, 40);
        computerPanel.setBackground(Color.black);
        computerPanel.setLayout(new FlowLayout());

        createComputerLabel();

        this.add(computerPanel);
    }

    private void createComputerLabel() {
        computerLabel = new JLabel("Computer:");
        computerLabel.setFont(FontCreator.makeFont(20));
        computerLabel.setForeground(DefaultColors.backgroundColor);

        computerPanel.add(computerLabel);
    }

    private void createUserPanel() {
        userPanel = new JPanel();
        userPanel.setBounds(20, SizesOfComponents.PANEL_HEIGHT / 2 - 30, 360, 80);
        userPanel.setOpaque(false);
        userPanel.setLayout(new FlowLayout());
        userPanel.setOpaque(false);

        createUserTextField();
        createStepButton();
        createSurrenderButton();

        this.add(userPanel);
    }

    private void createUserTextField() {
        userTextField = new JTextField("");
        userTextField.setPreferredSize(new Dimension(SizesOfComponents.USER_TEXT_FIELD_WIDTH,
                SizesOfComponents.USER_GAME_COMPONENTS_HEIGHT));
        userTextField.setFont(FontCreator.makeFont(20));
        userTextField.setBorder(new LineBorder(DefaultColors.backgroundColor));
        userTextField.setBackground(Color.black);
        userTextField.setForeground(DefaultColors.backgroundColor);

        userTextField.addActionListener(e -> repaint());

        userPanel.add(userTextField);
    }

    private void createStepButton() {
        stepButton = new JButton();
        stepButton.setPreferredSize(new Dimension(SizesOfComponents.USER_STEP_BUTTON_WIDTH,
                SizesOfComponents.USER_GAME_COMPONENTS_HEIGHT));
        stepButton.setBorder(new ButtonStyle(50, "STEP"));
        stepButton.setBackground(DefaultColors.transparent);
        stepButton.setForeground(DefaultColors.backgroundColor);

        eventListenerForStepButton();

        userPanel.add(stepButton);
    }

    private void createSurrenderButton() {
        surrenderButton = new JButton("Surrender");
        surrenderButton.setPreferredSize(new Dimension(150, SizesOfComponents.USER_GAME_COMPONENTS_HEIGHT));
        surrenderButton.setFont(FontCreator.makeFont(20));
        surrenderButton.setBorder(new ButtonStyle(50, "Surrender"));
        surrenderButton.setBackground(DefaultColors.transparent);
        surrenderButton.setForeground(DefaultColors.backgroundColor);

        eventListenerForSurrenderButton();

        userPanel.add(surrenderButton);
    }

    private void eventListenerForSurrenderButton() {
        surrenderButton.addActionListener(e -> {
            player.setStatus("Loose");
            replacePanel();
            ShadowRemover.removeShadow(surrenderButton);
            JOptionPane.showMessageDialog(this, "Game was ended!");
        });

        surrenderButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                ShadowRemover.removeShadow(surrenderButton);
            }
        });
    }

    private void eventListenerForStepButton() {
        stepButton.addActionListener(e -> {
            if (userTextField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "You should type city to continue");
            } else {
                processingCities();
            }
            ShadowRemover.removeShadow(stepButton);
        });

        stepButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                ShadowRemover.removeShadow(stepButton);
            }
        });
    }

    private void processingCities() {
        String playerCity = userTextField.getText().toLowerCase();

        if (isCityAllowed(playerCity)) {
            correctPlayerStep(playerCity);
            computerStep(playerCity);
        } else {
            JOptionPane.showMessageDialog(this, "Your city does not exist!!!");
        }
    }

    private void computerStep(String playerCity) {
        String computerCity;

        computerCity = computer.getNewCity(playerCity);
        if (computerCity == null) {
            JOptionPane.showMessageDialog(this, "Game was ended!");
            player.setStatus("Won!");
            replacePanel();
            return;
        }
        computerLabel.setText("Computer: " + convertFirstLetterInCity(computerCity));
        computer.saveComputerCity(convertFirstLetterInCity(computerCity));
    }

    private String convertFirstLetterInCity(String computerCity) {
        return ("" + computerCity.charAt(0)).toUpperCase() + computerCity.substring(1);
    }

    private void correctPlayerStep(String playerCity) {
        player.increaseScore();
        player.savePlayerCity(convertFirstLetterInCity(playerCity));
        ListOfCities.usedCities.add(playerCity);
        userTextField.setText("");
    }

    private boolean isCityAllowed(String playerCity) {
        if (ListOfCities.usedCities.isEmpty()) {
            return WordValidator.firstStepValidate(playerCity);
        } else {
            return WordValidator.validate(playerCity, computer.getCurrentCity());
        }
    }


    private void replacePanel() {
        Container container = getRootPane().getContentPane();
        container.setFocusable(false);
        container.removeAll();

        EndPanel endPanel = new EndPanel(player, computer);
        container.add(endPanel);

        endPanel.requestFocusInWindow();

        container.revalidate();
        container.repaint();
    }
}
