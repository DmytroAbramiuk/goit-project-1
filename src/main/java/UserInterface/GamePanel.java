package UserInterface;

import Computer.Computer;
import ListOfCities.ListOfCities;
import Player.Player;
import Player.WordValidator;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class GamePanel extends JPanel {
    Player player;
    Computer computer;
    JPanel computerPanel;
    JPanel userPanel;
    JTextField userTextField;
    JButton stepButton;
    JButton surrenderButton;
    JLabel computerLabel;
    JLabel cityFromComputerLabel;


    public GamePanel(String username) {
        this.player = new Player(username);
        this.computer = new Computer();
        initialize();
    }

    private void initialize() {
        this.setPreferredSize(new Dimension(SizesOfComponents.PANEL_WIDTH, SizesOfComponents.PANEL_HEIGHT));
        this.setLayout(null);

        LogoCreator.createCitiesLogo(this);
        createComputerPanel();
        createUserPanel();
        createSurrenderButton();

        this.setVisible(true);
    }

    private void createComputerPanel() {
        computerPanel = new JPanel();
        computerPanel.setBounds(0, SizesOfComponents.PANEL_HEIGHT / 2 - 70, 400, 40);
        computerPanel.setLayout(new FlowLayout());
        computerPanel.setOpaque(false);

        createComputerLabel();
        createCityFromComputerLabel();

        this.add(computerPanel);
    }

    private void createComputerLabel() {
        computerLabel = new JLabel("Computer:");
        computerLabel.setFont(FontCreator.makeFont(20));

        computerPanel.add(computerLabel);
    }

    private void createCityFromComputerLabel() {
        cityFromComputerLabel = new JLabel();
        cityFromComputerLabel.setFont(FontCreator.makeFont(20));

        computerPanel.add(cityFromComputerLabel);
    }

    private void createUserPanel() {
        userPanel = new JPanel();
        userPanel.setBounds(20, SizesOfComponents.PANEL_HEIGHT / 2 - 30, 360, 40);
        userPanel.setLayout(new GridLayout());
        userPanel.setOpaque(false);

        createUserTextField();
        createStepButton();

        this.add(userPanel);
    }

    private void createSurrenderButton() {
        JButton surrenderButton = new JButton("Surrender");
        surrenderButton.setFont(FontCreator.makeFont(20));
        surrenderButton.setBorder(new LineBorder(Color.BLACK));

        surrenderButton.addActionListener(e -> {
            player.setStatus("Loose");
            replacePanel();
            JOptionPane.showMessageDialog(this, "Game Over!");
        });

        userPanel.add(surrenderButton);
    }

    private void createUserTextField() {
        userTextField = new JTextField("");
        userTextField.setFont(FontCreator.makeFont(20));
        userTextField.setBorder(new LineBorder(Color.BLACK));

        userPanel.add(userTextField);
    }

    private void createStepButton() {
        stepButton = new JButton("Make Step");
        stepButton.setFont(FontCreator.makeFont(20));
        stepButton.setBorder(new LineBorder(Color.BLACK));

        eventListenerForStepButton();

        userPanel.add(stepButton);
    }

    private void eventListenerForStepButton() {
        stepButton.addActionListener(e -> {
            if (userTextField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "You should type city to continue");
            } else {
                processingCities();
            }
        });
    }

    private void processingCities() {
        String playerCity = userTextField.getText().toLowerCase();

        if (playerCity.equalsIgnoreCase("здаюсь")) {
            JOptionPane.showMessageDialog(this, "Game Over!");
            player.setStatus("Loose");
            replacePanel();
            return;
        }

        if (isCityAllowed(playerCity)) {
            correctPlayerStep(playerCity);
            computerStep(playerCity);
        } else {
            JOptionPane.showMessageDialog(this, "Your city does not exist!!!");
        }
    }

    private void computerStep(String playerCity){
        String computerCity;

        computerCity = computer.getNewCity(playerCity);
        if (computerCity == null) {
            JOptionPane.showMessageDialog(this, "Game over!");
            player.setStatus("Won!");
            replacePanel();
            return;
        }
        cityFromComputerLabel.setText(convertFirstLetterInCity(computerCity));
        computer.saveComputerCity(convertFirstLetterInCity(computerCity));
    }

    private String convertFirstLetterInCity(String computerCity){
        return ("" + computerCity.charAt(0)).toUpperCase() + computerCity.substring(1);
    }

    private void correctPlayerStep(String playerCity){
        player.increaseScore();
        player.savePlayerCity(convertFirstLetterInCity(playerCity));
        ListOfCities.usedCities.add(playerCity);
        userTextField.setText("");
    }

    private boolean isCityAllowed(String playerCity){
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
