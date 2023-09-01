package UserInterface;

import Computer.Computer;
import Convertor.UsedWordsConvertor;
import Player.Player;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.List;

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

        JLabel playerUsernameLabel = new JLabel(player.getUsername() + " " + player.getStatus() + " with " + player.getScore() + lastWord);
        playerUsernameLabel.setFont(FontCreator.makeFont(15));

        scoreboardPanel.add(playerUsernameLabel);

        this.add(scoreboardPanel);
    }

    private void createResultWordListsPanel() {
        resultWordListPanel = new JPanel();
        resultWordListPanel.setLayout(new BorderLayout());
        resultWordListPanel.setBounds(0, PANEL_HEIGHT / 5 + 20, PANEL_WIDTH, PANEL_HEIGHT - (PANEL_HEIGHT / 5 + 20));

        createTopPanel();
        createBottomPanel();

        this.add(resultWordListPanel);
    }

    private void createTopPanel(){
        topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(1, 2));

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

        createPlayerCitiesLabel();
        createComputerCitiesLabel();

        resultWordListPanel.add(bottomPanel, BorderLayout.CENTER);
    }

    private void createPlayerCitiesLabel(){
        JLabel playerWordsLabel = new JLabel(UsedWordsConvertor.convert(player.getUsedPlayerCities()));

        JScrollPane playerWordsScrollPane = new JScrollPane(playerWordsLabel);
        playerWordsScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        playerWordsLabel.setBorder(new LineBorder(Color.BLACK));
        playerWordsLabel.setFont(FontCreator.makeFont(15));
        playerWordsLabel.setVerticalAlignment(SwingConstants.TOP);

        bottomPanel.add(playerWordsScrollPane);
    }

    private void createComputerCitiesLabel(){
        JLabel computerWordsLabel = new JLabel(UsedWordsConvertor.convert(computer.getUsedComputerCities()));

        JScrollPane computerWordsScrollPane = new JScrollPane(computerWordsLabel);
        computerWordsScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        computerWordsLabel.setBorder(new LineBorder(Color.BLACK));
        computerWordsLabel.setFont(FontCreator.makeFont(15));
        computerWordsLabel.setVerticalAlignment(SwingConstants.TOP);

        bottomPanel.add(computerWordsScrollPane);
    }
}
