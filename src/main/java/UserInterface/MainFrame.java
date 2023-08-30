package UserInterface;

import javax.swing.*;

public class MainFrame extends JFrame {

    public MainFrame(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        StartPanel startPanel = new StartPanel();
        this.add(startPanel);
//        GamePanel gamePanel = new GamePanel();
//        this.add(gamePanel);
//        EndPanel endPanel = new EndPanel();
//        this.add(endPanel);

        this.pack();
        this.setVisible(true);
    }
}
