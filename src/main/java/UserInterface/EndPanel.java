package UserInterface;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class EndPanel extends JPanel {
    private final static int PANEL_WIDTH = 400;
    private final static int PANEL_HEIGHT = 500;

    public EndPanel() {
        initialize();
    }

    private void initialize() {
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setLayout(null);
        this.setBackground(new Color(229, 171, 102, 186));

        createResultsLabel();
        createScoreBoardPanel();

        this.setVisible(true);
    }

    private void createResultsLabel(){
        JLabel resultsLabel = new JLabel("Results");
        resultsLabel.setBounds(0,0,PANEL_WIDTH, PANEL_HEIGHT/5);
        resultsLabel.setOpaque(false);

        resultsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultsLabel.setBorder(new LineBorder(Color.BLACK));

        Font font = new Font("Arial Black", Font.BOLD, 50);
        resultsLabel.setFont(font);

        this.add(resultsLabel);
    }

    private void createScoreBoardPanel(){
        JPanel scoreboardPanel = new JPanel();
        scoreboardPanel.setBounds(0,PANEL_HEIGHT/5,PANEL_WIDTH,PANEL_HEIGHT-PANEL_HEIGHT/5);
        scoreboardPanel.setLayout(new GridLayout(2,1));
        scoreboardPanel.setOpaque(false);

        JLabel playerUsernameLabel = new JLabel("username");
        playerUsernameLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        playerUsernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        playerUsernameLabel.setFont(new Font("Arial Black", Font.BOLD, 25));

        JLabel playerScoreLabel = new JLabel("100 words");
        playerScoreLabel.setVerticalAlignment(SwingConstants.TOP);
        playerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        playerScoreLabel.setFont(new Font("Arial Black", Font.BOLD, 25));

        scoreboardPanel.add(playerUsernameLabel);
        scoreboardPanel.add(playerScoreLabel);

        this.add(scoreboardPanel);
    }
}
