package graphics;

import java.awt.image.*;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

public class GraphicsFactory {
    protected BufferedImage spriteSheet;

    public GraphicsFactory(){
        importImg();
    }

    private void importImg(){
        InputStream iS = GraphicsFactory.class.getClassLoader().getResourceAsStream(Paths.get("res/tileset.png").toString());

        try {
            spriteSheet = ImageIO.read(iS);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}   
