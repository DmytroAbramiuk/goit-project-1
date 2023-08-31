package UserInterface;

import Player.Player;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class GamePanel extends JPanel {
    Player player;
    JPanel computerPanel;
    JPanel userPanel;
    JTextField userTextField;
    JButton stepButton;
    JLabel computerLabel;
    JLabel cityFromComputerLabel;


    public GamePanel(String username) {
        this.player = new Player(username);
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

    private void createComputerPanel(){
        computerPanel = new JPanel();
        computerPanel.setBounds(0,SizesOfComponents.PANEL_HEIGHT/2-70, 400,40);
        computerPanel.setLayout(new FlowLayout());
        computerPanel.setOpaque(false);

        Font font = new Font("Arial Black", Font.BOLD, 20);

        computerLabel = new JLabel("Computer:");
        computerLabel.setFont(font);

        cityFromComputerLabel = new JLabel("city");
        cityFromComputerLabel.setFont(font);

        computerPanel.add(computerLabel);
        computerPanel.add(cityFromComputerLabel);

        this.add(computerPanel);
    }

    private void createUserPanel(){
        userPanel = new JPanel();
        userPanel.setBounds(20,SizesOfComponents.PANEL_HEIGHT/2-30, 360,40);
        userPanel.setLayout(new GridLayout());
        userPanel.setOpaque(false);

        Font font = new Font("Arial Black", Font.BOLD, 20);

        userTextField = new JTextField("your city");
        userTextField.setFont(font);
        userTextField.setBorder(new LineBorder(Color.BLACK));

        stepButton = new JButton("Make Step");
        stepButton.setFont(font);
        stepButton.setBorder(new LineBorder(Color.BLACK));

        userPanel.add(userTextField);
        userPanel.add(stepButton);

        this.add(userPanel);
    }
}
