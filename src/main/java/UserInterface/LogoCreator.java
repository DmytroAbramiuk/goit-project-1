package UserInterface;

import javax.swing.*;
import java.awt.*;
import SizesAndColoursOfComponents.SizesOfComponents;
public class LogoCreator extends JPanel {
    public static void createCitiesLogo(JPanel panel) {
        JPanel citiesPanel = new JPanel();
        citiesPanel.setBounds(0, 0, SizesOfComponents.CITIES_LOGO_WIDTH.getValue(),
                SizesOfComponents.DEFAULT_PANEL_HEIGHT.getValue() / 5);
        citiesPanel.setLayout(new FlowLayout());
        citiesPanel.setOpaque(false);

        Font font = new Font("Arial Black", Font.BOLD, SizesOfComponents.FONT_SIZE_50.getValue());
        JLabel citiesLabel = new JLabel("CITIES");
        citiesLabel.setFont(font);

        citiesPanel.add(citiesLabel);

        panel.add(citiesPanel);
    }
}
