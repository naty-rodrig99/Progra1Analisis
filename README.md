# Progra1Analisis


import logicaDeNegocios.Imagen;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.lang.String;


public class PrograAnalisisP1 {

	public static void main(String[] args) throws IOException {
            
            //Get the file to read
            File file = new File("C:\\Users\\naty9\\OneDrive\\Escritorio\\Pruebas Analisis\\pizza4.jpg");
            //Read it using the read method of ImageIO class
            Image image = ImageIO.read(file);
            //Get width
            int widthImg1 = image.getWidth(null);
            //Get height
            int heightImg1 = image.getHeight(null);
            //Print the data
            //System.out.println("Width:" + widthImg1 + "  Height:" + heightImg1); 
                
            for(int y = 0; y < heightImg1;y++){
                for(int x = 0; x < widthImg1;x++){
                    //Read pixel color image 1:
                    //int p = image.getRed(x,y);
                    //System.out.println(p);
                }
            }

            //new image dimension 
            int widthImg2 = widthImg1;
            int heightImg2 = widthImg1;
            //create buffered image object img2
            BufferedImage img = new BufferedImage(widthImg2,heightImg2,BufferedImage.TYPE_INT_ARGB);
            //file object
            File f = null;
            //create random image pixel by pixel
            int cont = 10;
            int numImg = 0;
            while (cont!=0){
                for(int y = 0; y < heightImg2;y++){
                    for(int x = 0; x < widthImg2;x++){
                        int a = (int)(Math.random()*256); //alpha
                        int r = (int)(Math.random()*256); //red
                        int g = (int)(Math.random()*256); //green
                        int b = (int)(Math.random()*256); //blue

                        int p = (a<<24) | (r<<16) | (g<<8) | b; //pixel
                        img.setRGB(x, y, p);
                    }
                }
                //write image2 output
                try{
                    numImg++;
                    String name = "output"+ numImg +".png";
                    f = new File("C:\\Users\\naty9\\OneDrive\\Escritorio\\Pruebas Analisis\\"+name);
                    ImageIO.write(img, "png", f);
                }catch(IOException e){
                    System.out.println("Error:" + e);
                }
                cont--;
            }
 
	}
}
