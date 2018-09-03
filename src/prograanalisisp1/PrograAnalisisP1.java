
import logicaDeNegocios.Imagen;
import logicaDeNegocios.RandomImage;
import logicaDeNegocios.Operations;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.lang.String;


public class PrograAnalisisP1 {

	public static void main(String[] args) throws IOException {
            Imagen original = new Imagen();
            RandomImage random = new RandomImage();
            //Read original image
            original.readImage("C:\\Users\\naty9\\OneDrive\\Escritorio\\Pruebas Analisis\\insta.png");
            //Create first random image
            random.createRandomImage(original.getWidth(),original.getHeight(), "C:\\Users\\naty9\\OneDrive\\Escritorio\\Pruebas Analisis\\");
            original.readPixelColor(); //Leer color de pixel
            

           
        }
}

        