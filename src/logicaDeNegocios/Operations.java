/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaDeNegocios;

import java.util.ArrayList;

/**
 *
 * @author naty9
 */
public class Operations {
    
    public int power(int base, int exp){
        int result = 1;
        for (int i = 1; i <= exp; i++) {
            result = result * base;
        }
        //System.out.println(result);
        return result;
    }
    
    public int squareRoot(int num){
        //Base case
        if(num == 0 || num == 1){
            return num;
        }
        int i = 1;
        int result = 1;
        while(result <= num){
            i++;
            result = i * i;
        }
        return i - 1;   
    }
    
    //Recorrer lista de todos los ARGB
    public void eucledianDistance(ArrayList<Integer> pixelA, ArrayList<Integer> pixelB){
        int opRed = pixelB.get(1) - pixelA.get(1);
        int opGreen = pixelB.get(2) - pixelA.get(2);
        int opBlue = pixelB.get(3) - pixelA.get(3);
        int sum = power(opRed,2) + power(opGreen,2) + power(opBlue,2);
        int square = squareRoot(sum);
    }
    
    //Mutacion
    
    //Cruzar
    
    //Adaptabilidad
    
}
