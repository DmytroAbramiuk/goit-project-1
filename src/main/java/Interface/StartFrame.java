package Interface;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class StartFrame extends JFrame {

    private final static int WINDOW_WIDTH = 400;
    private final static int WINDOW_HEIGHT = 500;
    private final static int START_BUTTON_HEIGHT = 35;
    private final static int START_BUTTON_WIDTH = 130;
    private final static int CITIES_LABEL_HEIGHT = 80;
    private final static int CITIES_LABEL_WIDTH = 200;

    public StartFrame(){
        this.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        createStartButton();
        createCitiesLabel();

        this.setVisible(true);
    }

    public void createCitiesLabel(){
        Font font = new Font("Arial Black", Font.BOLD, 20);
        JLabel citiesLabel = new JLabel("CITIES");
        citiesLabel.setBorder(new LineBorder(Color.BLACK));
        citiesLabel.setFont(font);

        citiesLabel.setBounds((WINDOW_WIDTH/2)-(CITIES_LABEL_WIDTH/2), 10, CITIES_LABEL_WIDTH, CITIES_LABEL_HEIGHT);
        citiesLabel.setHorizontalAlignment(SwingConstants.CENTER);

        this.add(citiesLabel);
    }

    public void createStartButton(){
        JButton startButton = new JButton("START GAME");
        startButton.setBounds((WINDOW_WIDTH/2)-(START_BUTTON_WIDTH/2), (WINDOW_HEIGHT/2)-(START_BUTTON_HEIGHT/2), START_BUTTON_WIDTH, START_BUTTON_HEIGHT);

        startButton.setBorder(new LineBorder(Color.BLACK));
        startButton.setBackground(Color.lightGray);

        this.add(startButton);
    }
}
