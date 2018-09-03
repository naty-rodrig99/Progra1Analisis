/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaDeNegocios;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.lang.String;
/**
 *
 * @author naty9
 */
public class RandomImage {
    private int width;
    private int height;
    
    public void createRandomImage(int width, int height,String path){
        //new image dimension 
        //int widthImg = widthImg1;
        //int heightImg2 = widthImg1;
        //create buffered image object img2
        BufferedImage img = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
        //file object
        File f = null;
        //create random image pixel by pixel
        for(int y = 0; y < height;y++){
            for(int x = 0; x < width;x++){
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
            String name = "output"+ 1 +".png";
            //"C:\\Users\\naty9\\OneDrive\\Escritorio\\Pruebas Analisis\\"
            f = new File(path + name);
            ImageIO.write(img, "png", f);
        }catch(IOException e){
            System.out.println("Error:" + e);
        } 
    }
}
