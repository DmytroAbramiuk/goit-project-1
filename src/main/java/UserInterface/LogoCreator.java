package UserInterface;

import javax.swing.*;
import java.awt.*;

public class LogoCreator extends JPanel {
    public static void createCitiesLogo(JPanel panel) {
        JPanel citiesPanel = new JPanel();
        citiesPanel.setBounds(0, 0, 400, SizesOfComponents.PANEL_HEIGHT / 5);
        citiesPanel.setLayout(new FlowLayout());
        citiesPanel.setOpaque(false);

        Font font = new Font("Arial Black", Font.BOLD, 50);
        JLabel citiesLabel = new JLabel("CITIES");
        citiesLabel.setFont(font);

        citiesPanel.add(citiesLabel);

        panel.add(citiesPanel);
    }
}
