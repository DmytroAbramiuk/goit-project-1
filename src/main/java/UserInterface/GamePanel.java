package UserInterface;

import Computer.Computer;
import ListOfCities.ListOfCities;
import Player.Player;
import Player.WordValidator;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import SizesAndColoursOfComponents.SizesOfComponents;
import SizesAndColoursOfComponents.DefaultColorsOfComponents;
public class GamePanel extends JPanel {
    private final Player player;
    private final Computer computer;
    private JPanel computerPanel;
    private JPanel userPanel;
    private JTextField userTextField;
    private JButton stepButton;
    private JButton surrenderButton;
    private JLabel computerLabel;

    public GamePanel(String username, int difficulty) {
        this.player = new Player(username);
        this.computer = new Computer(difficulty);
        initialize();
    }

    private void initialize() {
        this.setPreferredSize(new Dimension(SizesOfComponents.DEFAULT_PANEL_WIDTH.getValue(),
                SizesOfComponents.DEFAULT_PANEL_HEIGHT.getValue()));
        this.setLayout(null);

        LogoCreator.createCitiesLogo(this);
        createComputerPanel();
        createUserPanel();

        this.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (BackgroundImageCreator.createBackground() != null) {
            g.drawImage(BackgroundImageCreator.createBackground(), 0, 0, getWidth(), getHeight(), this);
        }
    }

    private void createComputerPanel() {
        computerPanel = new JPanel();
        computerPanel.setBounds(0, SizesOfComponents.DEFAULT_PANEL_HEIGHT.getValue() / 2 - 70,
                SizesOfComponents.DEFAULT_PANEL_WIDTH.getValue(),
                SizesOfComponents.COMPUTER_PANEL_HEIGHT.getValue());
        computerPanel.setBackground(Color.black);
        computerPanel.setLayout(new FlowLayout());

        createComputerLabel();

        this.add(computerPanel);
    }

    private void createComputerLabel() {
        computerLabel = new JLabel("Computer:");
        computerLabel.setFont(FontCreator.makeFont(SizesOfComponents.FONT_SIZE_20.getValue()));
        computerLabel.setForeground(DefaultColorsOfComponents.BACKGROUNDCOLOR.getColor());

        computerPanel.add(computerLabel);
    }

    private void createUserPanel() {
        userPanel = new JPanel();
        userPanel.setBounds(20, SizesOfComponents.DEFAULT_PANEL_HEIGHT.getValue() / 2 - 30,
                SizesOfComponents.USER_PANEL_WIDTH.getValue(),
                SizesOfComponents.USER_PANEL_HEIGHT.getValue());
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
        userTextField.setPreferredSize(new Dimension(SizesOfComponents.USER_TEXT_FIELD_WIDTH.getValue(),
                SizesOfComponents.USER_GAME_COMPONENTS_HEIGHT.getValue()));
        userTextField.setFont(FontCreator.makeFont(SizesOfComponents.FONT_SIZE_20.getValue()));
        userTextField.setBorder(new LineBorder(DefaultColorsOfComponents.BACKGROUNDCOLOR.getColor()));
        userTextField.setBackground(Color.black);
        userTextField.setForeground(DefaultColorsOfComponents.BACKGROUNDCOLOR.getColor());

        userTextField.addActionListener(e -> repaint());

        userPanel.add(userTextField);
    }

    private void createStepButton() {
        stepButton = new JButton();
        stepButton.setPreferredSize(new Dimension(SizesOfComponents.USER_STEP_BUTTON_WIDTH.getValue(),
                SizesOfComponents.USER_GAME_COMPONENTS_HEIGHT.getValue()));
        stepButton.setBorder(new ButtonStyle( "STEP"));
        stepButton.setBackground(DefaultColorsOfComponents.TRANSPARENTCOLOR.getColor());
        stepButton.setForeground(DefaultColorsOfComponents.BACKGROUNDCOLOR.getColor());

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
            ShadowRemover.removeShadow(stepButton);
        });

        stepButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                ShadowRemover.removeShadow(stepButton);
            }
        });
    }

    private void createSurrenderButton() {
        surrenderButton = new JButton("Surrender");
        surrenderButton.setPreferredSize(new Dimension(SizesOfComponents.SURRENDER_BUTTON_WIDTH.getValue(),
                SizesOfComponents.USER_GAME_COMPONENTS_HEIGHT.getValue()));
        surrenderButton.setFont(FontCreator.makeFont(SizesOfComponents.FONT_SIZE_20.getValue()));
        surrenderButton.setBorder(new ButtonStyle( "Surrender"));
        surrenderButton.setBackground(DefaultColorsOfComponents.BACKGROUNDCOLOR.getColor());
        surrenderButton.setForeground(DefaultColorsOfComponents.BACKGROUNDCOLOR.getColor());

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
        return (Character.toString(computerCity.charAt(0))).toUpperCase() + computerCity.substring(1);
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
