package Interface;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class GamePanel extends JPanel {
    private final static int PANEL_WIDTH = 400;
    private final static int PANEL_HEIGHT = 500;
    private final static int CITIES_LABEL_HEIGHT = 80;
    private final static int CITIES_LABEL_WIDTH = 200;


    public GamePanel() {
        initialize();
    }

    private void initialize() {
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setLayout(null);
        this.setBackground(new Color(229, 171, 102, 186));

        createCitiesLabel();
        createComputerPanel();
        createUserPanel();

        this.setVisible(true);
    }

    private void createCitiesLabel() {
        Font font = new Font("Arial Black", Font.BOLD, 50);
        JLabel citiesLabel = new JLabel("CITIES");
        citiesLabel.setFont(font);

        citiesLabel.setHorizontalAlignment(SwingConstants.CENTER);


        citiesLabel.setBounds((PANEL_WIDTH / 2) - (CITIES_LABEL_WIDTH / 2),
                10,
                CITIES_LABEL_WIDTH,
                CITIES_LABEL_HEIGHT);

        this.add(citiesLabel);
    }

    private void createComputerPanel(){
        JPanel computerPanel = new JPanel();
        computerPanel.setBounds(0,PANEL_HEIGHT/2-70, 400,40);
        computerPanel.setLayout(new FlowLayout());
        computerPanel.setBackground(new Color(229, 171, 102, 158));

        Font font = new Font("Arial Black", Font.BOLD, 20);

        JLabel computerLabel = new JLabel("Computer:");
        computerLabel.setFont(font);
        JLabel cityFromComputerLabel = new JLabel("city");
        cityFromComputerLabel.setFont(font);

        computerPanel.add(computerLabel);
        computerPanel.add(cityFromComputerLabel);

        this.add(computerPanel);
    }

    private void createUserPanel(){
        JPanel userPanel = new JPanel();
        userPanel.setBounds(20,PANEL_HEIGHT/2-30, 360,40);
        userPanel.setLayout(new GridLayout());

        Font font = new Font("Arial Black", Font.BOLD, 20);

        JTextField userTextField = new JTextField("your city");
        userTextField.setFont(font);
        userTextField.setBorder(new LineBorder(Color.BLACK));
        userTextField.setBackground(new Color(229, 171, 102, 158));

        JButton stepButton = new JButton("Make Step");
        stepButton.setFont(font);
        stepButton.setBorder(new LineBorder(Color.BLACK));
        stepButton.setBackground(new Color(229, 171, 102, 158));

        userPanel.add(userTextField);
        userPanel.add(stepButton);

        this.add(userPanel);
    }
}
