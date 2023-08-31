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

    private void createComputerLabel(){
        computerLabel = new JLabel("Computer:");
        computerLabel.setFont(FontCreator.makeFont(20));

        computerPanel.add(computerLabel);
    }

    private void createCityFromComputerLabel(){
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

    private void createUserTextField(){
        userTextField = new JTextField("your city");
        userTextField.setFont(FontCreator.makeFont(20));
        userTextField.setBorder(new LineBorder(Color.BLACK));

        userPanel.add(userTextField);
    }

    private void createStepButton(){
        stepButton = new JButton("Make Step");
        stepButton.setFont(FontCreator.makeFont(20));
        stepButton.setBorder(new LineBorder(Color.BLACK));

        eventListenerForStepButton();

        userPanel.add(stepButton);
    }

    private void eventListenerForStepButton(){
        stepButton.addActionListener(e -> {
            if(userTextField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "You should type city to continue");
            }
            else{
                processingCities();
            }
        });
    }

    private void processingCities(){
        boolean isCityAllowed;
        String playerCity = userTextField.getText().toLowerCase();
        String computerCity;

        if(playerCity.equalsIgnoreCase("здаюсь")){
            JOptionPane.showMessageDialog(this, "You Loose!");
            replacePanel();
            return;
        }

        if(ListOfCities.usedCities.isEmpty()){
            isCityAllowed = WordValidator.firstStepValidate(playerCity);
        } else {
            String currentComputerCity = computer.getCurrentCity();
            isCityAllowed = WordValidator.validate(playerCity, currentComputerCity);
        }

        if(isCityAllowed){
            player.increaseScore();
            ListOfCities.usedCities.add(playerCity);
            computerCity = computer.getNewCity(playerCity);
            if(computerCity==null){
                JOptionPane.showMessageDialog(this, "You Win!");
                replacePanel();
                return;
            }
            cityFromComputerLabel.setText(computerCity);
        } else {
            JOptionPane.showMessageDialog(this, "Your city does not exist!!!");
        }
    }


    private void replacePanel(){
        Container container = getRootPane().getContentPane();
        container.setFocusable(false);
        container.removeAll();

        EndPanel endPanel = new EndPanel(player);
        container.add(endPanel);

        endPanel.requestFocusInWindow();

        container.revalidate();
        container.repaint();
    }
}
