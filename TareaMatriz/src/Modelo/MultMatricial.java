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
public class MultMatricial {

    public ArrayList<ArrayList<Double>> matrixMultiplication(ArrayList<ArrayList<Double>> matrizA, ArrayList<ArrayList<Double>> matrizB){
        if(Utilidades.diferentSizeColARowB(matrizA,matrizB)){
            throw new NumberFormatException("Multiplicación imposible, los tamaños no coinciden.");
        }

        ArrayList<ArrayList<Double>> resultado = new ArrayList<>();
        
        int columnasA = matrizA.get(0).size();
        double acumuladorSuma = 0;
        
        for (int filasA = 0; filasA < matrizA.size(); filasA++) {
            resultado.add(new ArrayList<>());
            for (int columnasB = 0; columnasB < matrizB.get(0).size(); columnasB++) {
                for(int filasB = 0; filasB < columnasA; filasB++){
                    acumuladorSuma += (matrizA.get(filasA).get(filasB)*matrizB.get(filasB).get(columnasB));
                    System.out.println("i: " + filasA + "\tj: " + columnasB + "\tk: " + filasB);
                }
                resultado.get(filasA).add(acumuladorSuma);
                acumuladorSuma = 0;
            }
        }
        return resultado;
    }
    
}
