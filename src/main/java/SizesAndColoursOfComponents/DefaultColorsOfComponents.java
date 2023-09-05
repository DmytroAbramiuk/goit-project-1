package SizesAndColoursOfComponents;

import java.awt.*;

public enum DefaultColorsOfComponents {
    BACKGROUNDCOLOR(new Color(107, 208, 255)),
    TRANSPARENTCOLOR(new Color(0,0,0,0));
    private final Color color;


    DefaultColorsOfComponents(Color color) {
        this.color = color;
    }
    public Color getColor(){
        return this.color;
    }

}
