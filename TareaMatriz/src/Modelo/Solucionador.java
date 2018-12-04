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
public class Solucionador {
    public ArrayList<ArrayList<Double>> solucionar(ArrayList<ArrayList<Double>> matrix){
        ArrayList<ArrayList<Double>> copia = new ArrayList<>();
        
        //Inicializando copia.
        for (int i = 0; i < matrix.size(); i++) {
            copia.add(new ArrayList<>());
            for (int j = 0; j < matrix.get(i).size() - 1; j++) {
                copia.get(i).add(matrix.get(i).get(j));
            }
        }
        
        //Se evalúa si el sistema tiene solución.
        if(copia.size()!= copia.get(0).size()){
            System.out.println(copia.size());
            System.out.println(copia.get(0).size());
            throw new NumberFormatException("La matriz de incógnitas no es cuadrada. "
                    + "El sistema no tiene solución.");
        }
        
        Determinante det = new Determinante();
        if(det.determinante(copia) == 0){
            throw new NumberFormatException("La matriz no tiene inversa. "
                    + "El sistema no tiene solución.");
        }
        
        //Se hallan las soluciones.
        int grado = matrix.size();
        
        for (int i = 0; i < grado; i++) {
            for (int j = 0; j < grado; j++) {
                //Normalización
                double pivote = matrix.get(i).get(i);
                matrix.set(i, MultEscalar.multiplyRow(matrix.get(i), 1/pivote));
                
                //Resta de filas
                for (int k = 0; k < grado; k++) {
                    if(k!=i){
                        ArrayList<Double> auxRow;
                        auxRow = MultEscalar.multiplyRow(matrix.get(i), matrix.get(k).get(i));
                        matrix.set(k, Sumador.subRows(matrix.get(k), auxRow));
                    }
                }
            }
        }
        
        return matrix;
    }
    
    // al aplicar la metrica se obtiene que ((2+2+2)+(0+0))=6
    
}
