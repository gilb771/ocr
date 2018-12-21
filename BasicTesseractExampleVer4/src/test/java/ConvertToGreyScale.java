import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

public class ConvertToGreyScale {


    public static BufferedImage convertToGreyScale(InputStream inputFile){
        BufferedImage image = null;
        try {
            image = ImageIO.read(inputFile);
            int width = image.getWidth();
            int height = image.getHeight();

            for(int i=0; i<height; i++){

                for(int j=0; j<width; j++){

                    Color c = new Color(image.getRGB(j, i));
                    int red = (int)(c.getRed() * 0.299);
                    int green = (int)(c.getGreen() * 0.587);
                    int blue = (int)(c.getBlue() *0.114);
                    Color newColor = new Color(red+green+blue,

                            red+green+blue,red+green+blue);

                    image.setRGB(j,i,newColor.getRGB());
                }
            }

            File ouptut = new File("C:\\gil.png");
            ImageIO.write(image, "png", ouptut);
        } catch (Exception e) {
            System.out.println("Error in the opencv method");
        }
        return image;
    }


}
