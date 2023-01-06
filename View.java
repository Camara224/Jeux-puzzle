package puzzle;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.awt.*;

public class View{

    public BufferedImage[] createTiles(String img, int rows, int cols) throws IOException {

        File file = new File(img); // I have lena.jpg in my working directory
        FileInputStream fis = new FileInputStream(file);
        BufferedImage image = ImageIO.read(fis); //reading the image file


        int multiple = rows * cols;

        int multipleWidth = image.getWidth() / cols; // determines the multiple width and height
        int multipleHeight = image.getHeight() / rows;
        int count = 0;
        BufferedImage imgs [] = new BufferedImage[multiple]; //Image array to hold image chunks
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                //Initialize the image array with image multiple
                imgs[count] = new BufferedImage(multipleWidth, multipleHeight, image.getType());

                // draws the image multiple
                Graphics2D gr = imgs[count++].createGraphics();
                gr.drawImage(image, 0, 0, multipleWidth, multipleHeight, multipleWidth * y, multipleHeight * x, multipleWidth * y + multipleWidth, multipleHeight * x + multipleHeight, null);
                gr.dispose();
            }
        }

	return imgs;
    }
}