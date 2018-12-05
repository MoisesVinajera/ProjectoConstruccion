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
public class Trasponedor {
    public ArrayList<ArrayList<Double>> trasposeMatrix(ArrayList<ArrayList<Double>> matrix){
        ArrayList<ArrayList<Double>> resultado = new ArrayList<>();
        int grado = matrix.size();
        
        for (int i = 0; i < grado; i++) {
            resultado.add(new ArrayList<Double>());
            for (int j = 0; j < matrix.get(0).size(); j++) {  
                resultado.get(i).add(matrix.get(j).get(i));
            }
        }
        
        for (int i = 0; i < grado; i++) {
            matrix.set(i, resultado.get(i));
        }
        
        return matrix;
    }
}
