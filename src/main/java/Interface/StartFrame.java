package Interface;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class StartFrame extends JFrame {

    public StartFrame(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        PanelForTheStartFrame panelForTheStartFrame = new PanelForTheStartFrame();
        this.add(panelForTheStartFrame);

        this.pack();
        this.setVisible(true);
    }
}
