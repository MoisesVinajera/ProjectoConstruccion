/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Sumador {
    public ArrayList<ArrayList<Double>> sumarMatrices(ArrayList<ArrayList<Double>> matrixA, ArrayList<ArrayList<Double>> matrixB){
        //usando la metrica para medir el flujo se sabe que para que d tenga un valor de 0 o 1 debe estar estructurado, la de solo cuenta a los ciclos While e If
        //entonces aplicando la metrica  d(F(fj, ... ,F,)) = min(d(F),d(fj), ... ,d(F,))
        //se obtiene min(1,1,1)
        
        //usando la metrica se obtienen los siguientes numeros de aristas 1+2+1+1+1+2+1-n
        if(matrixA.size() != matrixB.size() || matrixA.get(0).size() != matrixB.get(0).size()){
            throw new NumberFormatException("Las matrices son de distinto tamaño.");
        }
        
        ArrayList<ArrayList<Double>> result = new ArrayList<>();
        for (int i = 0; i < matrixA.size(); i++) {
            result.add(Sumador.addRows(matrixA.get(i), matrixB.get(i)));
        }
        
        return result;
    }
    
    public static ArrayList<Double> addRows(ArrayList<Double> row, ArrayList<Double> adding){
        if(row.size() != adding.size()){
            throw new NumberFormatException("Addition with different size of array.");
        }
        
        ArrayList<Double> result = new ArrayList<>();
        
        for (int i = 0; i < row.size(); i++) {
            result.add(row.get(i)+adding.get(i));
        }
        
        return result;
    }
    
    public static ArrayList<Double> subRows(ArrayList<Double> row, ArrayList<Double> substracting){
        if(row.size() != substracting.size()){
            throw new NumberFormatException("Addition with different size of array.");
        }
        
        ArrayList<Double> result = new ArrayList<>();
        
        for (int i = 0; i < row.size(); i++) {
            result.add(row.get(i)-substracting.get(i));
        }
        
        return result;
    }
}

