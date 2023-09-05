package UserInterface;

import Computer.Computer;
import Convertor.UsedWordsConvertor;
import Player.Player;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

import SizesAndColoursOfComponents.SizesOfComponents;
public class EndPanel extends JPanel {
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
        this.setPreferredSize(new Dimension(SizesOfComponents.DEFAULT_PANEL_WIDTH.getValue(),
                SizesOfComponents.DEFAULT_PANEL_HEIGHT.getValue()));
        this.setLayout(null);

        createResultsLabel();
        createScoreBoardPanel();
        createResultWordListsPanel();

        this.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (BackgroundImageCreator.createBackground() != null) {
            g.drawImage(BackgroundImageCreator.createBackground(), 0, 0, getWidth(), getHeight(), this);
        }
    }

    private void createResultsLabel() {
        JLabel resultsLabel = new JLabel("Results");
        resultsLabel.setBounds(0, 0, SizesOfComponents.DEFAULT_PANEL_WIDTH.getValue(),
                SizesOfComponents.DEFAULT_PANEL_HEIGHT.getValue() / 5);
        resultsLabel.setOpaque(false);

        resultsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultsLabel.setBorder(new LineBorder(Color.BLACK));

        resultsLabel.setFont(FontCreator.makeFont(SizesOfComponents.FONT_SIZE_50.getValue()));

        this.add(resultsLabel);
    }

    private void createScoreBoardPanel() {
        JPanel scoreboardPanel = new JPanel();
        scoreboardPanel.setBounds(0, SizesOfComponents.DEFAULT_PANEL_HEIGHT.getValue() / 5,
                SizesOfComponents.DEFAULT_PANEL_WIDTH.getValue(), 20);
        scoreboardPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        scoreboardPanel.setOpaque(false);

        String lastPart = " words";
        if (player.getScore() == 1)
            lastPart = " word";

        JLabel playerResultsLabel = new JLabel(player.getUsername()
                + " " + player.getStatus() + " with " + player.getScore() + lastPart);
        playerResultsLabel.setFont(FontCreator.makeFont(SizesOfComponents.FONT_SIZE_15.getValue()));

        scoreboardPanel.add(playerResultsLabel);

        this.add(scoreboardPanel);
    }

    private void createResultWordListsPanel() {
        resultWordListPanel = new JPanel();
        resultWordListPanel.setLayout(new BorderLayout());
        resultWordListPanel.setBounds(0, SizesOfComponents.DEFAULT_PANEL_HEIGHT.getValue() / 5 + 20,
                SizesOfComponents.DEFAULT_PANEL_WIDTH.getValue(),
                SizesOfComponents.DEFAULT_PANEL_HEIGHT.getValue() - (SizesOfComponents.DEFAULT_PANEL_HEIGHT.getValue() / 5 + 20));
        resultWordListPanel.setOpaque(false);

        createTopPanel();
        createBottomPanel();

        this.add(resultWordListPanel);
    }

    private void createTopPanel() {
        topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(1, 2));
        topPanel.setOpaque(false);

        createPlayerLabel();
        createComputerLabel();

        resultWordListPanel.add(topPanel, BorderLayout.NORTH);
    }

    private void createPlayerLabel() {
        JLabel playerLabel = new JLabel("Player cities");
        playerLabel.setFont(FontCreator.makeFont(SizesOfComponents.FONT_SIZE_15.getValue()));
        playerLabel.setHorizontalAlignment(SwingConstants.CENTER);

        topPanel.add(playerLabel);
    }

    private void createComputerLabel() {
        JLabel computerLabel = new JLabel("Computer cities");
        computerLabel.setFont(FontCreator.makeFont(SizesOfComponents.FONT_SIZE_15.getValue()));
        computerLabel.setHorizontalAlignment(SwingConstants.CENTER);

        topPanel.add(computerLabel);
    }

    private void createBottomPanel() {
        bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1, 2));

        bottomPanel.setOpaque(false);

        createPlayerCitiesLabel();
        createComputerCitiesLabel();

        resultWordListPanel.add(bottomPanel, BorderLayout.CENTER);
    }

    private void createPlayerCitiesLabel() {
        JLabel playerCitiesLabel = new JLabel(UsedWordsConvertor.convert(player.getUsedPlayerCities()));

        JScrollPane playerCitiesScrollPane = new JScrollPane(playerCitiesLabel);
        playerCitiesScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        playerCitiesLabel.setFont(FontCreator.makeFont(SizesOfComponents.FONT_SIZE_15.getValue()));
        playerCitiesLabel.setVerticalAlignment(SwingConstants.TOP);
        playerCitiesLabel.setBorder(new LineBorder(Color.BLACK));

        playerCitiesScrollPane.setOpaque(false);
        playerCitiesScrollPane.getViewport().setOpaque(false);

        bottomPanel.add(playerCitiesScrollPane);
    }

    private void createComputerCitiesLabel() {
        JLabel computerCitiesLabel = new JLabel(UsedWordsConvertor.convert(computer.getUsedComputerCities()));

        JScrollPane computerCitiesScrollPane = new JScrollPane(computerCitiesLabel);
        computerCitiesScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        computerCitiesLabel.setFont(FontCreator.makeFont(SizesOfComponents.FONT_SIZE_15.getValue()));
        computerCitiesLabel.setVerticalAlignment(SwingConstants.TOP);
        computerCitiesLabel.setBorder(new LineBorder(Color.BLACK));

        computerCitiesScrollPane.setOpaque(false);
        computerCitiesScrollPane.getViewport().setOpaque(false);

        bottomPanel.add(computerCitiesScrollPane);
    }
}
