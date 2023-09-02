package UserInterface;

import javax.swing.*;

public class ShadowRemover {
    public static void removeShadow(JButton button){
        button.setOpaque(false);
        button.setContentAreaFilled(true);
        button.setBorderPainted(true);
        button.repaint();
    }
}
