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
import java.awt.Color;
import java.awt.List;
import java.lang.reflect.Array;
import java.util.ArrayList;


public class Imagen {
    private File file;
    private BufferedImage image;
    private int width;
    private int height;
    private ArrayList<Integer> ARGB = new ArrayList<Integer>(); ;
    private ArrayList<ArrayList> pixelColor = new ArrayList<ArrayList>(); ;
    
    public void readImage(String path)throws IOException{
        //Get the file to read
        //"C:\\Users\\naty9\\OneDrive\\Escritorio\\Pruebas Analisis\\pizza4.jpg"
        file = new File(path);
        //Read it using the read method of ImageIO class
        image = ImageIO.read(file);
    }
    //Get width
    public int getWidth(){
        width = image.getWidth(null);
        return width;
    }
    
    //Get height
    public int getHeight(){
        height = image.getHeight(null);
        return height;
    }
    
    //print pixel color
    public void printPixelARGB(int pixel) {
        boolean empty = ARGB.isEmpty();
        if (empty != true) {
            ARGB.clear();
        }
        int alpha = (pixel >> 24) & 0xff;
        int red = (pixel >> 16) & 0xff;
        int green = (pixel >> 8) & 0xff;
        int blue = (pixel) & 0xff;
        //Add to arrayList ARGB
        ARGB.add(alpha);
        ARGB.add(red);
        ARGB.add(green);
        ARGB.add(blue);
        //Add to arrayList pixelColor
        pixelColor.add(ARGB);
        //System.out.println("ARGB: " + alpha + ", " + red + ", " + green + ", " + blue);
        //Go through arrayList
        for (int i = 0; i < pixelColor.size(); i++) {
            System.out.println(pixelColor.get(i));
            break;
        }
    }
    
    //reads pixel color
    public void readPixelColor() {
        System.out.println("width, height: " + width + ", " + height);
        for (int i = 0; i < height; i++) {
          for (int j = 0; j < width; j++) {
            System.out.println("x,y: " + j + ", " + i);
            int pix = image.getRGB(j, i);
            printPixelARGB(pix);
            System.out.println("");
          }
        }
      }
    

    
}
