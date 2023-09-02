package UserInterface;

import Computer.Computer;
import Convertor.UsedWordsConvertor;
import Player.Player;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

public class EndPanel extends JPanel {
    private final static int PANEL_WIDTH = 400;
    private final static int PANEL_HEIGHT = 500;
    Player player;
    Computer computer;
    JPanel resultWordListPanel;
    JPanel bottomPanel;
    JPanel topPanel;

    public EndPanel(Player player, Computer computer) {
        this.player = player;
        this.computer = computer;
        initialize();
    }

    private void initialize() {
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        GameBackgroundCreator.createBackground(this);
        this.setLayout(null);

        createResultsLabel();
        createScoreBoardPanel();
        createResultWordListsPanel();

        this.setVisible(true);
    }

    private void createResultsLabel() {
        JLabel resultsLabel = new JLabel("Results");
        resultsLabel.setBounds(0, 0, PANEL_WIDTH, PANEL_HEIGHT / 5);
        resultsLabel.setOpaque(false);

        resultsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultsLabel.setBorder(new LineBorder(Color.BLACK));

        resultsLabel.setFont(FontCreator.makeFont(50));

        this.add(resultsLabel);
    }

    private void createScoreBoardPanel() {
        JPanel scoreboardPanel = new JPanel();
        scoreboardPanel.setBounds(0, PANEL_HEIGHT / 5, PANEL_WIDTH, 20);
        scoreboardPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        scoreboardPanel.setOpaque(false);

        String lastWord = " words";
        if(player.getScore()==1)
            lastWord=" word";

        JLabel playerResultsLabel = new JLabel(player.getUsername() + " " + player.getStatus() + " with " + player.getScore() + lastWord);
        playerResultsLabel.setFont(FontCreator.makeFont(15));

        scoreboardPanel.add(playerResultsLabel);

        this.add(scoreboardPanel);
    }

    private void createResultWordListsPanel() {
        resultWordListPanel = new JPanel();
        resultWordListPanel.setLayout(new BorderLayout());
        resultWordListPanel.setBounds(0, PANEL_HEIGHT / 5 + 20, PANEL_WIDTH, PANEL_HEIGHT - (PANEL_HEIGHT / 5 + 20));
        resultWordListPanel.setOpaque(false);

        createTopPanel();
        createBottomPanel();

        this.add(resultWordListPanel);
    }

    private void createTopPanel(){
        topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(1, 2));
        topPanel.setOpaque(false);

        createPlayerLabel();
        createComputerLabel();

        resultWordListPanel.add(topPanel, BorderLayout.NORTH);
    }

    private void createPlayerLabel(){
        JLabel playerLabel = new JLabel("Player cities");
        playerLabel.setFont(FontCreator.makeFont(15));
        playerLabel.setHorizontalAlignment(SwingConstants.CENTER);

        topPanel.add(playerLabel);
    }

    private void createComputerLabel(){
        JLabel computerLabel = new JLabel("Computer cities");
        computerLabel.setFont(FontCreator.makeFont(15));
        computerLabel.setHorizontalAlignment(SwingConstants.CENTER);

        topPanel.add(computerLabel);
    }

    private void createBottomPanel(){
        bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1, 2));

        bottomPanel.setOpaque(false);

        createPlayerCitiesLabel();
        createComputerCitiesLabel();

        resultWordListPanel.add(bottomPanel, BorderLayout.CENTER);
    }

    private void createPlayerCitiesLabel(){
        JLabel playerCitiesLabel = new JLabel(UsedWordsConvertor.convert(player.getUsedPlayerCities()));


        JScrollPane playerCitiesScrollPane = new JScrollPane(playerCitiesLabel);
        playerCitiesScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        //playerCitiesLabel.setBorder(new LineBorder(Color.BLACK));
        playerCitiesLabel.setFont(FontCreator.makeFont(15));
        playerCitiesLabel.setVerticalAlignment(SwingConstants.TOP);

        playerCitiesScrollPane.setOpaque(false);
        playerCitiesLabel.setOpaque(false);

        bottomPanel.add(playerCitiesScrollPane);
    }

    private void createComputerCitiesLabel(){
        JLabel computerCitiesLabel = new JLabel(UsedWordsConvertor.convert(computer.getUsedComputerCities()));

        JScrollPane computerCitiesScrollPane = new JScrollPane(computerCitiesLabel);
        computerCitiesScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        //computerCitiesLabel.setBorder(new LineBorder(Color.BLACK));
        computerCitiesLabel.setFont(FontCreator.makeFont(15));
        computerCitiesLabel.setVerticalAlignment(SwingConstants.TOP);

        computerCitiesScrollPane.setOpaque(false);
        computerCitiesLabel.setOpaque(false);


        bottomPanel.add(computerCitiesScrollPane);
    }
}
