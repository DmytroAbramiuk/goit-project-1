package UserInterface;

import javax.swing.border.Border;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class ButtonStyle implements Border {
    private final int arc = 50;
    private final String buttonText;

    public ButtonStyle( String buttonText) {
        this.buttonText = buttonText;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(Color.BLACK);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.draw(new RoundRectangle2D.Double(x, y, width - 1, height - 1, arc, arc));
        g2d.fill(new RoundRectangle2D.Double(x, y, width - 1, height - 1, arc, arc));
        g2d.setColor(c.getForeground());

        int fontSize = 20;
        g2d.setFont(FontCreator.makeFont(fontSize));
        g2d.drawString(buttonText, x + (width - calculateX(g2d)) / 2, y + height / 2 + 7);
        g2d.dispose();
    }

    private int calculateX(Graphics g) {
        FontMetrics fontMetrics = g.getFontMetrics();

        return fontMetrics.stringWidth(buttonText);
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(arc, arc, arc, arc);
    }

    @Override
    public boolean isBorderOpaque() {
        return false;
    }
}
