/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaDeNegocios;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author naty9
 */
public class Population {
    public int poblacionInicial;
    public int probabilidadCruce=20;
    public int porcentajeGenesAMutar=20;
    private static BufferedImage image;
    private ArrayList<DNA> population;
    
    public Population(BufferedImage img, int poblacionInicial){
        image = img;
        population = new ArrayList<DNA>();
        for(int i = 0; i < poblacionInicial; i++){
            population.add(new DNA(img));
        }
    }
    
    public void calcularFitness(){
        for(DNA dna: population){
            dna.myDistance(image);
        }
    }
    
    public void calcularEuclediana(){
        for(DNA dna: population){
            dna.EuclideanFitness(image);
        }
    }
    
    public void calcularManhattan(){
        for(DNA dna: population){
            dna.ManhattanDistance(image);
        }
    }
    
    public void normalizeFitness(){
        DNA.totalScore = 0;
        for(DNA dna: population){
            DNA.totalScore += dna.adaptabilidad;
        }
        for(DNA dna: population){
            float f = dna.adaptabilidad;
            float t = DNA.totalScore;
            dna.adaptabilidadNormailzada += dna.adaptabilidad/DNA.totalScore;
        }
    }
    
    public void mutarPoblacion(){
        for(DNA dna: population){
            dna.mutar(probabilidadCruce);
        }
    }
    
    public DNA pickParent(){
        float numRandom = (float)(Math.random());
        int index = 0;
        while(numRandom > 0){
            numRandom -= population.get(index).adaptabilidadNormailzada;
            index ++;
        }
        return population.get(--index);
    }
    
    public void crossOver(){
        ArrayList<DNA> newGeneration = new ArrayList<DNA>();
        //this.normalizeFitness();
        int porcentaje = (population.size() * probabilidadCruce)/100;
        for(int i = 0; i < porcentaje; i++){
            DNA madre = this.pickParent();
            DNA padre = this.pickParent();
            if(padre != madre){
                DNA hijo =  padre.crossOver(madre);
                newGeneration.add(hijo);
                continue;
            }
            i --;
        }
        while(newGeneration.size() < population.size()){
            newGeneration.add(population.get((int) Math.random() * population.size()));
        }
        population = newGeneration;
        this.mutarPoblacion();
        this.calcularEuclediana();
        DNA.totalScore = 0;
        
    }
    
 
}
