/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaDeNegocios;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author naty9
 */
public class DNA {
    public int adaptabilidad = 0;
    public float adaptabilidadNormailzada = 0; 
    public BufferedImage genes;
    public static int totalScore = 0;
    public static int cont = 0;
    
    public DNA(BufferedImage img){
        genes = new BufferedImage(img.getWidth(),img.getHeight(),BufferedImage.TYPE_INT_ARGB);
        File f = null;
        for(int y = 0; y < img.getHeight();y++){
            for(int x = 0; x < img.getWidth();x++){
                int a = 255; //alpha
                int r = (int)(Math.random()*256); //red
                int g = (int)(Math.random()*256); //green
                int b = (int)(Math.random()*256); //blue

                int p = (a<<24) | (r<<16) | (g<<8) | b; //pixel
                genes.setRGB(x, y, p);
            }
        }
        try{
            cont++;
            String name = "output"+ cont +".png";
            f = new File("C:\\Users\\naty9\\OneDrive\\Escritorio\\Pruebas Analisis\\" + name);
            ImageIO.write(genes, "png", f);
        }catch(IOException e){
            System.out.println("Error:" + e);
        } 
    }
    
    public DNA(DNA padre, DNA madre){
        genes = new BufferedImage(padre.genes.getWidth(),padre.genes.getHeight(), BufferedImage.TYPE_INT_ARGB);
        for(int y = 0; y < padre.genes.getHeight(); y++){
            for(int x = 0; x < padre.genes.getWidth(); x++){
                int rgb = (x + y)%2 == 0? padre.genes.getRGB(x, y): madre.genes.getRGB(x, y);
                genes.setRGB(x, y, rgb);
            }
        }
    }
      
    public void myDistance(BufferedImage image){
        for(int i = 0; i < image.getWidth(); i++){
            for(int j = 0; j < image.getHeight(); j++){
                int blueImg = image.getRGB(j, i) & 0xff;
                int greenImg = (image.getRGB(j, i) & 0xff00) >> 8;
                int redImg = (image.getRGB(j, i)& 0xff0000) >> 16;
                
                int blueGen = genes.getRGB(j, i) & 0xff;
                int greenGen = (genes.getRGB(j, i) & 0xff00) >> 8;
                int redGen = (genes.getRGB(j, i)& 0xff0000) >> 16;
                
                if((blueImg == blueGen) && (greenImg == greenGen) && (redImg == redGen)){
                    adaptabilidad++;
                }
            }
        }
        adaptabilidad = (int) Math.pow(adaptabilidad, 2);
    }
    
    public void EuclideanFitness(BufferedImage image)
    {
        int sumatoria = 0;
        for(int i = 0; i < image.getHeight(); i++)
        {
            for(int j = 0; j < image.getWidth(); j++)
            {
                int colorGen = this.genes.getRGB(i,j);
                int redGen = (colorGen & 0xff0000) >> 16;
                int greenGen = (colorGen & 0xff00) >> 8;
                int blueGen = (colorGen & 0xff);
                
                int colorImg = image.getRGB(i,j);
                int redImg = (colorImg & 0xff0000) >> 16;
                int greenImg = (colorImg & 0xff00) >> 8;
                int blueImg = (colorImg & 0xff);
                
                int restaRed = Math.abs(redImg - redGen);
                int restaGreen = Math.abs(greenImg - greenGen);
                int restaBlue = Math.abs(blueImg - blueGen);
                
                int cuadradoRojo = (int) Math.pow(restaRed, 2);
                int cuadradoVerde = (int) Math.pow(restaGreen, 2);
                int cuadradoAzul = (int) Math.pow(restaBlue, 2);
                
                int sumaFinal = cuadradoRojo + cuadradoVerde + cuadradoAzul;
                sumatoria += sumaFinal;
            }
        }
        this.adaptabilidad = (int)Math.sqrt(sumatoria);
    }
    
    public void ManhattanDistance(BufferedImage image)
    {
        int sumatoria = 0;
        for(int i = 0; i < image.getHeight(); i++)
        {
            for(int j = 0; j < image.getWidth(); j++)
            {
                int colorIndividuo = this.genes.getRGB(i,j);
                int rojoIndividuo = (colorIndividuo & 0xff0000) >> 16;
                int verdeIndividuo = (colorIndividuo & 0xff00) >> 8;
                int azulIndividuo = (colorIndividuo & 0xff);
                
                int colorImg = image.getRGB(i,j);
                int rojoImg = (colorImg & 0xff0000) >> 16;
                int verdeImg = (colorImg & 0xff00) >> 8;
                int azulImg = (colorImg & 0xff);
                
                int restaRojo = Math.abs(rojoImg - rojoIndividuo);
                int restaVerde = Math.abs(verdeImg - verdeIndividuo);
                int restaAzul = Math.abs(azulImg - azulIndividuo);
                
                int sumaFinal = restaRojo + restaVerde + restaAzul;
                sumatoria += sumaFinal;
            }
        }
        this.adaptabilidad = (int)Math.sqrt(sumatoria);
    }
    
    public void mutar(int probabilidadMutar){
        for(int i = 0; i < this.genes.getHeight(); i++){
            for(int j = 0; j < this.genes.getWidth(); j++){
                int numRandom = (int) (Math.random() * 100) + 1;
                if(numRandom < probabilidadMutar){
                    int a = 255; //alpha
                    int r = (int)(Math.random()*256); //red
                    int g = (int)(Math.random()*256); //green
                    int b = (int)(Math.random()*256); //blue

                    int p = (a<<24) | (r<<16) | (g<<8) | b; //pixel
                    genes.setRGB(i, j, p);
                }
            }    
        }
    }
    
    public DNA crossOver(DNA padre){
        return new DNA(padre, this);
    }
    
}
