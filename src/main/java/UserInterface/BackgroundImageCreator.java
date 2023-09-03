package UserInterface;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BackgroundImageCreator {
    public static BufferedImage createBackground(){
        try {
            return ImageIO.read(new File("src/main/java/Files/background.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
